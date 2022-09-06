package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //Add Quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    //Update Quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //Getting Quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //Get one quiz
    @GetMapping("/{quizId}")
    public Quiz quiz(@PathVariable("quizId") Long quizId)
    {
        return this.quizService.getQuiz(quizId);
    }

    //Delete Quiz
    @DeleteMapping("/{quizId}")
    public void delete(@PathVariable ("quizId") Long quizId)
    {
        this.quizService.deleteQuiz(quizId);
    }

    //Get Specific Category
    @GetMapping("/category/{cId}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cId") Long cId){
        Category category = new Category();
        category.setCid(cId);
        return this.quizService.getQuizzesOfCategory(category);
    }

    //Get active quiz
    @GetMapping( "/active")
    public List<Quiz> getActiveQuizzes()
    {
        return this.quizService.getActiveQuizzes();
    }

    //Get Active quiz category
    @GetMapping( "/category/active/{cId}")
    public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cId") Long cId)
    {
        Category category = new Category();
        category.setCid(cId);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }
}
