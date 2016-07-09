package main.com.njupt.kb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import main.com.njupt.kb.dao.BaseDao;
import main.com.njupt.kb.dao.CategoryDao;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.User;

@Repository(value = "categoryDao")
public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	@Override
	public int add(Category category) {
		// TODO Auto-generated method stub
		/*this.getSession().save(category);*/
		return this.getSession().createSQLQuery("insert into category values(null,:name,:remark,:uid)")
		.addEntity(Category.class)
		.setParameter("name", category.getName())
		.setParameter("remark", category.getRemark())
		.setParameter("uid", category.getUser().getId())
		.executeUpdate();

	}

	@Override
	public List<Category> findCategorys(int userID) {
		// TODO Auto-generated method stub
		
		return this.getSession()
				.createQuery("from Category c where c.user.id=:uid")
				.setParameter("uid",userID)
				.list();
		 
	}

	@Override
	public int delete(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

}
