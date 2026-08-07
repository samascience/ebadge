package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class b51 implements xr2 {
    private static final Set a = new HashSet(Arrays.asList("heroqltevzw", "heroqltetmo", "k61v1_basic_ref"));

    static boolean f(zs zsVar) {
        return a.contains(Build.DEVICE.toLowerCase(Locale.US));
    }
}
