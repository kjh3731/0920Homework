package com.java.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@Autowired
	SqlSession sql;
	
	@RequestMapping("/")
	public String root(Model model) {
		List<MainBean> list = sql.selectList("noticeboard.select");
		model.addAttribute("list", list);
		return "main";
	}
	
	 @RequestMapping("/write") 
	 public String write() {
		 return "write"; 
	 }
	
	@RequestMapping(value = "/write/{key}", method=RequestMethod.POST)
	public String crud(@PathVariable("key") String key, MainBean mb) {
		
		System.out.println(mb.toString());
		switch (key) {
		case "insert":
			sql.insert("noticeboard.insert", mb);
			break;
		case "update":
			
			break;
		case "delete":
			
			break;

		default:
			break;
		}

		return "redirect:/";
	}
	
	@RequestMapping("/viewDetail/{key}")
	public String viewDetail(@PathVariable("key") String key) {
		
		
		return "viewDetail";
	}
}
