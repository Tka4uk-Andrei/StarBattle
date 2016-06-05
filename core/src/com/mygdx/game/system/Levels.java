package com.mygdx.game.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.models.StarModel;

public class Levels {

    public static Array<StarModel> getStars1() {
        Array<StarModel> stars = new Array<StarModel>();

        int screenHeight = Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();

        int mapWidth = 6;
        int mapHeight = 4;

        float px = (screenWidth - 128 - 128) / (mapWidth * 2);
        float py = (screenHeight - 128) / (mapHeight * 2);

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 1,
                screenHeight - (128 / 2 + py + py * 2 * 0)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{1, 2, 3}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 4,
                screenHeight - (128 / 2 + py + py * 2 * 0)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{0, 4, 5}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 0,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.ADVANCED_FACTORY,
                new int[]{0, 3, 6, 8}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 2,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.SMALL,
                new int[]{0, 2, 4, 9}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 3,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.ADVANCED_FACTORY,
                new int[]{1, 3, 5, 9, 10}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 5,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.MINE,
                new int[]{1, 4, 7, 11}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 1,
                screenHeight - (128 / 2 + py + py * 2 * 2)), 0, StarModel.Constants.Types.SMALL,
                new int[]{2}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 4,
                screenHeight - (128 / 2 + py + py * 2 * 2)), 0, StarModel.Constants.Types.SMALL,
                new int[]{5}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 0,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{2, 9}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 2,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.MINE,
                new int[]{3, 8, 4, 10}, new FleetModel()));


        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 3,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.SMALL,
                new int[]{4, 9, 11}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 5,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{5, 10}, new FleetModel()));

        stars.get(6).setMastership(Constants.Sides.FRIENDLY);
        stars.get(7).setMastership(Constants.Sides.HOSTILE);

        return stars;
    }

    public static Array<StarModel> getStars2() {
        Array<StarModel> stars = new Array<StarModel>();

        int screenHeight = Gdx.graphics.getHeight();
        int screenWidth = Gdx.graphics.getWidth();

        int mapWidth = 6;
        int mapHeight = 4;

        float px = (screenWidth - 128 - 128) / (mapWidth * 2);
        float py = (screenHeight - 128) / (mapHeight * 2);

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 1,
                screenHeight - (128 / 2 + py + py * 2 * 0)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{1, 2, 3}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 4,
                screenHeight - (128 / 2 + py + py * 2 * 0)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{0, 4, 5}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 0,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.ADVANCED_FACTORY,
                new int[]{0, 3, 6, 8}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 2,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.SMALL,
                new int[]{0, 2, 4, 9}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 3,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.ADVANCED_FACTORY,
                new int[]{1, 3, 5, 9, 10}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 5,
                screenHeight - (128 / 2 + py + py * 2 * 1)), 0, StarModel.Constants.Types.MINE,
                new int[]{1, 4, 7, 11}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 1,
                screenHeight - (128 / 2 + py + py * 2 * 2)), 0, StarModel.Constants.Types.SMALL,
                new int[]{2}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 4,
                screenHeight - (128 / 2 + py + py * 2 * 2)), 0, StarModel.Constants.Types.SMALL,
                new int[]{5}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 0,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{2, 9}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 2,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.MINE,
                new int[]{3, 8, 4, 10}, new FleetModel()));


        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 3,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.SMALL,
                new int[]{4, 9, 11}, new FleetModel()));

        stars.add(new StarModel(new Point(128 / 2 + px + px * 2 * 5,
                screenHeight - (128 / 2 + py + py * 2 * 3)), 0, StarModel.Constants.Types.FACTORY,
                new int[]{5, 10}, new FleetModel()));

        stars.get(6).setMastership(Constants.Sides.FRIENDLY);
        stars.get(7).setMastership(Constants.Sides.HOSTILE);

        return stars;
    }
}
