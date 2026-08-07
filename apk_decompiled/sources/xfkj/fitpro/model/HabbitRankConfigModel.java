package xfkj.fitpro.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class HabbitRankConfigModel {
    private List<HabbitRankModel> ranks;
    private int signCount;

    public List<HabbitRankModel> getRanks() {
        return this.ranks;
    }

    public int getSignCount() {
        return this.signCount;
    }

    public void setRanks(List<HabbitRankModel> list) {
        this.ranks = list;
    }

    public void setSignCount(int i) {
        this.signCount = i;
    }
}
