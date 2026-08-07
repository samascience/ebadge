package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class QueryStepsRankResponse {
    private String avator;
    private int date;
    private int like;
    private boolean likeByMe;
    private String nickname;
    private int step;
    private long userId;

    public String getAvator() {
        return this.avator;
    }

    public int getDate() {
        return this.date;
    }

    public int getLike() {
        return this.like;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getStep() {
        return this.step;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isLikeByMe() {
        return this.likeByMe;
    }

    public void setAvator(String str) {
        this.avator = str;
    }

    public void setDate(int i) {
        this.date = i;
    }

    public void setLike(int i) {
        this.like = i;
    }

    public void setLikeByMe(boolean z) {
        this.likeByMe = z;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setStep(int i) {
        this.step = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "QueryStepsRankResponse{userId=" + this.userId + ", nickname='" + this.nickname + "', avator='" + this.avator + "', date=" + this.date + ", step=" + this.step + ", like=" + this.like + ", likeByMe=" + this.likeByMe + '}';
    }
}
