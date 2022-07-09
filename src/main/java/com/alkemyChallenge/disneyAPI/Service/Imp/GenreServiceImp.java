/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemyChallenge.disneyAPI.Service.Imp;

import com.alkemyChallenge.disneyAPI.Dto.GenreDto;
import com.alkemyChallenge.disneyAPI.Entity.GenreEntity;
import com.alkemyChallenge.disneyAPI.Mapper.GenreMapper;
import com.alkemyChallenge.disneyAPI.Repository.GenreRepository;
import com.alkemyChallenge.disneyAPI.Service.GenreService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImp implements GenreService{
    @Autowired
    private GenreMapper GenreMapper;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDto save(GenreDto genre) {
        
        GenreEntity entity = this.GenreMapper.dto2entity(genre);
        this.genreRepository.save(entity);
        GenreDto dto = this.GenreMapper.entity2dto(entity);
        
        return dto;
    }
    
    

    


    
    
}
