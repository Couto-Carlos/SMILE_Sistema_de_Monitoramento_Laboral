package com.example.smile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ReciveBluetooth extends AppCompatActivity {
    private RobertBluetoothInterface bluetooth_interface = new RobertBluetoothInterface();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive_bluetooth);

        if (BluetoothManager.getSocket() != null && BluetoothManager.getSocket().isConnected()) {
        } else {
            Toast.makeText(getBaseContext(), "Sem uma conexão bluetooth não é possível executar", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(ReciveBluetooth.this, "Pronto para começar", Toast.LENGTH_LONG).show();
        BluetoothManager.beginListenForData(bluetooth_interface);


    }
    public class RobertBluetoothInterface implements BluetoothListenInterface {
        @Override
        public void ouvinte(String s) {
            Toast.makeText(ReciveBluetooth.this, s, Toast.LENGTH_LONG).show();
        }
    }
}
