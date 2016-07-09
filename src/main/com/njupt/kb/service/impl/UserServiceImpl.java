package main.com.njupt.kb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.com.njupt.kb.dao.CategoryDao;
import main.com.njupt.kb.dao.FileDao;
import main.com.njupt.kb.dao.UserDao;
import main.com.njupt.kb.domain.User;
import main.com.njupt.kb.service.UserService;

@Service(value="userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="fileDao")
	private FileDao fileDao;
	
	@Resource(name="categoryDao")
	private CategoryDao categoryDao;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		if(user==null||user.getName()==null||user.getPassword()==null)
			return null;
		int result=userDao.add(user);
		if(result==0)
			return null;
		user=userDao.findUser(user.getName(), user.getPassword());
		return user;
	}

	@Override
	public User modifyUserPassword(int userID, String newPassword, String oldPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User LoginUser(User user) {
		// TODO Auto-generated method stub
		if(user.getName()==null||user.getPassword()==null)
			return null;
		return userDao.findUser(user.getName(), user.getPassword());
	}

	@Override
	public User findUserByName(User user) {
		// TODO Auto-generated method stub
		if(user==null||user.getName()==null)
			return null;
		user=userDao.findUserByName(user.getName());
		return user;
	}

}
