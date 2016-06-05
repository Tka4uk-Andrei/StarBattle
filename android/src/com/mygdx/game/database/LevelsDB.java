package com.mygdx.game.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.db.AbstractLevelsDb;
import com.mygdx.game.models.FleetModel;
import com.mygdx.game.models.ShipModel;
import com.mygdx.game.models.StarModel;
import com.mygdx.game.system.Point;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LevelsDB extends AbstractLevelsDb {

    private StarsDB starsDB;
    private SQLiteDatabase stmt;

    public LevelsDB(Context context) {
        starsDB = new StarsDB(context);
        stmt = starsDB.getWritableDatabase();
        starsDB.createDb();
    }

    @Override
    public Array<Array<StarModel>> getStarModels(int width, int height) {
        return starsDB.selectAllStars(width, height);
    }

    class StarsDB extends SQLiteOpenHelper {

        public static final String DB_PATH = "/data/data/com.mygdx.game.database/databases/";
        public static final String DB_NAME = "levels.db";

        public static final String TABLE_NAME = "groups";
        public static final String KEY_LEVEL_ID = "level_id";
        public static final String KEY_X_COORDINATE = "x_cordinate";
        public static final String KEY_Y_COORDINATE = "y_cordinate";
        public static final String KEY_CONNECTED_STARS = "connected_stars";
        public static final String KEY_STAR_SIDE = "star_side";
        public static final String KEY_STAR_TYPE = "star_type";
        public static final String KEY_RAPTOR_COUNT = "raptor_count";
        public static final String KEY_SHIELD_COUNT = "shield_count";
        public static final String KEY_ONE_SHIELD_COUNT = "one_shield_count";
        public static final String KEY_TWO_SHIELD_COUNT = "two_shield_count";
        public static final String KEY_MASTERSHIP = "mastership";

        public static final String CREATE_DB = "CREATE TABLE " +
                TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT not null," +
                KEY_LEVEL_ID + " varchar(50) not null," +
                KEY_X_COORDINATE + " varchar(50) not null," +
                KEY_Y_COORDINATE + " varchar(20) not null," +
                KEY_CONNECTED_STARS + " varchar(20) not null," +
                KEY_STAR_SIDE + " varchar(500) not null," +
                KEY_STAR_TYPE + " varchar(150)," +
                KEY_RAPTOR_COUNT + " varchar(150)," +
                KEY_SHIELD_COUNT + " blob," +
                KEY_ONE_SHIELD_COUNT + " varchar(150)," +
                KEY_TWO_SHIELD_COUNT + " blob," +
                KEY_MASTERSHIP + " INTEGER not null" + ")";

        private StarsDB thisStarsDB;
        private SQLiteDatabase thisDB;

        private Context context;

        public StarsDB(Context context) {
            super(context, DB_NAME, null, 1);
            this.context = context;
        }

        public StarsDB getThisGroupsDataBase(Context context) {
            if (thisStarsDB == null) {
                createDb();
                thisStarsDB = new StarsDB(context);
                thisDB = thisStarsDB.getWritableDatabase();
            }
            return thisStarsDB;
        }

        public void createDb() {
            InputStream myInput = null;
            OutputStream myOutput = null;

            try {
                File file = new File(DB_PATH + DB_NAME);
                if (!file.exists()) {
                    this.getReadableDatabase();
                    //получаем локальную бд как поток
                    myInput = context.getAssets().open(DB_NAME);
                    // Путь к новой бд
                    String outFileName = DB_PATH + DB_NAME;

                    // Открываем пустую бд
                    myOutput = new FileOutputStream(outFileName);

                    // побайтово копируем данные
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = myInput.read(buffer)) > 0) {
                        myOutput.write(buffer, 0, length);
                    }

                    // закрываем потоки
                    myOutput.flush();
                    myOutput.close();
                    myInput.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB);
        }

        public Array<Array<StarModel>> selectAllStars(int width, int height) {
            Array<Array<StarModel>> levels = new Array<>();

            Cursor cursor = thisDB.query(TABLE_NAME, null, null, null, null, null, null);

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

            float px = width / (x + 1);
            float py = height / (y + 1);

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

            int prevLevel = cursor.getInt(cursor.getColumnIndex(KEY_LEVEL_ID));

            Array<StarModel> stars = new Array<>();

            do {
                int connectedStars[] = new int[cursor.getString(cursor.getColumnIndex(KEY_CONNECTED_STARS)).length()];

                for (int i = 0; i < cursor.getString(cursor.getColumnIndex(KEY_CONNECTED_STARS)).length(); ++i)
                    connectedStars[i] = cursor.getString(cursor.getColumnIndex(KEY_CONNECTED_STARS)).charAt(i) - '-';


                StarModel starModel = new StarModel(new Point(
                        cursor.getInt(cursor.getColumnIndex(KEY_X_COORDINATE)),
                        cursor.getInt(cursor.getColumnIndex(KEY_Y_COORDINATE))),
                        0,
                        cursor.getInt(cursor.getColumnIndex(KEY_STAR_TYPE)),
                        connectedStars,
                        new FleetModel()
                );

                starModel.setSide(cursor.getInt(cursor.getColumnIndex(KEY_STAR_SIDE)));


                starModel.getFleetModel().setShip(new ShipModel(cursor.getInt(cursor.getColumnIndex(KEY_STAR_SIDE)),
                        ShipModel.Constants.Types.RAPTOR,
                        cursor.getInt(cursor.getColumnIndex(KEY_RAPTOR_COUNT))));

                starModel.getFleetModel().setShip(new ShipModel(
                        cursor.getInt(cursor.getColumnIndex(KEY_STAR_SIDE)),
                        ShipModel.Constants.Types.SHIELD,
                        cursor.getInt(cursor.getColumnIndex(KEY_SHIELD_COUNT))));

                starModel.getFleetModel().setShip(new ShipModel(cursor.getInt(cursor.getColumnIndex(KEY_STAR_SIDE)),
                        ShipModel.Constants.Types.TWO_SHIELD,
                        cursor.getInt(cursor.getColumnIndex(KEY_TWO_SHIELD_COUNT))));
                starModel.getFleetModel().setShip(new ShipModel(cursor.getInt(cursor.getColumnIndex(KEY_STAR_SIDE)),
                        ShipModel.Constants.Types.ONE_SHIELD,
                        cursor.getInt(cursor.getColumnIndex(KEY_ONE_SHIELD_COUNT))));

                if (cursor.isLast())
                    break;

                cursor.moveToNext();

            }
            while (prevLevel == cursor.getInt(cursor.getColumnIndex(KEY_LEVEL_ID)));

            return stars;
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
