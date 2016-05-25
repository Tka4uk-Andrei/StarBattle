package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;
import com.mygdx.game.textures.focus.FocusTexture;

public class AdvancedFactory extends Star {

    private BasicStar basicStar;

    public AdvancedFactory(StarModel starModel, ConditionTextures starTextures,
                     ShipTexturesContainer shipsTextures, Array<StarModel> starModels, int currentFrame,
                           FocusTexture focusTexture) {
        basicStar = new BasicStar(starModel, starTextures, shipsTextures, starModels, currentFrame,
                focusTexture);
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
    public void onTouch(Point touch) {
        basicStar.onTouch(touch);
    }
}
