package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.MainMenu;

public class GdxGame extends Game {

    @Override
    public void create() {
        MainMenu mainMenu = new MainMenu(this);
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
