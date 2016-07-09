package main.com.njupt.kb.dao;

import java.util.List;

import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;

public interface FileDao {

	/**
	 * 插入一条文件记录
	 * @param file 文件
	 * @return 数字 0为插入失败,1为插入成功
	 */
	public int add(File file);
	
	/**
	 * 产出一个文件记录
	 * @param file
	 * @return
	 */
	public int delete(File file);
	
	/**
	 * 查询单个文件
	 * @param id
	 * @return
	 */
	public File findFile(int id);
	
	/**
	 * 分页查询目录下的全部文件
	 * @param page
	 * @param category
	 * @return
	 */
	public PageModel findFiles(PageModel page,int cid);
	
	/**
	 * 查询用户某一类文件
	 * @param userID
	 * @param keyword
	 * @return
	 */
	public PageModel findFilesByType(int userID,PageModel pageModel);
	
	/**
	 * 
	 * @param userID
	 * @param pageModel
	 * @return
	 */
	public PageModel findFileByKeyWord(int userID,PageModel pageModel);
	
	/**
	 * 将文件设为常用
	 * @param fileID
	 * @return
	 */
	public int setCommonUse(int fileID);
	
	/**
	 * 取消常用
	 * @param fileID
	 * @return
	 */
	public int cancelCommonUse(int fileID);
	

	/**
	 * 查询用户常用文件
	 * @param uid
	 * @param pageModel
	 * @return
	 */
	public PageModel findCommonUseFile(int uid,PageModel pageModel);
	

	

}
