package com.sotis.onlinetest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Tests")
public class Test {

    @Id
    private ObjectId _id;
    private String name;
    private List<Question> questionList;
    private List<String> answers;
    //private List<AreaOfInterest> areaOfInterests;
    private List<QuestionTime> questionTimes;

    public List<QuestionTime> getQuestionTimes() {
        if(this.questionTimes == null) {
            this.questionTimes = new ArrayList<>();
        }
        return questionTimes;
    }
}
