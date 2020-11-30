package com.sotis.onlinetest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

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
    private String answer;
    private List<AreaOfInterest> aois;

    public List<AreaOfInterest> getAois() {
        if(this.aois == null){
            this.aois = new ArrayList<>();
        }
        return aois;
    }
}
