package test.com.njupt.kb.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import main.com.njupt.kb.dao.FileDao;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.User;
import main.com.njupt.kb.service.FileService;
import main.com.njupt.kb.util.FileUtil;
import main.com.njupt.kb.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestFileService {
	
	@Resource(name="fileService")
	private FileService fileService;
	
	@Resource(name="fileDao")
	private FileDao fileDao;
	
	@Test
	public void uploadFile(){
		User user = new User();
		Category category = new Category();
		for(int i=0;i<10;i++){
			String uuid = Random.generateName();
			File file = new File();
			java.io.File localFile = new java.io.File("myfile"+i+".txt");
			
			String[] type = localFile.getName().split(".");
			String newName = uuid+type[type.length-1];
			String path="./myuser/category01/";
					
			category.setId(01);
			user.setId(02);
			file.setOriginalName(localFile.getName());
			file.setPath(localFile.getAbsolutePath());
			file.setNewName(newName);
			
			FileUtil.CopyFile((MultipartFile)localFile, path, newName);
			
			fileDao.add(file);
		}
	}
	

}
