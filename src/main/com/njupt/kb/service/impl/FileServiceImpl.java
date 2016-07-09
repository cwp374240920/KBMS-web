package main.com.njupt.kb.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import main.com.njupt.kb.dao.AssociationDao;
import main.com.njupt.kb.dao.CategoryDao;
import main.com.njupt.kb.dao.FileDao;
import main.com.njupt.kb.dao.UserDao;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;
import main.com.njupt.kb.dto.AssociationInfo;
import main.com.njupt.kb.service.FileService;
import main.com.njupt.kb.util.FileUtil;
import main.com.njupt.kb.util.Random;

@Service(value = "fileService")
public class FileServiceImpl implements FileService {
 
	@Resource(name = "userDao")
	private UserDao userDao;

	@Resource(name = "fileDao")
	private FileDao fileDao;

	@Resource(name = "categoryDao")
	private CategoryDao categoryDao;
	
	@Resource(name="associationDao")
	private AssociationDao associationDao;

	@Override
	public void uploadFile(MultipartFile file, int categoryID, int userID, HttpServletRequest httpServletRequest) {
		String uuid = Random.generateName();
		// 文件原名字
		String originName = file.getOriginalFilename();
		String[] part = originName.split("\\.");

		// 文件新生成的名字
		String suffix = part[part.length - 1];
		String type= FileUtil.FileType(suffix);
		String newName = uuid + "." + suffix;
		String p1 = httpServletRequest.getSession().getServletContext().getRealPath("\\");
		System.out.println("p1 is----->" + p1);
		String path = p1 + "..\\file" + "\\" + userID + "\\" + categoryID + "\\";
		String pathForSQL = "/file" + "/" + userID + "/" + categoryID + "/" + newName;
		String docRealPath="";
		String docPath="";
		
		//拷贝文件
		FileUtil.CopyFile(file, path, newName);
		
		//如果是文本进行转换
		if(type.equals("文本")){
			if(!suffix.equals("txt")){
				docRealPath=p1 + "..\\docfile" + "\\" + userID + "\\" + categoryID + "\\"+uuid+".pdf";
				docPath="/docfile" + "/" + userID + "/" + categoryID + "/" + uuid+".pdf";
				FileUtil.convertToPDF(path+newName, docRealPath);
			}
			if(suffix.equals("txt")){
				docPath=pathForSQL;
			}
			
		}

		
		File f = new File();
		Category category = new Category();
		category.setId(categoryID);

		f.setNewName(newName);
		f.setOriginalName(file.getOriginalFilename());
		f.setPath(pathForSQL);
		f.setCategory(category);
		f.setType(type);
		f.setDocPath(docPath);

		

		fileDao.add(f);

	}

	@Override
	public File findFile(int fileID) {

		if (fileID <= 0)
			return null;

		return fileDao.findFile(fileID);
	}

	@Override
	public PageModel queryFile(int categoryId, PageModel pageModel) {
		// TODO Auto-generated method stub
		return fileDao.findFiles(pageModel, categoryId);
	}

	@Override
	public PageModel findFileByType(int userID, PageModel pageModel) {
		// TODO Auto-generated method stub
		if (userID <= 0)
			return null;
		return fileDao.findFilesByType(userID, pageModel);

	}

	@Override
	public PageModel findFileByKeyword(int userID, PageModel pageModel) {
		// TODO Auto-generated method stub
		if (userID <= 0)
			return null;
		return fileDao.findFileByKeyWord(userID, pageModel);
	}

	@Override
	public File setCommonUse(int fileID) {
		fileDao.setCommonUse(fileID);
		return fileDao.findFile(fileID);
	}

	@Override
	public File cancelCommonUse(int fileID) {
		
		fileDao.cancelCommonUse(fileID);
		return fileDao.findFile(fileID);
	}


	@Override
	public int deleteAssociation(int fid) {
		// TODO Auto-generated method stub
		if(fid<=0)
			return 0;
		return 1;
	}

	@Override
	public int createAssociation(AssociationInfo a) {
		// TODO Auto-generated method stub
		
		int [] fileIDList=a.getFileID();
		String info=a.getInfo();
		
		if(fileIDList.length<=0)
			return 0;
		String key=Random.generateName();
		
		int result=0;
		for(int i=0;i<fileIDList.length;i++)
		{
			result+=associationDao.createAssociation(key, info, fileIDList[i]);
		}
		return result;
	}

	@Override
	public PageModel findAssociateFiles(int fid, PageModel pageModel) {
		// TODO Auto-generated method stub
		if(fid<=0)
			return null;
		return associationDao.findAssociation(fid, pageModel);
	}

	@Override
	public PageModel findCommonUseFile(int userID, PageModel pageModel) {
		// TODO Auto-generated method stub
		return fileDao.findCommonUseFile(userID, pageModel);
	}


	
}
