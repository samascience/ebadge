package com.luck.picture.lib.widget.longimage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private final Uri a;
    private final Bitmap b;
    private final Integer c;
    private boolean d;
    private int e;
    private int f;
    private Rect g;
    private boolean h;

    private a(Bitmap bitmap, boolean z) {
        this.b = bitmap;
        this.a = null;
        this.c = null;
        this.d = false;
        this.e = bitmap.getWidth();
        this.f = bitmap.getHeight();
        this.h = z;
    }

    public static a a(String str) {
        if (str == null) {
            throw new NullPointerException("Asset name must not be null");
        }
        return o("file:///android_asset/" + str);
    }

    public static a b(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap, true);
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    public static a k(int i) {
        return new a(i);
    }

    public static a n(Uri uri) {
        if (uri != null) {
            return new a(uri);
        }
        throw new NullPointerException("Uri must not be null");
    }

    public static a o(String str) {
        if (str == null) {
            throw new NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith(WatchConstant.FAT_FS_ROOT)) {
                str = str.substring(1);
            }
            str = "file:///" + str;
        }
        return new a(Uri.parse(str));
    }

    protected final Bitmap c() {
        return this.b;
    }

    protected final Integer d() {
        return this.c;
    }

    protected final int e() {
        return this.f;
    }

    protected final Rect f() {
        return this.g;
    }

    protected final int g() {
        return this.e;
    }

    protected final boolean h() {
        return this.d;
    }

    protected final Uri i() {
        return this.a;
    }

    protected final boolean j() {
        return this.h;
    }

    public a l(boolean z) {
        this.d = z;
        return this;
    }

    public a m() {
        return l(true);
    }

    private a(Uri uri) {
        String string = uri.toString();
        if (string.startsWith("file:///") && !new File(string.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(string, Constants.ENC_UTF_8));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.b = null;
        this.a = uri;
        this.c = null;
        this.d = true;
    }

    private a(int i) {
        this.b = null;
        this.a = null;
        this.c = Integer.valueOf(i);
        this.d = true;
    }
}
