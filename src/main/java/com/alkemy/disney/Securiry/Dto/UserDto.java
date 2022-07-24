package com.alkemy.disney.Securiry.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Getter
@Setter

public class UserDto {

    private String username;
    @Size(min = 8,message = "Password needs to be more than 8 characters")
    private String password;
}
