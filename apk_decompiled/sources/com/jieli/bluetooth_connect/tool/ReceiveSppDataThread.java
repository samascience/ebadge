package com.jieli.bluetooth_connect.tool;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ReceiveSppDataThread extends Thread {
    public static final int EXIT_REASON_IO_EXCEPTION = 2;
    public static final int EXIT_REASON_PARAM_ERROR = 1;
    public static final int EXIT_REASON_SUCCESS = 0;
    private static final String TAG = "ReceiveSppDataThread";
    private volatile boolean isRunning;
    private final int mBlockSize;
    private final BluetoothSocket mBluetoothSocket;
    private final BluetoothDevice mConnectedSppDev;
    private final OnRecvSppDataListener mOnRecvSppDataListener;

    public interface OnRecvSppDataListener {
        void onRecvSppData(long j, BluetoothDevice bluetoothDevice, byte[] bArr);

        void onThreadStart(long j);

        void onThreadStop(long j, int i, BluetoothDevice bluetoothDevice);
    }

    public ReceiveSppDataThread(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, OnRecvSppDataListener onRecvSppDataListener) {
        this(bluetoothDevice, bluetoothSocket, 4096, onRecvSppDataListener);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        InputStream inputStream;
        super.run();
        String str = TAG;
        JL_Log.i(str, str, "start.");
        int i = 1;
        this.isRunning = true;
        OnRecvSppDataListener onRecvSppDataListener = this.mOnRecvSppDataListener;
        if (onRecvSppDataListener != null) {
            onRecvSppDataListener.onThreadStart(getId());
        }
        if (this.mConnectedSppDev != null) {
            byte[] bArr = new byte[this.mBlockSize];
            BluetoothSocket bluetoothSocket = this.mBluetoothSocket;
            if (bluetoothSocket != null) {
                try {
                    inputStream = bluetoothSocket.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                    inputStream = null;
                }
            } else {
                inputStream = null;
            }
            String str2 = TAG;
            JL_Log.i(str2, str2, "isRunning : " + this.isRunning + ", mBluetoothSocket : " + this.mBluetoothSocket + ", inputStream : " + inputStream);
            while (true) {
                if (!this.isRunning || inputStream == null) {
                    i = 0;
                } else {
                    try {
                        int i2 = inputStream.read(bArr);
                        if (i2 < 0) {
                            i = 2;
                        } else if (i2 == 0) {
                            Thread.sleep(30L);
                        } else {
                            byte[] bArr2 = new byte[i2];
                            System.arraycopy(bArr, 0, bArr2, 0, i2);
                            OnRecvSppDataListener onRecvSppDataListener2 = this.mOnRecvSppDataListener;
                            if (onRecvSppDataListener2 != null) {
                                onRecvSppDataListener2.onRecvSppData(getId(), this.mConnectedSppDev, bArr2);
                            }
                        }
                    } catch (Exception e2) {
                        String str3 = TAG;
                        JL_Log.e(str3, str3, "have an exception : " + e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            }
        }
        this.isRunning = false;
        OnRecvSppDataListener onRecvSppDataListener3 = this.mOnRecvSppDataListener;
        if (onRecvSppDataListener3 != null) {
            onRecvSppDataListener3.onThreadStop(getId(), i, this.mConnectedSppDev);
        }
        String str4 = TAG;
        JL_Log.i(str4, str4, "exit");
    }

    public void stopThread() {
        this.isRunning = false;
    }

    public ReceiveSppDataThread(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, int i, OnRecvSppDataListener onRecvSppDataListener) {
        super("ReceiveSppDataThread : " + bluetoothDevice);
        this.mConnectedSppDev = bluetoothDevice;
        this.mBluetoothSocket = bluetoothSocket;
        this.mBlockSize = i;
        this.mOnRecvSppDataListener = onRecvSppDataListener;
    }
}
