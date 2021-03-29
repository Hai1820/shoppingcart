package com.myclass.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Size
@ToString
public class JWTLoginSuccessResponse {
    private boolean success;
    private String token;

}
