package defpackage;

import android.os.Build;
import androidx.camera.video.s;

/* JADX INFO: loaded from: classes.dex */
public class nc3 implements pd3 {
    private static boolean f() {
        return "positivo".equalsIgnoreCase(Build.BRAND) && "twist 2 pro".equalsIgnoreCase(Build.MODEL);
    }

    static boolean g() {
        return f();
    }

    @Override // defpackage.pd3
    public boolean a() {
        return false;
    }

    @Override // defpackage.pd3
    public boolean c(zt ztVar, s sVar) {
        return f() && ztVar.f() == 0 && sVar == s.a;
    }
}
