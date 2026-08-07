package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class k4 extends j4 {
    private static final SparseIntArray I;
    private final LinearLayout G;
    private long H;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R.id.title_bar, 1);
        sparseIntArray.put(R.id.contract_list, 2);
    }

    public k4(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 3, null, I));
    }

    public void K() {
        synchronized (this) {
            this.H = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.H = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.H != 0;
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
    private k4(w50 w50Var, View view, Object[] objArr) {
        SwipeMenuRecyclerView swipeMenuRecyclerView = (SwipeMenuRecyclerView) objArr[2];
        Object obj = objArr[1];
        super(w50Var, view, 0, swipeMenuRecyclerView, obj != null ? x11.bind((View) obj) : null);
        this.H = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.G = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
