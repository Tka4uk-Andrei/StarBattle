package com.mygdx.game.screens.play.ai;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.GdxGame;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.screens.play.PlayScreen;
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

    public AILevelChoose(GdxGame gdxGame, PlayScreen playScreen){

        this.gdxGame = gdxGame;
        this.playScreen = playScreen;

        batch = new SpriteBatch();

        Gdx.input.setInputProcessor(new GestureDetector(this));


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0.647f, 1);
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

        Array<StarModel> stars = new Array<StarModel>();

        ShipModel shipModel = new ShipModel(new Point(100, 100), 0, 0, 1, 0);

        FleetModel fleetModel = new FleetModel(shipModel, shipModel, shipModel, shipModel,
                shipModel, shipModel, shipModel);


        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();

        int mapWidth = 6;
        int mapHeight = 4;

        px = (screenWidth - 128 - 128) / (mapWidth * 2);
        py = (screenHeight - 128) / (mapHeight * 2);

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 1,
                screenHeight - (128 / 2 + py + py * 2 * 0)), 0, 1,
                new int[]{1, 2, 3}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 4,
                screenHeight - (128 / 2 + py + py * 2 * 0)), 0, 1,
                new int[]{0, 4, 5}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 0,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, 1,
                new int[]{0, 3, 6, 8}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 2,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, 1,
                new int[]{0, 2, 4, 9}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 3,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, 1,
                new int[]{1, 3, 5, 9, 10}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 5,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, 1,
                new int[]{1, 4, 7, 11}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 1,
                screenHeight - (128 / 2 + py + py * 2 * 2)), 0, 1,
                new int[]{2}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 4,
                screenHeight - (128 / 2 + py + py * 2 * 2)), 0, 1,
                new int[]{5}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 0,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, 1,
                new int[]{2, 9}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 2,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, 1,
                new int[]{3, 8, 4, 10}, fleetModel));


        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 3,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, 1,
                new int[]{4, 9, 11}, fleetModel));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 5,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, 1,
                new int[]{5, 10}, fleetModel));


        aiPlay = new AIPlay(gdxGame, this, stars);
        gdxGame.setScreen(aiPlay);
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
