package main.com.njupt.kb.dao;

import main.com.njupt.kb.domain.User;

public interface UserDao{
	
	/**
	 * 插入一条用户记录
	 * @param u 用户
	 * @return 整型数字,0为插入失败,1为插入成功
	 */
	public int add(User u);
	
	/**
	 * 删除一个用户
	 * @param user
	 * @return
	 */
	public int delete(User user);
	
	/**
	 * 查询用户
	 * @param name
	 * @param password
	 * @return
	 */
	public User findUser(String name,String password);
	
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	public User findUserByName(String name);
	

}
