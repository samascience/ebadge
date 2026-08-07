package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class xp0 extends wp0 {
    private static final SparseIntArray L;
    private final LinearLayout J;
    private long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.title, 1);
        sparseIntArray.put(R.id.image, 2);
        sparseIntArray.put(R.id.edit, 3);
        sparseIntArray.put(R.id.tv_cancel, 4);
        sparseIntArray.put(R.id.tv_confirm, 5);
    }

    public xp0(w50 w50Var, View view) {
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

    private xp0(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (AppCompatEditText) objArr[3], (ImageView) objArr[2], (TextView) objArr[1], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[5]);
        this.K = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.J = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
