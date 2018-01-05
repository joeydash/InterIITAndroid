package com.joeydash.interiitandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Dbhelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "InterIIT.db";
    public static String TABLE_NAME = "QrTable";
    public static String COL_1 = "ID";
    public static String COL_2 = "QR_DETAILS";
    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" Create Table "+TABLE_NAME+" ( "+COL_1+" Integer Primary Key Autoincrement ,"+COL_2+" Text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table If Exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public Long insertData(String details){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,details);
        return sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }
    public Cursor getData(String details){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("Select * From "+TABLE_NAME+ " WHERE "+COL_2 + "= ?",new String[] {details});
    }
    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("Select * From "+TABLE_NAME,null);
    }
    public void deleteAll(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Integer response = sqLiteDatabase.delete(TABLE_NAME,null,null);
    }
}
