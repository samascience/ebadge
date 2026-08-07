package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum LangEnm {
    CHINESE_SIMPLIFIED(0, "简体中文"),
    ENGLISH(1, "英文"),
    TAIWAN(2, "繁体中文"),
    ALBANIAN(3, "阿拉伯语"),
    CZECH(4, "捷克语"),
    GERMAN(5, "德语"),
    SPANISH(6, "西班牙语"),
    FRENCH(7, "法语"),
    JAPANESE(8, "日语"),
    MALAYSIAN(9, "马来西亚语"),
    DUTCH(10, "荷兰语"),
    POLISH(11, "波兰语"),
    PORTUGUESE(12, "葡萄牙语"),
    RUSSIAN(13, "俄语"),
    SLOVAK(14, "斯洛伐克语"),
    THAI(15, "泰语"),
    GREEK(16, "希腊语"),
    VIETNAMESE(17, "越南语"),
    ITALIAN(18, "意大利语"),
    FILIPINO(19, "菲律宾语"),
    INDONESIAN(20, "印尼语"),
    UKRAINIAN(21, "乌克兰语"),
    INDIAN(22, "印度语"),
    FRENCH_BELGIAN(23, "芬兰语"),
    CROATIAN(24, "克罗地亚语"),
    NORWEGIAN(25, "挪威语"),
    DANISH(26, "丹麦语"),
    SWEDISH(27, "瑞典语"),
    KOREAN(28, "韩语"),
    CZECH_REPUBLIC(29, "匈牙利语"),
    GERMANY(30, "希腊语"),
    BOSNIAN(31, "波斯语"),
    ROMANIA(32, "罗马尼亚语"),
    MONGOLIAN(33, "缅甸语"),
    MONGOLIAN_CYRILLIC(34, "孟加拉语");

    private String desc;
    private int value;

    LangEnm(int i, String str) {
        this.value = i;
        this.desc = str;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getValue() {
        return this.value;
    }
}
