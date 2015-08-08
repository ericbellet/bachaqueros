package com.ati.damlabs.dam_lab_android_2.libs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ati.damlabs.dam_lab_android_2.models.User;

/**
 * Created by eric on 31/07/15.
 */



/**
 * Created by Juan on 7/19/2015.
 */
public class UsersLocalDB extends SQLiteOpenHelper {

    private SQLiteDatabase database;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";

    public static final String sqlUserCreateTable =
            "CREATE TABLE User" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " email TEXT)";

    public static final String sqlUserDropTable =
            "DROP TABLE IF EXISTS User";

    public UsersLocalDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void dropTable(){
        database.execSQL(sqlUserDropTable);

        onCreate(database);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlUserCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlUserDropTable);

        onCreate(db);
    }

    public void write() {
        database = this.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public void createUser(User user) {

        ContentValues newUser = new ContentValues();

        newUser.put("email", user.get_email());


        database.insert("Pastie", null, newUser);
    }

}
