package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
abstract /* synthetic */ class a {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[Constants$LogLevel.values().length];
        a = iArr;
        try {
            iArr[Constants$LogLevel.LOG_LEVEL_VERBOSE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[Constants$LogLevel.LOG_LEVEL_DEBUG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[Constants$LogLevel.LOG_LEVEL_INFO.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[Constants$LogLevel.LOG_LEVEL_WARNING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[Constants$LogLevel.LOG_LEVEL_ERROR.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[Constants$LogLevel.LOG_LEVEL_NONE.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
