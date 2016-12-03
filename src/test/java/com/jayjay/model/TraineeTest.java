package com.jayjay.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TraineeTest {
    private Trainee trainee;

    @Before
    public void setup() {
        trainee = new Trainee(new Position("1 2 N"), "LMLMLMLMM");
    }

    @Test
    public void shouldCorrectlyTurnLeft() {
        trainee.left();
        assertEquals(trainee.getPosition().getDirection(), Direction.WEST);
    }

    @Test
    public void shouldCorrectlyTurnRight() {
        trainee.right();
        assertEquals(trainee.getPosition().getDirection(), Direction.EAST);
    }
}
