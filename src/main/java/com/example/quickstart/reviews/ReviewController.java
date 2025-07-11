package com.example.quickstart.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviewsByCompany(@PathVariable Long companyId){

        List<Review> reviews = reviewService.getAllReviews(companyId);
        if(reviews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId, reviewId);

        if(review != null){
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> saveReviews(@PathVariable Long companyId, @RequestBody Review review){
        Boolean isAdded = reviewService.saveReview(companyId, review);
        if(isAdded){
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Company not Found", HttpStatus.NOT_FOUND);

        }

    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review){
        Boolean isUpdated = reviewService.updateReview(companyId, reviewId, review);

        if(isUpdated){
            return new ResponseEntity<>("Review Successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Update unsuccessful", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteById(@PathVariable Long companyId, @PathVariable Long reviewId){

        Boolean isDeleted  = reviewService.deleteReview(companyId, reviewId);
        if(isDeleted){
            return new ResponseEntity<>("Review deleted successful", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Unsuccessful", HttpStatus.NOT_FOUND);
    }
}
