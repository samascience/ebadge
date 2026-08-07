package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class cb0 {
    public static final cb0 a = new cb0();

    private cb0() {
    }

    public final String a(long j) {
        if (j >= 1073741824) {
            lv2 lv2Var = lv2.a;
            String str = String.format(Locale.getDefault(), "%.2f GB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1.073741824E9d)}, 1));
            p31.e(str, "format(...)");
            return str;
        }
        if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            lv2 lv2Var2 = lv2.a;
            String str2 = String.format(Locale.getDefault(), "%.2f MB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576.0d)}, 1));
            p31.e(str2, "format(...)");
            return str2;
        }
        if (j >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            lv2 lv2Var3 = lv2.a;
            String str3 = String.format(Locale.getDefault(), "%.2f KB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024.0d)}, 1));
            p31.e(str3, "format(...)");
            return str3;
        }
        return j + " B";
    }

    public final long b(long j) {
        return (j <= 0 || j < 5120) ? j : j - 5120;
    }
}
