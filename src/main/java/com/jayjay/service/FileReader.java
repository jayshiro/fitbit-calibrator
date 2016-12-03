package com.jayjay.service;

import com.jayjay.exception.InvalidFileExtensionException;
import com.jayjay.exception.InvalidUpperRightCoordinatesException;

import java.io.IOException;

public interface FileReader<K> {
    public static final String EXTENSION_TXT = "txt";

    public K read(String filePath)
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException;
}
