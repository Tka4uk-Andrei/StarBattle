package com.mygdx.game.system;

import com.badlogic.gdx.graphics.Texture;

public class View {

    private TexturesPack textures;
    private long time;
    private Point originPoint;
    private Point renderPoint;
    private float rotation;

    private int currentFrame;

    public View(TexturesPack texturesPack, Point centerPoint, Point originPoint, int currentFrame, float rotation) {
        time = System.currentTimeMillis();
        textures = texturesPack;
        this.currentFrame = currentFrame;
        renderPoint = new Point(centerPoint.getX() - textures.getTextures().get(currentFrame).getWidth() / 2,
                centerPoint.getY() - textures.getTextures().get(currentFrame).getHeight() / 2);

        this.originPoint = new Point(originPoint.getX() - renderPoint.getX(), originPoint.getY() - renderPoint.getY());
        this.rotation = rotation;
    }

    public View(TexturesPack texturesPack, Point centerPoint, int currentFrame) {
        time = System.currentTimeMillis();
        textures = texturesPack;
        this.currentFrame = currentFrame;
        renderPoint = new Point(centerPoint.getX() - textures.getTextures().get(currentFrame).getWidth() / 2,
                centerPoint.getY() - textures.getTextures().get(currentFrame).getHeight() / 2);
        originPoint = new Point(textures.getTextures().get(currentFrame).getWidth() / 2, textures.getTextures().get(currentFrame).getHeight() / 2);
    }

    public void update(boolean rotationFlag) {
        if (System.currentTimeMillis() - time >= textures.getFrameTime()) {
            time = System.currentTimeMillis();
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

    public void setOriginPointInCenter() {
        originPoint.setX(textures.getTextures().get(currentFrame).getWidth() / 2);
        originPoint.setY(textures.getTextures().get(currentFrame).getHeight() / 2);
    }

    public Point getRenderPoint() {
        return renderPoint;
    }

    public void setRenderPoint(Point centerPoint) {
        renderPoint.setX(centerPoint.getX() - textures.getTextures().get(currentFrame).getWidth() / 2);
        renderPoint.setY(centerPoint.getY() - textures.getTextures().get(currentFrame).getHeight() / 2);
    }

    public Texture getFrame() {
        return textures.getTextures().get(currentFrame);
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public TexturesPack getTexturesPack() {
        return textures;
    }

    public void setTexturesPack(TexturesPack textures) {
//        renderPoint.setX(getRenderPoint().getX() + this.textures.getTextures().get(currentFrame).getWidth() / 2);
//        renderPoint.setY(getRenderPoint().getX() + this.textures.getTextures().get(currentFrame).getHeight() / 2);

        this.textures = textures;

//        renderPoint.setX(getRenderPoint().getX() - this.textures.getTextures().get(currentFrame).getWidth() / 2);
//        renderPoint.setY(getRenderPoint().getX() - this.textures.getTextures().get(currentFrame).getHeight() / 2);
    }

    public void setTime(long time) {
        this.time = time;
    }
}
