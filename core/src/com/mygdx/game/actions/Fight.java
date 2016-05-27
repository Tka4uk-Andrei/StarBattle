package com.mygdx.game.actions;

import com.mygdx.game.gameObjects.FleetManager;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.system.Constants;

public class Fight {

    private FleetModel fleetModel;
    private ShipModel ship;
    private Star star;

    public Fight(FleetModel fleetModel, ShipModel ship) {
        this.fleetModel = fleetModel;
        this.ship = ship;
    }

    public void fight(Star star) {

        this.star = star;

        if (fleetModel.getCruiser().getSide() == Constants.Sides.HOSTILE
                || fleetModel.getOneShield().getSide() == Constants.Sides.HOSTILE
                || fleetModel.getRaptor().getSide() == Constants.Sides.HOSTILE
                || fleetModel.getTwoShield().getSide() == Constants.Sides.HOSTILE
                || fleetModel.getShield().getSide() == Constants.Sides.HOSTILE
                || fleetModel.getOneCruiser().getSide() == Constants.Sides.HOSTILE
                || fleetModel.getTwoCruiser().getSide() == Constants.Sides.HOSTILE) {

            int shipHealth = shipsFight(getShipHealth(ship), fleetModel.getShield());

            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship), fleetModel.getTwoShield());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship), fleetModel.getOneShield());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship), fleetModel.getCruiser());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship), fleetModel.getTwoCruiser());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship), fleetModel.getOneCruiser());
            if (shipHealth > 0)
                shipHealth = shipsFight(getShipHealth(ship), fleetModel.getRaptor());
            if (shipHealth > 0)
                setHealth(shipHealth, ship.getType(), ship.getSide());

        } else
            setHealth(getShipHealth(ship), ship.getType(), ship.getSide());
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

    private void setHealth(int health, int shipType, int side) {

        // switch

        if (shipType == ShipModel.Constants.Types.CRUISER) {
            if (fleetModel.getCruiser().getCount() +
                    health / ShipModel.Constants.Health.CRUISER > 0)
                star.getBasicStar().getFleetManager().setSide(side);

            fleetModel.getCruiser().setCount(fleetModel.getCruiser().getCount() +
                    health / ShipModel.Constants.Health.CRUISER);
            health %= ShipModel.Constants.Health.CRUISER;
            shipType = ShipModel.Constants.Types.TWO_CRUISER;
        }

        if (shipType == ShipModel.Constants.Types.TWO_CRUISER) {
            if (fleetModel.getTwoCruiser().getCount() +
                    health / ShipModel.Constants.Health.TWO_CRUISER > 0)
                star.getBasicStar().getFleetManager().setSide(side);

            fleetModel.getTwoCruiser().setCount(fleetModel.getTwoCruiser().getCount() +
                    health / ShipModel.Constants.Health.TWO_CRUISER);
            health %= ShipModel.Constants.Health.TWO_CRUISER;
            shipType = ShipModel.Constants.Types.ONE_CRUISER;
        }

        if (shipType == ShipModel.Constants.Types.ONE_CRUISER) {
            if (fleetModel.getOneCruiser().getCount() +
                    health / ShipModel.Constants.Health.ONE_CRUISER > 0)
                star.getBasicStar().getFleetManager().setSide(side);

            fleetModel.getOneCruiser().setCount(fleetModel.getOneCruiser().getCount() +
                    health / ShipModel.Constants.Health.ONE_CRUISER);
        }
        if (shipType == ShipModel.Constants.Types.SHIELD) {
            if (fleetModel.getShield().getCount() +
                    health / ShipModel.Constants.Health.SHIELD > 0)
                star.getBasicStar().getFleetManager().setSide(side);

            fleetModel.getShield().setCount(fleetModel.getShield().getCount() +
                    health / ShipModel.Constants.Health.SHIELD);
            health %= ShipModel.Constants.Health.SHIELD;
            shipType = ShipModel.Constants.Types.TWO_SHIELD;
        }

        if (shipType == ShipModel.Constants.Types.TWO_SHIELD) {
            if (fleetModel.getTwoShield().getCount() +
                    health / ShipModel.Constants.Health.TWO_SHIELD > 0)
                star.getBasicStar().getFleetManager().setSide(side);

            fleetModel.getTwoShield().setCount(fleetModel.getCruiser().getCount() +
                    health / ShipModel.Constants.Health.TWO_SHIELD);
            health %= ShipModel.Constants.Health.TWO_SHIELD;
            shipType = ShipModel.Constants.Types.ONE_SHIELD;
        }

        if (shipType == ShipModel.Constants.Types.ONE_SHIELD) {
            if (fleetModel.getOneShield().getCount() +
                    health / ShipModel.Constants.Health.ONE_SHIELD > 0)
                star.getBasicStar().getFleetManager().setSide(side);

            fleetModel.getOneShield().setCount(fleetModel.getCruiser().getCount() +
                    health / ShipModel.Constants.Health.ONE_SHIELD);

        }
        if (shipType == ShipModel.Constants.Types.RAPTOR) {
            if (fleetModel.getRaptor().getCount() +
                    health / ShipModel.Constants.Health.RAPTOR > 0)
                star.getBasicStar().getFleetManager().setSide(side);

            star.getBasicStar().getModel().getFleetModel().getRaptor().setCount(fleetModel.getRaptor().getCount() +
                    health / ShipModel.Constants.Health.RAPTOR);

            star.getBasicStar().getFleetManager().setSide(side);
        }
    }

    private int shipsFight(int fighterHealth, ShipModel model) {
        int modelHealth = getShipHealth(model);

        if (modelHealth - fighterHealth >= 0) {
            modelHealth -= fighterHealth;
            setHealth(modelHealth, model.getType(), model.getSide());
        } else {
            setHealth(0, model.getType(), Constants.Sides.NONE);
            fighterHealth -= modelHealth;
        }

        return fighterHealth;
    }
}
