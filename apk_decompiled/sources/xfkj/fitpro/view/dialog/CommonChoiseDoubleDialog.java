package xfkj.fitpro.view.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.ml2;
import defpackage.p31;
import defpackage.up0;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonChoiseDoubleDialog extends BindingBaseDialogFragment<up0> implements RadioGroup.OnCheckedChangeListener {
    private final String w;
    private final String x;
    private final String y;
    private int z;

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    protected BindingBaseDialogFragment.a N() {
        return new BindingBaseDialogFragment.a().a(false).k(80).m(ml2.a() - d.c(20.0f));
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    public void O(Bundle bundle, View view) {
        ViewDataBinding viewDataBindingQ = Q();
        p31.c(viewDataBindingQ);
        ((up0) viewDataBindingQ).G.check(this.z == 0 ? R.id.rad1 : R.id.rad2);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        p31.f(radioGroup, "radioGroup");
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewDataBinding viewDataBindingQ = Q();
        p31.c(viewDataBindingQ);
        ((up0) viewDataBindingQ).G.setOnCheckedChangeListener(this);
        ViewDataBinding viewDataBindingQ2 = Q();
        p31.c(viewDataBindingQ2);
        ((up0) viewDataBindingQ2).H.setText(this.w);
        ViewDataBinding viewDataBindingQ3 = Q();
        p31.c(viewDataBindingQ3);
        ((up0) viewDataBindingQ3).z.setText(this.x);
        ViewDataBinding viewDataBindingQ4 = Q();
        p31.c(viewDataBindingQ4);
        ((up0) viewDataBindingQ4).F.setText(this.y);
    }
}
