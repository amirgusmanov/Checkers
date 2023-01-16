package com.company.checker;

import com.company.coordinate.BoardCoordinate;
import com.company.exceptions.ImpossibleMoveException;

import java.util.List;

/**
 * Default simple checker
 *
 * @author Amir Gusmanov
 */
public class SimpleChecker extends Checker {

    public SimpleChecker(BoardCoordinate coordinate, boolean isWhite) {
        super(isWhite, coordinate);
    }

    /**
     * Method which defines how can checker move
     *
     * @param finish - end coordinate
     * @return
     */
    @Override
    public boolean canMove(BoardCoordinate finish) {

        checkBoardCoordinateCompatibilityOrThrowException((BoardCoordinate) finish);
        int deltaVertical = finish.getVertical().getIndex() - this.getCoordinate().getVertical().getIndex();
        int deltaHorizontal = finish.getVertical().getIndex() - this.getCoordinate().getVertical().getIndex();

        if (Math.abs(deltaVertical) != ACCEPTABLE_ABSOLUTE_DELTA_VERTICAL) {
            return false;
        }
        if (isWhite()) {
            return deltaHorizontal == ACCEPTABLE_ABSOLUTE_DELTA_HORIZONTAL_WHITE;
        } else {
            return deltaHorizontal == ACCEPTABLE_ABSOLUTE_DELTA_HORIZONTAL_BLACK;
        }

    }

    //Difference in indexes of possible move
    public static final int ACCEPTABLE_ABSOLUTE_DELTA_VERTICAL = 1;
    public static final int ACCEPTABLE_ABSOLUTE_DELTA_HORIZONTAL_WHITE = 1;
    public static final int ACCEPTABLE_ABSOLUTE_DELTA_HORIZONTAL_BLACK = -1;

    @Override
    public List<BoardCoordinate> trace(BoardCoordinate target) throws ImpossibleMoveException {
        return null;
    }

}

