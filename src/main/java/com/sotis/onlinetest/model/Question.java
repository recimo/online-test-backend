package com.sotis.onlinetest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Questions")
public class Question {

    @Id
    private Integer id;
    private String questionText;

    public Question(Integer id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
