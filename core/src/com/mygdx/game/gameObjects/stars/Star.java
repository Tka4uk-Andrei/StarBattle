package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;

public abstract class Star {

    public abstract BasicStar getBasicStar();

    public abstract Array<View> getViews();

    public abstract void onTouch(Point touch);

    public abstract void sendTouch(Point touch);

    public abstract void setSide(int side);

    public abstract boolean isBlocked(int side);

    public abstract void setMastership(Mastership mastership);

    public abstract Mastership getMastership();
}
