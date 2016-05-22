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
        img = new Texture("badlogic.jpg");
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

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(img, 200, 200, 200, 200, 50, 50, 1, 1, rotation, 0, 0, img.getWidth(), img.getHeight(), false, false);
        batch.end();

        if (rotation >= 360)
            rotation = 0;

        rotation += 1f;
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
