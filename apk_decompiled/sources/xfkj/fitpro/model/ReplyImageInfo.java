package xfkj.fitpro.model;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.previewlibrary.enitity.IThumbViewInfo;

/* JADX INFO: loaded from: classes4.dex */
public class ReplyImageInfo implements IThumbViewInfo {
    public static final Parcelable.Creator<ReplyImageInfo> CREATOR = new Parcelable.Creator<ReplyImageInfo>() { // from class: xfkj.fitpro.model.ReplyImageInfo.1
        @Override // android.os.Parcelable.Creator
        public ReplyImageInfo createFromParcel(Parcel parcel) {
            return new ReplyImageInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ReplyImageInfo[] newArray(int i) {
            return new ReplyImageInfo[i];
        }
    };
    private Rect mBounds;
    private String url;
    private String user;
    private String videoUrl;

    public ReplyImageInfo(String str) {
        this.user = "用户字段";
        this.url = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.previewlibrary.enitity.IThumbViewInfo
    public Rect getBounds() {
        return this.mBounds;
    }

    @Override // com.previewlibrary.enitity.IThumbViewInfo
    public String getUrl() {
        return this.url;
    }

    public String getUser() {
        return this.user;
    }

    @Override // com.previewlibrary.enitity.IThumbViewInfo
    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setBounds(Rect rect) {
        this.mBounds = rect;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeParcelable(this.mBounds, i);
        parcel.writeString(this.user);
        parcel.writeString(this.videoUrl);
    }

    public ReplyImageInfo(String str, String str2) {
        this.user = "用户字段";
        this.url = str2;
        this.videoUrl = str;
    }

    protected ReplyImageInfo(Parcel parcel) {
        this.user = "用户字段";
        this.url = parcel.readString();
        this.mBounds = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.user = parcel.readString();
        this.videoUrl = parcel.readString();
    }
}
