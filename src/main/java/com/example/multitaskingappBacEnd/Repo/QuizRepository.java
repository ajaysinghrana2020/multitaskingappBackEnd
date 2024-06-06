package com.example.multitaskingappBacEnd.Repo;

import com.example.multitaskingappBacEnd.Pom.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
