package com.question.serviceImpl;


import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    private QuestionRepository questionRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question add(Question quiz) {
        return questionRepository.save(quiz);
    }

    @Override
    public List<Question> quizList() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<Question> getQuestionOfQuizById(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
