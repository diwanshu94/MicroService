package com.spring.diwanshu.RatingService.service;

import com.spring.diwanshu.RatingService.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    //Add new rating
    Rating createRating(Rating rating);


    //get Rating

    Rating getRatingById(String ratingId);

    //get Rating by UserId
    List<Rating> getRatingByUserId(String userId);

    //get All rating
    List<Rating> getAllRating();

    //get Rating by Movie Id

    List<Rating> getRatingByMovieId(String movieId);
}
