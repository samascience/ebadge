package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.oi;
import defpackage.px1;
import defpackage.qg2;
import defpackage.qi;
import defpackage.rx1;
import defpackage.ug2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class VideoDecoder implements ug2 {
    public static final px1 d = px1.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final px1 e = px1.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    private static final e f = new e();
    private final f a;
    private final oi b;
    private final e c;

    private static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    class a implements px1.b {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // px1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    class b implements px1.b {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // px1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    private static final class c implements f {
        private c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    static final class d implements f {

        class a extends MediaDataSource {
            final /* synthetic */ ByteBuffer a;

            a(ByteBuffer byteBuffer) {
                this.a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.a.limit()) {
                    return -1;
                }
                this.a.position((int) j);
                int iMin = Math.min(i2, this.a.remaining());
                this.a.get(bArr, i, iMin);
                return iMin;
            }
        }

        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface f {
        void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj);
    }

    static final class g implements f {
        g() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    VideoDecoder(oi oiVar, f fVar) {
        this(oiVar, fVar, f);
    }

    public static ug2 c(oi oiVar) {
        return new VideoDecoder(oiVar, new c(null));
    }

    public static ug2 d(oi oiVar) {
        return new VideoDecoder(oiVar, new d());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmapG = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f) ? null : g(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        if (bitmapG == null) {
            bitmapG = f(mediaMetadataRetriever, j, i);
        }
        if (bitmapG != null) {
            return bitmapG;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fB = downsampleStrategy.b(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fB), Math.round(fB * i5));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static ug2 h(oi oiVar) {
        return new VideoDecoder(oiVar, new g());
    }

    @Override // defpackage.ug2
    public boolean a(Object obj, rx1 rx1Var) {
        return true;
    }

    @Override // defpackage.ug2
    public qg2 b(Object obj, int i, int i2, rx1 rx1Var) throws IOException {
        long jLongValue = ((Long) rx1Var.a(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) rx1Var.a(e);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) rx1Var.a(DownsampleStrategy.h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.c.a();
        try {
            this.a.a(mediaMetadataRetrieverA, obj);
            return qi.d(e(mediaMetadataRetrieverA, jLongValue, num.intValue(), i, i2, downsampleStrategy2), this.b);
        } finally {
            mediaMetadataRetrieverA.release();
        }
    }

    VideoDecoder(oi oiVar, f fVar, e eVar) {
        this.b = oiVar;
        this.a = fVar;
        this.c = eVar;
    }
}
