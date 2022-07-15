package com.alkemy.disney.Service.Imp;

import com.alkemy.disney.Dto.CharacterDto;
import com.alkemy.disney.Entity.CharacterEntity;
import com.alkemy.disney.Mapper.CharacterMapper;
import com.alkemy.disney.Repository.CharacterRepository;
import com.alkemy.disney.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CharacterServiceImp implements CharacterService {
    @Autowired
    private CharacterMapper CharacterMapper;
    @Autowired
    private CharacterRepository CharacterRepository;

    //TODO: AGREGAR SI CARGAR O NO LAS PELICULAS
    @Override
    public CharacterDto save(CharacterDto dto) {
        CharacterEntity characterEntity = CharacterMapper.characterDto2Entity(dto);
        CharacterEntity entitySaved = this.CharacterRepository.save(characterEntity);
        return this.CharacterMapper.characterEntity2Dto(entitySaved, false);
    }

    @Override
    public CharacterDto update(CharacterDto characterDto, Long id) {

        CharacterEntity entity = CharacterRepository.getReferenceById(id);

        entity.setWeight(characterDto.getWeight());
        entity.setName(characterDto.getName());
        entity.setHistory(characterDto.getHistory());
        entity.setImage(characterDto.getImage());
        entity.setAge(characterDto.getAge());

        return CharacterMapper.characterEntity2Dto(CharacterRepository.save(entity), false);
    }

    @Override
    public void delete(Long id) {
        CharacterEntity entity = CharacterRepository.getReferenceById(id);
        CharacterRepository.delete(entity);

    }

    @Override
    public List<CharacterDto> findAll() {
        List<CharacterEntity> entities = CharacterRepository.findAll();
        return CharacterMapper.characterEntity2DtoList(entities, true);
    }

    @Override
    public CharacterDto findById(Long id) {
        CharacterEntity found = CharacterRepository.getReferenceById(id);
        return CharacterMapper.characterEntity2Dto(found, true);
    }

}
