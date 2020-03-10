package com.example.simplerestapis.repository;

import com.example.simplerestapis.service.scorecard.bean.Scorecard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Scorecardrepository extends MongoRepository<Scorecard, Integer> {
    List<Scorecard> findBywinner(String s);
    List<Scorecard> findBywinnerNot(String s);
}
