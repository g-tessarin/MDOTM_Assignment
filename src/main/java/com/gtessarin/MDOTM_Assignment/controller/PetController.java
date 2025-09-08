package com.gtessarin.MDOTM_Assignment.controller;

import com.gtessarin.MDOTM_Assignment.exception.NoPetsFoundException;
import com.gtessarin.MDOTM_Assignment.model.CreatePetRequest;
import com.gtessarin.MDOTM_Assignment.model.PetDto;
import com.gtessarin.MDOTM_Assignment.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.gtessarin.MDOTM_Assignment.api.*;

import java.util.List;

@Service
public class PetController implements PetsApiDelegate {

    @Autowired
    private PetService petService;


    @Override
    public ResponseEntity<PetDto> createPet(CreatePetRequest createPetRequest) {
        try {
            return ResponseEntity.ofNullable(petService.savePet(createPetRequest));
        }catch (Exception e){
            return  ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<PetDto> getPetById(Long id) {
        try {
            return ResponseEntity.of(petService.getPetById(id));
        }catch (NoPetsFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }


    @Override
    public ResponseEntity<Void> deletePet(Long id) {
        try {
            petService.deletePet(id);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<PetDto>> listPets() {
        try {
            return ResponseEntity.ok( petService.listPets());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }

    @Override
    public ResponseEntity<PetDto> updatePet(Long id, PetDto petDto) {
        try {
            return ResponseEntity.ofNullable(petService.updatePet(id, petDto));
        }catch (NoPetsFoundException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
