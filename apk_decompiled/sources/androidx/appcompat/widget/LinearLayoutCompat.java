package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import defpackage.be3;
import defpackage.iv0;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int[] i;
    private int[] j;
    private Drawable k;
    private int l;
    private int m;
    private int n;
    private int o;

    public static class a extends LinearLayout.LayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    private void h(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewP = p(i3);
            if (viewP.getVisibility() != 8) {
                a aVar = (a) viewP.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).height == -1) {
                    int i4 = ((LinearLayout.LayoutParams) aVar).width;
                    ((LinearLayout.LayoutParams) aVar).width = viewP.getMeasuredWidth();
                    measureChildWithMargins(viewP, i2, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) aVar).width = i4;
                }
            }
        }
    }

    private void i(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewP = p(i3);
            if (viewP.getVisibility() != 8) {
                a aVar = (a) viewP.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i4 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = viewP.getMeasuredHeight();
                    measureChildWithMargins(viewP, iMakeMeasureSpec, 0, i2, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i4;
                }
            }
        }
    }

    private void x(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void d(Canvas canvas) {
        int right;
        int left;
        int i;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = h0.b(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewP = p(i2);
            if (viewP != null && viewP.getVisibility() != 8 && q(i2)) {
                a aVar = (a) viewP.getLayoutParams();
                g(canvas, zB ? viewP.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (viewP.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.l);
            }
        }
        if (q(virtualChildCount)) {
            View viewP2 = p(virtualChildCount - 1);
            if (viewP2 != null) {
                a aVar2 = (a) viewP2.getLayoutParams();
                if (zB) {
                    left = viewP2.getLeft() - ((LinearLayout.LayoutParams) aVar2).leftMargin;
                    i = this.l;
                    right = left - i;
                } else {
                    right = viewP2.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.l;
                right = left - i;
            }
            g(canvas, right);
        }
    }

    void e(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewP = p(i);
            if (viewP != null && viewP.getVisibility() != 8 && q(i)) {
                f(canvas, (viewP.getTop() - ((LinearLayout.LayoutParams) ((a) viewP.getLayoutParams())).topMargin) - this.m);
            }
        }
        if (q(virtualChildCount)) {
            View viewP2 = p(virtualChildCount - 1);
            f(canvas, viewP2 == null ? (getHeight() - getPaddingBottom()) - this.m : viewP2.getBottom() + ((LinearLayout.LayoutParams) ((a) viewP2.getLayoutParams())).bottomMargin);
        }
    }

    void f(Canvas canvas, int i) {
        this.k.setBounds(getPaddingLeft() + this.o, i, (getWidth() - getPaddingRight()) - this.o, this.m + i);
        this.k.draw(canvas);
    }

    void g(Canvas canvas, int i) {
        this.k.setBounds(i, getPaddingTop() + this.o, this.l + i, (getHeight() - getPaddingBottom()) - this.o);
        this.k.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.b;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.c;
        if (this.d == 1 && (i = this.e & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i = this.d;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    int m(View view, int i) {
        return 0;
    }

    int n(View view) {
        return 0;
    }

    int o(View view) {
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.k == null) {
            return;
        }
        if (this.d == 1) {
            e(canvas);
        } else {
            d(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.d == 1) {
            s(i, i2, i3, i4);
        } else {
            r(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.d == 1) {
            w(i, i2);
        } else {
            u(i, i2);
        }
    }

    View p(int i) {
        return getChildAt(i);
    }

    protected boolean q(int i) {
        if (i == 0) {
            return (this.n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.n & 4) != 0;
        }
        if ((this.n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:35:0x00be  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:48:0x0100  */
    void r(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean z;
        int baseline;
        int i7;
        int i8;
        int measuredHeight;
        boolean zB = h0.b(this);
        int paddingTop = getPaddingTop();
        int i9 = i4 - i2;
        int paddingBottom = i9 - getPaddingBottom();
        int paddingBottom2 = (i9 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.e;
        int i11 = i10 & 112;
        boolean z2 = this.a;
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        int iB = iv0.b(8388615 & i10, getLayoutDirection());
        boolean z3 = true;
        if (iB != 1) {
            paddingLeft = iB != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.f;
        } else {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.f) / 2);
        }
        if (zB) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int iM = 0;
        while (iM < virtualChildCount) {
            int i12 = i5 + (i6 * iM);
            View viewP = p(i12);
            if (viewP == null) {
                paddingLeft += v(i12);
                z = z3;
            } else {
                if (viewP.getVisibility() != 8) {
                    int measuredWidth = viewP.getMeasuredWidth();
                    int measuredHeight2 = viewP.getMeasuredHeight();
                    a aVar = (a) viewP.getLayoutParams();
                    int i13 = iM;
                    if (z2) {
                        virtualChildCount = virtualChildCount;
                        baseline = ((LinearLayout.LayoutParams) aVar).height != -1 ? viewP.getBaseline() : -1;
                        i7 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i7 < 0) {
                            i7 = i11;
                        }
                        i8 = i7 & 112;
                        i11 = i11;
                        if (i8 != 16) {
                            if (i8 != 48) {
                                measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                                if (baseline != -1) {
                                    z = true;
                                    measuredHeight += iArr[1] - baseline;
                                }
                            } else if (i8 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight -= iArr2[2] - (viewP.getMeasuredHeight() - baseline);
                                }
                            }
                            z = true;
                        } else {
                            z = true;
                            measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        }
                        if (q(i12)) {
                            paddingLeft += this.l;
                        }
                        int i14 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        paddingTop = paddingTop;
                        x(viewP, i14 + n(viewP), measuredHeight, measuredWidth, measuredHeight2);
                        int iO = i14 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + o(viewP);
                        iM = i13 + m(viewP, i12);
                        paddingLeft = iO;
                    } else {
                        virtualChildCount = virtualChildCount;
                    }
                    i7 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i7 < 0) {
                        i7 = i11;
                    }
                    i8 = i7 & 112;
                    i11 = i11;
                    if (i8 != 16) {
                        if (i8 != 48) {
                            measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + paddingTop;
                            if (baseline != -1) {
                                z = true;
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i8 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewP.getMeasuredHeight() - baseline);
                            }
                        }
                        z = true;
                    } else {
                        z = true;
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((LinearLayout.LayoutParams) aVar).topMargin) - ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    }
                    if (q(i12)) {
                        paddingLeft += this.l;
                    }
                    int i15 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    paddingTop = paddingTop;
                    x(viewP, i15 + n(viewP), measuredHeight, measuredWidth, measuredHeight2);
                    int iO2 = i15 + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + o(viewP);
                    iM = i13 + m(viewP, i12);
                    paddingLeft = iO2;
                } else {
                    z = true;
                }
                iM++;
                virtualChildCount = virtualChildCount;
                i11 = i11;
                z3 = z;
                paddingTop = paddingTop;
            }
            iM++;
            virtualChildCount = virtualChildCount;
            i11 = i11;
            z3 = z;
            paddingTop = paddingTop;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a1  */
    void s(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i3 - i;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.e;
        int i11 = i10 & 112;
        int i12 = i10 & 8388615;
        if (i11 != 16) {
            paddingTop = i11 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.f;
        } else {
            paddingTop = getPaddingTop() + (((i4 - i2) - this.f) / 2);
        }
        int iM = 0;
        while (iM < virtualChildCount) {
            View viewP = p(iM);
            if (viewP == null) {
                paddingTop += v(iM);
            } else {
                if (viewP.getVisibility() != 8) {
                    int measuredWidth = viewP.getMeasuredWidth();
                    int measuredHeight = viewP.getMeasuredHeight();
                    a aVar = (a) viewP.getLayoutParams();
                    int i13 = ((LinearLayout.LayoutParams) aVar).gravity;
                    if (i13 < 0) {
                        i13 = i12;
                    }
                    int iB = iv0.b(i13, getLayoutDirection()) & 7;
                    if (iB != 1) {
                        if (iB != 5) {
                            i7 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                        } else {
                            i5 = paddingRight - measuredWidth;
                            i6 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                        }
                        int i14 = i7;
                        if (q(iM)) {
                            paddingTop += this.m;
                        }
                        int i15 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                        x(viewP, i14, i15 + n(viewP), measuredWidth, measuredHeight);
                        int iO = i15 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + o(viewP);
                        iM += m(viewP, iM);
                        paddingTop = iO;
                        i8 = 1;
                    } else {
                        i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                        i6 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                    }
                    i7 = i5 - i6;
                    int i16 = i7;
                    if (q(iM)) {
                        paddingTop += this.m;
                    }
                    int i17 = paddingTop + ((LinearLayout.LayoutParams) aVar).topMargin;
                    x(viewP, i16, i17 + n(viewP), measuredWidth, measuredHeight);
                    int iO2 = i17 + measuredHeight + ((LinearLayout.LayoutParams) aVar).bottomMargin + o(viewP);
                    iM += m(viewP, iM);
                    paddingTop = iO2;
                    i8 = 1;
                }
                iM += i8;
            }
            i8 = 1;
            iM += i8;
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.k) {
            return;
        }
        this.k = drawable;
        if (drawable != null) {
            this.l = drawable.getIntrinsicWidth();
            this.m = drawable.getIntrinsicHeight();
        } else {
            this.l = 0;
            this.m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.o = i;
    }

    public void setGravity(int i) {
        if (this.e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.e;
        if ((8388615 & i3) != i2) {
            this.e = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.n) {
            requestLayout();
        }
        this.n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.e;
        if ((i3 & 112) != i2) {
            this.e = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void t(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Code duplicated, block: B:200:0x045b  */
    /* JADX WARN: Code duplicated, block: B:60:0x0175  */
    /* JADX WARN: Code duplicated, block: B:67:0x0197  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e0  */
    void u(int i, int i2) {
        int[] iArr;
        int iCombineMeasuredStates;
        int i3;
        int iMax;
        int i4;
        int i5;
        int baseline;
        int i6;
        int i7;
        byte b;
        int i8;
        int i9;
        boolean z;
        boolean z2;
        View view;
        int i10;
        boolean z3;
        int i11;
        int measuredHeight;
        int iM;
        int baseline2;
        int i12;
        this.f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.i == null || this.j == null) {
            this.i = new int[4];
            this.j = new int[4];
        }
        int[] iArr2 = this.i;
        int[] iArr3 = this.j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.a;
        boolean z5 = this.h;
        int i13 = 1073741824;
        boolean z6 = mode == 1073741824;
        int iM2 = 0;
        int iMax2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        boolean z7 = false;
        int iCombineMeasuredStates2 = 0;
        boolean z8 = false;
        boolean z9 = true;
        float f = 0.0f;
        while (true) {
            iArr = iArr3;
            if (iM2 >= virtualChildCount) {
                break;
            }
            View viewP = p(iM2);
            if (viewP == null) {
                this.f += v(iM2);
            } else {
                if (viewP.getVisibility() == 8) {
                    iM2 += m(viewP, iM2);
                } else {
                    if (q(iM2)) {
                        this.f += this.l;
                    }
                    a aVar = (a) viewP.getLayoutParams();
                    float f2 = ((LinearLayout.LayoutParams) aVar).weight;
                    float f3 = f + f2;
                    if (mode == i13 && ((LinearLayout.LayoutParams) aVar).width == 0 && f2 > 0.0f) {
                        if (z6) {
                            this.f += ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin;
                        } else {
                            int i14 = this.f;
                            this.f = Math.max(i14, ((LinearLayout.LayoutParams) aVar).leftMargin + i14 + ((LinearLayout.LayoutParams) aVar).rightMargin);
                        }
                        if (z4) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            viewP.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i9 = iM2;
                            z = z5;
                            z2 = z4;
                            view = viewP;
                        } else {
                            i9 = iM2;
                            z = z5;
                            z2 = z4;
                            view = viewP;
                            z7 = true;
                            i10 = 1073741824;
                        }
                        if (mode2 == i10 && ((LinearLayout.LayoutParams) aVar).height == -1) {
                            z3 = true;
                            z8 = true;
                        } else {
                            z3 = false;
                        }
                        i11 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i11;
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            i12 = ((LinearLayout.LayoutParams) aVar).gravity;
                            if (i12 < 0) {
                                i12 = this.e;
                            }
                            int i15 = (((i12 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i15] = Math.max(iArr2[i15], baseline2);
                            iArr[i15] = Math.max(iArr[i15], measuredHeight - baseline2);
                        }
                        iMax3 = Math.max(iMax3, measuredHeight);
                        if (z9 || ((LinearLayout.LayoutParams) aVar).height != -1) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                            if (!z3) {
                                i11 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i11);
                        } else {
                            int i16 = iMax5;
                            if (!z3) {
                                i11 = measuredHeight;
                            }
                            iMax4 = Math.max(iMax4, i11);
                            iMax5 = i16;
                        }
                        int i17 = i9;
                        iM = m(view, i17) + i17;
                        f = f3;
                    } else {
                        if (((LinearLayout.LayoutParams) aVar).width != 0 || f2 <= 0.0f) {
                            b = -2;
                            i8 = Integer.MIN_VALUE;
                        } else {
                            b = -2;
                            ((LinearLayout.LayoutParams) aVar).width = -2;
                            i8 = 0;
                        }
                        i9 = iM2;
                        int i18 = i8;
                        z = z5;
                        z2 = z4;
                        t(viewP, i9, i, f3 == 0.0f ? this.f : 0, i2, 0);
                        if (i18 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar).width = i18;
                        }
                        int measuredWidth = viewP.getMeasuredWidth();
                        if (z6) {
                            view = viewP;
                            this.f += ((LinearLayout.LayoutParams) aVar).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) aVar).rightMargin + o(view);
                        } else {
                            view = viewP;
                            int i19 = this.f;
                            this.f = Math.max(i19, i19 + measuredWidth + ((LinearLayout.LayoutParams) aVar).leftMargin + ((LinearLayout.LayoutParams) aVar).rightMargin + o(view));
                        }
                        if (z) {
                            iMax2 = Math.max(measuredWidth, iMax2);
                        }
                    }
                    i10 = 1073741824;
                    if (mode2 == i10) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    i11 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i11;
                    iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                    if (z2) {
                        i12 = ((LinearLayout.LayoutParams) aVar).gravity;
                        if (i12 < 0) {
                            i12 = this.e;
                        }
                        int i110 = (((i12 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i110] = Math.max(iArr2[i110], baseline2);
                        iArr[i110] = Math.max(iArr[i110], measuredHeight - baseline2);
                    }
                    iMax3 = Math.max(iMax3, measuredHeight);
                    if (z9) {
                        z9 = false;
                    } else {
                        z9 = false;
                    }
                    if (((LinearLayout.LayoutParams) aVar).weight > 0.0f) {
                        if (!z3) {
                            i11 = measuredHeight;
                        }
                        iMax5 = Math.max(iMax5, i11);
                    } else {
                        int i111 = iMax5;
                        if (!z3) {
                            i11 = measuredHeight;
                        }
                        iMax4 = Math.max(iMax4, i11);
                        iMax5 = i111;
                    }
                    int i112 = i9;
                    iM = m(view, i112) + i112;
                    f = f3;
                }
                int i20 = iM + 1;
                iArr3 = iArr;
                z5 = z;
                z4 = z2;
                i13 = i10;
                iM2 = i20;
            }
            z = z5;
            z2 = z4;
            int i21 = i13;
            iM = iM2;
            i10 = i21;
            int i22 = iM + 1;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            i13 = i10;
            iM2 = i22;
        }
        boolean z10 = z5;
        boolean z11 = z4;
        int i23 = iMax3;
        int i24 = iMax4;
        int i25 = iMax5;
        int i26 = iCombineMeasuredStates2;
        if (this.f > 0 && q(virtualChildCount)) {
            this.f += this.l;
        }
        int i27 = iArr2[1];
        int iMax6 = (i27 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i23 : Math.max(i23, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i27, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        if (z10 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f = 0;
            int iM3 = 0;
            while (iM3 < virtualChildCount) {
                View viewP2 = p(iM3);
                if (viewP2 == null) {
                    this.f += v(iM3);
                } else if (viewP2.getVisibility() == 8) {
                    iM3 += m(viewP2, iM3);
                } else {
                    a aVar2 = (a) viewP2.getLayoutParams();
                    if (z6) {
                        this.f += ((LinearLayout.LayoutParams) aVar2).leftMargin + iMax2 + ((LinearLayout.LayoutParams) aVar2).rightMargin + o(viewP2);
                    } else {
                        int i28 = this.f;
                        this.f = Math.max(i28, i28 + iMax2 + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin + o(viewP2));
                    }
                    iM3++;
                    iMax6 = iMax6;
                }
                iM3++;
                iMax6 = iMax6;
            }
        }
        int iMax7 = iMax6;
        int paddingLeft = this.f + getPaddingLeft() + getPaddingRight();
        this.f = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i29 = (16777215 & iResolveSizeAndState) - this.f;
        if (z7 || (i29 != 0 && f > 0.0f)) {
            float f4 = this.g;
            if (f4 > 0.0f) {
                f = f4;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f = 0;
            int i30 = i24;
            int iMax8 = -1;
            iCombineMeasuredStates = i26;
            int i31 = 0;
            while (i31 < virtualChildCount) {
                View viewP3 = p(i31);
                if (viewP3 == null || viewP3.getVisibility() == 8) {
                    i4 = i29;
                    virtualChildCount = virtualChildCount;
                } else {
                    a aVar3 = (a) viewP3.getLayoutParams();
                    float f5 = ((LinearLayout.LayoutParams) aVar3).weight;
                    if (f5 > 0.0f) {
                        int i32 = (int) ((i29 * f5) / f);
                        float f6 = f - f5;
                        int i33 = i29 - i32;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin, ((LinearLayout.LayoutParams) aVar3).height);
                        if (((LinearLayout.LayoutParams) aVar3).width == 0) {
                            i7 = 1073741824;
                            if (mode == 1073741824) {
                                if (i32 <= 0) {
                                    i32 = 0;
                                }
                                viewP3.measure(View.MeasureSpec.makeMeasureSpec(i32, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewP3.getMeasuredState() & (-16777216));
                            f = f6;
                            i4 = i33;
                        } else {
                            i7 = 1073741824;
                        }
                        int measuredWidth2 = viewP3.getMeasuredWidth() + i32;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewP3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i7), childMeasureSpec);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewP3.getMeasuredState() & (-16777216));
                        f = f6;
                        i4 = i33;
                    } else {
                        i4 = i29;
                    }
                    if (z6) {
                        this.f += viewP3.getMeasuredWidth() + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + o(viewP3);
                    } else {
                        int i34 = this.f;
                        this.f = Math.max(i34, viewP3.getMeasuredWidth() + i34 + ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin + o(viewP3));
                    }
                    boolean z12 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == -1;
                    int i35 = ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = viewP3.getMeasuredHeight() + i35;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z12) {
                        i35 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i30, i35);
                    if (z9) {
                        i5 = -1;
                        boolean z13 = ((LinearLayout.LayoutParams) aVar3).height == -1;
                        if (z11 && (baseline = viewP3.getBaseline()) != i5) {
                            i6 = ((LinearLayout.LayoutParams) aVar3).gravity;
                            if (i6 < 0) {
                                i6 = this.e;
                            }
                            int i36 = (((i6 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i36] = Math.max(iArr2[i36], baseline);
                            iArr[i36] = Math.max(iArr[i36], measuredHeight2 - baseline);
                        }
                        z9 = z13;
                        i30 = iMax9;
                        f = f;
                    } else {
                        i5 = -1;
                    }
                    if (z11) {
                        i6 = ((LinearLayout.LayoutParams) aVar3).gravity;
                        if (i6 < 0) {
                            i6 = this.e;
                        }
                        int i37 = (((i6 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i37] = Math.max(iArr2[i37], baseline);
                        iArr[i37] = Math.max(iArr[i37], measuredHeight2 - baseline);
                    }
                    z9 = z13;
                    i30 = iMax9;
                    f = f;
                }
                i31++;
                i29 = i4;
                virtualChildCount = virtualChildCount;
            }
            i3 = virtualChildCount;
            this.f += getPaddingLeft() + getPaddingRight();
            int i38 = iArr2[1];
            iMax7 = (i38 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i38, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax = i30;
        } else {
            iMax = Math.max(i24, i25);
            if (z10 && mode != 1073741824) {
                for (int i39 = 0; i39 < virtualChildCount; i39++) {
                    View viewP4 = p(i39);
                    if (viewP4 != null && viewP4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewP4.getLayoutParams())).weight > 0.0f) {
                        viewP4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824), View.MeasureSpec.makeMeasureSpec(viewP4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = virtualChildCount;
            iCombineMeasuredStates = i26;
        }
        if (z9 || mode2 == 1073741824) {
            iMax = iMax7;
        }
        setMeasuredDimension(iResolveSizeAndState | ((-16777216) & iCombineMeasuredStates), View.resolveSizeAndState(Math.max(iMax + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates << 16));
        if (z8) {
            h(i3, i);
        }
    }

    int v(int i) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x032f  */
    void w(int i, int i2) {
        int i3;
        int iCombineMeasuredStates;
        int iMax;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iMax2;
        int i14;
        View view;
        int iMax3;
        boolean z2;
        this.f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i15 = this.b;
        boolean z3 = this.h;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int iMax4 = 0;
        int i19 = 0;
        int iM = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        float f = 0.0f;
        while (true) {
            int i20 = 8;
            int i21 = iMax4;
            if (iM >= virtualChildCount) {
                int i22 = i16;
                int i23 = i18;
                int i24 = i19;
                int i25 = mode2;
                int iMax5 = i17;
                int i26 = virtualChildCount;
                if (this.f > 0) {
                    i3 = i26;
                    if (q(i3)) {
                        this.f += this.m;
                    }
                } else {
                    i3 = i26;
                }
                if (z3 && (i25 == Integer.MIN_VALUE || i25 == 0)) {
                    this.f = 0;
                    int iM2 = 0;
                    while (iM2 < i3) {
                        View viewP = p(iM2);
                        if (viewP == null) {
                            this.f += v(iM2);
                        } else if (viewP.getVisibility() == i20) {
                            iM2 += m(viewP, iM2);
                        } else {
                            a aVar = (a) viewP.getLayoutParams();
                            int i27 = this.f;
                            this.f = Math.max(i27, i27 + i23 + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + o(viewP));
                        }
                        iM2++;
                        i20 = 8;
                    }
                }
                int paddingTop = this.f + getPaddingTop() + getPaddingBottom();
                this.f = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i28 = (16777215 & iResolveSizeAndState) - this.f;
                if (z4 || (i28 != 0 && f > 0.0f)) {
                    float f2 = this.g;
                    if (f2 > 0.0f) {
                        f = f2;
                    }
                    this.f = 0;
                    int i29 = i28;
                    int i30 = i24;
                    iCombineMeasuredStates = i22;
                    int i31 = 0;
                    while (i31 < i3) {
                        View viewP2 = p(i31);
                        if (viewP2.getVisibility() == 8) {
                            i4 = i29;
                        } else {
                            a aVar2 = (a) viewP2.getLayoutParams();
                            float f3 = ((LinearLayout.LayoutParams) aVar2).weight;
                            if (f3 > 0.0f) {
                                int i32 = (int) ((i29 * f3) / f);
                                float f4 = f - f3;
                                i4 = i29 - i32;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin, ((LinearLayout.LayoutParams) aVar2).width);
                                if (((LinearLayout.LayoutParams) aVar2).height == 0) {
                                    i7 = 1073741824;
                                    if (i25 == 1073741824) {
                                        if (i32 <= 0) {
                                            i32 = 0;
                                        }
                                        viewP2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i32, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewP2.getMeasuredState() & (-256));
                                    f = f4;
                                } else {
                                    i7 = 1073741824;
                                }
                                int measuredHeight = viewP2.getMeasuredHeight() + i32;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewP2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i7));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewP2.getMeasuredState() & (-256));
                                f = f4;
                            } else {
                                i4 = i29;
                            }
                            int i33 = ((LinearLayout.LayoutParams) aVar2).leftMargin + ((LinearLayout.LayoutParams) aVar2).rightMargin;
                            int measuredWidth = viewP2.getMeasuredWidth() + i33;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f5 = f;
                            if (mode != 1073741824) {
                                i5 = iCombineMeasuredStates;
                                i6 = -1;
                                if (((LinearLayout.LayoutParams) aVar2).width != -1) {
                                }
                                int iMax6 = Math.max(i30, i33);
                                if (z6 || ((LinearLayout.LayoutParams) aVar2).width != i6) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                int i34 = this.f;
                                this.f = Math.max(i34, viewP2.getMeasuredHeight() + i34 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + o(viewP2));
                                z6 = z;
                                iCombineMeasuredStates = i5;
                                i30 = iMax6;
                                f = f5;
                            } else {
                                i5 = iCombineMeasuredStates;
                                i6 = -1;
                            }
                            i33 = measuredWidth;
                            int iMax7 = Math.max(i30, i33);
                            if (z6) {
                                z = false;
                            } else {
                                z = false;
                            }
                            int i35 = this.f;
                            this.f = Math.max(i35, viewP2.getMeasuredHeight() + i35 + ((LinearLayout.LayoutParams) aVar2).topMargin + ((LinearLayout.LayoutParams) aVar2).bottomMargin + o(viewP2));
                            z6 = z;
                            iCombineMeasuredStates = i5;
                            i30 = iMax7;
                            f = f5;
                        }
                        i31++;
                        i29 = i4;
                    }
                    this.f += getPaddingTop() + getPaddingBottom();
                    iMax = i30;
                } else {
                    iMax = Math.max(i24, i21);
                    if (z3 && i25 != 1073741824) {
                        for (int i36 = 0; i36 < i3; i36++) {
                            View viewP3 = p(i36);
                            if (viewP3 != null && viewP3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((a) viewP3.getLayoutParams())).weight > 0.0f) {
                                viewP3.measure(View.MeasureSpec.makeMeasureSpec(viewP3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i23, 1073741824));
                            }
                        }
                    }
                    iCombineMeasuredStates = i22;
                }
                if (z6 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates), iResolveSizeAndState);
                if (z5) {
                    i(i3, i2);
                    return;
                }
                return;
            }
            View viewP4 = p(iM);
            if (viewP4 == null) {
                this.f += v(iM);
                i11 = mode2;
                iMax4 = i21;
                i13 = virtualChildCount;
            } else {
                int i37 = i16;
                if (viewP4.getVisibility() == 8) {
                    iM += m(viewP4, iM);
                    iMax4 = i21;
                    i16 = i37;
                    i13 = virtualChildCount;
                    i11 = mode2;
                } else {
                    if (q(iM)) {
                        this.f += this.m;
                    }
                    a aVar3 = (a) viewP4.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) aVar3).weight;
                    float f7 = f + f6;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) aVar3).height == 0 && f6 > 0.0f) {
                        int i38 = this.f;
                        this.f = Math.max(i38, ((LinearLayout.LayoutParams) aVar3).topMargin + i38 + ((LinearLayout.LayoutParams) aVar3).bottomMargin);
                        iMax3 = i18;
                        view = viewP4;
                        iMax2 = i19;
                        z4 = true;
                        i9 = i37;
                        i10 = i17;
                        i11 = mode2;
                        i12 = i21;
                        i13 = virtualChildCount;
                        i14 = iM;
                    } else {
                        int i39 = i17;
                        if (((LinearLayout.LayoutParams) aVar3).height != 0 || f6 <= 0.0f) {
                            i8 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) aVar3).height = -2;
                            i8 = 0;
                        }
                        i9 = i37;
                        int i40 = i8;
                        i10 = i39;
                        int i41 = i18;
                        i11 = mode2;
                        i12 = i21;
                        i13 = virtualChildCount;
                        iMax2 = i19;
                        i14 = iM;
                        t(viewP4, iM, i, 0, i2, f7 == 0.0f ? this.f : 0);
                        if (i40 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) aVar3).height = i40;
                        }
                        int measuredHeight2 = viewP4.getMeasuredHeight();
                        int i42 = this.f;
                        view = viewP4;
                        this.f = Math.max(i42, i42 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar3).topMargin + ((LinearLayout.LayoutParams) aVar3).bottomMargin + o(view));
                        iMax3 = z3 ? Math.max(measuredHeight2, i41) : i41;
                    }
                    if (i15 >= 0 && i15 == i14 + 1) {
                        this.c = this.f;
                    }
                    if (i14 < i15 && ((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) aVar3).width != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z5 = true;
                    }
                    int i43 = ((LinearLayout.LayoutParams) aVar3).leftMargin + ((LinearLayout.LayoutParams) aVar3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i43;
                    int iMax8 = Math.max(i10, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i9, view.getMeasuredState());
                    z6 = z6 && ((LinearLayout.LayoutParams) aVar3).width == -1;
                    if (((LinearLayout.LayoutParams) aVar3).weight > 0.0f) {
                        if (!z2) {
                            i43 = measuredWidth2;
                        }
                        iMax4 = Math.max(i12, i43);
                    } else {
                        if (!z2) {
                            i43 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i43);
                        iMax4 = i12;
                    }
                    int iM3 = m(view, i14) + i14;
                    i18 = iMax3;
                    i17 = iMax8;
                    f = f7;
                    i19 = iMax2;
                    iM = iM3;
                    i16 = iCombineMeasuredStates2;
                }
            }
            iM++;
            virtualChildCount = i13;
            mode2 = i11;
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 8388659;
        int[] iArr = R$styleable.LinearLayoutCompat;
        e0 e0VarV = e0.v(context, attributeSet, iArr, i, 0);
        be3.n0(this, context, iArr, attributeSet, e0VarV.r(), i, 0);
        int iK = e0VarV.k(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = e0VarV.k(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = e0VarV.a(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.g = e0VarV.i(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.b = e0VarV.k(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.h = e0VarV.a(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(e0VarV.g(R$styleable.LinearLayoutCompat_divider));
        this.n = e0VarV.k(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.o = e0VarV.f(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        e0VarV.x();
    }
}
