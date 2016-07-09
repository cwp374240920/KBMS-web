package test.com.njupt.kb.dao;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thoughtworks.xstream.mapper.PackageAliasingMapper;

import main.com.njupt.kb.dao.AssociationDao;
import main.com.njupt.kb.dao.FileDao;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;
import main.com.njupt.kb.domain.User;
import main.com.njupt.kb.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestFileDao {
	
	@Resource(name="fileDao")
	private FileDao fileDao;
	
	@Resource(name="associationDao")
	private AssociationDao associationDao;
	
	private String[] originalName={"javaWeb","Linux","云计算","组织行为学","通信原理","软件项目管理"};
	private Integer[] cid={1,2,3,4};
	
	@Test
	public void findFile(){
		File file=new File();
		file=fileDao.findFile(1);
		System.out.println(file.getOriginalName()+file.getPath());
		
	}
	
	@Test
	public void AddFile()
	{
		
		File file=new File();
		User user=new User();
		Category category=new Category();
		category.setId(2);
		for(int i=0;i<100;i++)
		{
			
			file.setNewName(Random.generateName());
			file.setPath("/file/"+user.getId()+"/"+Random.generateName());
			file.setOriginalName(originalName[i%6]);
			file.setCategory(category);
			fileDao.add(file);
		}
		/*file.setNewName(Random.generateName());
		file.setPath("/file/"+user.getId()+"/"+Random.generateName());
		file.setOriginalName(originalName[1]);
		file.setCategory(category);
		int k=fileDao.add(file);
		if(k==1)
			System.out.println("插入成功");*/
		
	}
	
	
	@Test
	public void queryList(){
		
		PageModel pageModel=new PageModel();
		pageModel.setPageNo(0);
		pageModel.setPageSize(20);

		
		pageModel=fileDao.findFiles(pageModel, 2);
		
		System.out.println(pageModel.getList().size());
		
		
	}
	
	@Test
	public void FindFilesByType(){
		
		PageModel pageModel=new PageModel();
		pageModel.setPageNo(0);
		pageModel.setPageSize(20);
		pageModel.setKeyword("文本");

		
		pageModel=fileDao.findFilesByType(1, pageModel);
		
		System.out.println(pageModel.getList().size());
		
		
	}
	
	@Test
	public void findFileByKeyWord(){
		PageModel pageModel=new PageModel();
		pageModel.setPageNo(0);
		pageModel.setPageSize(20);
		pageModel.setKeyword("11");
		
		pageModel=fileDao.findFileByKeyWord(1, pageModel);
		//log
		System.out.println("-------->"+pageModel.getList().size());
		
	}
	
	@Test
	public void setFileCommonUse(){
		int k=fileDao.setCommonUse(2);
		System.out.println(k);
	}
	
	@Test
	public void cancelFileCommonUse(){
		int k=fileDao.cancelCommonUse(2);
		System.out.println(k);
	}
	
	@Test
	public void createAssociation(){
		
		String key = "xiaofeng";
		String info = "sb";
		int fid = 13;
		associationDao.createAssociation(key, info, fid);
		
	}
	
	@Test
	public void findCommonUseFile(){
		PageModel pageModel=new PageModel();
		pageModel.setPageNo(1);
		pageModel.setPageSize(15);
		pageModel.setKeyword("常用");
		pageModel=fileDao.findCommonUseFile(1, pageModel);
		System.out.println(pageModel.getList().size());
	}

}
