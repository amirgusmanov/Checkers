package com.company.ui;

import com.company.coordinate.BoardCoordinate;
import com.company.coordinate.CheckersDeskBoardCoordinate;
import com.company.coordinate.Horizontal;
import com.company.coordinate.Vertical;
import com.company.deskgame.CheckerFiller;
import com.company.deskgame.Desk;
import com.company.move.Move;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements UserInterface {

    private Scanner scanner;
    private Desk game;
    private CheckerFiller checkerFiller;

    public ConsoleUI(Scanner scanner, Desk game, CheckerFiller checkerFiller) {
        this.scanner = scanner;
        this.game = game;
        this.checkerFiller = checkerFiller;
    }

    @Override
    public void showDesk() {
        char white = '\u26C0';
        char black = '\u26C2';
        for (CheckersDeskBoardCoordinate coordinates : checkerFiller.getCoordinateList()) {
            if (coordinates.getHorizontal().getIndex() != 8) {
                if (game.findCheckerOrNull(coordinates) == null) {
                    System.out.print("|_");
                } else if (game.findCheckerOrNull(coordinates).isWhite()) {
                    System.out.print("|" + white);
                } else if (!game.findCheckerOrNull(coordinates).isWhite()) {
                    System.out.print("|" + black);
                }
            } else if (coordinates.getHorizontal().getIndex() == 8) {
                if (game.findCheckerOrNull(coordinates) == null) {
                    System.out.print("|_");
                } else if (game.findCheckerOrNull(coordinates).isWhite()) {
                    System.out.print("|" + white);
                } else if (!game.findCheckerOrNull(coordinates).isWhite()) {
                    System.out.print("|" + black);
                }
                System.out.print("|");
                System.out.println();
            }
        }
        System.out.println();
    }

    @Override
    public Move nextMove() {
        String moveCoordinates;
        System.out.print("Enter move coordinates: ");
        moveCoordinates = scanner.nextLine();
        String[] words = moveCoordinates.split("\\s");

        String[] parts1 = {words[0].substring(0, 1), words[0].substring(1, 2)};
        String[] parts2 = {words[1].substring(0, 1), words[1].substring(1, 2)};

        BoardCoordinate startCoordinate = new CheckersDeskBoardCoordinate(Vertical.findByIndex(Integer.parseInt(parts1[1])), Horizontal.valueOf(parts1[0]));
        BoardCoordinate targetCoordinate = new CheckersDeskBoardCoordinate(Vertical.findByIndex(Integer.parseInt(parts2[1])), Horizontal.valueOf(parts2[0]));

        return new Move(startCoordinate, targetCoordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleUI consoleUI = (ConsoleUI) o;
        return Objects.equals(scanner, consoleUI.scanner) && Objects.equals(game, consoleUI.game) && Objects.equals(checkerFiller, consoleUI.checkerFiller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scanner, game, checkerFiller);
    }

    @Override
    public String toString() {
        return "ConsoleUI{" +
                "scanner=" + scanner +
                ", game=" + game +
                ", checkerFiller=" + checkerFiller +
                '}';
    }
}
