package com.question.controller;


import com.question.entity.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService quizService;

    @PostMapping("/")
    public Question create(@RequestBody Question quiz) {
        return quizService.add(quiz);
    }

    @GetMapping("/")
    public List<Question> getAll() {
        return quizService.quizList();
    }

    @GetMapping("/{id}")
    public Question create(@PathVariable Long id) {
        return quizService.get(id);
    }

    @GetMapping("/quiz/{quizId}") // Changed the path variable name to 'quizId'
    public List<Question> getQuestionsofQuiz(@PathVariable Long quizId) {
        return quizService.getQuestionOfQuizById(quizId);
    }

}
