package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class v3 extends ViewDataBinding {
    public final Button F;
    public final Button G;
    public final Button H;
    public final Button I;
    public final Button J;
    public final ImageView K;
    public final ProgressBar L;
    public final RecyclerView M;
    public final TextView N;
    public final Button z;

    protected v3(Object obj, View view, int i, Button button, Button button2, Button button3, Button button4, Button button5, Button button6, ImageView imageView, ProgressBar progressBar, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.z = button;
        this.F = button2;
        this.G = button3;
        this.H = button4;
        this.I = button5;
        this.J = button6;
        this.K = imageView;
        this.L = progressBar;
        this.M = recyclerView;
        this.N = textView;
    }

    public static v3 H(View view, Object obj) {
        return (v3) ViewDataBinding.f(obj, view, R.layout.activity_protocol_debug);
    }

    public static v3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (v3) ViewDataBinding.p(layoutInflater, R.layout.activity_protocol_debug, viewGroup, z, obj);
    }

    public static v3 J(LayoutInflater layoutInflater, Object obj) {
        return (v3) ViewDataBinding.p(layoutInflater, R.layout.activity_protocol_debug, null, false, obj);
    }

    public static v3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static v3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static v3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
