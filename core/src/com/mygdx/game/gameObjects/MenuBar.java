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
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;
import com.mygdx.game.textures.TexturePackForTexture;

// отображение боковой панели
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

    private Point raptorCountPoint;

    private Point shieldCountPoint;
    private Point twoShieldCountPoint;
    private Point oneShieldCountPoint;

    private Point cruiserCountPoint;
    private Point twoCruiserCountPoint;
    private Point oneCruiserCountPoint;

    private Point sendCountPoint;

    private Point sendViewPoint;

    private boolean raptorFocus;
    private boolean cruiserFocus;
    private boolean twoCruiserFocus;
    private boolean oneCruiserFocus;
    private boolean shieldFocus;
    private boolean twoShieldFocus;
    private boolean oneShieldFocus;
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
    private ShipModel sendModel;

    private Point center;

    private ShipTexturesContainer shipTextures;

    public MenuBar(FleetModel fleetModel, ShipTexturesContainer shipTexturesContainer) {

        shipTextures = shipTexturesContainer;

        center = new Point(Gdx.graphics.getWidth() - Constants.BAR_WIDTH / 2, Gdx.graphics.getHeight() / 2);

        this.fleetModel = fleetModel;

        float py = Gdx.graphics.getHeight() / 16f;

        float x = Gdx.graphics.getWidth() - Constants.BAR_WIDTH + 10 +
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getWidth() / 2;

        raptorViewPoint = new Point(x, Gdx.graphics.getHeight() -
                (shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getHeight() / 2 + py + py * 2 * 0));

        shieldViewPoint = new Point(x, Gdx.graphics.getHeight() - (
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getHeight() / 2 + py + py * 2 * 1));
        twoShieldViewPoint = new Point(x, Gdx.graphics.getHeight() - (
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getHeight() / 2 + py + py * 2 * 2));
        oneShieldViewPoint = new Point(x, Gdx.graphics.getHeight() - (
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getHeight() / 2 + py + py * 2 * 3));

        cruiserViewPoint = new Point(x, Gdx.graphics.getHeight() - (
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getHeight() / 2 + py + py * 2 * 4));
        twoCruiserViewPoint = new Point(x, Gdx.graphics.getHeight() - (
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getHeight() / 2 + py + py * 2 * 5));
        oneCruiserViewPoint = new Point(x, Gdx.graphics.getHeight() - (
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getHeight() / 2 + py + py * 2 * 6));

        this.raptorView = new View(shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()), raptorViewPoint, 0);

        this.shieldView = new View(shipTexturesContainer.getShield().getTexturesPack(fleetModel.getShield().getSide()), shieldViewPoint, 0);
        this.twoShieldView = new View(shipTexturesContainer.getOneShield().getTexturesPack(fleetModel.getTwoShield().getSide()), twoShieldViewPoint, 0);
        this.oneShieldView = new View(shipTexturesContainer.getTwoShield().getTexturesPack(fleetModel.getOneShield().getSide()), oneShieldViewPoint, 0);

        this.cruiserView = new View(shipTexturesContainer.getCruiser().getTexturesPack(fleetModel.getCruiser().getSide()), cruiserViewPoint, 0);
        this.twoCruiserView = new View(shipTexturesContainer.getOneCruiser().getTexturesPack(fleetModel.getTwoCruiser().getSide()), twoCruiserViewPoint, 0);
        this.oneCruiserView = new View(shipTexturesContainer.getTwoCruiser().getTexturesPack(fleetModel.getOneCruiser().getSide()), oneCruiserViewPoint, 0);

        sendTexture = new TexturePackForTexture(new Texture("send.png"));
        sendView = new View(sendTexture, new Point(x, Gdx.graphics.getHeight() - (shipTexturesContainer.getRaptor().
                getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 7)), 0);

        smallFocus = new TexturePackForTexture(new Texture("smallFocus.png"));
        focusView = new View(smallFocus, new Point(x, Gdx.graphics.getHeight() - (shipTexturesContainer.getRaptor().
                getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 7)), 0);

        x = Gdx.graphics.getWidth() - (Constants.BAR_WIDTH - 10 -
                shipTexturesContainer.getRaptor().getTexturesPack(fleetModel.getRaptor().getSide()).getTextures().get(0).getWidth() - 10) / 2;

        raptorCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 0));

        shieldCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 1));
        twoShieldCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 2));
        oneShieldCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 3));

        cruiserCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 4));
        twoCruiserCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 5));
        oneCruiserCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 6));

        sendCountPoint = new Point(x, Gdx.graphics.getHeight() - (py + py * 2 * 7));

        x = Gdx.graphics.getWidth() - Constants.BAR_WIDTH / 2;

        raptorViewPoint.setX(x);
        shieldViewPoint.setX(x);
        twoShieldViewPoint.setX(x);
        oneShieldViewPoint.setX(x);
        cruiserViewPoint.setX(x);
        twoCruiserViewPoint.setX(x);
        oneCruiserViewPoint.setX(x);
        sendViewPoint = new Point(x, Gdx.graphics.getHeight() - (shipTexturesContainer.getRaptor().
                getTexturesPack(0).getTextures().get(0).getHeight() / 2 + py + py * 2 * 7));

        Pixmap background = new Pixmap(Constants.BAR_WIDTH, Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        background.setColor(Color.DARK_GRAY);
        background.fill();
        backgroudTexture = new TexturePackForTexture(new Texture(background));
        backgroundView = new View(backgroudTexture,
                new Point(Gdx.graphics.getWidth() - Constants.BAR_WIDTH / 2, Gdx.graphics.getHeight() / 2), 0);
        background.dispose();

        generator = new FreeTypeFontGenerator(Gdx.files.internal("Glasten-Normal.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = 35;
        parameter.color = Color.WHITE;
        parameter.characters = "1234567890 ";

        bitmapFont = generator.generateFont(parameter);

        generator.dispose();

        setDefault();
    }

    public Array<View> getViews() {

        Array<View> views = new Array<View>();

        views.add(backgroundView);
        if (!raptorFocus && !cruiserFocus && !twoCruiserFocus && !oneCruiserFocus && !shieldFocus
                && !twoShieldFocus && !oneShieldFocus) {

            views.add(raptorView);
            views.add(new View(bitmapFont, String.valueOf(fleetModel.getRaptor().getCount()), raptorCountPoint));

            views.add(cruiserView);
            views.add(new View(bitmapFont, String.valueOf(fleetModel.getCruiser().getCount()), cruiserCountPoint));

            views.add(twoCruiserView);
            views.add(new View(bitmapFont, String.valueOf(fleetModel.getTwoCruiser().getCount()), twoCruiserCountPoint));

            views.add(oneCruiserView);
            views.add(new View(bitmapFont, String.valueOf(fleetModel.getOneCruiser().getCount()), oneCruiserCountPoint));

            views.add(twoShieldView);
            views.add(new View(bitmapFont, String.valueOf(fleetModel.getTwoShield().getCount()), twoShieldCountPoint));

            views.add(oneShieldView);
            views.add(new View(bitmapFont, String.valueOf(fleetModel.getOneShield().getCount()), oneShieldCountPoint));

            views.add(shieldView);
            views.add(new View(bitmapFont, String.valueOf(fleetModel.getShield().getCount()), shieldCountPoint));

        } else {
            if (sendFocusFlag)
                views.add(focusView);
            views.add(sendView);
            views.add(new View(bitmapFont, String.valueOf(sendModel.getCount()), sendCountPoint));

            if (raptorFocus) {
                views.add(raptorView);
                views.add(new View(bitmapFont, String.valueOf(fleetModel.getRaptor().getCount()), raptorCountPoint));
            } else if (cruiserFocus) {
                views.add(cruiserView);
                views.add(new View(bitmapFont, String.valueOf(fleetModel.getCruiser().getCount()), cruiserViewPoint));
            } else if (twoCruiserFocus) {
                views.add(twoCruiserView);
                views.add(new View(bitmapFont, String.valueOf(fleetModel.getTwoCruiser().getCount()), twoCruiserCountPoint));
            } else if (oneCruiserFocus) {
                views.add(oneCruiserView);
                views.add(new View(bitmapFont, String.valueOf(fleetModel.getOneCruiser().getCount()), oneCruiserCountPoint));
            } else if (shieldFocus) {
                views.add(shieldView);
                views.add(new View(bitmapFont, String.valueOf(fleetModel.getShield().getCount()), shieldCountPoint));
            } else if (twoShieldFocus) {
                views.add(twoShieldView);
                views.add(new View(bitmapFont, String.valueOf(fleetModel.getTwoShield().getCount()), twoShieldCountPoint));
            } else if (oneShieldFocus) {
                views.add(oneShieldView);
                views.add(new View(bitmapFont, String.valueOf(fleetModel.getOneShield().getCount()), oneShieldCountPoint));
            }
        }
        return views;
    }

    public boolean onTouch(Point touch) {

        if (!center.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, Gdx.graphics.getHeight() / 2))
            return false;

        if (cruiserViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, cruiserView.getFrame().getHeight())
                && fleetModel.getCruiser().getCount() > 0 && fleetModel.getCruiser().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {

            if (cruiserFocus) {
                sendModel.setCount((sendModel.getCount() + 1) % (fleetModel.getRaptor().getCount() + 1));
            }
            cruiserFocus = true;
            sendModel = new ShipModel(fleetModel.getRaptor().getSide(), ShipModel.Constants.Types.RAPTOR, 0);

        } else if (raptorViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, cruiserView.getFrame().getHeight())
                && fleetModel.getRaptor().getCount() > 0 && fleetModel.getRaptor().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {

            if (raptorFocus) {
                sendModel.setCount((sendModel.getCount() + 1) % (fleetModel.getRaptor().getCount() + 1));
            } else {
                raptorFocus = true;
                sendModel = new ShipModel(fleetModel.getRaptor().getSide(), ShipModel.Constants.Types.RAPTOR, 0);
            }

        } else if (oneCruiserViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, cruiserView.getFrame().getHeight())
                && fleetModel.getOneCruiser().getCount() > 0 && fleetModel.getOneCruiser().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
            oneCruiserFocus = true;

            if (raptorFocus) {
                sendModel.setCount((sendModel.getCount() + 1) % (fleetModel.getRaptor().getCount() + 1));
            } else {
                raptorFocus = true;
                sendModel = new ShipModel(fleetModel.getRaptor().getSide(), ShipModel.Constants.Types.RAPTOR, 0);
            }

        } else if (twoCruiserViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, cruiserView.getFrame().getHeight())
                && fleetModel.getTwoCruiser().getCount() > 0 && fleetModel.getTwoCruiser().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
            twoCruiserFocus = true;

            if (raptorFocus) {
                sendModel.setCount((sendModel.getCount() + 1) % (fleetModel.getRaptor().getCount() + 1));
            } else {
                raptorFocus = true;
                sendModel = new ShipModel(fleetModel.getRaptor().getSide(), ShipModel.Constants.Types.RAPTOR, 0);
            }

        } else if (shieldViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, cruiserView.getFrame().getHeight())
                && fleetModel.getShield().getCount() > 0 && fleetModel.getShield().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
            shieldFocus = true;

            if (raptorFocus) {
                sendModel.setCount((sendModel.getCount() + 1) % (fleetModel.getRaptor().getCount() + 1));
            } else {
                raptorFocus = true;
                sendModel = new ShipModel(fleetModel.getRaptor().getSide(), ShipModel.Constants.Types.RAPTOR, 0);
            }

        } else if (oneShieldViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, cruiserView.getFrame().getHeight())
                && fleetModel.getOneShield().getCount() > 0 && fleetModel.getOneShield().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
            oneShieldFocus = true;

            if (raptorFocus) {
                sendModel.setCount((sendModel.getCount() + 1) % (fleetModel.getRaptor().getCount() + 1));
            } else {
                raptorFocus = true;
                sendModel = new ShipModel(fleetModel.getRaptor().getSide(), ShipModel.Constants.Types.RAPTOR, 0);
            }

        } else if (twoShieldViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, cruiserView.getFrame().getHeight())
                && fleetModel.getTwoShield().getCount() > 0 && fleetModel.getTwoShield().getSide() == com.mygdx.game.system.Constants.Sides.FRIENDLY) {
            twoShieldFocus = true;

            if (raptorFocus) {
                sendModel.setCount((sendModel.getCount() + 1) % (fleetModel.getRaptor().getCount() + 1));
            } else {
                raptorFocus = true;
                sendModel = new ShipModel(fleetModel.getRaptor().getSide(), ShipModel.Constants.Types.RAPTOR, 0);
            }

        } else if (sendViewPoint.inRectRangeThatPoint(touch, Constants.BAR_WIDTH / 2, sendView.getFrame().getHeight())) {
            sendFocusFlag = true;
        }


        return true;
    }

    public void dispose() {
        sendTexture.dispose();
        smallFocus.dispose();

        backgroudTexture.dispose();
    }

    public void setDefault() {

        raptorFocus = false;

        cruiserFocus = false;
        oneCruiserFocus = false;
        twoCruiserFocus = false;

        shieldFocus = false;
        oneShieldFocus = false;
        twoShieldFocus = false;
        sendFocusFlag = false;

        if (sendModel != null)
            sendModel.setCount(0);

    }

    public boolean isSendCondition() {
        return sendFocusFlag;
    }

    public ShipModel getSendModel() {
        return sendModel;
    }

    public void setSide(int side) {

        raptorView.setTexturesPack(shipTextures.getRaptor().getTexturesPack(side));
        shieldView.setTexturesPack(shipTextures.getShield().getTexturesPack(side));
        cruiserView.setTexturesPack(shipTextures.getCruiser().getTexturesPack(side));
        twoShieldView.setTexturesPack(shipTextures.getTwoShield().getTexturesPack(side));
        oneShieldView.setTexturesPack(shipTextures.getOneShield().getTexturesPack(side));
        oneCruiserView.setTexturesPack(shipTextures.getOneCruiser().getTexturesPack(side));
        twoCruiserView.setTexturesPack(shipTextures.getTwoCruiser().getTexturesPack(side));

    }

    private static class Constants {

        public static final int BAR_WIDTH = 128;

    }
}
