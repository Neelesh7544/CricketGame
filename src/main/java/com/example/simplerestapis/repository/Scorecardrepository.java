package com.example.simplerestapis.repository;

import com.example.simplerestapis.service.scorecard.bean.Scorecard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Scorecardrepository extends MongoRepository<Scorecard, Integer> {

}
