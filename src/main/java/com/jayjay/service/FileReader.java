package com.jayjay.service;

import com.jayjay.exception.*;

import java.io.IOException;

public interface FileReader<K> {
    public static final String EXTENSION_TXT = "txt";

    public K read(String filePath) throws InvalidFileExtensionException, IOException, InvalidRowException;
}
