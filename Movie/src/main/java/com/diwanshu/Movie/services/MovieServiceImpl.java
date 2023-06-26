package com.diwanshu.Movie.services;

import com.diwanshu.Movie.common.DataNotFoundException;
import com.diwanshu.Movie.entities.Movie;
import com.diwanshu.Movie.repository.MovieRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepositry movieRepositry;

    @Override
    public Movie createMovie(Movie movie) {
        String randomId = UUID.randomUUID().toString();
        movie.setMovieId(randomId);
        return movieRepositry.save(movie);
    }

    @Override
    public List<Movie> getAllMovieList() {
        return movieRepositry.findAll();
    }

    @Override
    public Movie getMovieById(String id) {
        return movieRepositry.findById(id).orElseThrow(()->new DataNotFoundException("There is no Data Available for Movie Id : "+id));
    }
}
