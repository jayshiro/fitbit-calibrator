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

    @Test
    public void shouldReturnCorrectPropertyWithOneParam() {
        assertEquals(propertiesReader.getProperty("property.with.one.parameter","value"),"Substitue value.");
    }

    @Test
    public void shouldReturnCorrectPropertyWithTwoParams() {
        assertEquals(propertiesReader.getProperty("property.with.two.parameters","value","another value"),
                "Substitue value with another value.");
    }

    @Test
    public void shouldReturnCorrectStringWithInsufficientParameters() {
        assertEquals(propertiesReader.getProperty("property.with.two.parameters","value"), "Substitue value with {1}.");
    }

    @Test
    public void shouldReturnCorrectStringWithOverflowingParameters() {
        assertEquals(propertiesReader.getProperty("property.with.two.parameters","value","another value","hello"),
                "Substitue value with another value.");
    }
}
