package org.talcrafts.digigyan.model;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

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
public class WifiContent extends EndPointContent {

    private static WifiContent ourInstance;
    public static WifiContent getInstance() {
        return ourInstance;
    }

    final WifiManager mWifiManager;

    public static List<WifiEndpoint> ITEMS = new ArrayList<WifiEndpoint>();
    public static Map<String, WifiEndpoint> ITEM_MAP = new HashMap<String, WifiEndpoint>();

    public WifiContent(WifiManager wifiManager) {
        this.mWifiManager = wifiManager;
        ourInstance=this;

    }
    public void startScan(){
        this.mWifiManager.startScan(); //TODO better place to initialize
    }

    public void syncResult() {
        ITEMS.clear();
        ITEM_MAP.clear();
        List<ScanResult> wifiScanList = mWifiManager.getScanResults();
        ITEMS.clear();
        for (ScanResult result : wifiScanList) {
            addItem(result);
        }
    }

    private void addItem(ScanResult item) {
        WifiEndpoint endpoint = WifiEndpoint.from(item);
        addItem(endpoint);
        }

    public static class WifiEndpoint extends EndPoint {
        public final String id;
        public final String content;
        public final String details;

        public WifiEndpoint(String id, String content, String details) {
            super(id);
            this.id = id;
            this.content = content;
            this.details = details;
            this.type=this.getClass().getSimpleName();
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
