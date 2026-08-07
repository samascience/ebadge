package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class i4 extends h4 {
    private static final SparseIntArray J;
    private final ConstraintLayout H;
    private long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.search_bar, 2);
        sparseIntArray.put(R.id.language_recycler, 3);
    }

    public i4(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 4, null, J));
    }

    public void K() {
        synchronized (this) {
            this.I = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.I = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.I != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private i4(w50 w50Var, View view, Object[] objArr) {
        RecyclerView recyclerView = (RecyclerView) objArr[3];
        EditText editText = (EditText) objArr[2];
        Object obj = objArr[1];
        super(w50Var, view, 0, recyclerView, editText, obj != null ? x11.bind((View) obj) : null);
        this.I = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.H = constraintLayout;
        constraintLayout.setTag(null);
        B(view);
        K();
    }
}
