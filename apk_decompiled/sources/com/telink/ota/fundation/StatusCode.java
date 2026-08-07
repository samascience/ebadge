package com.telink.ota.fundation;

/* JADX INFO: loaded from: classes.dex */
public enum StatusCode {
    SUCCESS(0, "OTA success"),
    STARTED(1, "OTA started"),
    STOPPED(2, "OTA stopped"),
    BUSY(4, "OTA busy"),
    REBOOTING(5, "OTA rebooting"),
    FAIL_PARAMS_ERR(16, "OTA fail: params err"),
    FAIL_CONNECTION_INTERRUPT(17, "OTA fail: connection interrupt"),
    FAIL_BATTERY_CHECK_ERR(18, "OTA fail: battery check err"),
    FAIL_VERSION_COMPARE_ERR(19, "OTA fail: version compare err"),
    FAIL_PACKET_SENT_ERR(20, "OTA fail: packet sent err"),
    FAIL_PACKET_SENT_TIMEOUT(21, "OTA fail: packet sent timeout"),
    FAIL_FLOW_TIMEOUT(22, "OTA fail: flow timeout"),
    FAIL_RECONNECT_ERR(23, "OTA fail: reconnect err"),
    FAIL_UNCONNECTED(24, "OTA fail: device not connected"),
    FAIL_SERVICE_NOT_FOUND(25, "OTA fail: service not found"),
    FAIL_CHARACTERISTIC_NOT_FOUND(26, "OTA fail: characteristic not found");

    private final int code;
    private final String desc;

    StatusCode(int i, String str) {
        this.code = i;
        this.desc = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isComplete() {
        int i;
        return isFailed() || (i = this.code) == SUCCESS.code || i == STOPPED.code;
    }

    public boolean isFailed() {
        return this.code >= 16;
    }
}
