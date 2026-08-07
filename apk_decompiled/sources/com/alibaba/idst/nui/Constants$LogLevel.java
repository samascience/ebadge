package com.alibaba.idst.nui;

/* JADX INFO: loaded from: classes.dex */
public enum Constants$LogLevel {
    LOG_LEVEL_VERBOSE,
    LOG_LEVEL_DEBUG,
    LOG_LEVEL_INFO,
    LOG_LEVEL_WARNING,
    LOG_LEVEL_ERROR,
    LOG_LEVEL_NONE;

    public static Constants$LogLevel fromInt(int i) {
        if (i == 0) {
            return LOG_LEVEL_VERBOSE;
        }
        if (i == 1) {
            return LOG_LEVEL_DEBUG;
        }
        if (i == 2) {
            return LOG_LEVEL_INFO;
        }
        if (i == 3) {
            return LOG_LEVEL_WARNING;
        }
        if (i != 4) {
            return i != 5 ? LOG_LEVEL_NONE : LOG_LEVEL_NONE;
        }
        return LOG_LEVEL_ERROR;
    }

    public static int toInt(Constants$LogLevel constants$LogLevel) {
        int i = a.a[constants$LogLevel.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            return i != 5 ? 5 : 4;
        }
        return 3;
    }
}
