package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.viewmodel.VideoPushViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n4 extends ViewDataBinding {
    public final TextView F;
    public final RecyclerView G;
    public final ImageView H;
    public final ImageView I;
    public final ImageView J;
    public final ImageView K;
    public final VideoView L;
    public final ImageView M;
    public final ImageView N;
    public final FrameLayout O;
    public final RadioButton P;
    public final RadioButton Q;
    public final RadioButton R;
    public final RadioButton S;
    public final RadioButton T;
    public final RadioButton U;
    public final AppCompatButton V;
    public final RadioGroup W;
    public final RadioGroup X;
    public final View Y;
    public final TextView Z;
    public final TextView a0;
    public final TextView b0;
    public final SwipeRefreshLayout c0;
    public final FrameLayout d0;
    protected VideoPushViewModel e0;
    public final AppCompatButton z;

    protected n4(Object obj, View view, int i, AppCompatButton appCompatButton, TextView textView, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, VideoView videoView, ImageView imageView5, ImageView imageView6, FrameLayout frameLayout, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, AppCompatButton appCompatButton2, RadioGroup radioGroup, RadioGroup radioGroup2, View view2, TextView textView2, TextView textView3, TextView textView4, SwipeRefreshLayout swipeRefreshLayout, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.z = appCompatButton;
        this.F = textView;
        this.G = recyclerView;
        this.H = imageView;
        this.I = imageView2;
        this.J = imageView3;
        this.K = imageView4;
        this.L = videoView;
        this.M = imageView5;
        this.N = imageView6;
        this.O = frameLayout;
        this.P = radioButton;
        this.Q = radioButton2;
        this.R = radioButton3;
        this.S = radioButton4;
        this.T = radioButton5;
        this.U = radioButton6;
        this.V = appCompatButton2;
        this.W = radioGroup;
        this.X = radioGroup2;
        this.Y = view2;
        this.Z = textView2;
        this.a0 = textView3;
        this.b0 = textView4;
        this.c0 = swipeRefreshLayout;
        this.d0 = frameLayout2;
    }

    public static n4 H(View view, Object obj) {
        return (n4) ViewDataBinding.f(obj, view, R.layout.activity_video_push);
    }

    public static n4 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (n4) ViewDataBinding.p(layoutInflater, R.layout.activity_video_push, viewGroup, z, obj);
    }

    public static n4 J(LayoutInflater layoutInflater, Object obj) {
        return (n4) ViewDataBinding.p(layoutInflater, R.layout.activity_video_push, null, false, obj);
    }

    public static n4 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static n4 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public abstract void K(VideoPushViewModel videoPushViewModel);

    public static n4 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
