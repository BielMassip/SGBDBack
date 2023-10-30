package com.example.backsgbdproject.repository;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.entity.Review;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ReviewRepo extends ElasticsearchRepository<Review, Integer> {
    List<Review> findByGameId(Long gameId);
}
