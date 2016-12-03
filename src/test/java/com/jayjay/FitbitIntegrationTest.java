package com.jayjay;

import com.jayjay.exception.InvalidFileExtensionException;
import com.jayjay.exception.InvalidRowException;
import com.jayjay.model.Direction;
import com.jayjay.model.Field;
import com.jayjay.model.Position;
import com.jayjay.model.Trainee;
import com.jayjay.service.FitbitCalibrator;
import com.jayjay.service.FitbitFileReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class FitbitIntegrationTest {

    private Configuration configuration;
    private FitbitFileReader fitbitFileReader;

    @Before
    public void setup() throws IOException {
        configuration = new Configuration();
        fitbitFileReader = configuration.getFitbitFileReader();
    }

    @Test
    public void shouldProduceTheCorrectResultsAfterCombiningModules()
            throws InvalidRowException, IOException, InvalidFileExtensionException {
        File invalidFile = new File(getClass().getClassLoader().getResource("sampleInput1.txt").getFile());
        Field field = fitbitFileReader.read(invalidFile.getAbsolutePath()).get();
        configuration.getFitbitCalibrator(field).calibrate();

        List<Trainee> traineeList = field.getTrainees();
        Position position1 = traineeList.get(0).getPosition();
        assertEquals(position1.getX(), 1);
        assertEquals(position1.getY(), 3);
        assertEquals(position1.getDirection(), Direction.NORTH);

        Position position2 = traineeList.get(1).getPosition();
        assertEquals(position2.getX(), 5);
        assertEquals(position2.getY(), 1);
        assertEquals(position2.getDirection(), Direction.EAST);
    }
}
