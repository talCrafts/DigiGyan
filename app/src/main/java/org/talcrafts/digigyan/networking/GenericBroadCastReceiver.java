package org.talcrafts.digigyan.networking;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;

import org.talcrafts.digigyan.model.BluetoothContent;
import org.talcrafts.digigyan.model.WifiContent;

/**
 * Created by ashwaghm on 15-Jan-17.
 */

public class GenericBroadCastReceiver extends BroadcastReceiver {
    final BluetoothContent blueTooth;
    final WifiContent wifi;

    public GenericBroadCastReceiver(WifiManager wifi, BluetoothAdapter blueTooth) {
        this.blueTooth = new BluetoothContent(blueTooth);
        this.wifi = new WifiContent(wifi);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            wifi.scan();
        }
        if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
            blueTooth.scan();
        }
    }
}
