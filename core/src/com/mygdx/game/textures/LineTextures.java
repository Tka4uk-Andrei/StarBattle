package com.mygdx.game.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.system.TexturesPack;

public class LineTextures extends TexturesPack {

    Array<Texture> textures;

    public LineTextures(Texture texture) {
        textures = new Array<Texture>();
        textures.add(texture);
    }

    @Override
    public Array<Texture> getTextures() {
        return textures;
    }

    @Override
    public int getFrameTime() {
        return Constants.FRAME_TIME;
    }

    @Override
    public float getDeltaDegree() {
        return Constants.DELTA_DEGREE;
    }

    private static class Constants {

        public static final int FRAME_TIME = 10000;

        public static float DELTA_DEGREE = 0;
    }
}
