package com.mygdx.game.actions;

import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.system.Point;

public class Send {

    private Star currentStar;
    private Ship ship;
    private Mastership mastership;

    private float vectorX;
    private float vectorY;
    private Star destinationStar;

    private long timeSend;

    public Send(Star star, Ship ship) {
        currentStar = star;
        this.ship = ship;
        this.ship.setCenterPoint(new Point(currentStar.getBasicStar().getModel().getCenterPoint()));
        mastership = null;

        vectorX = 0;
        vectorY = 0;
    }

    public Send(Star star, Mastership mastership) {
        currentStar = star;
        this.mastership = mastership;
        ship = null;

        vectorX = 0;
        vectorY = 0;
    }

    public void send(Star destinationStar) {

        if (isSande())
            return;

        if (ship == null) {
            if (mastership.getModel().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
                if (destinationStar.isBlocked(com.mygdx.game.system.Constants.Sides.HOSTILE))
                    return;
            } else {
                if (destinationStar.isBlocked(com.mygdx.game.system.Constants.Sides.FRIENDLY)) {
                    return;
                }
            }
        } else {
            if (destinationStar.getMastership() != null) {
                if (ship.getModel().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
                    if (destinationStar.getMastership().getModel().getSide() == com.mygdx.game.system.Constants.Sides.HOSTILE)
                        return;
                } else {
                    if (destinationStar.getMastership().getModel().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
                        return;
                    }
                }
            }
        }

        this.destinationStar = destinationStar;

        vectorX = (destinationStar.getBasicStar().getModel().getCenterPoint().getX() -
                currentStar.getBasicStar().getModel().getCenterPoint().getX()) / Constants.JUMP_TIME;
        vectorY = (destinationStar.getBasicStar().getModel().getCenterPoint().getY() -
                currentStar.getBasicStar().getModel().getCenterPoint().getY()) / Constants.JUMP_TIME;

        timeSend = System.currentTimeMillis();

        float rotation = (float) Math.toDegrees(
                Math.atan((destinationStar.getBasicStar().getModel().getCenterPoint().getY() - currentStar.getBasicStar().getModel().getCenterPoint().getY()) /
                        (destinationStar.getBasicStar().getModel().getCenterPoint().getX() - currentStar.getBasicStar().getModel().getCenterPoint().getX())));
        if (destinationStar.getBasicStar().getModel().getCenterPoint().getX() >= currentStar.getBasicStar().getModel().getCenterPoint().getX())
            rotation += 270;
        else
            rotation += 90;


        if (ship == null) {
            mastership.getShipView().getViewModel().setRotation(rotation);
            destinationStar.setMastership(mastership);
            currentStar.setMastership(null);
        } else {
            ship.getShipView().getViewModel().setRotation(rotation);
        }
    }

    public void update() {
        if (!isSande())
            return;

        if (ship == null) {

            mastership.getModel().getCenterPoint().setX(
                    currentStar.getBasicStar().getModel().getCenterPoint().getX() +
                            vectorX * (System.currentTimeMillis() - timeSend));

            mastership.getModel().getCenterPoint().setY(
                    currentStar.getBasicStar().getModel().getCenterPoint().getY() +
                            vectorY * (System.currentTimeMillis() - timeSend));

            mastership.setCenterPoint(new Point(mastership.getModel().getCenterPoint()));

            if (destinationStar.getBasicStar().getModel().getCenterPoint().
                    inRectRangeThatPoint(mastership.getModel().getCenterPoint(), Constants.CAPTURE_DISTANCE, Constants.CAPTURE_DISTANCE) ||
                    timeSend + Constants.JUMP_TIME <= System.currentTimeMillis()) {
                vectorX = 0;
                vectorY = 0;

                mastership.getShipView().getViewModel().setRotation(0);
                mastership.setCenterPoint(new Point(destinationStar.getBasicStar().getModel().getCenterPoint()));
                mastership.setStar(destinationStar);


                currentStar = destinationStar;
            }

        } else {

            ship.getModel().getCenterPoint().setX(
                    currentStar.getBasicStar().getModel().getCenterPoint().getX() +
                            vectorX * (System.currentTimeMillis() - timeSend)
            );

            ship.getModel().getCenterPoint().setY(
                    currentStar.getBasicStar().getModel().getCenterPoint().getY() +
                            vectorY * (System.currentTimeMillis() - timeSend)
            );

            ship.setCenterPoint(ship.getModel().getCenterPoint());

            if (destinationStar.getBasicStar().getModel().getCenterPoint().
                    inRectRangeThatPoint(ship.getModel().getCenterPoint(), Constants.CAPTURE_DISTANCE, Constants.CAPTURE_DISTANCE) ||
                    timeSend + Constants.JUMP_TIME <= System.currentTimeMillis()) {

                vectorX = 0;
                vectorY = 0;

                currentStar = destinationStar;

                ship.getFight().fight(destinationStar);

            }
        }
    }

    public boolean isSande() {
        return (!(vectorX == 0 && vectorY == 0));
    }

    private static class Constants {

        private static int JUMP_TIME = 2000;

        private static int CAPTURE_DISTANCE = 5;

    }
}
