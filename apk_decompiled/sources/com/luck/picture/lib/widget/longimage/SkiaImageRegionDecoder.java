package com.luck.picture.lib.widget.longimage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Keep;
import defpackage.z01;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public class SkiaImageRegionDecoder implements z01 {
    private BitmapRegionDecoder a;
    private final ReadWriteLock b;
    private final Bitmap.Config c;

    @Keep
    public SkiaImageRegionDecoder() {
        this(null);
    }

    private Lock e() {
        return this.b.readLock();
    }

    @Override // defpackage.z01
    public synchronized void a() {
        this.b.writeLock().lock();
        try {
            this.a.recycle();
            this.a = null;
            this.b.writeLock().unlock();
        } catch (Throwable th) {
            this.b.writeLock().unlock();
            throw th;
        }
    }

    @Override // defpackage.z01
    public synchronized boolean b() {
        BitmapRegionDecoder bitmapRegionDecoder;
        bitmapRegionDecoder = this.a;
        return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
    }

    @Override // defpackage.z01
    public Point c(Context context, Uri uri) {
        int identifier;
        String string = uri.toString();
        if (string.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                identifier = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    identifier = 0;
                }
            } else {
                identifier = 0;
            }
            this.a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (string.startsWith("file:///android_asset/")) {
            this.a = BitmapRegionDecoder.newInstance(context.getAssets().open(string.substring(22), 1), false);
        } else if (string.startsWith("file://")) {
            this.a = BitmapRegionDecoder.newInstance(string.substring(7), false);
        } else {
            InputStream inputStream = null;
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    throw new Exception("Content resolver returned null stream. Unable to initialise with uri.");
                }
                this.a = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                try {
                    inputStreamOpenInputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
        return new Point(this.a.getWidth(), this.a.getHeight());
    }

    @Override // defpackage.z01
    public Bitmap d(Rect rect, int i) {
        e().lock();
        try {
            BitmapRegionDecoder bitmapRegionDecoder = this.a;
            if (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) {
                throw new IllegalStateException("Cannot decode region after decoder has been recycled");
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = this.c;
            Bitmap bitmapDecodeRegion = this.a.decodeRegion(rect, options);
            if (bitmapDecodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
            e().unlock();
            return bitmapDecodeRegion;
        } catch (Throwable th) {
            e().unlock();
            throw th;
        }
    }

    public SkiaImageRegionDecoder(Bitmap.Config config) {
        this.b = new ReentrantReadWriteLock(true);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.c = config;
        } else if (preferredBitmapConfig != null) {
            this.c = preferredBitmapConfig;
        } else {
            this.c = Bitmap.Config.RGB_565;
        }
    }
}
