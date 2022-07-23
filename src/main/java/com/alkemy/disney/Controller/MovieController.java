package com.alkemy.disney.Controller;

import com.alkemy.disney.Dto.MovieBasicDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/movies")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto> save(@Valid @RequestBody MovieDto movieDto){
        MovieDto saved = movieService.save(movieDto);
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@Valid @RequestBody MovieDto characterDto,
                                           @PathVariable Long id){
        MovieDto updated = movieService.update(characterDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        movieService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*@GetMapping
    public ResponseEntity<List<MovieDto>> findAll(){

        List<MovieDto> dtos = MovieService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> findById(@PathVariable Long id){
        MovieDto result = movieService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping
    public ResponseEntity<List<MovieBasicDto>> findByFilters(@RequestParam(required = false) String title,
                                                        @RequestParam(required = false) String genreId,
                                                        @RequestParam(required = false) String order){

        List<MovieBasicDto> movies = movieService.findByFilters(title, genreId, order);
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    //agregar un personaje a una pelicula
    @PostMapping("{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDto> addCharacter(@PathVariable Long idMovie,
                                                 @PathVariable Long idCharacter){
        MovieDto addCharacter = movieService.addCharacter(idMovie, idCharacter);

        return ResponseEntity.status(HttpStatus.OK).body(addCharacter);
    }

    @DeleteMapping("{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDto> removeCharacter(@PathVariable Long idMovie,
                                                    @PathVariable Long idCharacter){
        MovieDto removeCharacter = movieService.removeCharacter(idMovie, idCharacter);

        return ResponseEntity.status(HttpStatus.OK).body(removeCharacter);
    }




}
