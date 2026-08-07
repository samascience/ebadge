package com.legend.mywatch.sdk.mywatchsdklib.android.enm;

/* JADX INFO: loaded from: classes3.dex */
public enum NotifyMsgTypeEnm {
    QQ("com.tencent.mobileqq"),
    WeChat("com.tencent.mm"),
    MMS("app.mms"),
    CALL("com.android.incallui_deldel"),
    FACEBOOK("com.facebook.katana"),
    TWITTER("com.twitter.android"),
    SKYPE("com.skype.raider"),
    LINE("jp.naver.line.android"),
    WATSAPP("com.whatsapp"),
    KAKAOTALK("com.kakao.talk"),
    INSTAGRAM("com.instagram.android"),
    LINKEDIN("com.linkedin.android");

    private String pkgName;

    NotifyMsgTypeEnm(String str) {
        this.pkgName = str;
    }

    public String getPkgName() {
        return this.pkgName;
    }
}
