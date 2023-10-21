package com.example.smile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Debug;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ControladorSQL {

    private SQLiteDatabase db;
    private CreateSQL banco;
    Context context;

    public ControladorSQL(Context context) {
        banco = new CreateSQL(context);
        db = banco.getWritableDatabase();
        this.context = context;
    }

    public void AddDados(Trabalhadores trabalhadores) {

        ContentValues valores;
        valores = new ContentValues();
        valores.put("NOME", trabalhadores.getNOME());
        valores.put("SETOR", trabalhadores.getSETOR());
        db.insert(CreateSQL.TABELA, null, valores);

    }

    public void atualizar(Trabalhadores trabalhadores) {

        ContentValues valores;
        valores = new ContentValues();
        valores.put("NOME", trabalhadores.getNOME());
        valores.put("SETOR", trabalhadores.getSETOR());
        db.update(CreateSQL.TABELA, valores, "_id = ?", new String[]{"" + trabalhadores.getId()});
    }

    public void deletar(Trabalhadores trabalhadores) {
        db.delete(CreateSQL.TABELA, "_id = " + trabalhadores.getId(), null);
    }

    public List<Trabalhadores> buscar() {
        List<Trabalhadores> list = new ArrayList<Trabalhadores>();
        String[] colunas = new String[]{CreateSQL.SETOR, CreateSQL.NOME, CreateSQL.ID};
        Cursor cursor = db.query(CreateSQL.TABELA, colunas, null, null, null, null, "NOME ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{

                Trabalhadores trabalhadores = new Trabalhadores();
                trabalhadores.setSETOR(cursor.getString(0));
                trabalhadores.setNOME(cursor.getString(1));
                trabalhadores.setId(cursor.getLong(2));
                list.add(trabalhadores);

            }while(cursor.moveToNext());
        }

            return (list);
    }



}
