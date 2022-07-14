package com.alkemy.disney.Controller;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Mapper.CharacterMapper;
import com.alkemy.disney.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService CharacterService;


    @PostMapping
    public ResponseEntity<CharacterDto> save(@RequestBody CharacterDto dto){

        CharacterDto saved = this.CharacterService.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDto> update(@RequestBody CharacterDto characterDto, @PathVariable Long id){

        CharacterDto updated = CharacterService.update(characterDto, id);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        CharacterService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<CharacterDto>> findAll(){
        List<CharacterDto> dtos = CharacterService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> findById(@PathVariable Long id){
        CharacterDto result = CharacterService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
