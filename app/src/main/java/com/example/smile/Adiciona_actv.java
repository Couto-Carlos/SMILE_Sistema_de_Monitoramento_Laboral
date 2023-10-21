package com.example.smile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class Adiciona_actv extends AppCompatActivity {
    private Trabalhadores trabalhadores = new Trabalhadores();
    private EditText txt_nome;
    private EditText txt_setor;
    private Button btn_Salvar;
    private Button btn_Editar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_actv);

        txt_nome = (EditText) findViewById(R.id.txt_addinfo);
        txt_setor = (EditText) findViewById(R.id.txt_areatrabalho);
        btn_Salvar = (Button) findViewById(R.id.btn_add);
        btn_Editar = (Button) findViewById(R.id.btn_Editar);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                trabalhadores.setId(bundle.getLong("_id"));
                trabalhadores.setNOME(bundle.getString("NOME"));
                trabalhadores.setSETOR(bundle.getString("SETOR"));

                txt_nome.setText(trabalhadores.getNOME());
                txt_setor.setText(trabalhadores.getSETOR());



                btn_Salvar.setVisibility(View.GONE);
                btn_Editar.setVisibility(View.VISIBLE);
            }
        }
    }


        public void Salvar(View view){

            trabalhadores.setNOME(txt_nome.getText().toString());
            trabalhadores.setSETOR(txt_setor.getText().toString());
            ControladorSQL db = new ControladorSQL(this);
            db.AddDados(trabalhadores);


            Toast.makeText(this, "usuario inserido com sucesso", Toast.LENGTH_SHORT).show();
        }
        public void Editar(View view){
        trabalhadores.setNOME(txt_nome.getText().toString());
        trabalhadores.setSETOR(txt_setor.getText().toString());

        ControladorSQL db = new ControladorSQL(this);
            db.atualizar(trabalhadores);


        Toast.makeText(this, "usuario inserido com sucesso", Toast.LENGTH_SHORT).show();
    }

    }




