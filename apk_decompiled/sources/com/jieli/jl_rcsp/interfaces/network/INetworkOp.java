package com.jieli.jl_rcsp.interfaces.network;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.network.OTAParam;

/* JADX INFO: loaded from: classes3.dex */
public interface INetworkOp {
    void addOnNetworkListener(OnNetworkListener onNetworkListener);

    void cancelNetworkOTA(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    boolean isNetworkOTA();

    void queryNetworkInfo(BluetoothDevice bluetoothDevice, OnOperationCallback<Boolean> onOperationCallback);

    void removeOnNetworkListener(OnNetworkListener onNetworkListener);

    void startNetworkOTA(BluetoothDevice bluetoothDevice, OTAParam oTAParam, OnNetworkOTACallback onNetworkOTACallback);
}
