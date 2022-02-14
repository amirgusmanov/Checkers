package com.company.exceptions;

import com.company.coordinate.BoardCoordinate;

public class BoardCoordinateMismatchException extends RuntimeException {

    private Class<? extends BoardCoordinate> sourceCoordinateClass;
    private BoardCoordinate coordinate;

    public BoardCoordinateMismatchException(BoardCoordinate coordinate, Class<? extends BoardCoordinate> sourcePosition) {
        super(String.format("Position {%s} is mismatched with {%s}", coordinate, sourcePosition));
        this.coordinate = coordinate;
        this.sourceCoordinateClass = sourcePosition;
    }

    public BoardCoordinateMismatchException(Class<? extends BoardCoordinate> sourceCoordinate, BoardCoordinate coordinate, Throwable cause) {
        super(cause);
        this.sourceCoordinateClass = sourceCoordinate;
        this.coordinate = coordinate;
    }

    public Class<? extends BoardCoordinate> getSourcePositionClass() {
        return sourceCoordinateClass;
    }

    public BoardCoordinate getPosition() {
        return coordinate;
    }
}
