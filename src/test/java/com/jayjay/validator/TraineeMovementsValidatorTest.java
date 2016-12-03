package com.jayjay.validator;

import com.jayjay.validation.TraineeCoordinatesValidator;
import com.jayjay.validation.TraineeMovementsValidator;
import com.jayjay.validation.Validator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TraineeMovementsValidatorTest {

    private Validator validator;

    @Before
    public void setup() {
        validator = new TraineeMovementsValidator();
    }

    @Test
    public void shouldPassWhenMovementsAreValid() {
        assertTrue(validator.isValid("LMLMLMLMM"));
    }

    @Test
    public void shouldBeInvalidWhenMovementsAreWrong() {
        assertFalse(validator.isValid("MMRMMRMR RM"));
        assertFalse(validator.isValid("MMR3MM2RMRRM"));
    }
}
