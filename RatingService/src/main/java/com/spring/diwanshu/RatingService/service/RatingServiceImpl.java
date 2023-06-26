package com.spring.diwanshu.RatingService.service;

import com.spring.diwanshu.RatingService.customException.DataNotFoundException;
import com.spring.diwanshu.RatingService.entities.Rating;
import com.spring.diwanshu.RatingService.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements  RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new DataNotFoundException("Data Not Found for Rating Id : "+ratingId));
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByMovieId(String movieId) {
        return ratingRepository.findByMovieId(movieId);
    }
}
