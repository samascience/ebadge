package defpackage;

import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s11 {
    public static void a(AppCompatActivity appCompatActivity, int i, int i2, boolean z) {
        b(appCompatActivity, false, false, i, i2, z);
    }

    public static void b(AppCompatActivity appCompatActivity, boolean z, boolean z2, int i, int i2, boolean z3) {
        try {
            Window window = appCompatActivity.getWindow();
            boolean z4 = true;
            if (z && z2) {
                window.clearFlags(201326592);
                gb1.d(appCompatActivity, true, true, i == 0, z3);
                window.addFlags(Integer.MIN_VALUE);
            } else if (!z && !z2) {
                window.requestFeature(1);
                window.clearFlags(201326592);
                if (i != 0) {
                    z4 = false;
                }
                gb1.d(appCompatActivity, false, false, z4, z3);
                window.addFlags(Integer.MIN_VALUE);
            } else {
                if (z) {
                    return;
                }
                window.requestFeature(1);
                window.clearFlags(201326592);
                gb1.d(appCompatActivity, false, true, i == 0, z3);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setStatusBarColor(i);
            window.setNavigationBarColor(i2);
        } catch (Exception unused) {
        }
    }
}
