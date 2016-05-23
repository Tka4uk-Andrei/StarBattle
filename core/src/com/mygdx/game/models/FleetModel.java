package com.mygdx.game.models;

public class FleetModel {

    private ShipModel raptor;

    private ShipModel shield;
    private ShipModel twoShield;
    private ShipModel oneShield;

    private ShipModel cruiser;
    private ShipModel twoCruiser;
    private ShipModel oneCruiser;

    public FleetModel(ShipModel raptor, ShipModel shield, ShipModel twoShield, ShipModel oneShield,
                      ShipModel cruiser, ShipModel twoCruiser, ShipModel oneCruiser) {

        setShip(raptor);
        setShip(shield);
        setShip(twoShield);
        setShip(oneShield);
        setShip(cruiser);
        setShip(twoCruiser);
        setShip(oneCruiser);
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
