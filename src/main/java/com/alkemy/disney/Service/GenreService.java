/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alkemy.disney.Service;

import com.alkemy.disney.Dto.GenreDto;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lautaro
 */
@Service
public interface GenreService {
    
    public GenreDto save(GenreDto genre);
}
