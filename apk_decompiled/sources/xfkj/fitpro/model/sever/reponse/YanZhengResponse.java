package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class YanZhengResponse {
    private String code;
    private String mobile;

    public String getCode() {
        return this.code;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String toString() {
        return "YanZhengResponse{mobile='" + this.mobile + "', code='" + this.code + "'}";
    }
}
