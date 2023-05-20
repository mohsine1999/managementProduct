package com.mosine.reviewservice.service;


import com.mosine.reviewservice.model.Review;
import com.mosine.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> findReviewByIdproduct(Long id){
        return reviewRepository.findByIdproduct(id);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review getReview(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Long id, Review review) {
        Review reviewToUpdate = reviewRepository.findById(id).orElseThrow();
        reviewToUpdate.setAuthor(review.getAuthor());
        reviewToUpdate.setSubject(review.getSubject());
        reviewToUpdate.setContent(review.getContent());
        return reviewRepository.save(reviewToUpdate);
    }
}
