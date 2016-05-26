package com.mygdx.game.textures.progress;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.system.TexturesPack;

public class ProgressTexture extends TexturesPack {

    private Array<Texture> textures;
    private int frameTime;

    public ProgressTexture(int frameCount, int sizeXY, Color color, int lineWidth, int animationTime) {

        textures = new Array<Texture>();

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
                textures.add(new Texture(pixmap));
                j++;
            }
        }

        for (float y = width + 10; y >= 10; y -= .01) {
            x = (float) -Math.sqrt(Math.pow(width / 2, 2) - Math.pow(y - y0, 2)) + x0;
            pixmap.fillCircle((int) x, (int) y, lineWidth);
            if ((x - x0) == 0 || Math.toDegrees(Math.atan((y - y0) / (x - x0))) + 270 >= deltaDegree * j) {
                textures.add(new Texture(pixmap));
                j++;
            }
        }

        pixmap.dispose();
        frameTime = animationTime / textures.size;
    }

    public ProgressTexture(int frameCount, int sizeXY, Color color, int animationTime) {

        textures = new Array<Texture>();

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
                textures.add(new Texture(pixmap));
                j++;
            }
        }

        for (float y = width + 10; y >= 10; y -= .005) {
            x = (float) -Math.sqrt(Math.pow(width / 2, 2) - Math.pow(y - y0, 2)) + x0;
            pixmap.drawPixel((int) x, (int) y);

            if ((x - x0) == 0 || Math.toDegrees(Math.atan((y - y0) / (x - x0))) + 270 >= deltaDegree * j) {
                textures.add(new Texture(pixmap));
                j++;
            }
        }

        pixmap.dispose();
        frameTime = animationTime / textures.size;
    }

    @Override
    public Array<Texture> getTextures() {
        return textures;
    }

    @Override
    public int getFrameTime() {
        return frameTime;
    }

    @Override
    public float getDeltaDegree() {
        return 0;
    }

    @Override
    public void dispose() {
        for (Texture texture : textures)
            texture.dispose();
    }

    public static class Constants {

        public static final int SHIP_BILD_FRAMES = 120;
        public static final int BILD_TIME = 5000;

    }
}
