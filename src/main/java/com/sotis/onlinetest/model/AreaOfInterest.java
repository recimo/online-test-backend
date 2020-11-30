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
@Document(collection = "AOIs")
public class AreaOfInterest {
    private String name;
    private String top;
    private String bottom;
    private String left;
    private String right;
}
