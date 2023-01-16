package com.company.coordinate;

import com.company.exceptions.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class CheckersDeskBoardCoordinate extends BoardCoordinate {

    public CheckersDeskBoardCoordinate(Vertical vertical, Horizontal horizontal) {
        super(vertical, horizontal);
    }

    @Override
    public List<BoardCoordinate> adjacentCoordinates() {

        List<Vertical> adjacentVerticals = new ArrayList<>();

        if (this.getVertical().getIndex() != 0 && this.getVertical().getIndex() != Vertical.values().length) {
            adjacentVerticals.add((Vertical) this.getVertical().next());
            adjacentVerticals.add((Vertical) this.getVertical().previous());
        } else if (this.getVertical().getIndex() == 0) {
            adjacentVerticals.add((Vertical) this.getVertical().next());
        } else if (this.getVertical().getIndex() == Vertical.values().length) {
            adjacentVerticals.add((Vertical) this.getVertical().previous());
        }

        List<Horizontal> adjacentHorizontals = new ArrayList<>();

        if (this.getHorizontal().getIndex() != 0 && this.getHorizontal().getIndex() != Horizontal.values().length) {
            adjacentHorizontals.add((Horizontal) this.getHorizontal().next());
            adjacentHorizontals.add((Horizontal) this.getHorizontal().previous());
        } else if (this.getVertical().getIndex() == 0) {
            adjacentHorizontals.add((Horizontal) this.getHorizontal().previous());
        } else if (this.getVertical().getIndex() == Horizontal.values().length) {
            adjacentHorizontals.add((Horizontal) this.getVertical().next());
        }

        List<BoardCoordinate> adjacentPositions = new ArrayList<>();

        for (Vertical v : adjacentVerticals) {
            for (Horizontal h : adjacentHorizontals) {
                adjacentPositions.add(new CheckersDeskBoardCoordinate(v, h));
            }
        }
        return adjacentPositions;
    }

    @Override
    public List<BoardCoordinate> diagonals() {
        int currentVerticalIndex = this.getVertical().getIndex();
        int currentHorizontalIndex = this.getHorizontal().getIndex();

        throw new NotImplementedException();
    }
}

