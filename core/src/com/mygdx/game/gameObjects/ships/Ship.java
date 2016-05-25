package com.mygdx.game.gameObjects.ships;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.actions.Fight;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;

public class Ship {


//    private RaptorTexture shipTextures;

    private boolean jumpFlag;

    private int shipCount;

    private int side;

    private Sprite sprite;
    private float rotation;

    private Point centerPoint;

    private boolean focusFlag;

//    private Star destinationStar;
//    private Star currentStar;

    private float originX;
    private float originY;

    private float vectorX;
    private float vectorY;

    public View getShipView(){
        return null;
    }

    public ShipModel getModel(){
        return null;
    }

    public Fight getFight(){
        return null;
    }


//
//    public Raptor(Star star, RaptorTexture raptorTextures, int side) {
//
//        currentStar = star;
//        this.shipTextures = raptorTextures;
//        this.side = side;
//        centerPoint = new Point(star.getCenterPoint().getX() -
//                (star.getTexture().getWidth() + raptorTextures.getFrame(side).getWidth()) / 2,
//                star.getCenterPoint().getY());
//
//        rotation = shipTextures.getDegree();
//
//        sprite = new Sprite(shipTextures.getFrame(side));
//        sprite.setSize(shipTextures.getFrame(side).getWidth(), shipTextures.getFrame(side).getHeight());
//
//        originX = star.getTexture().getWidth() / 2 + shipTextures.getFrame(side).getWidth();
//        originY = shipTextures.getFrame(side).getHeight() / 2;
//
//        sprite.setCenter(centerPoint.getX(), centerPoint.getY());
//        sprite.setOrigin(originX, originY);
//        sprite.setRotation(0);
//
//        shipCount = 0;
//        jumpFlag = false;
//        focusFlag = true;
//
//        vectorX = 0;
//        vectorY = 0;
//    }
//
//    @Override
//    public int getFleetSize() {
//        return shipCount;
//    }
//
//    @Override
//    public void setFleetSize(int fleetSize) {
//        shipCount = fleetSize;
//    }
//
//    @Override
//    public ForRender getRender() {
//        update();
//
//        return new ForRender(sprite);
//    }
//
//    @Override
//    public int getShipCount() {
//        return shipCount;
//    }
//
//    @Override
//    public void update() {
//        if (!jumpFlag) {
//            sprite.setRotation(shipTextures.getDegree());
//
//            sprite.setOrigin(originX, originY);
//            vectorX = 0;
//            vectorY = 0;
//
//        } else if (destinationStar.getCenterPoint().inRangeThatPoint(centerPoint,
//                com.mygdx.game.Constants.MASTERSHIP_CAPTURE_BY_STAR_RANGE,
//                com.mygdx.game.Constants.MASTERSHIP_CAPTURE_BY_STAR_RANGE))
//            fight(destinationStar);
//
//        centerPoint.setX(centerPoint.getX() + vectorX);
//        centerPoint.setY(centerPoint.getY() + vectorY);
//
//        sprite.setCenter(centerPoint.getX(), centerPoint.getY());
//
//        sprite.setTexture(shipTextures.getFrame(side));
//    }

//    @Override
//    public void incFleetCount() {
//        shipCount++;
//    }
//
//    @Override
//    public int getType() {
//        return com.mygdx.game.Constants.ShipTypes.RAPTOR;
//    }

//    @Override
//    public void setSide(int side) {
//        this.side = side;
//    }

//    @Override
//    public void send(Star star) {
//        jumpFlag = true;
//
//        destinationStar = star;
//
//        rotation = 0;
//        centerPoint.setX(currentStar.getCenterPoint().getX());
//        centerPoint.setY(currentStar.getCenterPoint().getY());
//
//        sprite.setCenter(centerPoint.getX(), centerPoint.getY());
//        sprite.setOrigin(shipTextures.getFrame(side).getWidth() / 2, shipTextures.getFrame(side).getHeight() / 2);
//
//        rotation = (float) Math.toDegrees(
//                Math.atan((star.getCenterPoint().getY() - currentStar.getCenterPoint().getY()) /
//                        (star.getCenterPoint().getX() - currentStar.getCenterPoint().getX())));
//        if (star.getCenterPoint().getX() >= centerPoint.getX())
//            rotation += 270;
//        else
//            rotation += 90;
//
//        sprite.setRotation(rotation);
//
//        vectorX = (star.getCenterPoint().getX() - centerPoint.getX()) / com.mygdx.game.Constants.JumpTime.RAPTOR;
//        vectorY = (star.getCenterPoint().getY() - centerPoint.getY()) / com.mygdx.game.Constants.JumpTime.RAPTOR;
//    }


//    public void fight(Star star) {
//
//        if (star.getSide() == com.mygdx.game.Constants.SideCodes.HOSTILE) {
//            if (star.getRaptor().getFleetSize() - shipCount < 0) {
//                shipCount -= star.getRaptor().getFleetSize();
//                star.getRaptor().setFleetSize(0);
//            } else
//                star.getRaptor().setFleetSize(star.getRaptor().getFleetSize() - shipCount);
//        } else
//            star.getRaptor().setFleetSize(star.getRaptor().getFleetSize() + shipCount);
//
//        if (star.getSide() == com.mygdx.game.Constants.SideCodes.NONE)
//            star.getRaptor().setSide(com.mygdx.game.Constants.SideCodes.FRIENDLY);
//
//        shipCount = 0;
//    }

//    @Override
//    public boolean isFocused() {
//        return focusFlag;
//    }
//
//    @Override
//    public void setFocus(boolean focus) {
//        focusFlag = focus;
//    }
//
//    @Override
//    public boolean isTouched(Point touch) {
//        return centerPoint.inRangeThatPoint(touch,
//                shipTextures.getFrame(side).getWidth(),
//                shipTextures.getFrame(side).getHeight());
//    }


//    public Texture getTexture() {
//        return shipTextures.getFrame(side);
//    }

//    public RaptorTexture getShipTextures() {
//        return shipTextures;
//    }


    public Point getCenterPoint() {
        return centerPoint;
    }


    public void setCenterPoint(Point point) {
        centerPoint = point;
    }


    public int getSide() {
        return side;
    }

}
