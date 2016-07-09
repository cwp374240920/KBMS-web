package main.com.njupt.kb.web;


import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.regexp.internal.recompile;

import main.com.njupt.kb.domain.User;
import main.com.njupt.kb.dto.LoginedUser;
import main.com.njupt.kb.service.FileService;
import main.com.njupt.kb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="fileService")
	private FileService fileService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/login")
	public @ResponseBody LoginedUser login(@RequestBody User user){
		if(user==null)
			return null;
		LoginedUser loginedUser=new LoginedUser();
		user=userService.LoginUser(user);
		if(user==null)
			return null;
		try {
			BeanUtils.copyProperties(loginedUser,user );
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginedUser;
	}
	
	@RequestMapping("/register")
	public @ResponseBody LoginedUser Register(@RequestBody User user){
		if(user==null)
			return null;
		user=userService.addUser(user);
		LoginedUser loginedUser=new LoginedUser();
		try {
			BeanUtils.copyProperties(loginedUser, user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginedUser;
	}
	
	@RequestMapping("/findUserByName")
	public@ResponseBody Boolean findUserByName(@RequestBody User user){
		if(user==null)
			return null;
		user=userService.findUserByName(user);
		if(user!=null)
			return true;
		return false;
	
	}
}
