package com.mygdx.game.screens.play.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.GdxGame;
import com.mygdx.game.gameObjects.stars.SmallStar;
import com.mygdx.game.gameObjects.stars.Star;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ShipTexturesContainer;
import com.mygdx.game.textures.StarTextureContainer;

public class AIPlay implements Screen, GestureDetector.GestureListener {

    private SpriteBatch batch;
    private GdxGame gdxGame;
    private AILevelChoose aiLevelChoose;
    private Array<Star> stars;

    public AIPlay(GdxGame gdxGame, AILevelChoose aiLevelChoose, Array<StarModel> starModels) {

        this.gdxGame = gdxGame;
        this.aiLevelChoose = aiLevelChoose;

        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));

        StarTextureContainer starTextureContainer = new StarTextureContainer();
        ShipTexturesContainer shipTexturesContainer = new ShipTexturesContainer();

        stars = new Array<Star>();
        for (int i = 0; i < starModels.size; ++i)
            stars.add(new SmallStar(starModels.get(i), starTextureContainer.getSmallStar(),
                    shipTexturesContainer, starModels, 0));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        for (Star star : stars) {
            for (View view : star.getViews())
            batch.draw(view.getFrame(), view.getRenderPoint().getX(), view.getRenderPoint().getY(),
                    view.getOriginPoint().getX(), view.getOriginPoint().getY(),
                    view.getFrame().getWidth(), view.getFrame().getHeight(), 1, 1,
                    view.getRotation(), 0, 0, view.getFrame().getWidth(), view.getFrame().getHeight(),
                    false, false);
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

    }


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {

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
