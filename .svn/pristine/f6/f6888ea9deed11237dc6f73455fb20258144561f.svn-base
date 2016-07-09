package test.com.njupt.kb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.com.njupt.kb.dao.AssociationDao;
import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;
import main.com.njupt.kb.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestAssociationDao {

	@Resource(name = "associationDao")
	private AssociationDao associationDao;

	@Test
	public void createAssociation() {
		String key = Random.generateName();
		int[] a = { 3, 4, 5, 6 };

		for (int i = 0; i < a.length; i++) {
			int b= associationDao.createAssociation(key, "", a[i]);
			System.out.println(b);
		}
		

	}
	
	@Test
	public void deleteAssociation(){
		int fid = 7;
		System.out.println(associationDao.deleteAssociation(fid));
	}
	
	@Test
	public void findAssociation(){
		int fid=12;
		PageModel pageModel = new PageModel();
		pageModel.setPageNo(1);
		pageModel.setPageSize(20);
		pageModel = associationDao.findAssociation(fid, pageModel);
		List list=pageModel.getList();
		for(Object o:list){
			File f=(File) o;
			System.out.println(f.getOriginalName());
		}
	}

}
