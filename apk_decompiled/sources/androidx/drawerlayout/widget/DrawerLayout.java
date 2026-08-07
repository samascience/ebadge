package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import defpackage.be3;
import defpackage.dd0;
import defpackage.fe3;
import defpackage.iv0;
import defpackage.m2;
import defpackage.p2;
import defpackage.q30;
import defpackage.t1;
import defpackage.z21;
import defpackage.zi3;
import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    private static final int[] Q = {R.attr.colorPrimaryDark};
    static final int[] R = {R.attr.layout_gravity};
    static final boolean S;
    private static final boolean T;
    private static boolean U;
    private CharSequence F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList M;
    private Rect N;
    private Matrix O;
    private final p2 P;
    private final d a;
    private float b;
    private int c;
    private int d;
    private float e;
    private Paint f;
    private final fe3 g;
    private final fe3 h;
    private final h i;
    private final h j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f192q;
    private boolean r;
    private e s;
    private List t;
    private float u;
    private float v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private CharSequence z;

    class a implements p2 {
        a() {
        }

        @Override // defpackage.p2
        public boolean a(View view, p2.a aVar) {
            if (!DrawerLayout.this.D(view) || DrawerLayout.this.r(view) == 2) {
                return false;
            }
            DrawerLayout.this.f(view);
            return true;
        }
    }

    class b implements View.OnApplyWindowInsetsListener {
        b() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).R(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    class c extends t1 {
        private final Rect a = new Rect();

        c() {
        }

        private void c(m2 m2Var, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.A(childAt)) {
                    m2Var.c(childAt);
                }
            }
        }

        private void d(m2 m2Var, m2 m2Var2) {
            Rect rect = this.a;
            m2Var2.l(rect);
            m2Var.f0(rect);
            m2Var.O0(m2Var2.V());
            m2Var.z0(m2Var2.x());
            m2Var.j0(m2Var2.o());
            m2Var.n0(m2Var2.s());
            m2Var.p0(m2Var2.K());
            m2Var.s0(m2Var2.M());
            m2Var.c0(m2Var2.F());
            m2Var.H0(m2Var2.S());
            m2Var.a(m2Var2.i());
        }

        @Override // defpackage.t1
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewP = DrawerLayout.this.p();
            if (viewP == null) {
                return true;
            }
            CharSequence charSequenceS = DrawerLayout.this.s(DrawerLayout.this.t(viewP));
            if (charSequenceS == null) {
                return true;
            }
            text.add(charSequenceS);
            return true;
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            if (DrawerLayout.S) {
                super.onInitializeAccessibilityNodeInfo(view, m2Var);
            } else {
                m2 m2VarX = m2.X(m2Var);
                super.onInitializeAccessibilityNodeInfo(view, m2VarX);
                m2Var.J0(view);
                Object objG = be3.G(view);
                if (objG instanceof View) {
                    m2Var.B0((View) objG);
                }
                d(m2Var, m2VarX);
                m2VarX.a0();
                c(m2Var, (ViewGroup) view);
            }
            m2Var.j0("androidx.drawerlayout.widget.DrawerLayout");
            m2Var.r0(false);
            m2Var.s0(false);
            m2Var.b0(m2.a.e);
            m2Var.b0(m2.a.f);
        }

        @Override // defpackage.t1
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.S || DrawerLayout.A(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class d extends t1 {
        d() {
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            if (DrawerLayout.A(view)) {
                return;
            }
            m2Var.B0(null);
        }
    }

    public interface e {
        void a(View view);

        void b(View view);

        void c(int i);

        void d(View view, float f);
    }

    public static abstract class g implements e {
        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void c(int i) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.e
        public void d(View view, float f) {
        }
    }

    private class h extends fe3.c {
        private final int a;
        private fe3 b;
        private final Runnable c = new a();

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.o();
            }
        }

        h(int i) {
            this.a = i;
        }

        private void n() {
            View viewN = DrawerLayout.this.n(this.a == 3 ? 5 : 3);
            if (viewN != null) {
                DrawerLayout.this.f(viewN);
            }
        }

        @Override // fe3.c
        public int a(View view, int i, int i2) {
            if (DrawerLayout.this.c(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // fe3.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // fe3.c
        public int d(View view) {
            if (DrawerLayout.this.E(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // fe3.c
        public void f(int i, int i2) {
            View viewN = (i & 1) == 1 ? DrawerLayout.this.n(3) : DrawerLayout.this.n(5);
            if (viewN == null || DrawerLayout.this.r(viewN) != 0) {
                return;
            }
            this.b.c(viewN, i2);
        }

        @Override // fe3.c
        public boolean g(int i) {
            return false;
        }

        @Override // fe3.c
        public void h(int i, int i2) {
            DrawerLayout.this.postDelayed(this.c, 160L);
        }

        @Override // fe3.c
        public void i(View view, int i) {
            ((f) view.getLayoutParams()).c = false;
            n();
        }

        @Override // fe3.c
        public void j(int i) {
            DrawerLayout.this.W(i, this.b.w());
        }

        @Override // fe3.c
        public void k(View view, int i, int i2, int i3, int i4) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.c(view, 3) ? i + width : DrawerLayout.this.getWidth() - i) / width;
            DrawerLayout.this.T(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // fe3.c
        public void l(View view, float f, float f2) {
            int i;
            float fU = DrawerLayout.this.u(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                i = (f > 0.0f || (f == 0.0f && fU > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && fU > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.b.P(i, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // fe3.c
        public boolean m(View view, int i) {
            return DrawerLayout.this.E(view) && DrawerLayout.this.c(view, this.a) && DrawerLayout.this.r(view) == 0;
        }

        void o() {
            View viewN;
            int width;
            int iY = this.b.y();
            boolean z = this.a == 3;
            if (z) {
                viewN = DrawerLayout.this.n(3);
                width = (viewN != null ? -viewN.getWidth() : 0) + iY;
            } else {
                viewN = DrawerLayout.this.n(5);
                width = DrawerLayout.this.getWidth() - iY;
            }
            if (viewN != null) {
                if (((!z || viewN.getLeft() >= width) && (z || viewN.getLeft() <= width)) || DrawerLayout.this.r(viewN) != 0) {
                    return;
                }
                f fVar = (f) viewN.getLayoutParams();
                this.b.R(viewN, width, viewN.getTop());
                fVar.c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.c);
        }

        public void q(fe3 fe3Var) {
            this.b = fe3Var;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        S = true;
        T = true;
        U = i >= 29;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    static boolean A(View view) {
        return (be3.y(view) == 4 || be3.y(view) == 2) ? false : true;
    }

    private boolean G(float f2, float f3, View view) {
        if (this.N == null) {
            this.N = new Rect();
        }
        view.getHitRect(this.N);
        return this.N.contains((int) f2, (int) f3);
    }

    private void H(Drawable drawable, int i) {
        if (drawable == null || !dd0.h(drawable)) {
            return;
        }
        dd0.m(drawable, i);
    }

    private Drawable O() {
        int iA = be3.A(this);
        if (iA == 0) {
            Drawable drawable = this.I;
            if (drawable != null) {
                H(drawable, iA);
                return this.I;
            }
        } else {
            Drawable drawable2 = this.J;
            if (drawable2 != null) {
                H(drawable2, iA);
                return this.J;
            }
        }
        return this.K;
    }

    private Drawable P() {
        int iA = be3.A(this);
        if (iA == 0) {
            Drawable drawable = this.J;
            if (drawable != null) {
                H(drawable, iA);
                return this.J;
            }
        } else {
            Drawable drawable2 = this.I;
            if (drawable2 != null) {
                H(drawable2, iA);
                return this.I;
            }
        }
        return this.L;
    }

    private void Q() {
        if (T) {
            return;
        }
        this.x = O();
        this.y = P();
    }

    private void U(View view) {
        m2.a aVar = m2.a.y;
        be3.j0(view, aVar.b());
        if (!D(view) || r(view) == 2) {
            return;
        }
        be3.l0(view, aVar, null, this.P);
    }

    private void V(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || E(childAt)) && !(z && childAt == view)) {
                be3.z0(childAt, 4);
            } else {
                be3.z0(childAt, 1);
            }
        }
    }

    private boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent motionEventV = v(motionEvent, view);
            boolean zDispatchGenericMotionEvent = view.dispatchGenericMotionEvent(motionEventV);
            motionEventV.recycle();
            return zDispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean zDispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return zDispatchGenericMotionEvent2;
    }

    private MotionEvent v(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.O == null) {
                this.O = new Matrix();
            }
            matrix.invert(this.O);
            motionEventObtain.transform(this.O);
        }
        return motionEventObtain;
    }

    static String w(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        return (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean y() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((f) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    private boolean z() {
        return p() != null;
    }

    boolean B(View view) {
        return ((f) view.getLayoutParams()).a == 0;
    }

    public boolean C(int i) {
        View viewN = n(i);
        if (viewN != null) {
            return D(viewN);
        }
        return false;
    }

    public boolean D(View view) {
        if (E(view)) {
            return (((f) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean E(View view) {
        int iB = iv0.b(((f) view.getLayoutParams()).a, be3.A(view));
        return ((iB & 3) == 0 && (iB & 5) == 0) ? false : true;
    }

    public boolean F(View view) {
        if (E(view)) {
            return ((f) view.getLayoutParams()).b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void I(View view, float f2) {
        float fU = u(view);
        float width = view.getWidth();
        int i = ((int) (width * f2)) - ((int) (fU * width));
        if (!c(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        T(view, f2);
    }

    public void J(int i) {
        K(i, true);
    }

    public void K(int i, boolean z) {
        View viewN = n(i);
        if (viewN != null) {
            M(viewN, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i));
    }

    public void L(View view) {
        M(view, true);
    }

    public void M(View view, boolean z) {
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.m) {
            fVar.b = 1.0f;
            fVar.d = 1;
            V(view, true);
            U(view);
        } else if (z) {
            fVar.d |= 2;
            if (c(view, 3)) {
                this.g.R(view, 0, view.getTop());
            } else {
                this.h.R(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            I(view, 1.0f);
            W(0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    public void N(e eVar) {
        List list;
        if (eVar == null || (list = this.t) == null) {
            return;
        }
        list.remove(eVar);
    }

    public void R(Object obj, boolean z) {
        this.G = obj;
        this.H = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void S(int i, int i2) {
        View viewN;
        int iB = iv0.b(i2, be3.A(this));
        if (i2 == 3) {
            this.n = i;
        } else if (i2 == 5) {
            this.o = i;
        } else if (i2 == 8388611) {
            this.p = i;
        } else if (i2 == 8388613) {
            this.f192q = i;
        }
        if (i != 0) {
            (iB == 3 ? this.g : this.h).b();
        }
        if (i != 1) {
            if (i == 2 && (viewN = n(iB)) != null) {
                L(viewN);
                return;
            }
            return;
        }
        View viewN2 = n(iB);
        if (viewN2 != null) {
            f(viewN2);
        }
    }

    void T(View view, float f2) {
        f fVar = (f) view.getLayoutParams();
        if (f2 == fVar.b) {
            return;
        }
        fVar.b = f2;
        l(view, f2);
    }

    void W(int i, View view) {
        int i2;
        int iB = this.g.B();
        int iB2 = this.h.B();
        if (iB == 1 || iB2 == 1) {
            i2 = 1;
        } else {
            i2 = 2;
            if (iB != 2 && iB2 != 2) {
                i2 = 0;
            }
        }
        if (view != null && i == 0) {
            float f2 = ((f) view.getLayoutParams()).b;
            if (f2 == 0.0f) {
                j(view);
            } else if (f2 == 1.0f) {
                k(view);
            }
        }
        if (i2 != this.k) {
            this.k = i2;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.t.get(size)).c(i2);
                }
            }
        }
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (!E(childAt)) {
                this.M.add(childAt);
            } else if (D(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
        }
        if (!z) {
            int size = this.M.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) this.M.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.M.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (o() != null || E(view)) {
            be3.z0(view, 4);
        } else {
            be3.z0(view, 1);
        }
        if (S) {
            return;
        }
        be3.p0(view, this.a);
    }

    void b() {
        if (this.r) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).dispatchTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
        this.r = true;
    }

    boolean c(View view, int i) {
        return (t(view) & i) == i;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((f) getChildAt(i).getLayoutParams()).b);
        }
        this.e = fMax;
        boolean zN = this.g.n(true);
        boolean zN2 = this.h.n(true);
        if (zN || zN2) {
            be3.g0(this);
        }
    }

    public void d(int i) {
        e(i, true);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (G(x, y, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean zB = B(view);
        int width = getWidth();
        int iSave = canvas.save();
        int i = 0;
        if (zB) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && x(childAt) && E(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        float f2 = this.e;
        if (f2 > 0.0f && zB) {
            int i4 = this.d;
            this.f.setColor((i4 & 16777215) | (((int) ((((-16777216) & i4) >>> 24) * f2)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.f);
        } else if (this.x != null && c(view, 3)) {
            int intrinsicWidth = this.x.getIntrinsicWidth();
            int right2 = view.getRight();
            float fMax = Math.max(0.0f, Math.min(right2 / this.g.y(), 1.0f));
            this.x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.x.setAlpha((int) (fMax * 255.0f));
            this.x.draw(canvas);
        } else if (this.y != null && c(view, 5)) {
            int intrinsicWidth2 = this.y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float fMax2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.h.y(), 1.0f));
            this.y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.y.setAlpha((int) (fMax2 * 255.0f));
            this.y.draw(canvas);
        }
        return zDrawChild;
    }

    public void e(int i, boolean z) {
        View viewN = n(i);
        if (viewN != null) {
            g(viewN, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i));
    }

    public void f(View view) {
        g(view, true);
    }

    public void g(View view, boolean z) {
        if (!E(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        f fVar = (f) view.getLayoutParams();
        if (this.m) {
            fVar.b = 0.0f;
            fVar.d = 0;
        } else if (z) {
            fVar.d |= 4;
            if (c(view, 3)) {
                this.g.R(view, -view.getWidth(), view.getTop());
            } else {
                this.h.R(view, getWidth(), view.getTop());
            }
        } else {
            I(view, 0.0f);
            W(0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (T) {
            return this.b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.w;
    }

    public void h() {
        i(false);
    }

    void i(boolean z) {
        int childCount = getChildCount();
        boolean zR = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            f fVar = (f) childAt.getLayoutParams();
            if (E(childAt) && (!z || fVar.c)) {
                zR |= c(childAt, 3) ? this.g.R(childAt, -childAt.getWidth(), childAt.getTop()) : this.h.R(childAt, getWidth(), childAt.getTop());
                fVar.c = false;
            }
        }
        this.i.p();
        this.j.p();
        if (zR) {
            invalidate();
        }
    }

    void j(View view) {
        View rootView;
        f fVar = (f) view.getLayoutParams();
        if ((fVar.d & 1) == 1) {
            fVar.d = 0;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.t.get(size)).b(view);
                }
            }
            V(view, false);
            U(view);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    void k(View view) {
        f fVar = (f) view.getLayoutParams();
        if ((fVar.d & 1) == 0) {
            fVar.d = 1;
            List list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((e) this.t.get(size)).a(view);
                }
            }
            V(view, true);
            U(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void l(View view, float f2) {
        List list = this.t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((e) this.t.get(size)).d(view, f2);
            }
        }
    }

    View n(int i) {
        int iB = iv0.b(i, be3.A(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((t(childAt) & 7) == iB) {
                return childAt;
            }
        }
        return null;
    }

    View o() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((f) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.H || this.w == null) {
            return;
        }
        Object obj = this.G;
        int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.w.draw(canvas);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewU;
        int actionMasked = motionEvent.getActionMasked();
        boolean zQ = this.g.Q(motionEvent) | this.h.Q(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                i(true);
                this.r = false;
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    i(true);
                    this.r = false;
                }
            } else if (this.g.e(3)) {
                this.i.p();
                this.j.p();
            }
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.u = x;
            this.v = y;
            z = this.e > 0.0f && (viewU = this.g.u((int) x, (int) y)) != null && B(viewU);
            this.r = false;
        }
        return zQ || z || y() || this.r;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !z()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View viewP = p();
        if (viewP != null && r(viewP) == 0) {
            h();
        }
        return viewP != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f2;
        int i5;
        boolean z2 = true;
        this.l = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i8 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i8, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i8, ((ViewGroup.MarginLayoutParams) fVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f3 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (fVar.b * f3));
                        f2 = (measuredWidth + i5) / f3;
                    } else {
                        float f4 = measuredWidth;
                        int i9 = i6 - ((int) (fVar.b * f4));
                        f2 = (i6 - i9) / f4;
                        i5 = i9;
                    }
                    boolean z3 = f2 != fVar.b ? z2 : false;
                    int i10 = fVar.a & 112;
                    if (i10 == 16) {
                        int i11 = i4 - i2;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i12, measuredWidth + i5, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        childAt.layout(i5, i16, measuredWidth + i5, measuredHeight + i16);
                    } else {
                        int i17 = i4 - i2;
                        childAt.layout(i5, (i17 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i17 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    }
                    if (z3) {
                        T(childAt, f2);
                    }
                    int i18 = fVar.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
            i7++;
            z2 = true;
        }
        if (U && (rootWindowInsets = getRootWindowInsets()) != null) {
            z21 z21VarH = zi3.w(rootWindowInsets).h();
            fe3 fe3Var = this.g;
            fe3Var.M(Math.max(fe3Var.x(), z21VarH.a));
            fe3 fe3Var2 = this.h;
            fe3Var2.M(Math.max(fe3Var2.x(), z21VarH.c));
        }
        this.l = false;
        this.m = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        boolean z = this.G != null && be3.x(this);
        int iA = be3.A(this);
        int childCount = getChildCount();
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z) {
                    int iB = iv0.b(fVar.a, iA);
                    if (be3.x(childAt)) {
                        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) this.G;
                        if (iB == 3) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        } else if (iB == 5) {
                            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
                    } else {
                        WindowInsets windowInsetsReplaceSystemWindowInsets2 = (WindowInsets) this.G;
                        if (iB == 3) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        } else if (iB == 5) {
                            windowInsetsReplaceSystemWindowInsets2 = windowInsetsReplaceSystemWindowInsets2.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsetsReplaceSystemWindowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else {
                    if (!E(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (T) {
                        float fV = be3.v(childAt);
                        float f2 = this.b;
                        if (fV != f2) {
                            be3.x0(childAt, f2);
                        }
                    }
                    int iT = t(childAt) & 7;
                    boolean z4 = iT == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(iT) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.c + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                }
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewN;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.a;
        if (i != 0 && (viewN = n(i)) != null) {
            L(viewN);
        }
        int i2 = savedState.b;
        if (i2 != 3) {
            S(i2, 3);
        }
        int i3 = savedState.c;
        if (i3 != 3) {
            S(i3, 5);
        }
        int i4 = savedState.d;
        if (i4 != 3) {
            S(i4, 8388611);
        }
        int i5 = savedState.e;
        if (i5 != 3) {
            S(i5, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Q();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            f fVar = (f) getChildAt(i).getLayoutParams();
            int i2 = fVar.d;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                savedState.a = fVar.a;
                break;
            }
        }
        savedState.b = this.n;
        savedState.c = this.o;
        savedState.d = this.p;
        savedState.e = this.f192q;
        return savedState;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005a  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewO;
        this.g.G(motionEvent);
        this.h.G(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.u = x;
            this.v = y;
            this.r = false;
        } else if (action == 1) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            View viewU = this.g.u((int) x2, (int) y2);
            if (viewU != null && B(viewU)) {
                float f2 = x2 - this.u;
                float f3 = y2 - this.v;
                int iA = this.g.A();
                z = (f2 * f2) + (f3 * f3) >= ((float) (iA * iA)) || (viewO = o()) == null || r(viewO) == 2;
            }
            i(z);
        } else if (action == 3) {
            i(true);
            this.r = false;
        }
        return true;
    }

    View p() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (E(childAt) && F(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i) {
        int iA = be3.A(this);
        if (i == 3) {
            int i2 = this.n;
            if (i2 != 3) {
                return i2;
            }
            int i3 = iA == 0 ? this.p : this.f192q;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.o;
            if (i4 != 3) {
                return i4;
            }
            int i5 = iA == 0 ? this.f192q : this.p;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.p;
            if (i6 != 3) {
                return i6;
            }
            int i7 = iA == 0 ? this.n : this.o;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.f192q;
        if (i8 != 3) {
            return i8;
        }
        int i9 = iA == 0 ? this.o : this.n;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    public int r(View view) {
        if (E(view)) {
            return q(((f) view.getLayoutParams()).a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            i(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.l) {
            return;
        }
        super.requestLayout();
    }

    public CharSequence s(int i) {
        int iB = iv0.b(i, be3.A(this));
        if (iB == 3) {
            return this.z;
        }
        if (iB == 5) {
            return this.F;
        }
        return null;
    }

    public void setDrawerElevation(float f2) {
        this.b = f2;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (E(childAt)) {
                be3.x0(childAt, this.b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.s;
        if (eVar2 != null) {
            N(eVar2);
        }
        if (eVar != null) {
            a(eVar);
        }
        this.s = eVar;
    }

    public void setDrawerLockMode(int i) {
        S(i, 3);
        S(i, 5);
    }

    public void setScrimColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.w = new ColorDrawable(i);
        invalidate();
    }

    int t(View view) {
        return iv0.b(((f) view.getLayoutParams()).a, be3.A(this));
    }

    float u(View view) {
        return ((f) view.getLayoutParams()).b;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.drawerLayoutStyle);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new d();
        this.d = -1728053248;
        this.f = new Paint();
        this.m = true;
        this.n = 3;
        this.o = 3;
        this.p = 3;
        this.f192q = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.P = new a();
        setDescendantFocusability(Opcodes.ASM4);
        float f2 = getResources().getDisplayMetrics().density;
        this.c = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        h hVar = new h(3);
        this.i = hVar;
        h hVar2 = new h(5);
        this.j = hVar2;
        fe3 fe3VarO = fe3.o(this, 1.0f, hVar);
        this.g = fe3VarO;
        fe3VarO.N(1);
        fe3VarO.O(f3);
        hVar.q(fe3VarO);
        fe3 fe3VarO2 = fe3.o(this, 1.0f, hVar2);
        this.h = fe3VarO2;
        fe3VarO2.N(2);
        fe3VarO2.O(f3);
        hVar2.q(fe3VarO2);
        setFocusableInTouchMode(true);
        be3.z0(this, 1);
        be3.p0(this, new c());
        setMotionEventSplittingEnabled(false);
        if (be3.x(this)) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(1280);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Q);
            try {
                this.w = typedArrayObtainStyledAttributes.getDrawable(0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.DrawerLayout, i, 0);
        try {
            int i2 = R$styleable.DrawerLayout_elevation;
            if (typedArrayObtainStyledAttributes2.hasValue(i2)) {
                this.b = typedArrayObtainStyledAttributes2.getDimension(i2, 0.0f);
            } else {
                this.b = getResources().getDimension(R$dimen.def_drawer_elevation);
            }
            typedArrayObtainStyledAttributes2.recycle();
            this.M = new ArrayList();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes2.recycle();
            throw th2;
        }
    }

    public void setStatusBarBackground(int i) {
        this.w = i != 0 ? q30.e(getContext(), i) : null;
        invalidate();
    }

    public static class f extends ViewGroup.MarginLayoutParams {
        public int a;
        float b;
        boolean c;
        int d;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.R);
            this.a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public f(int i, int i2) {
            super(i, i2);
            this.a = 0;
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.a = 0;
            this.a = fVar.a;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        int b;
        int c;
        int d;
        int e;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = 0;
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.a = 0;
        }
    }
}
