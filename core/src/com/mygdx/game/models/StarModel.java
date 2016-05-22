package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class StarModel {

    private int side = 0;
    private int currentFrame;
    private Point centerPoint;

    public StarModel(Point centerPoint, int currentFrame) {
        this.centerPoint = new Point(centerPoint);
        this.currentFrame = currentFrame;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }
}
