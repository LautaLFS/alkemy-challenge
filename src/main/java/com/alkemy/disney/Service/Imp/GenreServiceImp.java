/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Mapper.GenreMapper;
import com.alkemy.disney.Repository.GenreRepository;
import com.alkemy.disney.Service.GenreService;
import com.alkemy.disney.Dto.GenreDto;
import com.alkemy.disney.Entity.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImp implements GenreService {
    @Autowired
    private GenreMapper GenreMapper;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public GenreDto save(GenreDto genre) {
        
        GenreEntity entity = this.GenreMapper.genreDto2entity(genre);
        this.genreRepository.save(entity);
        
        return this.GenreMapper.GenreEntity2dto(entity);
    }
    
    

    


    
    
}
