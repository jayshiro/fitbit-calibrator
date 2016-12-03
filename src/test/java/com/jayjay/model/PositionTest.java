package com.jayjay.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void shouldSetCorrectPosition() {
        Position position = new Position("3 4 E");

        assertEquals(position.getX(), 3);
        assertEquals(position.getY(), 4);
        assertEquals(position.getDirection(), Direction.EAST);
    }
}
