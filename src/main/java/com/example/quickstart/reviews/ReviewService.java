package com.example.quickstart.reviews;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    List<Review> getAllReviews(Long companyId);


    Boolean saveReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);

    Boolean updateReview(Long companyId, Long reviewId, Review review);

    Boolean deleteReview(Long companyId, Long reviewId);
}
