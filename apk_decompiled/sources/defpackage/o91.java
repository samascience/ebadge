package defpackage;

import android.util.Log;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class o91 {
    public static boolean a = false;
    private static String[] d;
    private static long[] e;
    private static final Set b = new HashSet();
    private static boolean c = false;
    private static int f = 0;
    private static int g = 0;

    public static void a(String str) {
        if (c) {
            int i = f;
            if (i == 20) {
                g++;
                return;
            }
            d[i] = str;
            e[i] = System.nanoTime();
            o43.a(str);
            f++;
        }
    }

    public static void b(String str) {
        if (a) {
            Log.d("LOTTIE", str);
        }
    }

    public static float c(String str) {
        int i = g;
        if (i > 0) {
            g = i - 1;
            return 0.0f;
        }
        if (!c) {
            return 0.0f;
        }
        int i2 = f - 1;
        f = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(d[i2])) {
            o43.b();
            return (System.nanoTime() - e[f]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + d[f] + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public static void d(String str) {
        Set set = b;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        set.add(str);
    }
}
