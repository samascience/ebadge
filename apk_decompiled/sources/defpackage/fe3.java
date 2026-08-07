package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.tenmeter.smlibrary.banner.config.BannerConfig;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class fe3 {
    private static final Interpolator x = new a();
    private int a;
    private int b;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private final int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f333q;
    private OverScroller r;
    private final c s;
    private View t;
    private boolean u;
    private final ViewGroup v;
    private int c = -1;
    private final Runnable w = new b();

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fe3.this.L(0);
        }
    }

    public static abstract class c {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public int c(int i) {
            return i;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i, int i2) {
        }

        public boolean g(int i) {
            return false;
        }

        public void h(int i, int i2) {
        }

        public void i(View view, int i) {
        }

        public void j(int i) {
        }

        public void k(View view, int i, int i2, int i3, int i4) {
        }

        public void l(View view, float f, float f2) {
        }

        public abstract boolean m(View view, int i);
    }

    private fe3(Context context, ViewGroup viewGroup, c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.v = viewGroup;
        this.s = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.p = i;
        this.o = i;
        this.b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, x);
    }

    private boolean E(int i) {
        if (D(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void H() {
        this.l.computeCurrentVelocity(1000, this.m);
        q(h(this.l.getXVelocity(this.c), this.n, this.m), h(this.l.getYVelocity(this.c), this.n, this.m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [fe3$c] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void I(float f, float f2, int i) {
        int i2;
        boolean zD = d(f, f2, i, 1);
        ?? r0 = zD;
        if (d(f2, f, i, 4)) {
            r0 = (zD ? 1 : 0) | 4;
        }
        ?? r1 = r0;
        if (d(f, f2, i, 2)) {
            r1 = (r0 == true ? 1 : 0) | 2;
        }
        ?? r2 = r1;
        if (d(f2, f, i, 8)) {
            i2 = (r1 == true ? 1 : 0) | 8;
        }
        if (r2 == 0) {
            r2 = i2;
            return;
        }
        r2 = i2;
        int[] iArr = this.i;
        iArr[i] = (iArr[i] | r2) == true ? 1 : 0;
        this.s.f(r2, i);
    }

    private void J(float f, float f2, int i) {
        t(i);
        float[] fArr = this.d;
        this.f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.e;
        this.g[i] = f2;
        fArr2[i] = f2;
        this.h[i] = z((int) f, (int) f2);
        this.k |= 1 << i;
    }

    private void K(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (E(pointerId)) {
                float x2 = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f[pointerId] = x2;
                this.g[pointerId] = y;
            }
        }
    }

    private boolean d(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.h[i] & i2) != i2 || (this.f333q & i2) == 0 || (this.j[i] & i2) == i2 || (this.i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.b;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.s.g(i2)) {
            return (this.i[i] & i2) == 0 && fAbs > ((float) this.b);
        }
        int[] iArr = this.j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    private boolean g(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.d(view) > 0;
        boolean z2 = this.s.e(view) > 0;
        if (z && z2) {
            float f3 = (f * f) + (f2 * f2);
            int i = this.b;
            return f3 > ((float) (i * i));
        }
        if (z) {
            return Math.abs(f) > ((float) this.b);
        }
        return z2 && Math.abs(f2) > ((float) this.b);
    }

    private float h(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        if (fAbs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    private int i(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        if (iAbs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    private void j() {
        float[] fArr = this.d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.e, 0.0f);
        Arrays.fill(this.f, 0.0f);
        Arrays.fill(this.g, 0.0f);
        Arrays.fill(this.h, 0);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    private void k(int i) {
        if (this.d == null || !D(i)) {
            return;
        }
        this.d[i] = 0.0f;
        this.e[i] = 0.0f;
        this.f[i] = 0.0f;
        this.g[i] = 0.0f;
        this.h[i] = 0;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k = (~(1 << i)) & this.k;
    }

    private int l(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f = width / 2;
        float fR = f + (r(Math.min(1.0f, Math.abs(i) / width)) * f);
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fR / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), BannerConfig.SCROLL_TIME);
    }

    private int m(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int i5 = i(i3, (int) this.n, (int) this.m);
        int i6 = i(i4, (int) this.n, (int) this.m);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(i5);
        int iAbs4 = Math.abs(i6);
        int i7 = iAbs3 + iAbs4;
        int i8 = iAbs + iAbs2;
        if (i5 != 0) {
            f = iAbs3;
            f2 = i7;
        } else {
            f = iAbs;
            f2 = i8;
        }
        float f5 = f / f2;
        if (i6 != 0) {
            f3 = iAbs4;
            f4 = i7;
        } else {
            f3 = iAbs2;
            f4 = i8;
        }
        return (int) ((l(i, i5, this.s.d(view)) * f5) + (l(i2, i6, this.s.e(view)) * (f3 / f4)));
    }

    public static fe3 o(ViewGroup viewGroup, float f, c cVar) {
        fe3 fe3VarP = p(viewGroup, cVar);
        fe3VarP.b = (int) (fe3VarP.b * (1.0f / f));
        return fe3VarP;
    }

    public static fe3 p(ViewGroup viewGroup, c cVar) {
        return new fe3(viewGroup.getContext(), viewGroup, cVar);
    }

    private void q(float f, float f2) {
        this.u = true;
        this.s.l(this.t, f, f2);
        this.u = false;
        if (this.a == 1) {
            L(0);
        }
    }

    private float r(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void s(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i3 != 0) {
            i = this.s.a(this.t, i, i3);
            be3.Z(this.t, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.s.b(this.t, i2, i4);
            be3.a0(this.t, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.s.k(this.t, i5, i6, i5 - left, i6 - top);
    }

    private void t(int i) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.e = fArr3;
            this.f = fArr4;
            this.g = fArr5;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
    }

    private boolean v(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.r.abortAnimation();
            L(0);
            return false;
        }
        this.r.startScroll(left, top, i5, i6, m(this.t, i5, i6, i3, i4));
        L(2);
        return true;
    }

    private int z(int i, int i2) {
        int i3 = i < this.v.getLeft() + this.o ? 1 : 0;
        if (i2 < this.v.getTop() + this.o) {
            i3 |= 4;
        }
        if (i > this.v.getRight() - this.o) {
            i3 |= 2;
        }
        return i2 > this.v.getBottom() - this.o ? i3 | 8 : i3;
    }

    public int A() {
        return this.b;
    }

    public int B() {
        return this.a;
    }

    public boolean C(int i, int i2) {
        return F(this.t, i, i2);
    }

    public boolean D(int i) {
        return ((1 << i) & this.k) != 0;
    }

    public boolean F(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void G(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewU = u((int) x2, (int) y);
            J(x2, y, pointerId);
            S(viewU, pointerId);
            int i3 = this.h[pointerId];
            int i4 = this.f333q;
            if ((i3 & i4) != 0) {
                this.s.h(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.a == 1) {
                H();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.a == 1) {
                if (E(this.c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.c);
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f;
                    int i5 = this.c;
                    int i6 = (int) (x3 - fArr[i5]);
                    int i7 = (int) (y2 - this.g[i5]);
                    s(this.t.getLeft() + i6, this.t.getTop() + i7, i6, i7);
                    K(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (E(pointerId2)) {
                    float x4 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x4 - this.d[pointerId2];
                    float f2 = y3 - this.e[pointerId2];
                    I(f, f2, pointerId2);
                    if (this.a != 1) {
                        View viewU2 = u((int) x4, (int) y3);
                        if (g(viewU2, f, f2) && S(viewU2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            K(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.a == 1) {
                q(0.0f, 0.0f);
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x5 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            J(x5, y4, pointerId3);
            if (this.a != 0) {
                if (C((int) x5, (int) y4)) {
                    S(this.t, pointerId3);
                    return;
                }
                return;
            } else {
                S(u((int) x5, (int) y4), pointerId3);
                int i8 = this.h[pointerId3];
                int i9 = this.f333q;
                if ((i8 & i9) != 0) {
                    this.s.h(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.a == 1 && pointerId4 == this.c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.c) {
                    View viewU3 = u((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    View view = this.t;
                    if (viewU3 == view && S(view, pointerId5)) {
                        i = this.c;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                H();
            }
        }
        k(pointerId4);
    }

    void L(int i) {
        this.v.removeCallbacks(this.w);
        if (this.a != i) {
            this.a = i;
            this.s.j(i);
            if (this.a == 0) {
                this.t = null;
            }
        }
    }

    public void M(int i) {
        this.o = i;
    }

    public void N(int i) {
        this.f333q = i;
    }

    public void O(float f) {
        this.n = f;
    }

    public boolean P(int i, int i2) {
        if (this.u) {
            return v(i, i2, (int) this.l.getXVelocity(this.c), (int) this.l.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    public boolean Q(MotionEvent motionEvent) {
        boolean z;
        View viewU;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                b();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    b();
                } else if (actionMasked == 5) {
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    float x2 = motionEvent.getX(actionIndex);
                    float y = motionEvent.getY(actionIndex);
                    J(x2, y, pointerId);
                    int i = this.a;
                    if (i == 0) {
                        int i2 = this.h[pointerId];
                        int i3 = this.f333q;
                        if ((i2 & i3) != 0) {
                            this.s.h(i2 & i3, pointerId);
                        }
                    } else if (i == 2 && (viewU = u((int) x2, (int) y)) == this.t) {
                        S(viewU, pointerId);
                    }
                } else if (actionMasked == 6) {
                    k(motionEvent.getPointerId(actionIndex));
                }
            } else if (this.d != null && this.e != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i4 = 0; i4 < pointerCount; i4++) {
                    int pointerId2 = motionEvent.getPointerId(i4);
                    if (E(pointerId2)) {
                        float x3 = motionEvent.getX(i4);
                        float y2 = motionEvent.getY(i4);
                        float f = x3 - this.d[pointerId2];
                        float f2 = y2 - this.e[pointerId2];
                        View viewU2 = u((int) x3, (int) y2);
                        boolean z2 = viewU2 != null && g(viewU2, f, f2);
                        if (!z2) {
                            I(f, f2, pointerId2);
                            if (this.a != 1) {
                                break;
                            }
                        } else {
                            int left = viewU2.getLeft();
                            int i5 = (int) f;
                            int iA = this.s.a(viewU2, left + i5, i5);
                            int top = viewU2.getTop();
                            int i6 = (int) f2;
                            int iB = this.s.b(viewU2, top + i6, i6);
                            int iD = this.s.d(viewU2);
                            int iE = this.s.e(viewU2);
                            if ((iD == 0 || (iD > 0 && iA == left)) && (iE == 0 || (iE > 0 && iB == top))) {
                                break;
                            }
                            I(f, f2, pointerId2);
                            if (this.a != 1 || (z2 && S(viewU2, pointerId2))) {
                                break;
                            }
                        }
                    }
                }
                K(motionEvent);
            }
            z = false;
        } else {
            float x4 = motionEvent.getX();
            float y3 = motionEvent.getY();
            z = false;
            int pointerId3 = motionEvent.getPointerId(0);
            J(x4, y3, pointerId3);
            View viewU3 = u((int) x4, (int) y3);
            if (viewU3 == this.t && this.a == 2) {
                S(viewU3, pointerId3);
            }
            int i7 = this.h[pointerId3];
            int i8 = this.f333q;
            if ((i7 & i8) != 0) {
                this.s.h(i7 & i8, pointerId3);
            }
        }
        if (this.a == 1) {
            return true;
        }
        return z;
    }

    public boolean R(View view, int i, int i2) {
        this.t = view;
        this.c = -1;
        boolean zV = v(i, i2, 0, 0);
        if (!zV && this.a == 0 && this.t != null) {
            this.t = null;
        }
        return zV;
    }

    boolean S(View view, int i) {
        if (view == this.t && this.c == i) {
            return true;
        }
        if (view == null || !this.s.m(view, i)) {
            return false;
        }
        this.c = i;
        c(view, i);
        return true;
    }

    public void a() {
        b();
        if (this.a == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.k(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        L(0);
    }

    public void b() {
        this.c = -1;
        j();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public void c(View view, int i) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.c = i;
            this.s.i(view, i);
            L(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public boolean e(int i) {
        int length = this.d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (f(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(int i, int i2) {
        if (!D(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f[i2] - this.d[i2];
        float f2 = this.g[i2] - this.e[i2];
        if (z && z2) {
            float f3 = (f * f) + (f2 * f2);
            int i3 = this.b;
            return f3 > ((float) (i3 * i3));
        }
        if (z) {
            return Math.abs(f) > ((float) this.b);
        }
        return z2 && Math.abs(f2) > ((float) this.b);
    }

    public boolean n(boolean z) {
        if (this.a == 2) {
            boolean zComputeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                be3.Z(this.t, left);
            }
            if (top != 0) {
                be3.a0(this.t, top);
            }
            if (left != 0 || top != 0) {
                this.s.k(this.t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.v.post(this.w);
                } else {
                    L(0);
                }
            }
        }
        return this.a == 2;
    }

    public View u(int i, int i2) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.v.getChildAt(this.s.c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public View w() {
        return this.t;
    }

    public int x() {
        return this.p;
    }

    public int y() {
        return this.o;
    }
}
