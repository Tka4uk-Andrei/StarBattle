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

// класс - контейнер кораблей
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
        return menuBar.getSendModel();
    }

    public FleetModel getFleetModels() {
        return star.getBasicStar().getModel().getFleetModel();
    }

    public Array<View> getViews() {
        Array<View> views = new Array<View>();


        raptorView.update(true);
        if (star.getBasicStar().getModel().getFleetModel().getRaptor().getCount() > 0)
            views.add(raptorView);

        cruiserView.update(true);
        if (star.getBasicStar().getModel().getFleetModel().getCruiser().getCount() > 0)
            views.add(cruiserView);

        oneCruiserView.update(true);
        if (star.getBasicStar().getModel().getFleetModel().getOneCruiser().getCount() > 0)
            views.add(oneCruiserView);

        twoCruiserView.update(true);
        if (star.getBasicStar().getModel().getFleetModel().getTwoCruiser().getCount() > 0)
            views.add(twoCruiserView);

        shieldView.update(true);
        if (star.getBasicStar().getModel().getFleetModel().getShield().getCount() > 0)
            views.add(shieldView);

        oneShieldView.update(true);
        if (star.getBasicStar().getModel().getFleetModel().getOneShield().getCount() > 0)
            views.add(oneShieldView);

        twoShieldView.update(true);
        if (star.getBasicStar().getModel().getFleetModel().getTwoShield().getCount() > 0)
            views.add(twoShieldView);

        if (star.getBasicStar().isFocusFlag())
            for (View view : menuBar.getViews())
                views.add(view);

        return views;
    }

    public boolean onTouch(Point touch) {
        return menuBar.onTouch(touch);

    }

    public void setSide(int side) {

        raptorView.setTexturesPack(texturesContainer.getRaptor().getTexturesPack(side));

        cruiserView.setTexturesPack(texturesContainer.getCruiser().getTexturesPack(side));
        twoCruiserView.setTexturesPack(texturesContainer.getTwoCruiser().getTexturesPack(side));
        oneCruiserView.setTexturesPack(texturesContainer.getOneCruiser().getTexturesPack(side));

        shieldView.setTexturesPack(texturesContainer.getShield().getTexturesPack(side));
        twoShieldView.setTexturesPack(texturesContainer.getTwoShield().getTexturesPack(side));
        oneShieldView.setTexturesPack(texturesContainer.getOneShield().getTexturesPack(side));

        star.getBasicStar().getModel().getFleetModel().getRaptor().setSide(side);

        star.getBasicStar().getModel().getFleetModel().getCruiser().setSide(side);
        star.getBasicStar().getModel().getFleetModel().getTwoCruiser().setSide(side);
        star.getBasicStar().getModel().getFleetModel().getOneCruiser().setSide(side);

        star.getBasicStar().getModel().getFleetModel().getShield().setSide(side);
        star.getBasicStar().getModel().getFleetModel().getTwoShield().setSide(side);
        star.getBasicStar().getModel().getFleetModel().getOneShield().setSide(side);

        menuBar.setSide(side);
        menuBar.setDefault();
    }

    public void setDefault() {
        menuBar.setDefault();
    }

    public boolean isSendFlag() {
        return menuBar.isSendCondition();
    }

    public ShipModel getShipForSend() {
        return menuBar.getSendModel();
    }
}
