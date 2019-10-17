package com.masi.typoglycemia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masi.typoglycemia.domain.Quiz;
import com.masi.typoglycemia.service.TypoglycemiaService;

@Controller
@Scope("session")
public class QuizRegisterController {

	
	@Autowired
	private TypoglycemiaService typoService;
	@GetMapping("admin/quizRegister")
	public String getQuiz() {
		return "admin/quizRegister";
	}

	@PostMapping("admin/quizRegister")
	public String postQuiz(@RequestParam("original")String str,Model model) {
	String	typoStr=typoService.convertString(str);
	Quiz quiz = new Quiz();
	quiz.setOriginal(str);
	typoService.save(quiz);
		model.addAttribute("original",typoStr);
		return "admin/quizResponse";
	}
}
