/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.disney.Mapper;

import com.alkemy.disney.Dto.GenreDto;
import com.alkemy.disney.Entity.GenreEntity;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Lautaro
 */
@Controller
public class GenreMapper {

    public GenreEntity genreDto2entity(GenreDto genre) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setImage(genre.getImage());
        genreEntity.setName(genre.getName());
        
        return genreEntity;
    }

    public GenreDto GenreEntity2dto(GenreEntity entity) {
        GenreDto genreDto = new GenreDto();
        genreDto.setId(entity.getId());
        genreDto.setImage(entity.getImage());
        genreDto.setName(entity.getName());
        
        return genreDto;
    }
    
}
