package com.example.simplerestapis.repository;

import com.example.simplerestapis.service.team.bean.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teamrepository extends MongoRepository<Team,Integer> {


}
