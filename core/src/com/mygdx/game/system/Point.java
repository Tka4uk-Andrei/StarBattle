package com.mygdx.game.system;

public class Point {
    private float x;
    private float y;

    public Point() {
        x = -1;
        y = -1;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setPoint(Point point) {
        x = point.getX();
        y = point.getY();
    }

    public boolean inRangeThatPoint(Point point, double xRange, double yRange) {
        return inRangeXThatPoint(point, xRange) && inRangeYThatPoint(point, yRange);
    }

    public boolean inRangeXThatPoint(Point point, double xRange) {
        return this.x - xRange / 2 <= point.getX() && point.getX() <= this.x + xRange / 2;
    }

    public boolean inRangeYThatPoint(Point point, double yRange) {
        return this.y - yRange / 2 <= point.getY() && point.getY() <= this.y + yRange / 2;
    }

    public boolean equals(Point point) {
        return this.x == point.getX() && this.y == point.getY();
    }
}
