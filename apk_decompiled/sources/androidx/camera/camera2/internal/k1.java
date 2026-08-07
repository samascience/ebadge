package androidx.camera.camera2.internal;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig;
import defpackage.b52;
import defpackage.iu;
import defpackage.st;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class k1 implements st {
    private final Map a;
    private final d b;

    class a implements d {
        a() {
        }

        @Override // androidx.camera.camera2.internal.d
        public CamcorderProfile a(int i, int i2) {
            return CamcorderProfile.get(i, i2);
        }

        @Override // androidx.camera.camera2.internal.d
        public boolean b(int i, int i2) {
            return CamcorderProfile.hasProfile(i, i2);
        }
    }

    public k1(Context context, Object obj, Set set) {
        this(context, new a(), obj, set);
    }

    private void c(Context context, iu iuVar, Set set) {
        b52.g(context);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            this.a.put(str, new s2(context, str, iuVar, this.b));
        }
    }

    @Override // defpackage.st
    public Pair a(int i, String str, List list, Map map, boolean z) {
        b52.b(!map.isEmpty(), "No new use cases to be bound.");
        s2 s2Var = (s2) this.a.get(str);
        if (s2Var != null) {
            return s2Var.A(i, list, map, z);
        }
        throw new IllegalArgumentException("No such camera id in supported combination list: " + str);
    }

    @Override // defpackage.st
    public SurfaceConfig b(int i, String str, int i2, Size size) {
        s2 s2Var = (s2) this.a.get(str);
        if (s2Var != null) {
            return s2Var.M(i, i2, size);
        }
        return null;
    }

    k1(Context context, d dVar, Object obj, Set set) {
        this.a = new HashMap();
        b52.g(dVar);
        this.b = dVar;
        c(context, obj instanceof iu ? (iu) obj : iu.a(context), set);
    }
}
