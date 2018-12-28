package com.mygdx.game.db;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.models.StarModel;

// БД дорабатывается....
public abstract class AbstractLevelsDb {

    public abstract Array<Array<StarModel>> getStarModels(int width, int height);

}
