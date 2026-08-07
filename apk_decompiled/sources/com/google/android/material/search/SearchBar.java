package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import defpackage.be3;
import defpackage.dd0;
import defpackage.f43;
import defpackage.j23;
import defpackage.o23;
import defpackage.og1;
import defpackage.sn2;
import defpackage.tg1;
import defpackage.uf1;
import defpackage.ug1;
import defpackage.v1;
import defpackage.v8;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class SearchBar extends Toolbar {
    private static final int r0 = R$style.Widget_Material3_SearchBar;
    private final TextView c0;
    private final boolean d0;
    private final boolean e0;
    private final com.google.android.material.search.a f0;
    private final Drawable g0;
    private final boolean h0;
    private final boolean i0;
    private View j0;
    private Integer k0;
    private Drawable l0;
    private int m0;
    private boolean n0;
    private tg1 o0;
    private final AccessibilityManager p0;
    private final v1.a q0;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String a;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            v1.a(SearchBar.this.p0, SearchBar.this.q0);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            v1.b(SearchBar.this.p0, SearchBar.this.q0);
        }
    }

    public SearchBar(Context context) {
        this(context, null);
    }

    private int V(int i, int i2) {
        return i == 0 ? i2 : i;
    }

    private void W(sn2 sn2Var, int i, float f, float f2, int i2) {
        tg1 tg1Var = new tg1(sn2Var);
        this.o0 = tg1Var;
        tg1Var.Q(getContext());
        this.o0.a0(f);
        if (f2 >= 0.0f) {
            this.o0.j0(f2, i2);
        }
        int iD = og1.d(this, R$attr.colorControlHighlight);
        this.o0.b0(ColorStateList.valueOf(i));
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iD);
        tg1 tg1Var2 = this.o0;
        be3.t0(this, new RippleDrawable(colorStateListValueOf, tg1Var2, tg1Var2));
    }

    private void X() {
        setNavigationIcon(getNavigationIcon() == null ? this.g0 : getNavigationIcon());
        setNavigationIconDecorative(true);
    }

    private void Y(int i, String str, String str2) {
        if (i != -1) {
            j23.p(this.c0, i);
        }
        setText(str);
        setHint(str2);
        if (getNavigationIcon() == null) {
            uf1.d((ViewGroup.MarginLayoutParams) this.c0.getLayoutParams(), getResources().getDimensionPixelSize(R$dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(boolean z) {
        setFocusableInTouchMode(z);
    }

    private void a0() {
        View view = this.j0;
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int i = measuredWidth2 + measuredWidth;
        int measuredHeight = this.j0.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        b0(this.j0, measuredWidth2, measuredHeight2, i, measuredHeight2 + measuredHeight);
    }

    private void b0(View view, int i, int i2, int i3, int i4) {
        if (be3.A(this) == 1) {
            view.layout(getMeasuredWidth() - i3, i2, getMeasuredWidth() - i, i4);
        } else {
            view.layout(i, i2, i3, i4);
        }
    }

    private Drawable c0(Drawable drawable) {
        int iD;
        if (!this.h0 || drawable == null) {
            return drawable;
        }
        Integer num = this.k0;
        if (num != null) {
            iD = num.intValue();
        } else {
            iD = og1.d(this, drawable == this.g0 ? R$attr.colorOnSurfaceVariant : R$attr.colorOnSurface);
        }
        Drawable drawableR = dd0.r(drawable.mutate());
        dd0.n(drawableR, iD);
        return drawableR;
    }

    private void d0(int i, int i2) {
        View view = this.j0;
        if (view != null) {
            view.measure(i, i2);
        }
    }

    private void e0() {
        if (this.e0 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = V(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = V(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = V(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = V(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void f0() {
        int width;
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        int right = 0;
        boolean z = getLayoutDirection() == 1;
        ImageButton imageButtonD = f43.d(this);
        if (imageButtonD == null || !imageButtonD.isClickable()) {
            width = 0;
        } else {
            width = z ? getWidth() - imageButtonD.getLeft() : imageButtonD.getRight();
        }
        ActionMenuView actionMenuViewA = f43.a(this);
        if (actionMenuViewA != null) {
            right = z ? actionMenuViewA.getRight() : getWidth() - actionMenuViewA.getLeft();
        }
        float f = -(z ? right : width);
        if (!z) {
            width = right;
        }
        setHandwritingBoundsOffsets(f, 0.0f, -width, 0.0f);
    }

    private void g0() {
        if (getLayoutParams() instanceof AppBarLayout.e) {
            AppBarLayout.e eVar = (AppBarLayout.e) getLayoutParams();
            if (this.n0) {
                if (eVar.c() == 0) {
                    eVar.g(53);
                }
            } else if (eVar.c() == 53) {
                eVar.g(0);
            }
        }
    }

    private void h0() {
        AccessibilityManager accessibilityManager = this.p0;
        if (accessibilityManager != null) {
            if (accessibilityManager.isEnabled() && this.p0.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new a());
        }
    }

    private void j0(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "title") != null) {
            throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "subtitle") != null) {
            throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
        }
    }

    private void setNavigationIconDecorative(boolean z) {
        ImageButton imageButtonD = f43.d(this);
        if (imageButtonD == null) {
            return;
        }
        imageButtonD.setClickable(!z);
        imageButtonD.setFocusable(!z);
        Drawable background = imageButtonD.getBackground();
        if (background != null) {
            this.l0 = background;
        }
        imageButtonD.setBackgroundDrawable(z ? null : this.l0);
        f0();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.d0 && this.j0 == null && !(view instanceof ActionMenuView)) {
            this.j0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i, layoutParams);
    }

    public View getCenterView() {
        return this.j0;
    }

    float getCompatElevation() {
        tg1 tg1Var = this.o0;
        return tg1Var != null ? tg1Var.w() : be3.v(this);
    }

    public float getCornerSize() {
        return this.o0.J();
    }

    protected int getDefaultMarginVerticalResource() {
        return R$dimen.m3_searchbar_margin_vertical;
    }

    protected int getDefaultNavigationIconResource() {
        return R$drawable.ic_search_black_24;
    }

    public CharSequence getHint() {
        return this.c0.getHint();
    }

    int getMenuResId() {
        return this.m0;
    }

    public int getStrokeColor() {
        return this.o0.F().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.o0.H();
    }

    public CharSequence getText() {
        return this.c0.getText();
    }

    public TextView getTextView() {
        return this.c0;
    }

    public void i0() {
        this.f0.b(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ug1.f(this, this.o0);
        e0();
        g0();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        accessibilityNodeInfo.setHintText(getHint());
        accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        if (zIsEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a0();
        f0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d0(i, i2);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.a);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.a = text == null ? null : text.toString();
        return savedState;
    }

    public void setCenterView(View view) {
        View view2 = this.j0;
        if (view2 != null) {
            removeView(view2);
            this.j0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z) {
        this.n0 = z;
        g0();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        tg1 tg1Var = this.o0;
        if (tg1Var != null) {
            tg1Var.a0(f);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.c0.setHint(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(c0(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.i0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z) {
        this.f0.a(z);
    }

    public void setStrokeColor(int i) {
        if (getStrokeColor() != i) {
            this.o0.l0(ColorStateList.valueOf(i));
        }
    }

    public void setStrokeWidth(float f) {
        if (getStrokeWidth() != f) {
            this.o0.m0(f);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(CharSequence charSequence) {
        this.c0.setText(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i) {
        Menu menu = getMenu();
        boolean z = menu instanceof androidx.appcompat.view.menu.e;
        if (z) {
            ((androidx.appcompat.view.menu.e) menu).i0();
        }
        super.x(i);
        this.m0 = i;
        if (z) {
            ((androidx.appcompat.view.menu.e) menu).h0();
        }
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean h;

        public ScrollingViewBehavior() {
            this.h = false;
        }

        private void Y(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.b
        protected boolean T() {
            return true;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean zL = super.l(coordinatorLayout, view, view2);
            if (!this.h && (view2 instanceof AppBarLayout)) {
                this.h = true;
                Y((AppBarLayout) view2);
            }
            return zL;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = false;
        }
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSearchBarStyle);
    }

    public void setHint(int i) {
        this.c0.setHint(i);
    }

    public void setText(int i) {
        this.c0.setText(i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchBar(Context context, AttributeSet attributeSet, int i) {
        int i2 = r0;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.m0 = -1;
        this.q0 = new v1.a() { // from class: ql2
            @Override // v1.a
            public final void onTouchExplorationStateChanged(boolean z) {
                this.a.Z(z);
            }
        };
        Context context2 = getContext();
        j0(attributeSet);
        this.g0 = v8.b(context2, getDefaultNavigationIconResource());
        this.f0 = new com.google.android.material.search.a();
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.SearchBar, i, i2, new int[0]);
        sn2 sn2VarM = sn2.e(context2, attributeSet, i, i2).m();
        int color = typedArrayI.getColor(R$styleable.SearchBar_backgroundTint, 0);
        float dimension = typedArrayI.getDimension(R$styleable.SearchBar_elevation, 0.0f);
        this.e0 = typedArrayI.getBoolean(R$styleable.SearchBar_defaultMarginsEnabled, true);
        this.n0 = typedArrayI.getBoolean(R$styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean z = typedArrayI.getBoolean(R$styleable.SearchBar_hideNavigationIcon, false);
        this.i0 = typedArrayI.getBoolean(R$styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.h0 = typedArrayI.getBoolean(R$styleable.SearchBar_tintNavigationIcon, true);
        int i3 = R$styleable.SearchBar_navigationIconTint;
        if (typedArrayI.hasValue(i3)) {
            this.k0 = Integer.valueOf(typedArrayI.getColor(i3, -1));
        }
        int resourceId = typedArrayI.getResourceId(R$styleable.SearchBar_android_textAppearance, -1);
        String string = typedArrayI.getString(R$styleable.SearchBar_android_text);
        String string2 = typedArrayI.getString(R$styleable.SearchBar_android_hint);
        float dimension2 = typedArrayI.getDimension(R$styleable.SearchBar_strokeWidth, -1.0f);
        int color2 = typedArrayI.getColor(R$styleable.SearchBar_strokeColor, 0);
        typedArrayI.recycle();
        if (!z) {
            X();
        }
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(context2).inflate(R$layout.mtrl_search_bar, this);
        this.d0 = true;
        this.c0 = (TextView) findViewById(R$id.open_search_bar_text_view);
        be3.x0(this, dimension);
        Y(resourceId, string, string2);
        W(sn2VarM, color, dimension, dimension2, color2);
        this.p0 = (AccessibilityManager) getContext().getSystemService("accessibility");
        h0();
    }
}
