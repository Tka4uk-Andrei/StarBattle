package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actions.Progress;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.system.Constants;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;
import com.mygdx.game.textures.focus.FocusTexture;
import com.mygdx.game.textures.progress.ProgressTexture;

public class FactoryStar extends Star {

    private BasicStar basicStar;

    private ConditionTextures progressTexture;
    private Progress progress;

    public FactoryStar(Array<Star> stars, StarModel starModel, ConditionTextures starTextures,
                       ShipTexturesContainer shipsTextures, Array<StarModel> starModels, int currentFrame,
                       FocusTexture focusTexture) {
        basicStar = new BasicStar(this, stars, starModel, starTextures, shipsTextures, starModels, currentFrame,
                focusTexture);

        progressTexture = new ConditionTextures(new ProgressTexture(ProgressTexture.Constants.SHIP_BILD_FRAMES, 40, Constants.Colors.friendly, 1, ProgressTexture.Constants.BILD_TIME),
                new ProgressTexture(ProgressTexture.Constants.SHIP_BILD_FRAMES, 40, Constants.Colors.friendly, 1, ProgressTexture.Constants.BILD_TIME),
                new ProgressTexture(ProgressTexture.Constants.SHIP_BILD_FRAMES, 40, Constants.Colors.hostile, 1, ProgressTexture.Constants.BILD_TIME));

        progress = new Progress(progressTexture.getTexturesPack(starModel.getSide()), new Point(starModel.getCenterPoint().getX() - 30, starModel.getCenterPoint().getY() + 30));
    }

    @Override
    public BasicStar getBasicStar() {
        return basicStar;
    }

    @Override
    public Array<View> getViews() {
        Array<View> views = basicStar.getViews();

        if (basicStar.getModel().getSide() != Constants.Sides.NONE) {
            if (progress.isDone())
                basicStar.getModel().getFleetModel().getRaptor().setCount(basicStar.getModel().getFleetModel().getRaptor().getCount() + 1);
            views.add(progress.getView());
        } else {
            progress.setCurrentFrame(0);
            progress.setTime(System.currentTimeMillis());
        }

        return views;
    }

    @Override
    public void onTouch(Point touch) {
        basicStar.onTouch(touch);
    }

    @Override
    public void sendTouch(Point touch) {
        basicStar.sendTouch(touch);
    }

    @Override
    public void setSide(int side) {
        progress.setTexturesPack(progressTexture.getTexturesPack(side));

        basicStar.updateSide(side);
    }

    @Override
    public boolean isBlocked(int side) {
        return basicStar.isBlocked(side);
    }

    @Override
    public Mastership getMastership() {
        return basicStar.getMastership();
    }

    @Override
    public void setMastership(Mastership mastership) {
        basicStar.setMastership(mastership);
    }
}
