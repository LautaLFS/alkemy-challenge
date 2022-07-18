package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Dto.CharacterFiltersDto;
import com.alkemy.disney.Dto.MovieDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Entity.MovieEntity;
import com.alkemy.disney.Mapper.CharacterMapper;
import com.alkemy.disney.Mapper.MovieMapper;
import com.alkemy.disney.Repository.CharacterRepository;
import com.alkemy.disney.Repository.Specification.CharacterSpecification;
import com.alkemy.disney.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service

public class CharacterServiceImp implements CharacterService {
    @Autowired
    private CharacterMapper CharacterMapper;
    @Autowired
    private CharacterRepository CharacterRepository;

    @Autowired
    private CharacterSpecification CharacterSpecification;


    //TODO: AGREGAR SI CARGAR O NO LAS PELICULAS
    @Override
    public CharacterDto save(CharacterDto dto) {
        CharacterEntity characterEntity = CharacterMapper.characterDto2Entity(dto);
        CharacterEntity entitySaved = this.CharacterRepository.save(characterEntity);
        return this.CharacterMapper.characterEntity2Dto(entitySaved, false);
    }

    @Override
    public CharacterDto update(CharacterDto characterDto, Long id) {

        CharacterEntity entity = CharacterRepository.getById(id);

        entity.setWeight(characterDto.getWeight());
        entity.setName(characterDto.getName());
        entity.setHistory(characterDto.getHistory());
        entity.setImage(characterDto.getImage());
        entity.setAge(characterDto.getAge());


        return CharacterMapper.characterEntity2Dto(CharacterRepository.save(entity), true);
    }

    @Override
    public void delete(Long id) {
        CharacterEntity entity = CharacterRepository.getById(id);
        CharacterRepository.delete(entity);

    }

    @Override
    public List<CharacterDto> findAll() {
        List<CharacterEntity> entities = CharacterRepository.findAll();
        return CharacterMapper.characterEntity2DtoList(entities, true);
    }
    @Override
    public CharacterDto findById(Long id) {
        CharacterEntity found = CharacterRepository.getById(id);
        return CharacterMapper.characterEntity2Dto(found, true);
    }

    @Override
    public List<CharacterDto> findByFilters(String name, String age, Set<Long> movieId) {

        CharacterFiltersDto filtersDto = new CharacterFiltersDto(movieId, name, age);
        List<CharacterEntity> entities = CharacterRepository.findAll(CharacterSpecification.getByFilters(filtersDto));

        return CharacterMapper.characterEntity2DtoList(entities, true);
    }

}
