package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class up0 extends ViewDataBinding {
    public final RadioButton F;
    public final RadioGroup G;
    public final TextView H;
    public final RadioButton z;

    protected up0(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TextView textView) {
        super(obj, view, i);
        this.z = radioButton;
        this.F = radioButton2;
        this.G = radioGroup;
        this.H = textView;
    }

    public static up0 H(View view, Object obj) {
        return (up0) ViewDataBinding.f(obj, view, R.layout.fragment_dialog_common_choise_double);
    }

    public static up0 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (up0) ViewDataBinding.p(layoutInflater, R.layout.fragment_dialog_common_choise_double, viewGroup, z, obj);
    }

    public static up0 J(LayoutInflater layoutInflater, Object obj) {
        return (up0) ViewDataBinding.p(layoutInflater, R.layout.fragment_dialog_common_choise_double, null, false, obj);
    }

    public static up0 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static up0 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static up0 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
