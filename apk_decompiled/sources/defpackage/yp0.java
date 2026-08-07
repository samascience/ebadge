package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class yp0 extends ViewDataBinding {
    public final ImageView F;
    public final TextView G;
    public final AppCompatTextView H;
    public final AppCompatTextView I;
    public final TextView z;

    protected yp0(Object obj, View view, int i, TextView textView, ImageView imageView, TextView textView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.z = textView;
        this.F = imageView;
        this.G = textView2;
        this.H = appCompatTextView;
        this.I = appCompatTextView2;
    }

    public static yp0 H(View view, Object obj) {
        return (yp0) ViewDataBinding.f(obj, view, R.layout.fragment_dialog_common_prompt);
    }

    public static yp0 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (yp0) ViewDataBinding.p(layoutInflater, R.layout.fragment_dialog_common_prompt, viewGroup, z, obj);
    }

    public static yp0 J(LayoutInflater layoutInflater, Object obj) {
        return (yp0) ViewDataBinding.p(layoutInflater, R.layout.fragment_dialog_common_prompt, null, false, obj);
    }

    public static yp0 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static yp0 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static yp0 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
