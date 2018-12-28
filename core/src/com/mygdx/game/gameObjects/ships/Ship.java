package com.mygdx.game.gameObjects.ships;

import com.mygdx.game.actions.Fight;
import com.mygdx.game.actions.Send;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;

// корабль кого - либо типа (не Mastership!)
public class Ship {

    private ShipModel model;
    private View view;
    private Fight fight;
    private Send send;

    private TexturesPack shipTextures;

    public Ship(ShipTexturesContainer shipTextures, ShipModel model, Star star) {

        this.model = new ShipModel(model);

        switch (model.getType()) {
            case ShipModel.Constants.Types.CRUISER:
                this.shipTextures = shipTextures.getCruiser().getTexturesPack(model.getSide());
                break;
            case ShipModel.Constants.Types.TWO_CRUISER:
                this.shipTextures = shipTextures.getTwoCruiser().getTexturesPack(model.getSide());
                break;
            case ShipModel.Constants.Types.ONE_CRUISER:
                this.shipTextures = shipTextures.getOneCruiser().getTexturesPack(model.getSide());
                break;
            case ShipModel.Constants.Types.SHIELD:
                this.shipTextures = shipTextures.getShield().getTexturesPack(model.getSide());
                break;
            case ShipModel.Constants.Types.TWO_SHIELD:
                this.shipTextures = shipTextures.getTwoShield().getTexturesPack(model.getSide());
                break;
            case ShipModel.Constants.Types.ONE_SHIELD:
                this.shipTextures = shipTextures.getOneShield().getTexturesPack(model.getSide());
                break;
            case ShipModel.Constants.Types.RAPTOR:
                this.shipTextures = shipTextures.getRaptor().getTexturesPack(model.getSide());
                break;
        }

        view = new View(this.shipTextures, model.getCenterPoint(), 0);

        send = new Send(star, this);
    }

    public View getShipView() {
        send.update();
        return view;
    }

    public ShipModel getModel() {
        return model;
    }

    public Fight getFight() {
        return fight;
    }

    public void send(Star destinationStar) {
        fight = new Fight(destinationStar.getBasicStar().getFleetManager().getFleetModels(), model);
        send.send(destinationStar);
    }

    public void setCenterPoint(Point point) {
        model.setCenterPoint(point);
        view.setRenderPointByCenter(point);
        view.setOriginPointInCenter();
    }

    public int getSide() {
        return model.getSide();
    }

    public Send getSend() {
        return send;
    }

}
