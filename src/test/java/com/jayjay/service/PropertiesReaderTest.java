package com.jayjay.service;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PropertiesReaderTest {

    private PropertiesReader propertiesReader;

    @Before
    public void setup() throws IOException {
        this.propertiesReader = new PropertiesReader("messages.properties");
    }

    @Test
    public void shouldReturnCorrectProperty() {
        assertEquals(propertiesReader.getProperty("err.file.invalid.extension"),"This program only accepts txt files.");
    }
}
