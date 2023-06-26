package com.spring.diwanshu.RatingService.repositories;

import com.spring.diwanshu.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

    List<Rating> findByUserId(String userId);

    List<Rating> findByMovieId(String movieId);
}
