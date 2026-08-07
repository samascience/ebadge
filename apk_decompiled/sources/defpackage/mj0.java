package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class mj0 extends t1 {
    private static final Rect k = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final do0.a l = new a();
    private static final do0.b m = new b();
    private final AccessibilityManager e;
    private final View f;
    private c g;
    private final Rect a = new Rect();
    private final Rect b = new Rect();
    private final Rect c = new Rect();
    private final int[] d = new int[2];
    int h = Integer.MIN_VALUE;
    int i = Integer.MIN_VALUE;
    private int j = Integer.MIN_VALUE;

    class a implements do0.a {
        a() {
        }

        @Override // do0.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m2 m2Var, Rect rect) {
            m2Var.k(rect);
        }
    }

    class b implements do0.b {
        b() {
        }

        @Override // do0.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public m2 a(ns2 ns2Var, int i) {
            return (m2) ns2Var.i(i);
        }

        @Override // do0.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(ns2 ns2Var) {
            return ns2Var.h();
        }
    }

    private class c extends n2 {
        c() {
        }

        @Override // defpackage.n2
        public m2 b(int i) {
            return m2.X(mj0.this.y(i));
        }

        @Override // defpackage.n2
        public m2 d(int i) {
            int i2 = i == 2 ? mj0.this.h : mj0.this.i;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i2);
        }

        @Override // defpackage.n2
        public boolean f(int i, int i2, Bundle bundle) {
            return mj0.this.G(i, i2, bundle);
        }
    }

    public mj0(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f = view;
        this.e = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (be3.y(view) == 0) {
            be3.z0(view, 1);
        }
    }

    private boolean H(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return K(i);
        }
        if (i2 == 2) {
            return d(i);
        }
        if (i2 != 64) {
            return i2 != 128 ? A(i, i2, bundle) : c(i);
        }
        return J(i);
    }

    private boolean I(int i, Bundle bundle) {
        return be3.e0(this.f, i, bundle);
    }

    private boolean J(int i) {
        int i2;
        if (!this.e.isEnabled() || !this.e.isTouchExplorationEnabled() || (i2 = this.h) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            c(i2);
        }
        this.h = i;
        this.f.invalidate();
        L(i, 32768);
        return true;
    }

    private void M(int i) {
        int i2 = this.j;
        if (i2 == i) {
            return;
        }
        this.j = i;
        L(i, 128);
        L(i2, 256);
    }

    private boolean c(int i) {
        if (this.h != i) {
            return false;
        }
        this.h = Integer.MIN_VALUE;
        this.f.invalidate();
        L(i, 65536);
        return true;
    }

    private boolean e() {
        int i = this.i;
        return i != Integer.MIN_VALUE && A(i, 16, null);
    }

    private AccessibilityEvent f(int i, int i2) {
        return i != -1 ? g(i, i2) : h(i2);
    }

    private AccessibilityEvent g(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        m2 m2VarY = y(i);
        accessibilityEventObtain.getText().add(m2VarY.z());
        accessibilityEventObtain.setContentDescription(m2VarY.s());
        accessibilityEventObtain.setScrollable(m2VarY.R());
        accessibilityEventObtain.setPassword(m2VarY.Q());
        accessibilityEventObtain.setEnabled(m2VarY.K());
        accessibilityEventObtain.setChecked(m2VarY.H());
        C(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(m2VarY.o());
        o2.c(accessibilityEventObtain, this.f, i);
        accessibilityEventObtain.setPackageName(this.f.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    private AccessibilityEvent h(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.f.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    private m2 i(int i) {
        m2 m2VarW = m2.W();
        m2VarW.p0(true);
        m2VarW.r0(true);
        m2VarW.j0("android.view.View");
        Rect rect = k;
        m2VarW.e0(rect);
        m2VarW.f0(rect);
        m2VarW.B0(this.f);
        E(i, m2VarW);
        if (m2VarW.z() == null && m2VarW.s() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        m2VarW.k(this.b);
        if (this.b.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int i2 = m2VarW.i();
        if ((i2 & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((i2 & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        m2VarW.z0(this.f.getContext().getPackageName());
        m2VarW.K0(this.f, i);
        if (this.h == i) {
            m2VarW.c0(true);
            m2VarW.a(128);
        } else {
            m2VarW.c0(false);
            m2VarW.a(64);
        }
        boolean z = this.i == i;
        if (z) {
            m2VarW.a(2);
        } else if (m2VarW.L()) {
            m2VarW.a(1);
        }
        m2VarW.s0(z);
        this.f.getLocationOnScreen(this.d);
        m2VarW.l(this.a);
        if (this.a.equals(rect)) {
            m2VarW.k(this.a);
            if (m2VarW.b != -1) {
                m2 m2VarW2 = m2.W();
                for (int i3 = m2VarW.b; i3 != -1; i3 = m2VarW2.b) {
                    m2VarW2.C0(this.f, -1);
                    m2VarW2.e0(k);
                    E(i3, m2VarW2);
                    m2VarW2.k(this.b);
                    Rect rect2 = this.a;
                    Rect rect3 = this.b;
                    rect2.offset(rect3.left, rect3.top);
                }
                m2VarW2.a0();
            }
            this.a.offset(this.d[0] - this.f.getScrollX(), this.d[1] - this.f.getScrollY());
        }
        if (this.f.getLocalVisibleRect(this.c)) {
            this.c.offset(this.d[0] - this.f.getScrollX(), this.d[1] - this.f.getScrollY());
            if (this.a.intersect(this.c)) {
                m2VarW.f0(this.a);
                if (v(this.a)) {
                    m2VarW.O0(true);
                }
            }
        }
        return m2VarW;
    }

    private m2 j() {
        m2 m2VarY = m2.Y(this.f);
        be3.c0(this.f, m2VarY);
        ArrayList arrayList = new ArrayList();
        r(arrayList);
        if (m2VarY.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m2VarY.d(this.f, ((Integer) arrayList.get(i)).intValue());
        }
        return m2VarY;
    }

    private ns2 n() {
        ArrayList arrayList = new ArrayList();
        r(arrayList);
        ns2 ns2Var = new ns2();
        for (int i = 0; i < arrayList.size(); i++) {
            ns2Var.g(((Integer) arrayList.get(i)).intValue(), i(((Integer) arrayList.get(i)).intValue()));
        }
        return ns2Var;
    }

    private void o(int i, Rect rect) {
        y(i).k(rect);
    }

    private static Rect s(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    private boolean v(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int w(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean x(int i, Rect rect) {
        m2 m2Var;
        ns2 ns2VarN = n();
        int i2 = this.i;
        m2 m2Var2 = i2 == Integer.MIN_VALUE ? null : (m2) ns2VarN.d(i2);
        if (i == 1 || i == 2) {
            m2Var = (m2) do0.d(ns2VarN, m, l, m2Var2, i, be3.A(this.f) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.i;
            if (i3 != Integer.MIN_VALUE) {
                o(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                s(this.f, i, rect2);
            }
            m2Var = (m2) do0.c(ns2VarN, m, l, m2Var2, rect2, i);
        }
        return K(m2Var != null ? ns2VarN.f(ns2VarN.e(m2Var)) : Integer.MIN_VALUE);
    }

    protected abstract boolean A(int i, int i2, Bundle bundle);

    protected void B(AccessibilityEvent accessibilityEvent) {
    }

    protected void C(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void D(m2 m2Var) {
    }

    protected abstract void E(int i, m2 m2Var);

    protected void F(int i, boolean z) {
    }

    boolean G(int i, int i2, Bundle bundle) {
        return i != -1 ? H(i, i2, bundle) : I(i2, bundle);
    }

    public final boolean K(int i) {
        int i2;
        if ((!this.f.isFocused() && !this.f.requestFocus()) || (i2 = this.i) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            d(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.i = i;
        F(i, true);
        L(i, 8);
        return true;
    }

    public final boolean L(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.e.isEnabled() || (parent = this.f.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f, f(i, i2));
    }

    public final boolean d(int i) {
        if (this.i != i) {
            return false;
        }
        this.i = Integer.MIN_VALUE;
        F(i, false);
        L(i, 8);
        return true;
    }

    @Override // defpackage.t1
    public n2 getAccessibilityNodeProvider(View view) {
        if (this.g == null) {
            this.g = new c();
        }
        return this.g;
    }

    public final boolean k(MotionEvent motionEvent) {
        if (!this.e.isEnabled() || !this.e.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iQ = q(motionEvent.getX(), motionEvent.getY());
            M(iQ);
            return iQ != Integer.MIN_VALUE;
        }
        if (action != 10 || this.j == Integer.MIN_VALUE) {
            return false;
        }
        M(Integer.MIN_VALUE);
        return true;
    }

    public final boolean l(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return x(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return x(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iW = w(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i < repeatCount && x(iW, null)) {
                        i++;
                        z = true;
                    }
                    return z;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        e();
        return true;
    }

    public final int m() {
        return this.h;
    }

    @Override // defpackage.t1
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        B(accessibilityEvent);
    }

    @Override // defpackage.t1
    public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
        super.onInitializeAccessibilityNodeInfo(view, m2Var);
        D(m2Var);
    }

    public final int p() {
        return this.i;
    }

    protected abstract int q(float f, float f2);

    protected abstract void r(List list);

    public final void t(int i) {
        u(i, 0);
    }

    public final void u(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.e.isEnabled() || (parent = this.f.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventF = f(i, 2048);
        u1.b(accessibilityEventF, i2);
        parent.requestSendAccessibilityEvent(this.f, accessibilityEventF);
    }

    m2 y(int i) {
        return i == -1 ? j() : i(i);
    }

    public final void z(boolean z, int i, Rect rect) {
        int i2 = this.i;
        if (i2 != Integer.MIN_VALUE) {
            d(i2);
        }
        if (z) {
            x(i, rect);
        }
    }
}
