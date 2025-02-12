package com.example.myfinances;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MyFinancesDataSource {
    private SQLiteDatabase database;
    private MyFinancesDBHelper dbHelper;

    public MyFinancesDataSource(Context context) {
        dbHelper = new MyFinancesDBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertCD(CertificatesOfDeposit cd) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put("account_number", cd.getAccountNumber());
            initialValues.put("initial_balance", cd.getInitialBalance());
            initialValues.put("current_balance", cd.getCurrentBalance());
            initialValues.put("interest_rate", cd.getInterestRate());

            didSucceed = database.insert("cd", null, initialValues) > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }

    public boolean insertLoans(Loans l) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put("account_number", l.getAccountNumber());
            initialValues.put("initial_balance", l.getInitialBalance());
            initialValues.put("current_balance", l.getCurrentBalance());
            initialValues.put("payment_amount", l.getPaymentAmount());
            initialValues.put("interest_rate", l.getInterestRate());

            didSucceed = database.insert("loans", null, initialValues) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }

    public boolean insertCheckings(Checkings c) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put("account_number", c.getAccountNumber());
            initialValues.put("current_balance", c.getCurrentBalance());

            didSucceed = database.insert("checkings", null, initialValues) > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }

    public boolean updateCD(CertificatesOfDeposit cd) {
        boolean didSucceed = false;
        try {
            long rowId = (long) cd.getCdId();
            ContentValues updateValues = new ContentValues();

            updateValues.put("account_number", cd.getAccountNumber());
            updateValues.put("initial_balance", cd.getInitialBalance());
            updateValues.put("current_balance", cd.getCurrentBalance());
            updateValues.put("interest_rate", cd.getInterestRate());

            didSucceed = database.update("cd", updateValues,"_id="
                    + rowId, null) > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }

    public boolean updateLoans(Loans l) {
        boolean didSucceed = false;
        try {
            long rowId = (long) l.getLoansId();
            ContentValues updateValues = new ContentValues();

            updateValues.put("account_number", l.getAccountNumber());
            updateValues.put("initial_balance", l.getInitialBalance());
            updateValues.put("current_balance", l.getCurrentBalance());
            updateValues.put("payment_amount", l.getPaymentAmount());
            updateValues.put("interest_rate", l.getInterestRate());

            didSucceed = database.update("loans", updateValues,"_id="
                    + rowId, null) > 0;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }

    public boolean updateCheckings(Checkings c) {
        boolean didSucceed = false;
        try {
            long rowId = (long) c.getCheckingsId();
            ContentValues updateValues = new ContentValues();

            updateValues.put("account_number", c.getAccountNumber());
            updateValues.put("current_balance", c.getCurrentBalance());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return didSucceed;
    }

    public int getLastCDId() {
        int lastCDId;
        try {
            String query = "SELECT MAX(_id) FROM cd";
            Cursor cursor = database.rawQuery(query,null);

            cursor.moveToFirst();
            lastCDId = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e) {
            lastCDId = -1;
        }
        return lastCDId;
    }

    public int getLastLoanId() {
        int lastLoanId;
        try {
            String query = "SELECT MAX(_id) FROM loans";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastLoanId = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e) {
            lastLoanId = -1;
        }
        return lastLoanId;
    }

    public int getLastCheckingsId() {
        int lastCheckingsId;
        try {
            String query = "SELECT MAX(_id) FROM checkings";
            Cursor cursor = database.rawQuery(query,null);

            cursor.moveToFirst();
            lastCheckingsId = cursor.getInt(0);
            cursor.close();
        }
        catch (Exception e) {
            lastCheckingsId = -1;
        }
        return lastCheckingsId;
    }
}
