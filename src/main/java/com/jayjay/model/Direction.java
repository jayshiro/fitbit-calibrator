package com.jayjay.model;

public enum Direction {
    NORTH("N"),
    SOUTH("S"),
    WEST("W"),
    EAST("E");

    private String alias;

    Direction(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
