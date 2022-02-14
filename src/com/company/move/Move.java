package com.company.move;

import com.company.coordinate.BoardCoordinate;

import java.util.Objects;

public class Move {

    private BoardCoordinate start;
    private BoardCoordinate target;

    public Move(BoardCoordinate start, BoardCoordinate target) {
        this.start = start;
        this.target = target;
    }

    public BoardCoordinate getStart() { return start; }

    public void setStart(BoardCoordinate start) {
        this.start = start;
    }

    public BoardCoordinate getTarget() {
        return target;
    }

    public void setTarget(BoardCoordinate target) {
        this.target = target;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(start, move.start) && Objects.equals(target, move.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, target);
    }

    @Override
    public String toString() {
        return "Move{" +
                "start=" + start +
                ", target=" + target +
                '}';
    }
}

