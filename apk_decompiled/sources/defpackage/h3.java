package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h3 extends ViewDataBinding {
    public final Button F;
    public final TextView G;
    public final TextView H;
    public final Button z;

    protected h3(Object obj, View view, int i, Button button, Button button2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.z = button;
        this.F = button2;
        this.G = textView;
        this.H = textView2;
    }

    public static h3 H(View view, Object obj) {
        return (h3) ViewDataBinding.f(obj, view, R.layout.activity_debug_function);
    }

    public static h3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (h3) ViewDataBinding.p(layoutInflater, R.layout.activity_debug_function, viewGroup, z, obj);
    }

    public static h3 J(LayoutInflater layoutInflater, Object obj) {
        return (h3) ViewDataBinding.p(layoutInflater, R.layout.activity_debug_function, null, false, obj);
    }

    public static h3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static h3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static h3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
