package io.github.wendergalan.personapi.controllers;

import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV1;
import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV2;
import io.github.wendergalan.personapi.model.entities.PhysicalPerson;
import io.github.wendergalan.personapi.services.PhysicalPersonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/physical_people")
public class PhysicalPersonController {

    @Autowired
    private PhysicalPersonService physicalPersonService;

    @GetMapping("/v1")
    public ResponseEntity findAllPeople() {
        return physicalPersonService.findAllPeople();
    }

    @GetMapping("/v1/{idPhysicalPerson}")
    public ResponseEntity getById(@PathVariable int idPhysicalPerson) {
        return physicalPersonService.getById(idPhysicalPerson);
    }

    @DeleteMapping("/v1/{idPhysicalPerson}")
    public ResponseEntity deleteById(@PathVariable int idPhysicalPerson) {
        return physicalPersonService.deleteById(idPhysicalPerson);
    }

    @PostMapping("/v1")
    public ResponseEntity saveV1(@Valid @RequestBody PhysicalPersonDTOV1 physicalPersonDtoV1, BindingResult result) {
        return physicalPersonService.saveV1(physicalPersonDtoV1, result);
    }

    @PutMapping("/v1/{idPhysicalPerson}")
    public ResponseEntity update(@PathVariable int idPhysicalPerson, @Valid @RequestBody PhysicalPerson physicalPerson) {
        return physicalPersonService.update(idPhysicalPerson, physicalPerson);
    }

    @PostMapping("/v2")
    public ResponseEntity saveV2(@Valid @RequestBody PhysicalPersonDTOV2 physicalPersonDtoV2, BindingResult result) {
        return physicalPersonService.saveV2(physicalPersonDtoV2, result);
    }

}
