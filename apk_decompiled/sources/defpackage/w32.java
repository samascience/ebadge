package defpackage;

import com.legend.mywatch.sdk.mywatchsdklib.android.enm.PlatformTypeEnum;

/* JADX INFO: loaded from: classes3.dex */
public class w32 extends ng {
    private PlatformTypeEnum a;

    public w32(PlatformTypeEnum platformTypeEnum) {
        this.a = platformTypeEnum;
    }

    public PlatformTypeEnum a() {
        return this.a;
    }

    public String toString() {
        return "PlatformTypeEvent{platformType=" + this.a + '}';
    }
}
