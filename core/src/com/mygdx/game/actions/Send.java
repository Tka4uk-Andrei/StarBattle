package com.mygdx.game.actions;

import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.gameObjects.stars.Star;

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
        mastership = null;
    }

    private Send(Star star, Mastership mastership){
        currentStar = star;
        this.mastership = mastership;
        ship = null;
    }

    public void send(Star destinationStar) {

        this.destinationStar = destinationStar;

        if (isSande())
            return;

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

        if (ship == null)
            mastership.getView().setRotation(rotation);
        else
            ship.getView().setRotation(rotation);
    }

    public void update(){
        if (!isSande())
            return;

        if (ship == null) {

            mastership.getModel().getCenterPoint().setX(
                    currentStar.getBasicStar().getModel().getCenterPoint().getX() +
                            vectorX * (timeSend - System.currentTimeMillis())
            );

            mastership.getModel().getCenterPoint().setY(
                    currentStar.getBasicStar().getModel().getCenterPoint().getY() +
                            vectorY * (timeSend - System.currentTimeMillis())
            );

            if (destinationStar.getBasicStar().getModel().getCenterPoint().
                    inRectRangeThatPoint(mastership.getModel().getCenterPoint(), 5, 5) ||
                    timeSend + Constants.JUMP_TIME >= System.currentTimeMillis()){
                vectorX = 0;
                vectorY = 0;
                mastership.getModel().getCenterPoint().setPoint(destinationStar.getBasicStar().getModel().getCenterPoint());
                currentStar = destinationStar;
            }

        } else {

            ship.getModel().getCenterPoint().setX(
                    currentStar.getBasicStar().getModel().getCenterPoint().getX() +
                            vectorX * (timeSend - System.currentTimeMillis())
            );

            ship.getModel().getCenterPoint().setY(
                    currentStar.getBasicStar().getModel().getCenterPoint().getY() +
                            vectorY * (timeSend - System.currentTimeMillis())
            );

            if (destinationStar.getBasicStar().getModel().getCenterPoint().
                    inRectRangeThatPoint(ship.getModel().getCenterPoint(), 5, 5) ||
                    timeSend + Constants.JUMP_TIME >= System.currentTimeMillis()){
                vectorX = 0;
                vectorY = 0;
                mastership.getModel().getCenterPoint().setPoint(destinationStar.getBasicStar().getModel().getCenterPoint());
                currentStar = destinationStar;

                ship.getFight().fight();
            }
        }
    }

    public boolean isSande(){
        return (vectorX == 0 && vectorY == 0);
    }

    private static class Constants {

        private static int JUMP_TIME = 1000;

        private static int CAPTURE_DISTANCE = 5;

    }
}
