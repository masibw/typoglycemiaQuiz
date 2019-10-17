package com.masi.typoglycemia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminIndexController {

	
	@GetMapping("admin/adminIndex")
	public String getIndex() {
		
		
		return "admin/adminIndex";
	}
	
	
	@PostMapping("admin/adminIndex")
	public String postIndex(Model model){
		return "admin/adminIndex";
	}
}
