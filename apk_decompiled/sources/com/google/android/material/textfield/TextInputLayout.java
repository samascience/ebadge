package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.e0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.connect.common.Constants;
import defpackage.be3;
import defpackage.bk0;
import defpackage.dd0;
import defpackage.el1;
import defpackage.j23;
import defpackage.m2;
import defpackage.m90;
import defpackage.nf3;
import defpackage.o23;
import defpackage.o53;
import defpackage.og1;
import defpackage.q30;
import defpackage.qh;
import defpackage.sg1;
import defpackage.sn2;
import defpackage.t1;
import defpackage.tg1;
import defpackage.uf1;
import defpackage.v8;
import defpackage.y6;
import defpackage.yg1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int H0 = R$style.Widget_Design_TextInputLayout;
    private static final int[][] I0 = {new int[]{R.attr.state_pressed}, new int[0]};
    final com.google.android.material.internal.a A0;
    private boolean B0;
    private boolean C0;
    private ValueAnimator D0;
    private boolean E0;
    private ColorStateList F;
    private boolean F0;
    private ColorStateList G;
    private boolean G0;
    private boolean H;
    private CharSequence I;
    private boolean J;
    private tg1 K;
    private tg1 L;
    private StateListDrawable M;
    private boolean N;
    private tg1 O;
    private tg1 P;
    private sn2 Q;
    private boolean R;
    private final int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private final FrameLayout a;
    private int a0;
    private final y b;
    private int b0;
    private final r c;
    private int c0;
    EditText d;
    private final Rect d0;
    private CharSequence e;
    private final Rect e0;
    private int f;
    private final RectF f0;
    private int g;
    private Typeface g0;
    private int h;
    private Drawable h0;
    private int i;
    private int i0;
    private final u j;
    private final LinkedHashSet j0;
    boolean k;
    private Drawable k0;
    private int l;
    private int l0;
    private boolean m;
    private Drawable m0;
    private e n;
    private ColorStateList n0;
    private TextView o;
    private ColorStateList o0;
    private int p;
    private int p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f271q;
    private int q0;
    private CharSequence r;
    private int r0;
    private boolean s;
    private ColorStateList s0;
    private TextView t;
    private int t0;
    private ColorStateList u;
    private int u0;
    private int v;
    private int v0;
    private bk0 w;
    private int w0;
    private bk0 x;
    private int x0;
    private ColorStateList y;
    int y0;
    private ColorStateList z;
    private boolean z0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        CharSequence a;
        boolean b;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.a, parcel, i);
            parcel.writeInt(this.b ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.b = parcel.readInt() == 1;
        }
    }

    class a implements TextWatcher {
        int a;
        final /* synthetic */ EditText b;

        a(EditText editText) {
            this.b = editText;
            this.a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.u0(!textInputLayout.F0);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.k) {
                textInputLayout2.k0(editable);
            }
            if (TextInputLayout.this.s) {
                TextInputLayout.this.y0(editable);
            }
            int lineCount = this.b.getLineCount();
            int i = this.a;
            if (lineCount != i) {
                if (lineCount < i) {
                    int iB = be3.B(this.b);
                    int i2 = TextInputLayout.this.y0;
                    if (iB != i2) {
                        this.b.setMinimumHeight(i2);
                    }
                }
                this.a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.c.h();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.A0.y0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class d extends t1 {
        private final TextInputLayout a;

        public d(TextInputLayout textInputLayout) {
            this.a = textInputLayout;
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            EditText editText = this.a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.a.getHint();
            CharSequence error = this.a.getError();
            CharSequence placeholderText = this.a.getPlaceholderText();
            int counterMaxLength = this.a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.a.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean zP = this.a.P();
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : Constants.STR_EMPTY;
            this.a.b.A(m2Var);
            if (!zIsEmpty) {
                m2Var.M0(text);
            } else if (!TextUtils.isEmpty(string)) {
                m2Var.M0(string);
                if (!zP && placeholderText != null) {
                    m2Var.M0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                m2Var.M0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                m2Var.u0(string);
                m2Var.I0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            m2Var.x0(counterMaxLength);
            if (z) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                m2Var.q0(error);
            }
            View viewT = this.a.j.t();
            if (viewT != null) {
                m2Var.v0(viewT);
            }
            this.a.c.m().o(view, m2Var);
        }

        @Override // defpackage.t1
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.a.c.m().p(view, accessibilityEvent);
        }
    }

    public interface e {
        int a(Editable editable);
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    private bk0 A() {
        bk0 bk0Var = new bk0();
        bk0Var.X(el1.f(getContext(), R$attr.motionDurationShort2, 87));
        bk0Var.Z(el1.g(getContext(), R$attr.motionEasingLinearInterpolator, y6.a));
        return bk0Var;
    }

    private boolean B() {
        return this.H && !TextUtils.isEmpty(this.I) && (this.K instanceof h);
    }

    private void C() {
        Iterator it = this.j0.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(this);
        }
    }

    private void D(Canvas canvas) {
        tg1 tg1Var;
        if (this.P == null || (tg1Var = this.O) == null) {
            return;
        }
        tg1Var.draw(canvas);
        if (this.d.isFocused()) {
            Rect bounds = this.P.getBounds();
            Rect bounds2 = this.O.getBounds();
            float F = this.A0.F();
            int iCenterX = bounds2.centerX();
            bounds.left = y6.c(iCenterX, bounds2.left, F);
            bounds.right = y6.c(iCenterX, bounds2.right, F);
            this.P.draw(canvas);
        }
    }

    private void E(Canvas canvas) {
        if (this.H) {
            this.A0.l(canvas);
        }
    }

    private void F(boolean z) {
        ValueAnimator valueAnimator = this.D0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.D0.cancel();
        }
        if (z && this.C0) {
            l(0.0f);
        } else {
            this.A0.y0(0.0f);
        }
        if (B() && ((h) this.K).t0()) {
            y();
        }
        this.z0 = true;
        L();
        this.b.l(true);
        this.c.H(true);
    }

    private tg1 G(boolean z) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float f2 = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.d;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R$dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        sn2 sn2VarM = sn2.a().E(f2).I(f2).v(dimensionPixelOffset).z(dimensionPixelOffset).m();
        EditText editText2 = this.d;
        tg1 tg1VarM = tg1.m(getContext(), popupElevation, editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null);
        tg1VarM.setShapeAppearanceModel(sn2VarM);
        tg1VarM.d0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return tg1VarM;
    }

    private static Drawable H(tg1 tg1Var, int i, int i2, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{og1.j(i2, i, 0.1f), i}), tg1Var, tg1Var);
    }

    private int I(int i, boolean z) {
        int compoundPaddingLeft;
        if (z || getPrefixText() == null) {
            compoundPaddingLeft = (!z || getSuffixText() == null) ? this.d.getCompoundPaddingLeft() : this.c.y();
        } else {
            compoundPaddingLeft = this.b.c();
        }
        return i + compoundPaddingLeft;
    }

    private int J(int i, boolean z) {
        int compoundPaddingRight;
        if (z || getSuffixText() == null) {
            compoundPaddingRight = (!z || getPrefixText() == null) ? this.d.getCompoundPaddingRight() : this.b.c();
        } else {
            compoundPaddingRight = this.c.y();
        }
        return i - compoundPaddingRight;
    }

    private static Drawable K(Context context, tg1 tg1Var, int i, int[][] iArr) {
        int iC = og1.c(context, R$attr.colorSurface, "TextInputLayout");
        tg1 tg1Var2 = new tg1(tg1Var.E());
        int iJ = og1.j(i, iC, 0.1f);
        tg1Var2.b0(new ColorStateList(iArr, new int[]{iJ, 0}));
        tg1Var2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iJ, iC});
        tg1 tg1Var3 = new tg1(tg1Var.E());
        tg1Var3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, tg1Var2, tg1Var3), tg1Var});
    }

    private void L() {
        TextView textView = this.t;
        if (textView == null || !this.s) {
            return;
        }
        textView.setText((CharSequence) null);
        o53.a(this.a, this.x);
        this.t.setVisibility(4);
    }

    private boolean Q() {
        return d0() || (this.o != null && this.m);
    }

    private boolean S() {
        return this.T == 1 && this.d.getMinLines() <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int T(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.d.requestLayout();
    }

    private void V() {
        p();
        r0();
        A0();
        h0();
        k();
        if (this.T != 0) {
            t0();
        }
        b0();
    }

    private void W() {
        if (B()) {
            RectF rectF = this.f0;
            this.A0.o(rectF, this.d.getWidth(), this.d.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            o(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.V);
            ((h) this.K).w0(rectF);
        }
    }

    private void X() {
        if (!B() || this.z0) {
            return;
        }
        y();
        W();
    }

    private static void Y(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                Y((ViewGroup) childAt, z);
            }
        }
    }

    private void a0() {
        TextView textView = this.t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void b0() {
        EditText editText = this.d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i = this.T;
                if (i == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    private boolean e0() {
        return (this.c.G() || ((this.c.A() && M()) || this.c.w() != null)) && this.c.getMeasuredWidth() > 0;
    }

    private boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.b.getMeasuredWidth() > 0;
    }

    private void g0() {
        if (this.t == null || !this.s || TextUtils.isEmpty(this.r)) {
            return;
        }
        this.t.setText(this.r);
        o53.a(this.a, this.w);
        this.t.setVisibility(0);
        this.t.bringToFront();
        announceForAccessibility(this.r);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.d;
        if (!(editText instanceof AutoCompleteTextView) || q.a(editText)) {
            return this.K;
        }
        int iD = og1.d(this.d, R$attr.colorControlHighlight);
        int i = this.T;
        if (i == 2) {
            return K(getContext(), this.K, iD, I0);
        }
        if (i == 1) {
            return H(this.K, this.c0, iD, I0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.M == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.M = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.M.addState(new int[0], G(false));
        }
        return this.M;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.L == null) {
            this.L = G(true);
        }
        return this.L;
    }

    private void h0() {
        if (this.T == 1) {
            if (sg1.k(getContext())) {
                this.U = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (sg1.j(getContext())) {
                this.U = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void i0(Rect rect) {
        tg1 tg1Var = this.O;
        if (tg1Var != null) {
            int i = rect.bottom;
            tg1Var.setBounds(rect.left, i - this.W, rect.right, i);
        }
        tg1 tg1Var2 = this.P;
        if (tg1Var2 != null) {
            int i2 = rect.bottom;
            tg1Var2.setBounds(rect.left, i2 - this.a0, rect.right, i2);
        }
    }

    private void j() {
        TextView textView = this.t;
        if (textView != null) {
            this.a.addView(textView);
            this.t.setVisibility(0);
        }
    }

    private void j0() {
        if (this.o != null) {
            EditText editText = this.d;
            k0(editText == null ? null : editText.getText());
        }
    }

    private void k() {
        if (this.d == null || this.T != 1) {
            return;
        }
        if (sg1.k(getContext())) {
            EditText editText = this.d;
            be3.F0(editText, be3.F(editText), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), be3.E(this.d), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (sg1.j(getContext())) {
            EditText editText2 = this.d;
            be3.F0(editText2, be3.F(editText2), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), be3.E(this.d), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private static void l0(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void m() {
        tg1 tg1Var = this.K;
        if (tg1Var == null) {
            return;
        }
        sn2 sn2VarE = tg1Var.E();
        sn2 sn2Var = this.Q;
        if (sn2VarE != sn2Var) {
            this.K.setShapeAppearanceModel(sn2Var);
        }
        if (w()) {
            this.K.j0(this.V, this.b0);
        }
        int iQ = q();
        this.c0 = iQ;
        this.K.b0(ColorStateList.valueOf(iQ));
        n();
        r0();
    }

    private void m0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.o;
        if (textView != null) {
            c0(textView, this.m ? this.p : this.f271q);
            if (!this.m && (colorStateList2 = this.y) != null) {
                this.o.setTextColor(colorStateList2);
            }
            if (!this.m || (colorStateList = this.z) == null) {
                return;
            }
            this.o.setTextColor(colorStateList);
        }
    }

    private void n() {
        if (this.O == null || this.P == null) {
            return;
        }
        if (x()) {
            this.O.b0(this.d.isFocused() ? ColorStateList.valueOf(this.p0) : ColorStateList.valueOf(this.b0));
            this.P.b0(ColorStateList.valueOf(this.b0));
        }
        invalidate();
    }

    private void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListG = this.F;
        if (colorStateListG == null) {
            colorStateListG = og1.g(getContext(), R$attr.colorControlActivated);
        }
        EditText editText = this.d;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = dd0.r(this.d.getTextCursorDrawable()).mutate();
        if (Q() && (colorStateList = this.G) != null) {
            colorStateListG = colorStateList;
        }
        dd0.o(drawableMutate, colorStateListG);
    }

    private void o(RectF rectF) {
        float f2 = rectF.left;
        int i = this.S;
        rectF.left = f2 - i;
        rectF.right += i;
    }

    private void p() {
        int i = this.T;
        if (i == 0) {
            this.K = null;
            this.O = null;
            this.P = null;
            return;
        }
        if (i == 1) {
            this.K = new tg1(this.Q);
            this.O = new tg1();
            this.P = new tg1();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(this.T + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.H || (this.K instanceof h)) {
                this.K = new tg1(this.Q);
            } else {
                this.K = h.r0(this.Q);
            }
            this.O = null;
            this.P = null;
        }
    }

    private int q() {
        return this.T == 1 ? og1.i(og1.e(this, R$attr.colorSurface, 0), this.c0) : this.c0;
    }

    private void q0() {
        be3.t0(this.d, getEditTextBoxBackground());
    }

    private Rect r(Rect rect) {
        if (this.d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.e0;
        boolean zO = nf3.o(this);
        rect2.bottom = rect.bottom;
        int i = this.T;
        if (i == 1) {
            rect2.left = I(rect.left, zO);
            rect2.top = rect.top + this.U;
            rect2.right = J(rect.right, zO);
            return rect2;
        }
        if (i != 2) {
            rect2.left = I(rect.left, zO);
            rect2.top = getPaddingTop();
            rect2.right = J(rect.right, zO);
            return rect2;
        }
        rect2.left = rect.left + this.d.getPaddingLeft();
        rect2.top = rect.top - v();
        rect2.right = rect.right - this.d.getPaddingRight();
        return rect2;
    }

    private int s(Rect rect, Rect rect2, float f2) {
        return S() ? (int) (rect2.top + f2) : rect.bottom - this.d.getCompoundPaddingBottom();
    }

    private boolean s0() {
        int iMax;
        if (this.d == null || this.d.getMeasuredHeight() >= (iMax = Math.max(this.c.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            return false;
        }
        this.d.setMinimumHeight(iMax);
        return true;
    }

    private void setEditText(EditText editText) {
        if (this.d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.d = editText;
        int i = this.f;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.h);
        }
        int i2 = this.g;
        if (i2 != -1) {
            setMaxEms(i2);
        } else {
            setMaxWidth(this.i);
        }
        this.N = false;
        V();
        setTextInputAccessibilityDelegate(new d(this));
        this.A0.N0(this.d.getTypeface());
        this.A0.v0(this.d.getTextSize());
        int i3 = Build.VERSION.SDK_INT;
        this.A0.q0(this.d.getLetterSpacing());
        int gravity = this.d.getGravity();
        this.A0.j0((gravity & (-113)) | 48);
        this.A0.u0(gravity);
        this.y0 = be3.B(editText);
        this.d.addTextChangedListener(new a(editText));
        if (this.n0 == null) {
            this.n0 = this.d.getHintTextColors();
        }
        if (this.H) {
            if (TextUtils.isEmpty(this.I)) {
                CharSequence hint = this.d.getHint();
                this.e = hint;
                setHint(hint);
                this.d.setHint((CharSequence) null);
            }
            this.J = true;
        }
        if (i3 >= 29) {
            n0();
        }
        if (this.o != null) {
            k0(this.d.getText());
        }
        p0();
        this.j.f();
        this.b.bringToFront();
        this.c.bringToFront();
        C();
        this.c.x0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        v0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.I)) {
            return;
        }
        this.I = charSequence;
        this.A0.K0(charSequence);
        if (this.z0) {
            return;
        }
        W();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.s == z) {
            return;
        }
        if (z) {
            j();
        } else {
            a0();
            this.t = null;
        }
        this.s = z;
    }

    private int t(Rect rect, float f2) {
        return S() ? (int) (rect.centerY() - (f2 / 2.0f)) : rect.top + this.d.getCompoundPaddingTop();
    }

    private void t0() {
        if (this.T != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            int iV = v();
            if (iV != layoutParams.topMargin) {
                layoutParams.topMargin = iV;
                this.a.requestLayout();
            }
        }
    }

    private Rect u(Rect rect) {
        if (this.d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.e0;
        float fC = this.A0.C();
        rect2.left = rect.left + this.d.getCompoundPaddingLeft();
        rect2.top = t(rect, fC);
        rect2.right = rect.right - this.d.getCompoundPaddingRight();
        rect2.bottom = s(rect, rect2, fC);
        return rect2;
    }

    private int v() {
        float fR;
        if (!this.H) {
            return 0;
        }
        int i = this.T;
        if (i == 0) {
            fR = this.A0.r();
        } else {
            if (i != 2) {
                return 0;
            }
            fR = this.A0.r() / 2.0f;
        }
        return (int) fR;
    }

    private void v0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.d;
        boolean z3 = false;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.d;
        if (editText2 != null && editText2.hasFocus()) {
            z3 = true;
        }
        ColorStateList colorStateList2 = this.n0;
        if (colorStateList2 != null) {
            this.A0.d0(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.n0;
            this.A0.d0(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.x0) : this.x0));
        } else if (d0()) {
            this.A0.d0(this.j.r());
        } else if (this.m && (textView = this.o) != null) {
            this.A0.d0(textView.getTextColors());
        } else if (z3 && (colorStateList = this.o0) != null) {
            this.A0.i0(colorStateList);
        }
        if (z4 || !this.B0 || (isEnabled() && z3)) {
            if (z2 || this.z0) {
                z(z);
                return;
            }
            return;
        }
        if (z2 || !this.z0) {
            F(z);
        }
    }

    private boolean w() {
        return this.T == 2 && x();
    }

    private void w0() {
        EditText editText;
        if (this.t == null || (editText = this.d) == null) {
            return;
        }
        this.t.setGravity(editText.getGravity());
        this.t.setPadding(this.d.getCompoundPaddingLeft(), this.d.getCompoundPaddingTop(), this.d.getCompoundPaddingRight(), this.d.getCompoundPaddingBottom());
    }

    private boolean x() {
        return this.V > -1 && this.b0 != 0;
    }

    private void x0() {
        EditText editText = this.d;
        y0(editText == null ? null : editText.getText());
    }

    private void y() {
        if (B()) {
            ((h) this.K).u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Editable editable) {
        if (this.n.a(editable) != 0 || this.z0) {
            L();
        } else {
            g0();
        }
    }

    private void z(boolean z) {
        ValueAnimator valueAnimator = this.D0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.D0.cancel();
        }
        if (z && this.C0) {
            l(1.0f);
        } else {
            this.A0.y0(1.0f);
        }
        this.z0 = false;
        if (B()) {
            W();
        }
        x0();
        this.b.l(false);
        this.c.H(false);
    }

    private void z0(boolean z, boolean z2) {
        int defaultColor = this.s0.getDefaultColor();
        int colorForState = this.s0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.s0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.b0 = colorForState2;
        } else if (z2) {
            this.b0 = colorForState;
        } else {
            this.b0 = defaultColor;
        }
    }

    void A0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.K == null || this.T == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.d) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.b0 = this.x0;
        } else if (d0()) {
            if (this.s0 != null) {
                z0(z2, z);
            } else {
                this.b0 = getErrorCurrentTextColors();
            }
        } else if (!this.m || (textView = this.o) == null) {
            if (z2) {
                this.b0 = this.r0;
            } else if (z) {
                this.b0 = this.q0;
            } else {
                this.b0 = this.p0;
            }
        } else if (this.s0 != null) {
            z0(z2, z);
        } else {
            this.b0 = textView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            n0();
        }
        this.c.I();
        Z();
        if (this.T == 2) {
            int i = this.V;
            if (z2 && isEnabled()) {
                this.V = this.a0;
            } else {
                this.V = this.W;
            }
            if (this.V != i) {
                X();
            }
        }
        if (this.T == 1) {
            if (!isEnabled()) {
                this.c0 = this.u0;
            } else if (z && !z2) {
                this.c0 = this.w0;
            } else if (z2) {
                this.c0 = this.v0;
            } else {
                this.c0 = this.t0;
            }
        }
        m();
    }

    public boolean M() {
        return this.c.F();
    }

    public boolean N() {
        return this.j.A();
    }

    public boolean O() {
        return this.j.B();
    }

    final boolean P() {
        return this.z0;
    }

    public boolean R() {
        return this.J;
    }

    public void Z() {
        this.b.m();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.a.addView(view, layoutParams2);
        this.a.setLayoutParams(layoutParams);
        t0();
        setEditText((EditText) view);
    }

    void c0(TextView textView, int i) {
        try {
            j23.p(textView, i);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        j23.p(textView, R$style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(q30.c(getContext(), R$color.design_error));
    }

    boolean d0() {
        return this.j.l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.e != null) {
            boolean z = this.J;
            this.J = false;
            CharSequence hint = editText.getHint();
            this.d.setHint(this.e);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.d.setHint(hint);
                this.J = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.a.getChildCount());
        for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
            View childAt = this.a.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.F0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.F0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.E0) {
            return;
        }
        this.E0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.A0;
        boolean zI0 = aVar != null ? aVar.I0(drawableState) : false;
        if (this.d != null) {
            u0(be3.T(this) && isEnabled());
        }
        p0();
        A0();
        if (zI0) {
            invalidate();
        }
        this.E0 = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.d;
        return editText != null ? editText.getBaseline() + getPaddingTop() + v() : super.getBaseline();
    }

    tg1 getBoxBackground() {
        int i = this.T;
        if (i == 1 || i == 2) {
            return this.K;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.c0;
    }

    public int getBoxBackgroundMode() {
        return this.T;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.U;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return nf3.o(this) ? this.Q.j().a(this.f0) : this.Q.l().a(this.f0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return nf3.o(this) ? this.Q.l().a(this.f0) : this.Q.j().a(this.f0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return nf3.o(this) ? this.Q.r().a(this.f0) : this.Q.t().a(this.f0);
    }

    public float getBoxCornerRadiusTopStart() {
        return nf3.o(this) ? this.Q.t().a(this.f0) : this.Q.r().a(this.f0);
    }

    public int getBoxStrokeColor() {
        return this.r0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.s0;
    }

    public int getBoxStrokeWidth() {
        return this.W;
    }

    public int getBoxStrokeWidthFocused() {
        return this.a0;
    }

    public int getCounterMaxLength() {
        return this.l;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.k && this.m && (textView = this.o) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.z;
    }

    public ColorStateList getCounterTextColor() {
        return this.y;
    }

    public ColorStateList getCursorColor() {
        return this.F;
    }

    public ColorStateList getCursorErrorColor() {
        return this.G;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.n0;
    }

    public EditText getEditText() {
        return this.d;
    }

    public CharSequence getEndIconContentDescription() {
        return this.c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.c.n();
    }

    public int getEndIconMinSize() {
        return this.c.o();
    }

    public int getEndIconMode() {
        return this.c.p();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.c.q();
    }

    CheckableImageButton getEndIconView() {
        return this.c.r();
    }

    public CharSequence getError() {
        if (this.j.A()) {
            return this.j.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.j.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.j.o();
    }

    public int getErrorCurrentTextColors() {
        return this.j.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.c.s();
    }

    public CharSequence getHelperText() {
        if (this.j.B()) {
            return this.j.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.j.u();
    }

    public CharSequence getHint() {
        if (this.H) {
            return this.I;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.A0.r();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.A0.w();
    }

    public ColorStateList getHintTextColor() {
        return this.o0;
    }

    public e getLengthCounter() {
        return this.n;
    }

    public int getMaxEms() {
        return this.g;
    }

    public int getMaxWidth() {
        return this.i;
    }

    public int getMinEms() {
        return this.f;
    }

    public int getMinWidth() {
        return this.h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.s) {
            return this.r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.u;
    }

    public CharSequence getPrefixText() {
        return this.b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.b.b();
    }

    public TextView getPrefixTextView() {
        return this.b.d();
    }

    public sn2 getShapeAppearanceModel() {
        return this.Q;
    }

    public CharSequence getStartIconContentDescription() {
        return this.b.e();
    }

    public Drawable getStartIconDrawable() {
        return this.b.f();
    }

    public int getStartIconMinSize() {
        return this.b.g();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.b.h();
    }

    public CharSequence getSuffixText() {
        return this.c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.c.x();
    }

    public TextView getSuffixTextView() {
        return this.c.z();
    }

    public Typeface getTypeface() {
        return this.g0;
    }

    public void i(f fVar) {
        this.j0.add(fVar);
        if (this.d != null) {
            fVar.a(this);
        }
    }

    void k0(Editable editable) {
        int iA = this.n.a(editable);
        boolean z = this.m;
        int i = this.l;
        if (i == -1) {
            this.o.setText(String.valueOf(iA));
            this.o.setContentDescription(null);
            this.m = false;
        } else {
            this.m = iA > i;
            l0(getContext(), this.o, iA, this.l, this.m);
            if (z != this.m) {
                m0();
            }
            this.o.setText(qh.c().j(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(iA), Integer.valueOf(this.l))));
        }
        if (this.d == null || z == this.m) {
            return;
        }
        u0(false);
        A0();
        p0();
    }

    void l(float f2) {
        if (this.A0.F() == f2) {
            return;
        }
        if (this.D0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.D0 = valueAnimator;
            valueAnimator.setInterpolator(el1.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, y6.b));
            this.D0.setDuration(el1.f(getContext(), R$attr.motionDurationMedium4, Opcodes.GOTO));
            this.D0.addUpdateListener(new c());
        }
        this.D0.setFloatValues(this.A0.F(), f2);
        this.D0.start();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    boolean o0() {
        boolean z;
        if (this.d == null) {
            return false;
        }
        boolean z2 = true;
        if (f0()) {
            int measuredWidth = this.b.getMeasuredWidth() - this.d.getPaddingLeft();
            if (this.h0 == null || this.i0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.h0 = colorDrawable;
                this.i0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = j23.a(this.d);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.h0;
            if (drawable != drawable2) {
                j23.j(this.d, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z = true;
            } else {
                z = false;
            }
        } else if (this.h0 != null) {
            Drawable[] drawableArrA2 = j23.a(this.d);
            j23.j(this.d, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
            this.h0 = null;
            z = true;
        } else {
            z = false;
        }
        if (e0()) {
            int measuredWidth2 = this.c.z().getMeasuredWidth() - this.d.getPaddingRight();
            CheckableImageButton checkableImageButtonK = this.c.k();
            if (checkableImageButtonK != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonK.getMeasuredWidth() + uf1.b((ViewGroup.MarginLayoutParams) checkableImageButtonK.getLayoutParams());
            }
            Drawable[] drawableArrA3 = j23.a(this.d);
            Drawable drawable3 = this.k0;
            if (drawable3 == null || this.l0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.k0 = colorDrawable2;
                    this.l0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = drawableArrA3[2];
                Drawable drawable5 = this.k0;
                if (drawable4 != drawable5) {
                    this.m0 = drawable4;
                    j23.j(this.d, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.l0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                j23.j(this.d, drawableArrA3[0], drawableArrA3[1], this.k0, drawableArrA3[3]);
            }
        } else {
            if (this.k0 == null) {
                return z;
            }
            Drawable[] drawableArrA4 = j23.a(this.d);
            if (drawableArrA4[2] == this.k0) {
                j23.j(this.d, drawableArrA4[0], drawableArrA4[1], this.m0, drawableArrA4[3]);
            } else {
                z2 = z;
            }
            this.k0 = null;
        }
        return z2;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.A0.Y(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.G0 = false;
        boolean zS0 = s0();
        boolean zO0 = o0();
        if (zS0 || zO0) {
            this.d.post(new Runnable() { // from class: c23
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.U();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.d;
        if (editText != null) {
            Rect rect = this.d0;
            m90.a(this, editText, rect);
            i0(rect);
            if (this.H) {
                this.A0.v0(this.d.getTextSize());
                int gravity = this.d.getGravity();
                this.A0.j0((gravity & (-113)) | 48);
                this.A0.u0(gravity);
                this.A0.f0(r(rect));
                this.A0.p0(u(rect));
                this.A0.a0();
                if (!B() || this.z0) {
                    return;
                }
                W();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.G0) {
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.G0 = true;
        }
        w0();
        this.c.x0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.a);
        if (savedState.b) {
            post(new b());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = i == 1;
        if (z != this.R) {
            float fA = this.Q.r().a(this.f0);
            float fA2 = this.Q.t().a(this.f0);
            sn2 sn2VarM = sn2.a().D(this.Q.s()).H(this.Q.q()).u(this.Q.k()).y(this.Q.i()).E(fA2).I(fA).v(this.Q.l().a(this.f0)).z(this.Q.j().a(this.f0)).m();
            this.R = z;
            setShapeAppearanceModel(sn2VarM);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (d0()) {
            savedState.a = getError();
        }
        savedState.b = this.c.E();
        return savedState;
    }

    void p0() {
        Drawable background;
        TextView textView;
        EditText editText = this.d;
        if (editText == null || this.T != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.s.a(background)) {
            background = background.mutate();
        }
        if (d0()) {
            background.setColorFilter(androidx.appcompat.widget.g.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.m && (textView = this.o) != null) {
            background.setColorFilter(androidx.appcompat.widget.g.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            dd0.c(background);
            this.d.refreshDrawableState();
        }
    }

    void r0() {
        EditText editText = this.d;
        if (editText == null || this.K == null) {
            return;
        }
        if ((this.N || editText.getBackground() == null) && this.T != 0) {
            q0();
            this.N = true;
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.c0 != i) {
            this.c0 = i;
            this.t0 = i;
            this.v0 = i;
            this.w0 = i;
            m();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(q30.c(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.t0 = defaultColor;
        this.c0 = defaultColor;
        this.u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.v0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.w0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.T) {
            return;
        }
        this.T = i;
        if (this.d != null) {
            V();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.U = i;
    }

    public void setBoxCornerFamily(int i) {
        this.Q = this.Q.v().C(i, this.Q.r()).G(i, this.Q.t()).t(i, this.Q.j()).x(i, this.Q.l()).m();
        m();
    }

    public void setBoxStrokeColor(int i) {
        if (this.r0 != i) {
            this.r0 = i;
            A0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.p0 = colorStateList.getDefaultColor();
            this.x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.q0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.r0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.r0 != colorStateList.getDefaultColor()) {
            this.r0 = colorStateList.getDefaultColor();
        }
        A0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.s0 != colorStateList) {
            this.s0 = colorStateList;
            A0();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.W = i;
        A0();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.a0 = i;
        A0();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.k != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.o = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.g0;
                if (typeface != null) {
                    this.o.setTypeface(typeface);
                }
                this.o.setMaxLines(1);
                this.j.e(this.o, 2);
                uf1.d((ViewGroup.MarginLayoutParams) this.o.getLayoutParams(), getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                m0();
                j0();
            } else {
                this.j.C(this.o, 2);
                this.o = null;
            }
            this.k = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.l != i) {
            if (i > 0) {
                this.l = i;
            } else {
                this.l = -1;
            }
            if (this.k) {
                j0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.p != i) {
            this.p = i;
            m0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.z != colorStateList) {
            this.z = colorStateList;
            m0();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.f271q != i) {
            this.f271q = i;
            m0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            m0();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            n0();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            if (Q()) {
                n0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.n0 = colorStateList;
        this.o0 = colorStateList;
        if (this.d != null) {
            u0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Y(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.c.N(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.c.O(z);
    }

    public void setEndIconContentDescription(int i) {
        this.c.P(i);
    }

    public void setEndIconDrawable(int i) {
        this.c.R(i);
    }

    public void setEndIconMinSize(int i) {
        this.c.T(i);
    }

    public void setEndIconMode(int i) {
        this.c.U(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.c.V(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.c.W(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.c.X(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.c.Y(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.c.Z(mode);
    }

    public void setEndIconVisible(boolean z) {
        this.c.a0(z);
    }

    public void setError(CharSequence charSequence) {
        if (!this.j.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.j.w();
        } else {
            this.j.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        this.j.E(i);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.j.F(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.j.G(z);
    }

    public void setErrorIconDrawable(int i) {
        this.c.b0(i);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.c.f0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.c.g0(mode);
    }

    public void setErrorTextAppearance(int i) {
        this.j.H(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.j.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.B0 != z) {
            this.B0 = z;
            u0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (O()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!O()) {
                setHelperTextEnabled(true);
            }
            this.j.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.j.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.j.K(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.j.J(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.H) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.C0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.H) {
            this.H = z;
            if (z) {
                CharSequence hint = this.d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.I)) {
                        setHint(hint);
                    }
                    this.d.setHint((CharSequence) null);
                }
                this.J = true;
            } else {
                this.J = false;
                if (!TextUtils.isEmpty(this.I) && TextUtils.isEmpty(this.d.getHint())) {
                    this.d.setHint(this.I);
                }
                setHintInternal(null);
            }
            if (this.d != null) {
                t0();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.A0.g0(i);
        this.o0 = this.A0.p();
        if (this.d != null) {
            u0(false);
            t0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.o0 != colorStateList) {
            if (this.n0 == null) {
                this.A0.i0(colorStateList);
            }
            this.o0 = colorStateList;
            if (this.d != null) {
                u0(false);
            }
        }
    }

    public void setLengthCounter(e eVar) {
        this.n = eVar;
    }

    public void setMaxEms(int i) {
        this.g = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(int i) {
        this.i = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.f = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(int i) {
        this.h = i;
        EditText editText = this.d;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        this.c.i0(i);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        this.c.k0(i);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        this.c.m0(z);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.c.n0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.c.o0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.t == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.t = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            be3.z0(this.t, 2);
            bk0 bk0VarA = A();
            this.w = bk0VarA;
            bk0VarA.c0(67L);
            this.x = A();
            setPlaceholderTextAppearance(this.v);
            setPlaceholderTextColor(this.u);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.s) {
                setPlaceholderTextEnabled(true);
            }
            this.r = charSequence;
        }
        x0();
    }

    public void setPlaceholderTextAppearance(int i) {
        this.v = i;
        TextView textView = this.t;
        if (textView != null) {
            j23.p(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            TextView textView = this.t;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.b.n(charSequence);
    }

    public void setPrefixTextAppearance(int i) {
        this.b.o(i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.b.p(colorStateList);
    }

    public void setShapeAppearanceModel(sn2 sn2Var) {
        tg1 tg1Var = this.K;
        if (tg1Var == null || tg1Var.E() == sn2Var) {
            return;
        }
        this.Q = sn2Var;
        m();
    }

    public void setStartIconCheckable(boolean z) {
        this.b.q(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? v8.b(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        this.b.t(i);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.b.u(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b.v(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.b.w(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.b.x(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.b.y(mode);
    }

    public void setStartIconVisible(boolean z) {
        this.b.z(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.c.p0(charSequence);
    }

    public void setSuffixTextAppearance(int i) {
        this.c.q0(i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.c.r0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(d dVar) {
        EditText editText = this.d;
        if (editText != null) {
            be3.p0(editText, dVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.g0) {
            this.g0 = typeface;
            this.A0.N0(typeface);
            this.j.N(typeface);
            TextView textView = this.o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void u0(boolean z) {
        v0(z, false);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.c.Q(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.c.S(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.c.l0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.b.r(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.b.s(drawable);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = H0;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = new u(this);
        this.n = new e() { // from class: d23
            @Override // com.google.android.material.textfield.TextInputLayout.e
            public final int a(Editable editable) {
                return TextInputLayout.T(editable);
            }
        };
        this.d0 = new Rect();
        this.e0 = new Rect();
        this.f0 = new RectF();
        this.j0 = new LinkedHashSet();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.A0 = aVar;
        this.G0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = y6.a;
        aVar.L0(timeInterpolator);
        aVar.G0(timeInterpolator);
        aVar.j0(8388659);
        int[] iArr = R$styleable.TextInputLayout;
        int i3 = R$styleable.TextInputLayout_counterTextAppearance;
        int i4 = R$styleable.TextInputLayout_counterOverflowTextAppearance;
        int i5 = R$styleable.TextInputLayout_errorTextAppearance;
        int i6 = R$styleable.TextInputLayout_helperTextTextAppearance;
        int i7 = R$styleable.TextInputLayout_hintTextAppearance;
        e0 e0VarJ = o23.j(context2, attributeSet, iArr, i, i2, i3, i4, i5, i6, i7);
        y yVar = new y(this, e0VarJ);
        this.b = yVar;
        this.H = e0VarJ.a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(e0VarJ.p(R$styleable.TextInputLayout_android_hint));
        this.C0 = e0VarJ.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.B0 = e0VarJ.a(R$styleable.TextInputLayout_expandedHintEnabled, true);
        int i8 = R$styleable.TextInputLayout_android_minEms;
        if (e0VarJ.s(i8)) {
            setMinEms(e0VarJ.k(i8, -1));
        } else {
            int i9 = R$styleable.TextInputLayout_android_minWidth;
            if (e0VarJ.s(i9)) {
                setMinWidth(e0VarJ.f(i9, -1));
            }
        }
        int i10 = R$styleable.TextInputLayout_android_maxEms;
        if (e0VarJ.s(i10)) {
            setMaxEms(e0VarJ.k(i10, -1));
        } else {
            int i11 = R$styleable.TextInputLayout_android_maxWidth;
            if (e0VarJ.s(i11)) {
                setMaxWidth(e0VarJ.f(i11, -1));
            }
        }
        this.Q = sn2.e(context2, attributeSet, i, i2).m();
        this.S = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.U = e0VarJ.e(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.W = e0VarJ.f(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.a0 = e0VarJ.f(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.V = this.W;
        float fD = e0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fD2 = e0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fD3 = e0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fD4 = e0VarJ.d(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        sn2.b bVarV = this.Q.v();
        if (fD >= 0.0f) {
            bVarV.E(fD);
        }
        if (fD2 >= 0.0f) {
            bVarV.I(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarV.z(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarV.v(fD4);
        }
        this.Q = bVarV.m();
        ColorStateList colorStateListB = sg1.b(context2, e0VarJ, R$styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.t0 = defaultColor;
            this.c0 = defaultColor;
            if (colorStateListB.isStateful()) {
                this.u0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.v0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.w0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.v0 = this.t0;
                ColorStateList colorStateListA = v8.a(context2, R$color.mtrl_filled_background_color);
                this.u0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.w0 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.c0 = 0;
            this.t0 = 0;
            this.u0 = 0;
            this.v0 = 0;
            this.w0 = 0;
        }
        int i12 = R$styleable.TextInputLayout_android_textColorHint;
        if (e0VarJ.s(i12)) {
            ColorStateList colorStateListC = e0VarJ.c(i12);
            this.o0 = colorStateListC;
            this.n0 = colorStateListC;
        }
        int i13 = R$styleable.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateListB2 = sg1.b(context2, e0VarJ, i13);
        this.r0 = e0VarJ.b(i13, 0);
        this.p0 = q30.c(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.x0 = q30.c(context2, R$color.mtrl_textinput_disabled_color);
        this.q0 = q30.c(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i14 = R$styleable.TextInputLayout_boxStrokeErrorColor;
        if (e0VarJ.s(i14)) {
            setBoxStrokeErrorColor(sg1.b(context2, e0VarJ, i14));
        }
        if (e0VarJ.n(i7, -1) != -1) {
            setHintTextAppearance(e0VarJ.n(i7, 0));
        }
        this.F = e0VarJ.c(R$styleable.TextInputLayout_cursorColor);
        this.G = e0VarJ.c(R$styleable.TextInputLayout_cursorErrorColor);
        int iN = e0VarJ.n(i5, 0);
        CharSequence charSequenceP = e0VarJ.p(R$styleable.TextInputLayout_errorContentDescription);
        int iK = e0VarJ.k(R$styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean zA = e0VarJ.a(R$styleable.TextInputLayout_errorEnabled, false);
        int iN2 = e0VarJ.n(i6, 0);
        boolean zA2 = e0VarJ.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceP2 = e0VarJ.p(R$styleable.TextInputLayout_helperText);
        int iN3 = e0VarJ.n(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceP3 = e0VarJ.p(R$styleable.TextInputLayout_placeholderText);
        boolean zA3 = e0VarJ.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(e0VarJ.k(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.f271q = e0VarJ.n(i3, 0);
        this.p = e0VarJ.n(i4, 0);
        setBoxBackgroundMode(e0VarJ.k(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(charSequenceP);
        setErrorAccessibilityLiveRegion(iK);
        setCounterOverflowTextAppearance(this.p);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.f271q);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        int i15 = R$styleable.TextInputLayout_errorTextColor;
        if (e0VarJ.s(i15)) {
            setErrorTextColor(e0VarJ.c(i15));
        }
        int i16 = R$styleable.TextInputLayout_helperTextTextColor;
        if (e0VarJ.s(i16)) {
            setHelperTextColor(e0VarJ.c(i16));
        }
        int i17 = R$styleable.TextInputLayout_hintTextColor;
        if (e0VarJ.s(i17)) {
            setHintTextColor(e0VarJ.c(i17));
        }
        int i18 = R$styleable.TextInputLayout_counterTextColor;
        if (e0VarJ.s(i18)) {
            setCounterTextColor(e0VarJ.c(i18));
        }
        int i19 = R$styleable.TextInputLayout_counterOverflowTextColor;
        if (e0VarJ.s(i19)) {
            setCounterOverflowTextColor(e0VarJ.c(i19));
        }
        int i20 = R$styleable.TextInputLayout_placeholderTextColor;
        if (e0VarJ.s(i20)) {
            setPlaceholderTextColor(e0VarJ.c(i20));
        }
        r rVar = new r(this, e0VarJ);
        this.c = rVar;
        boolean zA4 = e0VarJ.a(R$styleable.TextInputLayout_android_enabled, true);
        e0VarJ.x();
        be3.z0(this, 2);
        be3.B0(this, 1);
        frameLayout.addView(yVar);
        frameLayout.addView(rVar);
        addView(frameLayout);
        setEnabled(zA4);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }
}
