package com.mygdx.game.gameObjects;

import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;

public class FleetManager {

    private View raptorView;

    private View shieldView;
    private View twoShieldView;
    private View oneShieldView;

    private View cruiserView;
    private View twoCruiserView;
    private View oneCruiserView;

    private StarModel starModel;

    private MenuBar menuBar;

    public FleetManager(StarModel starModel, ShipTexturesContainer shipTexturesContainer) {

        this.starModel = starModel;

        this.raptorView = new View(shipTexturesContainer.getRaptor().getTexturesPack(starModel.getSide()), starModel.getCenterPoint(), 0);

        this.shieldView = new View(shipTexturesContainer.getShield().getTexturesPack(starModel.getSide()), starModel.getCenterPoint(), 0);
//        this.twoShieldView = new View(,,);
//        this.oneShieldView = new View(,,);

        this.cruiserView = new View(shipTexturesContainer.getCruiser().getTexturesPack(starModel.getSide()), starModel.getCenterPoint(), 0);
//        this.twoCruiserView = new View(,,);
//        this.oneCruiserView = new View(,,);


    }



}
