package com.jayjay.service;

import com.jayjay.exception.InvalidFileExtensionException;
import com.jayjay.exception.InvalidUpperRightCoordinatesException;
import com.jayjay.model.Field;
import com.jayjay.validation.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class FitbitFileReader implements FileReader<Optional<Field>>{

    private static final String ERR_FILE_EXTENSION = "This program only accepts txt files.";
    private static final String ERR_FILE_MISSING = "File is missing. Please provide correct file path.";
    private static final String ERR_INVALID_FIELD_COORDS =
            "You've set an invalid value for the upper-right coordinates of the field.";

    private Validator upperRightCoordinatesValidator;

    public FitbitFileReader(Validator upperRightCoordinatesValidator) {
        this.upperRightCoordinatesValidator = upperRightCoordinatesValidator;
    }


    @Override
    public Optional<Field> read(String filePath)
            throws InvalidFileExtensionException, IOException, InvalidUpperRightCoordinatesException {
        Field field = new Field();
        Optional<Field> result = Optional.empty();

        if(!hasValidFileExtension(filePath)) {
            throw new InvalidFileExtensionException(ERR_FILE_EXTENSION);
        }

        String row = "";
        boolean hasReadUpperRightCoordinates = false;

        try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
            try (BufferedReader br = new BufferedReader(fileReader)) {
                while ((row = br.readLine()) != null) {

                    if(!hasReadUpperRightCoordinates) {
                        if(!upperRightCoordinatesValidator.isValid(row)) {
                            throw new InvalidUpperRightCoordinatesException(ERR_INVALID_FIELD_COORDS);
                        }
                        setUpperRightCoordinates(field, row);
                        hasReadUpperRightCoordinates = true;
                    }

                }
            }

            result = Optional.of(field);

        } catch (IOException e) {
            throw new IOException(ERR_FILE_MISSING);
        }

        return result;
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

    private void setUpperRightCoordinates(Field field, String row) {
        String [] strArray = row.split(" ");
        field.setRightX(Integer.parseInt(strArray[0]));
        field.setRightY(Integer.parseInt(strArray[1]));
    }
}
