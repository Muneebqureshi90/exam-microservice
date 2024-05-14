package com.question.services;



import com.question.entity.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question quiz);
    List<Question> quizList();
    Question get(Long id);
    List<Question> getQuestionOfQuizById(Long quizId);
}
