package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.bluetooth.CmdSnGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class SnGenerator implements CmdSnGenerator {
    public final Map<String, Integer> b = new HashMap();
    public int a = (new Random().nextInt(255) + 1) % 256;

    public synchronized int autoIncSN(BluetoothDevice bluetoothDevice) {
        int cmdSequence;
        try {
            cmdSequence = getCmdSequence(bluetoothDevice);
            int i = 0;
            if (bluetoothDevice != null) {
                int i2 = cmdSequence + 1;
                if (i2 < 256) {
                    i = i2;
                }
                this.b.put(bluetoothDevice.getAddress(), Integer.valueOf(i));
            } else {
                int i3 = cmdSequence + 1;
                if (i3 < 256) {
                    i = i3;
                }
                this.a = i;
            }
        } catch (Throwable th) {
            throw th;
        }
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

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.CmdSnGenerator
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
