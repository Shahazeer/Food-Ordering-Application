package com.example.FlavourDash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "android.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_EMAIL + " TEXT PRIMARY KEY, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result != -1; // Returns true if insertion was successful
    }

    public String getUserPassword(String email) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {COLUMN_PASSWORD};
        String selection = COLUMN_EMAIL + "=?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null);
        String password = null;
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_PASSWORD);
            if (columnIndex >= 0) {
                password = cursor.getString(columnIndex);
            }
        }
        cursor.close();
        db.close();
        return password;
    }
}

