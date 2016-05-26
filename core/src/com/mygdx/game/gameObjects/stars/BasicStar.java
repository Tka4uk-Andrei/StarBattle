package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.FleetManager;
import com.mygdx.game.gameObjects.Line;
import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;
import com.mygdx.game.textures.focus.FocusTexture;

public class BasicStar {

    private StarModel starModel;
    private Array<StarModel> starModels;

    private View view;
    private ConditionTextures starTextures;
    private ShipTexturesContainer shipsTextures;

    private FleetManager fleetManager;

    private Array<Line> lines;

    private Mastership mastership;

    private boolean focusFlag;

    private View focusView;

    private Array<Ship> ships;

    private Star star;
    private Array<Star> stars;

    public BasicStar(Star star, Array<Star> stars, StarModel starModel, ConditionTextures starTextures,
                     ShipTexturesContainer shipsTextures, Array<StarModel> starModels, int currentFrame,
                     FocusTexture focusTexture) {

        this.star = star;
        this.stars = stars;
        this.starModel = starModel;
        this.starModels = starModels;
        this.starTextures = starTextures;
        this.shipsTextures = shipsTextures;

        view = new View(starTextures.getTexturesPack(starModel.getSide()), starModel.getCenterPoint(), currentFrame);

        lines = new Array<Line>();

        for (int i : starModel.getConnectedStars())
            lines.add(new Line(this, starModels.get(i).getCenterPoint()));

        focusFlag = false;
        focusView = new View(focusTexture, starModel.getCenterPoint(), 0);

        ships = new Array<Ship>();

        fleetManager = new FleetManager(star, starModel, shipsTextures, starTextures);
    }

    public StarModel getModel() {
        return starModel;
    }

    public void onTouch(Point touch) {

        if (starModel.getCenterPoint().inRectRangeThatPoint(touch,
                view.getFrame().getWidth(), view.getFrame().getHeight())) {

            focusFlag = true;
        } else
            focusFlag = false;

    }

    public void sendTouch(Point touch) {
        for (int i : starModel.getConnectedStars()) {
            if (starModels.get(i).getCenterPoint().inRectRangeThatPoint(touch,
                    view.getFrame().getWidth(), view.getFrame().getHeight())) {

                Ship ship = new Ship(shipsTextures, fleetManager.getModelForSend(), star);
                ship.send(stars.get(i));
                ships.add(ship);
            }
        }
    }

    public Array<View> getViews() {
        Array<View> views = new Array<View>();

        view.update(false);


        if (focusFlag) {
            focusView.update(false);
            views.add(focusView);
        }

        for (Line line : lines) {
            line.getView().update(false);
            views.add(line.getView());
        }

        views.add(view);

        for (View view : fleetManager.getViews())
            views.add(view);

        for (int i = 0; i < ships.size; ++i) {
            if (!ships.get(i).getSend().isSande()) {
                ships.removeIndex(i);
                --i;
            } else {
                views.add(ships.get(i).getShipView());
            }
        }

        return views;
    }

    public FleetManager getFleetManager() {
        return fleetManager;
    }

    public void setSide(int side) {

        starModel.setSide(side);

        view.setTexturesPack(starTextures.getTexturesPack(side));

        for (int i = 0; i < lines.size; ++i)
            lines.get(i).updateSide();

        fleetManager.setSide(side);
    }

    public Mastership getMastership() {
        return mastership;
    }

    public void setMastership(Mastership mastership) {
        this.mastership = mastership;
    }

    public boolean isFocusFlag() {
        return focusFlag;
    }
}
