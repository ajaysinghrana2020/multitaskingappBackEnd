package com.example.multitaskingappBacEnd.service;

import com.example.multitaskingappBacEnd.Pom.exam.Questions;
import com.example.multitaskingappBacEnd.Pom.exam.Quiz;

import java.util.Set;

public interface QuestionsService {
    public Questions addQuiestion(Questions questions);
    public  Questions updateQuestion(Questions questions);
    public Set<Questions> getQuestions();
    public Questions getQuestions(Long questionsId);
    public  Set<Questions> getQuestionsOfQuiz(Quiz quiz);
    public void deltedQuestion(Long QuestionId);

}
