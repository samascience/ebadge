package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class cq0 extends bq0 {
    private static final SparseIntArray H;
    private final LinearLayout F;
    private long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R.id.calendar, 1);
    }

    public cq0(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 2, null, H));
    }

    public void K() {
        synchronized (this) {
            this.G = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.G = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.G != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private cq0(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (CalendarView) objArr[1]);
        this.G = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.F = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
