package io.github.wendergalan.hateoasproject.services;

import io.github.wendergalan.hateoasproject.model.entities.PessoaFisica;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface PessoaFisicaService {

    ResponseEntity deleteById(int idPessoa);

    ResponseEntity saveV1(PessoaFisica pessoaFisica, BindingResult result);

    ResponseEntity saveV2(PessoaFisica pessoaFisica, BindingResult result);

    ResponseEntity update(int customerId, PessoaFisica pessoaFisica);

    ResponseEntity getById(int idPessoa);

    ResponseEntity findAllPessoas();
}
