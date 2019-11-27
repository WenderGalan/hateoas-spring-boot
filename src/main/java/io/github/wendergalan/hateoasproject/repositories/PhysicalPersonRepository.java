package io.github.wendergalan.hateoasproject.repositories;

import io.github.wendergalan.hateoasproject.model.entities.PhysicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Physical person repository.
 */
@Repository
public interface PhysicalPersonRepository extends JpaRepository<PhysicalPerson, Integer> {
}
