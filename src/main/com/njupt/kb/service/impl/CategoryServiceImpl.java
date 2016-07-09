package main.com.njupt.kb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.com.njupt.kb.dao.CategoryDao;
import main.com.njupt.kb.dao.FileDao;
import main.com.njupt.kb.dao.UserDao;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.User;
import main.com.njupt.kb.service.CategoryService;

@Service(value="categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="fileDao")
	private FileDao fileDao;
	
	@Resource(name="categoryDao")
	private CategoryDao categoryDao;
	
	@Override
	public void addCategory(int userID, Category category) {
		// TODO Auto-generated method stub
		if(userID<=0)
			return;
		User user=new User();
		user.setId(userID);
		category.setUser(user);
		categoryDao.add(category);

	}

	@Override
	public List findCategory(int userID) {
		// TODO Auto-generated method stub
		if(userID<=0)
			return null;
		List list=categoryDao.findCategorys(userID);
		return list;
		
	}

	@Override
	public int deleteCategory(int categoryID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
