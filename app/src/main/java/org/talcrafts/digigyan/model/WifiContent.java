package org.talcrafts.digigyan.model;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class WifiContent {

    final WifiManager mWifiManager;

    public static final List<WifiEndpoint> ITEMS = new ArrayList<WifiEndpoint>();
    public static final Map<String, WifiEndpoint> ITEM_MAP = new HashMap<String, WifiEndpoint>();

    public WifiContent(WifiManager wifiManager) {
        this.mWifiManager = wifiManager;
        wifiManager.startScan(); //TODO better place to initialize
    }


    public void scan() {
        List<ScanResult> wifiScanList = mWifiManager.getScanResults();
        ITEMS.clear();
        for (ScanResult result : wifiScanList) {
            addItem(result);
        }
    }

    private static void addItem(ScanResult item) {
        WifiEndpoint endpoint = WifiEndpoint.from(item);
        ITEMS.add(endpoint);
        ITEM_MAP.put(endpoint.id, endpoint);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class WifiEndpoint extends EndPoint {
        public final String id;
        public final String content;
        public final String details;

        public WifiEndpoint(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        public static WifiEndpoint from(ScanResult result) {
            WifiEndpoint obj = new WifiEndpoint(result.BSSID, result.capabilities, result.SSID.toString());
            return obj;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
