package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l4 extends ViewDataBinding {
    public final WebView F;
    public final x11 z;

    protected l4(Object obj, View view, int i, x11 x11Var, WebView webView) {
        super(obj, view, i);
        this.z = x11Var;
        this.F = webView;
    }

    public static l4 H(View view, Object obj) {
        return (l4) ViewDataBinding.f(obj, view, R.layout.activity_user_protocol);
    }

    public static l4 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (l4) ViewDataBinding.p(layoutInflater, R.layout.activity_user_protocol, viewGroup, z, obj);
    }

    public static l4 J(LayoutInflater layoutInflater, Object obj) {
        return (l4) ViewDataBinding.p(layoutInflater, R.layout.activity_user_protocol, null, false, obj);
    }

    public static l4 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static l4 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static l4 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
