package com.jayjay.service;

import com.jayjay.model.Field;

public class FitbitCalibrator {
    private Field field;

    public FitbitCalibrator(Field field) {
        this.field = field;
    }


    public void calibrate() {
        field.getTrainees().stream()
                .forEach(trainee -> {
                    char[] movements = trainee.getMovements().toCharArray();

                    for(char movement : movements) {
                        switch (movement) {
                            case 'L': trainee.left();
                                break;
                            case 'R': trainee.right();
                                break;
                            case 'M': trainee.move(field.getLimitX(), field.getLimitY());
                                break;
                        }
                    }

                });
    }


}
