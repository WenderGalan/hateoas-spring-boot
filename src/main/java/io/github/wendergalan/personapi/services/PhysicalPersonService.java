package io.github.wendergalan.personapi.services;

import io.github.wendergalan.personapi.model.entities.PhysicalPerson;
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
     * @param physicalPerson the physical person
     * @param result       the result
     * @return the response entity
     */
    ResponseEntity saveV1(PhysicalPerson physicalPerson, BindingResult result);

    /**
     * Save v 2 response entity.
     *
     * @param physicalPerson the physical person
     * @param result       the result
     * @return the response entity
     */
    ResponseEntity saveV2(PhysicalPerson physicalPerson, BindingResult result);

    /**
     * Update response entity.
     *
     * @param customerId   the customer id
     * @param physicalPerson the physical person
     * @return the response entity
     */
    ResponseEntity update(int customerId, PhysicalPerson physicalPerson);

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
