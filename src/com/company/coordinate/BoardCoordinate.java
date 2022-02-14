package com.company.coordinate;

import java.util.List;
import java.util.Objects;

/**
 * Abstract model of coordinate
 * @author Amir Gusmanov
 */
public abstract class BoardCoordinate {

    private Vertical vertical;
    private Horizontal horizontal;

    public BoardCoordinate(Vertical vertical, Horizontal horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Vertical getVertical() { return vertical; }

    public void setVertical(Vertical vertical) {
        this.vertical = vertical;
    }

    public Horizontal getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(Horizontal horizontal) {
        this.horizontal = horizontal;
    }

    abstract public List<BoardCoordinate> adjacentCoordinates();

    abstract public List<BoardCoordinate> diagonals();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCoordinate that = (BoardCoordinate) o;
        return vertical == that.vertical && horizontal == that.horizontal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }

    @Override
    public String toString() {
        return "BoardCoordinate{" +
                "vertical=" + vertical +
                ", horizontal=" + horizontal +
                '}';
    }
}
