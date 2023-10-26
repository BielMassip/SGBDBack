package com.example.backsgbdproject.repository;

import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.entity.Review;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ReviewRepo extends ElasticsearchRepository<Review, Integer> {
}
