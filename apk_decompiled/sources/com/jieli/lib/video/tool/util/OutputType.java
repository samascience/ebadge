package com.jieli.lib.video.tool.util;

/* JADX INFO: loaded from: classes3.dex */
public enum OutputType {
    ANI(0, "ani"),
    AVI(1, "avi");

    public final String suffix;
    public final int value;

    OutputType(int i, String str) {
        this.value = i;
        this.suffix = str;
    }
}
