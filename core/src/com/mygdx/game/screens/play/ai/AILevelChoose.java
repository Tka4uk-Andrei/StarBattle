package com.mygdx.game.screens.play.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GdxGame;
import com.mygdx.game.screens.play.PlayScreen;
import com.mygdx.game.system.Levels;
import com.mygdx.game.system.Point;

public class AILevelChoose implements Screen, GestureDetector.GestureListener {

    private GdxGame gdxGame;
    private PlayScreen playScreen;
    private SpriteBatch batch;

    private AIPlay aiPlay;

    private float px;
    private float py;

    private int screenWidth;
    private int screenHeight;

    private Texture btn;
    private Point btnPoint;
    private Point btnCenter;

    private Texture text;

    public AILevelChoose(GdxGame gdxGame, PlayScreen playScreen) {

        this.gdxGame = gdxGame;
        this.playScreen = playScreen;

        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));

        btn = new Texture("choose.png");
        btnPoint = new Point(10, Gdx.graphics.getHeight() - 10 - btn.getHeight());
        btnCenter = new Point(btnPoint.getX() + btn.getWidth() / 2, btnPoint.getY() + btn.getHeight() / 2);

        text = new Texture("text.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(btn, btnPoint.getX(), btnPoint.getY());
        batch.draw(text, 0, 0);
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
        batch.dispose();
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {

        Point touch = new Point(x, Gdx.graphics.getHeight() - y);

        if (btnCenter.inRectRangeThatPoint(touch, btn.getWidth() / 2, btn.getHeight() / 2)) {

//            aiPlay = new AIPlay(gdxGame, this, stars);
            aiPlay = new AIPlay(gdxGame, this, Levels.getStars1());
            gdxGame.setScreen(aiPlay);

        }

        return true;
    }

    public void returnBack(){
        gdxGame.getScreen();

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
