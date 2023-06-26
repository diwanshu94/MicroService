package com.diwanshu.Movie.common;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponse {

    String message;

    boolean success;

    HttpStatus status;
}
