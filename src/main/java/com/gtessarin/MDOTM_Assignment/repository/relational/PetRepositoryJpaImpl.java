package com.gtessarin.MDOTM_Assignment.repository.relational;

import com.gtessarin.MDOTM_Assignment.entity.PetEntity;
import com.gtessarin.MDOTM_Assignment.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("relational")
public class PetRepositoryJpaImpl implements PetRepository {

    @Autowired
    PetJpaRepository petJpaRepository;

    @Override
    public List<PetEntity> findAll() {
        return petJpaRepository.findAll();
    }

    @Override
    public Optional<PetEntity> findById(Long id) {
        return petJpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        petJpaRepository.deleteById(id);
    }

    @Override
    public PetEntity save(PetEntity petEntity) {
        return petJpaRepository.save(petEntity);
    }
}
