package com.jayjay.validator;

import com.jayjay.validation.UpperRightCoordinatesValidator;
import com.jayjay.validation.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UpperRightCoordinatesValidatorTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = new UpperRightCoordinatesValidator();
    }

    @Test
    public void shouldPassWhenCoordinatesAreValid() {
        assertTrue(validator.isValid("5 5"));
    }
}
