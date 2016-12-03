package com.jayjay.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {

    @Test
    public void shouldContainCorrectValuesGivenStringRow() {
        Field field = new Field();
        field.setCoordinates("5 7");

        assertEquals(field.getRightX(), 5);
        assertEquals(field.getRightY(), 7);
    }
}
