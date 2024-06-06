package com.example.multitaskingappBacEnd.Controller;

import com.example.multitaskingappBacEnd.Pom.exam.Quiz;
import com.example.multitaskingappBacEnd.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        Quiz quiz1=this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
        Quiz quiz1=this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable("id")Long id){
        return this.quizService.getQuiz(id);
    }

    //getall quizer

    @GetMapping("/")
    public ResponseEntity<?> queses(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable("id")Long id){
        quizService.deleteQuiz(id);
    }

//    {
//        "qid": 13,
//            "title": "Python Basics",
//            "description": "This quiz contains quistions of basic Python",
//            "maxMarks": "100",
//            "numberOfQuestions": "10",
//            "active": false,
//            "category": {
//        "cid": 9,
//                "title": "Programing Language",
//                "description": "This Quiz Contains Quizz related to Programing Language"
//    }

}
