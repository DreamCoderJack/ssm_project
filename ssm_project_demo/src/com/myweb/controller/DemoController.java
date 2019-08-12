package com.myweb.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.pojo.User;

@Controller
public class DemoController {

	@RequestMapping(value="/hello")
	public ModelAndView hello() {
		
		ModelAndView view = new ModelAndView();
		view.addObject("message", "Hello SpringMVC");
		view.setViewName("demo");
		
		return view;
	}
	
	@RequestMapping(value="/login" )
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("passwd") String passwd) {
		ModelAndView view = new ModelAndView();
		view.addObject("username",username);
		view.addObject("passwd",passwd);
		view.setViewName("login");
		return view;
		

	}
	
	@RequestMapping(value="/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file ,@RequestParam("filename") String filename) {
		if(!file.isEmpty()) {
			try {
				file.transferTo(new File("C:\\"+file.getOriginalFilename()));
				
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("文件存储失败");
				e.printStackTrace();
				
			}finally {
				
			}
			return "redirect:successful.html";
		}else {
			return "redirect:fail.html";
		}
		
	}
}
