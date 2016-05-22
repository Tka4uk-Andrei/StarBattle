package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class StarModel {

    private int side = 0;
    private int currentFrame;
    private Point centerPoint;
    private int type;
    private int connectedStars[];

    public StarModel(Point centerPoint, int currentFrame, int type, int[] connectedStars) {
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
