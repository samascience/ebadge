package defpackage;

import android.os.Build;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
public class tj0 implements v92 {
    private Size[] g() {
        return new Size[]{new Size(1440, 1080), new Size(960, 720)};
    }

    private static boolean h() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    static boolean i() {
        return h();
    }

    public Size[] f(int i) {
        return (i == 34 && h()) ? g() : new Size[0];
    }
}
