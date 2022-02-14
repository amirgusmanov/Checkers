package com.company.coordinate;

import java.util.Arrays;

public enum Vertical implements BoardPosition {

    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8);

    private final int index;

    Vertical(int index) { this.index = index; }

    public int getIndex() { return index; }

    @Override
    public BoardPosition next() {
        if (index == VIII.index) {
            return I;
        } else {
            return findByIndex(index + 1);
        }
    }

    @Override
    public BoardPosition previous() {
        if (index == I.index) {
            return VIII;
        } else {
            return findByIndex(index - 1);
        }
    }

    public static Vertical findByIndex(int index) {
        return Arrays.stream(values())
                .filter(coordinate -> coordinate.index == index)
                .findFirst()
                .get();
    }

}
