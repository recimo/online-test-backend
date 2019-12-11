package com.sotis.onlinetest.repository;

import com.sotis.onlinetest.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question, Integer> {
}
