package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: loaded from: classes4.dex */
public class q4 extends p4 {
    private static final SparseIntArray G = null;
    private long F;
    private final RelativeLayout z;

    public q4(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 1, null, G));
    }

    public void K() {
        synchronized (this) {
            this.F = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.F = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.F != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private q4(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0);
        this.F = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.z = relativeLayout;
        relativeLayout.setTag(null);
        B(view);
        K();
    }
}
