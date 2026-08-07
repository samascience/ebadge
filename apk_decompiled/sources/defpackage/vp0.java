package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class vp0 extends up0 {
    private static final SparseIntArray K;
    private final LinearLayout I;
    private long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R.id.title, 1);
        sparseIntArray.put(R.id.rad_grp, 2);
        sparseIntArray.put(R.id.rad1, 3);
        sparseIntArray.put(R.id.rad2, 4);
    }

    public vp0(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 5, null, K));
    }

    public void K() {
        synchronized (this) {
            this.J = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.J = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.J != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private vp0(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (RadioButton) objArr[3], (RadioButton) objArr[4], (RadioGroup) objArr[2], (TextView) objArr[1]);
        this.J = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.I = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
