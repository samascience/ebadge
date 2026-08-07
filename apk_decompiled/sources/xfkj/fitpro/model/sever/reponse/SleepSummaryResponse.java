package xfkj.fitpro.model.sever.reponse;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SleepSummaryResponse {
    private List<Integer> asleepStat;
    private List<Integer> durStat;
    private List<Integer> wakeupStat;

    public List<Integer> getAsleepStat() {
        return this.asleepStat;
    }

    public List<Integer> getDurStat() {
        return this.durStat;
    }

    public List<Integer> getWakeupStat() {
        return this.wakeupStat;
    }

    public void setAsleepStat(List<Integer> list) {
        this.asleepStat = list;
    }

    public void setDurStat(List<Integer> list) {
        this.durStat = list;
    }

    public void setWakeupStat(List<Integer> list) {
        this.wakeupStat = list;
    }
}
