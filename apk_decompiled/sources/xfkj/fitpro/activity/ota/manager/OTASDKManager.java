package xfkj.fitpro.activity.ota.manager;

import android.app.Application;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import com.jieli.JliCore;
import com.jieli.jl_rcsp.util.JL_Log;
import defpackage.aa0;
import defpackage.ba0;
import defpackage.ct1;
import defpackage.dy;
import defpackage.e20;
import defpackage.ng;
import defpackage.o10;
import defpackage.r02;
import defpackage.tg3;
import defpackage.ug3;
import defpackage.ux1;
import defpackage.w32;
import defpackage.wr2;
import defpackage.zi2;
import java.util.UUID;
import xfkj.fitpro.activity.ota.OTAProxyUtils;
import xfkj.fitpro.activity.ota.jieli.WatchManagerDemo;
import xfkj.fitpro.activity.ota.model.OTAInfo;

/* JADX INFO: loaded from: classes4.dex */
public class OTASDKManager {
    private static final String TAG = "OTASDKManager";
    private static OTASDKManager instance;
    private BluetoothGattCallback bluetoothGattCallback;
    private Application context;
    private boolean isInitialized = false;
    private boolean isJliInitialized = false;
    private boolean isLpInitialized = false;
    private boolean isLyInitialized = false;
    private BluetoothGattCharacteristic jieLiWriteCharacteristic;
    private OTAInfo otaInfo;
    private static final UUID JIE_LI_SERVICE_UUID = UUID.fromString("0000ae00-0000-1000-8000-00805f9b34fb");
    private static final UUID JIE_LI_WRITE_UUID = UUID.fromString("0000ae01-0000-1000-8000-00805f9b34fb");
    private static final UUID JIE_LI_NOTIFY_UUID = UUID.fromString("0000ae02-0000-1000-8000-00805f9b34fb");

    private OTASDKManager() {
    }

    private String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02X", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    private void enableJieLiNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        try {
            zi2.e().E(bluetoothGattCharacteristic, new byte[]{1}, "开启消息通知");
            Log.i(TAG, "杰理通知已开启");
        } catch (Exception e) {
            Log.e(TAG, "开启杰理通知失败: " + e.getMessage(), e);
        }
    }

    private void findJieLiCharacteristics(BluetoothGatt bluetoothGatt) {
        try {
            for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                if (isJieLiOTAService(bluetoothGattService)) {
                    Log.i(TAG, "发现杰理OTA服务，开始查找特征");
                    processJieLiCharacteristics(bluetoothGattService, bluetoothGatt);
                    return;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "查找杰理特征失败: " + e.getMessage(), e);
        }
    }

    private String getBluetoothListenerStatus() {
        try {
            WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
            return (watchManagerDemo == null || watchManagerDemo.getBleManager() == null || watchManagerDemo.getBleManager().getBluetoothGattCallback() == null) ? "使用自定义回调" : "使用WatchManagerDemo回调";
        } catch (Exception e) {
            return "状态未知: " + e.getMessage();
        }
    }

    public static synchronized OTASDKManager getInstance() {
        try {
            if (instance == null) {
                instance = new OTASDKManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBluetoothConnected(BluetoothGatt bluetoothGatt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBluetoothDisconnected(BluetoothGatt bluetoothGatt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value == null || value.length <= 0) {
            return;
        }
        Log.d(TAG, "收到特征通知数据: " + bytesToHex(value));
        if (isJieLiNotifyCharacteristic(bluetoothGattCharacteristic)) {
            handleJieLiNotificationData(bluetoothGatt, bluetoothGattCharacteristic, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    private void handleJieLiNotificationData(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        try {
            WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
            if (watchManagerDemo == null || watchManagerDemo.getBleManager() == null) {
                Log.w(TAG, "WatchManagerDemo不可用，无法回调杰理通知数据");
            } else {
                watchManagerDemo.getBleManager().getBluetoothGattCallback().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                Log.d(TAG, "杰理通知数据已回调给WatchManagerDemo: " + bytesToHex(bArr));
            }
        } catch (Exception e) {
            Log.e(TAG, "回调杰理通知数据失败: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMtuChanged(BluetoothGatt bluetoothGatt, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServicesDiscovered(BluetoothGatt bluetoothGatt) {
        findJieLiCharacteristics(bluetoothGatt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleWatchSDKEvent(ng ngVar) {
        if (ngVar != null) {
            Log.d(TAG, "WatchSDK事件: " + ngVar.getClass().getSimpleName());
            if (ngVar instanceof o10) {
                String macAddress = ((o10) ngVar).getMacAddress();
                this.otaInfo.setDeviceId(macAddress);
                this.otaInfo.setBluetoothName(ug3.d());
                Log.d(TAG, "设备连接事件: " + macAddress);
                return;
            }
            if (ngVar instanceof dy) {
                String macAddress2 = ((dy) ngVar).getMacAddress();
                this.otaInfo.setClassicBluetoothMac(macAddress2);
                Log.d(TAG, "经典蓝牙绑定事件: " + macAddress2);
                return;
            }
            if (ngVar instanceof wr2) {
                String strA = ((wr2) ngVar).a();
                this.otaInfo.setSoftVersion(strA);
                Log.d(TAG, "软件版本事件: " + strA);
                return;
            }
            if (ngVar instanceof aa0) {
                zi2.g();
                return;
            }
            if (!(ngVar instanceof ba0)) {
                if (ngVar instanceof w32) {
                    this.otaInfo.setPlarmType(((w32) ngVar).a().getValue());
                    return;
                }
                Log.d(TAG, "其他WatchSDK事件: " + ngVar.getClass().getSimpleName());
                return;
            }
            ba0 ba0Var = (ba0) ngVar;
            String macAddress3 = ba0Var.getMacAddress();
            this.otaInfo.setDeviceId(macAddress3);
            this.otaInfo.setLed(ba0Var.c());
            this.otaInfo.setGsensor(ba0Var.a());
            this.otaInfo.setHeart(ba0Var.b());
            Log.d(TAG, "设备硬件信息事件: " + macAddress3 + ", LED: " + ba0Var.c() + ", Gsensor: " + ba0Var.a() + ", Heart: " + ba0Var.b());
        }
    }

    private void initBluetoothGattCallback() {
        try {
            this.bluetoothGattCallback = new BluetoothGattCallback() { // from class: xfkj.fitpro.activity.ota.manager.OTASDKManager.1
                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                    super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                    Log.d(OTASDKManager.TAG, "特征值变化: UUID=" + bluetoothGattCharacteristic.getUuid());
                    OTASDKManager.this.handleCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                    super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
                    Log.d(OTASDKManager.TAG, "特征读取完成: UUID=" + bluetoothGattCharacteristic.getUuid() + ", 状态=" + i);
                    if (i == 0) {
                        OTASDKManager.this.handleCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic);
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                    super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                    Log.d(OTASDKManager.TAG, "特征写入完成: UUID=" + bluetoothGattCharacteristic.getUuid() + ", 状态=" + i);
                    if (i == 0) {
                        OTASDKManager.this.handleCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic);
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                    super.onConnectionStateChange(bluetoothGatt, i, i2);
                    Log.i(OTASDKManager.TAG, "蓝牙连接状态变化: 状态=" + i + ", 新状态=" + i2);
                    if (i2 == 2) {
                        Log.i(OTASDKManager.TAG, "蓝牙设备已连接: " + bluetoothGatt.getDevice().getAddress());
                        OTASDKManager.this.handleBluetoothConnected(bluetoothGatt);
                        return;
                    }
                    if (i2 == 0) {
                        Log.i(OTASDKManager.TAG, "蓝牙设备已断开: " + bluetoothGatt.getDevice().getAddress());
                        OTASDKManager.this.handleBluetoothDisconnected(bluetoothGatt);
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                    super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
                    Log.d(OTASDKManager.TAG, "描述符读取完成: UUID=" + bluetoothGattDescriptor.getUuid() + ", 状态=" + i);
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                    super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                    Log.d(OTASDKManager.TAG, "描述符写入完成: UUID=" + bluetoothGattDescriptor.getUuid() + ", 状态=" + i);
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
                    super.onMtuChanged(bluetoothGatt, i, i2);
                    Log.i(OTASDKManager.TAG, "MTU变化: MTU=" + i + ", 状态=" + i2);
                    if (i2 == 0) {
                        OTASDKManager.this.handleMtuChanged(bluetoothGatt, i);
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                    super.onServicesDiscovered(bluetoothGatt, i);
                    Log.i(OTASDKManager.TAG, "蓝牙服务发现完成: 状态=" + i);
                    if (i == 0) {
                        OTASDKManager.this.handleServicesDiscovered(bluetoothGatt);
                    }
                }
            };
            Log.i(TAG, "蓝牙GATT回调初始化成功");
        } catch (Exception e) {
            Log.e(TAG, "蓝牙GATT回调初始化失败: " + e.getMessage(), e);
            throw new RuntimeException("蓝牙GATT回调初始化失败", e);
        }
    }

    private void initJliLogger() {
        try {
            JL_Log.setTagPrefix("health");
            JL_Log.configureLog(this.context, false, false);
            com.jieli.bluetooth_connect.util.JL_Log.setLog(false);
            Log.i(TAG, "JLI日志系统初始化成功");
        } catch (Exception e) {
            Log.e(TAG, "JLI日志系统初始化失败: " + e.getMessage(), e);
            throw new RuntimeException("JLI日志系统初始化失败", e);
        }
    }

    private void initJliOTA() {
        try {
            initJliLogger();
            JliCore.getInstance().init(this.context);
            initWatchManagerDemo();
            this.isJliInitialized = true;
            Log.i(TAG, "JLI OTA SDK初始化成功");
        } catch (Exception e) {
            Log.e(TAG, "JLI OTA SDK初始化失败: " + e.getMessage(), e);
            throw new RuntimeException("JLI OTA SDK初始化失败", e);
        }
    }

    private void initLpOTA() {
        try {
            r02.c(this.context);
            this.isLpInitialized = true;
            Log.i(TAG, "LP OTA SDK初始化成功");
        } catch (Exception e) {
            Log.e(TAG, "LP OTA SDK初始化失败: " + e.getMessage(), e);
            throw new RuntimeException("LP OTA SDK初始化失败", e);
        }
    }

    private void initLyOTA() {
        try {
            ux1.a.a(this.context);
            this.isLyInitialized = true;
            Log.i(TAG, "LY OTA SDK初始化成功");
        } catch (Exception e) {
            Log.e(TAG, "LY OTA SDK初始化失败: " + e.getMessage(), e);
            throw new RuntimeException("LY OTA SDK初始化失败", e);
        }
    }

    private void initWatchManagerDemo() {
        try {
            if (WatchManagerDemo.getInstance() != null) {
                Log.i(TAG, "WatchManagerDemo初始化成功");
            } else {
                Log.w(TAG, "WatchManagerDemo实例为空");
            }
        } catch (Exception e) {
            Log.e(TAG, "WatchManagerDemo初始化失败: " + e.getMessage(), e);
        }
    }

    private boolean isJieLiNotifyCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return bluetoothGattCharacteristic.getUuid().equals(JIE_LI_NOTIFY_UUID);
    }

    private boolean isJieLiOTAService(BluetoothGattService bluetoothGattService) {
        return bluetoothGattService.getUuid().equals(JIE_LI_SERVICE_UUID);
    }

    private static /* synthetic */ void lambda$initJliLogger$0(String str) {
        Log.i(TAG, "JLI output: " + str);
        JL_Log.addLogOutput(str);
    }

    private void processJieLiCharacteristics(BluetoothGattService bluetoothGattService, BluetoothGatt bluetoothGatt) {
        boolean z = false;
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            if (uuid.equals(JIE_LI_NOTIFY_UUID)) {
                if (bluetoothGattCharacteristic.getProperties() == 16) {
                    Log.i(TAG, "发现杰理通知特征，开启通知");
                    enableJieLiNotification(bluetoothGattCharacteristic);
                }
            } else if (uuid.equals(JIE_LI_WRITE_UUID)) {
                Log.i(TAG, "发现杰理写特征，存储到内存");
                this.jieLiWriteCharacteristic = bluetoothGattCharacteristic;
                try {
                    WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
                    if (watchManagerDemo != null && watchManagerDemo.getBleManager() != null) {
                        watchManagerDemo.getBleManager().setWriteCharForJIELI(bluetoothGattCharacteristic);
                        Log.i(TAG, "杰理写特征已设置到WatchManagerDemo");
                    }
                } catch (Exception e) {
                    Log.e(TAG, "设置杰理写特征到WatchManagerDemo失败: " + e.getMessage(), e);
                }
                z = true;
            }
        }
        if (z) {
            Log.i(TAG, "杰理特征发现完成，写特征已存储到内存");
        } else {
            Log.w(TAG, "未找到杰理写特征");
        }
    }

    private void setupWatchSDKBluetoothListener() {
        try {
            if (!isOtaMode() && !OTAProxyUtils.INSTANCE.isFindGuiXinPath(this.otaInfo)) {
                Log.e(TAG, "不在OTA升级模式下，不设置WatchSDK蓝牙监听");
                return;
            }
            WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
            if (watchManagerDemo == null || watchManagerDemo.getBleManager() == null) {
                tg3.m().l().a(this.bluetoothGattCallback);
                return;
            }
            BluetoothGattCallback bluetoothGattCallback = watchManagerDemo.getBleManager().getBluetoothGattCallback();
            if (bluetoothGattCallback != null) {
                tg3.m().l().a(bluetoothGattCallback);
                Log.i(TAG, "WatchSDK蓝牙监听设置成功（使用WatchManagerDemo回调）");
            } else {
                tg3.m().l().a(this.bluetoothGattCallback);
                Log.i(TAG, "WatchSDK蓝牙监听设置成功（使用自定义回调）");
            }
        } catch (Exception e) {
            Log.e(TAG, "WatchSDK蓝牙监听设置失败: " + e.getMessage(), e);
            throw new RuntimeException("WatchSDK蓝牙监听设置失败", e);
        }
    }

    private void setupWatchSDKEventListener() {
        try {
            tg3.m().h(new ct1(this));
            Log.i(TAG, "WatchSDK事件监听器设置成功");
        } catch (Exception e) {
            Log.e(TAG, "WatchSDK事件监听器设置失败: " + e.getMessage(), e);
        }
    }

    public String getInitializationStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("OTA SDK初始化状态:\n");
        sb.append("- 总体状态: ");
        sb.append(this.isInitialized ? "已初始化" : "未初始化");
        sb.append("\n");
        sb.append("- JLI平台: ");
        sb.append(this.isJliInitialized ? "已初始化" : "未初始化");
        sb.append("\n");
        sb.append("- LP平台: ");
        sb.append(this.isLpInitialized ? "已初始化" : "未初始化");
        sb.append("\n");
        sb.append("- LY平台: ");
        sb.append(this.isLyInitialized ? "已初始化" : "未初始化");
        sb.append("\n");
        sb.append("- 蓝牙监听: ");
        sb.append(getBluetoothListenerStatus());
        sb.append("\n");
        sb.append("- 杰理特征: ");
        sb.append(isJieLiCharacteristicsFound() ? "已发现" : "未发现");
        return sb.toString();
    }

    public BluetoothGattCharacteristic getJieLiWriteCharacteristic() {
        return this.jieLiWriteCharacteristic;
    }

    public OTAInfo getOTAInfo() {
        return this.otaInfo;
    }

    public void initialize(Application application) {
        if (this.isInitialized) {
            Log.w(TAG, "OTA SDK已经初始化过了");
            return;
        }
        this.context = application;
        this.otaInfo = new OTAInfo();
        try {
            initBluetoothGattCallback();
            initJliOTA();
            initLpOTA();
            initLyOTA();
            setupWatchSDKBluetoothListener();
            setupWatchSDKEventListener();
            this.isInitialized = true;
            Log.i(TAG, "所有OTA SDK初始化完成");
        } catch (Exception e) {
            Log.e(TAG, "OTA SDK初始化失败: " + e.getMessage(), e);
            throw new RuntimeException("OTA SDK初始化失败", e);
        }
    }

    public boolean isInitialized() {
        return this.isInitialized;
    }

    public boolean isJieLiCharacteristicsFound() {
        return this.jieLiWriteCharacteristic != null;
    }

    public boolean isJliInitialized() {
        return this.isJliInitialized;
    }

    public boolean isLpInitialized() {
        return this.isLpInitialized;
    }

    public boolean isLyInitialized() {
        return this.isLyInitialized;
    }

    public boolean isOtaMode() {
        return e20.f == 1;
    }

    public void reset() {
        try {
            tg3.m().s(new ct1(this));
            Log.d(TAG, "WatchSDK事件监听器已移除");
        } catch (Exception e) {
            Log.e(TAG, "移除WatchSDK事件监听器失败: " + e.getMessage(), e);
        }
        this.isInitialized = false;
        this.isJliInitialized = false;
        this.isLpInitialized = false;
        this.isLyInitialized = false;
        this.bluetoothGattCallback = null;
        this.jieLiWriteCharacteristic = null;
        this.context = null;
        this.otaInfo = new OTAInfo();
        Log.i(TAG, "OTA SDK状态已重置");
    }

    public void resetOtaState() {
        e20.f = 0;
    }

    public void sendDataToJieLiDevice(byte[] bArr) {
        try {
            if (this.jieLiWriteCharacteristic != null) {
                zi2.e().H(this.jieLiWriteCharacteristic, bArr, "发送数据给杰理设备");
                Log.d(TAG, "数据已发送到杰理设备: " + bytesToHex(bArr));
            } else {
                Log.w(TAG, "杰理写特征未找到，无法发送数据");
            }
        } catch (Exception e) {
            Log.e(TAG, "发送数据到杰理设备失败: " + e.getMessage(), e);
        }
    }

    public void setOtaState() {
        e20.f = 1;
    }
}
