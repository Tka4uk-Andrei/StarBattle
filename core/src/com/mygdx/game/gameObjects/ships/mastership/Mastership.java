package com.mygdx.game.gameObjects.ships.mastership;

import com.mygdx.game.actions.Send;
import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.system.View;

public abstract class Mastership {

    public abstract ShipModel getModel();

    public abstract Send getSend();

    public abstract View getView();

}
