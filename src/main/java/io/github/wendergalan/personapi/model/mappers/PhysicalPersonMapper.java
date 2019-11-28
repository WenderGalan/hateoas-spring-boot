package io.github.wendergalan.personapi.model.mappers;

import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV1;
import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV2;
import io.github.wendergalan.personapi.model.entities.PhysicalPerson;
import org.mapstruct.Mapper;

/**
 * The interface Physical person mapper.
 */
@Mapper(componentModel = "spring")
public interface PhysicalPersonMapper {

    /**
     * Physical person dtov 1 to physical person physical person.
     *
     * @param physicalPersonDtoV1 the physical person dto v 1
     * @return the physical person
     */
    PhysicalPerson physicalPersonDTOV1ToPhysicalPerson(PhysicalPersonDTOV1 physicalPersonDtoV1);

    /**
     * Physical person dtov 2 to physical person physical person.
     *
     * @param physicalPersonDtoV2 the physical person dto v 2
     * @return the physical person
     */
    PhysicalPerson physicalPersonDTOV2ToPhysicalPerson(PhysicalPersonDTOV2 physicalPersonDtoV2);
}
