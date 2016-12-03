package com.jayjay.model;

import java.io.Serializable;

public class Trainee implements Serializable{
    private Position position;
    private String movements;

    public Trainee() {}

    public Trainee(Position position, String movements) {
        this.position = position;
        this.movements = movements;
    }

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

    public void left() {
        switch (position.getDirection()) {
            case NORTH: position.setDirection(Direction.WEST);
                break;
            case WEST: position.setDirection(Direction.SOUTH);
                break;
            case SOUTH: position.setDirection(Direction.EAST);
                break;
            case EAST: position.setDirection(Direction.NORTH);
                break;
        }
    }

    public void right() {
        switch (position.getDirection()) {
            case NORTH: position.setDirection(Direction.EAST);
                break;
            case EAST: position.setDirection(Direction.SOUTH);
                break;
            case SOUTH: position.setDirection(Direction.WEST);
                break;
            case WEST: position.setDirection(Direction.NORTH);
                break;
        }
    }
}
