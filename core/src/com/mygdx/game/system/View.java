package com.mygdx.game.system;

public class View {

    private TexturesPack textures;
    private long time;
    private Point originPoint;
    private Point renderPoint;
    private float rotation;

    private int currentFrame;

    public View(TexturesPack texturesPack, Point centerPoint, int currentFrame) {
        time = System.currentTimeMillis();
        textures = texturesPack;
        this.currentFrame = currentFrame;
        renderPoint = new Point(centerPoint.getX() - textures.getTextures().get(currentFrame).getWidth(),
                centerPoint.getY() - textures.getTextures().get(currentFrame).getHeight());
        originPoint = new Point(centerPoint);
    }

    public void update(boolean rotationFlag) {
        if (System.currentTimeMillis() - time >= textures.getFrameTime()) {
            currentFrame = (currentFrame + 1) % textures.getTextures().size;
            if (rotationFlag) {
                rotation += textures.getDeltaDegree();
                if (rotation >= 360)
                    rotation -= 360;
            }
        }
    }

    public Point getOriginPoint() {
        return originPoint;
    }

    public void setOriginPoint(Point originPoint) {
        this.originPoint = originPoint;
    }

    public Point getRenderPoint() {
        return renderPoint;
    }

    public void setRenderPoint(Point centerPoint) {
        renderPoint.setX(centerPoint.getX() - textures.getTextures().get(currentFrame).getWidth());
        renderPoint.setY(centerPoint.getY() - textures.getTextures().get(currentFrame).getHeight());
    }
}
