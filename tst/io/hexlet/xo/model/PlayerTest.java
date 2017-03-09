package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gennadi on 09.03.17.
 */
public class PlayerTest {
    @Test
    public void testGetName() throws Exception {
        final String inputVaue = "Slava";
        final String expectedValue = "Slava";

        final Player player = new Player(inputVaue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);


    }

    @Test
    public void testGetFigure() throws Exception {

        final Figure inputVaue = Figure.X;
        final Figure expectedValue = inputVaue;


        final Player player = new Player(null, inputVaue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);

    }

}