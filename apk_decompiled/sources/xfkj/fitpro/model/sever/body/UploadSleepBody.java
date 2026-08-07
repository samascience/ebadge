package xfkj.fitpro.model.sever.body;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSleepBody {
    private String data;
    private int deep_sleep;
    private int light_sleep;
    private String sleep_date;
    private String sleep_time;
    private int total_sleep;
    private int userid;
    private String wakeup_time;

    public String getData() {
        return this.data;
    }

    public int getDeep_sleep() {
        return this.deep_sleep;
    }

    public int getLight_sleep() {
        return this.light_sleep;
    }

    public String getSleep_date() {
        return this.sleep_date;
    }

    public String getSleep_time() {
        return this.sleep_time;
    }

    public int getTotal_sleep() {
        return this.total_sleep;
    }

    public int getUserid() {
        return this.userid;
    }

    public String getWakeup_time() {
        return this.wakeup_time;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDeep_sleep(int i) {
        this.deep_sleep = i;
    }

    public void setLight_sleep(int i) {
        this.light_sleep = i;
    }

    public void setSleep_date(String str) {
        this.sleep_date = str;
    }

    public void setSleep_time(String str) {
        this.sleep_time = str;
    }

    public void setTotal_sleep(int i) {
        this.total_sleep = i;
    }

    public void setUserid(int i) {
        this.userid = i;
    }

    public void setWakeup_time(String str) {
        this.wakeup_time = str;
    }
}
