/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemyChallenge.disneyAPI.Controller;

import com.alkemyChallenge.disneyAPI.Dto.GenreDto;
import com.alkemyChallenge.disneyAPI.Service.GenreService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreService GenreService;
    
    //POST-SAVE
    @PostMapping
    public ResponseEntity<GenreDto> saveEntity(@RequestBody GenreDto genreDto){
    
        GenreDto allGenre = this.GenreService.save(genreDto);
        return ResponseEntity.status(HttpStatus.OK).body(allGenre);
    }
}
