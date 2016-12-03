package com.jayjay.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void shouldReturnCorrectAlias() {
        assertEquals(Direction.NORTH.getAlias(), "N");
        assertEquals(Direction.WEST.getAlias(), "W");
    }

    @Test
    public void shouldReturnCorrectDirection() {
        assertEquals(Direction.findByAlias("N").get(), Direction.NORTH);
        assertEquals(Direction.findByAlias("S").get(), Direction.SOUTH);
    }
}
