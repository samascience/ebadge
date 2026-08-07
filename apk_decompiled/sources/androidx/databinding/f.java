package androidx.databinding;

import defpackage.j42;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {
    private static final j42 f = new j42(10);
    private static final c.a g = new a();

    class a extends c.a {
        a() {
        }

        @Override // androidx.databinding.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(h.a aVar, h hVar, int i, b bVar) {
            if (i == 1) {
                aVar.c(hVar, bVar.a, bVar.b);
                return;
            }
            if (i == 2) {
                aVar.d(hVar, bVar.a, bVar.b);
                return;
            }
            if (i == 3) {
                aVar.e(hVar, bVar.a, bVar.c, bVar.b);
            } else if (i != 4) {
                aVar.b(hVar);
            } else {
                aVar.f(hVar, bVar.a, bVar.b);
            }
        }
    }

    static class b {
        public int a;
        public int b;
        public int c;

        b() {
        }
    }

    public f() {
        super(g);
    }

    private static b l(int i, int i2, int i3) {
        b bVar = (b) f.b();
        if (bVar == null) {
            bVar = new b();
        }
        bVar.a = i;
        bVar.c = i2;
        bVar.b = i3;
        return bVar;
    }

    @Override // androidx.databinding.c
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public synchronized void d(h hVar, int i, b bVar) {
        super.d(hVar, i, bVar);
        if (bVar != null) {
            f.a(bVar);
        }
    }

    public void o(h hVar, int i, int i2) {
        d(hVar, 1, l(i, 0, i2));
    }

    public void p(h hVar, int i, int i2) {
        d(hVar, 2, l(i, 0, i2));
    }

    public void q(h hVar, int i, int i2) {
        d(hVar, 4, l(i, 0, i2));
    }
}
