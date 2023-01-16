package com.company.exceptions;

import com.company.checker.Checker;
import com.company.coordinate.BoardCoordinate;

public class ImpossibleMoveException extends RuntimeException {

    //должен выйти exception в случае совершения невозможного хода
    private Checker piece;
    private BoardCoordinate targetCoordinate;

    public ImpossibleMoveException(Checker piece, BoardCoordinate targetCoordinate) {
        super(String.format("Checker {%s} has moved to the impossible position {%s}, try again", piece, targetCoordinate));
        this.piece = piece;
        this.targetCoordinate = targetCoordinate;
    }

    public ImpossibleMoveException(Checker piece, BoardCoordinate targetCoordinate, Throwable cause) {
        super(String.format("Checker {%s} has moved to the impossible position {%s}, try again", piece, targetCoordinate), cause);
        this.piece = piece;
        this.targetCoordinate = targetCoordinate;
    }

    public Checker getPiece() {
        return piece;
    }

    public void setPiece(Checker piece) {
        this.piece = piece;
    }

    public BoardCoordinate getTargetCoordinate() {
        return targetCoordinate;
    }

    public void setTargetCoordinate(BoardCoordinate targetCoordinate) {
        this.targetCoordinate = targetCoordinate;
    }
}
