package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class StarModel {

    private int mastership;
    private int side = 0;
    private int currentFrame;
    private Point centerPoint;
    private int type;
    private int connectedStars[];
    private FleetModel fleetModel;

    public StarModel(Point centerPoint, int currentFrame, int type, int[] connectedStars, FleetModel fleetModel) {
        this.centerPoint = new Point(centerPoint);
        this.currentFrame = currentFrame;
        this.connectedStars = connectedStars;
        this.fleetModel = fleetModel;
        this.type = type;
        mastership = 0;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int[] getConnectedStars() {
        return connectedStars;
    }

    public void setConnectedStars(int[] connectedStars) {
        this.connectedStars = connectedStars;
    }

    public FleetModel getFleetModel() {
        return fleetModel;
    }

    public void setFleetModel(FleetModel fleetModel) {
        this.fleetModel = fleetModel;
    }

    public int getMastership() {
        return mastership;
    }

    public void setMastership(int mastership) {
        this.mastership = mastership;
    }

    public static class Constants {

        public static class Types {
            public static final int SMALL = 1;
            public static final int MINE = 2;
            public static final int FACTORY = 3;
            public static final int ADVANCED_FACTORY = 4;
        }

    }
}
