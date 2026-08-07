package com.jieli.jl_rcsp.interfaces.network;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkInfo;
import com.jieli.jl_rcsp.model.device.settings.v0.NetworkOTAState;

/* JADX INFO: loaded from: classes3.dex */
public interface OnNetworkListener {
    void onNetworkInfo(BluetoothDevice bluetoothDevice, NetworkInfo networkInfo);

    void onNetworkOTAState(BluetoothDevice bluetoothDevice, NetworkOTAState networkOTAState);
}
