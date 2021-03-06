package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GdxGame;
import com.mygdx.game.screens.play.PlayScreen;
import com.mygdx.game.system.Point;
import com.mygdx.game.system.TexturesPack;
import com.mygdx.game.system.View;
import com.mygdx.game.textures.ships.cruiser.CruiserTextureHostile;

public class MainMenu implements Screen, GestureDetector.GestureListener {

    private GdxGame gdxGame;

    private PlayScreen playScreen;

    private SpriteBatch batch;

    private float rotation = 0;
    private Texture img;

    private View view;

    private TexturesPack ship;

    private Point center;

    public MainMenu(GdxGame gdxGame) {

        this.gdxGame = gdxGame;
        img = new Texture("play.png");
        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));

        playScreen = null;

        rotation = 0;

        ship = new CruiserTextureHostile();

        center = new Point(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        view = new View(ship,
                new Point(Gdx.graphics.getWidth() / 2f - img.getWidth() / 2f - ship.getTextures().get(0).getWidth() / 2f - 60, Gdx.graphics.getHeight() / 2f),
                center, 0, 0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        view.update(true);
        rotation -= 0.5f;

        if (rotation <= 0)
            rotation += 360;

        batch.begin();
        batch.draw(img, Gdx.graphics.getWidth() / 2 - img.getWidth() / 2, Gdx.graphics.getHeight() / 2 - img.getHeight() / 2);
        batch.draw(view.getFrame(), (int) view.getViewModel().getRenderPoint().getX(), (int) view.getViewModel().getRenderPoint().getY(),
                (int) view.getViewModel().getOriginPoint().getX(), (int) view.getViewModel().getOriginPoint().getY(),
                view.getFrame().getWidth() + 40, view.getFrame().getHeight() + 40, 1, 1,
                rotation, 0, 0, view.getFrame().getWidth(), view.getFrame().getHeight(),
                false, false);
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
        Point touch = new Point(x, Gdx.graphics.getHeight() - y);

        playScreen = new PlayScreen(gdxGame, this);
        if (center.inRectRangeThatPoint(touch, img.getWidth() / 2, img.getHeight() / 2))
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
