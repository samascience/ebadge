package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class SleepDataBean {
    private int sapce_time;
    private String status;
    private String time;

    public int getSapce_time() {
        return this.sapce_time;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTime() {
        return this.time;
    }

    public void setSapce_time(int i) {
        this.sapce_time = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "SleepDataBean{time='" + this.time + "', status='" + this.status + "', sapce_time=" + this.sapce_time + '}';
    }
}
