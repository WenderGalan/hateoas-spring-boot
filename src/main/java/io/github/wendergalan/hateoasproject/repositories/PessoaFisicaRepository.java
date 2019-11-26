package io.github.wendergalan.hateoasproject.repositories;

import io.github.wendergalan.hateoasproject.model.entities.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Integer> {
}
