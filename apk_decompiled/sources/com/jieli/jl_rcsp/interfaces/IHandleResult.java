package com.jieli.jl_rcsp.interfaces;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IHandleResult<T, C extends CommandBase> {
    T handleResult(BluetoothDevice bluetoothDevice, C c);

    int hasResult(BluetoothDevice bluetoothDevice, C c);
}
