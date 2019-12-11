package com.sotis.onlinetest.config;

import com.sotis.onlinetest.repository.QuestionRepository;
import com.sotis.onlinetest.repository.TestRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {TestRepository.class, QuestionRepository.class})
@Configuration
public class MongoDBConfig {

}
