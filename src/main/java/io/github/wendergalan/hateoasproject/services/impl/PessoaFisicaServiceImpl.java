package io.github.wendergalan.hateoasproject.services.impl;

import io.github.wendergalan.hateoasproject.controllers.PessoaFisicaController;
import io.github.wendergalan.hateoasproject.model.entities.PessoaFisica;
import io.github.wendergalan.hateoasproject.repositories.PessoaFisicaRepository;
import io.github.wendergalan.hateoasproject.services.PessoaFisicaService;
import io.github.wendergalan.hateoasproject.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Override
    public ResponseEntity deleteById(int idPessoa) {
        pessoaFisicaRepository.deleteById(idPessoa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity saveV1(PessoaFisica pessoaFisica, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().body(Util.criarListaDeErrosDaValidacao(result.getAllErrors()));

        pessoaFisicaRepository.save(pessoaFisica);

        // Add HATEOAS
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).saveV1(pessoaFisica, null)).withSelfRel().withType(HttpMethod.POST.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).deleteById(pessoaFisica.getId())).withRel("delete").withType(HttpMethod.DELETE.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).getById(pessoaFisica.getId())).withRel("details").withType(HttpMethod.GET.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).findAllPessoas()).withRel("find-all").withType(HttpMethod.GET.toString()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisica);
    }

    @Override
    public ResponseEntity saveV2(PessoaFisica pessoaFisica, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().body(Util.criarListaDeErrosDaValidacao(result.getAllErrors()));

        pessoaFisicaRepository.save(pessoaFisica);

        // Add HATEOAS
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).saveV2(pessoaFisica, null)).withSelfRel().withType(HttpMethod.POST.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).deleteById(pessoaFisica.getId())).withRel("delete").withType(HttpMethod.DELETE.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).getById(pessoaFisica.getId())).withRel("details").withType(HttpMethod.GET.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).findAllPessoas()).withRel("find-all").withType(HttpMethod.GET.toString()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisica);
    }

    @Override
    public ResponseEntity update(int idPessoa, PessoaFisica pessoaFisica) {
        pessoaFisica.setId(idPessoa);

        // Add HATEOAS
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).getById(idPessoa)).withSelfRel().withType(HttpMethod.PUT.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).deleteById(idPessoa)).withRel("delete").withType(HttpMethod.DELETE.toString()));
        pessoaFisica.add(linkTo(methodOn(PessoaFisicaController.class).findAllPessoas()).withRel("find-all").withType(HttpMethod.GET.toString()));

        pessoaFisicaRepository.save(pessoaFisica);
        return ResponseEntity.ok(pessoaFisica);
    }

    @Override
    public ResponseEntity getById(int idPessoa) {
        Optional<PessoaFisica> pf = pessoaFisicaRepository.findById(idPessoa);

        if (!pf.isPresent())
            return ResponseEntity.notFound().build();

        // Add HATEOAS
        pf.get().add(linkTo(methodOn(PessoaFisicaController.class).getById(idPessoa)).withSelfRel().withType(HttpMethod.GET.toString()));
        pf.get().add(linkTo(methodOn(PessoaFisicaController.class).findAllPessoas()).withRel("find-all").withType(HttpMethod.GET.toString()));
        pf.get().add(linkTo(methodOn(PessoaFisicaController.class).deleteById(idPessoa)).withRel("delete").withType(HttpMethod.DELETE.toString()));

        return ResponseEntity.ok(pf);
    }

    @Override
    public ResponseEntity findAllPessoas() {
        List<PessoaFisica> pessoasFisicas = pessoaFisicaRepository.findAll();
        pessoasFisicas.forEach(pf -> {
            // Add HATEOAS
            pf.add(linkTo(methodOn(PessoaFisicaController.class).findAllPessoas()).withSelfRel().withType(HttpMethod.GET.toString()));
            pf.add(linkTo(methodOn(PessoaFisicaController.class).getById(pf.getId())).withRel("details").withType(HttpMethod.GET.toString()));
            pf.add(linkTo(methodOn(PessoaFisicaController.class).deleteById(pf.getId())).withRel("delete").withType(HttpMethod.DELETE.toString()));
            pf.add(linkTo(methodOn(PessoaFisicaController.class).update(pf.getId(), pf)).withRel("update").withType(HttpMethod.PUT.toString()));
        });
        return ResponseEntity.ok(pessoasFisicas);
    }

}
