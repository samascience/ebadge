package xfkj.fitpro.model.stand;

/* JADX INFO: loaded from: classes4.dex */
public class SportStandGroupModel {
    private String dateStrIndex;
    private String devid;
    private Long id;
    private int totalCount;

    public SportStandGroupModel(String str, String str2, int i) {
        this.devid = str;
        this.dateStrIndex = str2;
        this.totalCount = i;
    }

    public String getDateStrIndex() {
        return this.dateStrIndex;
    }

    public String getDevid() {
        return this.devid;
    }

    public Long getId() {
        return this.id;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setDateStrIndex(String str) {
        this.dateStrIndex = str;
    }

    public void setDevid(String str) {
        this.devid = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public SportStandGroupModel(Long l, String str, String str2, int i) {
        this.id = l;
        this.devid = str;
        this.dateStrIndex = str2;
        this.totalCount = i;
    }

    public SportStandGroupModel() {
    }
}
