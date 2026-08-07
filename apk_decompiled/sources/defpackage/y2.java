package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y2 extends ViewDataBinding {
    public final WebView F;
    public final TextView G;
    public final x11 z;

    protected y2(Object obj, View view, int i, x11 x11Var, WebView webView, TextView textView) {
        super(obj, view, i);
        this.z = x11Var;
        this.F = webView;
        this.G = textView;
    }

    public static y2 H(View view, Object obj) {
        return (y2) ViewDataBinding.f(obj, view, R.layout.activity_app_instructions);
    }

    public static y2 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (y2) ViewDataBinding.p(layoutInflater, R.layout.activity_app_instructions, viewGroup, z, obj);
    }

    public static y2 J(LayoutInflater layoutInflater, Object obj) {
        return (y2) ViewDataBinding.p(layoutInflater, R.layout.activity_app_instructions, null, false, obj);
    }

    public static y2 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static y2 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static y2 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
