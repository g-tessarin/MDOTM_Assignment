package com.gtessarin.MDOTM_Assignment.mapper;

import com.gtessarin.MDOTM_Assignment.entity.PetEntity;
import com.gtessarin.MDOTM_Assignment.model.CreatePetRequest;
import com.gtessarin.MDOTM_Assignment.model.PetDto;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetDto entityToDto (PetEntity petEntity);

    PetEntity createRequestToEntity(CreatePetRequest petRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PetEntity patchEntity(PetDto inputDto, @MappingTarget PetEntity petEntity);
}
