package io.github.wendergalan.hateoasproject.model.entities;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@DiscriminatorValue(value = "1")
public class PessoaFisica extends Pessoa {

    @CPF
    private String cpf;
}
