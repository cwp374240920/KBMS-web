package main.com.njupt.kb.dao.impl;

import org.springframework.stereotype.Repository;

import main.com.njupt.kb.dao.BaseDao;
import main.com.njupt.kb.dao.UserDao;
import main.com.njupt.kb.domain.User;

@Repository(value="userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public  int  add(User u) {
		// TODO Auto-generated method stub
		return this.getSession()
				.createSQLQuery("insert into user (name,password) values(:name,:password)")
					.addEntity(User.class)
						.setParameter("name", u.getName())
							.setParameter("password", u.getPassword())
								.executeUpdate();
		
	}

	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String name, String password) {
		// TODO Auto-generated method stub
		User user=new User();
		user=(User) this.getSession().createSQLQuery("select * from user where name=:name and password=:password")
		.addEntity(User.class)
		.setParameter("name", name)
		.setParameter("password", password)
		.uniqueResult();
		return user;
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		User user=new User();
		user=(User) this.getSession().createSQLQuery("select * from user where name=:name")
		.addEntity(User.class)
		.setParameter("name", name)
		.uniqueResult();
		return user;
	}


}
