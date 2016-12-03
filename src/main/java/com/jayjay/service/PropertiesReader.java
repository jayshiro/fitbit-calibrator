package com.jayjay.service;

import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader(String fileName) throws IOException {
        this.properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

}
