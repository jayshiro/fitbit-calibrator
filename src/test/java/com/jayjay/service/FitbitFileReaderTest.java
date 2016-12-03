package com.jayjay.service;

import com.jayjay.exception.*;
import com.jayjay.model.Field;
import com.jayjay.validation.TraineeCoordinatesValidator;
import com.jayjay.validation.TraineeMovementsValidator;
import com.jayjay.validation.UpperRightCoordinatesValidator;
import com.jayjay.validation.Validator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class FitbitFileReaderTest {

    private FitbitFileReader fileReader;
    private File file;

    @Before
    public void setup() throws IOException {
        PropertiesReader propertiesReader = new PropertiesReader("messages.properties");
        Validator upperRightCoordinatesValidator = new UpperRightCoordinatesValidator();
        Validator traineeCoordinatesValidator = new TraineeCoordinatesValidator();
        Validator traineeMovementsValidator = new TraineeMovementsValidator();

        fileReader = new FitbitFileReader(propertiesReader, upperRightCoordinatesValidator,
                traineeCoordinatesValidator, traineeMovementsValidator);
        file = new File(getClass().getClassLoader().getResource("sampleInput1.txt").getFile());
    }

    @Test
    public void shouldNotReturnNullWhenReadingFile()
            throws InvalidFileExtensionException, IOException, InvalidRowException {
        assertNotNull(fileReader.read(file.getAbsolutePath()));
    }

    @Test
    public void shouldNotThrowIOExceptionWhenReadingFile()
            throws InvalidFileExtensionException, IOException, InvalidRowException {
        fileReader.read(file.getAbsolutePath());
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void shouldThrowExceptionWhenReadingNonTxtFile()
            throws InvalidFileExtensionException, IOException, InvalidRowException {
        File invalidFile = new File(getClass().getClassLoader().getResource("sampleInput1.doc").getFile());
        fileReader.read(invalidFile.getAbsolutePath());
    }

    @Test
    public void shouldNotThrowInvalidFileExceptionWhenReadingTxtFile()
            throws InvalidFileExtensionException, IOException, InvalidRowException {
        fileReader.read(file.getAbsolutePath());
    }

    @Test
    public void shouldReadTheUpperRightCoordinatesFromFileCorrectly()
            throws InvalidFileExtensionException, IOException, InvalidRowException {
        Optional<Field> optField = fileReader.read(file.getAbsolutePath());
        Field field = optField.get();

        assertEquals(field.getRightX(), 5);
        assertEquals(field.getRightY(), 5);
    }

    @Test
    public void shouldProperlyValidateUpperRightCoordinates()
            throws InvalidFileExtensionException, IOException, InvalidRowException {
        fileReader.read(file.getAbsolutePath());
    }

    @Test(expected = InvalidUpperRightCoordinatesException.class)
    public void shouldThrowExceptionWhenCoordinatesAreInvalid()
            throws IOException, InvalidFileExtensionException, InvalidRowException {
        File invalidFile = new File(getClass().getClassLoader().getResource("sampleInput2.txt").getFile());
        fileReader.read(invalidFile.getAbsolutePath());
    }

    @Test(expected = InvalidTraineeCoordinatesException.class)
    public void shouldThrowExceptionWhenTraineeCoordinatesAreInvalid()
            throws InvalidRowException, IOException, InvalidFileExtensionException {
        File invalidFile = new File(getClass().getClassLoader().getResource("invalidTraineeCoordinates1.txt").getFile());
        fileReader.read(invalidFile.getAbsolutePath());
    }

    @Test(expected = InvalidTraineeMovementsException.class)
    public void shouldThrowExceptionWhenTraineeMovementsAreInvalid()
            throws InvalidRowException, IOException, InvalidFileExtensionException {
        File invalidFile = new File(getClass().getClassLoader().getResource("invalidTraineeMovements1.txt").getFile());
        fileReader.read(invalidFile.getAbsolutePath());
    }

    @Test(expected = InvalidTraineeMovementsException.class)
    public void shouldThrowExceptionWhenTraineeMovementsAreMissing()
            throws InvalidRowException, IOException, InvalidFileExtensionException {
        File invalidFile = new File(getClass().getClassLoader().getResource("invalidTraineeMovements2.txt").getFile());
        fileReader.read(invalidFile.getAbsolutePath());
    }
}
