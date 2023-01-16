package com.company.deskgame;

import com.company.checker.Checker;
import com.company.checker.QueenChecker;
import com.company.coordinate.BoardCoordinate;
import com.company.coordinate.Vertical;
import com.company.exceptions.ImpossibleMoveException;
import com.company.move.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasicDesk extends Desk {

    private Checker eatingSpreeChecker;

    public BasicDesk(List<Checker> checkerList) {
        super(checkerList);
        eatingSpreeChecker = null;
    }

    @Override
    public void handle(Move m) {

        for (Checker checker : getCheckerList()) {
            if (canBeEaten(checker) && checker.isWhite() != isWhiteMove()) {
                Checker c = findCheckerOrNull(m.getStart());
                eatingSpreeChecker = c;
                handleEating(m);
            }
        }

        Checker checker = findChecker(m.getStart());
        if (!checker.canMove(m.getTarget())) {
            throw new ImpossibleMoveException(checker, m.getTarget());
        }
        if (checker.isWhite() != this.isWhiteMove()) {
            throw new ImpossibleMoveException(checker, m.getTarget());
        }
        if (checker.isWhite() && checker.getCoordinate().getVertical().equals(Vertical.VIII)) {
            turningIntoAWhiteQueen(checker);
        }
        if (!checker.isWhite() && checker.getCoordinate().getVertical().equals(Vertical.I)) {
            turningIntoABlackQueen(checker);
        }

        Checker targetChecker = findCheckerOrNull(m.getTarget());
        if (targetChecker != null) {
            if (targetChecker.isWhite() == checker.isWhite()) {
                throw new ImpossibleMoveException(checker, m.getTarget());
            }
            handleEating(m);
        }
        handleSimpleMove(m);

    }

    private boolean canBeEaten(Checker checker) {

        if (!getCheckerList().contains(checker)) {
            throw new RuntimeException(String.format("Checker {%s} is not on the desk", checker));
        }
        return canBeEatenSimple(checker) || canBeEatenQueen(checker);

    }

    private boolean canBeEatenSimple(Checker checker) {

        if (!getCheckerList().contains(checker)) {
            throw new RuntimeException(String.format("Checker {%s} is not on the desk", checker));
        }

        List<BoardCoordinate> coordinates = checker.getCoordinate().adjacentCoordinates();
        List<Checker> adjacentCheckers = new ArrayList<>();

        for (BoardCoordinate coordinate : coordinates) {
            Checker c = findCheckerOrNull(coordinate);
            if (c != null)
                adjacentCheckers.add(c);
        }

        List<Checker> adjacentEnemies = new ArrayList<>();
        for (Checker c : adjacentCheckers) {
            if (c.isWhite() != checker.isWhite())
                adjacentEnemies.add(c);
        }
        if (adjacentEnemies.isEmpty()) {
            return false;
        }
        for (Checker enemy : adjacentEnemies) {
            List<BoardCoordinate> diagonals = enemy.getCoordinate().diagonals();
            List<BoardCoordinate> intersections = new ArrayList<>();
            for (BoardCoordinate dp : diagonals) {
                for (BoardCoordinate ap : coordinates) {
                    if (dp.equals(ap))
                        intersections.add(dp);
                }
            }
            if (intersections.isEmpty())
                return true;
        }
        return false;

    }

    private boolean canBeEatenQueen(Checker checker) {

        if (!getCheckerList().contains(checker)) {
            throw new RuntimeException(String.format("Checker {%s} is not in the game", checker));
        }

        List<QueenChecker> enemyQueens = new ArrayList<>();

        for (Checker c : getCheckerList()) {
            if (c instanceof QueenChecker && c.isWhite() != checker.isWhite()) {
                enemyQueens.add((QueenChecker) c);
            }
        }

        List<BoardCoordinate> adjacentCoordinates = checker.getCoordinate().adjacentCoordinates();

        for (Checker queen : enemyQueens) {
            List<BoardCoordinate> diagonals = queen.getCoordinate().diagonals();
            List<BoardCoordinate> intersections = new ArrayList<>();
            for (BoardCoordinate diagonalCoordinate : diagonals) {
                for (BoardCoordinate adjacentCoordinate : adjacentCoordinates) {
                    if (diagonalCoordinate.equals(adjacentCoordinate)) {
                        intersections.add(adjacentCoordinate);
                    }
                }
            }
            if (intersections.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void handleEating(Move m) {
        if (eatingSpreeChecker != null) {
            if (!findChecker(m.getStart()).equals(eatingSpreeChecker)) {
                throw new ImpossibleMoveException(findChecker(m.getTarget()), m.getTarget());
            }
            if (findChecker(m.getStart()).equals(eatingSpreeChecker)) {
                getCheckerList().remove(findChecker(m.getTarget()));
            }
        }
    }

    private void handleSimpleMove(Move m) {
        if (eatingSpreeChecker != null) {
            if (!findChecker((m.getStart())).equals(eatingSpreeChecker)) {
                throw new ImpossibleMoveException(findChecker(m.getTarget()), m.getTarget());
            }
            if (findChecker(m.getStart()).equals(eatingSpreeChecker)) {
                //TODO: ...
                findChecker(m.getTarget()).getCoordinate().getVertical().next();
            }
        }
    }

    public void turningIntoAWhiteQueen(Checker checker) {
        getCheckerList().set(getCheckerList().indexOf(checker), new QueenChecker(true, checker.getCoordinate()));
    }

    public void turningIntoABlackQueen(Checker checker) {
        getCheckerList().set(getCheckerList().indexOf(checker), new QueenChecker(false, checker.getCoordinate()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BasicDesk basicDesk = (BasicDesk) o;
        return Objects.equals(eatingSpreeChecker, basicDesk.eatingSpreeChecker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eatingSpreeChecker);
    }

    @Override
    public String toString() {
        return "BasicDesk{" +
                "eatingSpreeChecker=" + eatingSpreeChecker +
                '}';
    }
}
