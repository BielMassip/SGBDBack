package com.example.backsgbdproject.repository;

import com.example.backsgbdproject.entity.Game;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepo extends ElasticsearchRepository<Game, String> {
    List<Game> findByGenre(String genre);

    List<Game> findByName(String name);

    List<Game> findByCompany(String company);

    List<Game> findByRatingGreaterThanEqual(int rating);

    List<Game> findByRating(int rating);

    List<Game> findByPriceLessThanEqual(double price);

    Optional<Game> findById(String id);
}
