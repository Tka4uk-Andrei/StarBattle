package com.mygdx.game.gameObjects;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.ConditionTextures;
import com.mygdx.game.system.Point;
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

    private Star star;

    private MenuBar menuBar;

    private Array<View> views;

    private ShipTexturesContainer texturesContainer;

    public FleetManager(Star star, StarModel model, ShipTexturesContainer shipTexturesContainer, ConditionTextures starTextureContainer) {

        this.star = star;
        this.texturesContainer = shipTexturesContainer;

        float delta = (shipTexturesContainer.getRaptor().getTexturesPack(model.getSide()).getTextures().get(0).getWidth()
                + starTextureContainer.getTexturesPack(model.getSide()).getTextures().get(0).getWidth()) / 2;
        Point point = new Point(model.getCenterPoint().getX() - delta, model.getCenterPoint().getY());

        this.raptorView = new View(shipTexturesContainer.getRaptor().getTexturesPack(model.getSide()), point, model.getCenterPoint(), 0, 0);

        this.shieldView = new View(shipTexturesContainer.getShield().getTexturesPack(model.getSide()), point, model.getCenterPoint(), 0, 51);
        this.oneShieldView = new View(shipTexturesContainer.getTwoShield().getTexturesPack(model.getSide()), point, model.getCenterPoint(), 0, 102);
        this.twoShieldView = new View(shipTexturesContainer.getTwoShield().getTexturesPack(model.getSide()), point, model.getCenterPoint(), 0, 153);

        this.cruiserView = new View(shipTexturesContainer.getCruiser().getTexturesPack(model.getSide()), point, model.getCenterPoint(), 0, 204);
        this.twoCruiserView = new View(shipTexturesContainer.getOneCruiser().getTexturesPack(model.getSide()), point, model.getCenterPoint(), 0, 255);
        this.oneCruiserView = new View(shipTexturesContainer.getTwoCruiser().getTexturesPack(model.getSide()), point, model.getCenterPoint(), 0, 306);

        menuBar = new MenuBar(model.getFleetModel(), shipTexturesContainer);
    }

    public ShipModel getModelForSend() {
        return null;
    }

    public FleetModel getFleetModels() {
        return star.getBasicStar().getModel().getFleetModel();
    }

    public Array<View> getViews() {
        Array<View> views = new Array<View>();

        raptorView.update(true);
        views.add(raptorView);

        cruiserView.update(true);
        views.add(cruiserView);

        oneCruiserView.update(true);
        views.add(oneCruiserView);

        twoCruiserView.update(true);
        views.add(twoCruiserView);

        shieldView.update(true);
        views.add(shieldView);

        oneShieldView.update(true);
        views.add(oneShieldView);

        twoShieldView.update(true);
        views.add(twoShieldView);

        if (star.getBasicStar().isFocusFlag())
            for (View view : menuBar.getViews())
                views.add(view);

        return views;
    }

    public void onTouch(Point touch) {
        if (star.getBasicStar().isFocusFlag())
            menuBar.onTouch(touch);
    }

    public void setSide(int side) {

        raptorView.setTexturesPack(texturesContainer.getRaptor().getTexturesPack(side));

        cruiserView.setTexturesPack(texturesContainer.getCruiser().getTexturesPack(side));
        twoCruiserView.setTexturesPack(texturesContainer.getTwoCruiser().getTexturesPack(side));
        oneCruiserView.setTexturesPack(texturesContainer.getOneCruiser().getTexturesPack(side));

        shieldView.setTexturesPack(texturesContainer.getShield().getTexturesPack(side));
        twoShieldView.setTexturesPack(texturesContainer.getTwoShield().getTexturesPack(side));
        oneShieldView.setTexturesPack(texturesContainer.getOneShield().getTexturesPack(side));

    }
}
