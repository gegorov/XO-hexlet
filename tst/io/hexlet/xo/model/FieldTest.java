package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by gennadi on 09.03.17.
 */
public class FieldTest {
    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field();

        assertEquals(3, field.getSize());

    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure acctualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, acctualFigure);


    }

//    @Test
//    public void testSetFigureWhenAlreadyOccupied() throws Exception {
//        final Field field = new Field();
//        final Point inputPoint = new Point(0,0);
//
//        final Figure inputFigure = Figure.O;
//
//        field.setFigure(inputPoint, inputFigure);
//
//        try {
//            field.setFigure(inputPoint, inputFigure);
//            fail();
//        } catch (final AlreadyOccupiedException e){}
//    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);


        final Figure acctualFigure = field.getFigure(inputPoint);

        assertNull(acctualFigure);


    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}

    }
    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}

    }

}