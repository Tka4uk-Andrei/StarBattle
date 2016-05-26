package com.mygdx.game.models;

import com.mygdx.game.system.Constants;
import com.mygdx.game.system.Point;

public class FleetModel {

    private ShipModel raptor;

    private ShipModel shield;
    private ShipModel twoShield;
    private ShipModel oneShield;

    private ShipModel cruiser;
    private ShipModel twoCruiser;
    private ShipModel oneCruiser;

    public FleetModel() {

        setShip(new ShipModel(Constants.Sides.NONE, ShipModel.Constants.Types.RAPTOR, 0));
        setShip(new ShipModel(Constants.Sides.NONE, ShipModel.Constants.Types.CRUISER, 0));
        setShip(new ShipModel(Constants.Sides.NONE, ShipModel.Constants.Types.TWO_CRUISER, 0));
        setShip(new ShipModel(Constants.Sides.NONE, ShipModel.Constants.Types.ONE_CRUISER, 0));
        setShip(new ShipModel(Constants.Sides.NONE, ShipModel.Constants.Types.SHIELD, 0));
        setShip(new ShipModel(Constants.Sides.NONE, ShipModel.Constants.Types.TWO_SHIELD, 0));
        setShip(new ShipModel(Constants.Sides.NONE, ShipModel.Constants.Types.ONE_SHIELD, 0));

    }

    public void setShip(ShipModel ship) {
        switch (ship.getType()) {
            case ShipModel.Constants.Types.CRUISER:
                cruiser = ship;
                break;
            case ShipModel.Constants.Types.ONE_CRUISER:
                oneCruiser = ship;
                break;
            case ShipModel.Constants.Types.TWO_CRUISER:
                twoCruiser = ship;
                break;
            case ShipModel.Constants.Types.SHIELD:
                shield = ship;
                break;
            case ShipModel.Constants.Types.ONE_SHIELD:
                oneShield = ship;
                break;
            case ShipModel.Constants.Types.TWO_SHIELD:
                twoShield = ship;
                break;
            case ShipModel.Constants.Types.RAPTOR:
                raptor = ship;
                break;
        }
    }

    public ShipModel getRaptor() {
        return raptor;
    }

    public ShipModel getShield() {
        return shield;
    }

    public ShipModel getTwoShield() {
        return twoShield;
    }

    public ShipModel getOneShield() {
        return oneShield;
    }

    public ShipModel getCruiser() {
        return cruiser;
    }

    public ShipModel getTwoCruiser() {
        return twoCruiser;
    }

    public ShipModel getOneCruiser() {
        return oneCruiser;
    }
}
