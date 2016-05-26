package com.mygdx.game.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameObjects.ships.Ship;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;
import com.mygdx.game.textures.TexturePackForTexture;

public class MenuBar {

    private View raptorView;

    private View shieldView;
    private View twoShieldView;
    private View oneShieldView;

    private View cruiserView;
    private View twoCruiserView;
    private View oneCruiserView;

    private View backgroundView;

    private View sendView;
    private View focusView;

    private Point raptorViewPoint;

    private Point shieldViewPoint;
    private Point twoShieldViewPoint;
    private Point oneShieldViewPoint;

    private Point cruiserViewPoint;
    private Point twoCruiserViewPoint;
    private Point oneCruiserViewPoint;

    private boolean raptorFocus = true;
    private boolean cruiserFocus = true;
    private boolean twoCruiserFocus = true;
    private boolean oneCruiserFocus = true;
    private boolean shieldFocus = true;
    private boolean twoShieldFocus = true;
    private boolean oneShieldFocus = true;
    private boolean sendFocusFlag;

    private TexturePackForTexture backgroudTexture;

//    private Button sendButton;

    private Array<Ship> ships;

    private TexturePackForTexture sendTexture;
    private TexturePackForTexture smallFocus;

    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private BitmapFont bitmapFont;

    private FleetModel fleetModel;

    public MenuBar(FleetModel fleetModel, ShipTexturesContainer shipTexturesContainer) {

        this.fleetModel = fleetModel;

        float py = Gdx.graphics.getHeight() / 16f;

        float x = Gdx.graphics.getWidth() - Constants.BAR_WIDTH + 10 +
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getWidth() / 2;

        raptorViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 0));

        shieldViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 1));
        twoShieldViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 2));
        oneShieldViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 3));

        cruiserViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 4));
        twoCruiserViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 5));
        oneCruiserViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 6));

        this.raptorView = new View(shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()), raptorViewPoint, 0);

        this.shieldView = new View(shipTexturesContainer.getShield().getTexturesPack(fleetModel.getShield().getSide()), shieldViewPoint, 0);
        this.twoShieldView = new View(shipTexturesContainer.getOneShield().getTexturesPack(fleetModel.getTwoShield().getSide()), twoShieldViewPoint, 0);
        this.oneShieldView = new View(shipTexturesContainer.getTwoShield().getTexturesPack(fleetModel.getOneShield().getSide()), oneShieldViewPoint, 0);

        this.cruiserView = new View(shipTexturesContainer.getCruiser().getTexturesPack(fleetModel.getCruiser().getSide()), cruiserViewPoint, 0);
        this.twoCruiserView = new View(shipTexturesContainer.getOneCruiser().getTexturesPack(fleetModel.getTwoCruiser().getSide()), twoCruiserViewPoint, 0);
        this.oneCruiserView = new View(shipTexturesContainer.getTwoCruiser().getTexturesPack(fleetModel.getOneCruiser().getSide()), oneCruiserViewPoint, 0);

        Pixmap background = new Pixmap(Constants.BAR_WIDTH, Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        background.setColor(Color.DARK_GRAY);
        background.fill();
        backgroudTexture = new TexturePackForTexture(new Texture(background));
        backgroundView = new View(backgroudTexture,
                new Point(Gdx.graphics.getWidth() - Constants.BAR_WIDTH / 2, Gdx.graphics.getHeight() / 2), 0);
        background.dispose();

        sendTexture = new TexturePackForTexture(new Texture("send.png"));
        sendView = new View(sendTexture, new Point(x, Gdx.graphics.getHeight() - (shipTexturesContainer.getRaptor().
                getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 7)), 0);

        smallFocus = new TexturePackForTexture(new Texture("smallFocus.png"));
        focusView = new View(smallFocus, new Point(x, Gdx.graphics.getHeight() - (shipTexturesContainer.getRaptor().
                getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 7)), 0);

        generator = new FreeTypeFontGenerator(Gdx.files.internal("Glasten-Normal.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 35;
        parameter.color = Color.WHITE;
        parameter.characters = "1234567890 ";

        bitmapFont = generator.generateFont(parameter);

        generator.dispose();

        sendFocusFlag = false;
    }

    public Array<View> getViews() {

        Array<View> views = new Array<View>();

        views.add(backgroundView);
        if (raptorFocus && cruiserFocus) {
            views.add(raptorView);
            views.add(cruiserView);
            views.add(twoCruiserView);
            views.add(oneCruiserView);
            views.add(twoShieldView);
            views.add(oneShieldView);
            views.add(shieldView);
        } else {
            if (sendFocusFlag)
                views.add(focusView);
            views.add(sendView);

            if (raptorFocus)
                views.add(raptorView);
            else if (cruiserFocus)
                views.add(cruiserView);
            else if (twoCruiserFocus)
                views.add(twoCruiserView);
            else if (oneCruiserFocus)
                views.add(oneCruiserView);
            else if (shieldFocus)
                views.add(shieldView);
            else if (twoShieldFocus)
                views.add(twoShieldView);
            else if (oneShieldFocus)
                views.add(oneShieldView);
        }

        return views;
    }

    public boolean onTouch(Point touch) {



//
//        if (!centerPoint.inRangeThatPoint(touch, barWidth, barHeight))
//            return false;
//
//
////        if (raptor.isFocused())
////            shipCount = (shipCount + 1) % (raptor.getShipCount() + 1);
//
//        if (raptorPoint.inRangeThatPoint(touch, barWidth * 2, raptor.getTexture().getHeight() * 2)
//                && raptor.getSide() == Constants.SideCodes.FRIENDLY) {
//            shipCount = (shipCount + 1) % (raptor.getShipCount() + 1);
//            raptor.setFocus(true);
//        } else if (object4Point.inRangeThatPoint(touch, barWidth * 2, sendTexture.getHeight() * 2))
//            sendFocusFlag = !sendFocusFlag;
//
//
////        if (raptor.isFocused() && cruiser.isFocused()) {
////            if (raptorPoint.inRangeThatPoint(touch, barWidth * 2, raptor.getTexture().getHeight() * 2)
////                    && raptor.getSide() == Constants.SideCodes.FRIENDLY) {
////                if (raptor.isFocused()) {
////                    cruiser.setFocus(false);
////                    shield.setFocus(false);
////
////                }
////            } else if (shieldPoint.inRangeThatPoint(touch, barWidth * 2, shield.getTexture().getHeight() * 2)
////                    && shield.getSide() == Constants.SideCodes.FRIENDLY) {
////                if (shield.isFocused()) {
////                    raptor.setFocus(false);
////                    cruiser.setFocus(false);
////
////                }
////            } else if (cruiserPoint.inRangeThatPoint(touch, barWidth * 2, cruiser.getTexture().getHeight() * 2)
////                    && cruiser.getSide() == Constants.SideCodes.FRIENDLY) {
////                if (cruiser.isFocused()) {
////                    raptor.setFocus(false);
////                    shield.setFocus(false);
////
////                }
////            }
////        } else if (raptorPoint.inRangeThatPoint(touch, barWidth * 2, raptor.getTexture().getHeight() * 2))
////            if (raptor.isFocused())
////                shipCount = (shipCount + 1) % (raptor.getShipCount() + 1);
////            else if (shield.isFocused())
////                shipCount = (shipCount + 1) % (shield.getShipCount() + 1);
////            else
////                shipCount = (shipCount + 1) % (cruiser.getShipCount() + 1);
////
////        else if (object4Point.inRangeThatPoint(touch, barWidth * 2, sendTexture.getHeight() * 2)) {
////            sendFocusFlag = !sendFocusFlag;
////        }

        return true;
    }

    public void dispose() {
        sendTexture.dispose();
        smallFocus.dispose();

        backgroudTexture.dispose();
    }

    public void setDefault() {

        cruiserFocus = true;
        raptorFocus = true;
        oneShieldFocus = true;
        oneCruiserFocus = true;
        twoCruiserFocus = true;
        twoShieldFocus = true;
        sendFocusFlag = false;

    }

    public boolean isSendCondition() {
        return sendFocusFlag;
    }

    public int getShipsTypeForSend() {
//        if (raptor.isFocused())
//            return Constants.ShipTypes.RAPTOR;
//        if (shield.isFocused())
//            return Constants.ShipTypes.SHIELD;
//        if (cruiser.isFocused())
//            return Constants.ShipTypes.CRUISER;

        return -1;
    }

    private static class Constants {

        public static final int BAR_WIDTH = 128;

    }
}
