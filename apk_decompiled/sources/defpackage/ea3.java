package defpackage;

import androidx.camera.core.x;

/* JADX INFO: loaded from: classes.dex */
public class ea3 {
    private final i43 a;

    public ea3(w92 w92Var) {
        this.a = (i43) w92Var.b(i43.class);
    }

    public boolean a() {
        i43 i43Var = this.a;
        boolean z = i43Var != null && i43Var.i();
        x.a("UseFlashModeTorchFor3aUpdate", "shouldUseFlashModeTorch: " + z);
        return z;
    }
}
