package com.sotis.onlinetest.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GazePoint {
    private String gazeTime;
    private String bpogX;
    private String bpogY;
}
