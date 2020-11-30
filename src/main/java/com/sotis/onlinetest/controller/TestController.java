package com.sotis.onlinetest.controller;

import com.sotis.onlinetest.model.*;
import com.sotis.onlinetest.repository.TestRepository;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Area;
import java.util.ArrayList;
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

    @GetMapping("/{name}")
    public Test getTestByName(@PathVariable("name") String name) {
        Test t = testRepository.findByName(name);
        return testRepository.findByName(name);
    }

    @PostMapping("/addAnswer")
    public void save(@RequestBody TestAnswerDTO answerDTO) {
        Test t = this.testRepository.findByName(answerDTO.getName());
        if(t.getAnswers() == null){
            List<String> newAnswers = new ArrayList<>();
            newAnswers.add(answerDTO.getAnsweredAnswer());
            t.setAnswers(newAnswers);
            this.testRepository.save(t);
        } else {
            t.getAnswers().add(answerDTO.getAnsweredAnswer());
            this.testRepository.save(t);
        }
    }

    @PutMapping
    public void insert(@RequestBody Test test) { this.testRepository.insert(test); }

    @PostMapping
    public void save(@RequestBody Test test) { this.testRepository.save(test); }

    @PostMapping("/addQuestion")
    public void update(@RequestBody TestQuestionDTO testQuestionDTO) {
        Test t = this.testRepository.findByName(testQuestionDTO.getName());
        if(t.getQuestionList() == null) {
            List<Question> newQuestionList = new ArrayList<>();
            newQuestionList.add(testQuestionDTO.getQuestion());
            t.setQuestionList(newQuestionList);
            this.testRepository.save(t);
        } else {
            t.getQuestionList().add(testQuestionDTO.getQuestion());
            this.testRepository.save(t);
        }
    }

    @PostMapping("/addAoi")
    public void save(@RequestBody AreaOfInterestDTO areaOfInterestDTO) {
        Test t = this.testRepository.findByName(areaOfInterestDTO.getTestName());
        Question q = t.getQuestionList().get(areaOfInterestDTO.getQuestionNumber());
        AreaOfInterest aoi = new AreaOfInterest();
        aoi.setName(areaOfInterestDTO.getName());
        aoi.setBottom(areaOfInterestDTO.getBottom());
        aoi.setTop(areaOfInterestDTO.getTop());
        aoi.setLeft(areaOfInterestDTO.getLeft());
        aoi.setRight(areaOfInterestDTO.getRight());
        q.getAois().add(aoi);
        this.testRepository.save(t);
    }

    @PostMapping("/addQuestionTimes")
    public void save(@RequestBody QuestionTimeDTO questionTimeDTO) {
        Test t = this.testRepository.findByName(questionTimeDTO.getTestName());
        QuestionTime qt = new QuestionTime();
        qt.setQuestionNumber(questionTimeDTO.getQuestionNumber());
        qt.setStartTime(questionTimeDTO.getStartTime());
        List<QuestionTime> qts = t.getQuestionTimes();
        if(!qts.isEmpty()) {
            qts.get(qts.size() - 1).setEndTime(questionTimeDTO.getStartTime());
        }
        t.getQuestionTimes().add(qt);
        this.testRepository.save(t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) { this.testRepository.deleteById(id); }
}
