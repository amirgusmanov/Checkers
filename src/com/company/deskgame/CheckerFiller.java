package com.company.deskgame;

import com.company.checker.SimpleChecker;
import com.company.coordinate.CheckersDeskBoardCoordinate;
import com.company.coordinate.Horizontal;
import com.company.coordinate.Vertical;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckerFiller implements CheckerGenerator {

    private Desk game;
    private List<CheckersDeskBoardCoordinate> coordinateList;

    public CheckerFiller() {
        this.coordinateList = new ArrayList<>();
    }

    public CheckerFiller(List<CheckersDeskBoardCoordinate> coordinateList, Desk game) {
        this.game = game;
        this.coordinateList = coordinateList;
    }

    public void positionList() {
        Vertical[] verticals = Vertical.values();
        Horizontal[] horizontals = Horizontal.values();
        for(Vertical v : verticals){
            for(Horizontal h : horizontals){
                coordinateList.add(new CheckersDeskBoardCoordinate(v, h));
            }
        }
    }

    @Override
    public void checkerFiller() {
        positionList();
        int i = 1;
        for(CheckersDeskBoardCoordinate coordinates : coordinateList){
            switch (i) {
                case 2, 4, 6, 8, 9, 11, 13, 15, 18, 20, 22, 24 -> game.getCheckerList().add(new SimpleChecker(coordinates, false));
                case 41, 43, 45, 47, 50, 52, 54, 56, 57, 59, 61, 63 -> game.getCheckerList().add(new SimpleChecker(coordinates, true));
            }
            i++;
        }
    }

    public Desk getGame() { return game; }

    public void setGame(Desk game) { this.game = game; }

    public List<CheckersDeskBoardCoordinate> getCoordinateList() { return coordinateList; }

    public void setCoordinateList(List<CheckersDeskBoardCoordinate> coordinateList) { this.coordinateList = coordinateList; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckerFiller that = (CheckerFiller) o;
        return Objects.equals(game, that.game) && Objects.equals(coordinateList, that.coordinateList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, coordinateList);
    }

    @Override
    public String toString() {
        return "CheckerFiller{" +
                "game=" + game +
                ", coordinateList=" + coordinateList +
                '}';
    }
}
