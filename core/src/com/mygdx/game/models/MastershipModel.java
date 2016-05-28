package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class MastershipModel {

    private Point centerPoint;

    private int side;

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public MastershipModel (Point centerPoint, int side) {
        this.centerPoint = new Point(centerPoint);
        this.side = side;
    }

    public int getSide(){
        return side;
    }
}
