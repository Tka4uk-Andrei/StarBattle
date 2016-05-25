package com.mygdx.game.gameObjects.ships.mastership;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actions.Send;
import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.MastershipModel;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;

public abstract class Mastership {

    public abstract MastershipModel getModel();

    public abstract MastershipModel setModel();

    public abstract Send getSend();

    public abstract Array<View> getViews();

    public abstract View getShipView();

    public abstract void onTouch(Point touch);

    public abstract void setCenterPoint(Point centerPoint);

    public abstract Array<Star> getStars();

    public abstract void setStar(Star star);
}
