package com.diwanshu.Movie.controller;

import com.diwanshu.Movie.entities.Movie;
import com.diwanshu.Movie.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    Logger logger = LoggerFactory.getLogger(MovieController.class);
    @Autowired
    private MovieService movieService;

    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        logger.info("Movie : "+movie.getMovieName());
        logger.info("Movie : "+movie.getMovieDesc());
        Movie response = movieService.createMovie(movie);
        return  new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getAllMovieList(){
        List<Movie> response = movieService.getAllMovieList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("movieId") String movieId){
        Movie response = movieService.getMovieById(movieId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
