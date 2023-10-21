package com.example.backsgbdproject.repository;

import com.example.backsgbdproject.entity.Game;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GameRepo extends ElasticsearchRepository<Game, Integer> {

}
