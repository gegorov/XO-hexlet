package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;


public class WinnerController {

    public Figure getWinner(final Field field) {
        try {
            //check line via Lambda
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(i, 0),  point -> new Point(point.x, point.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }
            // check column
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), point -> new Point(point.x + 1, point.y ))) {

                    return field.getFigure(new Point(0, i));
                }
            }
            //check diag 1
            //for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, 0), point -> new Point(point.x + 1, point.y + 1))) {

                    return field.getFigure(new Point(1, 1));
                }
            //}
            //check diag 2
            //for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, 2), point -> new Point(point.x + 1, point.y - 1))) {

                    return field.getFigure(new Point(1, 1));
                }
            //}





        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null){
                return false;
            }

            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }


        if (currentFigure != nextFigure){
            return false;
        }

        return check(field, nextPoint, pointGenerator);
    }

//    private interface IPointChanger{
//        Point next(final Point point);
//    }

    private interface IPointGenerator{
         Point next(final Point point);
    }
}
