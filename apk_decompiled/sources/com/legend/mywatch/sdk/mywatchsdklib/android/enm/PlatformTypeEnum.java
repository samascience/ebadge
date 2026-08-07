package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum PlatformTypeEnum {
    TELINK(1, "泰凌微"),
    RETECK(2, "LR平台"),
    BK(3, "BK平台"),
    OM(4, "OM平台"),
    LY(5, "LY平台"),
    LP(6, "奉加微"),
    JLI(7, "杰理");

    private final String name;
    private final int value;

    PlatformTypeEnum(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public static PlatformTypeEnum fromName(String str) {
        for (PlatformTypeEnum platformTypeEnum : values()) {
            if (platformTypeEnum.name.equals(str)) {
                return platformTypeEnum;
            }
        }
        return null;
    }

    public static PlatformTypeEnum fromValue(int i) {
        for (PlatformTypeEnum platformTypeEnum : values()) {
            if (platformTypeEnum.value == i) {
                return platformTypeEnum;
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "PlatformTypeEnum{value=" + this.value + ", name='" + this.name + "'}";
    }
}
