package io.github.wendergalan.personapi.annotations.adult.validator;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdultValidatorTest {

    private AdultValidator validator;

    @Before
    public void setup() {
        validator = new AdultValidator();
    }

    @Test
    public void mustBeUnderage() {
        LocalDate localDate = LocalDate.now().minusYears(10);
        assertFalse(validator.isValid(localDate, null));
    }

    @Test
    public void mustBeOfLegalAge() {
        LocalDate localDate = LocalDate.now().minusYears(19);
        assertTrue(validator.isValid(localDate, null));
    }
}
