package defpackage;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.InitializationException;
import androidx.camera.core.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class pr implements gt {
    private final iu a;
    private int f = 0;
    private final Map c = new HashMap();
    private Set e = new HashSet();
    private final List b = new ArrayList();
    private List d = new ArrayList();

    public pr(iu iuVar) {
        this.a = iuVar;
        e();
    }

    private void e() {
        Set hashSet = new HashSet();
        try {
            hashSet = this.a.e();
        } catch (CameraAccessExceptionCompat unused) {
            x.c("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ArrayList arrayList = new ArrayList((Set) it.next());
            if (arrayList.size() >= 2) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                try {
                    if (xt.a(this.a, str) && xt.a(this.a, str2)) {
                        this.e.add(new HashSet(Arrays.asList(str, str2)));
                        if (!this.c.containsKey(str)) {
                            this.c.put(str, new ArrayList());
                        }
                        if (!this.c.containsKey(str2)) {
                            this.c.put(str2, new ArrayList());
                        }
                        ((List) this.c.get(str)).add((String) arrayList.get(1));
                        ((List) this.c.get(str2)).add((String) arrayList.get(0));
                    }
                } catch (InitializationException unused2) {
                    x.a("Camera2CameraCoordinator", "Concurrent camera id pair: (" + str + ", " + str2 + ") is not backward compatible");
                }
            }
        }
    }

    @Override // defpackage.gt
    public int a() {
        return this.f;
    }

    @Override // defpackage.gt
    public void b(gt.a aVar) {
        this.b.add(aVar);
    }

    @Override // defpackage.gt
    public String c(String str) {
        if (!this.c.containsKey(str)) {
            return null;
        }
        for (String str2 : (List) this.c.get(str)) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                if (str2.equals(rr.a((yt) it.next()).b())) {
                    return str2;
                }
            }
        }
        return null;
    }

    @Override // defpackage.gt
    public void d(int i) {
        if (i != this.f) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((gt.a) it.next()).a(this.f, i);
            }
        }
        if (this.f == 2 && i != 2) {
            this.d.clear();
        }
        this.f = i;
    }
}
