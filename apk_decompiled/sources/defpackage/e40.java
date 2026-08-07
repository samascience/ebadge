package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class e40 {
    public static byte a(long j) {
        return (byte) (j & 255);
    }

    public static byte b(long j) {
        return (byte) ((j >> 8) & 255);
    }

    public static byte c(long j) {
        return (byte) ((j >> 16) & 255);
    }

    public static byte d(long j) {
        return (byte) (j >> 24);
    }

    public static long e(byte b, byte b2) {
        if ((b & 128) == 0) {
            return (((long) b2) & 255) | (((long) b) << 8);
        }
        return ((long) (b2 & 255)) | ((((long) b) & 127) << 8) | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
    }

    public static long f(byte b, byte b2, byte b3, byte b4) {
        long j;
        long j2;
        if ((b & 128) == 0) {
            j = (((long) (b2 & 255)) << 16) | (((long) (b & 255)) << 24) | (((long) (b3 & 255)) << 8);
            j2 = ((long) b4) & 255;
        } else {
            j = (((long) (b2 & 255)) << 16) | ((((long) b) & 127) << 24) | (((long) (b3 & 255)) << 8) | ((long) (b4 & 255));
            j2 = -2147483648L;
        }
        return j | j2;
    }

    public static byte g(long j) {
        return (byte) (j >> 8);
    }

    public static byte h(long j) {
        return (byte) (j & 255);
    }
}
