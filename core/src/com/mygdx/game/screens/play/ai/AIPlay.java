package com.mygdx.game.screens.play.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.GdxGame;
import com.mygdx.game.actions.GameEnd;
import com.mygdx.game.ai.AiManager;
import com.mygdx.game.gameObjects.ships.mastership.FriendlyMastership;
import com.mygdx.game.gameObjects.ships.mastership.HostileMasterShip;
import com.mygdx.game.gameObjects.stars.AdvancedFactory;
import com.mygdx.game.gameObjects.stars.FactoryStar;
import com.mygdx.game.gameObjects.stars.MineStar;
import com.mygdx.game.gameObjects.stars.SmallStar;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.Constants;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;
import com.mygdx.game.textures.StarTextureContainer;
import com.mygdx.game.textures.focus.FocusTexture;

public class AIPlay implements Screen, GestureDetector.GestureListener {

    private SpriteBatch batch;
    private GdxGame gdxGame;
    private AILevelChoose aiLevelChoose;

    private Array<Star> stars;
    private FriendlyMastership friendlyMastership;
    private HostileMasterShip hostileMasterShip;

    private Texture background;
    private StarTextureContainer starTextureContainer;
    private ShipTexturesContainer shipTexturesContainer;
    private FocusTexture focusTexture;

    private AiManager manager;

    private Texture winFr;
    private Texture winH;

    private Texture backBtn;
    private Point backPoint;
    private Point backRenderPoitn;

    public AIPlay(GdxGame gdxGame, AILevelChoose aiLevelChoose, Array<StarModel> starModels) {

        this.gdxGame = gdxGame;
        this.aiLevelChoose = aiLevelChoose;

        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));

        background = new Texture("Background.png");

        starTextureContainer = new StarTextureContainer();
        shipTexturesContainer = new ShipTexturesContainer();
        focusTexture = new FocusTexture();

        stars = new Array<Star>();
        for (int i = 0; i < starModels.size; ++i) {
            switch (starModels.get(i).getType()) {
                case StarModel.Constants.Types.SMALL:
                    stars.add(new SmallStar(stars, starModels.get(i), starTextureContainer.getSmallStar(),
                            shipTexturesContainer, starModels, 0, focusTexture));
                    break;
                case StarModel.Constants.Types.FACTORY:
                    stars.add(new FactoryStar(stars, starModels.get(i), starTextureContainer.getFactoryStar(),
                            shipTexturesContainer, starModels, 0, focusTexture));
                    break;
                case StarModel.Constants.Types.MINE:
                    stars.add(new MineStar(stars, starModels.get(i), starTextureContainer.getMineStar(),
                            shipTexturesContainer, starModels, 0, focusTexture));
                    break;
                case StarModel.Constants.Types.ADVANCED_FACTORY:
                    stars.add(new AdvancedFactory(stars, starModels.get(i), starTextureContainer.getAdvancedFactoryStar(),
                            shipTexturesContainer, starModels, 0, focusTexture));
                    break;
            }
        }

        friendlyMastership = new FriendlyMastership(stars.get(1), stars, focusTexture);
        hostileMasterShip = new HostileMasterShip(stars.get(2), stars);

        stars.get(1).getBasicStar().setMastership(friendlyMastership);
        stars.get(2).getBasicStar().setMastership(hostileMasterShip);

        winFr = new Texture("blueWin.png");
        winH = new Texture("redWin.png");

        backBtn = new Texture("return.png");

        backPoint = new Point(5 + backBtn.getWidth() / 2, 5 + backBtn.getHeight() / 2);
        backRenderPoitn = new Point(5, 5);

        manager = new AiManager(stars, hostileMasterShip, friendlyMastership);
        manager.start();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (GameEnd.isGameEnd(stars) == 0) {

            batch.begin();
//            batch.draw(background, 0, 0, 0, 0, background.getWidth(), background.getHeight(),
//                    1, 1, 0, 0, 0, background.getWidth(), background.getHeight(), false, false);
            synchronized (stars) {
                for (Star star : stars) {
                    for (View view : star.getViews())
                        if (view.getFrame() != null) {
                            batch.draw(view.getFrame(), (int) view.getViewModel().getRenderPoint().getX(), (int) view.getViewModel().getRenderPoint().getY(),
                                    (int) view.getViewModel().getOriginPoint().getX(), (int) view.getViewModel().getOriginPoint().getY(),
                                    view.getFrame().getWidth(), view.getFrame().getHeight(), 1, 1,
                                    view.getViewModel().getRotation(), 0, 0, view.getFrame().getWidth(), view.getFrame().getHeight(),
                                    false, false);
                        } else {
                            view.getBitmapFont().draw(batch, view.getText(), (int) view.getViewModel().getRenderPoint().getX(), (int) view.getViewModel().getRenderPoint().getY());
                        }
                }
            }
            synchronized (friendlyMastership) {
                for (View view : friendlyMastership.getViews())
                    if (view.getFrame() != null) {
                        batch.draw(view.getFrame(), (int) view.getViewModel().getRenderPoint().getX(), (int) view.getViewModel().getRenderPoint().getY(),
                                (int) view.getViewModel().getOriginPoint().getX(), (int) view.getViewModel().getOriginPoint().getY(),
                                view.getFrame().getWidth(), view.getFrame().getHeight(), 1, 1,
                                view.getViewModel().getRotation(), 0, 0, view.getFrame().getWidth(), view.getFrame().getHeight(),
                                false, false);
                    } else {
                        view.getBitmapFont().draw(batch, view.getText(), (int) view.getViewModel().getRenderPoint().getX(), (int) view.getViewModel().getRenderPoint().getY());
                    }
            }
            synchronized (hostileMasterShip) {
                for (View view : hostileMasterShip.getViews())
                    if (view.getFrame() != null) {
                        batch.draw(view.getFrame(), (int) view.getViewModel().getRenderPoint().getX(), (int) view.getViewModel().getRenderPoint().getY(),
                                (int) view.getViewModel().getOriginPoint().getX(), (int) view.getViewModel().getOriginPoint().getY(),
                                view.getFrame().getWidth(), view.getFrame().getHeight(), 1, 1,
                                view.getViewModel().getRotation(), 0, 0, view.getFrame().getWidth(), view.getFrame().getHeight(),
                                false, false);
                    } else {
                        view.getBitmapFont().draw(batch, view.getText(), (int) view.getViewModel().getRenderPoint().getX(), (int) view.getViewModel().getRenderPoint().getY());
                    }
            }

            batch.draw(backBtn, backRenderPoitn.getX(), backRenderPoitn.getY());

            batch.end();

        } else {
            if (GameEnd.isGameEnd(stars) == Constants.Sides.FRIENDLY) {
                batch.begin();
                batch.draw(winFr, Gdx.graphics.getWidth() / 2 - winFr.getWidth() / 2, Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() / 2 - winFr.getHeight() / 2));
                batch.end();
            } else {
                batch.begin();
                batch.draw(winH, Gdx.graphics.getWidth() / 2 - winH.getWidth() / 2, Gdx.graphics.getHeight() - (Gdx.graphics.getHeight() / 2 - winH.getHeight() / 2));
                batch.end();
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        starTextureContainer.dispose();
        shipTexturesContainer.dispose();
        focusTexture.dispose();
    }


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        if (GameEnd.isGameEnd(stars) == 0) {
            Point touch = new Point(x, Gdx.graphics.getHeight() - y);

            friendlyMastership.onTouch(touch);

            for (int i = 0; i < stars.size; ++i) {
                if (stars.get(i).getBasicStar().isSendFlag())
                    stars.get(i).sendTouch(touch);
                stars.get(i).onTouch(touch);
            }

            if (backPoint.inRectRangeThatPoint(touch, backBtn.getWidth(), backBtn.getHeight())) {
                gdxGame.setScreen(aiLevelChoose);
                Gdx.input.setInputProcessor(new GestureDetector(aiLevelChoose));
            }
        } else {
            gdxGame.setScreen(aiLevelChoose);
            Gdx.input.setInputProcessor(new GestureDetector(aiLevelChoose));
        }

        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
