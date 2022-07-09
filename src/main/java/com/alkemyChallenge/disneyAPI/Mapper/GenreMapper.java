/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemyChallenge.disneyAPI.Mapper;

import com.alkemyChallenge.disneyAPI.Dto.GenreDto;
import com.alkemyChallenge.disneyAPI.Entity.GenreEntity;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Lautaro
 */
@Controller
public class GenreMapper {

    public GenreEntity dto2entity(GenreDto genre) {
        
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setImage(genre.getImage());
        genreEntity.setName(genre.getName());
        
        return genreEntity;
    }

    public GenreDto entity2dto(GenreEntity entity) {
        
        GenreDto genreDto = new GenreDto();
        genreDto.setId(entity.getId());
        genreDto.setImage(entity.getImage());
        genreDto.setName(entity.getName());
        
        return genreDto;
    }
    
}
