package com.mygdx.game.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.system.TexturesPack;

public class TexturePackForTexture extends TexturesPack {

    private Array<Texture> textures;

    public TexturePackForTexture(Texture texture) {
        textures = new Array<Texture>();
        textures.add(texture);
    }

    @Override
    public Array<Texture> getTextures() {
        return textures;
    }

    @Override
    public int getFrameTime() {
        return 10000;
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
}
