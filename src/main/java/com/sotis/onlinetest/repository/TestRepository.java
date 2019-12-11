package com.sotis.onlinetest.repository;

import com.sotis.onlinetest.model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<Test, Integer> {
}
