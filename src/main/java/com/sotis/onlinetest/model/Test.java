package com.sotis.onlinetest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Tests")
public class Test {

    @Id
    private Integer id;
    private List<Question> questionList;

    public Test(Integer id, List<Question> questionList) {
        this.id = id;
        this.questionList = questionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
