package com.alkemy.disney.Controller;

import com.alkemy.disney.Dto.CharacterBasicDto;
import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDto> save(@Valid @RequestBody CharacterDto dto) {
        CharacterDto saved = this.characterService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDto> update(@Valid @RequestBody CharacterDto characterDto,
                                               @PathVariable Long id) {
        CharacterDto updated = characterService.update(characterDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
            characterService.delete(id);
         return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping
    public ResponseEntity<List<CharacterBasicDto>> findByFilters(@RequestParam(required = false) String name,
                                                                 @RequestParam(required = false) String age,
                                                                 @RequestParam(required = false) Set<Long> movieId) {
        List<CharacterBasicDto> dtos = characterService.findByFilters(name, age, movieId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> findById(@PathVariable Long id) {
        CharacterDto result = characterService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
