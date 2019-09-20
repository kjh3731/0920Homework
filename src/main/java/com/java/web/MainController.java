package com.java.web;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired
	SqlSession sql;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<MainBean> list = sql.selectList("noticeboard.select");
		model.addAttribute("list", list);
		return "main";
	}
	
	@RequestMapping("/{key}")
	public String crud(@PathVariable("key") String key, MainBean mb, Model model) {
		
		switch (key) {
		case "insert":
					
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
}
