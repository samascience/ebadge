package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zx {
    protected final zx a;
    protected final Class b;
    private ArrayList c;

    public zx(Class cls) {
        this(null, cls);
    }

    public void a(mg2 mg2Var) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(mg2Var);
    }

    public zx b(Class cls) {
        return new zx(this, cls);
    }

    public zx c(Class cls) {
        if (this.b == cls) {
            return this;
        }
        for (zx zxVar = this.a; zxVar != null; zxVar = zxVar.a) {
            if (zxVar.b == cls) {
                return zxVar;
            }
        }
        return null;
    }

    public void d(og2 og2Var) {
        ArrayList arrayList = this.c;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((mg2) it.next()).n(og2Var);
            }
        }
    }

    private zx(zx zxVar, Class cls) {
        this.a = zxVar;
        this.b = cls;
    }
}
