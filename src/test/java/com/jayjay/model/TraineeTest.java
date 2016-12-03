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

    @Test
    public void shouldMoveProperly() {
        int limitX = 4, limitY = 4;

        trainee.right();
        trainee.move(limitX, limitY);
        Position position = trainee.getPosition();
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 2);
        assertEquals(position.getDirection(), Direction.EAST);

        trainee.left();
        trainee.move(limitX, limitY);
        position = trainee.getPosition();
        assertEquals(position.getX(), 2);
        assertEquals(position.getY(), 3);
        assertEquals(position.getDirection(), Direction.NORTH);
    }
}
