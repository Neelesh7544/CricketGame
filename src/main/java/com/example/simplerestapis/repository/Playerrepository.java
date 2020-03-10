package com.example.simplerestapis.repository;

import com.example.simplerestapis.service.player.beans.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Playerrepository extends MongoRepository<Player,Integer> {

}
