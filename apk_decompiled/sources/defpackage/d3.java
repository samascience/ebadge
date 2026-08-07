package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.ui.viewmodels.bluetooth.BluetoothScanViewModel;

/* JADX INFO: loaded from: classes4.dex */
public class d3 extends c3 {
    private static final SparseIntArray O;
    private final LinearLayout L;
    private final TextView M;
    private long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 4);
        sparseIntArray.put(R.id.lottieanimation_connecting, 5);
        sparseIntArray.put(R.id.connection_stocks, 6);
        sparseIntArray.put(R.id.rv_devices, 7);
    }

    public d3(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 8, null, O));
    }

    private boolean L(im1 im1Var, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N |= 2;
        }
        return true;
    }

    private boolean M(im1 im1Var, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N |= 1;
        }
        return true;
    }

    public void K() {
        synchronized (this) {
            this.N = 8L;
        }
        z();
    }

    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        long j;
        int i;
        int i2;
        String str;
        int i3;
        im1 im1VarF;
        BluetoothScanViewModel.ConnectionState connectionStateD;
        synchronized (this) {
            j = this.N;
            this.N = 0L;
        }
        BluetoothScanViewModel bluetoothScanViewModel = this.K;
        int i4 = 0;
        if ((15 & j) != 0) {
            long j2 = j & 14;
            if (j2 != 0) {
                if (bluetoothScanViewModel != null) {
                    connectionStateD = bluetoothScanViewModel.D();
                    im1VarF = bluetoothScanViewModel.F();
                } else {
                    im1VarF = null;
                    connectionStateD = null;
                }
                F(1, im1VarF);
                boolean z = (im1VarF != null ? (BluetoothScanViewModel.ConnectionState) im1VarF.f() : null) == connectionStateD;
                if (j2 != 0) {
                    j |= z ? 544L : 272L;
                }
                i2 = z ? 8 : 0;
                i3 = z ? 0 : 8;
            } else {
                i2 = 0;
                i3 = 0;
            }
            long j3 = j & 13;
            if (j3 != 0) {
                im1 im1VarI = bluetoothScanViewModel != null ? bluetoothScanViewModel.I() : null;
                F(0, im1VarI);
                String str2 = im1VarI != null ? (String) im1VarI.f() : null;
                boolean z2 = str2 != null;
                if (j3 != 0) {
                    j |= z2 ? 128L : 64L;
                }
                int i5 = i3;
                str = str2;
                i = z2 ? 0 : 8;
                i4 = i5;
            } else {
                i = 0;
                i4 = i3;
            }
            if ((14 & j) != 0) {
                this.z.setVisibility(i4);
                this.I.setVisibility(i2);
            }
            if ((j & 13) != 0) {
                i23.b(this.M, str);
                this.M.setVisibility(i);
            }
        }
        i = 0;
        i2 = 0;
        str = null;
        if ((14 & j) != 0) {
            this.z.setVisibility(i4);
            this.I.setVisibility(i2);
        }
        if ((j & 13) != 0) {
            i23.b(this.M, str);
            this.M.setVisibility(i);
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
        if (i == 0) {
            return M((im1) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return L((im1) obj, i2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private d3(w50 w50Var, View view, Object[] objArr) {
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        TextView textView = (TextView) objArr[6];
        LottieAnimationView lottieAnimationView = (LottieAnimationView) objArr[5];
        RecyclerView recyclerView = (RecyclerView) objArr[7];
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[3];
        Object obj = objArr[4];
        super(w50Var, view, 2, linearLayout, textView, lottieAnimationView, recyclerView, swipeRefreshLayout, obj != null ? x11.bind((View) obj) : null);
        this.N = -1L;
        this.z.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[0];
        this.L = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.M = textView2;
        textView2.setTag(null);
        this.I.setTag(null);
        B(view);
        K();
    }
}
