package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class b3 extends a3 {
    private static final SparseIntArray K;
    private final x11 H;
    private final LinearLayout I;
    private long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R.id.tv_device_factory_name, 2);
        sparseIntArray.put(R.id.tabLayout, 3);
        sparseIntArray.put(R.id.viewPager, 4);
    }

    public b3(w50 w50Var, View view) {
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

    private b3(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (TabLayout) objArr[3], (TextView) objArr[2], (ViewPager) objArr[4]);
        this.J = -1L;
        Object obj = objArr[1];
        this.H = obj != null ? x11.bind((View) obj) : null;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.I = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
