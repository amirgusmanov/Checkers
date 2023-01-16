package com.company.exceptions;

import com.company.coordinate.BoardCoordinate;

public class CheckerNotFoundException extends RuntimeException {

    private BoardCoordinate coordinate;

    public CheckerNotFoundException(Throwable cause, BoardCoordinate coordinate) {
        super(cause);
        this.coordinate = coordinate;
    }

    public CheckerNotFoundException(BoardCoordinate coordinate) {
        super("Could not find a checker at coordinate" + coordinate);
        this.coordinate = coordinate;
    }

    public BoardCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(BoardCoordinate coordinate) {
        this.coordinate = coordinate;
    }
}
