package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.ui.viewmodels.bluetooth.BluetoothScanViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c3 extends ViewDataBinding {
    public final TextView F;
    public final LottieAnimationView G;
    public final RecyclerView H;
    public final SwipeRefreshLayout I;
    public final x11 J;
    protected BluetoothScanViewModel K;
    public final LinearLayout z;

    protected c3(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, LottieAnimationView lottieAnimationView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, x11 x11Var) {
        super(obj, view, i);
        this.z = linearLayout;
        this.F = textView;
        this.G = lottieAnimationView;
        this.H = recyclerView;
        this.I = swipeRefreshLayout;
        this.J = x11Var;
    }

    public static c3 H(View view, Object obj) {
        return (c3) ViewDataBinding.f(obj, view, R.layout.activity_bluetooth_scan_mvvm);
    }

    public static c3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (c3) ViewDataBinding.p(layoutInflater, R.layout.activity_bluetooth_scan_mvvm, viewGroup, z, obj);
    }

    public static c3 J(LayoutInflater layoutInflater, Object obj) {
        return (c3) ViewDataBinding.p(layoutInflater, R.layout.activity_bluetooth_scan_mvvm, null, false, obj);
    }

    public static c3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static c3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static c3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
