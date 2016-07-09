package main.com.njupt.kb.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;
import main.com.njupt.kb.dto.AssociationInfo;
import main.com.njupt.kb.service.FileService;

@Controller
@RequestMapping(value = "/file")
public class FileController {

	@Resource(name = "fileService")
	private FileService fileService;
	

	@RequestMapping(value = "/upload")
	public @ResponseBody PageModel upload(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam int cid, @RequestParam int uid, HttpServletRequest httpServletRequest) {

		if(file==null||cid==0||uid==0)
			return null;
		fileService.uploadFile(file, cid, uid, httpServletRequest);
		PageModel pageModel = new PageModel();
		pageModel.setPageNo(0);
		pageModel.setPageSize(20);
		pageModel = fileService.queryFile(cid, pageModel);
		return pageModel;
	}

	@RequestMapping("/loadFiles")
	public @ResponseBody PageModel loadFiles(@RequestParam int cid, @RequestBody PageModel pageModel) {
		return fileService.queryFile(cid, pageModel);
	}
	
	@RequestMapping("/typeFile")
	public @ResponseBody PageModel loadFilesByType(@RequestParam int uid,@RequestBody PageModel pageModel){
		return fileService.findFileByType(uid, pageModel);
	}
	@RequestMapping("/keyWordFile")
	public @ResponseBody PageModel loadFileByKeyword(@RequestParam int uid,@RequestBody PageModel pageModel){
		return fileService.findFileByKeyword(uid, pageModel);
	}
	
	@RequestMapping("/setCommonUse")
	public @ResponseBody File setCommonUse(@RequestParam int fid){
		return fileService.setCommonUse(fid);
	}
	
	@RequestMapping("/cancelCommonUse")
	public @ResponseBody File cancelCommonUse(@RequestParam int fid){
		return fileService.cancelCommonUse(fid);
	}
	
	@RequestMapping("/createAssociateFile")
	public @ResponseBody int createAssociateFile(@RequestBody AssociationInfo associationInfo)
	{
		return fileService.createAssociation(associationInfo);
	}
	
	@RequestMapping("/associateFile")
	public @ResponseBody PageModel findAssociateFile(@RequestParam int fid ,@RequestBody PageModel pageModel){
		return fileService.findAssociateFiles(fid, pageModel);
	}
	
	@RequestMapping("/commonUseFile")
	public @ResponseBody PageModel findCommonUseFile(@RequestParam int uid,@RequestBody PageModel pageModel){
		return fileService.findCommonUseFile(uid, pageModel);
	}
	
	@RequestMapping("/getFile")
	public @ResponseBody File getFileByID(@RequestParam int fid){
		return fileService.findFile(fid);
	}
	

}
