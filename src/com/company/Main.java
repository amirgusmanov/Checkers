package com.company;

import com.company.deskgame.BasicDesk;
import com.company.deskgame.CheckerFiller;
import com.company.deskgame.Desk;
import com.company.move.Move;
import com.company.ui.ConsoleUI;
import com.company.ui.UserInterface;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Desk game = new BasicDesk(new ArrayList<>());
        CheckerFiller checkerFiller = new CheckerFiller(new ArrayList<>(), game);
        UserInterface ui = new ConsoleUI(new Scanner(System.in), game, checkerFiller);
        checkerFiller.checkerFiller();
        ui.showDesk();

        while(true) {
            Move nextMove = ui.nextMove();
            game.handle(nextMove);
            ui.showDesk();
        }
    }
}
