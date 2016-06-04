package com.mygdx.game.models;

import com.mygdx.game.system.Point;

public class ViewModel {

    private Point centerPoint;
    private Point renderPoint;
    private Point originPoint;
    private float rotation;
    private boolean visible;

    public ViewModel(Point renderPoint, Point originPoint, Point centerPoint, float rotation) {

        this.centerPoint = new Point(centerPoint);
        this.originPoint = new Point(originPoint);
        this.renderPoint = new Point(renderPoint);

        this.rotation = rotation;

        visible = true;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Point getRenderPoint() {
        return renderPoint;
    }

    public void setRenderPoint(Point renderPoint) {
        this.renderPoint = renderPoint;
    }

    public Point getOriginPoint() {
        return originPoint;
    }

    public void setOriginPoint(Point originPoint) {
        this.originPoint = originPoint;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
