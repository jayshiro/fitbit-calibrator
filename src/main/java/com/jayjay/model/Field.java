package com.jayjay.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Field implements Serializable{

    private int limitX;
    private int limitY;
    private List<Trainee> trainees;

    public Field(){
        this.trainees = new ArrayList<>();
    }

    public int getLimitX() {
        return limitX;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    public int getLimitY() {
        return limitY;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
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

    public void setCoordinates(String coordinates) {
        String [] strArray = coordinates.trim().split(" ");
        this.limitX = Integer.parseInt(strArray[0]);
        this.limitY = Integer.parseInt(strArray[1]);
    }
}
