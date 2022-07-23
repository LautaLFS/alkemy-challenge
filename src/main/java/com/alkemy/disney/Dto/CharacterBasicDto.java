package com.alkemy.disney.Dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class CharacterBasicDto {
    @NonNull
    private String name;
    @NonNull
    private String image;
}
