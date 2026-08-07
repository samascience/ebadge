package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.google.android.material.tabs.TabLayout;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.view.MyViewPager;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n3 extends ViewDataBinding {
    public final TextView F;
    public final MyViewPager G;
    public final TabLayout z;

    protected n3(Object obj, View view, int i, TabLayout tabLayout, TextView textView, MyViewPager myViewPager) {
        super(obj, view, i);
        this.z = tabLayout;
        this.F = textView;
        this.G = myViewPager;
    }

    public static n3 H(View view, Object obj) {
        return (n3) ViewDataBinding.f(obj, view, R.layout.activity_login_and_register);
    }

    public static n3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (n3) ViewDataBinding.p(layoutInflater, R.layout.activity_login_and_register, viewGroup, z, obj);
    }

    public static n3 J(LayoutInflater layoutInflater, Object obj) {
        return (n3) ViewDataBinding.p(layoutInflater, R.layout.activity_login_and_register, null, false, obj);
    }

    public static n3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static n3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static n3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
