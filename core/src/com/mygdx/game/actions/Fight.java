package com.mygdx.game.actions;

import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.Constants;

public class Fight {

    private StarModel starModel;

    public Fight(StarModel starModel) {
        this.starModel = starModel;
    }

    public void fight(Ship ship) {

        if (ship.getModel().getSide() != Constants.Sides.HOSTILE) {

            int shipHealth = shipsFight(getShipHealth(ship.getModel()), starModel.getFleetModel().getShield());

            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship.getModel()), starModel.getFleetModel().getTwoShield());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship.getModel()), starModel.getFleetModel().getOneShield());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship.getModel()), starModel.getFleetModel().getCruiser());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship.getModel()), starModel.getFleetModel().getTwoCruiser());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship.getModel()), starModel.getFleetModel().getOneCruiser());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship.getModel()), starModel.getFleetModel().getRaptor());
            if (shipHealth > 0)
                setHealth(shipHealth, ship.getModel().getType());

        } else
            setHealth(getShipHealth(ship.getModel()) , ship.getModel().getType());
    }

    private int getShipHealth(ShipModel model) {
        int shipHealth = 0;
        switch (model.getType()) {
            case ShipModel.Constants.Types.CRUISER:
                shipHealth = model.getCount() * ShipModel.Constants.Health.CRUISER;
                break;
            case ShipModel.Constants.Types.ONE_CRUISER:
                shipHealth = model.getCount() * ShipModel.Constants.Health.ONE_CRUISER;
                break;
            case ShipModel.Constants.Types.TWO_CRUISER:
                shipHealth = model.getCount() * ShipModel.Constants.Health.TWO_CRUISER;
                break;
            case ShipModel.Constants.Types.SHIELD:
                shipHealth = model.getCount() * ShipModel.Constants.Health.SHIELD;
                break;
            case ShipModel.Constants.Types.ONE_SHIELD:
                shipHealth = model.getCount() * ShipModel.Constants.Health.ONE_SHIELD;
                break;
            case ShipModel.Constants.Types.TWO_SHIELD:
                shipHealth = model.getCount() * ShipModel.Constants.Health.TWO_SHIELD;
                break;
            case ShipModel.Constants.Types.RAPTOR:
                shipHealth = model.getCount() * ShipModel.Constants.Health.RAPTOR;
                break;
        }
        return shipHealth;
    }

    private void setHealth(int health, int shipType){

        // switch

        if (shipType == ShipModel.Constants.Types.CRUISER) {
            starModel.getFleetModel().getCruiser().setCount(
                    starModel.getFleetModel().getCruiser().getCount() +
                            health / ShipModel.Constants.Health.CRUISER);
            health %= ShipModel.Constants.Health.CRUISER;
            shipType = ShipModel.Constants.Types.TWO_CRUISER;
        }

        if (shipType == ShipModel.Constants.Types.TWO_CRUISER) {
            starModel.getFleetModel().getTwoCruiser().setCount(
                    starModel.getFleetModel().getCruiser().getCount() +
                            health / ShipModel.Constants.Health.TWO_CRUISER);
            health %= ShipModel.Constants.Health.TWO_CRUISER;
            shipType = ShipModel.Constants.Types.ONE_CRUISER;
        }

        if (shipType == ShipModel.Constants.Types.ONE_CRUISER)
            starModel.getFleetModel().getOneCruiser().setCount(
                    starModel.getFleetModel().getCruiser().getCount() +
                            health / ShipModel.Constants.Health.ONE_CRUISER);

        if (shipType == ShipModel.Constants.Types.SHIELD) {
            starModel.getFleetModel().getShield().setCount(
                    starModel.getFleetModel().getCruiser().getCount() +
                            health / ShipModel.Constants.Health.CRUISER);
            health %= ShipModel.Constants.Health.SHIELD;
            shipType = ShipModel.Constants.Types.TWO_SHIELD;
        }

        if (shipType == ShipModel.Constants.Types.TWO_SHIELD) {
            starModel.getFleetModel().getTwoShield().setCount(
                    starModel.getFleetModel().getCruiser().getCount() +
                            health / ShipModel.Constants.Health.TWO_SHIELD);
            health %= ShipModel.Constants.Health.TWO_SHIELD;
            shipType = ShipModel.Constants.Types.ONE_SHIELD;
        }

        if (shipType == ShipModel.Constants.Types.ONE_SHIELD)
            starModel.getFleetModel().getOneShield().setCount(
                    starModel.getFleetModel().getCruiser().getCount() +
                            health / ShipModel.Constants.Health.ONE_SHIELD);

        if (shipType == ShipModel.Constants.Types.RAPTOR)
            starModel.getFleetModel().getRaptor().setCount(
                    starModel.getFleetModel().getCruiser().getCount() +
                            health / ShipModel.Constants.Health.ONE_SHIELD);
    }

    private int shipsFight(int fighterHealth, ShipModel model) {
        int modelHealth = getShipHealth(model);

        if (modelHealth - fighterHealth >= 0) {
            modelHealth -= fighterHealth;
            setHealth(modelHealth, model.getType());
        } else {
            setHealth(0, model.getType());
            fighterHealth -= modelHealth;
        }

        return fighterHealth;
    }
}
