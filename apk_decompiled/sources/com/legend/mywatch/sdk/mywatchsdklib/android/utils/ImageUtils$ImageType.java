package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

/* JADX INFO: loaded from: classes3.dex */
public enum ImageUtils$ImageType {
    TYPE_JPG("jpg"),
    TYPE_PNG("png"),
    TYPE_GIF("gif"),
    TYPE_TIFF("tiff"),
    TYPE_BMP("bmp"),
    TYPE_WEBP("webp"),
    TYPE_ICO("ico"),
    TYPE_UNKNOWN("unknown");

    String value;

    ImageUtils$ImageType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
