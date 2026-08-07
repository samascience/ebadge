package com.jieli.bluetooth_connect.bean;

import com.jieli.bluetooth_connect.constant.BluetoothConstant;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class BluetoothOption {
    private boolean reconnect;
    private String scanFilterData;

    @Deprecated
    private int priority = 0;

    @Deprecated
    private int timeoutMs = 2000;
    private boolean enterLowPowerMode = false;
    private boolean isUseMultiDevice = false;

    @Deprecated
    private boolean isUseDeviceAuth = true;
    private boolean isNotAssociatedEDR = false;
    private boolean isSkipNoneNameDevice = true;
    private boolean isSupportCTKD = true;
    private String otaScanFilterData = BluetoothConstant.OTA_FILTER_FLAG;
    private int bleScanStrategy = 1;
    private int bleScanMode = 1;
    private int mtu = 20;
    private final Map<String, UUID> bleUUIDMap = new HashMap();
    private boolean isUseBleBondWay = false;
    private boolean isAutoConnectBle = false;
    private boolean isNeedChangeBleMtu = false;
    private boolean isOnlyConnect = false;
    private UUID sppUUID = BluetoothConstant.UUID_SPP;
    private boolean isSupportA2DP = true;

    public BluetoothOption() {
        setBleUUID(BluetoothConstant.UUID_SERVICE, BluetoothConstant.UUID_WRITE, BluetoothConstant.UUID_NOTIFICATION);
    }

    public static BluetoothOption createDefaultOption() {
        return new BluetoothOption().setReconnect(true).setTimeoutMs(2000).setMtu(20).setScanFilterData("JLAISDK");
    }

    public UUID getBleNotificationUUID() {
        UUID uuid = this.bleUUIDMap.get(BluetoothConstant.KEY_BLE_NOTIFICATION_CHARACTERISTIC_UUID);
        return uuid == null ? BluetoothConstant.UUID_NOTIFICATION : uuid;
    }

    public int getBleScanMode() {
        return this.bleScanMode;
    }

    public int getBleScanStrategy() {
        return this.bleScanStrategy;
    }

    public UUID getBleServiceUUID() {
        UUID uuid = this.bleUUIDMap.get(BluetoothConstant.KEY_BLE_SERVICE_UUID);
        return uuid == null ? BluetoothConstant.UUID_SERVICE : uuid;
    }

    public UUID getBleWriteUUID() {
        UUID uuid = this.bleUUIDMap.get(BluetoothConstant.KEY_BLE_WRITE_CHARACTERISTIC_UUID);
        return uuid == null ? BluetoothConstant.UUID_WRITE : uuid;
    }

    public int getMtu() {
        return this.mtu;
    }

    public String getOtaScanFilterData() {
        return this.otaScanFilterData;
    }

    @Deprecated
    public int getPriority() {
        return this.priority;
    }

    public String getScanFilterData() {
        return this.scanFilterData;
    }

    public UUID getSppUUID() {
        return this.sppUUID;
    }

    @Deprecated
    public int getTimeoutMs() {
        return this.timeoutMs;
    }

    public boolean isAutoConnectBle() {
        return this.isAutoConnectBle;
    }

    public boolean isEnterLowPowerMode() {
        return this.enterLowPowerMode;
    }

    public boolean isNeedChangeBleMtu() {
        return this.isNeedChangeBleMtu;
    }

    public boolean isNotAssociatedEDR() {
        return this.isNotAssociatedEDR;
    }

    public boolean isOnlyConnect() {
        return this.isOnlyConnect;
    }

    public boolean isReconnect() {
        return this.reconnect;
    }

    public boolean isSkipNoneNameDevice() {
        return this.isSkipNoneNameDevice;
    }

    public boolean isSupportA2DP() {
        return this.isSupportA2DP;
    }

    public boolean isSupportCTKD() {
        return this.isSupportCTKD;
    }

    public boolean isUseBleBondWay() {
        return this.isUseBleBondWay;
    }

    @Deprecated
    public boolean isUseDeviceAuth() {
        return this.isUseDeviceAuth;
    }

    public boolean isUseMultiDevice() {
        return this.isUseMultiDevice;
    }

    public BluetoothOption setAutoConnectBle(boolean z) {
        this.isAutoConnectBle = z;
        return this;
    }

    public BluetoothOption setBleScanMode(int i) {
        this.bleScanMode = i;
        return this;
    }

    public BluetoothOption setBleScanStrategy(int i) {
        this.bleScanStrategy = i;
        return this;
    }

    public BluetoothOption setBleUUID(UUID uuid, UUID uuid2, UUID uuid3) {
        this.bleUUIDMap.put(BluetoothConstant.KEY_BLE_SERVICE_UUID, uuid);
        this.bleUUIDMap.put(BluetoothConstant.KEY_BLE_WRITE_CHARACTERISTIC_UUID, uuid2);
        this.bleUUIDMap.put(BluetoothConstant.KEY_BLE_NOTIFICATION_CHARACTERISTIC_UUID, uuid3);
        return this;
    }

    public BluetoothOption setEnterLowPowerMode(boolean z) {
        this.enterLowPowerMode = z;
        return this;
    }

    public BluetoothOption setMtu(int i) {
        this.mtu = BluetoothUtil.formatBleMtu(i);
        return this;
    }

    public BluetoothOption setNeedChangeBleMtu(boolean z) {
        this.isNeedChangeBleMtu = z;
        return this;
    }

    public BluetoothOption setNotAssociatedEDR(boolean z) {
        this.isNotAssociatedEDR = z;
        return this;
    }

    public BluetoothOption setOnlyConnect(boolean z) {
        this.isOnlyConnect = z;
        return this;
    }

    public BluetoothOption setOtaScanFilterData(String str) {
        this.otaScanFilterData = str;
        return this;
    }

    @Deprecated
    public BluetoothOption setPriority(int i) {
        this.priority = i;
        return this;
    }

    public BluetoothOption setReconnect(boolean z) {
        this.reconnect = z;
        return this;
    }

    public BluetoothOption setScanFilterData(String str) {
        this.scanFilterData = str;
        return this;
    }

    public BluetoothOption setSkipNoneNameDevice(boolean z) {
        this.isSkipNoneNameDevice = z;
        return this;
    }

    public BluetoothOption setSppUUID(UUID uuid) {
        this.sppUUID = uuid;
        return this;
    }

    public BluetoothOption setSupportA2DP(boolean z) {
        this.isSupportA2DP = z;
        return this;
    }

    public BluetoothOption setSupportCTKD(boolean z) {
        this.isSupportCTKD = z;
        return this;
    }

    @Deprecated
    public BluetoothOption setTimeoutMs(int i) {
        this.timeoutMs = i;
        return this;
    }

    public BluetoothOption setUseBleBondWay(boolean z) {
        this.isUseBleBondWay = z;
        return this;
    }

    @Deprecated
    public BluetoothOption setUseDeviceAuth(boolean z) {
        this.isUseDeviceAuth = z;
        return this;
    }

    public BluetoothOption setUseMultiDevice(boolean z) {
        this.isUseMultiDevice = z;
        return this;
    }

    public String toString() {
        return "BluetoothOption{priority=" + this.priority + ", reconnect=" + this.reconnect + ", timeoutMs=" + this.timeoutMs + ", scanFilterData='" + this.scanFilterData + "', mtu=" + this.mtu + ", enterLowPowerMode=" + this.enterLowPowerMode + ", bleScanStrategy=" + this.bleScanStrategy + ", bleScanMode=" + this.bleScanMode + ", bleUUIDMap=" + this.bleUUIDMap + ", sppUUID=" + this.sppUUID + ", isUseBleBondWay=" + this.isUseBleBondWay + ", isAutoConnectBle=" + this.isAutoConnectBle + ", isUseDeviceAuth=" + this.isUseDeviceAuth + ", isNotAssociatedEDR=" + this.isNotAssociatedEDR + ", isOnlyConnect=" + this.isOnlyConnect + ", isSkipNoneNameDevice=" + this.isSkipNoneNameDevice + ", isSupportA2DP=" + this.isSupportA2DP + ", isSupportCTKD=" + this.isSupportCTKD + '}';
    }
}
