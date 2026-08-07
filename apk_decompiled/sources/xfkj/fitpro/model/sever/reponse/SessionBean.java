package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class SessionBean {
    private String token;
    private int ttl;

    public SessionBean(String str, int i) {
        this.token = str;
        this.ttl = i;
    }

    public String getToken() {
        return this.token;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    public String toString() {
        return "SessionBean{token='" + this.token + "', ttl=" + this.ttl + '}';
    }

    public SessionBean() {
    }
}
