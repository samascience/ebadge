package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class UserHabbitCustomModel {
    private long habbitId;
    private String habbitName;
    private Long habbitType;
    Long id;

    public UserHabbitCustomModel(Long l, String str, long j, Long l2) {
        this.id = l;
        this.habbitName = str;
        this.habbitId = j;
        this.habbitType = l2;
    }

    public long getHabbitId() {
        return this.habbitId;
    }

    public String getHabbitName() {
        return this.habbitName;
    }

    public Long getHabbitType() {
        return this.habbitType;
    }

    public Long getId() {
        return this.id;
    }

    public void setHabbitId(long j) {
        this.habbitId = j;
    }

    public void setHabbitName(String str) {
        this.habbitName = str;
    }

    public void setHabbitType(Long l) {
        this.habbitType = l;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public String toString() {
        return "UserHabbitCustomModel{id=" + this.id + ", habbitName='" + this.habbitName + "', habbitId=" + this.habbitId + ", habbitType=" + this.habbitType + '}';
    }

    public UserHabbitCustomModel() {
    }
}
