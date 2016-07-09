package main.com.njupt.kb.dao;

import main.com.njupt.kb.domain.PageModel;

public interface AssociationDao{
	
	/**
	 * 查询用户关联文件
	 * @param fileID
	 * @return
	 */
	public PageModel findAssociation(int fileID,PageModel pageModel);
	
	/**
	 * 生成文件关联
	 * @param key 	统一的uuid
	 * @param info 文件关联信息
	 * @param fid	相关联的文件id
	 * @return	修改的记录数
	 */
	public int createAssociation(String key, String info, int fid);

	/**
	 * 删除文件关联
	 * @param aid 关联号
	 * @return 修改的记录数
	 */
	public int deleteAssociation(int aid);
}
