package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.FleetManager;
import com.mygdx.game.gameObjects.Line;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.View;

public class SmallStar extends Star {

    private View view;

    private FleetManager fleetManager;

    private Line line;

    private StarModel starModel;

    private Mastership mastership;

    public SmallStar(StarModel starModel) {

    }


    @Override
    public StarModel getModel() {
        return starModel;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public void onTouch() {

    }

    @Override
    public Array<View> getViews() {
        return null;
    }


}
