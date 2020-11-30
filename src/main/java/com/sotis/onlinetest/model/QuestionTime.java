package com.sotis.onlinetest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "QuestionTime")
public class QuestionTime {
    private int questionNumber;
    private String startTime;
    private String endTime;
}
