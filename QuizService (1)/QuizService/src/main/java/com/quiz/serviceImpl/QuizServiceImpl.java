package com.quiz.serviceImpl;

import com.quiz.entity.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {


    @Autowired
    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> quizList() {

//        doing for microservices
        List<Quiz> quizList = quizRepository.findAll();
        List<Quiz> collect = quizList.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return collect;

//        return quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;

    }
}
