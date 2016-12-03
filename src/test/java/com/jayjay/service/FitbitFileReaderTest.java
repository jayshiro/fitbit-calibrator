package com.jayjay.service;

import com.jayjay.exception.InvalidFileExtensionException;
import com.jayjay.exception.InvalidUpperRightCoordinatesException;
import com.jayjay.model.Field;
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
    public void setup() {
        Validator upperRightCoordinatesValidator = new UpperRightCoordinatesValidator();

        fileReader = new FitbitFileReader(upperRightCoordinatesValidator);
        file = new File(getClass().getClassLoader().getResource("sampleInput1.txt").getFile());
    }

    @Test
    public void shouldNotReturnNullWhenReadingFile()
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException {
        assertNotNull(fileReader.read(file.getAbsolutePath()));
    }

    @Test
    public void shouldNotThrowIOExceptionWhenReadingFile()
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException {
        fileReader.read(file.getAbsolutePath());
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void shouldThrowExceptionWhenReadingNonTxtFile()
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException {
        File invalidFile = new File(getClass().getClassLoader().getResource("sampleInput1.doc").getFile());
        fileReader.read(invalidFile.getAbsolutePath());
    }

    @Test
    public void shouldNotThrowInvalidFileExceptionWhenReadingTxtFile()
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException {
        fileReader.read(file.getAbsolutePath());
    }

    @Test
    public void shouldReadTheUpperRightCoordinatesFromFileCorrectly()
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException {
        Optional<Field> optField = fileReader.read(file.getAbsolutePath());
        Field field = optField.get();

        assertEquals(field.getRightX(), 5);
        assertEquals(field.getRightY(), 5);
    }

    @Test
    public void shouldProperlyValidateUpperRightCoordinates()
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException {
        fileReader.read(file.getAbsolutePath());
    }

    @Test(expected = InvalidUpperRightCoordinatesException.class)
    public void shouldThrowExceptionWhenCoordinatesAreInvalid()
            throws InvalidUpperRightCoordinatesException, IOException, InvalidFileExtensionException {
        File invalidFile = new File(getClass().getClassLoader().getResource("sampleInput2.txt").getFile());
        fileReader.read(invalidFile.getAbsolutePath());
    }
}
