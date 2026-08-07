package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class se1 implements v92 {
    private static final Set a = new HashSet(Arrays.asList("SM-A520W", "MOTOG3"));

    static boolean f() {
        return a.contains(Build.MODEL.toUpperCase(Locale.US));
    }
}
