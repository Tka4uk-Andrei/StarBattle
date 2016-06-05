package com.mygdx.game.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StarsDB extends SQLiteOpenHelper {

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
            KEY_LEVEL_ID + "  INTEGER null," +
            KEY_X_COORDINATE + " INTEGER not null," +
            KEY_Y_COORDINATE + " INTEGER not null," +
            KEY_CONNECTED_STARS + " INTEGER not null," +
            KEY_STAR_SIDE + " INTEGER not null," +
            KEY_STAR_TYPE + " INTEGER not null," +
            KEY_RAPTOR_COUNT + " INTEGER," +
            KEY_SHIELD_COUNT + " INTEGER," +
            KEY_ONE_SHIELD_COUNT + " INTEGER," +
            KEY_TWO_SHIELD_COUNT + " INTEGER," +
            KEY_MASTERSHIP + " INTEGER" + ")";

    private Context context;

    public StarsDB(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
        createDb();
    }

    public void createDb() {
        InputStream myInput;
        OutputStream myOutput;

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
        createDb();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
