package org.talcrafts.digigyan.model;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class BluetoothContent extends EndPointContent {

    final BluetoothAdapter mBtAdapter;

    private static BluetoothContent ourInstance;

    public static BluetoothContent getInstance() {
        return ourInstance;
    }

    public void startScan() {
        if (mBtAdapter.isDiscovering()) {
            mBtAdapter.cancelDiscovery();
        }
        mBtAdapter.startDiscovery();
    }

    public void syncResult() {
        ITEMS.clear();
        ITEM_MAP.clear();
        Set<BluetoothDevice> devices = mBtAdapter.getBondedDevices();
        for (BluetoothDevice device : devices)
            addItem(device);
    }

    public BluetoothContent(BluetoothAdapter btAdapter) {
        this.mBtAdapter = btAdapter;
        ourInstance = this;
    }

    public void addItem(BluetoothDevice device) {
        BLEndpoint item = new BLEndpoint(device.getAddress(), device.getName(), device.getName());
        addItem(item);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class BLEndpoint extends EndPoint {

        public BLEndpoint(String id, String content, String details) {
            super(id);
            this.content = content;
            this.details = details;
            this.type=this.getClass().getSimpleName();
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
