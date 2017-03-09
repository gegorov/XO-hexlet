package io.hexlet.xo.model;

import java.awt.*;

/**
 * Created by gennadi on 09.03.17.
 */
public class Field {

    private final static int FIELD_SIZE = 3;

    private final  static int MIN_COORDINATE = 0;

    private final  static int MAX_COORDINATE = FIELD_SIZE;

    private final Figure [][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {

        return FIELD_SIZE;

    }

    public Figure getFigure (final Point point) {
        return field[point.x][point.y];
    }

    public void setFigure (final Point point, final Figure figure) {
        field[point.x][point.y] = figure;

    }

    private boolean checkPoint( final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);

    }

    private boolean checkCoordinate (final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }

}
