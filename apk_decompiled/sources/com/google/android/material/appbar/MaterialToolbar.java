package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import defpackage.be3;
import defpackage.dd0;
import defpackage.f43;
import defpackage.o23;
import defpackage.qd0;
import defpackage.tg1;
import defpackage.ug1;
import defpackage.yg1;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialToolbar extends Toolbar {
    private static final int h0 = R$style.Widget_MaterialComponents_Toolbar;
    private static final ImageView.ScaleType[] i0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private Integer c0;
    private boolean d0;
    private boolean e0;
    private ImageView.ScaleType f0;
    private Boolean g0;

    public MaterialToolbar(Context context) {
        this(context, null);
    }

    private Pair S(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void T(Context context) {
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : qd0.g(background);
        if (colorStateListValueOf != null) {
            tg1 tg1Var = new tg1();
            tg1Var.b0(colorStateListValueOf);
            tg1Var.Q(context);
            tg1Var.a0(be3.v(this));
            be3.t0(this, tg1Var);
        }
    }

    private void U(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i, view.getTop(), i2, view.getBottom());
    }

    private void V() {
        if (this.d0 || this.e0) {
            TextView textViewG = f43.g(this);
            TextView textViewE = f43.e(this);
            if (textViewG == null && textViewE == null) {
                return;
            }
            Pair pairS = S(textViewG, textViewE);
            if (this.d0 && textViewG != null) {
                U(textViewG, pairS);
            }
            if (!this.e0 || textViewE == null) {
                return;
            }
            U(textViewE, pairS);
        }
    }

    private Drawable W(Drawable drawable) {
        if (drawable == null || this.c0 == null) {
            return drawable;
        }
        Drawable drawableR = dd0.r(drawable.mutate());
        dd0.n(drawableR, this.c0.intValue());
        return drawableR;
    }

    private void X() {
        ImageView imageViewC = f43.c(this);
        if (imageViewC != null) {
            Boolean bool = this.g0;
            if (bool != null) {
                imageViewC.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f0;
            if (scaleType != null) {
                imageViewC.setScaleType(scaleType);
            }
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f0;
    }

    public Integer getNavigationIconTint() {
        return this.c0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ug1.e(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        V();
        X();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        ug1.d(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.g0;
        if (bool == null || bool.booleanValue() != z) {
            this.g0 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f0 != scaleType) {
            this.f0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(W(drawable));
    }

    public void setNavigationIconTint(int i) {
        this.c0 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.e0 != z) {
            this.e0 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.d0 != z) {
            this.d0 = z;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void x(int i) {
        Menu menu = getMenu();
        boolean z = menu instanceof androidx.appcompat.view.menu.e;
        if (z) {
            ((androidx.appcompat.view.menu.e) menu).i0();
        }
        super.x(i);
        if (z) {
            ((androidx.appcompat.view.menu.e) menu).h0();
        }
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        int i2 = h0;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.MaterialToolbar, i, i2, new int[0]);
        int i3 = R$styleable.MaterialToolbar_navigationIconTint;
        if (typedArrayI.hasValue(i3)) {
            setNavigationIconTint(typedArrayI.getColor(i3, -1));
        }
        this.d0 = typedArrayI.getBoolean(R$styleable.MaterialToolbar_titleCentered, false);
        this.e0 = typedArrayI.getBoolean(R$styleable.MaterialToolbar_subtitleCentered, false);
        int i4 = typedArrayI.getInt(R$styleable.MaterialToolbar_logoScaleType, -1);
        if (i4 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = i0;
            if (i4 < scaleTypeArr.length) {
                this.f0 = scaleTypeArr[i4];
            }
        }
        int i5 = R$styleable.MaterialToolbar_logoAdjustViewBounds;
        if (typedArrayI.hasValue(i5)) {
            this.g0 = Boolean.valueOf(typedArrayI.getBoolean(i5, false));
        }
        typedArrayI.recycle();
        T(context2);
    }
}
