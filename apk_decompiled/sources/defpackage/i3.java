package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class i3 extends h3 {
    private static final SparseIntArray K;
    private final ScrollView I;
    private long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R.id.btn_get_dial_remain_space, 1);
        sparseIntArray.put(R.id.tv_remain_space_result, 2);
        sparseIntArray.put(R.id.btn_push_latest_image, 3);
        sparseIntArray.put(R.id.tv_image_push_result, 4);
    }

    public i3(w50 w50Var, View view) {
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

    private i3(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (Button) objArr[1], (Button) objArr[3], (TextView) objArr[4], (TextView) objArr[2]);
        this.J = -1L;
        ScrollView scrollView = (ScrollView) objArr[0];
        this.I = scrollView;
        scrollView.setTag(null);
        B(view);
        K();
    }
}
