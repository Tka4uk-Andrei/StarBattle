package com.mygdx.game.gameObjects.stars;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.FleetManager;
import com.mygdx.game.gameObjects.Line;
import com.mygdx.game.gameObjects.ships.mastership.Mastership;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.system.Constants;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;

public class SmallStar extends Star {

    private StarModel starModel;
    private Array<StarModel> starModels;
    private ConditionTextures starTextures;
    private ShipTexturesContainer shipsTextures;

    private View view;

    private FleetManager fleetManager;
    private Array<Line> line;

    private Mastership mastership;

    public SmallStar(StarModel starModel, ConditionTextures starTextures,
                     ShipTexturesContainer shipsTextures, Array<StarModel> starModels, int currentFrame) {

        this.starModel = starModel;
        this.starModels = starModels;
        this.starTextures = starTextures;
        this.shipsTextures = shipsTextures;

        view = new View(starTextures.getTexturesPack(starModel.getSide()), starModel.getCenterPoint(), currentFrame);



        fleetManager = new FleetManager();
    }


    @Override
    public StarModel getModel() {
        return starModel;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public void onTouch() {

    }

    @Override
    public Array<View> getViews() {
        return null;
    }


}
