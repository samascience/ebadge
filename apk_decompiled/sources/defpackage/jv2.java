package defpackage;

import android.os.Build;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
public class jv2 implements v92 {
    private static boolean g() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto e5 play".equalsIgnoreCase(Build.MODEL);
    }

    static boolean h() {
        return g();
    }

    public Size f(int i) {
        if (i == 4) {
            return new Size(640, 480);
        }
        if (i == 5) {
            return new Size(960, 720);
        }
        if (i != 6) {
            return null;
        }
        return new Size(1440, 1080);
    }
}
