package com.baidu.location;

/* JADX INFO: loaded from: classes.dex */
abstract /* synthetic */ class d {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[LocationClientOption.LocationMode.values().length];
        a = iArr;
        try {
            iArr[LocationClientOption.LocationMode.Hight_Accuracy.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[LocationClientOption.LocationMode.Battery_Saving.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[LocationClientOption.LocationMode.Device_Sensors.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[LocationClientOption.LocationMode.Fuzzy_Locating.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
