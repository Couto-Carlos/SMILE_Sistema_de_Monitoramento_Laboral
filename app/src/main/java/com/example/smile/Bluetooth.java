package com.example.smile;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

import static com.example.smile.BluetoothManager.list;

public class Bluetooth extends AppCompatActivity {

    private RobertBluetoothInterface bluetooth_interface = new RobertBluetoothInterface();
    int revisao = 0;
    private BluetoothAdapter Bluetooth;
    private Set<BluetoothDevice>pairedDevices;
    static String Revisao;
    ArrayList list = new ArrayList();
    ListView Revisaolist;
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        Bluetooth = BluetoothAdapter.getDefaultAdapter();
        lista = (ListView)findViewById(R.id.list_listview);
        Revisaolist= (ListView)findViewById(R.id.list_temperaturas);


        final ArrayAdapter adapter = new ArrayAdapter(Bluetooth.this, android.R.layout.simple_list_item_1, list);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                System.out.println("entrou");
                BluetoothManager.A(arg2);
            }
        });
    }

    public void on(View v){
        if (!Bluetooth.isEnabled()) {
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnOn, 0);
            Toast.makeText(getApplicationContext(), "Ligado",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Ja está ligado", Toast.LENGTH_LONG).show();
        }
        revisao = 1;
    }

    public void off(View v){
        Bluetooth.disable();
        Toast.makeText(getApplicationContext(), "Desligado" ,Toast.LENGTH_LONG).show();
        revisao = 0;
    }


    public  void visible(View v){
        Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(getVisible, 0);
        revisao = 1;
    }



    public void list(View v) {
        if (revisao == 1) {
            pairedDevices = Bluetooth.getBondedDevices();

            ArrayList list = new ArrayList();

            for (BluetoothDevice bt : pairedDevices) list.add(bt.getName());
            Toast.makeText(getApplicationContext(), "Mostrando aparelhos pairados", Toast.LENGTH_SHORT).show();

            final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

            BluetoothManager.getBluetoothManager(Bluetooth.this).choose_paired_devices(Bluetooth.this);

            lista.setAdapter(adapter);
        } else {
            Toast.makeText(getApplicationContext(), "Ligue para listar", Toast.LENGTH_LONG).show();
        }
    }
        public void ouvir(View v){

           if (BluetoothManager.getSocket() != null && BluetoothManager.getSocket().isConnected()) {
           } else {
               Toast.makeText(getBaseContext(), "Sem uma conexão bluetooth não é possível executar", Toast.LENGTH_LONG).show();
               return;
           }
            Toast.makeText(Bluetooth.this, "Pronto para começar", Toast.LENGTH_LONG).show();
            BluetoothManager.beginListenForData(bluetooth_interface);

        }
    public class RobertBluetoothInterface implements BluetoothListenInterface {
        @Override
        public void ouvinte(String s) {
          //  Toast.makeText(Bluetooth.this, s, Toast.LENGTH_LONG).show();
            list.add(s);
            final ArrayAdapter adapter = new ArrayAdapter(com.example.smile.Bluetooth.this, android.R.layout.simple_list_item_1, list);
            Revisaolist.setAdapter(adapter);
            Revisaolist.setSelection(adapter.getCount() - 1);
        }
    }
}
