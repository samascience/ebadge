package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class RegisterResponse {
    private SessionBean session;
    private UserBean user;

    public static class SessionBean {
        private String token;
        private int ttl;

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
    }

    public static class UserBean {
        private int id;

        public int getId() {
            return this.id;
        }

        public void setId(int i) {
            this.id = i;
        }
    }

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
        return "RegisterResponse{user=" + this.user + ", session=" + this.session + '}';
    }
}
