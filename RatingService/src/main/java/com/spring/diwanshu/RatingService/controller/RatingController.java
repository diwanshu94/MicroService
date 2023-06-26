package com.spring.diwanshu.RatingService.controller;

import com.spring.diwanshu.RatingService.entities.Rating;
import com.spring.diwanshu.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){

       Rating ratingResponse = ratingService.createRating(rating);

       return new ResponseEntity<>(ratingResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> getAllRating(){

        List<Rating> ratings = ratingService.getAllRating();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId){
        List<Rating> ratings = ratingService.getRatingByUserId(userId);

        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/movieId/{movieId}")
    public ResponseEntity<List<Rating>> getRatingByMovieId(@PathVariable("movieId") String movieId){
        List<Rating> ratings = ratingService.getRatingByMovieId(movieId);

        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("ratingId") String ratingId){
        Rating ratings = ratingService.getRatingById(ratingId);

        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
