package defpackage;

import android.os.Build;
import androidx.camera.video.s;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class cf2 implements pd3 {
    private static boolean f() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "HMA-L29".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean g() {
        return "Huawei".equalsIgnoreCase(Build.BRAND) && "LYA-AL00".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean h() {
        return "Huawei".equalsIgnoreCase(Build.MANUFACTURER) && Arrays.asList("JNY-L21A", "JNY-L01A", "JNY-L21B", "JNY-L22A", "JNY-L02A", "JNY-L22B", "JNY-LX1").contains(Build.MODEL.toUpperCase(Locale.US));
    }

    private static boolean i() {
        return "OPPO".equalsIgnoreCase(Build.BRAND) && "PHT110".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean j() {
        return "Vivo".equalsIgnoreCase(Build.BRAND) && "vivo 1820".equalsIgnoreCase(Build.MODEL);
    }

    static boolean k() {
        return f() || g() || j() || h() || i();
    }

    @Override // defpackage.pd3
    public boolean a() {
        return f() || g() || h() || i();
    }

    @Override // defpackage.pd3
    public boolean c(zt ztVar, s sVar) {
        if (f() || g()) {
            return sVar == s.d;
        }
        if (j()) {
            return sVar == s.b || sVar == s.c;
        }
        if (h()) {
            return ztVar.f() == 0 && (sVar == s.c || sVar == s.b);
        }
        if (i()) {
            return ztVar.f() == 1 && sVar == s.d;
        }
        return false;
    }
}
