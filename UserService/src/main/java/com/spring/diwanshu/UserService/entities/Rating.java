package com.spring.diwanshu.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.servlet.ModelAndView;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    String ratingId;

    private String userId;

    private String movieId;

    private int rate;

    private String comment;

    private Movies movie;
}
