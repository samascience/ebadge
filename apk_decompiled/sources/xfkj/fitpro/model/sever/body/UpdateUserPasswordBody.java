package xfkj.fitpro.model.sever.body;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateUserPasswordBody {
    private String oldPassword;
    private String password;
    private int userId;

    public String getOldPassword() {
        return this.oldPassword;
    }

    public String getPassword() {
        return this.password;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setOldPassword(String str) {
        this.oldPassword = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }
}
