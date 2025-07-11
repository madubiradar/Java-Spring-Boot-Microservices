package com.example.quickstart.reviews;

import com.example.quickstart.company.Company;
import com.example.quickstart.company.CompanyService;
import com.example.quickstart.company.CompanyServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Boolean saveReview(Long companyId, Review review) {
        Company company = companyService.getCompanyId(companyId);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Company company = companyService.getCompanyId(companyId);
        if(company != null){
            updatedReview.setId(reviewId);
            updatedReview.setCompany(company);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteReview(Long companyId, Long reviewId) {
        Company company = companyService.getCompanyId(companyId);

        if( company != null && reviewRepository.existsById(reviewId)){

            Review review = reviewRepository.findById(reviewId).orElse(null);

            Company company1 = review.getCompany();

            company1.getReviews().remove(review);

            review.setCompany(null);

            companyService.updateCompany(companyId, company);

            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

}
