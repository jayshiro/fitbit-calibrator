package com.jayjay.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void shouldReturnCorrectAlias() {
        assertEquals(Direction.NORTH.getAlias(), "N");
        assertEquals(Direction.WEST.getAlias(), "W");
    }
}
