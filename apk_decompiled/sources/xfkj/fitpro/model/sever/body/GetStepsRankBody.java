package xfkj.fitpro.model.sever.body;

/* JADX INFO: loaded from: classes4.dex */
public class GetStepsRankBody {
    String date;
    int userid;

    public GetStepsRankBody(int i, String str) {
        this.userid = i;
        this.date = str;
    }

    public String getDate() {
        return this.date;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setUserid(int i) {
        this.userid = i;
    }
}
