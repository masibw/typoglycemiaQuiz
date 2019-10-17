package com.masi.typoglycemia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.masi.typoglycemia.domain.Quiz;
import com.masi.typoglycemia.service.TypoglycemiaService;

@Controller
@Scope("session")
public class QuizListController {

	@Autowired
	private TypoglycemiaService typoService;
	
	@GetMapping("admin/quizList")
	public String GetQuizList(Model model) {
		
		List<Quiz> quizzes = typoService.findAll();
		model.addAttribute("quizzes",quizzes);
		return "admin/quizList";
	}
}
