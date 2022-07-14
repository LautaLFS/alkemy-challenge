/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.disney.Controller;

import com.alkemy.disney.Dto.GenreDto;
import com.alkemy.disney.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private com.alkemy.disney.Service.GenreService GenreService;
    
    //POST-SAVE
    @PostMapping
    public ResponseEntity<GenreDto> saveEntity(@RequestBody GenreDto genreDto){
    
        GenreDto savedGenre = this.GenreService.save(genreDto);
        return ResponseEntity.status(HttpStatus.OK).body(savedGenre);
    }
}
