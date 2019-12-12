package io.github.wendergalan.personapi.models.dtos;

import io.github.wendergalan.personapi.annotations.adult.Adult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * The type Physical person dtov 1.
 */
@Data
@ApiModel(value = "Physical Person DTO V1", description = "Model Physical Person DTO V1")
public class PhysicalPersonDTOV1 {

    @ApiModelProperty(value = "The unique identifier of the physical person", required = true)
    private Integer id;

    @ApiModelProperty(value = "Name of Physical Person", required = true)
    @Length(min = 1, max = 100)
    @NotNull
    private String name;

    @ApiModelProperty(value = "Telephone of Physical Person", required = true)
    @Length(min = 1, max = 15)
    @NotNull
    private String telephone;

    /**
     * Address can be null
     */
    @ApiModelProperty(value = "Telephone of Physical Person")
    @Length(max = 200)
    private String address;

    @ApiModelProperty(value = "Nationality of Physical Person")
    @Length(max = 50)
    private String nationality;

    @ApiModelProperty(value = "Date of Birth of Physical Person")
    @Adult
    @NotNull
    private LocalDate dateOfBirth;

    @ApiModelProperty(value = "Naturaless of Physical Person")
    @Length(max = 50)
    private String naturalness;

    @ApiModelProperty(value = "Email of Physical Person")
    @Email
    private String email;

    @ApiModelProperty(value = "CPF of Physical Person")
    @CPF
    private String cpf;
}
