package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.view.PulseWaveView;
import xfkj.fitpro.view.WaveView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l3 extends ViewDataBinding {
    public final CardView F;
    public final PulseWaveView G;
    public final LinearLayout H;
    public final LinearLayout I;
    public final RelativeLayout J;
    public final RecyclerView K;
    public final x11 L;
    public final ImageView M;
    public final AppCompatTextView N;
    public final AppCompatTextView O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final WaveView S;
    public final ImageView z;

    protected l3(Object obj, View view, int i, ImageView imageView, CardView cardView, PulseWaveView pulseWaveView, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, RecyclerView recyclerView, x11 x11Var, ImageView imageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ImageView imageView3, TextView textView, TextView textView2, WaveView waveView) {
        super(obj, view, i);
        this.z = imageView;
        this.F = cardView;
        this.G = pulseWaveView;
        this.H = linearLayout;
        this.I = linearLayout2;
        this.J = relativeLayout;
        this.K = recyclerView;
        this.L = x11Var;
        this.M = imageView2;
        this.N = appCompatTextView;
        this.O = appCompatTextView2;
        this.P = imageView3;
        this.Q = textView;
        this.R = textView2;
        this.S = waveView;
    }

    public static l3 H(View view, Object obj) {
        return (l3) ViewDataBinding.f(obj, view, R.layout.activity_home_voice_assistant_simultaneous_translation);
    }

    public static l3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (l3) ViewDataBinding.p(layoutInflater, R.layout.activity_home_voice_assistant_simultaneous_translation, viewGroup, z, obj);
    }

    public static l3 J(LayoutInflater layoutInflater, Object obj) {
        return (l3) ViewDataBinding.p(layoutInflater, R.layout.activity_home_voice_assistant_simultaneous_translation, null, false, obj);
    }

    public static l3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static l3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static l3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
