package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class ShipModel {

    private int side = 0;
    private Point centerPoint;
    private int type;
    private int count;

    public ShipModel(ShipModel shipModel) {

        this.side = shipModel.getSide();
        this.type = shipModel.getType();
        this.count = shipModel.getCount();

        this.centerPoint = new Point();
        if (shipModel.getCenterPoint() != null)
            this.centerPoint.setPoint(shipModel.getCenterPoint());
    }

    public ShipModel(Point centerPoint, int side, int type, int count) {

        this.centerPoint = new Point(centerPoint);
        this.side = side;
        this.type = type;
        this.count = count;

    }

    public ShipModel(int side, int type, int count) {

        this.centerPoint = new Point();
        this.side = side;
        this.type = type;
        this.count = count;

    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

//    public int getCurrentFrame() {
//        return currentFrame;
//    }

//    public void setCurrentFrame(int currentFrame) {
//        this.currentFrame = currentFrame;
//    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static class Constants {

        public static class Types {

            public static final int RAPTOR = 1;

            public static final int SHIELD = 2;
            public static final int TWO_SHIELD = 3;
            public static final int ONE_SHIELD = 4;

            public static final int CRUISER = 5;
            public static final int TWO_CRUISER = 6;
            public static final int ONE_CRUISER = 7;

            public static final int COUNT = 7;
        }

        public static class Health {

            public static final int RAPTOR = 1;

            public static final int SHIELD = 3;
            public static final int TWO_SHIELD = 2;
            public static final int ONE_SHIELD = 1;

            public static final int CRUISER = 3;
            public static final int TWO_CRUISER = 2;
            public static final int ONE_CRUISER = 1;
        }

    }
}
