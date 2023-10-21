package com.example.smile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateSQL extends SQLiteOpenHelper {

    public static final String NOME_DO_BANCO = "Banco";
    public static final String ID = "_id";
    public static final String TABELA = "TRABALHADORES";
    public static final int Versao = 7;
    public static final String SETOR = "SETOR";
    public static final String NOME = "NOME";
  //  public static final String META = "META";
  //  public static final String CLO  = "CLO";



    public CreateSQL(Context context){

        super(context,NOME_DO_BANCO,null,Versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SETOR + " text not null, "+ NOME + " text not null " + ");";

        // CREATE TABLE IF NOT EXISTS trabalhadores(_id integer primary key autoincrement, nome text, setor text)
            db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABELA +";");
        onCreate(db);
    }

}
