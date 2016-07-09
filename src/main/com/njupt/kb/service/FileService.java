package main.com.njupt.kb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import main.com.njupt.kb.domain.AssociateFile;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;
import main.com.njupt.kb.dto.AssociationInfo;

public interface FileService {
	

	/**
	 * 上传文件
	 * @param file
	 * @param categoryID
	 */
	public void uploadFile(MultipartFile file,int categoryID,int userID,HttpServletRequest httpServletRequest);
	

	/**
	 * 查询单个文件
	 * @param fileID
	 * @return
	 */
	public File findFile(int fileID);
	
	/**
	 * 查询某一目录下的文件
	 * @param CategoryId
	 * @param pageModel
	 * @return
	 */
	public PageModel queryFile(int categoryId,PageModel pageModel);
	
	/**
	 * 查询用户某一类文件
	 * @param userID
	 * @param pageModel
	 * @return
	 */
	public PageModel findFileByType(int userID,PageModel pageModel);
	
	/**
	 * 根据关键字查询用户文件
	 * @param userId
	 * @param pageModel
	 * @return
	 */
	public PageModel findFileByKeyword(int userID,PageModel pageModel);

	/**
	 * 标记为常用文件
	 * @param fileID
	 * @return
	 */
	public File setCommonUse(int fileID);
	
	
	/**
	 * 取消标记常用文件
	 * @param fileID
	 * @return
	 */
	public File cancelCommonUse(int fileID);
	
	/**
	 * 添加文件关联
	 * @param associationInfo
	 * @return
	 */
	public int createAssociation(AssociationInfo associationInfo);

	/**
	 * 删除文件关联信息
	 * @param fid
	 * @return
	 */
	public int deleteAssociation(int fid);
	
	/**
	 * 查询关联文件
	 * @param fid
	 * @param pageModel
	 * @return
	 */
	public PageModel findAssociateFiles(int fid,PageModel pageModel);
	
	/**
	 * 查找常用文件
	 * @param userID
	 * @param pageModel
	 * @return
	 */
	public PageModel findCommonUseFile(int userID, PageModel pageModel);
}
