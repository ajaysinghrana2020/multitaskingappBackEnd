package com.example.multitaskingappBacEnd.service.Impl;

import com.example.multitaskingappBacEnd.Pom.exam.Questions;
import com.example.multitaskingappBacEnd.Pom.exam.Quiz;
import com.example.multitaskingappBacEnd.Repo.QuestionsRepository;
import com.example.multitaskingappBacEnd.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    QuestionsRepository questionsRepository;


    @Override
    public Questions addQuiestion(Questions questions) {
        return questionsRepository.save(questions);
    }

    @Override
    public Questions updateQuestion(Questions questions) {
        return questionsRepository.save(questions);
    }

    @Override
    public Set<Questions> getQuestions() {
        return new HashSet<>(this.questionsRepository.findAll());
    }

    @Override
    public Questions getQuestions(Long questionsId) {
        return this.questionsRepository.findById(questionsId).get();
    }

    public  Set<Questions> getQuestionsOfQuiz(Quiz quiz){
        return this.questionsRepository.findByQuiz(quiz);
    }

    @Override
    public void deltedQuestion(Long QuestionId) {
        this.questionsRepository.deleteById(QuestionId);
    }
}
