package com.alkemy.disney.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Long id;
    @NonNull
    private String image;
    @NonNull
    private String title;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date date;
    @Min(1)
    @Max(5)
    private int rate;
    //genre_id
    private Long genre;
    private Set<CharacterDto> characters = new HashSet<>();



}
