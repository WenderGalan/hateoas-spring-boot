package io.github.wendergalan.hateoasproject.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "pessoa", schema = "public")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Pessoa extends RepresentationModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @NotNull
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "nome", nullable = false)
    @Length(min = 1, max = 100)
    @NotNull
    private String nome;

    @Column(name = "telefone", nullable = false)
    @Length(min = 1, max = 15)
    @NotNull
    private String telefone;

    @Column(name = "endereco", length = 200)
    @Length(max = 200)
    @NotNull
    private String endereco;

    @Column(name = "nacionalidade", length = 50)
    @Length(max = 50)
    private String nacionalidade;

    @Column(name = "naturalidade", length = 50)
    @Length(max = 50)
    private String naturalidade;

    @Email
    private String email;
}
