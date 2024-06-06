package com.example.multitaskingappBacEnd.Controller;

import com.example.multitaskingappBacEnd.Pom.exam.Questions;
import com.example.multitaskingappBacEnd.Pom.exam.Quiz;
import com.example.multitaskingappBacEnd.service.QuestionsService;
import com.example.multitaskingappBacEnd.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @Autowired
    QuizService quizService;

    //add
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Questions questions){
        return ResponseEntity.ok(this.questionsService.addQuiestion(questions));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Questions questions){
        return ResponseEntity.ok(this.questionsService.addQuiestion(questions));
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsofQuiz(@PathVariable("qid")Long qid){
//        Quiz quiz =new Quiz();
//        quiz.setQid(qid);
//        Set<Questions> questionsOfQuiz= this.questionsService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);
        Quiz quiz =this.quizService.getQuiz(qid);
        Set<Questions> questions =quiz.getQuestions();
        List list= new ArrayList(questions);
        Collections.shuffle(list);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
            list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{qid}")
    public  Questions get(@PathVariable("qid") Long qid){
        return this.questionsService.getQuestions(qid);
    }

    @PutMapping("/{id}")
        public void deletequestion(@PathVariable("id") Long id){
            this.questionsService.deltedQuestion(id);
        }


//    {
//        "quesId": 15,
//            "content": "What is Java Programing?",
//            "image": "java.png",
//            "option1": "OOPS",
//            "option2": "DSA",
//            "option3": "SQA",
//            "option4": "ABC",
//            "answer": "ABC",
//            "quiz": {
//        "qid": 12,
//                "title": "Java Basics",
//                "description": "This quiz contains quistions of basic java",
//                "maxMarks": "100",
//                "numberOfQuestions": "10",
//                "active": false,
//                "category": {
//            "cid": 9,
//                    "title": "Programing Language",
//                    "description": "This Quiz Contains Quizz related to Programing Language"
//        }
//    }
//    }
}