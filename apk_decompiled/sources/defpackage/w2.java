package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class w2 extends ViewDataBinding {
    public final ImageView F;
    public final LinearLayout G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final AppCompatButton z;

    protected w2(Object obj, View view, int i, AppCompatButton appCompatButton, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.z = appCompatButton;
        this.F = imageView;
        this.G = linearLayout;
        this.H = textView;
        this.I = textView2;
        this.J = textView3;
        this.K = textView4;
        this.L = textView5;
    }

    public static w2 H(View view, Object obj) {
        return (w2) ViewDataBinding.f(obj, view, R.layout.activity_about);
    }

    public static w2 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (w2) ViewDataBinding.p(layoutInflater, R.layout.activity_about, viewGroup, z, obj);
    }

    public static w2 J(LayoutInflater layoutInflater, Object obj) {
        return (w2) ViewDataBinding.p(layoutInflater, R.layout.activity_about, null, false, obj);
    }

    public static w2 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static w2 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static w2 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
