package com.jayjay.service;

import com.jayjay.model.Direction;
import com.jayjay.model.Field;
import com.jayjay.model.Position;
import com.jayjay.model.Trainee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FitbitCalibratorTest {
    private FitbitCalibrator fitbitCalibrator;
    private Field field;

    @Before
    public void setup() {
        field = new Field();
        field.setCoordinates("5 5");
        field.addTrainee(new Trainee(new Position("1 2 N"), "LMLMLMLMM"));
        field.addTrainee(new Trainee(new Position("3 3 E"), "MMRMMRMRRM"));

        fitbitCalibrator = new FitbitCalibrator(field);
    }

    @Test
    public void shouldReturnCorrectListOfOutputCoordinates() {
        fitbitCalibrator.calibrate();

        Position position1 = field.getTrainees().get(0).getPosition();
        assertEquals(position1.getX(), 1);
        assertEquals(position1.getY(), 3);
        assertEquals(position1.getDirection(), Direction.NORTH);

        Position position2 = field.getTrainees().get(1).getPosition();
        assertEquals(position2.getX(), 5);
        assertEquals(position2.getY(), 1);
        assertEquals(position2.getDirection(), Direction.EAST);
    }

}
