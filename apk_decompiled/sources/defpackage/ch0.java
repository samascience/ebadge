package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ch0 implements v92 {
    private static final List a = Arrays.asList("SM-N9208", "SM-G920V");

    static boolean f() {
        return a.contains(Build.MODEL.toUpperCase());
    }
}
