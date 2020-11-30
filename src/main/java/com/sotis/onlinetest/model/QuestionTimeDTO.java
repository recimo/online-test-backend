package com.sotis.onlinetest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionTimeDTO {
    private String testName;
    private int questionNumber;
    private String startTime;
    private String endTime;
}
