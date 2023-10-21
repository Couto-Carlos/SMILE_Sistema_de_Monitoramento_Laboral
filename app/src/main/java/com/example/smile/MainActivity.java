package com.example.smile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button btn_adiciona;
    private Button btn_lista;
    private Button btn_bluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btn_adiciona = (Button) findViewById(R.id.btn_adiciona);

    btn_adiciona.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent adici = new Intent(MainActivity.this,Adiciona_actv.class);
            startActivity(adici);
        }
    });

        System.out.println("alou");
        btn_lista = (Button) findViewById(R.id.btn_lista);

        btn_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adici = new Intent(MainActivity.this,Listar.class);
                startActivity(adici);
            }
        });

        btn_bluetooth = (Button) findViewById(R.id.btn_bluetooth);

        btn_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adici = new Intent(MainActivity.this,Bluetooth.class);
                startActivity(adici);
            }
        });
    }


}
