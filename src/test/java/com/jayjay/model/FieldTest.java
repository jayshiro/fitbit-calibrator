package com.jayjay.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FieldTest {

    @Test
    public void shouldContainCorrectValuesGivenStringRow() {
        Field field = new Field();
        field.setCoordinates("5 7");

        assertEquals(field.getLimitX(), 5);
        assertEquals(field.getLimitY(), 7);
    }
}
