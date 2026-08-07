package xfkj.fitpro.model.sever.reponse;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AdviceResponse implements Serializable {
    private Object contact;
    private String content;
    private Date createdAt;
    private String id;
    private String image1;
    private String image2;
    private String image3;
    private List<ReplyListBean> replyList;
    private int source;
    private int status;
    private Object type;
    private Date updatedAt;
    private String userId;

    public static class ReplyListBean implements Serializable {
        private String content;
        private List<String> images;
        private Date replyAt;
        private String replyBy;

        public String getContent() {
            return this.content;
        }

        public List<String> getImages() {
            return this.images;
        }

        public Date getReplyAt() {
            return this.replyAt;
        }

        public String getReplyBy() {
            return this.replyBy;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setImages(List<String> list) {
            this.images = list;
        }

        public void setReplyAt(Date date) {
            this.replyAt = date;
        }

        public void setReplyBy(String str) {
            this.replyBy = str;
        }
    }

    public Object getContact() {
        return this.contact;
    }

    public String getContent() {
        return this.content;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getId() {
        return this.id;
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

    public List<ReplyListBean> getReplyList() {
        return this.replyList;
    }

    public int getSource() {
        return this.source;
    }

    public int getStatus() {
        return this.status;
    }

    public Object getType() {
        return this.type;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setContact(Object obj) {
        this.contact = obj;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public void setId(String str) {
        this.id = str;
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

    public void setReplyList(List<ReplyListBean> list) {
        this.replyList = list;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setType(Object obj) {
        this.type = obj;
    }

    public void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "AdviceResponse{id='" + this.id + "', userId='" + this.userId + "', content='" + this.content + "', type=" + this.type + ", source=" + this.source + ", status=" + this.status + ", image1='" + this.image1 + "', image2='" + this.image2 + "', image3='" + this.image3 + "', contact=" + this.contact + ", createdAt='" + this.createdAt + "', updatedAt='" + this.updatedAt + "', replyList=" + this.replyList + '}';
    }
}
