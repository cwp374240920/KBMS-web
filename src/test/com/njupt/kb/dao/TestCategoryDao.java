package test.com.njupt.kb.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.com.njupt.kb.dao.CategoryDao;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.PageModel;
import main.com.njupt.kb.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestCategoryDao {

	@Resource(name = "categoryDao")
	private CategoryDao categoryDao;
	
	private String[] name={"文档","视频","音频","其他"};

	@Test
	public void add() {
		Category category = new Category();
		User user=new User();
		user.setId(1);
		for(int i=0;i<4;i++)
		{
			category.setName(name[i]);
			category.setRemark("普通文件");
			category.setUser(user);
			categoryDao.add(category);
		}
		/*category.setName("压缩包");
		category.setRemark("普通文件");
		category.setUser(user);
		int k=categoryDao.add(category);
		if(k==1)
			System.out.println("插入成功");*/
		
	}
	
	@Test
	public void findCategorys(){

		
		List list=categoryDao.findCategorys(1);
		
		System.out.println(list.size());
		Iterator iterator=list.iterator();
		while(iterator.hasNext()){
			Category category=(Category) iterator.next();
			System.out.println(category.getName());
		}
	}

}
