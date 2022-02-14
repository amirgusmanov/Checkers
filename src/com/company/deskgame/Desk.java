package com.company.deskgame;

import com.company.checker.Checker;
import com.company.coordinate.BoardCoordinate;
import com.company.exceptions.CheckerNotFoundException;
import com.company.move.Move;

import java.util.List;
import java.util.Objects;

public abstract class Desk {

    private List<Checker> checkerList;

    private boolean isWhiteMove;

    public abstract void handle(Move m);

    public Desk(List<Checker> checkerList){
        this.checkerList = checkerList;
        isWhiteMove = true;
    }

    public Checker findChecker(BoardCoordinate coordinate){
        for(Checker checker : getCheckerList()){
            if(checker.getCoordinate().equals(coordinate)){
                return checker;
            }
        }
        throw new CheckerNotFoundException(coordinate);
    }

    public Checker findCheckerOrNull(BoardCoordinate coordinate){
        for(Checker checker : getCheckerList()){
            if(checker.getCoordinate().equals(coordinate)){
                return checker;
            }
        }
        return null;
    }

    public List<Checker> getCheckerList() {
        return checkerList;
    }

    public void setCheckerList(List<Checker> checkerList) {
        this.checkerList = checkerList;
    }

    public boolean isWhiteMove() {
        return isWhiteMove;
    }

    public void setWhiteMove(boolean whiteMove) {
        isWhiteMove = whiteMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desk desk = (Desk) o;
        return isWhiteMove == desk.isWhiteMove && Objects.equals(checkerList, desk.checkerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkerList, isWhiteMove);
    }

    @Override
    public String toString() {
        return "Desk{" +
                "checkerList=" + checkerList +
                ", isWhiteMove=" + isWhiteMove +
                '}';
    }
}
