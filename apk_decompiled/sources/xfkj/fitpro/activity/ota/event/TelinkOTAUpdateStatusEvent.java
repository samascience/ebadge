package xfkj.fitpro.activity.ota.event;

/* JADX INFO: loaded from: classes4.dex */
public class TelinkOTAUpdateStatusEvent {
    private int progress;
    private int status;

    public TelinkOTAUpdateStatusEvent(int i, int i2) {
        this.status = i;
        this.progress = i2;
    }

    public int getProgress() {
        return this.progress;
    }

    public int getStatus() {
        return this.status;
    }
}
