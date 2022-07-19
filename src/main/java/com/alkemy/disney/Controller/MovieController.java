package com.alkemy.disney.Controller;

import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.MovieEntity;
import com.alkemy.disney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    private MovieService MovieService;

    @PostMapping
    public ResponseEntity<MovieDto> save(@RequestBody MovieDto movieDto){

        MovieDto saved = MovieService.save(movieDto);

        return ResponseEntity.status(HttpStatus.OK).body(saved);

    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@RequestBody MovieDto characterDto, @PathVariable Long id){

        MovieDto updated = MovieService.update(characterDto, id);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        MovieService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*@GetMapping
    public ResponseEntity<List<MovieDto>> findAll(){

        List<MovieDto> dtos = MovieService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id){

        MovieDto result = MovieService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping
    public ResponseEntity<List<MovieDto>> findByFilters(@RequestParam(required = false) String title,
                                                           @RequestParam(required = false) String genreId,
                                                           @RequestParam(required = false) String order){

        List<MovieDto> movies = MovieService.findByFilters(title, genreId, order);
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    //agregar un personaje a una pelicula
    @PostMapping("{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDto> addCharacter(@PathVariable Long idMovie,
                                                 @PathVariable Long idCharacter){
        MovieDto addCharacter = MovieService.addCharacter(idMovie, idCharacter);

        return ResponseEntity.status(HttpStatus.OK).body(addCharacter);
    }

    @DeleteMapping("{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDto> removeCharacter(@PathVariable Long idMovie,
                                                 @PathVariable Long idCharacter){
        MovieDto removeCharacter = MovieService.removeCharacter(idMovie, idCharacter);

        return ResponseEntity.status(HttpStatus.OK).body(removeCharacter);
    }




}
