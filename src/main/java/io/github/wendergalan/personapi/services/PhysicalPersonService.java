package io.github.wendergalan.personapi.services;

import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV1;
import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * The interface Physical person service.
 */
public interface PhysicalPersonService {

    /**
     * Delete by id response entity.
     *
     * @param idPhysicalPerson the id physical person
     * @return the response entity
     */
    ResponseEntity deleteById(int idPhysicalPerson);

    /**
     * Save v 1 response entity.
     *
     * @param physicalPersonDtoV1 the physical person
     * @param result              the result
     * @return the response entity
     */
    ResponseEntity saveV1(PhysicalPersonDTOV1 physicalPersonDtoV1, BindingResult result);

    /**
     * Save v 2 response entity.
     *
     * @param physicalPersonDtoV2 the physical person
     * @param result              the result
     * @return the response entity
     */
    ResponseEntity saveV2(PhysicalPersonDTOV2 physicalPersonDtoV2, BindingResult result);

    /**
     * Update response entity.
     *
     * @param customerId     the customer id
     * @param physicalPersonDTOV1 the physical person
     * @return the response entity
     */
    ResponseEntity updateV1(int customerId, PhysicalPersonDTOV1 physicalPersonDTOV1);

    /**
     * Update response entity.
     *
     * @param customerId     the customer id
     * @param physicalPersonDTOV2 the physical person
     * @return the response entity
     */
    ResponseEntity updateV2(int customerId, PhysicalPersonDTOV2 physicalPersonDTOV2);

    /**
     * Gets by id.
     *
     * @param idPhysicalPerson the id physical person
     * @return the by id
     */
    ResponseEntity getById(int idPhysicalPerson);

    /**
     * Find all people response entity.
     *
     * @return the response entity
     */
    ResponseEntity findAllPeople();
}
