package com.sotis.onlinetest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AreaOfInterestDTO {
    private String testName;
    private int questionNumber;
    private String name;
    private String top;
    private String bottom;
    private String left;
    private String right;
}
