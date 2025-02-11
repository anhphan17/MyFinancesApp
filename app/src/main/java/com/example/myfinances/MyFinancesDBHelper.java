package com.example.myfinances;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyFinancesDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myfinances.db";
    private static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE_CD =
            "create table cd (_id integer primary key autoincrement, " +
                    "account_number integer, initial_balance double, current_balance double," +
                    "interest_rate float);";

    public static final String CREATE_TABLE_LOANS =
            "create table loans (_id integer primary key autoincrement, account_number integer, " +
                    "initial_balance double, current_balance double, payment_amount double, " +
                    "interest_rate float);";

    public static final String CREATE_TABLE_CHECKINGS =
            "create table checkings (_id integer primary key autoincrement, " +
                    "account_number integer, current_balance double);";

    public MyFinancesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CD);
        db.execSQL(CREATE_TABLE_LOANS);
        db.execSQL(CREATE_TABLE_CHECKINGS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cd");
        db.execSQL("DROP TABLE IF EXISTS loans");
        db.execSQL("DROP TABLE IF EXISTS checkings");
        onCreate(db);

    }
}
