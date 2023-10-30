package com.example.backsgbdproject.service;

import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.example.backsgbdproject.entity.Game;
import com.example.backsgbdproject.entity.Review;
import com.example.backsgbdproject.repository.ReviewRepo;
import org.elasticsearch.client.RequestOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private GameService gameService;

    public Iterable<Review> getReviews(){
        return reviewRepo.findAll();
    }

    public Review insertReview(Review review){
        return reviewRepo.save(review);
    }

    public Review updateReview(Review review, int id){
        Review review1 = reviewRepo.findById(id).get();
        review1.setComment(review.getComment());
        review1.setRating(review.getRating());
        review1.setLike(review.getLike());
        reviewRepo.save(review1);
        return review1;
    }

    public void deleteReview(int id){
        reviewRepo.deleteById(id);
    }
}