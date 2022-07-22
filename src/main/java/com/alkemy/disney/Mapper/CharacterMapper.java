package com.alkemy.disney.Mapper;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Entity.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class CharacterMapper {
    @Autowired
        private MovieMapper movieMapper;
    public CharacterEntity characterDto2Entity(CharacterDto dto) {
        CharacterEntity entity = new CharacterEntity();
        loadEntity(entity, dto);
        return entity;
    }
    public CharacterDto characterEntity2Dto(CharacterEntity entitySaved, boolean loadMovies) {
        CharacterDto dto = new CharacterDto();
        dto.setId(entitySaved.getId());
        dto.setImage(entitySaved.getImage());
        dto.setName(entitySaved.getName());
        dto.setAge(entitySaved.getAge());
        dto.setHistory(entitySaved.getHistory());
        dto.setWeight(entitySaved.getWeight());
        if (loadMovies) {
            dto.setMovies(movieMapper.movieEntity2DTOSet(entitySaved.getMovies(), false));
        }
        return dto;
    }

    public List<CharacterDto> characterEntity2DtoList(List<CharacterEntity> entities, boolean loadMovies) {
        List<CharacterDto> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtos.add(characterEntity2Dto(entity, loadMovies));
        }
        return dtos;
    }
    public Set<CharacterDto> addCharactersDTO(Set<CharacterEntity> characters, boolean loadMovies) {
        Set<CharacterDto> added = new HashSet<>();
        for (CharacterEntity character : characters) {
            added.add(characterEntity2Dto(character, loadMovies));
        }
        return added;
    }
    public CharacterEntity loadEntity(CharacterEntity entity, CharacterDto dto){
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setHistory(dto.getHistory());
        entity.setWeight(dto.getWeight());
        return entity;
    }

}
