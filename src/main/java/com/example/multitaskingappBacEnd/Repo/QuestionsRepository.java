package com.example.multitaskingappBacEnd.Repo;

import com.example.multitaskingappBacEnd.Pom.exam.Questions;
import com.example.multitaskingappBacEnd.Pom.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionsRepository extends JpaRepository<Questions,Long> {
    Set<Questions> findByQuiz(Quiz quiz);
}
