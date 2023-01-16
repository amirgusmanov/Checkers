package com.company.coordinate;

import java.util.Arrays;

public enum Horizontal implements BoardPosition {

    A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8);

    private final int index;

    Horizontal(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public BoardPosition next() {
        if (index == H.index) {
            return A;
        } else {
            return findByIndex(index + 1);
        }
    }

    @Override
    public BoardPosition previous() {
        if (index == A.index) {
            return H;
        } else {
            return findByIndex(index - 1);
        }
    }

    public static Horizontal findByIndex(int index) {
        return Arrays.stream(values()).filter(coordinate -> coordinate.index == index).findFirst().get();
    }

}
