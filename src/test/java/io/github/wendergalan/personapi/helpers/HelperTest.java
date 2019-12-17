package io.github.wendergalan.personapi.helpers;

import io.github.wendergalan.personapi.models.beans.Validation;
import io.github.wendergalan.personapi.models.entities.PhysicalPerson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class HelperTest {

    private static Errors errors;

    @Before
    public void setup() {
        PhysicalPerson physicalPerson = new PhysicalPerson();
        errors = new BeanPropertyBindingResult(physicalPerson, "physicalPerson");
        ((BeanPropertyBindingResult) errors).addError(new FieldError("id", "id", "cannot be null"));
    }

    @Test
    public void shouldReturnEmptyList() {
        List<Validation> validations = Helper.createListOfErrorValidations(new ArrayList<>());
        Assert.assertTrue(validations.isEmpty());
    }

    @Test
    public void shouldReturnListOfErrors() {
        List<Validation> validations = Helper.createListOfErrorValidations(errors.getAllErrors());
        Assert.assertTrue(!validations.isEmpty());
    }
}
