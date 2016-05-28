package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GdxGame;
import com.mygdx.game.screens.editor.EditorSettings;
import com.mygdx.game.screens.play.PlayScreen;

public class MainMenu implements Screen, GestureDetector.GestureListener {

    private GdxGame gdxGame;

    private Settings settings;
    private PlayScreen playScreen;
    private EditorSettings editorSettings;

    private SpriteBatch batch;

    private float rotation = 0;
    private Texture img;


    public MainMenu(GdxGame gdxGame) {

        this.gdxGame = gdxGame;
        img = new Texture("play.png");
        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));

        settings = null;
        playScreen = null;
        editorSettings = null;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(img, Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
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
        img.dispose();
        batch.dispose();
    }



    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        playScreen = new PlayScreen(gdxGame, this);
        gdxGame.setScreen(playScreen);
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
        rotation = 90;
        return true;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
