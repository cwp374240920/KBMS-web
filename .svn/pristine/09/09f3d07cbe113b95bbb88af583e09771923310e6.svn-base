package main.com.njupt.kb.service;

import main.com.njupt.kb.domain.User;

public interface UserService {

	/**
	 * 注册一个用户
	 * @param user
	 * @return
	 */
	public User addUser(User user);
	
	/**
	 * 用户密码修改
	 * @param user
	 * @return
	 */
	public User modifyUserPassword(int userID,String newPassword,String oldPassword);
	
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public User LoginUser(User user);
	
	/**
	 * 通过用户名查找用户
	 * @param user
	 * @return
	 */
	public User findUserByName(User user);
}
