package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.interfaces.rcsp.ICmdSnGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class SnGenerator implements ICmdSnGenerator {
    private final Map<String, Integer> b = new HashMap();
    private int a = (new Random().nextInt(255) + 1) % 256;

    public synchronized int autoIncSN(BluetoothDevice bluetoothDevice) {
        int cmdSequence = getCmdSequence(bluetoothDevice);
        int i = 0;
        if (bluetoothDevice == null) {
            int i2 = cmdSequence + 1;
            this.a = i2 < 256 ? i2 : 0;
            return cmdSequence;
        }
        int i3 = cmdSequence + 1;
        if (i3 < 256) {
            i = i3;
        }
        this.b.put(bluetoothDevice.getAddress(), Integer.valueOf(i));
        return cmdSequence;
    }

    public void destroy() {
        this.b.clear();
    }

    public int getCmdSequence(BluetoothDevice bluetoothDevice) {
        Integer num;
        if (bluetoothDevice != null && (num = this.b.get(bluetoothDevice.getAddress())) != null) {
            return num.intValue();
        }
        return this.a;
    }

    @Override // com.jieli.jl_bt_ota.interfaces.rcsp.ICmdSnGenerator
    public int getRcspCmdSeq(BluetoothDevice bluetoothDevice) {
        return autoIncSN(bluetoothDevice);
    }

    public void removeCmdSequence(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || this.b.isEmpty()) {
            return;
        }
        this.b.remove(bluetoothDevice.getAddress());
    }
}
