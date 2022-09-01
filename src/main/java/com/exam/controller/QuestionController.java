package com.exam.controller;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //Add Question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //Update Question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //Getting All Question of any quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId") Long quizId)
    {
        // Quiz quiz = new Quiz();
        // quiz.setqId(quizId);
        // Set<Question> questionOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
        // return ResponseEntity.ok(questionOfQuiz);

        Quiz quiz = this.quizService.getQuiz(quizId);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
        {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    //Get one Question
    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable("questionId") Long questionId)
    {
        return this.questionService.getQuestion(questionId);
    }

    //Delete Quiz
    @DeleteMapping("/{questionId}")
    public void delete(@PathVariable ("questionId") Long questionId)
    {
        this.questionService.deleteQuestion(questionId);
    }
}
