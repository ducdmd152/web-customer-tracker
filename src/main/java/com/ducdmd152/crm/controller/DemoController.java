package com.ducdmd152.crm.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	@GetMapping("/hello")
	public String showHello(Model model) {
		model.addAttribute("theDate", new Date());
		
		return "helloworld";
	}
}
