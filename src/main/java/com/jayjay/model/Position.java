package com.jayjay.model;

import java.io.Serializable;

public class Position implements Serializable{
    private int x;
    private int y;
    private Direction direction;

    public Position() {}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
