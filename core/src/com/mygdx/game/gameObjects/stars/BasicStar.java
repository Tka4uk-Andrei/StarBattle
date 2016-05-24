package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.FleetManager;
import com.mygdx.game.gameObjects.Line;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;

public class BasicStar {

    private StarModel starModel;
    private Array<StarModel> starModels;

    private View view;
    private ConditionTextures starTextures;
    private ShipTexturesContainer shipsTextures;

    private FleetManager fleetManager;

    private Array<Line> lines;

    private Mastership mastership;

    public BasicStar(StarModel starModel, ConditionTextures starTextures,
                     ShipTexturesContainer shipsTextures, Array<StarModel> starModels, int currentFrame) {

        this.starModel = starModel;
        this.starModels = starModels;
        this.starTextures = starTextures;
        this.shipsTextures = shipsTextures;

        view = new View(starTextures.getTexturesPack(starModel.getSide()), starModel.getCenterPoint(), currentFrame);

        fleetManager = new FleetManager(starModel, shipsTextures);

        lines = new Array<Line>();

        for (int i : starModel.getConnectedStars())
            lines.add(new Line(this, starModels.get(i).getCenterPoint()));

    }

    public StarModel getModel() {
        return starModel;
    }

    public boolean isBlocked() {
        return false;
    }

    public void onTouch() {

    }

    public Array<View> getViews() {
        Array <View> views = new Array<View>();

        view.update(false);

        for (Line line : lines){
            line.getView().update(false);
            views.add(line.getView());
        }

        views.add(view);

        return views;
    }

    public FleetManager getFleetManager() {
        return fleetManager;
    }

    public void setSide(int side) {

        starModel.setSide(side);

        for (int i = 0; i < lines.size; ++i)
            lines.get(i).updateSide();



    }

}
