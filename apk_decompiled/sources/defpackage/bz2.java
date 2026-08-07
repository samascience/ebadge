package defpackage;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.config.PictureSelectionConfig;

/* JADX INFO: loaded from: classes3.dex */
public class bz2 {
    private final PictureSelectionConfig a;
    private final v22 b;

    public bz2(v22 v22Var, int i) {
        this.b = v22Var;
        PictureSelectionConfig pictureSelectionConfigB = PictureSelectionConfig.b();
        this.a = pictureSelectionConfigB;
        pictureSelectionConfigB.a = i;
        pictureSelectionConfigB.q1 = true;
        pictureSelectionConfigB.v = 1;
        pictureSelectionConfigB.w = 9;
    }

    private String c() {
        if (this.a.a == a22.w()) {
            return "image/*";
        }
        if (this.a.a == a22.y()) {
            return "video/*";
        }
        return this.a.a == a22.t() ? "audio/*" : "image/*";
    }

    public bz2 a(int i) {
        this.a.R = i;
        return this;
    }

    public void b(int i) {
        Activity activityC;
        if (wc0.a() || (activityC = this.b.c()) == null || this.a == null) {
            return;
        }
        PictureSelectionConfig pictureSelectionConfigC = PictureSelectionConfig.c();
        PictureSelectionConfig pictureSelectionConfig = this.a;
        pictureSelectionConfigC.o0 = pictureSelectionConfig.o0;
        pictureSelectionConfigC.b0 = pictureSelectionConfig.b0;
        pictureSelectionConfigC.N = pictureSelectionConfig.N;
        pictureSelectionConfigC.O = pictureSelectionConfig.O;
        pictureSelectionConfigC.P = pictureSelectionConfig.P;
        pictureSelectionConfigC.Q = pictureSelectionConfig.Q;
        pictureSelectionConfigC.R = pictureSelectionConfig.R;
        pictureSelectionConfigC.L = pictureSelectionConfig.L;
        pictureSelectionConfigC.G = pictureSelectionConfig.G;
        pictureSelectionConfigC.p0 = pictureSelectionConfig.p0;
        pictureSelectionConfigC.w0 = pictureSelectionConfig.w0;
        pictureSelectionConfigC.x0 = pictureSelectionConfig.x0;
        pictureSelectionConfigC.y0 = pictureSelectionConfig.y0;
        pictureSelectionConfigC.z0 = pictureSelectionConfig.z0;
        pictureSelectionConfigC.A0 = pictureSelectionConfig.A0;
        pictureSelectionConfigC.a = pictureSelectionConfig.a;
        pictureSelectionConfigC.q1 = pictureSelectionConfig.q1;
        pictureSelectionConfigC.v = pictureSelectionConfig.v;
        pictureSelectionConfigC.w = pictureSelectionConfig.w;
        Intent intentA = cz2.a(c(), pictureSelectionConfig.v == 2);
        if (intentA == null) {
            return;
        }
        this.a.h1 = false;
        Fragment fragmentD = this.b.d();
        if (fragmentD != null) {
            fragmentD.startActivityForResult(intentA, i);
        } else {
            activityC.startActivityForResult(intentA, i);
        }
    }

    public bz2 d(boolean z) {
        this.a.b0 = z;
        return this;
    }

    public bz2 e(int i) {
        this.a.L = i;
        return this;
    }

    public bz2 f(int i) {
        this.a.v = i;
        return this;
    }
}
