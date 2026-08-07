package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class IMEIStatusModel {
    Long id;
    private String imei;
    private boolean isOnly;
    private boolean isSync;
    private int status;

    public IMEIStatusModel(Long l, String str, int i, boolean z, boolean z2) {
        this.id = l;
        this.imei = str;
        this.status = i;
        this.isOnly = z;
        this.isSync = z2;
    }

    public Long getId() {
        return this.id;
    }

    public String getImei() {
        return this.imei;
    }

    public boolean getIsOnly() {
        return this.isOnly;
    }

    public boolean getIsSync() {
        return this.isSync;
    }

    public int getStatus() {
        return this.status;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setIsOnly(boolean z) {
        this.isOnly = z;
    }

    public void setIsSync(boolean z) {
        this.isSync = z;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String toString() {
        return "IMEIStatusModel{imei='" + this.imei + "', status=" + this.status + ", isOnly=" + this.isOnly + ", isSync=" + this.isSync + '}';
    }

    public IMEIStatusModel() {
        this.status = 0;
        this.isOnly = true;
        this.isSync = false;
    }
}
