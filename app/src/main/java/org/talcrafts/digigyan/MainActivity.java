package org.talcrafts.digigyan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.talcrafts.digigyan.activity.BaseAcitivity;
import org.talcrafts.digigyan.login.LoginActivity;
import org.talcrafts.digigyan.networking.GenericBroadCastReceiver;
import org.talcrafts.digigyan.networking.bluetooth.BluetoothEndPointListActivity;
import org.talcrafts.digigyan.networking.wifi.WifiEndPointListActivity;

public class MainActivity extends BaseAcitivity {

    private Button mBluetoothButton;
    private Button mWifiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBluetoothButton=(Button) findViewById(R.id.bluetoothButton);
        mBluetoothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BluetoothEndPointListActivity.class);
                startActivity(intent);
            }
        });
        mWifiButton=(Button)findViewById(R.id.wifiButton);
        mWifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WifiEndPointListActivity.class);
                startActivity(intent);
            }
        });


        GenericBroadCastReceiver receiver =new GenericBroadCastReceiver((WifiManager) getSystemService(Context.WIFI_SERVICE),BluetoothAdapter.getDefaultAdapter());

        IntentFilter wifiIntentFilters = new IntentFilter();
        wifiIntentFilters.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        wifiIntentFilters.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        wifiIntentFilters.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        registerReceiver(receiver, wifiIntentFilters);

        IntentFilter btIntentFilters = new IntentFilter();
        btIntentFilters.addAction(BluetoothDevice.ACTION_FOUND);
        btIntentFilters.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(receiver,btIntentFilters);

//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
