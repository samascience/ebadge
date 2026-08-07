package xfkj.fitpro.ui.activities.device.electronicBadgeDevice.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.connect.common.Constants;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes4.dex */
public final class VideoInfo implements Parcelable {
    public static final a CREATOR = new a(null);
    private final String a;
    private final String b;
    private final Uri c;

    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new VideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoInfo[] newArray(int i) {
            return new VideoInfo[i];
        }

        private a() {
        }
    }

    public VideoInfo(String str, String str2, Uri uri) {
        p31.f(str, "path");
        p31.f(str2, "name");
        p31.f(uri, "uri");
        this.a = str;
        this.b = str2;
        this.c = uri;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final Uri c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return p31.a(this.a, videoInfo.a) && p31.a(this.b, videoInfo.b) && p31.a(this.c, videoInfo.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "VideoInfo(path=" + this.a + ", name=" + this.b + ", uri=" + this.c + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VideoInfo(Parcel parcel) {
        p31.f(parcel, "parcel");
        String string = parcel.readString();
        String str = Constants.STR_EMPTY;
        string = string == null ? Constants.STR_EMPTY : string;
        String string2 = parcel.readString();
        str = string2 != null ? string2 : str;
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (uri == null) {
            uri = Uri.EMPTY;
            p31.e(uri, "EMPTY");
        }
        this(string, str, uri);
    }
}
