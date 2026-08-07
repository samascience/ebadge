package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import defpackage.c73;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {
    private final a X;
    private CharSequence Y;
    private CharSequence Z;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreference.this.a(Boolean.valueOf(z))) {
                SwitchPreference.this.t0(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.X = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SwitchPreference, i, i2);
        w0(c73.m(typedArrayObtainStyledAttributes, R$styleable.SwitchPreference_summaryOn, R$styleable.SwitchPreference_android_summaryOn));
        v0(c73.m(typedArrayObtainStyledAttributes, R$styleable.SwitchPreference_summaryOff, R$styleable.SwitchPreference_android_summaryOff));
        A0(c73.m(typedArrayObtainStyledAttributes, R$styleable.SwitchPreference_switchTextOn, R$styleable.SwitchPreference_android_switchTextOn));
        z0(c73.m(typedArrayObtainStyledAttributes, R$styleable.SwitchPreference_switchTextOff, R$styleable.SwitchPreference_android_switchTextOff));
        u0(c73.b(typedArrayObtainStyledAttributes, R$styleable.SwitchPreference_disableDependentsState, R$styleable.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B0(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.S);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.Y);
            r4.setTextOff(this.Z);
            r4.setOnCheckedChangeListener(this.X);
        }
    }

    private void C0(View view) {
        if (((AccessibilityManager) g().getSystemService("accessibility")).isEnabled()) {
            B0(view.findViewById(R.id.switch_widget));
            x0(view.findViewById(R.id.summary));
        }
    }

    public void A0(CharSequence charSequence) {
        this.Y = charSequence;
        F();
    }

    @Override // androidx.preference.Preference
    public void J(d dVar) {
        super.J(dVar);
        B0(dVar.a(R.id.switch_widget));
        y0(dVar);
    }

    @Override // androidx.preference.Preference
    protected void T(View view) {
        super.T(view);
        C0(view);
    }

    public void z0(CharSequence charSequence) {
        this.Z = charSequence;
        F();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c73.a(context, R$attr.switchPreferenceStyle, R.attr.switchPreferenceStyle));
    }
}
