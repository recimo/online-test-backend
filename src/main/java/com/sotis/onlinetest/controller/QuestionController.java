package com.sotis.onlinetest.controller;


import com.sotis.onlinetest.model.Question;
import com.sotis.onlinetest.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/all")
    public List<Question> getAll(){
        List<Question> questions = this.questionRepository.findAll();

        return questions;
    }

    @PutMapping
    public void insert(@RequestBody Question question){
        this.questionRepository.insert(question);
    }

    @PostMapping
    public void update(@RequestBody Question question){
        this.questionRepository.save(question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        this.questionRepository.deleteById(id);
    }
}
