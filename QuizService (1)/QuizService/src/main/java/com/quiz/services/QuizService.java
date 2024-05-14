package com.quiz.services;

import com.quiz.entity.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);
    List<Quiz> quizList();
    Quiz get(Long id);

}
