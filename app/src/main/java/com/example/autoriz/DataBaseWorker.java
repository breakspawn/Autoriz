package com.example.autoriz;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Pair;
// работа с базой данных

import java.io.IOException;

public class DataBaseWorker
{
    private  SQLiteDatabase db;
    private DatabaseHelper helper;

    public final String T_USERS = "Users";
    public final String F_NAME = "Username";
    public final String F_PASS = "Password";
    public final String F_AGE = "Age";

    public DataBaseWorker(Context context)
    {
        helper = new DatabaseHelper(context);
        UpdateDB();
        try {
            db = helper.getWritableDatabase();
        } catch (SQLException e) {
            throw e;
        }
    }

    private void UpdateDB() throws Error
    {
        try {
            helper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
    }

    public String select(String table)
    {
        String result = "";
        Cursor c = db.rawQuery("SELECT * FROM "+ table, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            for (int i = 0; i < c.getColumnCount(); i++)
            {
                result += c.getString(i) + " | ";
            }
            result += "\n";
            c.moveToNext();
        }
        c.close();
        return result;
    }

    public  boolean equals(String table, String username, String field, String value)
    {
        boolean result = false;

        Cursor c = db.rawQuery("SELECT * FROM "+ table, null);
        c.moveToFirst();
        while(!c.isAfterLast())
        {
            String fieldRes = c.getString(c.getColumnIndex(field));
            String uname = c.getString(c.getColumnIndex(F_NAME));
            if(fieldRes.equals(String.valueOf(value)) && uname.equals(String.valueOf(username)))
            {
                result = true;
                break;
            }
            c.moveToNext();
        }
        c.close();

        return result;
    }

    public boolean insert (String table, Pair[] pairs)
    {
        ContentValues values = new ContentValues();
        for ( Pair p : pairs ) {
            values.put(p.first.toString(), p.second.toString());
        }
        return db.insert(table,null,values) > -1;
    }
}
