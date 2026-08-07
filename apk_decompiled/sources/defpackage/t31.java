package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.model.BluetoothDeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t31 extends ViewDataBinding {
    public final TextView F;
    public final TextView G;
    public final TextView H;
    protected BluetoothDeviceInfo I;
    public final ImageView z;

    protected t31(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.z = imageView;
        this.F = textView;
        this.G = textView2;
        this.H = textView3;
    }

    public static t31 H(View view, Object obj) {
        return (t31) ViewDataBinding.f(obj, view, R.layout.item_bluetooth_device_simple);
    }

    public static t31 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (t31) ViewDataBinding.p(layoutInflater, R.layout.item_bluetooth_device_simple, viewGroup, z, obj);
    }

    public static t31 J(LayoutInflater layoutInflater, Object obj) {
        return (t31) ViewDataBinding.p(layoutInflater, R.layout.item_bluetooth_device_simple, null, false, obj);
    }

    public static t31 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static t31 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public abstract void K(BluetoothDeviceInfo bluetoothDeviceInfo);

    public static t31 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
