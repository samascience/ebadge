package xfkj.fitpro.activity.ota.event;

import defpackage.ng;

/* JADX INFO: loaded from: classes4.dex */
public class OTAUpgradeEvent extends ng {
    private String otaPath;

    public OTAUpgradeEvent(String str) {
        this.otaPath = str;
    }

    public String getOtaPath() {
        return this.otaPath;
    }
}
