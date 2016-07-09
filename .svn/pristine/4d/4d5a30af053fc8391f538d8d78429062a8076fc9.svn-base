package test.com.njupt.kb.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.com.njupt.kb.dao.UserDao;
import main.com.njupt.kb.domain.User;
import main.com.njupt.kb.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestUserDao {
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	private String[] firstName={"王","李","张","刘","徐","徐","庞","林"};
	private String[] lastName={"晓峰","东","非","飞","建国","天问"};
	
	@Test
	public void add(){
		User user=new User();
		for(int i=0;i<100;i++){
			String name=firstName[i%8]+lastName[i%6];
			String pwd=Random.generateName();
			user.setName(name);
			user.setPassword(pwd);
			userDao.add(user);
		}
		/*user.setName("雨天好");
		user.setPassword("15646");
		int b=userDao.add(user);
		if(b==1)
			System.out.println("成功");
		if(b==0)
			System.out.println("失败");*/
		
	}
	
	@Test
	public void findUser(){
		User user=new User();
		user.setPassword("f7f5785-39");
		user=userDao.findUser("王晓峰", "f7f5785-39");
		System.out.println(user.getName());
	}

}
