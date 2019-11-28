package io.github.wendergalan.personapi.controllers;

import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV1;
import io.github.wendergalan.personapi.model.dtos.PhysicalPersonDTOV2;
import io.github.wendergalan.personapi.services.PhysicalPersonService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api("Physical Person Controller")
@RestController
@RequestMapping("/physical_people")
public class PhysicalPersonController {

    @Autowired
    private PhysicalPersonService physicalPersonService;

    @GetMapping("/v1")
    @ApiOperation(value = "Find All People", notes = "Retrieving the collection of people", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class)
    })
    public ResponseEntity findAllPeople() {
        return physicalPersonService.findAllPeople();
    }

    @GetMapping("/v1/{idPhysicalPerson}")
    @ApiOperation(value = "Get People By ID", notes = "Retrieving the detail person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity getById(
            @ApiParam(required = true, name = "idPhysicalPerson", value = "ID of the person you want to retrieve", example = "0")
            @PathVariable int idPhysicalPerson) {
        return physicalPersonService.getById(idPhysicalPerson);
    }

    @DeleteMapping("/v1/{idPhysicalPerson}")
    @ApiOperation(value = "Delete People By ID", notes = "Delete the person")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Success"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity deleteById(
            @ApiParam(required = true, name = "idPhysicalPerson", value = "ID of the person you want to delete", example = "0")
            @PathVariable int idPhysicalPerson) {
        return physicalPersonService.deleteById(idPhysicalPerson);
    }

    @Deprecated
    @PostMapping("/v1")
    @ApiOperation(value = "Create Physical Person", notes = "Creating a new physical person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class)
    })
    public ResponseEntity saveV1(
            @ApiParam(required = true, name = "physicalPersonDtoV1", value = "Save Person", example = "0")
            @Valid @RequestBody PhysicalPersonDTOV1 physicalPersonDtoV1, BindingResult result) {
        return physicalPersonService.saveV1(physicalPersonDtoV1, result);
    }

    @Deprecated
    @PutMapping("/v1/{idPhysicalPerson}")
    @ApiOperation(value = "Update Physical Person", notes = "Updating a physical person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class)
    })
    public ResponseEntity updateV1(
            @ApiParam(required = true, name = "physicalPersonDtoV1", value = "Update Person", example = "0")
            @PathVariable int idPhysicalPerson, @Valid @RequestBody PhysicalPersonDTOV1 physicalPersonDtoV1) {
        return physicalPersonService.updateV1(idPhysicalPerson, physicalPersonDtoV1);
    }

    @PutMapping("/v2/{idPhysicalPerson}")
    @ApiOperation(value = "Update Physical Person", notes = "Updating a physical person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad request", response = ResponseEntity.class)
    })
    public ResponseEntity updateV2(
            @ApiParam(required = true, name = "physicalPersonDtoV1", value = "Update Person", example = "0")
            @PathVariable int idPhysicalPerson, @Valid @RequestBody PhysicalPersonDTOV2 physicalPersonDtoV2) {
        return physicalPersonService.updateV2(idPhysicalPerson, physicalPersonDtoV2);
    }

    @PostMapping("/v2")
    @ApiOperation(value = "Create Physical Person", notes = "Creating a new physical person")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad request")
    })
    public ResponseEntity saveV2(@Valid @RequestBody PhysicalPersonDTOV2 physicalPersonDtoV2, BindingResult result) {
        return physicalPersonService.saveV2(physicalPersonDtoV2, result);
    }
}
