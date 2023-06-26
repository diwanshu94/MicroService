package com.spring.diwanshu.UserService.Service;

import com.spring.diwanshu.UserService.custom.exception.CoustomException;
import com.spring.diwanshu.UserService.entities.Movies;
import com.spring.diwanshu.UserService.entities.Rating;
import com.spring.diwanshu.UserService.entities.User;
import com.spring.diwanshu.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
       return userRepository.save(user);
    }

    private BigDecimal generateRandomId() {

        Random random = new Random();
        int scale = 10;
        int precision = 20;
        BigDecimal randomId = new BigDecimal(random.nextDouble()).setScale(precision, RoundingMode.HALF_UP)
                .setScale(scale, RoundingMode.HALF_UP);

        return randomId;
    }

    @Override
    public User getUser(String userId) {

         User user = userRepository.findById(userId).orElseThrow(() -> new CoustomException("User not found for id : "+userId));
         //fetch ratings
        String url = "http://RATINGSERVICE/rating/userId/"+userId;
        Rating[] userRating = restTemplate.getForObject(url, Rating[].class);
       List<Rating> ratingList = Arrays.stream(userRating).collect(Collectors.toList());
        //fetch each movie
      List<Rating> newRatingList =   ratingList.stream().map(rating -> {
          String movieServiceUrl = "http://MOVIESERVICE/movie/"+rating.getMovieId()  ;
          Movies movies = restTemplate.getForObject(movieServiceUrl, Movies.class);
            rating.setMovie(movies);
            return  rating;
        }).collect(Collectors.toList());

        user.setUserRating(newRatingList);
    return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
