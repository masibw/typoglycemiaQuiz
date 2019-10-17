package com.masi.typoglycemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	
	@GetMapping("/index")
	public String getIndex() {
		
		
		return "index";
	}
	
	
	@PostMapping("/index")
	public String postIndex(Model model){
		return "index";
	}
}
