package main.com.njupt.kb.dao;

import java.util.List;

import main.com.njupt.kb.domain.Category;

public interface CategoryDao {

	/**
	 * 插入一个目录
	 * @param category
	 */
	public int add(Category category);
	
	/**
	 * 删除用户目录
	 * @param category
	 * @return
	 */
	public int delete(Category category);

	/**
	 * 查询用户目录
	 * @param userID
	 * @return
	 */
	public List<Category> findCategorys(int userID);
}
