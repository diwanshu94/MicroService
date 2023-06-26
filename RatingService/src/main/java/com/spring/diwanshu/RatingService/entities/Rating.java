package com.spring.diwanshu.RatingService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rating")
public class Rating {

    @Id
    @Column(name = "rating_id")
    private String ratingId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "movie_id")
    private String movieId;
    @Column(name = "rate")
    private int rate;
    @Column(name = "comment")
    private String comment;

}
