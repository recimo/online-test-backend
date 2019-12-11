package com.sotis.onlinetest.controller;

import com.sotis.onlinetest.model.Test;
import com.sotis.onlinetest.repository.TestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) { this.testRepository = testRepository; }

    @GetMapping("/all")
    public List<Test> getAll(){
        List<Test> tests = this.testRepository.findAll();

        return tests;
    }

    @PutMapping
    public void insert(@RequestBody Test test) { this.testRepository.insert(test); }

    @PostMapping
    public void update(@RequestBody Test test) { this.testRepository.save(test); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) { this.testRepository.deleteById(id); }
}
