package defpackage;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.util.Range;

/* JADX INFO: loaded from: classes.dex */
public abstract class t7 {
    public static Range<Integer>[] a(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getInputChannelCountRanges();
    }

    public static int b(MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getMinInputChannelCount();
    }

    public static void c(AudioRecord.Builder builder, Context context) {
        builder.setContext(context);
    }
}
