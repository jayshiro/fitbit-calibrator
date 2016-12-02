package com.jayjay.service;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class FitbitFileReaderTest {

    private FileReader fileReader;

    @Before
    public void setup() {
        fileReader = new FitbitFileReader();
    }

    @Test
    public void shouldNotReturnNullWhenReadingFile() {
        assertNotNull(fileReader.read());
    }

    @Test
    public void shouldNotThrowIOExceptionWhenReadingFile() {
        fileReader.read();
    }
}
