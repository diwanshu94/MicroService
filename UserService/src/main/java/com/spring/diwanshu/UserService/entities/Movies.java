package com.spring.diwanshu.UserService.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movies {


    private String movieId;

    private String movieName;

    private String movieDesc;
}
