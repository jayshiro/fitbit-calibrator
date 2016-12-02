package com.jayjay.model;

import java.io.Serializable;

public class Trainee implements Serializable{
    private Position position;
    private String movements;

    public Trainee() {}

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }
}
