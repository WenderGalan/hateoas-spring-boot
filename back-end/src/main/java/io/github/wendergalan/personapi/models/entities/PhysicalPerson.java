package io.github.wendergalan.personapi.models.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

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

    //    @CPF
    private String cpf;

    /**
     * @param name
     * @return
     */
    public static PhysicalPerson generatePhysicalPerson(String name) {
        PhysicalPerson physicalPerson = new PhysicalPerson();
        physicalPerson.setName(name);
        physicalPerson.setCpf("000.000.000-99");
        physicalPerson.setDateOfBirth(LocalDate.now().minusYears(18).minusDays(20).minusMonths(4));
        physicalPerson.setEmail("contato@email.com.br");
        physicalPerson.setNaturalness("Campo Grande - MS");
        physicalPerson.setNationality("Brazil");
        physicalPerson.setTelephone("(67) 99999-****");
    return physicalPerson;
    }
}
