package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class ShipModel {

    private int side = 0;
    private int currentFrame = 0;
    private Point centerPoint;

    public ShipModel (Point centerPoint, int currentFrame, int side) {

        this.centerPoint = new Point(centerPoint);
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

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }
}
