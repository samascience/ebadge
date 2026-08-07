package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WatchCacheManager {
    public final Map<String, WatchCache> a = new HashMap();

    public static class WatchCache {
        public int a;
        public int b;
        public boolean c;
        public short d;

        public short getCrc16() {
            return this.d;
        }

        public int getWriteLen() {
            return this.b;
        }

        public int getWriteOffset() {
            return this.a;
        }

        public boolean isNeedCheckReadData() {
            return this.c;
        }

        public WatchCache setCrc16(short s) {
            this.d = s;
            return this;
        }

        public WatchCache setNeedCheckReadData(boolean z) {
            this.c = z;
            return this;
        }

        public WatchCache setWriteLen(int i) {
            this.b = i;
            return this;
        }

        public WatchCache setWriteOffset(int i) {
            this.a = i;
            return this;
        }
    }

    public void destroy() {
        this.a.clear();
    }

    public WatchCache getWatchCache(String str) {
        return this.a.get(str);
    }

    public WatchCache getWatchCacheByDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return getWatchCache(bluetoothDevice.getAddress());
    }

    public boolean isNeedCheckReadData(BluetoothDevice bluetoothDevice) {
        WatchCache watchCacheByDevice = getWatchCacheByDevice(bluetoothDevice);
        if (watchCacheByDevice == null) {
            return false;
        }
        return watchCacheByDevice.isNeedCheckReadData();
    }

    public void putWatchCache(String str, WatchCache watchCache) {
        this.a.put(str, watchCache);
    }

    public void putWatchCacheByDevice(BluetoothDevice bluetoothDevice, WatchCache watchCache) {
        if (bluetoothDevice == null) {
            return;
        }
        putWatchCache(bluetoothDevice.getAddress(), watchCache);
    }

    public WatchCache removeWatchCache(String str) {
        return this.a.remove(str);
    }

    public WatchCache removeWatchCacheByDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return removeWatchCache(bluetoothDevice.getAddress());
    }
}
