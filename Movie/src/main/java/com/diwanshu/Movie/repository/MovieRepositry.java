package com.diwanshu.Movie.repository;

import com.diwanshu.Movie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositry extends JpaRepository<Movie, String> {
}
