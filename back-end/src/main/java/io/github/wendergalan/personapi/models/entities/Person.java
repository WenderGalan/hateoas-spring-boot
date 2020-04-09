package io.github.wendergalan.personapi.models.entities;

import io.github.wendergalan.personapi.annotations.adult.Adult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * The type Person.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "person", schema = "public")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 1, discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Person extends RepresentationModel {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "name", nullable = false)
    @Length(min = 1, max = 100)
    @NotNull
    private String name;

    @Column(name = "telephone", nullable = false)
    @Length(min = 1, max = 15)
    @NotNull
    private String telephone;

    @Column(name = "address", length = 200)
    @Length(max = 200)
    private String address;

    @Column(name = "nationality", length = 50)
    @Length(max = 50)
    private String nationality;

    @Adult
    @NotNull
    private LocalDate dateOfBirth;

    @Column(name = "naturalness", length = 50)
    @Length(max = 50)
    private String naturalness;

    // @Email
    private String email;
}
