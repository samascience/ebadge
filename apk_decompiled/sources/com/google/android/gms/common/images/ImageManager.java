package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import defpackage.af1;
import defpackage.e43;
import defpackage.ta;
import defpackage.ts3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImageManager {
    private static final Object a = new Object();
    private static HashSet b = new HashSet();

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        private final Uri a;
        private final ArrayList b;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ImageManager.g(null).execute(new b(null, this.a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    private static final class a extends af1 {
    }

    private final class b implements Runnable {
        private final Uri a;
        private final ParcelFileDescriptor b;

        public b(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.a = uri;
            this.b = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmapDecodeFileDescriptor;
            Bitmap bitmap;
            boolean z;
            ta.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.b;
            boolean z2 = false;
            if (parcelFileDescriptor != null) {
                try {
                    bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String strValueOf = String.valueOf(this.a);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(strValueOf);
                    Log.e("ImageManager", sb.toString(), e);
                    z2 = true;
                    bitmapDecodeFileDescriptor = null;
                }
                try {
                    this.b.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
                bitmap = bitmapDecodeFileDescriptor;
                z = z2;
            } else {
                z = false;
                bitmap = null;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.h(null).post(new c(null, this.a, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String strValueOf2 = String.valueOf(this.a);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(strValueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    private final class c implements Runnable {
        private final Uri a;
        private final Bitmap b;
        private final CountDownLatch c;
        private boolean d;

        public c(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.a = uri;
            this.b = bitmap;
            this.d = z;
            this.c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ta.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.b != null;
            ImageManager.i(null);
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.f(null).remove(this.a);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.b;
                if (arrayList.size() > 0) {
                    e43.a(arrayList.get(0));
                    if (z) {
                        ImageManager.a(null);
                        throw null;
                    }
                    ImageManager.e(null).put(this.a, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager.a(null);
                    ImageManager.b(null);
                    throw null;
                }
            }
            this.c.countDown();
            synchronized (ImageManager.a) {
                ImageManager.b.remove(this.a);
            }
        }
    }

    static /* synthetic */ Context a(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ ts3 b(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ Map e(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ Map f(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ ExecutorService g(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ Handler h(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ a i(ImageManager imageManager) {
        throw null;
    }
}
