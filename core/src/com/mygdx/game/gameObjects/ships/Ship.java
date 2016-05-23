package com.mygdx.game.gameObjects.ships;

import com.mygdx.game.actions.Fight;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.system.View;

public abstract class Ship {

    public abstract ShipModel getModel();

    public abstract View getView();

    public abstract Fight getFight();

}
