package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class MastershipModel {

    private Point centerPoint;

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public MastershipModel (Point centerPoint) {
        this.centerPoint = new Point(centerPoint);
    }
}
