package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {

	@GetMapping("/index")
	public String welcomefile() {
		return "index";
	}
	

	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/message")
	public ModelAndView getMessage() {
		String message = "this is message from getMessage";
		return new ModelAndView("showmessage", "msg", message);
	}

}
