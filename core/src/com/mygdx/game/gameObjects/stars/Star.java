package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actions.Fight;
import com.mygdx.game.gameObjects.FleetManager;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.View;

public abstract class Star {

    public abstract BasicStar getBasicStar();

    public abstract Array<View> getViews();

//    public abstract StarModel getModel();
//
//    public abstract boolean isBlocked();
//
//    public abstract void onTouch();
//
//    public abstract Array<View> getViews();
//
//    public abstract FleetManager getFleetManager();
//
//    public abstract void setSide(int side);
}
