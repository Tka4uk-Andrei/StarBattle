package com.mygdx.game.screens.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GdxGame;
import com.mygdx.game.screens.MainMenu;
import com.mygdx.game.screens.play.ai.AILevelChoose;
import com.mygdx.game.screens.play.online.Network;

public class PlayScreen implements Screen, GestureDetector.GestureListener {

    private GdxGame gdxGame;
    private MainMenu mainMenu;

    private AILevelChoose aiLevelChoose;
    private Description description;
    private Network network;

    private SpriteBatch batch;

    public PlayScreen(GdxGame gdxGame, MainMenu mainMenu) {
        this.gdxGame = gdxGame;
        this.mainMenu = mainMenu;

        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0.647f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        batch.dispose();
    }



    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        aiLevelChoose = new AILevelChoose(gdxGame, this);
        gdxGame.setScreen(aiLevelChoose);
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
