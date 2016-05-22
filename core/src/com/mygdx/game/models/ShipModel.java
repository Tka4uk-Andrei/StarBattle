package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class ShipModel {

    private int side = 0;
    private int currentFrame = 0;
    private float rotation = 0;
    private Point centerPoint;
    private Point originPoint;

    public ShipModel (Point centerPoint, Point originPoint, int currentFrame, int side) {

        this.centerPoint = new Point(centerPoint);
        this.originPoint = new Point (originPoint);
        this.currentFrame = currentFrame;
        this.side = side;
    }


    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Point getOriginPoint() {
        return originPoint;
    }

    public void setOriginPoint(Point originPoint) {
        this.originPoint = originPoint;
    }
}
