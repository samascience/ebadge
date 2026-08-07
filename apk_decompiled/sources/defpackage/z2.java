package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class z2 extends y2 {
    private static final SparseIntArray J;
    private final LinearLayout H;
    private long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J = sparseIntArray;
        sparseIntArray.put(R.id.app_instructions_title, 1);
        sparseIntArray.put(R.id.app_instructions_webView, 2);
        sparseIntArray.put(R.id.no_instructions_textView, 3);
    }

    public z2(w50 w50Var, View view) {
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
    private z2(w50 w50Var, View view, Object[] objArr) {
        Object obj = objArr[1];
        super(w50Var, view, 0, obj != null ? x11.bind((View) obj) : null, (WebView) objArr[2], (TextView) objArr[3]);
        this.I = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.H = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
