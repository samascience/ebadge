package com.github.clans.fab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionMenu extends ViewGroup {
    private int F;
    private float G;
    private float H;
    private float I;
    private int J;
    private int K;
    private int L;
    private Drawable M;
    private int N;
    private Interpolator O;
    private Interpolator P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private int U;
    private int V;
    private Typeface W;
    private AnimatorSet a;
    private boolean a0;
    private AnimatorSet b;
    private ImageView b0;
    private AnimatorSet c;
    private Animation c0;
    private int d;
    private Animation d0;
    private FloatingActionButton e;
    private Animation e0;
    private int f;
    private Animation f0;
    private int g;
    private boolean g0;
    private int h;
    private int h0;
    private int i;
    private ValueAnimator i0;
    private boolean j;
    private ValueAnimator j0;
    private boolean k;
    private int k0;
    private Handler l;
    private int l0;
    private int m;
    private Context m0;
    private int n;
    private String n0;
    private int o;
    private boolean o0;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f232q;
    private int r;
    private ColorStateList s;
    private float t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.a, this.b, this.c));
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        b(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatingActionMenu.this.setBackgroundColor(Color.argb(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.a, this.b, this.c));
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FloatingActionMenu floatingActionMenu = FloatingActionMenu.this;
            floatingActionMenu.u(floatingActionMenu.Q);
        }
    }

    class d implements Runnable {
        final /* synthetic */ FloatingActionButton a;
        final /* synthetic */ boolean b;

        d(FloatingActionButton floatingActionButton, boolean z) {
            this.a = floatingActionButton;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingActionMenu.this.s()) {
                return;
            }
            if (this.a != FloatingActionMenu.this.e) {
                this.a.I(this.b);
            }
            Label label = (Label) this.a.getTag(R$id.fab_label);
            if (label == null || !label.r()) {
                return;
            }
            label.x(this.b);
        }
    }

    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatingActionMenu.this.j = true;
            FloatingActionMenu.d(FloatingActionMenu.this);
        }
    }

    class f implements Runnable {
        final /* synthetic */ FloatingActionButton a;
        final /* synthetic */ boolean b;

        f(FloatingActionButton floatingActionButton, boolean z) {
            this.a = floatingActionButton;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FloatingActionMenu.this.s()) {
                if (this.a != FloatingActionMenu.this.e) {
                    this.a.u(this.b);
                }
                Label label = (Label) this.a.getTag(R$id.fab_label);
                if (label == null || !label.r()) {
                    return;
                }
                label.q(this.b);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FloatingActionMenu.this.j = false;
            FloatingActionMenu.d(FloatingActionMenu.this);
        }
    }

    public interface h {
    }

    public FloatingActionMenu(Context context) {
        this(context, null);
    }

    static /* synthetic */ h d(FloatingActionMenu floatingActionMenu) {
        floatingActionMenu.getClass();
        return null;
    }

    private void e(FloatingActionButton floatingActionButton) {
        String labelText = floatingActionButton.getLabelText();
        if (TextUtils.isEmpty(labelText)) {
            return;
        }
        Label label = new Label(this.m0);
        label.setClickable(true);
        label.setFab(floatingActionButton);
        label.setShowAnimation(AnimationUtils.loadAnimation(getContext(), this.m));
        label.setHideAnimation(AnimationUtils.loadAnimation(getContext(), this.n));
        if (this.V > 0) {
            label.setTextAppearance(getContext(), this.V);
            label.setShowShadow(false);
            label.setUsingStyle(true);
        } else {
            label.w(this.w, this.x, this.y);
            label.setShowShadow(this.v);
            label.setCornerRadius(this.u);
            if (this.S > 0) {
                setLabelEllipsize(label);
            }
            label.setMaxLines(this.T);
            label.y();
            label.setTextSize(0, this.t);
            label.setTextColor(this.s);
            int shadowRadius = this.r;
            int shadowRadius2 = this.o;
            if (this.v) {
                shadowRadius += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowXOffset());
                shadowRadius2 += floatingActionButton.getShadowRadius() + Math.abs(floatingActionButton.getShadowYOffset());
            }
            label.setPadding(shadowRadius, shadowRadius2, this.r, this.o);
            if (this.T < 0 || this.R) {
                label.setSingleLine(this.R);
            }
        }
        Typeface typeface = this.W;
        if (typeface != null) {
            label.setTypeface(typeface);
        }
        label.setText(labelText);
        label.setOnClickListener(floatingActionButton.getOnClickListener());
        addView(label);
        floatingActionButton.setTag(R$id.fab_label, label);
    }

    private int f(int i) {
        double d2 = i;
        return (int) ((0.03d * d2) + d2);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0014 A[PHI: r6
      0x0014: PHI (r6v5 float) = (r6v1 float), (r6v7 float) binds: [B:14:0x001d, B:8:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    private void h() {
        float f2;
        float f3 = 135.0f;
        if (this.h0 == 0) {
            int i = this.l0;
            f2 = i == 0 ? -135.0f : 135.0f;
            if (i == 0) {
                f3 = -135.0f;
            }
        } else {
            int i2 = this.l0;
            f2 = i2 == 0 ? 135.0f : -135.0f;
            if (i2 != 0) {
                f3 = -135.0f;
            }
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.b0, "rotation", f2, 0.0f);
        this.a.play(ObjectAnimator.ofFloat(this.b0, "rotation", 0.0f, f3));
        this.b.play(objectAnimatorOfFloat);
        this.a.setInterpolator(this.O);
        this.b.setInterpolator(this.P);
        this.a.setDuration(300L);
        this.b.setDuration(300L);
    }

    private void i() {
        for (int i = 0; i < this.i; i++) {
            if (getChildAt(i) != this.b0) {
                FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i);
                if (floatingActionButton.getTag(R$id.fab_label) == null) {
                    e(floatingActionButton);
                    FloatingActionButton floatingActionButton2 = this.e;
                    if (floatingActionButton == floatingActionButton2) {
                        floatingActionButton2.setOnClickListener(new c());
                    }
                }
            }
        }
    }

    private void j() {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getContext());
        this.e = floatingActionButton;
        boolean z = this.z;
        floatingActionButton.b = z;
        if (z) {
            floatingActionButton.d = com.github.clans.fab.a.a(getContext(), this.G);
            this.e.e = com.github.clans.fab.a.a(getContext(), this.H);
            this.e.f = com.github.clans.fab.a.a(getContext(), this.I);
        }
        this.e.E(this.J, this.K, this.L);
        FloatingActionButton floatingActionButton2 = this.e;
        floatingActionButton2.c = this.F;
        floatingActionButton2.a = this.U;
        floatingActionButton2.J();
        this.e.setLabelText(this.n0);
        ImageView imageView = new ImageView(getContext());
        this.b0 = imageView;
        imageView.setImageDrawable(this.M);
        addView(this.e, super.generateDefaultLayoutParams());
        addView(this.b0);
        h();
    }

    private void n(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionMenu, 0, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionMenu_menu_buttonSpacing, this.d);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionMenu_menu_labels_margin, this.g);
        int i = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionMenu_menu_labels_position, 0);
        this.l0 = i;
        this.m = typedArrayObtainStyledAttributes.getResourceId(R$styleable.FloatingActionMenu_menu_labels_showAnimation, i == 0 ? R$anim.fab_slide_in_from_right : R$anim.fab_slide_in_from_left);
        this.n = typedArrayObtainStyledAttributes.getResourceId(R$styleable.FloatingActionMenu_menu_labels_hideAnimation, this.l0 == 0 ? R$anim.fab_slide_out_to_right : R$anim.fab_slide_out_to_left);
        this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionMenu_menu_labels_paddingTop, this.o);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionMenu_menu_labels_paddingRight, this.p);
        this.f232q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionMenu_menu_labels_paddingBottom, this.f232q);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionMenu_menu_labels_paddingLeft, this.r);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R$styleable.FloatingActionMenu_menu_labels_textColor);
        this.s = colorStateList;
        if (colorStateList == null) {
            this.s = ColorStateList.valueOf(-1);
        }
        this.t = typedArrayObtainStyledAttributes.getDimension(R$styleable.FloatingActionMenu_menu_labels_textSize, getResources().getDimension(R$dimen.labels_text_size));
        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionMenu_menu_labels_cornerRadius, this.u);
        this.v = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionMenu_menu_labels_showShadow, true);
        this.w = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_labels_colorNormal, -13421773);
        this.x = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_labels_colorPressed, -12303292);
        this.y = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_labels_colorRipple, 1728053247);
        this.z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionMenu_menu_showShadow, true);
        this.F = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_shadowColor, 1711276032);
        this.G = typedArrayObtainStyledAttributes.getDimension(R$styleable.FloatingActionMenu_menu_shadowRadius, this.G);
        this.H = typedArrayObtainStyledAttributes.getDimension(R$styleable.FloatingActionMenu_menu_shadowXOffset, this.H);
        this.I = typedArrayObtainStyledAttributes.getDimension(R$styleable.FloatingActionMenu_menu_shadowYOffset, this.I);
        this.J = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_colorNormal, -2473162);
        this.K = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_colorPressed, -1617853);
        this.L = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_colorRipple, -1711276033);
        this.N = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionMenu_menu_animationDelayPerItem, 50);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.FloatingActionMenu_menu_icon);
        this.M = drawable;
        if (drawable == null) {
            this.M = getResources().getDrawable(R$drawable.fab_add);
        }
        this.R = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionMenu_menu_labels_singleLine, false);
        this.S = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionMenu_menu_labels_ellipsize, 0);
        this.T = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionMenu_menu_labels_maxLines, -1);
        this.U = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionMenu_menu_fab_size, 0);
        this.V = typedArrayObtainStyledAttributes.getResourceId(R$styleable.FloatingActionMenu_menu_labels_style, 0);
        String string = typedArrayObtainStyledAttributes.getString(R$styleable.FloatingActionMenu_menu_labels_customFont);
        try {
            if (!TextUtils.isEmpty(string)) {
                this.W = Typeface.createFromAsset(getContext().getAssets(), string);
            }
            this.h0 = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionMenu_menu_openDirection, 0);
            this.k0 = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionMenu_menu_backgroundColor, 0);
            int i2 = R$styleable.FloatingActionMenu_menu_fab_label;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.o0 = true;
                this.n0 = typedArrayObtainStyledAttributes.getString(i2);
            }
            int i3 = R$styleable.FloatingActionMenu_menu_labels_padding;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                q(typedArrayObtainStyledAttributes.getDimensionPixelSize(i3, 0));
            }
            this.O = new OvershootInterpolator();
            this.P = new AnticipateInterpolator();
            this.m0 = new ContextThemeWrapper(getContext(), this.V);
            o();
            j();
            p(typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        } catch (RuntimeException e2) {
            throw new IllegalArgumentException("Unable to load specified custom font: " + string, e2);
        }
    }

    private void o() {
        int iAlpha = Color.alpha(this.k0);
        int iRed = Color.red(this.k0);
        int iGreen = Color.green(this.k0);
        int iBlue = Color.blue(this.k0);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iAlpha);
        this.i0 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(300L);
        this.i0.addUpdateListener(new a(iRed, iGreen, iBlue));
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(iAlpha, 0);
        this.j0 = valueAnimatorOfInt2;
        valueAnimatorOfInt2.setDuration(300L);
        this.j0.addUpdateListener(new b(iRed, iGreen, iBlue));
    }

    private void p(TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(R$styleable.FloatingActionMenu_menu_fab_show_animation, R$anim.fab_scale_up);
        setMenuButtonShowAnimation(AnimationUtils.loadAnimation(getContext(), resourceId));
        this.e0 = AnimationUtils.loadAnimation(getContext(), resourceId);
        int resourceId2 = typedArray.getResourceId(R$styleable.FloatingActionMenu_menu_fab_hide_animation, R$anim.fab_scale_down);
        setMenuButtonHideAnimation(AnimationUtils.loadAnimation(getContext(), resourceId2));
        this.f0 = AnimationUtils.loadAnimation(getContext(), resourceId2);
    }

    private void q(int i) {
        this.o = i;
        this.p = i;
        this.f232q = i;
        this.r = i;
    }

    private boolean r() {
        return this.k0 != 0;
    }

    private void setLabelEllipsize(Label label) {
        int i = this.S;
        if (i == 1) {
            label.setEllipsize(TextUtils.TruncateAt.START);
            return;
        }
        if (i == 2) {
            label.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i == 3) {
            label.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            if (i != 4) {
                return;
            }
            label.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    public void g(boolean z) {
        if (s()) {
            if (r()) {
                this.j0.start();
            }
            if (this.a0) {
                AnimatorSet animatorSet = this.c;
                if (animatorSet != null) {
                    animatorSet.start();
                } else {
                    this.b.start();
                    this.a.cancel();
                }
            }
            this.k = false;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                    i++;
                    this.l.postDelayed(new f((FloatingActionButton) childAt, z), i2);
                    i2 += this.N;
                }
            }
            this.l.postDelayed(new g(), (i + 1) * this.N);
        }
    }

    public int getAnimationDelayPerItem() {
        return this.N;
    }

    public AnimatorSet getIconToggleAnimatorSet() {
        return this.c;
    }

    public int getMenuButtonColorNormal() {
        return this.J;
    }

    public int getMenuButtonColorPressed() {
        return this.K;
    }

    public int getMenuButtonColorRipple() {
        return this.L;
    }

    public String getMenuButtonLabelText() {
        return this.n0;
    }

    public ImageView getMenuIconView() {
        return this.b0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.e);
        bringChildToFront(this.b0);
        this.i = getChildCount();
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingRight = this.l0 == 0 ? ((i3 - i) - (this.f / 2)) - getPaddingRight() : (this.f / 2) + getPaddingLeft();
        boolean z2 = this.h0 == 0;
        int measuredHeight = z2 ? ((i4 - i2) - this.e.getMeasuredHeight()) - getPaddingBottom() : getPaddingTop();
        int measuredWidth = paddingRight - (this.e.getMeasuredWidth() / 2);
        FloatingActionButton floatingActionButton = this.e;
        floatingActionButton.layout(measuredWidth, measuredHeight, floatingActionButton.getMeasuredWidth() + measuredWidth, this.e.getMeasuredHeight() + measuredHeight);
        int measuredWidth2 = paddingRight - (this.b0.getMeasuredWidth() / 2);
        int measuredHeight2 = ((this.e.getMeasuredHeight() / 2) + measuredHeight) - (this.b0.getMeasuredHeight() / 2);
        ImageView imageView = this.b0;
        imageView.layout(measuredWidth2, measuredHeight2, imageView.getMeasuredWidth() + measuredWidth2, this.b0.getMeasuredHeight() + measuredHeight2);
        if (z2) {
            measuredHeight = measuredHeight + this.e.getMeasuredHeight() + this.d;
        }
        for (int i5 = this.i - 1; i5 >= 0; i5--) {
            View childAt = getChildAt(i5);
            if (childAt != this.b0) {
                FloatingActionButton floatingActionButton2 = (FloatingActionButton) childAt;
                if (floatingActionButton2.getVisibility() != 8) {
                    int measuredWidth3 = paddingRight - (floatingActionButton2.getMeasuredWidth() / 2);
                    if (z2) {
                        measuredHeight = (measuredHeight - floatingActionButton2.getMeasuredHeight()) - this.d;
                    }
                    if (floatingActionButton2 != this.e) {
                        floatingActionButton2.layout(measuredWidth3, measuredHeight, floatingActionButton2.getMeasuredWidth() + measuredWidth3, floatingActionButton2.getMeasuredHeight() + measuredHeight);
                        if (!this.k) {
                            floatingActionButton2.u(false);
                        }
                    }
                    View view = (View) floatingActionButton2.getTag(R$id.fab_label);
                    if (view != null) {
                        int measuredWidth4 = ((this.o0 ? this.f : floatingActionButton2.getMeasuredWidth()) / 2) + this.g;
                        int i6 = this.l0;
                        int i7 = i6 == 0 ? paddingRight - measuredWidth4 : measuredWidth4 + paddingRight;
                        int measuredWidth5 = i6 == 0 ? i7 - view.getMeasuredWidth() : view.getMeasuredWidth() + i7;
                        int i8 = this.l0;
                        int i9 = i8 == 0 ? measuredWidth5 : i7;
                        if (i8 != 0) {
                            i7 = measuredWidth5;
                        }
                        int measuredHeight3 = (measuredHeight - this.h) + ((floatingActionButton2.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                        view.layout(i9, measuredHeight3, i7, view.getMeasuredHeight() + measuredHeight3);
                        if (!this.k) {
                            view.setVisibility(4);
                        }
                    }
                    measuredHeight = z2 ? measuredHeight - this.d : measuredHeight + childAt.getMeasuredHeight() + this.d;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        this.f = 0;
        measureChildWithMargins(this.b0, i, 0, i2, 0);
        for (int i4 = 0; i4 < this.i; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && childAt != this.b0) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                this.f = Math.max(this.f, childAt.getMeasuredWidth());
            }
        }
        int i5 = 0;
        int iMax = 0;
        while (true) {
            if (i3 >= this.i) {
                break;
            }
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8 && childAt2 != this.b0) {
                int measuredWidth = childAt2.getMeasuredWidth();
                int measuredHeight = i5 + childAt2.getMeasuredHeight();
                Label label = (Label) childAt2.getTag(R$id.fab_label);
                if (label != null) {
                    int measuredWidth2 = (this.f - childAt2.getMeasuredWidth()) / (this.o0 ? 1 : 2);
                    measureChildWithMargins(label, i, childAt2.getMeasuredWidth() + label.n() + this.g + measuredWidth2, i2, 0);
                    iMax = Math.max(iMax, measuredWidth + label.getMeasuredWidth() + measuredWidth2);
                }
                i5 = measuredHeight;
            }
            i3++;
        }
        int iMax2 = Math.max(this.f, iMax + this.g) + getPaddingLeft() + getPaddingRight();
        int iF = f(i5 + (this.d * (this.i - 1)) + getPaddingTop() + getPaddingBottom());
        if (getLayoutParams().width == -1) {
            iMax2 = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        }
        if (getLayoutParams().height == -1) {
            iF = View.getDefaultSize(getSuggestedMinimumHeight(), i2);
        }
        setMeasuredDimension(iMax2, iF);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g0) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            return s();
        }
        if (action != 1) {
            return false;
        }
        g(this.Q);
        return true;
    }

    public boolean s() {
        return this.j;
    }

    public void setAnimated(boolean z) {
        this.Q = z;
        this.a.setDuration(z ? 300L : 0L);
        this.b.setDuration(z ? 300L : 0L);
    }

    public void setAnimationDelayPerItem(int i) {
        this.N = i;
    }

    public void setClosedOnTouchOutside(boolean z) {
        this.g0 = z;
    }

    public void setIconAnimated(boolean z) {
        this.a0 = z;
    }

    public void setIconAnimationCloseInterpolator(Interpolator interpolator) {
        this.b.setInterpolator(interpolator);
    }

    public void setIconAnimationInterpolator(Interpolator interpolator) {
        this.a.setInterpolator(interpolator);
        this.b.setInterpolator(interpolator);
    }

    public void setIconAnimationOpenInterpolator(Interpolator interpolator) {
        this.a.setInterpolator(interpolator);
    }

    public void setIconToggleAnimatorSet(AnimatorSet animatorSet) {
        this.c = animatorSet;
    }

    public void setMenuButtonColorNormal(int i) {
        this.J = i;
        this.e.setColorNormal(i);
    }

    public void setMenuButtonColorNormalResId(int i) {
        this.J = getResources().getColor(i);
        this.e.setColorNormalResId(i);
    }

    public void setMenuButtonColorPressed(int i) {
        this.K = i;
        this.e.setColorPressed(i);
    }

    public void setMenuButtonColorPressedResId(int i) {
        this.K = getResources().getColor(i);
        this.e.setColorPressedResId(i);
    }

    public void setMenuButtonColorRipple(int i) {
        this.L = i;
        this.e.setColorRipple(i);
    }

    public void setMenuButtonColorRippleResId(int i) {
        this.L = getResources().getColor(i);
        this.e.setColorRippleResId(i);
    }

    public void setMenuButtonHideAnimation(Animation animation) {
        this.d0 = animation;
        this.e.setHideAnimation(animation);
    }

    public void setMenuButtonLabelText(String str) {
        this.e.setLabelText(str);
    }

    public void setMenuButtonShowAnimation(Animation animation) {
        this.c0 = animation;
        this.e.setShowAnimation(animation);
    }

    public void setOnMenuButtonClickListener(View.OnClickListener onClickListener) {
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnMenuButtonLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.e.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMenuToggleListener(h hVar) {
    }

    public void t(boolean z) {
        if (s()) {
            return;
        }
        if (r()) {
            this.i0.start();
        }
        if (this.a0) {
            AnimatorSet animatorSet = this.c;
            if (animatorSet != null) {
                animatorSet.start();
            } else {
                this.b.cancel();
                this.a.start();
            }
        }
        this.k = true;
        int i = 0;
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if ((childAt instanceof FloatingActionButton) && childAt.getVisibility() != 8) {
                i++;
                this.l.postDelayed(new d((FloatingActionButton) childAt, z), i2);
                i2 += this.N;
            }
        }
        this.l.postDelayed(new e(), (i + 1) * this.N);
    }

    public void u(boolean z) {
        if (s()) {
            g(z);
        } else {
            t(z);
        }
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new AnimatorSet();
        this.b = new AnimatorSet();
        this.d = com.github.clans.fab.a.a(getContext(), 0.0f);
        this.g = com.github.clans.fab.a.a(getContext(), 0.0f);
        this.h = com.github.clans.fab.a.a(getContext(), 0.0f);
        this.l = new Handler();
        this.o = com.github.clans.fab.a.a(getContext(), 4.0f);
        this.p = com.github.clans.fab.a.a(getContext(), 8.0f);
        this.f232q = com.github.clans.fab.a.a(getContext(), 4.0f);
        this.r = com.github.clans.fab.a.a(getContext(), 8.0f);
        this.u = com.github.clans.fab.a.a(getContext(), 3.0f);
        this.G = 4.0f;
        this.H = 1.0f;
        this.I = 3.0f;
        this.Q = true;
        this.a0 = true;
        n(context, attributeSet);
    }
}
