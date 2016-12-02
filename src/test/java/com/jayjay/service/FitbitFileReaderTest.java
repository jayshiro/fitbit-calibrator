package com.jayjay.service;

import com.jayjay.exception.InvalidFileExtensionException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;

public class FitbitFileReaderTest {

    private FileReader fileReader;

    @Before
    public void setup() {
        fileReader = new FitbitFileReader();
    }

    @Test
    public void shouldNotReturnNullWhenReadingFile() throws InvalidFileExtensionException, IOException {
        File file = new File(getClass().getClassLoader().getResource("sampleInput1.txt").getFile());
        assertNotNull(fileReader.read(file.getAbsolutePath()));
    }

    @Test
    public void shouldNotThrowIOExceptionWhenReadingFile() throws InvalidFileExtensionException, IOException {
        File file = new File(getClass().getClassLoader().getResource("sampleInput1.txt").getFile());
        fileReader.read(file.getAbsolutePath());
    }

    @Test(expected = InvalidFileExtensionException.class)
    public void shouldThrowExceptionWhenReadingNonTxtFile() throws InvalidFileExtensionException, IOException {
        File file = new File(getClass().getClassLoader().getResource("sampleInput1.doc").getFile());
        fileReader.read(file.getAbsolutePath());
    }

    @Test
    public void shouldNotThrowInvalidFileExceptionWhenReadingTxtFile()
            throws InvalidFileExtensionException, IOException {
        File file = new File(getClass().getClassLoader().getResource("sampleInput1.txt").getFile());
        fileReader.read(file.getAbsolutePath());
    }
}
