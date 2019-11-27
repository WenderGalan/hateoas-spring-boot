package io.github.wendergalan.personapi.model.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class PhysicalPersonDTOV2 {

    private Integer id;

    @Length(min = 1, max = 100)
    @NotNull
    private String name;

    @Length(min = 1, max = 15)
    @NotNull
    private String telephone;

    /**
     * Address can't be null
     */
    @Length(max = 200)
    @NotNull
    private String address;

    @Length(max = 50)
    private String nationality;

    @Length(max = 50)
    private String naturalness;

    @Email
    private String email;

    @CPF
    private String cpf;
}
