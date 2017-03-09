package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

/**
 * Created by gennadi on 10.03.17.
 */
public class XOCLI {

    public static void main(String[] args) {

        final String name1 = "Marsik";
        final String name2 = "Barsik";

        final Player [] players = new Player[2];

        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView cw = new ConsoleView();
        cw.show(gameXO);

        while (cw.move(gameXO)) {
            cw.show(gameXO);
        }



    }
}
