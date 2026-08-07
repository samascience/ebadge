package defpackage;

import androidx.camera.core.impl.CameraCaptureFailure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class bs {

    public static final class a extends as {
        private final List a = new ArrayList();

        a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                as asVar = (as) it.next();
                if (!(asVar instanceof b)) {
                    this.a.add(asVar);
                }
            }
        }

        @Override // defpackage.as
        public void a(int i) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((as) it.next()).a(i);
            }
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((as) it.next()).b(i, csVar);
            }
        }

        @Override // defpackage.as
        public void c(int i, CameraCaptureFailure cameraCaptureFailure) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((as) it.next()).c(i, cameraCaptureFailure);
            }
        }

        @Override // defpackage.as
        public void d(int i) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((as) it.next()).d(i);
            }
        }

        public List e() {
            return this.a;
        }
    }

    static final class b extends as {
        b() {
        }

        @Override // defpackage.as
        public void b(int i, cs csVar) {
        }

        @Override // defpackage.as
        public void c(int i, CameraCaptureFailure cameraCaptureFailure) {
        }

        @Override // defpackage.as
        public void d(int i) {
        }
    }

    static as a(List list) {
        if (list.isEmpty()) {
            return c();
        }
        return list.size() == 1 ? (as) list.get(0) : new a(list);
    }

    public static as b(as... asVarArr) {
        return a(Arrays.asList(asVarArr));
    }

    public static as c() {
        return new b();
    }
}
