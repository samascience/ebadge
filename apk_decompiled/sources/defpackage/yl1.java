package defpackage;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class yl1 implements rk1 {
    private final List a;
    private final h42 b;

    static class a implements y50, y50.a {
        private final List a;
        private final h42 b;
        private int c;
        private Priority d;
        private y50.a e;
        private List f;
        private boolean g;

        a(List list, h42 h42Var) {
            this.b = h42Var;
            z42.c(list);
            this.a = list;
            this.c = 0;
        }

        private void g() {
            if (this.g) {
                return;
            }
            if (this.c < this.a.size() - 1) {
                this.c++;
                e(this.d, this.e);
            } else {
                z42.d(this.f);
                this.e.c(new GlideException("Fetch failed", new ArrayList(this.f)));
            }
        }

        @Override // defpackage.y50
        public Class a() {
            return ((y50) this.a.get(0)).a();
        }

        @Override // defpackage.y50
        public void b() {
            List list = this.f;
            if (list != null) {
                this.b.a(list);
            }
            this.f = null;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((y50) it.next()).b();
            }
        }

        @Override // y50.a
        public void c(Exception exc) {
            ((List) z42.d(this.f)).add(exc);
            g();
        }

        @Override // defpackage.y50
        public void cancel() {
            this.g = true;
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((y50) it.next()).cancel();
            }
        }

        @Override // defpackage.y50
        public DataSource d() {
            return ((y50) this.a.get(0)).d();
        }

        @Override // defpackage.y50
        public void e(Priority priority, y50.a aVar) {
            this.d = priority;
            this.e = aVar;
            this.f = (List) this.b.b();
            ((y50) this.a.get(this.c)).e(priority, this);
            if (this.g) {
                cancel();
            }
        }

        @Override // y50.a
        public void f(Object obj) {
            if (obj != null) {
                this.e.f(obj);
            } else {
                g();
            }
        }
    }

    yl1(List list, h42 h42Var) {
        this.a = list;
        this.b = h42Var;
    }

    @Override // defpackage.rk1
    public boolean a(Object obj) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((rk1) it.next()).a(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.rk1
    public rk1.a b(Object obj, int i, int i2, rx1 rx1Var) {
        rk1.a aVarB;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        w81 w81Var = null;
        for (int i3 = 0; i3 < size; i3++) {
            rk1 rk1Var = (rk1) this.a.get(i3);
            if (rk1Var.a(obj) && (aVarB = rk1Var.b(obj, i, i2, rx1Var)) != null) {
                w81Var = aVarB.a;
                arrayList.add(aVarB.c);
            }
        }
        if (arrayList.isEmpty() || w81Var == null) {
            return null;
        }
        return new rk1.a(w81Var, new a(arrayList, this.b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.a.toArray()) + '}';
    }
}
