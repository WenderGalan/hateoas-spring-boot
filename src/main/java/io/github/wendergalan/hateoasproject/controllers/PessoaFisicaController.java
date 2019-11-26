package io.github.wendergalan.hateoasproject.controllers;

import io.github.wendergalan.hateoasproject.model.entities.PessoaFisica;
import io.github.wendergalan.hateoasproject.services.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pessoas_fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @GetMapping("/v1")
    public ResponseEntity findAllPessoas() {
        return pessoaFisicaService.findAllPessoas();
    }

    @GetMapping("/v1/{idPessoaFisica}")
    public ResponseEntity getById(@PathVariable int idPessoaFisica) {
        return pessoaFisicaService.getById(idPessoaFisica);
    }

    @DeleteMapping("/v1/{idPessoaFisica}")
    public ResponseEntity deleteById(@PathVariable int idPessoaFisica) {
        return pessoaFisicaService.deleteById(idPessoaFisica);
    }

    @PostMapping("/v1")
    public ResponseEntity saveV1(@Valid @RequestBody PessoaFisica pessoaFisica, BindingResult result) {
        return pessoaFisicaService.saveV1(pessoaFisica, result);
    }

    @PutMapping("/v1/{idPessoaFisica}")
    public ResponseEntity update(@PathVariable int idPessoaFisica, @Valid @RequestBody PessoaFisica pessoaFisica) {
        return pessoaFisicaService.update(idPessoaFisica, pessoaFisica);
    }

    @PostMapping("/v2")
    public ResponseEntity saveV2(@Valid @RequestBody PessoaFisica pessoaFisica, BindingResult result) {
        return pessoaFisicaService.saveV2(pessoaFisica, result);
    }

}
