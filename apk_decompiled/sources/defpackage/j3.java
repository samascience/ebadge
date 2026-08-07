package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j3 extends ViewDataBinding {
    public final CardView F;
    public final CardView G;
    public final CardView H;
    public final CardView I;
    public final CardView J;
    public final CardView K;
    public final CardView L;
    public final CardView M;
    public final CardView N;
    public final CardView O;
    public final CardView P;
    public final v11 Q;
    public final ImageView R;
    public final ImageView S;
    public final LinearLayout T;
    public final TextView U;
    public final TextView V;
    public final ImageView W;
    public final CardView z;

    protected j3(Object obj, View view, int i, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, CardView cardView6, CardView cardView7, CardView cardView8, CardView cardView9, CardView cardView10, CardView cardView11, CardView cardView12, v11 v11Var, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView3) {
        super(obj, view, i);
        this.z = cardView;
        this.F = cardView2;
        this.G = cardView3;
        this.H = cardView4;
        this.I = cardView5;
        this.J = cardView6;
        this.K = cardView7;
        this.L = cardView8;
        this.M = cardView9;
        this.N = cardView10;
        this.O = cardView11;
        this.P = cardView12;
        this.Q = v11Var;
        this.R = imageView;
        this.S = imageView2;
        this.T = linearLayout;
        this.U = textView;
        this.V = textView2;
        this.W = imageView3;
    }

    public static j3 H(View view, Object obj) {
        return (j3) ViewDataBinding.f(obj, view, R.layout.activity_device_home);
    }

    public static j3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (j3) ViewDataBinding.p(layoutInflater, R.layout.activity_device_home, viewGroup, z, obj);
    }

    public static j3 J(LayoutInflater layoutInflater, Object obj) {
        return (j3) ViewDataBinding.p(layoutInflater, R.layout.activity_device_home, null, false, obj);
    }

    public static j3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static j3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static j3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
