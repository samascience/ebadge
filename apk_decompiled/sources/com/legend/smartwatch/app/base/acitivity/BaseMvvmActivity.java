package com.legend.smartwatch.app.base.acitivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.q;
import com.legend.smartwatch.app.base.viewmodel.a;
import defpackage.p31;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMvvmActivity<VB extends ViewDataBinding, VM extends a> extends BaseActivity<VB> {
    private final int k;
    protected a l;

    public BaseMvvmActivity(int i) {
        super(i);
        this.k = i;
    }

    private final void X() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            throw new IllegalStateException("must extend BaseMvvmActivity with generic type arguments");
        }
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
        p31.d(type, "null cannot be cast to non-null type java.lang.Class<VM of com.legend.smartwatch.app.base.acitivity.BaseMvvmActivity>");
        Z((a) new q(this).a((Class) type));
    }

    protected final a Y() {
        a aVar = this.l;
        if (aVar != null) {
            return aVar;
        }
        p31.t("mViewModel");
        return null;
    }

    protected final void Z(a aVar) {
        p31.f(aVar, "<set-?>");
        this.l = aVar;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        X();
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
