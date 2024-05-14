package com.quiz.services;

import com.quiz.entity.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// This interface defines a Feign client for making HTTP requests to the Question service
//@FeignClient(url = "http://localhost:8081", value = "Question-Client")
@FeignClient(name = "question-service")
public interface QuestionClient {

    // Retrieves a list of questions for a specific quiz from the Question service
    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
