package com.jayjay.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Field implements Serializable{

    private int rightX;
    private int rightY;
    private List<Trainee> trainees;

    public Field(){
        this.trainees = new ArrayList<>();
    }

    public int getRightX() {
        return rightX;
    }

    public void setRightX(int rightX) {
        this.rightX = rightX;
    }

    public int getRightY() {
        return rightY;
    }

    public void setRightY(int rightY) {
        this.rightY = rightY;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }
}
