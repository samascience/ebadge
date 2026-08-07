package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class wz0 implements v92 {
    public static final List a = Arrays.asList("Pixel 2", "Pixel 2 XL", "Pixel 3", "Pixel 3 XL");

    static boolean f() {
        return a.contains(Build.MODEL) && "Google".equals(Build.MANUFACTURER);
    }
}
