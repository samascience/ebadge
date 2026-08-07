package com.jieli.bmp_convert;

/* JADX INFO: loaded from: classes3.dex */
public class ConvertParam {
    public static final int FORMAT_ARGB_8565 = 1;
    public static final int FORMAT_ARGB_8888 = 2;
    public static final int FORMAT_AUTO = 0;
    public int a = 0;

    public int getFormat() {
        return this.a;
    }

    public ConvertParam setFormat(int i) {
        this.a = i;
        return this;
    }

    public String toString() {
        return "ConvertParam{format=" + this.a + '}';
    }
}
