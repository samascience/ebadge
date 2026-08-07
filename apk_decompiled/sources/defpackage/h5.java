package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
public class h5 {
    private i5 a;
    private Window b;
    private sb0 c;

    public static class a {
        public Context a;
        public int b;
        public boolean c;
        public DialogInterface.OnCancelListener d;
        public DialogInterface.OnDismissListener e;
        public DialogInterface.OnKeyListener f;
        public int m;
        public View n;
        public int o;
        public int p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f342q;
        public int r;
        public int s;
        public SparseArray g = new SparseArray();
        public SparseArray h = new SparseArray();
        public SparseArray i = new SparseArray();
        public SparseArray j = new SparseArray();
        public SparseArray k = new SparseArray();
        public SparseArray l = new SparseArray();
        public int t = 17;

        public a(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        public void a(h5 h5Var) {
            int i = this.m;
            sb0 sb0Var = i != 0 ? new sb0(this.a, i) : null;
            if (this.n != null) {
                sb0Var = new sb0();
                sb0Var.c(this.n);
            }
            if (sb0Var == null) {
                throw new IllegalArgumentException("please set layout");
            }
            h5Var.a().setContentView(sb0Var.a());
            h5Var.c(sb0Var);
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                h5Var.f(this.h.keyAt(i2), (CharSequence) this.h.valueAt(i2));
            }
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                h5Var.d(this.k.keyAt(i3), ((Integer) this.k.valueAt(i3)).intValue());
            }
            for (int i4 = 0; i4 < this.i.size(); i4++) {
                h5Var.e(this.i.keyAt(i4), (View.OnClickListener) this.i.valueAt(i4));
            }
            Window windowB = h5Var.b();
            windowB.setGravity(this.t);
            int i5 = this.s;
            if (i5 != 0) {
                windowB.setWindowAnimations(i5);
            }
            WindowManager.LayoutParams attributes = windowB.getAttributes();
            attributes.width = this.o;
            attributes.height = this.p;
            attributes.verticalMargin = this.f342q;
            attributes.horizontalMargin = this.r;
            windowB.setAttributes(attributes);
        }
    }

    public h5(i5 i5Var, Window window) {
        this.a = i5Var;
        this.b = window;
    }

    public i5 a() {
        return this.a;
    }

    public Window b() {
        return this.b;
    }

    public void c(sb0 sb0Var) {
        this.c = sb0Var;
    }

    public void d(int i, int i2) {
        this.c.d(i, i2);
    }

    public void e(int i, View.OnClickListener onClickListener) {
        this.c.e(i, onClickListener);
    }

    public void f(int i, CharSequence charSequence) {
        this.c.f(i, charSequence);
    }
}
