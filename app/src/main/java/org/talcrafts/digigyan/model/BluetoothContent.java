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
public class BluetoothContent {

    final BluetoothAdapter mBtAdapter;

    public static final List<BLEndpoint> ITEMS = new ArrayList<BLEndpoint>();
    public static final Map<String, BLEndpoint> ITEM_MAP = new HashMap<String, BLEndpoint>();

    public BluetoothContent(BluetoothAdapter btAdapter){
        this.mBtAdapter=btAdapter;
        //TODO better place to initialize
        if (mBtAdapter.isDiscovering()) {
            mBtAdapter.cancelDiscovery();
        }
        mBtAdapter.startDiscovery();
    }

    public void scan() {
        Set<BluetoothDevice> devices = mBtAdapter.getBondedDevices();
        for (BluetoothDevice device : devices)
            addItem(device);
    }

    private static void addItem(BluetoothDevice device) {
        BLEndpoint item = new BLEndpoint(device.getAddress(), device.getName(), device.getName());
        ITEMS.add(item);
        ITEM_MAP.put(item.id,item);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class BLEndpoint extends EndPoint {
        public final String id;
        public final String content;
        public final String details;

        public BLEndpoint(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
