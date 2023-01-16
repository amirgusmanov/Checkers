package com.company.checker;

import com.company.coordinate.BoardCoordinate;
import com.company.exceptions.BoardCoordinateMismatchException;
import com.company.exceptions.ImpossibleMoveException;

import java.util.List;
import java.util.Objects;

/**
 * Parents class for simple and queen checker
 *
 * @author Amir Gusmanov
 */
public abstract class Checker {

    private boolean isWhite;
    private BoardCoordinate coordinate;

    public abstract boolean canMove(BoardCoordinate finish);

    public Checker(boolean isWhite, BoardCoordinate coordinate) {
        this.isWhite = isWhite;
        this.coordinate = coordinate;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public BoardCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(BoardCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public abstract List<BoardCoordinate> trace(BoardCoordinate target) throws ImpossibleMoveException;

    protected void checkBoardCoordinateCompatibilityOrThrowException(BoardCoordinate finish) throws BoardCoordinateMismatchException {
        if (finish.getClass() != coordinate.getClass()) {
            throw new BoardCoordinateMismatchException((BoardCoordinate) finish, coordinate.getClass());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checker checker = (Checker) o;
        return isWhite == checker.isWhite && Objects.equals(coordinate, checker.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWhite, coordinate);
    }

    @Override
    public String toString() {
        return "Checker{" +
                "isWhite=" + isWhite +
                ", coordinate=" + coordinate +
                '}';
    }

}
