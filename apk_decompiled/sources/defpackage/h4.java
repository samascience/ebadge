package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h4 extends ViewDataBinding {
    public final EditText F;
    public final x11 G;
    public final RecyclerView z;

    protected h4(Object obj, View view, int i, RecyclerView recyclerView, EditText editText, x11 x11Var) {
        super(obj, view, i);
        this.z = recyclerView;
        this.F = editText;
        this.G = x11Var;
    }

    public static h4 H(View view, Object obj) {
        return (h4) ViewDataBinding.f(obj, view, R.layout.activity_select_language);
    }

    public static h4 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (h4) ViewDataBinding.p(layoutInflater, R.layout.activity_select_language, viewGroup, z, obj);
    }

    public static h4 J(LayoutInflater layoutInflater, Object obj) {
        return (h4) ViewDataBinding.p(layoutInflater, R.layout.activity_select_language, null, false, obj);
    }

    public static h4 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static h4 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static h4 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
