package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class x2 extends w2 {
    private static final SparseIntArray O;
    private final x11 M;
    private long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R.id.tv_version, 2);
        sparseIntArray.put(R.id.img_qrcode, 3);
        sparseIntArray.put(R.id.btn_share, 4);
        sparseIntArray.put(R.id.tv_link_privacy_policy, 5);
        sparseIntArray.put(R.id.tv_link_user_protocol, 6);
        sparseIntArray.put(R.id.tv_link_open_sourece_protcol, 7);
        sparseIntArray.put(R.id.tv_icp, 8);
    }

    public x2(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 9, null, O));
    }

    public void K() {
        synchronized (this) {
            this.N = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.N = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.N != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private x2(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (AppCompatButton) objArr[4], (ImageView) objArr[3], (LinearLayout) objArr[0], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[2]);
        this.N = -1L;
        this.G.setTag(null);
        Object obj = objArr[1];
        this.M = obj != null ? x11.bind((View) obj) : null;
        B(view);
        K();
    }
}
