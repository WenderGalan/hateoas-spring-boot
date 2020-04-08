package io.github.wendergalan.personapi.models.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The type Physical person.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@DiscriminatorValue(value = "1")
public class PhysicalPerson extends Person {

    @CPF
    private String cpf;
}
