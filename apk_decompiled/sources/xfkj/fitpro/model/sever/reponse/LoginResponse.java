package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class LoginResponse {
    private SessionBean session;
    private UserBean user;

    public SessionBean getSession() {
        return this.session;
    }

    public UserBean getUser() {
        return this.user;
    }

    public void setSession(SessionBean sessionBean) {
        this.session = sessionBean;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }

    public String toString() {
        return "LoginResponse{user=" + this.user + ", session=" + this.session + '}';
    }
}
