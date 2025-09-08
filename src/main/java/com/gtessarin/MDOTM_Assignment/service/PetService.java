package com.gtessarin.MDOTM_Assignment.service;

import com.gtessarin.MDOTM_Assignment.entity.PetEntity;
import com.gtessarin.MDOTM_Assignment.mapper.PetMapper;
import com.gtessarin.MDOTM_Assignment.model.CreatePetRequest;
import com.gtessarin.MDOTM_Assignment.model.PetDto;
import com.gtessarin.MDOTM_Assignment.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Autowired
    PetRepository repository;
    @Autowired
    PetMapper petMapper;

    @Transactional
    public Optional<PetDto> getPetById(Long id) {
        return Optional.ofNullable(petMapper.entityToDto(repository.findById(id).orElse(null)));
    }

    @Transactional
    public PetDto savePet(CreatePetRequest request) {
        return petMapper.entityToDto(repository.save(petMapper.createRequestToEntity(request)));
    }

    @Transactional
    public List<PetDto> listPets() {
        return repository.findAll()
                .stream()
                .map(petEntity -> petMapper.entityToDto(petEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePet(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public PetDto updatePet(Long id, PetDto petDto) {
        PetEntity oldPet = repository.findById(id).orElseThrow();
        PetEntity newPet = petMapper.patchEntity(petDto, oldPet);
       return petMapper.entityToDto( repository.save(newPet));
    }

}