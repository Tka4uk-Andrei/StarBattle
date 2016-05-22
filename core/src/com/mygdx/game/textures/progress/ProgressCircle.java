package com.mygdx.game.textures.progress;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class ProgressCircle {

    private Texture circle[];
    private int currentFrame;
    private long time;
    private int frameTime;

    private boolean done;
    private boolean firstDone;

    public ProgressCircle(int frameCount, int sizeXY, Color color, int lineWidth, int frameTime) {

        circle = new Texture[frameCount];

        int width = sizeXY - 20;

        float deltaDegree = 360 / frameCount;
        float x;
        int j = 0;
        float x0 = width / 2 + 10;
        float y0 = width / 2 + 10;

        Pixmap pixmap = new Pixmap(sizeXY, sizeXY, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);

        for (float y = 10; y <= width + 10; y += .01) {

            x = (float) Math.sqrt(Math.pow(width / 2, 2) - Math.pow(y - y0, 2)) + x0;

            pixmap.fillCircle((int) x, (int) y, lineWidth);

            if ((x - x0 == 0) || (Math.toDegrees(Math.atan((y - y0) / Math.abs(x - x0))) + 90 >= (deltaDegree * j))) {
                circle[j] = new Texture(pixmap);
                j++;
            }
        }

        for (float y = width + 10; y >= 10; y -= .01) {

            x = (float) -Math.sqrt(Math.pow(width / 2, 2) - Math.pow(y - y0, 2)) + x0;

            pixmap.fillCircle((int) x, (int) y, lineWidth);

            if ((x - x0) == 0 || Math.toDegrees(Math.atan((y - y0) / (x - x0))) + 270 >= deltaDegree * j) {
                circle[j] = new Texture(pixmap);
                j++;
            }
        }

        pixmap.dispose();

        currentFrame = 0;
        time = System.currentTimeMillis();
        this.frameTime = frameTime;

        done = false;
        firstDone = true;
    }

    public ProgressCircle(int frameCount, int sizeXY, Color color, int frameTime) {

        circle = new Texture[frameCount];

        int width = sizeXY - 20;

        float deltaDegree = 360 / frameCount;
        float x;
        int j = 0;
        float x0 = width / 2 + 10;
        float y0 = width / 2 + 10;

        Pixmap pixmap = new Pixmap(sizeXY, sizeXY, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);

        for (float y = 10; y <= width + 10; y += .005) {

            x = (float) Math.sqrt(Math.pow(width / 2, 2) - Math.pow(y - y0, 2)) + x0;

            pixmap.drawPixel((int) x, (int) y);

            if ((x - x0 == 0) || (Math.toDegrees(Math.atan((y - y0) / Math.abs(x - x0))) + 90 >= (deltaDegree * j))) {
                circle[j] = new Texture(pixmap);
                j++;
            }
        }

        for (float y = width + 10; y >= 10; y -= .005) {

            x = (float) -Math.sqrt(Math.pow(width / 2, 2) - Math.pow(y - y0, 2)) + x0;

            pixmap.drawPixel((int) x, (int) y);

            if ((x - x0) == 0 || Math.toDegrees(Math.atan((y - y0) / (x - x0))) + 270 >= deltaDegree * j) {
                circle[j] = new Texture(pixmap);
                j++;
            }
        }

        pixmap.dispose();

        currentFrame = 0;
        time = System.currentTimeMillis();
        this.frameTime = frameTime;
    }

    private void update() {
        if (System.currentTimeMillis() - time >= frameTime) {
            time = System.currentTimeMillis();
            currentFrame = (currentFrame + 1) % circle.length;
        }

        if (currentFrame == (circle.length - 1) && firstDone) {
            done = true;
            firstDone = false;
        } else {
            done = false;
            if (currentFrame != (circle.length - 1))
                firstDone = true;
        }
    }

    public int getLength() {
        return circle.length;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public Texture getFrame() {
        update();

        return circle[currentFrame];
    }

    public void dispose() {
        for (Texture aCircle : circle) aCircle.dispose();
    }

    public boolean isDone() {
        return done;
    }
}
