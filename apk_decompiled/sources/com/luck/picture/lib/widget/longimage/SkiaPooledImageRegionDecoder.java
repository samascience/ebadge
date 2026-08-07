package com.luck.picture.lib.widget.longimage;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import defpackage.z01;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes3.dex */
public class SkiaPooledImageRegionDecoder implements z01 {
    private static final String i = "SkiaPooledImageRegionDecoder";
    private static boolean j = false;
    private b a;
    private final ReadWriteLock b;
    private final Bitmap.Config c;
    private Context d;
    private Uri e;
    private long f;
    private final Point g;
    private final AtomicBoolean h;

    class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (SkiaPooledImageRegionDecoder.this.a != null) {
                SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                if (!skiaPooledImageRegionDecoder.i(skiaPooledImageRegionDecoder.a.n(), SkiaPooledImageRegionDecoder.this.f)) {
                    return;
                }
                try {
                    if (SkiaPooledImageRegionDecoder.this.a != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        SkiaPooledImageRegionDecoder.this.j("Starting decoder");
                        SkiaPooledImageRegionDecoder.this.l();
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        SkiaPooledImageRegionDecoder.this.j("Started decoder, took " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms");
                    }
                } catch (Exception e) {
                    SkiaPooledImageRegionDecoder.this.j("Failed to start decoder: " + e.getMessage());
                }
            }
        }
    }

    @Keep
    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        if (j) {
            Log.d(i, str);
        }
    }

    private int k() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws IOException {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        int identifier;
        String string = this.e.toString();
        long length = Long.MAX_VALUE;
        if (string.startsWith("android.resource://")) {
            String authority = this.e.getAuthority();
            Resources resources = this.d.getPackageName().equals(authority) ? this.d.getResources() : this.d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = this.e.getPathSegments();
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
            try {
                length = this.d.getResources().openRawResourceFd(identifier).getLength();
            } catch (Exception unused2) {
            }
            bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(this.d.getResources().openRawResource(identifier), false);
        } else if (string.startsWith("file:///android_asset/")) {
            String strSubstring = string.substring(22);
            try {
                length = this.d.getAssets().openFd(strSubstring).getLength();
            } catch (Exception unused3) {
            }
            bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(this.d.getAssets().open(strSubstring, 1), false);
        } else if (string.startsWith("file://")) {
            BitmapRegionDecoder bitmapRegionDecoderNewInstance2 = BitmapRegionDecoder.newInstance(string.substring(7), false);
            try {
                File file = new File(string);
                if (file.exists()) {
                    length = file.length();
                }
            } catch (Exception unused4) {
            }
            bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance2;
        } else {
            InputStream inputStreamOpenInputStream = null;
            try {
                ContentResolver contentResolver = this.d.getContentResolver();
                inputStreamOpenInputStream = contentResolver.openInputStream(this.e);
                BitmapRegionDecoder bitmapRegionDecoderNewInstance3 = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                try {
                    AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.e, "r");
                    if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                        length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                    }
                } catch (Exception unused5) {
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance3;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception unused7) {
                    }
                }
                throw th;
            }
        }
        this.f = length;
        this.g.set(bitmapRegionDecoderNewInstance.getWidth(), bitmapRegionDecoderNewInstance.getHeight());
        this.b.writeLock().lock();
        try {
            b bVar = this.a;
            if (bVar != null) {
                bVar.h(bitmapRegionDecoderNewInstance);
            }
        } finally {
            this.b.writeLock().unlock();
        }
    }

    private boolean m() {
        ActivityManager activityManager = (ActivityManager) this.d.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    private void n() {
        if (!this.h.compareAndSet(false, true) || this.f >= Long.MAX_VALUE) {
            return;
        }
        j("Starting lazy init of additional decoders");
        new a().start();
    }

    @Keep
    public static void setDebug(boolean z) {
        j = z;
    }

    @Override // defpackage.z01
    public synchronized void a() {
        this.b.writeLock().lock();
        try {
            b bVar = this.a;
            if (bVar != null) {
                bVar.l();
                this.a = null;
                this.d = null;
                this.e = null;
            }
            this.b.writeLock().unlock();
        } catch (Throwable th) {
            this.b.writeLock().unlock();
            throw th;
        }
    }

    @Override // defpackage.z01
    public synchronized boolean b() {
        b bVar;
        bVar = this.a;
        return (bVar == null || bVar.j()) ? false : true;
    }

    @Override // defpackage.z01
    public Point c(Context context, Uri uri) throws IOException {
        this.d = context;
        this.e = uri;
        l();
        return this.g;
    }

    @Override // defpackage.z01
    public Bitmap d(Rect rect, int i2) {
        j("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.g.x || rect.height() < this.g.y) {
            n();
        }
        this.b.readLock().lock();
        try {
            b bVar = this.a;
            if (bVar != null) {
                BitmapRegionDecoder bitmapRegionDecoderG = bVar.g();
                if (bitmapRegionDecoderG != null) {
                    try {
                        if (!bitmapRegionDecoderG.isRecycled()) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = i2;
                            options.inPreferredConfig = this.c;
                            Bitmap bitmapDecodeRegion = bitmapRegionDecoderG.decodeRegion(rect, options);
                            if (bitmapDecodeRegion == null) {
                                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                            }
                            this.a.m(bitmapRegionDecoderG);
                            this.b.readLock().unlock();
                            return bitmapDecodeRegion;
                        }
                    } catch (Throwable th) {
                        this.a.m(bitmapRegionDecoderG);
                        throw th;
                    }
                }
                if (bitmapRegionDecoderG != null) {
                    this.a.m(bitmapRegionDecoderG);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } catch (Throwable th2) {
            this.b.readLock().unlock();
            throw th2;
        }
    }

    protected boolean i(int i2, long j2) {
        if (i2 >= 4) {
            j("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j3 = ((long) i2) * j2;
        if (j3 > 20971520) {
            j("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        }
        if (i2 >= k()) {
            j("No additional encoders allowed, limited by CPU cores (" + k() + ")");
            return false;
        }
        if (m()) {
            j("No additional encoders allowed, memory is low");
            return false;
        }
        j("Additional decoder allowed, current count is " + i2 + ", estimated native memory " + (j3 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + "Mb");
        return true;
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.a = new b(null);
        this.b = new ReentrantReadWriteLock(true);
        this.f = Long.MAX_VALUE;
        this.g = new Point(0, 0);
        this.h = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.c = config;
        } else if (preferredBitmapConfig != null) {
            this.c = preferredBitmapConfig;
        } else {
            this.c = Bitmap.Config.RGB_565;
        }
    }

    private static class b {
        private final Semaphore a;
        private final Map b;

        private b() {
            this.a = new Semaphore(0, true);
            this.b = new ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BitmapRegionDecoder g() {
            this.a.acquireUninterruptibly();
            return i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void h(BitmapRegionDecoder bitmapRegionDecoder) {
            this.b.put(bitmapRegionDecoder, Boolean.FALSE);
            this.a.release();
        }

        private synchronized BitmapRegionDecoder i() {
            for (Map.Entry entry : this.b.entrySet()) {
                if (!((Boolean) entry.getValue()).booleanValue()) {
                    entry.setValue(Boolean.TRUE);
                    return (BitmapRegionDecoder) entry.getKey();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean j() {
            return this.b.isEmpty();
        }

        private synchronized boolean k(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry entry : this.b.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (!((Boolean) entry.getValue()).booleanValue()) {
                        return false;
                    }
                    entry.setValue(Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void l() {
            while (!this.b.isEmpty()) {
                BitmapRegionDecoder bitmapRegionDecoderG = g();
                bitmapRegionDecoderG.recycle();
                this.b.remove(bitmapRegionDecoderG);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(BitmapRegionDecoder bitmapRegionDecoder) {
            if (k(bitmapRegionDecoder)) {
                this.a.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized int n() {
            return this.b.size();
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }
}
