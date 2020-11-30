package com.sotis.onlinetest.repository;

import com.sotis.onlinetest.model.Test;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, Integer> {
    Test findByName(String name);
}
