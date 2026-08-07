package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t3 extends ViewDataBinding {
    public final AppCompatButton F;
    public final ImageView G;
    public final ImageView H;
    public final ImageView I;
    public final ImageView J;
    public final ImageView K;
    public final ImageView L;
    public final TextView M;
    public final SwipeRefreshLayout N;
    public final AppCompatButton O;
    public final TextView P;
    public final FrameLayout Q;
    public final LinearLayout R;
    public final TextView S;
    public final RecyclerView z;

    protected t3(Object obj, View view, int i, RecyclerView recyclerView, AppCompatButton appCompatButton, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, SwipeRefreshLayout swipeRefreshLayout, AppCompatButton appCompatButton2, TextView textView2, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView3) {
        super(obj, view, i);
        this.z = recyclerView;
        this.F = appCompatButton;
        this.G = imageView;
        this.H = imageView2;
        this.I = imageView3;
        this.J = imageView4;
        this.K = imageView5;
        this.L = imageView6;
        this.M = textView;
        this.N = swipeRefreshLayout;
        this.O = appCompatButton2;
        this.P = textView2;
        this.Q = frameLayout;
        this.R = linearLayout;
        this.S = textView3;
    }

    public static t3 H(View view, Object obj) {
        return (t3) ViewDataBinding.f(obj, view, R.layout.activity_picture_push);
    }

    public static t3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (t3) ViewDataBinding.p(layoutInflater, R.layout.activity_picture_push, viewGroup, z, obj);
    }

    public static t3 J(LayoutInflater layoutInflater, Object obj) {
        return (t3) ViewDataBinding.p(layoutInflater, R.layout.activity_picture_push, null, false, obj);
    }

    public static t3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static t3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static t3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
