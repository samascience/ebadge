package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j4 extends ViewDataBinding {
    public final x11 F;
    public final SwipeMenuRecyclerView z;

    protected j4(Object obj, View view, int i, SwipeMenuRecyclerView swipeMenuRecyclerView, x11 x11Var) {
        super(obj, view, i);
        this.z = swipeMenuRecyclerView;
        this.F = x11Var;
    }

    public static j4 H(View view, Object obj) {
        return (j4) ViewDataBinding.f(obj, view, R.layout.activity_syn_contracts);
    }

    public static j4 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (j4) ViewDataBinding.p(layoutInflater, R.layout.activity_syn_contracts, viewGroup, z, obj);
    }

    public static j4 J(LayoutInflater layoutInflater, Object obj) {
        return (j4) ViewDataBinding.p(layoutInflater, R.layout.activity_syn_contracts, null, false, obj);
    }

    public static j4 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static j4 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static j4 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
