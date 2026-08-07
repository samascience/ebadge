package xfkj.fitpro.model.sever.body;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class FeedbackBody {
    int userid;
    String content = Constants.STR_EMPTY;
    String image1 = Constants.STR_EMPTY;
    String image2 = Constants.STR_EMPTY;
    String image3 = Constants.STR_EMPTY;
    String contact = Constants.STR_EMPTY;
    String version = Constants.STR_EMPTY;

    public String getContact() {
        return this.contact;
    }

    public String getContent() {
        return this.content;
    }

    public String getImage1() {
        return this.image1;
    }

    public String getImage2() {
        return this.image2;
    }

    public String getImage3() {
        return this.image3;
    }

    public int getUserid() {
        return this.userid;
    }

    public String getVersion() {
        return this.version;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setImage1(String str) {
        this.image1 = str;
    }

    public void setImage2(String str) {
        this.image2 = str;
    }

    public void setImage3(String str) {
        this.image3 = str;
    }

    public void setUserid(int i) {
        this.userid = i;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
