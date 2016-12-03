package com.jayjay.model;

import java.util.Arrays;
import java.util.Optional;

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

    public static Optional<Direction> findByAlias(final String alias) {
        return Arrays.asList(values())
                .stream()
                .filter(direction -> {
                    if (direction.getAlias().equals(alias)) {
                        return true;
                    }
                    return false;
                })
                .findFirst();
    }
}
