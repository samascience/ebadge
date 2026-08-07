package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class UserBean {
    private long id;
    private String password;

    public UserBean(long j, String str) {
        this.id = j;
        this.password = str;
    }

    public long getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public UserBean() {
    }
}
