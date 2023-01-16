package com.company.checker;

import com.company.coordinate.BoardCoordinate;
import com.company.exceptions.ImpossibleMoveException;

import java.util.List;

/**
 * Queen checker
 *
 * @author Amir Gusmanov
 */
public class QueenChecker extends Checker {

    public QueenChecker(boolean isWhite, BoardCoordinate coordinate) {
        super(isWhite, coordinate);
    }

    /**
     * Method which defines how queen checker moves
     *
     * @param finish - end coordinate
     * @return
     */
    @Override
    public boolean canMove(BoardCoordinate finish) {

        int deltaVertical = finish.getVertical().getIndex() - this.getCoordinate().getVertical().getIndex();
        int deltaHorizontal = finish.getHorizontal().getIndex() - this.getCoordinate().getHorizontal().getIndex();

        return (Math.abs(deltaHorizontal) == Math.abs(deltaVertical) && deltaHorizontal > 0);

    }

    @Override
    public List<BoardCoordinate> trace(BoardCoordinate target) throws ImpossibleMoveException {
        return null;
    }


}
