package io.github.wendergalan.personapi.model.mappers;

import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV1;
import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV2;
import io.github.wendergalan.personapi.model.entities.PhysicalPerson;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhysicalPersonMapper {

    PhysicalPersonMapper INSTANCE = Mappers.getMapper(PhysicalPersonMapper.class);

    PhysicalPerson physicalPersonDTOV1ToPhysicalPerson(PhysicalPersonDTOV1 physicalPersonDtoV1);

    PhysicalPerson physicalPersonDTOV2PhysicalPerson(PhysicalPersonDTOV2 physicalPersonDtoV2);
}
