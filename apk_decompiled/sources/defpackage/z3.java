package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class z3 extends y3 {
    private static final SparseIntArray L;
    private final x11 I;
    private final LinearLayout J;
    private long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.edt_email_addr, 2);
        sparseIntArray.put(R.id.edt_pwd, 3);
        sparseIntArray.put(R.id.edt_pwd_agin, 4);
        sparseIntArray.put(R.id.btn_register, 5);
    }

    public z3(w50 w50Var, View view) {
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

    private z3(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (AppCompatButton) objArr[5], (EditText) objArr[2], (EditText) objArr[3], (EditText) objArr[4]);
        this.K = -1L;
        Object obj = objArr[1];
        this.I = obj != null ? x11.bind((View) obj) : null;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.J = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
