package androidx.preference;

import android.R;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import defpackage.c73;
import defpackage.m2;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.preference.Preference
    public boolean B() {
        return false;
    }

    @Override // androidx.preference.Preference
    public void J(d dVar) {
        super.J(dVar);
        if (Build.VERSION.SDK_INT >= 28) {
            dVar.itemView.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public void O(m2 m2Var) {
        m2.f fVarQ;
        super.O(m2Var);
        if (Build.VERSION.SDK_INT >= 28 || (fVarQ = m2Var.q()) == null) {
            return;
        }
        m2Var.m0(m2.f.f(fVarQ.c(), fVarQ.d(), fVarQ.a(), fVarQ.b(), true, fVarQ.e()));
    }

    @Override // androidx.preference.Preference
    public boolean n0() {
        return !super.B();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c73.a(context, R$attr.preferenceCategoryStyle, R.attr.preferenceCategoryStyle));
    }
}
