package defpackage;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class xr implements dh0 {
    private final boolean c;
    private final String d;
    private final int e;
    private final Map f = new HashMap();
    private final w92 g;

    static class a {
        static EncoderProfiles a(String str, int i) {
            return CamcorderProfile.getAll(str, i);
        }
    }

    public xr(String str, w92 w92Var) {
        boolean z;
        int i;
        this.d = str;
        try {
            i = Integer.parseInt(str);
            z = true;
        } catch (NumberFormatException unused) {
            x.k("Camera2EncoderProfilesProvider", "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
            z = false;
            i = -1;
        }
        this.c = z;
        this.e = i;
        this.g = w92Var;
    }

    private eh0 c(int i) {
        CamcorderProfile camcorderProfile;
        try {
            camcorderProfile = CamcorderProfile.get(this.e, i);
        } catch (RuntimeException e) {
            x.l("Camera2EncoderProfilesProvider", "Unable to get CamcorderProfile by quality: " + i, e);
            camcorderProfile = null;
        }
        if (camcorderProfile != null) {
            return fh0.a(camcorderProfile);
        }
        return null;
    }

    private eh0 d() {
        Iterator it = dh0.b.iterator();
        while (it.hasNext()) {
            eh0 eh0VarB = b(((Integer) it.next()).intValue());
            if (eh0VarB != null) {
                return eh0VarB;
            }
        }
        return null;
    }

    private eh0 e() {
        for (int size = dh0.b.size() - 1; size >= 0; size--) {
            eh0 eh0VarB = b(size);
            if (eh0VarB != null) {
                return eh0VarB;
            }
        }
        return null;
    }

    private eh0 f(int i) {
        if (Build.VERSION.SDK_INT >= 31) {
            EncoderProfiles encoderProfilesA = a.a(this.d, i);
            if (encoderProfilesA == null) {
                return null;
            }
            if (xa0.a(r31.class) != null) {
                x.a("Camera2EncoderProfilesProvider", "EncoderProfiles contains invalid video profiles, use CamcorderProfile to create EncoderProfilesProxy.");
            } else {
                try {
                    return fh0.b(encoderProfilesA);
                } catch (NullPointerException e) {
                    x.l("Camera2EncoderProfilesProvider", "Failed to create EncoderProfilesProxy, EncoderProfiles might  contain invalid video profiles. Use CamcorderProfile instead.", e);
                }
            }
        }
        return c(i);
    }

    private boolean g(eh0 eh0Var) {
        lq lqVar = (lq) this.g.b(lq.class);
        if (lqVar == null) {
            return true;
        }
        List listD = eh0Var.d();
        if (listD.isEmpty()) {
            return true;
        }
        eh0.c cVar = (eh0.c) listD.get(0);
        return lqVar.f().contains(new Size(cVar.k(), cVar.h()));
    }

    @Override // defpackage.dh0
    public boolean a(int i) {
        return this.c && b(i) != null;
    }

    @Override // defpackage.dh0
    public eh0 b(int i) {
        eh0 eh0VarE = null;
        if (!this.c || !CamcorderProfile.hasProfile(this.e, i)) {
            return null;
        }
        if (this.f.containsKey(Integer.valueOf(i))) {
            return (eh0) this.f.get(Integer.valueOf(i));
        }
        eh0 eh0VarF = f(i);
        if (eh0VarF == null || g(eh0VarF)) {
            eh0VarE = eh0VarF;
        } else if (i == 1) {
            eh0VarE = d();
        } else if (i == 0) {
            eh0VarE = e();
        }
        this.f.put(Integer.valueOf(i), eh0VarE);
        return eh0VarE;
    }
}
