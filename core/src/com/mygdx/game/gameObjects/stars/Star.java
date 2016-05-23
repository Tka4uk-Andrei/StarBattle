package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.View;
import com.sun.deploy.security.MozillaJSSDSASignature;

public abstract class Star {

    public abstract StarModel getModel();

    public abstract boolean isBlocked();

    public abstract void onTouch();

    public abstract Array<View> getViews();
}
