package com.mygdx.game.textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class TexturesGetter {

    public static Array<Texture> getTextures(String dir, String[] files){
        Array<Texture> textures = new Array<Texture>();

        for (String file : files)
            textures.add(new Texture(dir + file));

        return textures;
    }


}
