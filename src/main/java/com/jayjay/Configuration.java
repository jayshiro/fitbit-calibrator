package com.jayjay;

import com.jayjay.model.Field;
import com.jayjay.service.FileReader;
import com.jayjay.service.FitbitCalibrator;
import com.jayjay.service.FitbitFileReader;
import com.jayjay.service.PropertiesReader;
import com.jayjay.validation.FieldCoordinatesValidator;
import com.jayjay.validation.TraineeCoordinatesValidator;
import com.jayjay.validation.TraineeMovementsValidator;
import com.jayjay.validation.Validator;

import java.io.IOException;

public class Configuration {

    private FitbitFileReader fileReader;
    private PropertiesReader propertiesReader;

    private Validator fieldCoordinatesValidator;
    private Validator traineeCoordinatesValidator;
    private Validator traineeMovementsValidator;

    public Configuration() throws IOException {
        propertiesReader = new PropertiesReader("messages.properties");

        fieldCoordinatesValidator = new FieldCoordinatesValidator();
        traineeCoordinatesValidator = new TraineeCoordinatesValidator();
        traineeMovementsValidator = new TraineeMovementsValidator();
        fileReader = new FitbitFileReader(propertiesReader, fieldCoordinatesValidator, traineeCoordinatesValidator,
                traineeMovementsValidator);

    }

    public FitbitCalibrator getFitbitCalibrator(Field field) {
        return new FitbitCalibrator(field);
    }

    public PropertiesReader getPropertiesReader() {
        return propertiesReader;
    }

    public FitbitFileReader getFitbitFileReader() {
        return fileReader;
    }
}
