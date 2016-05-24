package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.FleetManager;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.View;

public class FactoryStar extends Star {

    @Override
    public BasicStar getBasicStar() {
        return null;
    }

    @Override
    public Array<View> getViews() {
        return null;
    }
}
