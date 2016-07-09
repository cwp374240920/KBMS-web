package main.com.njupt.kb.util;

import java.io.File;

import org.apache.catalina.Server;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;


public class FileUtil {
	
	static String img="jpg|JPG|png|PNG|gif|GIF|jpeg|JPEG|bmp|BMP";
	static String video="mp4|MP4|avi|AVI|rmvb|RMVB|ogg|OGG|webm|WEBM|WebM";
	static String doc="doc|DOC|pdf|PDF|xls|XLS|html|HTML|docx";
	static String audio="mp3|MP3|wav|WAV|ogg|OGG";

	/**
	 * 复制文件
	 * @param file	文件
	 * @param path	存储路径
	 * @param fileName 文件名字
	 */
	public static void CopyFile(MultipartFile file,String path,String fileName)
	{
		Logger logger=Logger.getLogger(Server.class);
		File targetFile = new File(path, fileName); 
        if(!targetFile.exists()){
        	logger.info("创建文件目录:"+path);
            targetFile.mkdirs();
            logger.info("创建文件目录成功!");
            
        }  
   
        try {
        	logger.info("开始复制文件到目录:"+path+fileName);
            file.transferTo(targetFile);
            logger.info("复制成功");
        } catch (Exception e) { 
        	logger.info("复制失败,可能是目录不存在!");
            e.printStackTrace();  
        }  	
	}
	
	/**
	 * 文件类型判断
	 * @param suffix
	 * @return
	 */
	public static String FileType(String suffix){
		if(suffix.matches(img))
			return "图片";
		if(suffix.matches(doc))
			return "文本";
		if(suffix.matches(video))
			return "视频";
		if(suffix.matches(audio))
			return "音频";
		return "其他";
	}
	
	/**
	 * 文件转换,支持office文档转pdf
	 * @param sourceFile 源文件
	 * @param targetFile 目标文件
	 */
	public static File convertToPDF(String sourceFile, String targetFile) {
		File inputFile = new File(sourceFile);
		File outputFile = new File(targetFile);
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
		Process pro = null;
		try {
			connection.connect();
			DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
			converter.convert(inputFile, outputFile);
			return outputFile;
		} catch (Exception e) {	
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (connection != null) {
					connection.disconnect();
					connection = null;
				}
				if(pro!=null){
					pro.destroy();//销毁线程
					pro=null;
				}
			} catch (Exception e) {
			}
		}
	}
}
