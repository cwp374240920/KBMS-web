package test.com.njupt.kb.util;

import org.junit.Test;

import main.com.njupt.kb.util.FileUtil;

public class TestFileUtil {
	
	@Test
	public void FileType(){
		String suffix1="jpg";
		String suffix2="mp4";
		String suffix3="doc";
		System.out.println(FileUtil.FileType(suffix1));
		System.out.println(FileUtil.FileType(suffix2));
		System.out.println(FileUtil.FileType(suffix3));
	}

}
