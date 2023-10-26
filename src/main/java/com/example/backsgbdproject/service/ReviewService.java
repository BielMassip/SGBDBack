package com.example.backsgbdproject.service;

import com.example.backsgbdproject.entity.Review;
import com.example.backsgbdproject.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

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