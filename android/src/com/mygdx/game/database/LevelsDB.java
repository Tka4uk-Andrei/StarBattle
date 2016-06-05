package com.mygdx.game.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.db.AbstractLevelsDb;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.Point;

public class LevelsDB extends AbstractLevelsDb {

    private StarsDB starsDB;
    private SQLiteDatabase stmt;

    public LevelsDB(Context context) {
        starsDB = new StarsDB(context);

        String path = StarsDB.DB_PATH + StarsDB.DB_NAME;
        stmt = SQLiteDatabase.openDatabase(path, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public Array<Array<StarModel>> getStarModels(int width, int height) {
        Array<Array<StarModel>> levels = new Array<>();

        Cursor cursor = stmt.query(StarsDB.TABLE_NAME, null, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isLast()) {
            levels.add(setLevelValues(cursor));
        }

        float x = 0;
        float y = 0;

        for (Array<StarModel> level : levels) {
            for (StarModel starModel : level) {
                x = Math.max(x, starModel.getCenterPoint().getX());
                y = Math.max(y, starModel.getCenterPoint().getY());
            }
        }

        float px = (width - 128 - 128) / ((x + 1) * 2);
        float py = (height - 128) / ((y + 1) * 2);

        for (Array<StarModel> level : levels) {
            for (StarModel starModel : level) {
                starModel.getCenterPoint().setX(128 / 2 + px +
                        px * 2 * starModel.getCenterPoint().getX());

                starModel.getCenterPoint().setY(height - (128 / 2 + py +
                        py * 2 * starModel.getCenterPoint().getY()));
            }
        }

        return levels;
    }

    private Array<StarModel> setLevelValues(Cursor cursor) {

        int prevLevel = cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_LEVEL_ID));

        Array<StarModel> stars = new Array<>();

        do {
            int connectedStars[] = new int[cursor.getString(cursor.getColumnIndex(StarsDB.KEY_CONNECTED_STARS)).length()];

            for (int i = 0; i < cursor.getString(cursor.getColumnIndex(StarsDB.KEY_CONNECTED_STARS)).length(); ++i)
                connectedStars[i] = cursor.getString(cursor.getColumnIndex(StarsDB.KEY_CONNECTED_STARS)).charAt(i) - '-';


            StarModel starModel = new StarModel(new Point(
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_X_COORDINATE)),
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_Y_COORDINATE))),
                    0,
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_STAR_TYPE)),
                    connectedStars,
                    new FleetModel()
            );

            starModel.setSide(cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_STAR_SIDE)));


            starModel.getFleetModel().setShip(new ShipModel(cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_STAR_SIDE)),
                    ShipModel.Constants.Types.RAPTOR,
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_RAPTOR_COUNT))));

            starModel.getFleetModel().setShip(new ShipModel(
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_STAR_SIDE)),
                    ShipModel.Constants.Types.SHIELD,
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_SHIELD_COUNT))));

            starModel.getFleetModel().setShip(new ShipModel(cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_STAR_SIDE)),
                    ShipModel.Constants.Types.TWO_SHIELD,
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_TWO_SHIELD_COUNT))));
            starModel.getFleetModel().setShip(new ShipModel(cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_STAR_SIDE)),
                    ShipModel.Constants.Types.ONE_SHIELD,
                    cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_ONE_SHIELD_COUNT))));

            starModel.setMastership(cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_MASTERSHIP)));

            if (cursor.isLast())
                break;

            cursor.moveToNext();

        }
        while (prevLevel == cursor.getInt(cursor.getColumnIndex(StarsDB.KEY_LEVEL_ID)));

        return stars;
    }
}
