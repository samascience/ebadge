package xfkj.fitpro.model.sever.body;

/* JADX INFO: loaded from: classes4.dex */
public class ResetUserPasswordBody {
    private String code;
    private String mobile;
    private String password;
    private int userId;

    public String getCode() {
        return this.code;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getPassword() {
        return this.password;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserId(int i) {
        this.userId = i;
    }
}
