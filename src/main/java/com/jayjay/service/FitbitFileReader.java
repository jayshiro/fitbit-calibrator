package com.jayjay.service;

import com.jayjay.exception.*;
import com.jayjay.model.Field;
import com.jayjay.model.Position;
import com.jayjay.model.Trainee;
import com.jayjay.validation.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

public class FitbitFileReader implements FileReader<Optional<Field>>{

    private static final String ERR_FILE_EXTENSION = "err.file.invalid.extension";
    private static final String ERR_FILE_MISSING = "err.file.missing";
    private static final String ERR_INVALID_FIELD_COORDS = "err.invalid.field.coordinates";
    private static final String ERR_INVALID_TRAINEE_COORDS = "err.invalid.trainee.coordinates";
    private static final String ERR_INVALID_TRAINEE_MOVES = "err.invalid.trainee.movements";
    private static final String ERR_TRAINEES_MISSING = "err.trainees.missing";

    private PropertiesReader propertiesReader;
    private Validator upperRightCoordinatesValidator;
    private Validator traineeCoordinatesValidator;
    private Validator traineeMovementsValidator;

    public FitbitFileReader(PropertiesReader propertiesReader, Validator upperRightCoordinatesValidator,
                            Validator traineeCoordinatesValidator, Validator traineeMovementsValidator) {
        this.propertiesReader = propertiesReader;
        this.upperRightCoordinatesValidator = upperRightCoordinatesValidator;
        this.traineeCoordinatesValidator = traineeCoordinatesValidator;
        this.traineeMovementsValidator = traineeMovementsValidator;
    }


    @Override
    public Optional<Field> read(String filePath)
            throws InvalidFileExtensionException, IOException, InvalidRowException {
        Field field = new Field();
        Optional<Field> result = Optional.empty();

        if(!hasValidFileExtension(filePath)) {
            throw new InvalidFileExtensionException(propertiesReader.getProperty(ERR_FILE_EXTENSION));
        }

        String row = "";
        String nextRow = "";
        boolean hasReadUpperRightCoordinates = false;

        try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
            try (BufferedReader br = new BufferedReader(fileReader)) {
                while ((row = br.readLine()) != null) {

                    if(!hasReadUpperRightCoordinates) {
                        if(!upperRightCoordinatesValidator.isValid(row)) {
                            throw new InvalidUpperRightCoordinatesException(
                                    propertiesReader.getProperty(ERR_INVALID_FIELD_COORDS, row));

                        }
                        field.setCoordinates(row);
                        hasReadUpperRightCoordinates = true;

                    } else {
                        if(!traineeCoordinatesValidator.isValid(row)) {
                            throw new InvalidTraineeCoordinatesException(
                                    propertiesReader.getProperty(ERR_INVALID_TRAINEE_COORDS, row));
                        }

                        nextRow = br.readLine();
                        if(!traineeMovementsValidator.isValid(nextRow)) {
                            throw new InvalidTraineeMovementsException(
                                    propertiesReader.getProperty(ERR_INVALID_TRAINEE_MOVES, row));
                        }

                        field.addTrainee(new Trainee(new Position(row), nextRow));
                    }
                }
            }

            if(field.getTrainees().size() == 0) {
                throw new InvalidTraineesMissingException(ERR_TRAINEES_MISSING);
            }

            result = Optional.of(field);

        } catch (IOException e) {
            throw new IOException(propertiesReader.getProperty(ERR_FILE_MISSING));
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
}
