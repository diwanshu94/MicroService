package com.diwanshu.Movie.services;

import com.diwanshu.Movie.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    // Create Movie

    Movie createMovie(Movie movie);

    //Get All Movie

    List<Movie> getAllMovieList();

    // Get Single Movie
    Movie getMovieById(String id);
}
