package com.jayjay;

import com.jayjay.exception.InvalidFileExtensionException;
import com.jayjay.exception.InvalidRowException;
import com.jayjay.model.Field;
import com.jayjay.model.Position;
import com.jayjay.service.FitbitCalibrator;

import java.io.IOException;
import java.util.Optional;

public class FitbitTool {
    private static final String ERR_INVALID_FILE_PARAM = "err.invalid.file.parameter";
    private static final String OUT_TRAINEE_POSITION = "out.trainee.position";

    public static void main(String [] args) throws IOException, InvalidFileExtensionException, InvalidRowException {
        Configuration configuration = new Configuration();

        if(args.length == 0) {
            System.out.println(configuration.getPropertiesReader().getProperty(ERR_INVALID_FILE_PARAM));
        } else {
            process(args[0], configuration);
        }
    }

    private static void process(String filePath, Configuration configuration)
            throws InvalidRowException, IOException, InvalidFileExtensionException {
        Optional<Field> fieldOptional= configuration.getFitbitFileReader().read(filePath);

        if(fieldOptional.isPresent()) {
            Field field = fieldOptional.get();
            FitbitCalibrator fitbitCalibrator = configuration.getFitbitCalibrator(field);
            fitbitCalibrator.calibrate();

            field.getTrainees().stream()
                    .forEach(trainee -> {
                        Position position = trainee.getPosition();
                        System.out.println(configuration.getPropertiesReader().getProperty(OUT_TRAINEE_POSITION,
                                String.valueOf(position.getX()),
                                String.valueOf(position.getY()),
                                position.getDirection().getAlias()));
                    });
        }

    }
}
