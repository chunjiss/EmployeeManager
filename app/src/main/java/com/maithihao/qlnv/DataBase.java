package com.maithihao.qlnv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DataBase {
    Context context;
    String dbName = "qlnv.db";


    public DataBase(Context context) {
        this.context = context;
    }

    private SQLiteDatabase openDB() {
        return context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }

    private void closeDB(SQLiteDatabase db) {
        db.close();
    }

    public void createTable() {
        SQLiteDatabase db = openDB();
        String sqlQlsv = "CREATE TABLE IF NOT EXISTS qlnv (" +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " ten TEXT," +
                " que TEXT," +
                " gioitinh TEXT," +
                " chucvu TEXT," +
                " luong TEXT );";

        db.execSQL(sqlQlsv);
        closeDB(db);
    }


    public ArrayList<NhanVien> getAllNhanVien() {
        SQLiteDatabase db = openDB();
        ArrayList<NhanVien> arr = new ArrayList<>();
        String sql = "select * from qlnv";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String name = csr.getString(1);
                    String que = csr.getString(2);
                    String gioitinh = csr.getString(3);
                    String chucvu = csr.getString(4);
                    String luong = csr.getString(5);
                    NhanVien NhanVien = new NhanVien(id, name, que, gioitinh, chucvu, luong);
                    arr.add(NhanVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }


    public ArrayList<NhanVien> getAllNhanVien(String content) {
        SQLiteDatabase db = openDB();
        ArrayList<NhanVien> arr = new ArrayList<>();
        String sql = "select * from qlnv where ten like" + "'%" + content + "%'";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String name = csr.getString(1);
                    String que = csr.getString(2);
                    String gioitinh = csr.getString(3);
                    String chucvu = csr.getString(4);
                    String luong = csr.getString(5);
                    NhanVien NhanVien = new NhanVien(id, name, que, gioitinh, chucvu, luong);
                    arr.add(NhanVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }

    public NhanVien getNhanVien(String idsv) {
        SQLiteDatabase db = openDB();
        ArrayList<NhanVien> arr = new ArrayList<>();
        String sql = "select * from qlnv where id = " + idsv;
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String name = csr.getString(1);
                    String que = csr.getString(2);
                    String gioitinh = csr.getString(3);
                    String chucvu = csr.getString(4);
                    String luong = csr.getString(5);
                    NhanVien NhanVien = new NhanVien(id, name, que, gioitinh, chucvu, luong);
                    arr.add(NhanVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr.get(0);
    }

    //
//
//
    public void insertSv(NhanVien sv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", sv.getId());
        contentValues.put("ten", sv.getTen());
        contentValues.put("que", sv.getQue());
        contentValues.put("gioitinh", sv.getGioitinh());
        contentValues.put("chucvu", sv.getChucvu());
        contentValues.put("luong", sv.getLuong());
        SQLiteDatabase db = openDB();
        db.insert("qlnv", null, contentValues);
        closeDB(db);
    }

    public void updateSv(NhanVien sv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", sv.getId());
        contentValues.put("ten", sv.getTen());
        contentValues.put("que", sv.getQue());
        contentValues.put("gioitinh", sv.getGioitinh());
        contentValues.put("chucvu", sv.getChucvu());
        contentValues.put("luong", sv.getLuong());
        SQLiteDatabase db = openDB();
        db.update("qlnv", contentValues, "id" + " = ?",
                new String[]{sv.getId()});
        closeDB(db);
    }

    public void deletenv(String id) {
        SQLiteDatabase db = openDB();
        db.delete("qlnv", "id" + " = ?",
                new String[]{id});
    }
//

}
