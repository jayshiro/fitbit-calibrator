package com.jayjay.validator;

import com.jayjay.validation.FieldCoordinatesValidator;
import com.jayjay.validation.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FieldCoordinatesValidatorTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = new FieldCoordinatesValidator();
    }

    @Test
    public void shouldPassWhenCoordinatesAreValid() {
        assertTrue(validator.isValid("5 5"));
    }
}
