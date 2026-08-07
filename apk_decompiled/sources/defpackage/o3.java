package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.view.MyViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class o3 extends n3 {
    private static final SparseIntArray L;
    private final ScrollView H;
    private final LinearLayout I;
    private final w11 J;
    private long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.tv_skip, 3);
        sparseIntArray.put(R.id.tabLayout, 4);
        sparseIntArray.put(R.id.viewPager, 5);
    }

    public o3(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 6, null, L));
    }

    public void K() {
        synchronized (this) {
            this.K = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.K = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.K != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private o3(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (TabLayout) objArr[4], (TextView) objArr[3], (MyViewPager) objArr[5]);
        this.K = -1L;
        ScrollView scrollView = (ScrollView) objArr[0];
        this.H = scrollView;
        scrollView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.I = linearLayout;
        linearLayout.setTag(null);
        Object obj = objArr[2];
        this.J = obj != null ? w11.bind((View) obj) : null;
        B(view);
        K();
    }
}
