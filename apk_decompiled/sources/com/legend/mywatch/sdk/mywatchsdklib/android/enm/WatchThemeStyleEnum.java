package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum WatchThemeStyleEnum {
    TAKE_PICTURE(0, "拍照照片"),
    BG_COLOR(1, "背景颜色"),
    BG_STYLE(2, "背景样式"),
    TIME_STYLE(3, "时间样式"),
    POINTER_STYLE(4, "指针样式"),
    MIX_FUNCTION_1(5, "复杂功能一"),
    MIX_FUNCTION_2(6, "复杂功能二");

    String label;
    int type;

    WatchThemeStyleEnum(int i, String str) {
        this.type = i;
        this.label = str;
    }

    public String getLabel() {
        return this.label;
    }

    public int getType() {
        return this.type;
    }
}
