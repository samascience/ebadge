package com.alibaba.dashscope.aigc.multimodalconversation;

import com.tencent.open.SocialConstants;
import defpackage.xm2;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class AudioResult implements Serializable {

    @xm2("data")
    private String data;

    @xm2("expires_at")
    private Long expiresAt;

    @xm2("id")
    private String id;

    @xm2(SocialConstants.PARAM_URL)
    private String url;

    public static abstract class b {
        private String a;
        private String b;
        private String c;
        private Long d;

        public String toString() {
            return "AudioResult.AudioResultBuilder(data=" + this.a + ", id=" + this.b + ", url=" + this.c + ", expiresAt=" + this.d + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }
    }

    protected AudioResult(b bVar) {
        this.data = bVar.a;
        this.id = bVar.b;
        this.url = bVar.c;
        this.expiresAt = bVar.d;
    }

    public static b builder() {
        return new c();
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof AudioResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioResult)) {
            return false;
        }
        AudioResult audioResult = (AudioResult) obj;
        if (!audioResult.canEqual(this)) {
            return false;
        }
        Long expiresAt = getExpiresAt();
        Long expiresAt2 = audioResult.getExpiresAt();
        if (expiresAt != null ? !expiresAt.equals(expiresAt2) : expiresAt2 != null) {
            return false;
        }
        String data = getData();
        String data2 = audioResult.getData();
        if (data != null ? !data.equals(data2) : data2 != null) {
            return false;
        }
        String id = getId();
        String id2 = audioResult.getId();
        if (id != null ? !id.equals(id2) : id2 != null) {
            return false;
        }
        String url = getUrl();
        String url2 = audioResult.getUrl();
        return url != null ? url.equals(url2) : url2 == null;
    }

    public String getData() {
        return this.data;
    }

    public Long getExpiresAt() {
        return this.expiresAt;
    }

    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        Long expiresAt = getExpiresAt();
        int iHashCode = expiresAt == null ? 43 : expiresAt.hashCode();
        String data = getData();
        int iHashCode2 = ((iHashCode + 59) * 59) + (data == null ? 43 : data.hashCode());
        String id = getId();
        int iHashCode3 = (iHashCode2 * 59) + (id == null ? 43 : id.hashCode());
        String url = getUrl();
        return (iHashCode3 * 59) + (url != null ? url.hashCode() : 43);
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setExpiresAt(Long l) {
        this.expiresAt = l;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "AudioResult(data=" + getData() + ", id=" + getId() + ", url=" + getUrl() + ", expiresAt=" + getExpiresAt() + ")";
    }

    public AudioResult() {
    }
}
