package com.example.backsgbdproject.repository;

import com.example.backsgbdproject.entity.Game;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface GameRepo extends ElasticsearchRepository<Game, Integer> {
    List<Game> findByGenre(String genre);
}
