package com.masi.typoglycemia.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.masi.typoglycemia.domain.Quiz;
import com.masi.typoglycemia.repository.QuizRepository;
@Service
@Scope("session")
public class TypoglycemiaService {
	
	@Autowired
	private QuizRepository quizRepository;
	public String convertWord(String str) {
		if(str.length()<2) return str+"　";
		int lastn = str.length();
		List<Character> chars = new ArrayList<>();
		for (char ch : str.toCharArray()) {
			chars.add(ch);
		}

		char last = chars.get(lastn - 1);
		chars.remove(lastn - 1);
		char first = chars.get(0);
		chars.remove(0);

		Collections.shuffle(chars);
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		for (Character ch : chars) {
			sb.append(ch);
		}
		sb.append(last);
		String typoStr = sb.toString();
		return typoStr+"　";
	}
	
	public String convertString(String str) {
		String[] splitString = str.split("　+|\\s+");
		StringBuilder sb=new StringBuilder();
		for(String word: splitString) {
			sb.append(convertWord(word));
		}
		String result = sb.toString();
		return result.substring(0,result.length()-1);
	
	}
	
	
	public List<Quiz> findAll(){
		return quizRepository.findAll();
	}
	public Optional<Quiz> findOne(int id) {
		return quizRepository.findById(id);
	}
	
	public Quiz save(Quiz quiz) {
		return quizRepository.save(quiz);
	}
	public void delete(int id) {
		quizRepository.deleteById(id);
	}
}
