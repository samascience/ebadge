package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p4 extends ViewDataBinding {
    protected p4(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static p4 H(View view, Object obj) {
        return (p4) ViewDataBinding.f(obj, view, R.layout.activity_welcome);
    }

    public static p4 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (p4) ViewDataBinding.p(layoutInflater, R.layout.activity_welcome, viewGroup, z, obj);
    }

    public static p4 J(LayoutInflater layoutInflater, Object obj) {
        return (p4) ViewDataBinding.p(layoutInflater, R.layout.activity_welcome, null, false, obj);
    }

    public static p4 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static p4 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static p4 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
