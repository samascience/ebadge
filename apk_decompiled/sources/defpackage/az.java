package defpackage;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.util.LruCache;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class az {
    private static final LruCache a = new LruCache(10);

    public static MediaCodec a(hg0 hg0Var) {
        return b(hg0Var.c());
    }

    private static MediaCodec b(String str) throws InvalidConfigException {
        try {
            return MediaCodec.createEncoderByType(str);
        } catch (IOException | IllegalArgumentException e) {
            throw new InvalidConfigException(e);
        }
    }

    public static MediaCodecInfo c(hg0 hg0Var) throws Throwable {
        MediaCodecInfo mediaCodecInfo;
        MediaCodec mediaCodecB;
        String strC = hg0Var.c();
        LruCache lruCache = a;
        synchronized (lruCache) {
            mediaCodecInfo = (MediaCodecInfo) lruCache.get(strC);
        }
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        try {
            mediaCodecB = b(strC);
            try {
                MediaCodecInfo codecInfo = mediaCodecB.getCodecInfo();
                synchronized (lruCache) {
                    lruCache.put(strC, codecInfo);
                }
                mediaCodecB.release();
                return codecInfo;
            } catch (Throwable th) {
                th = th;
                if (mediaCodecB != null) {
                    mediaCodecB.release();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            mediaCodecB = null;
        }
    }
}
