package com.sotis.onlinetest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Questions")
public class Question {

    //@Id
    //private Integer id;
    private String questionQuestion;
    private String questionText;
    private String questionAnswer;

}
