package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/security")
public class LoginController {
	
	@GetMapping("/login")
	public String showlogin() {
		return "loginpage";
	}

	@PostMapping("/validate")
	public ModelAndView authecateuser(@RequestParam("uname") String unm,@RequestParam String passwd) {
		if(unm.equals("admin") && passwd.equals("admin") ) {
			String msg="Valid user";
			return new ModelAndView("success","msg",msg);
		}else {
			return new ModelAndView("loginpage","msg","");
		}
		
	}

}

