package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.tencent.open.SocialConstants;
import defpackage.nj2;
import defpackage.st1;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new a();
    private final int a;
    private final Uri b;
    private final int c;
    private final int d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.a = i;
        this.b = uri;
        this.c = i2;
        this.d = i3;
    }

    private static Uri G0(JSONObject jSONObject) {
        if (jSONObject.has(SocialConstants.PARAM_URL)) {
            try {
                return Uri.parse(jSONObject.getString(SocialConstants.PARAM_URL));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final Uri F0() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (st1.a(this.b, webImage.b) && this.c == webImage.c && this.d == webImage.d) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.d;
    }

    public final int getWidth() {
        return this.c;
    }

    public final int hashCode() {
        return st1.b(this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocialConstants.PARAM_URL, this.b.toString());
            jSONObject.put("width", this.c);
            jSONObject.put("height", this.d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.c), Integer.valueOf(this.d), this.b.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.n(parcel, 2, F0(), i, false);
        nj2.h(parcel, 3, getWidth());
        nj2.h(parcel, 4, getHeight());
        nj2.b(parcel, iA);
    }

    public WebImage(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(G0(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }
}
