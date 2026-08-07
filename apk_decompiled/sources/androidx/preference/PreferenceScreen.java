package androidx.preference;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import defpackage.c73;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean a0;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, c73.a(context, R$attr.preferenceScreenStyle, R.attr.preferenceScreenStyle));
        this.a0 = true;
    }

    public boolean A0() {
        return this.a0;
    }

    @Override // androidx.preference.Preference
    protected void K() {
        c.b bVarD;
        if (l() != null || j() != null || w0() == 0 || (bVarD = u().d()) == null) {
            return;
        }
        bVarD.m(this);
    }

    @Override // androidx.preference.PreferenceGroup
    protected boolean x0() {
        return false;
    }
}
