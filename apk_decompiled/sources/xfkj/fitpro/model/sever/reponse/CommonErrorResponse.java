package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class CommonErrorResponse {
    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "CommonErrorResponse{code=" + this.code + ", message='" + this.message + "'}";
    }
}
