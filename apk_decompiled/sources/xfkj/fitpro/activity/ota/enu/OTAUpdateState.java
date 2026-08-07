package xfkj.fitpro.activity.ota.enu;

/* JADX INFO: loaded from: classes4.dex */
public enum OTAUpdateState {
    OTA_UPDATE_NOT_BEING(-1),
    OTA_UPDATE_ING(1);

    private final int ordinal;

    OTAUpdateState(int i) {
        this.ordinal = i;
    }

    public int getOrdinal() {
        return this.ordinal;
    }
}
