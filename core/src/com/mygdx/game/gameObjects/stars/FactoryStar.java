package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;

public class FactoryStar extends Star {

    private BasicStar basicStar;

    public FactoryStar(StarModel starModel, ConditionTextures starTextures,
                     ShipTexturesContainer shipsTextures, Array<StarModel> starModels, int currentFrame) {
        basicStar = new BasicStar(starModel, starTextures, shipsTextures, starModels, currentFrame);
    }

    @Override
    public BasicStar getBasicStar() {
        return basicStar;
    }

    @Override
    public Array<View> getViews() {
        Array<View> views = basicStar.getViews();

        return views;
    }

    @Override
    public void onTouch() {

    }
}
