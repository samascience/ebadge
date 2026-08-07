package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.e0;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.dd0;
import defpackage.e43;
import defpackage.e6;
import defpackage.f10;
import defpackage.nf3;
import defpackage.o23;
import defpackage.og1;
import defpackage.qd0;
import defpackage.sg1;
import defpackage.v8;
import defpackage.w6;
import defpackage.yg1;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int[] F;
    private static final int[][] G;
    private static final int H;
    private static final int y = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[] z = {R$attr.state_indeterminate};
    private final LinkedHashSet e;
    private final LinkedHashSet f;
    private ColorStateList g;
    private boolean h;
    private boolean i;
    private boolean j;
    private CharSequence k;
    private Drawable l;
    private Drawable m;
    private boolean n;
    ColorStateList o;
    ColorStateList p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f254q;
    private int r;
    private int[] s;
    private boolean t;
    private CharSequence u;
    private CompoundButton.OnCheckedChangeListener v;
    private final w6 w;
    private final e6 x;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        private String a() {
            int i = this.a;
            if (i != 1) {
                return i != 2 ? "unchecked" : "indeterminate";
            }
            return "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + a() + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Integer.valueOf(this.a));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    class a extends e6 {
        a() {
        }

        @Override // defpackage.e6
        public void b(Drawable drawable) {
            super.b(drawable);
            ColorStateList colorStateList = MaterialCheckBox.this.o;
            if (colorStateList != null) {
                dd0.o(drawable, colorStateList);
            }
        }

        @Override // defpackage.e6
        public void c(Drawable drawable) {
            super.c(drawable);
            MaterialCheckBox materialCheckBox = MaterialCheckBox.this;
            ColorStateList colorStateList = materialCheckBox.o;
            if (colorStateList != null) {
                dd0.n(drawable, colorStateList.getColorForState(materialCheckBox.s, MaterialCheckBox.this.o.getDefaultColor()));
            }
        }
    }

    static {
        int i = R$attr.state_error;
        F = new int[]{i};
        G = new int[][]{new int[]{R.attr.state_enabled, i}, new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
        H = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context context) {
        this(context, null);
    }

    private boolean c(e0 e0Var) {
        return e0Var.n(R$styleable.MaterialCheckBox_android_button, 0) == H && e0Var.n(R$styleable.MaterialCheckBox_buttonCompat, 0) == 0;
    }

    private void e() {
        this.l = qd0.d(this.l, this.o, f10.c(this));
        this.m = qd0.d(this.m, this.p, this.f254q);
        g();
        h();
        super.setButtonDrawable(qd0.a(this.l, this.m));
        refreshDrawableState();
    }

    private void f() {
        if (Build.VERSION.SDK_INT < 30 || this.u != null) {
            return;
        }
        super.setStateDescription(getButtonStateDescription());
    }

    private void g() {
        w6 w6Var;
        if (this.n) {
            w6 w6Var2 = this.w;
            if (w6Var2 != null) {
                w6Var2.f(this.x);
                this.w.b(this.x);
            }
            Drawable drawable = this.l;
            if (!(drawable instanceof AnimatedStateListDrawable) || (w6Var = this.w) == null) {
                return;
            }
            int i = R$id.checked;
            int i2 = R$id.unchecked;
            ((AnimatedStateListDrawable) drawable).addTransition(i, i2, w6Var, false);
            ((AnimatedStateListDrawable) this.l).addTransition(R$id.indeterminate, i2, this.w, false);
        }
    }

    private String getButtonStateDescription() {
        int i = this.r;
        if (i == 1) {
            return getResources().getString(R$string.mtrl_checkbox_state_description_checked);
        }
        return i == 0 ? getResources().getString(R$string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R$string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.g == null) {
            int[][] iArr = G;
            int[] iArr2 = new int[iArr.length];
            int iD = og1.d(this, R$attr.colorControlActivated);
            int iD2 = og1.d(this, R$attr.colorError);
            int iD3 = og1.d(this, R$attr.colorSurface);
            int iD4 = og1.d(this, R$attr.colorOnSurface);
            iArr2[0] = og1.j(iD3, iD2, 1.0f);
            iArr2[1] = og1.j(iD3, iD, 1.0f);
            iArr2[2] = og1.j(iD3, iD4, 0.54f);
            iArr2[3] = og1.j(iD3, iD4, 0.38f);
            iArr2[4] = og1.j(iD3, iD4, 0.38f);
            this.g = new ColorStateList(iArr, iArr2);
        }
        return this.g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.o;
        if (colorStateList != null) {
            return colorStateList;
        }
        return super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    private void h() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.l;
        if (drawable != null && (colorStateList2 = this.o) != null) {
            dd0.o(drawable, colorStateList2);
        }
        Drawable drawable2 = this.m;
        if (drawable2 == null || (colorStateList = this.p) == null) {
            return;
        }
        dd0.o(drawable2, colorStateList);
    }

    private void i() {
    }

    public boolean d() {
        return this.j;
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.l;
    }

    public Drawable getButtonIconDrawable() {
        return this.m;
    }

    public ColorStateList getButtonIconTintList() {
        return this.p;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f254q;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.o;
    }

    public int getCheckedState() {
        return this.r;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.k;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.r == 1;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && this.o == null && this.p == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, z);
        }
        if (d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        this.s = qd0.f(iArrOnCreateDrawableState);
        i();
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.i || !TextUtils.isEmpty(getText()) || (drawableA = f10.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (nf3.o(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            dd0.l(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && d()) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.k));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCheckedState(savedState.a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getCheckedState();
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(v8.b(getContext(), i));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.m = drawable;
        e();
    }

    public void setButtonIconDrawableResource(int i) {
        setButtonIconDrawable(v8.b(getContext(), i));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.p == colorStateList) {
            return;
        }
        this.p = colorStateList;
        e();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f254q == mode) {
            return;
        }
        this.f254q = mode;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.o == colorStateList) {
            return;
        }
        this.o = colorStateList;
        e();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        e();
    }

    public void setCenterIfNoTextEnabled(boolean z2) {
        this.i = z2;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        setCheckedState(z2 ? 1 : 0);
    }

    public void setCheckedState(int i) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.r != i) {
            this.r = i;
            super.setChecked(i == 1);
            refreshDrawableState();
            f();
            if (this.t) {
                return;
            }
            this.t = true;
            LinkedHashSet linkedHashSet = this.f;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    throw null;
                }
            }
            if (this.r != 2 && (onCheckedChangeListener = this.v) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.t = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        i();
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.k = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i) {
        setErrorAccessibilityLabel(i != 0 ? getResources().getText(i) : null);
    }

    public void setErrorShown(boolean z2) {
        if (this.j == z2) {
            return;
        }
        this.j = z2;
        refreshDrawableState();
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.v = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.u = charSequence;
        if (charSequence == null) {
            f();
        } else {
            super.setStateDescription(charSequence);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.h = z2;
        if (z2) {
            f10.d(this, getMaterialThemeColorsTintList());
        } else {
            f10.d(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.l = drawable;
        this.n = false;
        e();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i) {
        int i2 = y;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        this.w = w6.a(getContext(), R$drawable.mtrl_checkbox_button_checked_unchecked);
        this.x = new a();
        Context context2 = getContext();
        this.l = f10.a(this);
        this.o = getSuperButtonTintList();
        setSupportButtonTintList(null);
        e0 e0VarJ = o23.j(context2, attributeSet, R$styleable.MaterialCheckBox, i, i2, new int[0]);
        this.m = e0VarJ.g(R$styleable.MaterialCheckBox_buttonIcon);
        if (this.l != null && o23.g(context2) && c(e0VarJ)) {
            super.setButtonDrawable((Drawable) null);
            this.l = v8.b(context2, R$drawable.mtrl_checkbox_button);
            this.n = true;
            if (this.m == null) {
                this.m = v8.b(context2, R$drawable.mtrl_checkbox_button_icon);
            }
        }
        this.p = sg1.b(context2, e0VarJ, R$styleable.MaterialCheckBox_buttonIconTint);
        this.f254q = nf3.q(e0VarJ.k(R$styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.h = e0VarJ.a(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.i = e0VarJ.a(R$styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.j = e0VarJ.a(R$styleable.MaterialCheckBox_errorShown, false);
        this.k = e0VarJ.p(R$styleable.MaterialCheckBox_errorAccessibilityLabel);
        int i3 = R$styleable.MaterialCheckBox_checkedState;
        if (e0VarJ.s(i3)) {
            setCheckedState(e0VarJ.k(i3, 0));
        }
        e0VarJ.x();
        e();
    }
}
