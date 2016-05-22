package com.mygdx.game.system;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public abstract class TexturesPack {

    public abstract Array<Texture> getTextures();

    public abstract int getFrameTime();

    public abstract float getDeltaDegree();
}
