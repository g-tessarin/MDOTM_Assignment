package com.gtessarin.MDOTM_Assignment.repository;

import com.gtessarin.MDOTM_Assignment.entity.PetEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository {
    List<PetEntity> findAll();

   Optional<PetEntity> findById(Long id);

   void deleteById(Long id);

    PetEntity save(PetEntity petEntity);
}
