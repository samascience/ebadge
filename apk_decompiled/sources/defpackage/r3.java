package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class r3 extends q3 {
    private static final SparseIntArray P;
    private final LinearLayout N;
    private long O;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.put(R.id.title_chunk, 1);
        sparseIntArray.put(R.id.rlv, 2);
        sparseIntArray.put(R.id.hand_lr_box, 3);
        sparseIntArray.put(R.id.hand_Left, 4);
        sparseIntArray.put(R.id.labhandName, 5);
        sparseIntArray.put(R.id.hand_status, 6);
        sparseIntArray.put(R.id.hndline, 7);
        sparseIntArray.put(R.id.frm_loadding, 8);
        sparseIntArray.put(R.id.progressBar3, 9);
    }

    public r3(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 10, null, P));
    }

    public void K() {
        synchronized (this) {
            this.O = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.O = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.O != 0;
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
    private r3(w50 w50Var, View view, Object[] objArr) {
        FrameLayout frameLayout = (FrameLayout) objArr[8];
        ImageView imageView = (ImageView) objArr[4];
        RelativeLayout relativeLayout = (RelativeLayout) objArr[3];
        Switch r7 = (Switch) objArr[6];
        View view2 = (View) objArr[7];
        TextView textView = (TextView) objArr[5];
        ProgressBar progressBar = (ProgressBar) objArr[9];
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        Object obj = objArr[1];
        super(w50Var, view, 0, frameLayout, imageView, relativeLayout, r7, view2, textView, progressBar, recyclerView, obj != null ? m33.bind((View) obj) : null);
        this.O = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.N = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
