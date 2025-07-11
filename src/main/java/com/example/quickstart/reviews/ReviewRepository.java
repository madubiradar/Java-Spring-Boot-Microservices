package com.example.quickstart.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

//    @Query(nativeQuery = true,
//    value = "select * from Company where id = :")
    List<Review> findByCompanyId(Long companyId);
}
