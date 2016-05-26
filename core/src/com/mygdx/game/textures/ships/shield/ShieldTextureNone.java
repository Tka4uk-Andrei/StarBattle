package com.mygdx.game.textures.ships.shield;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.textures.TexturesGetter;

public class ShieldTextureNone extends TexturesPack {

    private Array<Texture> textures = TexturesGetter.getTextures(Constants.DIR, Constants.FILES);

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

    @Override
    public void dispose() {
        for (Texture texture : textures)
            texture.dispose();
    }

    private static class Constants {

        public static final String DIR = "Shield/none/";

        public static final String FILES[] = new String[]{"1.png"};

        public static final int FRAME_TIME = 60;

        public static float DELTA_DEGREE = -3f;
    }
}
