package com.jieli.jl_rcsp.tool;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.tencent.connect.common.Constants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CommandHelper {
    public static volatile CommandHelper b;
    public final HashMap<String, CommandBase> a = new HashMap<>();

    @SuppressLint({"UseSparseArrays"})
    public CommandHelper() {
    }

    public static String getCacheCommandKey(BluetoothDevice bluetoothDevice, int i, int i2) {
        String str;
        if (bluetoothDevice != null) {
            str = bluetoothDevice.getAddress() + "-";
        } else {
            str = Constants.STR_EMPTY;
        }
        String str2 = str + String.valueOf(i);
        if (i2 < 0) {
            return str2;
        }
        return str2 + "-" + i2;
    }

    public static CommandHelper getInstance() {
        if (b == null) {
            synchronized (CommandHelper.class) {
                try {
                    if (b == null) {
                        b = new CommandHelper();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public CommandBase getCommand(BluetoothDevice bluetoothDevice, int i, int i2) {
        return this.a.get(getCacheCommandKey(bluetoothDevice, i, i2));
    }

    public void putCommandBase(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        if (commandBase != null) {
            if (commandBase.getType() == 2 || commandBase.getType() == 3) {
                this.a.put(getCacheCommandKey(bluetoothDevice, commandBase.getId(), commandBase.getOpCodeSn()), commandBase);
            }
        }
    }

    public void release() {
        this.a.clear();
        b = null;
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket != null) {
            removeCommandBase(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        }
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, int i, int i2) {
        this.a.remove(getCacheCommandKey(bluetoothDevice, i, i2));
    }
}
