package com.mygdx.game.textures.stars.factory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.textures.TexturesGetter;

public class FactoryStarTexturesNone extends TexturesPack {

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

    private static class Constants {

        public static final String DIR = "FactoryStar/none/";

        public static final String FILES[] = new String[]{"1.png", "2.png", "3.png",
                "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "10.png", "11.png", "12.png",
                "13.png", "14.png", "15.png", "16.png", "17.png", "18.png", "19.png"};

        public static final int FRAME_TIME = 60;

        public static float DELTA_DEGREE = 0;
    }
}
