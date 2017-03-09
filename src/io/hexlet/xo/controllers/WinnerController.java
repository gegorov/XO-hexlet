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
                if (check(field, new Point(i, 0),  point -> new Point(point.x + 1, point.y))) {
                    return field.getFigure(new Point(i, 0));
                }
            }
            // check column
            for (int i = 0; i < 3; i++) {
                if (check(field, new Point(0, i), new IPointChanger() {
                    @Override
                    public Point next(Point point) {
                        return new Point(point.x + 1,point.y );
                    }
                })) {
                    return field.getFigure(new Point(0, i));
                }
            }
            //check diag 1

            if (check(field, new Point(0, 0), new IPointChanger() {
                @Override
                public Point next(Point point) {
                    return new Point(point.x + 1,point.y + 1 );
                }
            })) {
                return field.getFigure(new Point(1, 1));
            }
            // check diag 2
            if (check(field, new Point(0, 2), new IPointChanger() {
                @Override
                public Point next(Point point) {
                    return new Point(point.x + 1,point.y - 1 );
                }
            })) {
                return field.getFigure(new Point(1, 1));
            }

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    private boolean check(final Field field, final Point startPoint, IPointChanger pointChanger) {
        final Point p1 = startPoint;
        final Point p2 = pointChanger.next(p1);
        final Point p3 = pointChanger.next(p2);
        try {
            if (field.getFigure(p1) == null) {
                return false;
            }
            if (field.getFigure(p1) == field.getFigure(p2) && field.getFigure(p1) == field.getFigure(p3)) {
                return true;
            }
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;
    }

    private interface IPointChanger{
        Point next(final Point point);
    }
}
