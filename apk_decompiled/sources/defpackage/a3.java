package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a3 extends ViewDataBinding {
    public final TextView F;
    public final ViewPager G;
    public final TabLayout z;

    protected a3(Object obj, View view, int i, TabLayout tabLayout, TextView textView, ViewPager viewPager) {
        super(obj, view, i);
        this.z = tabLayout;
        this.F = textView;
        this.G = viewPager;
    }

    public static a3 H(View view, Object obj) {
        return (a3) ViewDataBinding.f(obj, view, R.layout.activity_back_permission_settings);
    }

    public static a3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (a3) ViewDataBinding.p(layoutInflater, R.layout.activity_back_permission_settings, viewGroup, z, obj);
    }

    public static a3 J(LayoutInflater layoutInflater, Object obj) {
        return (a3) ViewDataBinding.p(layoutInflater, R.layout.activity_back_permission_settings, null, false, obj);
    }

    public static a3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static a3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static a3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
