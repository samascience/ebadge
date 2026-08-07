package xfkj.fitpro.model.home;

/* JADX INFO: loaded from: classes4.dex */
public class SportsModel extends BaseSportsModel {
    private int sportType;

    public SportsModel(int i) {
        this.sportType = i;
    }

    @Override // xfkj.fitpro.model.home.BaseSportsModel
    public int getItemType() {
        return BaseSportsModel.SPORTS_TYPE;
    }

    public int getSportType() {
        return this.sportType;
    }
}
