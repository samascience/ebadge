package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ng {
    private String macAddress = Constants.STR_EMPTY;

    public final String getMacAddress() {
        return this.macAddress;
    }

    public final void setMacAddress(String str) {
        p31.f(str, "<set-?>");
        this.macAddress = str;
    }
}
