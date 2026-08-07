package xfkj.fitpro.activity.ota.jieli;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.util.Log;
import com.jieli.jl_rcsp.impl.RcspAuth;
import com.jieli.jl_rcsp.impl.WatchOpImpl;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;

/* JADX INFO: loaded from: classes4.dex */
public class WatchManagerDemo extends WatchOpImpl {
    private static WatchManagerDemo instance;
    private final String TAG;
    public boolean isAuthPass;
    public boolean isUseDevice;
    public BleManager mBleManager;
    private final RcspAuth mRcspAuth;

    public WatchManagerDemo() {
        super(1);
        this.TAG = "WatchManagerDemo";
        this.isUseDevice = true;
        BleManager bleManager = new BleManager();
        this.mBleManager = bleManager;
        bleManager.setOnBleEventListener(new OnBleEventListener() { // from class: xfkj.fitpro.activity.ota.jieli.WatchManagerDemo.1
            @Override // xfkj.fitpro.activity.ota.jieli.OnBleEventListener
            public void onConnect(BluetoothDevice bluetoothDevice, int i) {
                Log.i("WatchManagerDemo", String.format("设备[%s]的连接状态: %d%n", bluetoothDevice, Integer.valueOf(i)));
                WatchManagerDemo.this.setAuthPass(false);
                if (i == 2) {
                    WatchManagerDemo watchManagerDemo = WatchManagerDemo.this;
                    if (watchManagerDemo.isUseDevice) {
                        watchManagerDemo.mRcspAuth.stopAuth(bluetoothDevice, false);
                        WatchManagerDemo.this.mRcspAuth.startAuth(bluetoothDevice);
                        return;
                    }
                }
                int iChangeConnectStatus = RcspUtil.changeConnectStatus(i);
                Log.i("WatchManagerDemo", String.format("原连接状态: %d ==> 转换后连接状态: %d%n", Integer.valueOf(i), Integer.valueOf(iChangeConnectStatus)));
                WatchManagerDemo.this.notifyBtDeviceConnection(bluetoothDevice, iChangeConnectStatus);
            }

            @Override // xfkj.fitpro.activity.ota.jieli.OnBleEventListener
            public void onReceiveData(BluetoothDevice bluetoothDevice, byte[] bArr) {
                boolean zIsAuthPass = WatchManagerDemo.this.isAuthPass();
                Log.i("WatchManagerDemo", String.format("是否通过认证: %s,\n接收到设备[%s]的数据[%s]%n", Boolean.valueOf(zIsAuthPass), bluetoothDevice, CHexConver.byte2HexStr(bArr)));
                if (zIsAuthPass) {
                    WatchManagerDemo.this.notifyReceiveDeviceData(bluetoothDevice, bArr);
                } else {
                    WatchManagerDemo.this.mRcspAuth.handleAuthData(bluetoothDevice, bArr);
                }
            }
        });
        this.mRcspAuth = new RcspAuth(new RcspAuth.IRcspAuthOp() { // from class: qg3
            @Override // com.jieli.jl_rcsp.impl.RcspAuth.IRcspAuthOp
            public final boolean sendAuthDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
                return this.a.lambda$new$0(bluetoothDevice, bArr);
            }
        }, new RcspAuth.OnRcspAuthListener() { // from class: xfkj.fitpro.activity.ota.jieli.WatchManagerDemo.2
            @Override // com.jieli.jl_rcsp.impl.RcspAuth.OnRcspAuthListener
            public void onAuthFailed(BluetoothDevice bluetoothDevice, int i, String str) {
                Log.i("WatchManagerDemo", "onAuthFailed:" + str);
                WatchManagerDemo.this.setAuthPass(false);
                WatchManagerDemo.this.mBleManager.disconnect();
            }

            @Override // com.jieli.jl_rcsp.impl.RcspAuth.OnRcspAuthListener
            public void onAuthSuccess(BluetoothDevice bluetoothDevice) {
                Log.i("WatchManagerDemo", "onAuthSuccess:" + bluetoothDevice);
                WatchManagerDemo.this.setAuthPass(true);
                WatchManagerDemo.this.notifyBtDeviceConnection(bluetoothDevice, 1);
            }

            @Override // com.jieli.jl_rcsp.impl.RcspAuth.OnRcspAuthListener
            public void onInitResult(boolean z) {
                Log.i("WatchManagerDemo", "onInitResult:" + z);
            }
        });
    }

    public static synchronized WatchManagerDemo getInstance() {
        try {
            if (instance == null) {
                instance = new WatchManagerDemo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(BluetoothDevice bluetoothDevice, byte[] bArr) {
        return this.mBleManager.sendBleData(bArr);
    }

    public BleManager getBleManager() {
        return this.mBleManager;
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public BluetoothDevice getConnectedDevice() {
        BluetoothGatt bluetoothGatt = this.mBleManager.getBluetoothGatt();
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getDevice();
    }

    public boolean isAuthPass() {
        return !this.isUseDevice || this.isAuthPass;
    }

    @Override // com.jieli.jl_rcsp.impl.WatchOpImpl, com.jieli.jl_rcsp.impl.RcspOpImpl, com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp
    public void release() {
        super.release();
        this.mRcspAuth.destroy();
        this.mBleManager.setOnBleEventListener(null);
    }

    @Override // com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy
    public boolean sendDataToDevice(BluetoothDevice bluetoothDevice, byte[] bArr) {
        boolean zSendBleData = this.mBleManager.sendBleData(bArr);
        Log.i("WatchManagerDemo", "sendDataToDevice:" + zSendBleData);
        return zSendBleData;
    }

    public void setAuthPass(boolean z) {
        this.isAuthPass = z;
    }
}
