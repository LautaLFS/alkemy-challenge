package com.alkemy.disney.Mapper;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Entity.CharacterEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CharacterMapper {
    public CharacterEntity characterDto2Entity(CharacterDto dto) {
        CharacterEntity entity = new CharacterEntity();
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setHistory(dto.getHistory());
        entity.setWeight(dto.getWeight());


        return entity;
    }

    public CharacterDto characterEntity2Dto(CharacterEntity entitySaved) {

        CharacterDto dto = new CharacterDto();
        dto.setId(entitySaved.getId());
        dto.setImage(entitySaved.getImage());
        dto.setName(entitySaved.getName());
        dto.setAge(entitySaved.getAge());
        dto.setHistory(entitySaved.getHistory());
        dto.setWeight(entitySaved.getWeight());


        return dto;
    }

    public List<CharacterDto> characterEntity2DtoList(List<CharacterEntity> finds) {
        List<CharacterDto> dtos = new ArrayList<>();

        for (CharacterEntity find : finds){
            dtos.add(characterEntity2Dto(find));
        }
        return dtos;
    }
}
