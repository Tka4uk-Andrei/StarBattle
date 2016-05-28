//package com.mygdx.game.database;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteStatement;
//
//import com.mygdx.game.db.AbstractLevelsDb;
//
//public class LevelsDB extends AbstractLevelsDb {
//
//    protected SQLiteOpenHelper db_connection;
//    protected SQLiteDatabase stmt;
//
//    public LevelsDB(Context context) {
//        db_connection = new AndroidDB(context, database_name, null, version);
//        stmt = db_connection.getWritableDatabase();
//    }
//
//    public void execute(String sql) {
//        stmt.execSQL(sql);
//    }
//
//    public int executeUpdate(String sql) {
//        stmt.execSQL(sql);
//        SQLiteStatement tmp = stmt.compileStatement("SELECT CHANGES()");
//        return (int) tmp.simpleQueryForLong();
//    }
//
//    public Result query(String sql) {
//        ResultAndroid result = new ResultAndroid(stmt.rawQuery(sql, null));
//        return result;
//    }
//
//    class AndroidDB extends SQLiteOpenHelper {
//
//        public AndroidDB(Context context, String name, CursorFactory factory,
//                         int version) {
//            super(context, name, factory, version);
//        }
//
//        public void onCreate(SQLiteDatabase db) {
//            stmt = db;
//            DatabaseAndroid.this.onCreate();
//        }
//
//        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            stmt = db;
//            DatabaseAndroid.this.onUpgrade();
//        }
//    }
//
//}
