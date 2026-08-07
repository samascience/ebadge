package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class w3 extends v3 {
    private static final SparseIntArray Q;
    private final LinearLayout O;
    private long P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Q = sparseIntArray;
        sparseIntArray.put(R.id.iv_protocol_debug_back, 1);
        sparseIntArray.put(R.id.tv_connection_status, 2);
        sparseIntArray.put(R.id.btn_connect_device, 3);
        sparseIntArray.put(R.id.btn_disconnect_device, 4);
        sparseIntArray.put(R.id.btn_send_test_data, 5);
        sparseIntArray.put(R.id.btn_request_device_info, 6);
        sparseIntArray.put(R.id.btn_request_media_list, 7);
        sparseIntArray.put(R.id.btn_clear_logs, 8);
        sparseIntArray.put(R.id.rv_protocol_logs, 9);
        sparseIntArray.put(R.id.progress_bar, 10);
    }

    public w3(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 11, null, Q));
    }

    public void K() {
        synchronized (this) {
            this.P = 1L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        synchronized (this) {
            this.P = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.P != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private w3(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (Button) objArr[8], (Button) objArr[3], (Button) objArr[4], (Button) objArr[6], (Button) objArr[7], (Button) objArr[5], (ImageView) objArr[1], (ProgressBar) objArr[10], (RecyclerView) objArr[9], (TextView) objArr[2]);
        this.P = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.O = linearLayout;
        linearLayout.setTag(null);
        B(view);
        K();
    }
}
