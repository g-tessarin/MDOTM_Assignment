package com.gtessarin.MDOTM_Assignment.repository.relational;


import com.gtessarin.MDOTM_Assignment.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJpaRepository extends JpaRepository<PetEntity, Long> {
}
