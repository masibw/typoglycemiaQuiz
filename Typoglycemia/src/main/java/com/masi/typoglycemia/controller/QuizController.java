package com.masi.typoglycemia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masi.typoglycemia.domain.Quiz;
import com.masi.typoglycemia.service.QuizService;
import com.masi.typoglycemia.service.TypoglycemiaService;

@Controller
@Scope("session")
public class QuizController {

	@Autowired
	private TypoglycemiaService typoService;
	@Autowired
	private QuizService quizService;
	
	Quiz quiz = new Quiz();
	
	@GetMapping("/quiz")
	public String GetQuiz(Model model) {
		int id=1;
		List<Quiz> quizList = typoService.findAll();
		id=(int) Math.ceil(Math.random()*quizList.size());
		Optional<Quiz> oquiz = typoService.findOne(id);
		quiz = oquiz.get();
		model.addAttribute("quiz",typoService.convertString(quiz.getOriginal()));
		return "quiz";
		
	}
	
	@PostMapping("/quiz")
	public String postQuiz(@RequestParam("answer") String str,Model model) {
		boolean isCorrect = quizService.isCorrect(quiz.getId(),str);
		if(isCorrect) {
			model.addAttribute("judge","正解です！");

			model.addAttribute("answer",quiz.getOriginal());
			return "correct";
		}else {
			model.addAttribute("judge","不正解です");

			model.addAttribute("answer",quiz.getOriginal());
			return "wrong";
		}
		
		
	}
}
