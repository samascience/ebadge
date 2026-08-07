package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class g62 implements v92 {
    private static final List a = Arrays.asList("sunfish", "bramble", "redfin", "barbet");

    static boolean f() {
        return "Google".equals(Build.MANUFACTURER) && a.contains(Build.DEVICE.toLowerCase(Locale.getDefault()));
    }
}
