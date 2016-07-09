package main.com.njupt.kb.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.service.CategoryService;

@Controller
public class CategoryController {

	@Resource(name = "categoryService")
	private CategoryService categoryService;

	@RequestMapping("/user/category")
	public @ResponseBody List<Category> getCategory(@RequestParam int userID) {
				
		if(userID<=0) 
			return null;
		List list = categoryService.findCategory(userID);
		return list;

	}

	@RequestMapping("/user/addCategory")
	public @ResponseBody List addCategory(@RequestBody Category category,@RequestParam int userID) {
		if(category==null)
			return null;
		categoryService.addCategory(userID, category);
		List list = categoryService.findCategory(userID);
		return list;
	}

}
