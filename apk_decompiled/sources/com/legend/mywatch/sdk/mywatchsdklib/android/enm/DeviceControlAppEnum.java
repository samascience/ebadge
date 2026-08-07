package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum DeviceControlAppEnum {
    TAKE_PHOTO(0),
    EXIT_REMOTE_CAMERA(1),
    ENTER_REMOTE_CAMERA(2),
    EXIT_HEART_AUTO(3),
    EXIT_BLOOD_PRESSURE(4),
    EXIT_BLOOD_OXYGEN(5),
    FIND_PHONE(6),
    STOP_FIND_PHONE(7),
    HANG_UP(8),
    ANSWER(9),
    PREVIOUS(10),
    NEXT(11),
    PLAY_PAUSE(12),
    SYNCHRONIZE_TIME(13),
    GET_IMEI(14);

    int type;

    DeviceControlAppEnum(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
