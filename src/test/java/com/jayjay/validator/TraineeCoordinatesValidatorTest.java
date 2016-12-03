package com.jayjay.validator;

import com.jayjay.validation.TraineeCoordinatesValidator;
import com.jayjay.validation.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TraineeCoordinatesValidatorTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = new TraineeCoordinatesValidator();
    }

    @Test
    public void shouldPassWhenCoordinatesAreValid() {
        assertTrue(validator.isValid("1 2 N"));
    }

    @Test
    public void shouldBeInvalidWhenCoordinatesAreWrong() {
        assertFalse(validator.isValid("N N 3"));
    }
}
