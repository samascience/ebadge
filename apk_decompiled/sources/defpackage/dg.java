package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dg {

    public static final class a implements cg.b {
        final /* synthetic */ pr0 a;

        a(pr0 pr0Var) {
            this.a = pr0Var;
        }

        @Override // cg.b
        public void a(Object obj, int i, View view) {
            p31.f(view, "view");
            this.a.invoke(obj, Integer.valueOf(i), view);
        }
    }

    public static final void a(cg cgVar, pr0 pr0Var) {
        p31.f(cgVar, "<this>");
        p31.f(pr0Var, "action");
        cgVar.h(new a(pr0Var));
    }
}
