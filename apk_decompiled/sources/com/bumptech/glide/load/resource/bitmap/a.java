package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import defpackage.b53;
import defpackage.cd1;
import defpackage.na3;
import defpackage.oi;
import defpackage.px1;
import defpackage.qg2;
import defpackage.qi;
import defpackage.rx1;
import defpackage.v9;
import defpackage.z42;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final px1 f = px1.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    public static final px1 g = px1.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    public static final px1 h = DownsampleStrategy.h;
    public static final px1 i;
    public static final px1 j;
    private static final Set k;
    private static final b l;
    private static final Set m;
    private static final Queue n;
    private final oi a;
    private final DisplayMetrics b;
    private final v9 c;
    private final List d;
    private final com.bumptech.glide.load.resource.bitmap.b e = com.bumptech.glide.load.resource.bitmap.b.b();

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.a$a, reason: collision with other inner class name */
    class C0065a implements b {
        C0065a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void b(oi oiVar, Bitmap bitmap) {
        }
    }

    public interface b {
        void a();

        void b(oi oiVar, Bitmap bitmap);
    }

    static {
        Boolean bool = Boolean.FALSE;
        i = px1.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        j = px1.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        l = new C0065a();
        m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        n = na3.e(0);
    }

    public a(List list, DisplayMetrics displayMetrics, oi oiVar, v9 v9Var) {
        this.d = list;
        this.b = (DisplayMetrics) z42.d(displayMetrics);
        this.a = (oi) z42.d(oiVar);
        this.c = (v9) z42.d(v9Var);
    }

    private static int a(double d) {
        int iL = l(d);
        int iX = x(((double) iL) * d);
        return x((d / ((double) (iX / iL))) * ((double) iX));
    }

    private void b(c cVar, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean zHasAlpha;
        if (this.e.i(i2, i3, options, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = cVar.d().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, c cVar, b bVar, oi oiVar, DownsampleStrategy downsampleStrategy, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int iFloor;
        int iFloor2;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (r(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float fB = downsampleStrategy.b(i7, i8, i5, i6);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + downsampleStrategy + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRoundingA = downsampleStrategy.a(i7, i8, i5, i6);
        if (sampleSizeRoundingA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i7;
        float f3 = i8;
        int iX = i7 / x(fB * f2);
        int iX2 = i8 / x(fB * f3);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(sampleSizeRoundingA == sampleSizeRounding ? Math.max(iX, iX2) : Math.min(iX, iX2)));
        if (sampleSizeRoundingA == sampleSizeRounding && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            iFloor = (int) Math.ceil(f2 / fMin);
            iFloor2 = (int) Math.ceil(f3 / fMin);
            int i9 = iMax / 8;
            if (i9 > 0) {
                iFloor /= i9;
                iFloor2 /= i9;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f4 = iMax;
            iFloor = (int) Math.floor(f2 / f4);
            iFloor2 = (int) Math.floor(f3 / f4);
        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
            float f5 = iMax;
            iFloor = Math.round(f2 / f5);
            iFloor2 = Math.round(f3 / f5);
        } else if (i7 % iMax == 0 && i8 % iMax == 0) {
            iFloor = i7 / iMax;
            iFloor2 = i8 / iMax;
        } else {
            int[] iArrM = m(cVar, options, bVar, oiVar);
            iFloor = iArrM[0];
            iFloor2 = iArrM[1];
        }
        double dB = downsampleStrategy.b(iFloor, iFloor2, i5, i6);
        options.inTargetDensity = a(dB);
        options.inDensity = l(dB);
        if (s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private qg2 e(c cVar, int i2, int i3, rx1 rx1Var, b bVar) {
        byte[] bArr = (byte[]) this.c.d(65536, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) rx1Var.a(f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) rx1Var.a(g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) rx1Var.a(DownsampleStrategy.h);
        boolean zBooleanValue = ((Boolean) rx1Var.a(i)).booleanValue();
        px1 px1Var = j;
        try {
            return qi.d(h(cVar, optionsK, downsampleStrategy, decodeFormat, preferredColorSpace, rx1Var.a(px1Var) != null && ((Boolean) rx1Var.a(px1Var)).booleanValue(), i2, i3, zBooleanValue, bVar), this.a);
        } finally {
            v(optionsK);
            this.c.put(bArr);
        }
    }

    private Bitmap h(c cVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z, int i2, int i3, boolean z2, b bVar) {
        int i4;
        int i5;
        int i6;
        String str;
        ColorSpace colorSpace;
        int iRound;
        int iRound2;
        long jB = cd1.b();
        int[] iArrM = m(cVar, options, bVar, this.a);
        int i7 = iArrM[0];
        int i8 = iArrM[1];
        String str2 = options.outMimeType;
        boolean z3 = (i7 == -1 || i8 == -1) ? false : z;
        int iA = cVar.a();
        int iG = b53.g(iA);
        boolean zJ = b53.j(iA);
        if (i2 == Integer.MIN_VALUE) {
            i4 = i3;
            i5 = r(iG) ? i8 : i7;
        } else {
            i4 = i3;
            i5 = i2;
        }
        if (i4 == Integer.MIN_VALUE) {
            i6 = r(iG) ? i7 : i8;
        } else {
            i6 = i4;
        }
        ImageHeaderParser.ImageType imageTypeD = cVar.d();
        c(imageTypeD, cVar, bVar, this.a, downsampleStrategy, iG, i7, i8, i5, i6, options);
        b(cVar, decodeFormat, z3, zJ, options, i5, i6);
        int i9 = Build.VERSION.SDK_INT;
        if (z(imageTypeD)) {
            if (i7 < 0 || i8 < 0 || !z2) {
                float f2 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i10 = options.inSampleSize;
                float f3 = i10;
                int iCeil = (int) Math.ceil(i7 / f3);
                int iCeil2 = (int) Math.ceil(i8 / f3);
                iRound = Math.round(iCeil * f2);
                iRound2 = Math.round(iCeil2 * f2);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i7 + "x" + i8 + "], sampleSize: " + i10 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                }
            } else {
                str = "Downsampler";
                iRound = i5;
                iRound2 = i6;
            }
            if (iRound > 0 && iRound2 > 0) {
                y(options, this.a, iRound, iRound2);
            }
        } else {
            str = "Downsampler";
        }
        if (i9 >= 28) {
            options.inPreferredColorSpace = ColorSpace.get((preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap bitmapI = i(cVar, options, bVar, this.a);
        bVar.b(this.a, bitmapI);
        if (Log.isLoggable(str, 2)) {
            t(i7, i8, str2, options, bitmapI, i2, i3, jB);
        }
        if (bitmapI == null) {
            return null;
        }
        bitmapI.setDensity(this.b.densityDpi);
        Bitmap bitmapK = b53.k(this.a, bitmapI, iA);
        if (bitmapI.equals(bitmapK)) {
            return bitmapK;
        }
        this.a.c(bitmapI);
        return bitmapK;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.c r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.a.b r7, defpackage.oi r8) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.a()
            r5.c()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = defpackage.b53.f()
            r4.lock()
            android.graphics.Bitmap r5 = r5.b(r6)     // Catch: java.lang.Throwable -> L25 java.lang.IllegalArgumentException -> L27
            java.util.concurrent.locks.Lock r6 = defpackage.b53.f()
            r6.unlock()
            return r5
        L25:
            r5 = move-exception
            goto L50
        L27:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L25
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L38
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L25
        L38:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L4f
            r8.c(r0)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            r0 = 0
            r6.inBitmap = r0     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            java.util.concurrent.locks.Lock r6 = defpackage.b53.f()
            r6.unlock()
            return r5
        L4e:
            throw r1     // Catch: java.lang.Throwable -> L25
        L4f:
            throw r1     // Catch: java.lang.Throwable -> L25
        L50:
            java.util.concurrent.locks.Lock r6 = defpackage.b53.f()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.a.i(com.bumptech.glide.load.resource.bitmap.c, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.a$b, oi):android.graphics.Bitmap");
    }

    private static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options options;
        Queue queue = n;
        synchronized (queue) {
            options = (BitmapFactory.Options) queue.poll();
        }
        if (options == null) {
            options = new BitmapFactory.Options();
            w(options);
        }
        return options;
    }

    private static int l(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int[] m(c cVar, BitmapFactory.Options options, b bVar, oi oiVar) {
        options.inJustDecodeBounds = true;
        i(cVar, options, bVar, oiVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    private static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + cd1.a(j2));
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    private static void v(BitmapFactory.Options options) {
        w(options);
        Queue queue = n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int x(double d) {
        return (int) (d + 0.5d);
    }

    private static void y(BitmapFactory.Options options, oi oiVar, int i2, int i3) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = oiVar.e(i2, i3, config);
    }

    private boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public qg2 d(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, rx1 rx1Var) {
        return e(new c.b(parcelFileDescriptor, this.d, this.c), i2, i3, rx1Var, l);
    }

    public qg2 f(InputStream inputStream, int i2, int i3, rx1 rx1Var) {
        return g(inputStream, i2, i3, rx1Var, l);
    }

    public qg2 g(InputStream inputStream, int i2, int i3, rx1 rx1Var, b bVar) {
        return e(new c.a(inputStream, this.d, this.c), i2, i3, rx1Var, bVar);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}
