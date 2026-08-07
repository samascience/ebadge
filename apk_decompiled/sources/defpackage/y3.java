package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y3 extends ViewDataBinding {
    public final EditText F;
    public final EditText G;
    public final EditText H;
    public final AppCompatButton z;

    protected y3(Object obj, View view, int i, AppCompatButton appCompatButton, EditText editText, EditText editText2, EditText editText3) {
        super(obj, view, i);
        this.z = appCompatButton;
        this.F = editText;
        this.G = editText2;
        this.H = editText3;
    }

    public static y3 H(View view, Object obj) {
        return (y3) ViewDataBinding.f(obj, view, R.layout.activity_register);
    }

    public static y3 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (y3) ViewDataBinding.p(layoutInflater, R.layout.activity_register, viewGroup, z, obj);
    }

    public static y3 J(LayoutInflater layoutInflater, Object obj) {
        return (y3) ViewDataBinding.p(layoutInflater, R.layout.activity_register, null, false, obj);
    }

    public static y3 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static y3 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static y3 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
