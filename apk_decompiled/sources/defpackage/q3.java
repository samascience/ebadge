package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q3 extends ViewDataBinding {
    public final ImageView F;
    public final RelativeLayout G;
    public final Switch H;
    public final View I;
    public final TextView J;
    public final ProgressBar K;
    public final RecyclerView L;
    public final m33 M;
    public final FrameLayout z;

    protected q3(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, RelativeLayout relativeLayout, Switch r7, View view2, TextView textView, ProgressBar progressBar, RecyclerView recyclerView, m33 m33Var) {
        super(obj, view, i);
        this.z = frameLayout;
        this.F = imageView;
        this.G = relativeLayout;
        this.H = r7;
        this.I = view2;
        this.J = textView;
        this.K = progressBar;
        this.L = recyclerView;
        this.M = m33Var;
    }

    public static q3 H(View view, Object obj) {
        return (q3) ViewDataBinding.f(obj, view, R.layout.activity_message_setting);
    }

    public static q3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (q3) ViewDataBinding.p(layoutInflater, R.layout.activity_message_setting, viewGroup, z, obj);
    }

    public static q3 J(LayoutInflater layoutInflater, Object obj) {
        return (q3) ViewDataBinding.p(layoutInflater, R.layout.activity_message_setting, null, false, obj);
    }

    public static q3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static q3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static q3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
