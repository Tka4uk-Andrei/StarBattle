package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.db.AbstractLevelsDb;
import com.mygdx.game.screens.MainMenu;

public class GdxGame extends Game {

    private MainMenu mainMenu;
    private AbstractLevelsDb levelsDb;

    public GdxGame(AbstractLevelsDb levelsDb) {
        this.levelsDb = levelsDb;
    }

    @Override
    public void create() {
        mainMenu = new MainMenu(this);
        setScreen(mainMenu);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }
}
