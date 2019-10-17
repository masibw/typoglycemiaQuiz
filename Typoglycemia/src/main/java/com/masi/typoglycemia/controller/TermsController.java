package com.masi.typoglycemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TermsController {

	
	@GetMapping("/terms")
	public String getIndex() {
		
		
		return "terms";
	}
	
	
	@PostMapping("/terms")
	public String postIndex(Model model){
		return "terms";
	}
}
