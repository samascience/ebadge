package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.model.BluetoothDeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
public class u31 extends t31 {
    private static final SparseIntArray M;
    private final RelativeLayout J;
    private final View K;
    private long L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R.id.iv_device_icon, 5);
    }

    public u31(w50 w50Var, View view) {
        this(w50Var, view, ViewDataBinding.s(w50Var, view, 6, null, M));
    }

    @Override // defpackage.t31
    public void K(BluetoothDeviceInfo bluetoothDeviceInfo) {
        this.I = bluetoothDeviceInfo;
        synchronized (this) {
            this.L |= 1;
        }
        notifyPropertyChanged(1);
        super.z();
    }

    public void L() {
        synchronized (this) {
            this.L = 2L;
        }
        z();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void h() {
        long j;
        String strValueOf;
        String address;
        boolean zIsConnected;
        int iM;
        View view;
        int i;
        String displayName;
        int rssi;
        synchronized (this) {
            j = this.L;
            this.L = 0L;
        }
        BluetoothDeviceInfo bluetoothDeviceInfo = this.I;
        long j2 = j & 3;
        String str = null;
        int i2 = 0;
        if (j2 != 0) {
            if (bluetoothDeviceInfo != null) {
                rssi = bluetoothDeviceInfo.getRssi();
                displayName = bluetoothDeviceInfo.getDisplayName();
                address = bluetoothDeviceInfo.getAddress();
                zIsConnected = bluetoothDeviceInfo.isConnected();
            } else {
                displayName = null;
                address = null;
                rssi = 0;
                zIsConnected = false;
            }
            if (j2 != 0) {
                j = zIsConnected ? j | 32 : j | 16;
            }
            strValueOf = String.valueOf(rssi);
            str = displayName;
        } else {
            strValueOf = null;
            address = null;
            zIsConnected = false;
        }
        long j3 = 16 & j;
        if (j3 != 0) {
            boolean zIsConnecting = bluetoothDeviceInfo != null ? bluetoothDeviceInfo.isConnecting() : false;
            if (j3 != 0) {
                j |= zIsConnecting ? 8L : 4L;
            }
            if (zIsConnecting) {
                view = this.K;
                i = R.color.orange;
            } else {
                view = this.K;
                i = R.color.gray;
            }
            iM = ViewDataBinding.m(view, i);
        } else {
            iM = 0;
        }
        long j4 = j & 3;
        if (j4 != 0) {
            if (zIsConnected) {
                iM = ViewDataBinding.m(this.K, R.color.green);
            }
            i2 = iM;
        }
        if (j4 != 0) {
            if (ViewDataBinding.l() >= 21) {
                this.K.setBackgroundTintList(g40.a(i2));
            }
            i23.b(this.F, address);
            i23.b(this.G, str);
            i23.b(this.H, strValueOf);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean o() {
        synchronized (this) {
            try {
                return this.L != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean t(int i, Object obj, int i2) {
        return false;
    }

    private u31(w50 w50Var, View view, Object[] objArr) {
        super(w50Var, view, 0, (ImageView) objArr[5], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[3]);
        this.L = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.J = relativeLayout;
        relativeLayout.setTag(null);
        View view2 = (View) objArr[4];
        this.K = view2;
        view2.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        this.H.setTag(null);
        B(view);
        L();
    }
}
