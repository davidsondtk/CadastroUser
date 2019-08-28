package com.example.logincomsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Constructor;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contato.db";
    private static final String TABLE_NAME = "contato";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USUARIO = "usuario";
    private static final String COLUMN_SENHA = "senha";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contato" +
            "(id integer primary key autoincrement, " +
            " nome text not null, " +
            " email text not null," +
            " usuario text not null," +
            " senha text not null);";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertContato(Contato c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, c.getNome());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_USUARIO, c.getUsuario());
        values.put(COLUMN_SENHA, c.getSenha());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String buscarSenha(String usuario){
        db = this.getReadableDatabase();
        //String query = "SELECT usuario, senha FROM " + TABLE_NAME + " WHERE " + COLUMN_USUARIO + "= " + usuario;
        String query = "SELECT usuario, senha FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "Não Encontrado";
        if(cursor.moveToFirst()){
           do {
               a = cursor.getString(0);
               if(a.equals(usuario)){
                   b = cursor.getString(1);
                   break;
               }
           }while (cursor.moveToNext());
        }
        return b;
    }

}
