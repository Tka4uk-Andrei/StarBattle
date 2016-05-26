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
import com.mygdx.game.gameObjects.ships.mastership.FriendlyMastership;
import com.mygdx.game.gameObjects.stars.AdvancedFactory;
import com.mygdx.game.gameObjects.stars.FactoryStar;
import com.mygdx.game.gameObjects.stars.MineStar;
import com.mygdx.game.gameObjects.stars.SmallStar;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.StarModel;
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

    private Texture background;
    private StarTextureContainer starTextureContainer;
    private ShipTexturesContainer shipTexturesContainer;
    private FocusTexture focusTexture;

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

        friendlyMastership = new FriendlyMastership(stars.get(2), stars, focusTexture);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0, 0, 0, background.getWidth(), background.getHeight(),
                1, 1, 0, 0, 0, background.getWidth(), background.getHeight(), false, false);
        for (Star star : stars) {
            for (View view : star.getViews())
                if (view.getFrame() != null) {
                    batch.draw(view.getFrame(), (int) view.getRenderPoint().getX(), (int) view.getRenderPoint().getY(),
                            (int) view.getOriginPoint().getX(), (int) view.getOriginPoint().getY(),
                            view.getFrame().getWidth(), view.getFrame().getHeight(), 1, 1,
                            view.getRotation(), 0, 0, view.getFrame().getWidth(), view.getFrame().getHeight(),
                            false, false);
                } else {
                    view.getBitmapFont().draw(batch, view.getText(), (int) view.getRenderPoint().getX(), (int) view.getRenderPoint().getY());
                }
        }

        for (View view : friendlyMastership.getViews())
            if (view.getFrame() != null) {
                batch.draw(view.getFrame(), (int) view.getRenderPoint().getX(), (int) view.getRenderPoint().getY(),
                        (int) view.getOriginPoint().getX(), (int) view.getOriginPoint().getY(),
                        view.getFrame().getWidth(), view.getFrame().getHeight(), 1, 1,
                        view.getRotation(), 0, 0, view.getFrame().getWidth(), view.getFrame().getHeight(),
                        false, false);
            } else {
                view.getBitmapFont().draw(batch, view.getText(), (int) view.getRenderPoint().getX(), (int) view.getRenderPoint().getY());
            }

        batch.end();

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

        Point touch = new Point(x, Gdx.graphics.getHeight() - y);

        friendlyMastership.onTouch(touch);

        for (int i = 0; i < stars.size; ++i) {
//            if (stars.get(i).getBasicStar().isSendFlag())
//            {
//                for (int j : stars.get(i).getBasicStar().getModel().getConnectedStars()){
//
//                }
//            }
            stars.get(i).onTouch(touch);
        }

//        for (int i = 0; i < stars.size; i++) {
//            if (stars[i].isFocusFlag() && stars.get(i).isReadyToSend())
//                for (int j = 0; j < stars[i].getConnectedStars().length; j++)
//                    if (stars[stars[i].getConnectedStars()[j]].isTouched(point))
//                        stars[i].sendFleet(stars[stars[i].getConnectedStars()[j]]);
//            stars[i].setFocusFlag(stars[i].isTouched(point));
//        }

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
