package com.mosine.reviewservice.controller;

import com.mosine.reviewservice.model.Review;
import com.mosine.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@RequestBody Review reviewRequest) {

        reviewService.addReview(reviewRequest);
    }
    @GetMapping("/produit/{id}")
    public List<Review> findReviewByIdproduct(@PathVariable Long id) {
    return reviewService.findReviewByIdproduct(id);
    }
        @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Review getReview(@PathVariable Long id) {
        return reviewService.getReview(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
