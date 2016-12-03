package com.jayjay.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    private Position position;

    @Before
    public void setup() {
        position = new Position("3 4 E");
    }


    @Test
    public void shouldSetCorrectPosition() {
        assertEquals(position.getX(), 3);
        assertEquals(position.getY(), 4);
        assertEquals(position.getDirection(), Direction.EAST);
    }

    @Test
    public void shouldAddXProperly() {
        position.addX(1);
        assertEquals(position.getX(), 4);
        position.addX(-1);
        assertEquals(position.getX(), 3);
    }

    @Test
    public void shouldAddYProperly() {
        position.addY(1);
        assertEquals(position.getY(), 5);
        position.addY(-1);
        assertEquals(position.getY(), 4);
    }
}
