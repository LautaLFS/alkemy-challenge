package com.alkemy.disney.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class MovieBasicDto {
    private String image;
    private String title;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;
}
