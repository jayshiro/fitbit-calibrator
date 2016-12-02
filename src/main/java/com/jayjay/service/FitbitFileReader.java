package com.jayjay.service;

import com.jayjay.exception.InvalidFileExtensionException;
import com.jayjay.model.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class FitbitFileReader implements FileReader<Optional<Field>>{

    @Override
    public Optional<Field> read(String filePath) throws InvalidFileExtensionException, IOException {

        if(!hasValidFileExtension(filePath)) {
            throw new InvalidFileExtensionException("This program only accepts txt files.");
        }

        String row = "";
        try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
            try (BufferedReader br = new BufferedReader(fileReader)) {
                while ((row = br.readLine()) != null) {

                }
            }

        } catch (IOException e) {
            throw new IOException("File is missing. Please provide correct file path.");
        }

        return Optional.empty();
    }

    private boolean hasValidFileExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        if(index > 0) {
            if(filePath.substring(index + 1).equals(EXTENSION_TXT)) {
                return true;
            }
        }
        return false;
    }
}
