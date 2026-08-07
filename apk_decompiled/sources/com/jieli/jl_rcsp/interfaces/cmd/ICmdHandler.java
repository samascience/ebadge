package com.jieli.jl_rcsp.interfaces.cmd;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;

/* JADX INFO: loaded from: classes3.dex */
public interface ICmdHandler {
    CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket);
}
