package io.github.wendergalan.personapi.services.impl;

import io.github.wendergalan.personapi.controllers.PhysicalPersonController;
import io.github.wendergalan.personapi.helpers.Helper;
import io.github.wendergalan.personapi.models.beans.ResponseBean;
import io.github.wendergalan.personapi.models.dtos.PhysicalPersonDTOV1;
import io.github.wendergalan.personapi.models.dtos.PhysicalPersonDTOV2;
import io.github.wendergalan.personapi.models.entities.PhysicalPerson;
import io.github.wendergalan.personapi.models.mappers.PhysicalPersonMapper;
import io.github.wendergalan.personapi.repositories.PhysicalPersonRepository;
import io.github.wendergalan.personapi.services.PhysicalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * The type Physical person service.
 */
@Service
public class PhysicalPersonServiceImpl implements PhysicalPersonService {

    @Autowired
    private PhysicalPersonRepository physicalPersonRepository;

    @Autowired
    private PhysicalPersonMapper physicalPersonMapper;

    @Override
    public ResponseEntity deleteById(int idPhysicalPerson) {
        return physicalPersonRepository
                .findById(idPhysicalPerson)
                .map(p -> {
                    physicalPersonRepository.deleteById(idPhysicalPerson);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Override
    public ResponseEntity saveV1(PhysicalPersonDTOV1 physicalPersonDtoV1, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().body(Helper.createListOfErrorValidations(result.getAllErrors()));

        PhysicalPerson physicalPerson = physicalPersonMapper.physicalPersonDTOV1ToPhysicalPerson(physicalPersonDtoV1);

        physicalPersonRepository.save(physicalPerson);

        // Add HATEOAS
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).saveV1(physicalPersonDtoV1, null)).withSelfRel().withType(HttpMethod.POST.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).deleteById(physicalPerson.getId())).withRel("delete").withType(HttpMethod.DELETE.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).getById(physicalPerson.getId())).withRel("details").withType(HttpMethod.GET.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).findAllPeople(1, 10)).withRel("find-all").withType(HttpMethod.GET.toString()));

        URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{idPhysicalPerson}")
                .buildAndExpand(physicalPerson.getId())
                .toUri();

        return ResponseEntity.created(uri).body(physicalPerson);
    }

    @Override
    public ResponseEntity saveV2(PhysicalPersonDTOV2 physicalPersonDtoV2, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().body(Helper.createListOfErrorValidations(result.getAllErrors()));

        PhysicalPerson physicalPerson = physicalPersonMapper.physicalPersonDTOV2ToPhysicalPerson(physicalPersonDtoV2);

        physicalPersonRepository.save(physicalPerson);

        // Add HATEOAS
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).saveV2(physicalPersonDtoV2, null)).withSelfRel().withType(HttpMethod.POST.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).deleteById(physicalPerson.getId())).withRel("delete").withType(HttpMethod.DELETE.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).getById(physicalPerson.getId())).withRel("details").withType(HttpMethod.GET.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).findAllPeople(1, 10)).withRel("find-all").withType(HttpMethod.GET.toString()));

        URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{idPhysicalPerson}")
                .buildAndExpand(physicalPerson.getId())
                .toUri();

        return ResponseEntity.created(uri).body(physicalPerson);
    }

    @Override
    public ResponseEntity updateV1(int idPhysicalPerson, PhysicalPersonDTOV1 physicalPersonDTOV1) {
        PhysicalPerson physicalPerson = physicalPersonMapper.physicalPersonDTOV1ToPhysicalPerson(physicalPersonDTOV1);
        physicalPerson.setId(idPhysicalPerson);

        // Add HATEOAS
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).getById(idPhysicalPerson)).withSelfRel().withType(HttpMethod.PUT.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).deleteById(idPhysicalPerson)).withRel("delete").withType(HttpMethod.DELETE.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).findAllPeople(1, 10)).withRel("find-all").withType(HttpMethod.GET.toString()));

        physicalPersonRepository.save(physicalPerson);
        return ResponseEntity.ok(physicalPerson);
    }

    @Override
    public ResponseEntity updateV2(int idPhysicalPerson, PhysicalPersonDTOV2 physicalPersonDTOV2) {
        PhysicalPerson physicalPerson = physicalPersonMapper.physicalPersonDTOV2ToPhysicalPerson(physicalPersonDTOV2);
        physicalPerson.setId(idPhysicalPerson);

        // Add HATEOAS
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).getById(idPhysicalPerson)).withSelfRel().withType(HttpMethod.PUT.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).deleteById(idPhysicalPerson)).withRel("delete").withType(HttpMethod.DELETE.toString()));
        physicalPerson.add(linkTo(methodOn(PhysicalPersonController.class).findAllPeople(1, 10)).withRel("find-all").withType(HttpMethod.GET.toString()));

        physicalPersonRepository.save(physicalPerson);
        return ResponseEntity.ok(physicalPerson);
    }

    @Override
    public ResponseEntity getById(int idPhysicalPerson) {
        Optional<PhysicalPerson> pf = physicalPersonRepository.findById(idPhysicalPerson);

        if (!pf.isPresent())
            return ResponseEntity.notFound().build();

        // Add HATEOAS
        pf.get().add(linkTo(methodOn(PhysicalPersonController.class).getById(idPhysicalPerson)).withSelfRel().withType(HttpMethod.GET.toString()));
        pf.get().add(linkTo(methodOn(PhysicalPersonController.class).findAllPeople(1, 10)).withRel("find-all").withType(HttpMethod.GET.toString()));
        pf.get().add(linkTo(methodOn(PhysicalPersonController.class).deleteById(idPhysicalPerson)).withRel("delete").withType(HttpMethod.DELETE.toString()));

        return ResponseEntity.ok(pf);
    }

    @Override
    public ResponseEntity findAllPeople(PageRequest pageRequest) {
        Page<PhysicalPerson> allOfPage = physicalPersonRepository.findAll(pageRequest);
        allOfPage.getContent().forEach(pf -> {
            // Add HATEOAS
            pf.add(linkTo(methodOn(PhysicalPersonController.class).findAllPeople(1, 10)).withSelfRel().withType(HttpMethod.GET.toString()));
            pf.add(linkTo(methodOn(PhysicalPersonController.class).getById(pf.getId())).withRel("details").withType(HttpMethod.GET.toString()));
            pf.add(linkTo(methodOn(PhysicalPersonController.class).deleteById(pf.getId())).withRel("delete").withType(HttpMethod.DELETE.toString()));
            pf.add(linkTo(methodOn(PhysicalPersonController.class).updateV2(pf.getId(), null)).withRel("update").withType(HttpMethod.PUT.toString()));
        });
        return ResponseEntity.ok(new ResponseBean<>(allOfPage.isEmpty() ? 0 : pageRequest.getPageNumber() + 1, allOfPage.getTotalPages(), allOfPage.getTotalElements(), allOfPage.getContent()));
    }

}
