package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.tool.datahandles.DataHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DataHandlerCache {
    public static volatile DataHandlerCache c;
    public final Map<String, DataHandler> a = Collections.synchronizedMap(new HashMap());
    public final List<BluetoothDevice> b = Collections.synchronizedList(new ArrayList());

    public static DataHandlerCache getInstance() {
        if (c == null) {
            synchronized (DataHandlerCache.class) {
                try {
                    if (c == null) {
                        c = new DataHandlerCache();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public final void a() {
        Iterator it = new HashSet(this.a.keySet()).iterator();
        while (it.hasNext()) {
            DataHandler dataHandler = this.a.get((String) it.next());
            if (dataHandler != null) {
                dataHandler.release();
            }
        }
        this.a.clear();
        this.b.clear();
    }

    public void addDataHandler(BluetoothDevice bluetoothDevice, DataHandler dataHandler) {
        if (bluetoothDevice == null || dataHandler == null) {
            return;
        }
        if (!this.b.contains(bluetoothDevice)) {
            this.b.add(bluetoothDevice);
        }
        if (this.a.containsKey(bluetoothDevice.getAddress())) {
            return;
        }
        this.a.put(bluetoothDevice.getAddress(), dataHandler);
    }

    public void destroy() {
        a();
        c = null;
    }

    public DataHandler getDataHandler(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return this.a.get(bluetoothDevice.getAddress());
    }

    public List<BluetoothDevice> getDeviceList() {
        return this.b;
    }

    public void removeDataHandler(BluetoothDevice bluetoothDevice) {
        DataHandler dataHandlerRemove;
        if (bluetoothDevice == null || (dataHandlerRemove = this.a.remove(bluetoothDevice.getAddress())) == null) {
            return;
        }
        this.b.remove(bluetoothDevice);
        dataHandlerRemove.release();
    }
}
