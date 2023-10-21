package com.example.smile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.List;

public class Listar extends ListActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.trabalhadores);

        ControladorSQL db = new ControladorSQL(this);
        List<Trabalhadores> list = db.buscar();
        setListAdapter(new TrabalhadoresAdapter(this , list));



        }
    }

