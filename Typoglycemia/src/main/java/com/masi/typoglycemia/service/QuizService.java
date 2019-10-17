package com.masi.typoglycemia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.masi.typoglycemia.domain.Quiz;
import com.masi.typoglycemia.repository.QuizRepository;

@Service
@Scope("session")
public class QuizService {

	@Autowired
	private QuizRepository quizRepository;

	public boolean isCorrect(int id, String str) {

		Optional<Quiz> oquiz = quizRepository.findById(id);
		if (oquiz.isPresent()) {
			Quiz quiz = oquiz.get();
			String origin = quiz.getOriginal();
			String[] strWords = str.split("　+|\\s+");
			String[] originWords = origin.split("　+|\\s+");
			boolean isCorrect = false;
			for (int i = 0; i < originWords.length; i++) {
				if(strWords.length!=originWords.length) return false;
				else isCorrect = strWords[i].equals(originWords[i]);
				if (isCorrect == false)
					return false;
			}

			return isCorrect;
		} else {

			return false;
		}
	}

}
