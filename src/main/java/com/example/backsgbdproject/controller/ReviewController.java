package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.entity.Review;
import com.example.backsgbdproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/findAll")
    Iterable<Review> findAll(){
        return reviewService.getReviews();
    }

    @PostMapping("/insert")
    Review insertReview(@RequestBody Review review){
        return reviewService.insertReview(review);
    }

    @PutMapping("/update")
    Review updateReview(@RequestBody Review review){
        return reviewService.updateReview(review, review.getId());
    }
    @DeleteMapping("/delete/{id}")
    void deleteReview(@PathVariable int id){
        reviewService.deleteReview(id);
    }
}