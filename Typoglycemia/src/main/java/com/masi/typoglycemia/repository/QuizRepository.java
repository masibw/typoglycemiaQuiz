package com.masi.typoglycemia.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masi.typoglycemia.domain.Quiz;

@Repository
@Scope("session")
public interface QuizRepository extends JpaRepository<Quiz,Integer> {}
