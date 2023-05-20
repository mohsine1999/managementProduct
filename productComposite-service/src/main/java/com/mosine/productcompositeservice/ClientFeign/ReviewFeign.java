package com.mosine.productcompositeservice.ClientFeign;


import com.mosine.productcompositeservice.models.Product;
import com.mosine.productcompositeservice.models.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(value = "review-service")
public interface ReviewFeign {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@RequestBody Review reviewRequest);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Review getReview(@PathVariable Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id);

   @GetMapping("/api/reviews/produit/{id}")
   public List<Review> findReviewByIdproduct(@PathVariable Long id) ;
}
