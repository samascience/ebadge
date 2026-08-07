package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.customview.view.AbsSavedState;
import com.tenmeter.smlibrary.banner.config.BannerConfig;
import defpackage.be3;
import defpackage.m2;
import defpackage.mu1;
import defpackage.q30;
import defpackage.t1;
import defpackage.zi3;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    static final int[] m0 = {R.attr.layout_gravity};
    private static final Comparator n0 = new a();
    private static final Interpolator o0 = new b();
    private static final m p0 = new m();
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private float K;
    private float L;
    private int M;
    private VelocityTracker N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private EdgeEffect T;
    private EdgeEffect U;
    private boolean V;
    private boolean W;
    private int a;
    private boolean a0;
    private final ArrayList b;
    private int b0;
    private final f c;
    private List c0;
    private final Rect d;
    private j d0;
    androidx.viewpager.widget.a e;
    private j e0;
    int f;
    private List f0;
    private int g;
    private k g0;
    private Parcelable h;
    private int h0;
    private ClassLoader i;
    private int i0;
    private Scroller j;
    private ArrayList j0;
    private boolean k;
    private final Runnable k0;
    private l l;
    private int l0;
    private int m;
    private Drawable n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f203q;
    private float r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean y;
    private boolean z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int a;
        Parcelable b;
        ClassLoader c;

        static class a implements Parcelable.ClassLoaderCreator {
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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }
    }

    static class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.b - fVar2.b;
        }
    }

    static class b implements Interpolator {
        b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.E();
        }
    }

    class d implements mu1 {
        private final Rect a = new Rect();

        d() {
        }

        @Override // defpackage.mu1
        public zi3 a(View view, zi3 zi3Var) {
            zi3 zi3VarB0 = be3.b0(view, zi3Var);
            if (zi3VarB0.p()) {
                return zi3VarB0;
            }
            Rect rect = this.a;
            rect.left = zi3VarB0.j();
            rect.top = zi3VarB0.l();
            rect.right = zi3VarB0.k();
            rect.bottom = zi3VarB0.i();
            int childCount = ViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                zi3 zi3VarH = be3.h(ViewPager.this.getChildAt(i), zi3VarB0);
                rect.left = Math.min(zi3VarH.j(), rect.left);
                rect.top = Math.min(zi3VarH.l(), rect.top);
                rect.right = Math.min(zi3VarH.k(), rect.right);
                rect.bottom = Math.min(zi3VarH.i(), rect.bottom);
            }
            return zi3VarB0.q(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    static class f {
        Object a;
        int b;
        boolean c;
        float d;
        float e;

        f() {
        }
    }

    class h extends t1 {
        h() {
        }

        private boolean c() {
            androidx.viewpager.widget.a aVar = ViewPager.this.e;
            return aVar != null && aVar.d() > 1;
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(c());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.e) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.d());
            accessibilityEvent.setFromIndex(ViewPager.this.f);
            accessibilityEvent.setToIndex(ViewPager.this.f);
        }

        @Override // defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.j0(ViewPager.class.getName());
            m2Var.G0(c());
            if (ViewPager.this.canScrollHorizontally(1)) {
                m2Var.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                m2Var.a(8192);
            }
        }

        @Override // defpackage.t1
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!ViewPager.this.canScrollHorizontally(1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.f + 1);
                return true;
            }
            if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.f - 1);
            return true;
        }
    }

    public interface i {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface j {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public interface k {
        void transformPage(View view, float f);
    }

    private class l extends DataSetObserver {
        l() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.h();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.h();
        }
    }

    static class m implements Comparator {
        m() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            g gVar = (g) view.getLayoutParams();
            g gVar2 = (g) view2.getLayoutParams();
            boolean z = gVar.a;
            if (z != gVar2.a) {
                return z ? 1 : -1;
            }
            return gVar.e - gVar2.e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.b = new ArrayList();
        this.c = new f();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.f203q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.x = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.k0 = new c();
        this.l0 = 0;
        v();
    }

    private boolean C(int i2) {
        if (this.b.size() == 0) {
            if (this.V) {
                return false;
            }
            this.a0 = false;
            y(0, 0.0f, 0);
            if (this.a0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        f fVarT = t();
        int clientWidth = getClientWidth();
        int i3 = this.m;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = fVarT.b;
        float f3 = ((i2 / f2) - fVarT.e) / (fVarT.d + (i3 / f2));
        this.a0 = false;
        y(i5, f3, (int) (i4 * f3));
        if (this.a0) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean D(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.I - f2;
        this.I = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.f203q * clientWidth;
        float f5 = this.r * clientWidth;
        boolean z3 = false;
        f fVar = (f) this.b.get(0);
        ArrayList arrayList = this.b;
        f fVar2 = (f) arrayList.get(arrayList.size() - 1);
        if (fVar.b != 0) {
            f4 = fVar.e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.b != this.e.d() - 1) {
            f5 = fVar2.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.T.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.U.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.I += scrollX - i2;
        scrollTo(i2, getScrollY());
        C(i2);
        return z3;
    }

    private void G(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.b.isEmpty()) {
            if (!this.j.isFinished()) {
                this.j.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        f fVarU = u(this.f);
        int iMin = (int) ((fVarU != null ? Math.min(fVarU.e, this.r) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            g(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void H() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((g) getChildAt(i2).getLayoutParams()).a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void K(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean L() {
        this.M = -1;
        o();
        this.T.onRelease();
        this.U.onRelease();
        return this.T.isFinished() || this.U.isFinished();
    }

    private void M(int i2, boolean z, int i3, boolean z2) {
        f fVarU = u(i2);
        int clientWidth = fVarU != null ? (int) (getClientWidth() * Math.max(this.f203q, Math.min(fVarU.e, this.r))) : 0;
        if (z) {
            T(clientWidth, 0, i3);
            if (z2) {
                k(i2);
                return;
            }
            return;
        }
        if (z2) {
            k(i2);
        }
        g(false);
        scrollTo(clientWidth, 0);
        C(clientWidth);
    }

    private void U() {
        if (this.i0 != 0) {
            ArrayList arrayList = this.j0;
            if (arrayList == null) {
                this.j0 = new ArrayList();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.j0.add(getChildAt(i2));
            }
            Collections.sort(this.j0, p0);
        }
    }

    private void e(f fVar, int i2, f fVar2) {
        int i3;
        int i4;
        f fVar3;
        f fVar4;
        int iD = this.e.d();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.m / clientWidth : 0.0f;
        if (fVar2 != null) {
            int i5 = fVar2.b;
            int i6 = fVar.b;
            if (i5 < i6) {
                float fG = fVar2.e + fVar2.d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= fVar.b && i8 < this.b.size()) {
                    Object obj = this.b.get(i8);
                    while (true) {
                        fVar4 = (f) obj;
                        if (i7 <= fVar4.b || i8 >= this.b.size() - 1) {
                            break;
                        }
                        i8++;
                        obj = this.b.get(i8);
                    }
                    while (i7 < fVar4.b) {
                        fG += this.e.g(i7) + f2;
                        i7++;
                    }
                    fVar4.e = fG;
                    fG += fVar4.d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.b.size() - 1;
                float fG2 = fVar2.e;
                while (true) {
                    i5--;
                    if (i5 < fVar.b || size < 0) {
                        break;
                    }
                    Object obj2 = this.b.get(size);
                    while (true) {
                        fVar3 = (f) obj2;
                        if (i5 >= fVar3.b || size <= 0) {
                            break;
                        }
                        size--;
                        obj2 = this.b.get(size);
                    }
                    while (i5 > fVar3.b) {
                        fG2 -= this.e.g(i5) + f2;
                        i5--;
                    }
                    fG2 -= fVar3.d + f2;
                    fVar3.e = fG2;
                }
            }
        }
        int size2 = this.b.size();
        float fG3 = fVar.e;
        int i9 = fVar.b;
        int i10 = i9 - 1;
        this.f203q = i9 == 0 ? fG3 : -3.4028235E38f;
        int i11 = iD - 1;
        this.r = i9 == i11 ? (fVar.d + fG3) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            f fVar5 = (f) this.b.get(i12);
            while (true) {
                i4 = fVar5.b;
                if (i10 <= i4) {
                    break;
                }
                fG3 -= this.e.g(i10) + f2;
                i10--;
            }
            fG3 -= fVar5.d + f2;
            fVar5.e = fG3;
            if (i4 == 0) {
                this.f203q = fG3;
            }
            i12--;
            i10--;
        }
        float fG4 = fVar.e + fVar.d + f2;
        int i13 = fVar.b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            f fVar6 = (f) this.b.get(i14);
            while (true) {
                i3 = fVar6.b;
                if (i13 >= i3) {
                    break;
                }
                fG4 += this.e.g(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.r = (fVar6.d + fG4) - 1.0f;
            }
            fVar6.e = fG4;
            fG4 += fVar6.d + f2;
            i14++;
            i13++;
        }
        this.W = false;
    }

    private void g(boolean z) {
        boolean z2 = this.l0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.j.isFinished()) {
                this.j.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.j.getCurrX();
                int currY = this.j.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        C(currX);
                    }
                }
            }
        }
        this.w = false;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            f fVar = (f) this.b.get(i2);
            if (fVar.c) {
                fVar.c = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                be3.h0(this, this.k0);
            } else {
                this.k0.run();
            }
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int i(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.Q || Math.abs(i3) <= this.O) {
            i2 += (int) (f2 + (i2 >= this.f ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.b.size() <= 0) {
            return i2;
        }
        f fVar = (f) this.b.get(0);
        ArrayList arrayList = this.b;
        return Math.max(fVar.b, Math.min(i2, ((f) arrayList.get(arrayList.size() - 1)).b));
    }

    private void j(int i2, float f2, int i3) {
        j jVar = this.d0;
        if (jVar != null) {
            jVar.onPageScrolled(i2, f2, i3);
        }
        List list = this.c0;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                j jVar2 = (j) this.c0.get(i4);
                if (jVar2 != null) {
                    jVar2.onPageScrolled(i2, f2, i3);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.onPageScrolled(i2, f2, i3);
        }
    }

    private void k(int i2) {
        j jVar = this.d0;
        if (jVar != null) {
            jVar.onPageSelected(i2);
        }
        List list = this.c0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.c0.get(i3);
                if (jVar2 != null) {
                    jVar2.onPageSelected(i2);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.onPageSelected(i2);
        }
    }

    private void l(int i2) {
        j jVar = this.d0;
        if (jVar != null) {
            jVar.onPageScrollStateChanged(i2);
        }
        List list = this.c0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                j jVar2 = (j) this.c0.get(i3);
                if (jVar2 != null) {
                    jVar2.onPageScrollStateChanged(i2);
                }
            }
        }
        j jVar3 = this.e0;
        if (jVar3 != null) {
            jVar3.onPageScrollStateChanged(i2);
        }
    }

    private void n(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.h0 : 0, null);
        }
    }

    private void o() {
        this.y = false;
        this.z = false;
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.N = null;
        }
    }

    private Rect q(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.v != z) {
            this.v = z;
        }
    }

    private f t() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f3 = clientWidth > 0 ? this.m / clientWidth : 0.0f;
        int i3 = 0;
        boolean z = true;
        f fVar = null;
        int i4 = -1;
        float f4 = 0.0f;
        while (i3 < this.b.size()) {
            f fVar2 = (f) this.b.get(i3);
            if (!z && fVar2.b != (i2 = i4 + 1)) {
                fVar2 = this.c;
                fVar2.e = f2 + f4 + f3;
                fVar2.b = i2;
                fVar2.d = this.e.g(i2);
                i3--;
            }
            f fVar3 = fVar2;
            f2 = fVar3.e;
            float f5 = fVar3.d + f2 + f3;
            if (!z && scrollX < f2) {
                return fVar;
            }
            if (scrollX < f5 || i3 == this.b.size() - 1) {
                return fVar3;
            }
            int i5 = fVar3.b;
            float f6 = fVar3.d;
            i3++;
            z = false;
            i4 = i5;
            f4 = f6;
            fVar = fVar3;
        }
        return fVar;
    }

    private static boolean w(View view) {
        return view.getClass().getAnnotation(e.class) != null;
    }

    private boolean x(float f2, float f3) {
        return (f2 < ((float) this.G) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.G)) && f3 < 0.0f);
    }

    private void z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.M) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.I = motionEvent.getX(i2);
            this.M = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    boolean A() {
        int i2 = this.f;
        if (i2 <= 0) {
            return false;
        }
        N(i2 - 1, true);
        return true;
    }

    boolean B() {
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar == null || this.f >= aVar.d() - 1) {
            return false;
        }
        N(this.f + 1, true);
        return true;
    }

    void E() {
        F(this.f);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00cb A[PHI: r7 r10 r15
      0x00cb: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]
      0x00cb: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:64:0x00ef, B:61:0x00d9, B:53:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    void F(int i2) {
        f fVarU;
        String hexString;
        f fVarA;
        f fVarS;
        f fVar;
        int i3 = this.f;
        if (i3 != i2) {
            fVarU = u(i3);
            this.f = i2;
        } else {
            fVarU = null;
        }
        if (this.e == null) {
            U();
            return;
        }
        if (this.w) {
            U();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.e.r(this);
        int i4 = this.x;
        int iMax = Math.max(0, this.f - i4);
        int iD = this.e.d();
        int iMin = Math.min(iD - 1, this.f + i4);
        if (iD != this.a) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.a + ", found: " + iD + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.e.getClass());
        }
        int i5 = 0;
        while (true) {
            if (i5 < this.b.size()) {
                fVarA = (f) this.b.get(i5);
                int i6 = fVarA.b;
                int i7 = this.f;
                if (i6 >= i7) {
                    if (i6 != i7) {
                        break;
                    } else {
                        break;
                    }
                }
                i5++;
            }
            fVarA = null;
            break;
        }
        if (fVarA == null && iD > 0) {
            fVarA = a(this.f, i5);
        }
        if (fVarA != null) {
            int i8 = i5 - 1;
            f fVar2 = i8 >= 0 ? (f) this.b.get(i8) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - fVarA.d) + (getPaddingLeft() / clientWidth);
            float f2 = 0.0f;
            for (int i9 = this.f - 1; i9 >= 0; i9--) {
                if (f2 < paddingLeft || i9 >= iMax) {
                    if (fVar2 == null || i9 != fVar2.b) {
                        f2 += a(i9, i8 + 1).d;
                        i5++;
                        if (i8 >= 0) {
                            fVar = (f) this.b.get(i8);
                        } else {
                            fVar = null;
                        }
                    } else {
                        f2 += fVar2.d;
                        i8--;
                        if (i8 >= 0) {
                            fVar = (f) this.b.get(i8);
                        } else {
                            fVar = null;
                        }
                    }
                    fVar2 = fVar;
                } else {
                    if (fVar2 == null) {
                        break;
                    }
                    if (i9 == fVar2.b && !fVar2.c) {
                        this.b.remove(i8);
                        this.e.a(this, i9, fVar2.a);
                        i8--;
                        i5--;
                        if (i8 >= 0) {
                            fVar = (f) this.b.get(i8);
                        } else {
                            fVar = null;
                        }
                        fVar2 = fVar;
                    }
                }
            }
            float f3 = fVarA.d;
            int i10 = i5 + 1;
            if (f3 < 2.0f) {
                f fVar3 = i10 < this.b.size() ? (f) this.b.get(i10) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i11 = this.f;
                while (true) {
                    i11++;
                    if (i11 >= iD) {
                        break;
                    }
                    if (f3 >= paddingRight && i11 > iMin) {
                        if (fVar3 == null) {
                            break;
                        }
                        if (i11 == fVar3.b && !fVar3.c) {
                            this.b.remove(i10);
                            this.e.a(this, i11, fVar3.a);
                            if (i10 < this.b.size()) {
                                fVar3 = (f) this.b.get(i10);
                            }
                        }
                    } else if (fVar3 == null || i11 != fVar3.b) {
                        f fVarA2 = a(i11, i10);
                        i10++;
                        f3 += fVarA2.d;
                        fVar3 = i10 < this.b.size() ? (f) this.b.get(i10) : null;
                    } else {
                        f3 += fVar3.d;
                        i10++;
                        if (i10 < this.b.size()) {
                            fVar3 = (f) this.b.get(i10);
                        }
                    }
                }
            }
            e(fVarA, i5, fVarU);
            this.e.o(this, this.f, fVarA.a);
        }
        this.e.c(this);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            g gVar = (g) childAt.getLayoutParams();
            gVar.f = i12;
            if (!gVar.a && gVar.c == 0.0f && (fVarS = s(childAt)) != null) {
                gVar.c = fVarS.d;
                gVar.e = fVarS.b;
            }
        }
        U();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            f fVarR = viewFindFocus != null ? r(viewFindFocus) : null;
            if (fVarR == null || fVarR.b != this.f) {
                for (int i13 = 0; i13 < getChildCount(); i13++) {
                    View childAt2 = getChildAt(i13);
                    f fVarS2 = s(childAt2);
                    if (fVarS2 != null && fVarS2.b == this.f && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    public void I(i iVar) {
        List list = this.f0;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void J(j jVar) {
        List list = this.c0;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public void N(int i2, boolean z) {
        this.w = false;
        O(i2, z, false);
    }

    void O(int i2, boolean z, boolean z2) {
        P(i2, z, z2, 0);
    }

    void P(int i2, boolean z, boolean z2, int i3) {
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar == null || aVar.d() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f == i2 && this.b.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.e.d()) {
            i2 = this.e.d() - 1;
        }
        int i4 = this.x;
        int i5 = this.f;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.b.size(); i6++) {
                ((f) this.b.get(i6)).c = true;
            }
        }
        boolean z3 = this.f != i2;
        if (!this.V) {
            F(i2);
            M(i2, z, i3, z3);
        } else {
            this.f = i2;
            if (z3) {
                k(i2);
            }
            requestLayout();
        }
    }

    j Q(j jVar) {
        j jVar2 = this.e0;
        this.e0 = jVar;
        return jVar2;
    }

    public void R(boolean z, k kVar) {
        S(z, kVar, 2);
    }

    public void S(boolean z, k kVar, int i2) {
        boolean z2 = kVar != null;
        boolean z3 = z2 != (this.g0 != null);
        this.g0 = kVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.i0 = z ? 2 : 1;
            this.h0 = i2;
        } else {
            this.i0 = 0;
        }
        if (z3) {
            E();
        }
    }

    void T(int i2, int i3, int i4) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.j;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.k ? this.j.getCurrX() : this.j.getStartX();
            this.j.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            g(false);
            E();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fM = f3 + (m(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs2 = Math.abs(i4);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i6) / ((f2 * this.e.g(this.f)) + this.m)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, BannerConfig.SCROLL_TIME);
        this.k = false;
        this.j.startScroll(i5, scrollY, i6, i7, iMin);
        be3.g0(this);
    }

    f a(int i2, int i3) {
        f fVar = new f();
        fVar.b = i2;
        fVar.a = this.e.h(this, i2);
        fVar.d = this.e.g(i2);
        if (i3 < 0 || i3 >= this.b.size()) {
            this.b.add(fVar);
        } else {
            this.b.add(i3, fVar);
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i2, int i3) {
        f fVarS;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList arrayList) {
        f fVarS;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        g gVar = (g) layoutParams;
        boolean zW = gVar.a | w(view);
        gVar.a = zW;
        if (!this.u) {
            super.addView(view, i2, layoutParams);
        } else {
            if (zW) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            gVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    public void b(i iVar) {
        if (this.f0 == null) {
            this.f0 = new ArrayList();
        }
        this.f0.add(iVar);
    }

    public void c(j jVar) {
        if (this.c0 == null) {
            this.c0 = new ArrayList();
        }
        this.c0.add(jVar);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.e == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.f203q));
        }
        return i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.r));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.k = true;
        if (this.j.isFinished() || !this.j.computeScrollOffset()) {
            g(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.j.getCurrX();
        int currY = this.j.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!C(currX)) {
                this.j.abortAnimation();
                scrollTo(0, currY);
            }
        }
        be3.g0(this);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00bf  */
    public boolean d(int i2) {
        boolean zA;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
            break;
        }
        if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(viewFindFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    viewFindFocus = null;
                    break;
                }
                if (parent == this) {
                    break;
                }
                parent = parent.getParent();
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i2 == 17 || i2 == 1) {
                zA = A();
            } else if (i2 == 66 || i2 == 2) {
                zA = B();
            } else {
                zA = false;
            }
        } else if (i2 == 17) {
            zA = (viewFindFocus == null || q(this.d, viewFindNextFocus).left < q(this.d, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : A();
        } else if (i2 == 66) {
            zA = (viewFindFocus == null || q(this.d, viewFindNextFocus).left > q(this.d, viewFindFocus).left) ? viewFindNextFocus.requestFocus() : B();
        } else {
            zA = false;
        }
        if (zA) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return zA;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || p(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f fVarS;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.e) != null && aVar.d() > 1)) {
            if (!this.T.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f203q * width);
                this.T.setSize(height, width);
                zDraw = this.T.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.U.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.r + 1.0f)) * width2);
                this.U.setSize(height2, width2);
                zDraw |= this.U.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.T.finish();
            this.U.finish();
        }
        if (zDraw) {
            be3.g0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.n;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    protected boolean f(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && f(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.e;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.i0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((g) ((View) this.j0.get(i3)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.f;
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getPageMargin() {
        return this.m;
    }

    void h() {
        int iD = this.e.d();
        this.a = iD;
        boolean z = this.b.size() < (this.x * 2) + 1 && this.b.size() < iD;
        int iMax = this.f;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.b.size()) {
            f fVar = (f) this.b.get(i2);
            int iE = this.e.e(fVar.a);
            if (iE != -1) {
                if (iE == -2) {
                    this.b.remove(i2);
                    i2--;
                    if (!z2) {
                        this.e.r(this);
                        z2 = true;
                    }
                    this.e.a(this, fVar.b, fVar.a);
                    int i3 = this.f;
                    if (i3 == fVar.b) {
                        iMax = Math.max(0, Math.min(i3, iD - 1));
                    }
                } else {
                    int i4 = fVar.b;
                    if (i4 != iE) {
                        if (i4 == this.f) {
                            iMax = iE;
                        }
                        fVar.b = iE;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.e.c(this);
        }
        Collections.sort(this.b, n0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                g gVar = (g) getChildAt(i5).getLayoutParams();
                if (!gVar.a) {
                    gVar.c = 0.0f;
                }
            }
            O(iMax, false, true);
            requestLayout();
        }
    }

    float m(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.V = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.k0);
        Scroller scroller = this.j;
        if (scroller != null && !scroller.isFinished()) {
            this.j.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        float f2;
        super.onDraw(canvas);
        if (this.m <= 0 || this.n == null || this.b.size() <= 0 || this.e == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f3 = width;
        float f4 = this.m / f3;
        int i3 = 0;
        f fVar = (f) this.b.get(0);
        float f5 = fVar.e;
        int size = this.b.size();
        int i4 = fVar.b;
        int i5 = ((f) this.b.get(size - 1)).b;
        while (i4 < i5) {
            while (true) {
                i2 = fVar.b;
                if (i4 <= i2 || i3 >= size) {
                    break;
                }
                i3++;
                fVar = (f) this.b.get(i3);
            }
            if (i4 == i2) {
                float f6 = fVar.e;
                float f7 = fVar.d;
                f2 = (f6 + f7) * f3;
                f5 = f6 + f7 + f4;
            } else {
                float fG = this.e.g(i4);
                f2 = (f5 + fG) * f3;
                f5 += fG + f4;
            }
            if (this.m + f2 > scrollX) {
                this.n.setBounds(Math.round(f2), this.o, Math.round(this.m + f2), this.p);
                this.n.draw(canvas);
            }
            if (f2 > scrollX + width) {
                return;
            }
            i4++;
            f4 = f4;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            L();
            return false;
        }
        if (action != 0) {
            if (this.y) {
                return true;
            }
            if (this.z) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.K = x;
            this.I = x;
            float y = motionEvent.getY();
            this.L = y;
            this.J = y;
            this.M = motionEvent.getPointerId(0);
            this.z = false;
            this.k = true;
            this.j.computeScrollOffset();
            if (this.l0 != 2 || Math.abs(this.j.getFinalX() - this.j.getCurrX()) <= this.R) {
                g(false);
                this.y = false;
            } else {
                this.j.abortAnimation();
                this.w = false;
                E();
                this.y = true;
                K(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.M;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.I;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.L);
                if (f2 != 0.0f && !x(this.I, f2) && f(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.I = x2;
                    this.J = y2;
                    this.z = true;
                    return false;
                }
                int i3 = this.H;
                if (fAbs > i3 && fAbs * 0.5f > fAbs2) {
                    this.y = true;
                    K(true);
                    setScrollState(1);
                    float f3 = this.K;
                    float f4 = this.H;
                    this.I = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.J = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.z = true;
                }
                if (this.y && D(x2)) {
                    be3.g0(this);
                }
            }
        } else if (action == 6) {
            z(motionEvent);
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        return this.y;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    /* JADX WARN: Code duplicated, block: B:24:0x0076  */
    /* JADX WARN: Code duplicated, block: B:26:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        f fVarS;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a) {
                    int i10 = gVar.b;
                    int i11 = i10 & 7;
                    int i12 = i10 & 112;
                    if (i11 != 1) {
                        if (i11 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i11 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i6 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i12 != 16) {
                            if (i12 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i12 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i7 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i13 = paddingLeft + scrollX;
                            childAt.layout(i13, paddingTop, childAt.getMeasuredWidth() + i13, paddingTop + childAt.getMeasuredHeight());
                            i8++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        } else {
                            iMax2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i14 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i14;
                        int i15 = paddingLeft + scrollX;
                        childAt.layout(i15, paddingTop, childAt.getMeasuredWidth() + i15, paddingTop + childAt.getMeasuredHeight());
                        i8++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax = Math.max((i6 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i16 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i16;
                    if (i12 != 16) {
                        if (i12 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i12 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i7 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i17 = paddingLeft + scrollX;
                        childAt.layout(i17, paddingTop, childAt.getMeasuredWidth() + i17, paddingTop + childAt.getMeasuredHeight());
                        i8++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    } else {
                        iMax2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i18 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i18;
                    int i19 = paddingLeft + scrollX;
                    childAt.layout(i19, paddingTop, childAt.getMeasuredWidth() + i19, paddingTop + childAt.getMeasuredHeight());
                    i8++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i20 = (i6 - paddingLeft) - paddingRight;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                g gVar2 = (g) childAt2.getLayoutParams();
                if (!gVar2.a && (fVarS = s(childAt2)) != null) {
                    float f2 = i20;
                    int i22 = ((int) (fVarS.e * f2)) + paddingLeft;
                    if (gVar2.d) {
                        gVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * gVar2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i7 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i22, paddingTop, childAt2.getMeasuredWidth() + i22, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.o = paddingTop;
        this.p = i7 - paddingBottom;
        this.b0 = i8;
        if (this.V) {
            z2 = false;
            M(this.f, false, 0, false);
        } else {
            z2 = false;
        }
        this.V = z2;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        g gVar;
        g gVar2;
        int i4;
        setMeasuredDimension(View.getDefaultSize(0, i2), View.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.G = Math.min(measuredWidth / 10, this.F);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z = true;
            int i6 = 1073741824;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8 && (gVar2 = (g) childAt.getLayoutParams()) != null && gVar2.a) {
                int i7 = gVar2.b;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                boolean z2 = i9 == 48 || i9 == 80;
                if (i8 != 3 && i8 != 5) {
                    z = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z2) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i4 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i11 = ((ViewGroup.LayoutParams) gVar2).width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = ((ViewGroup.LayoutParams) gVar2).height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z2) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        this.s = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.t = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.u = true;
        E();
        this.u = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((gVar = (g) childAt2.getLayoutParams()) == null || !gVar.a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * gVar.c), 1073741824), this.t);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        f fVarS;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i3 = 0;
            i5 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
            i5 = -1;
        }
        while (i3 != i4) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (fVarS = s(childAt)) != null && fVarS.b == this.f && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i5;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar != null) {
            aVar.l(savedState.b, savedState.c);
            O(savedState.a, false, true);
        } else {
            this.g = savedState.a;
            this.h = savedState.b;
            this.i = savedState.c;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f;
        androidx.viewpager.widget.a aVar = this.e;
        if (aVar != null) {
            savedState.b = aVar.m();
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.m;
            G(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00dc  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        if (this.S) {
            return true;
        }
        boolean zL = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.e) == null || aVar.d() == 0) {
            return false;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.j.abortAnimation();
            this.w = false;
            E();
            float x = motionEvent.getX();
            this.K = x;
            this.I = x;
            float y = motionEvent.getY();
            this.L = y;
            this.J = y;
            this.M = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.I = motionEvent.getX(actionIndex);
                        this.M = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        z(motionEvent);
                        this.I = motionEvent.getX(motionEvent.findPointerIndex(this.M));
                    }
                } else if (this.y) {
                    M(this.f, true, 0, false);
                    zL = L();
                }
            } else if (!this.y) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.M);
                if (iFindPointerIndex == -1) {
                    zL = L();
                } else {
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float fAbs = Math.abs(x2 - this.I);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y2 - this.J);
                    if (fAbs > this.H && fAbs > fAbs2) {
                        this.y = true;
                        K(true);
                        float f2 = this.K;
                        this.I = x2 - f2 > 0.0f ? f2 + this.H : f2 - this.H;
                        this.J = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.y) {
                        zL = D(motionEvent.getX(motionEvent.findPointerIndex(this.M)));
                    }
                }
            } else if (this.y) {
                zL = D(motionEvent.getX(motionEvent.findPointerIndex(this.M)));
            }
        } else if (this.y) {
            VelocityTracker velocityTracker = this.N;
            velocityTracker.computeCurrentVelocity(1000, this.P);
            int xVelocity = (int) velocityTracker.getXVelocity(this.M);
            this.w = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f fVarT = t();
            float f3 = clientWidth;
            P(i(fVarT.b, ((scrollX / f3) - fVarT.e) / (fVarT.d + (this.m / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.M)) - this.K)), true, true, xVelocity);
            zL = L();
        }
        if (zL) {
            be3.g0(this);
        }
        return true;
    }

    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? A() : d(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? B() : d(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return d(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return d(1);
                }
            }
        }
        return false;
    }

    f r(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return s(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.u) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    f s(View view) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            f fVar = (f) this.b.get(i2);
            if (this.e.i(view, fVar.a)) {
                return fVar;
            }
        }
        return null;
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.p(null);
            this.e.r(this);
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                f fVar = (f) this.b.get(i2);
                this.e.a(this, fVar.b, fVar.a);
            }
            this.e.c(this);
            this.b.clear();
            H();
            this.f = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.e;
        this.e = aVar;
        this.a = 0;
        if (aVar != null) {
            if (this.l == null) {
                this.l = new l();
            }
            this.e.p(this.l);
            this.w = false;
            boolean z = this.V;
            this.V = true;
            this.a = this.e.d();
            if (this.g >= 0) {
                this.e.l(this.h, this.i);
                O(this.g, false, true);
                this.g = -1;
                this.h = null;
                this.i = null;
            } else if (z) {
                requestLayout();
            } else {
                E();
            }
        }
        List list = this.f0;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.f0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((i) this.f0.get(i3)).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.w = false;
        O(i2, !this.V, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.x) {
            this.x = i2;
            E();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(j jVar) {
        this.d0 = jVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.m;
        this.m = i2;
        int width = getWidth();
        G(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.n = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i2) {
        if (this.l0 == i2) {
            return;
        }
        this.l0 = i2;
        if (this.g0 != null) {
            n(i2 != 0);
        }
        l(i2);
    }

    f u(int i2) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            f fVar = (f) this.b.get(i3);
            if (fVar.b == i2) {
                return fVar;
            }
        }
        return null;
    }

    void v() {
        setWillNotDraw(false);
        setDescendantFocusability(Opcodes.ASM4);
        setFocusable(true);
        Context context = getContext();
        this.j = new Scroller(context, o0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.H = viewConfiguration.getScaledPagingTouchSlop();
        this.O = (int) (400.0f * f2);
        this.P = viewConfiguration.getScaledMaximumFlingVelocity();
        this.T = new EdgeEffect(context);
        this.U = new EdgeEffect(context);
        this.Q = (int) (25.0f * f2);
        this.R = (int) (2.0f * f2);
        this.F = (int) (f2 * 16.0f);
        be3.p0(this, new h());
        if (be3.y(this) == 0) {
            be3.z0(this, 1);
        }
        be3.E0(this, new d());
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.n;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    protected void y(int i2, float f2, int i3) {
        int iMax;
        int width;
        int left;
        if (this.b0 > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a) {
                    int i5 = gVar.b & 7;
                    if (i5 != 1) {
                        if (i5 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i5 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    } else {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i6 = iMax;
                    width = paddingLeft;
                    paddingLeft = i6;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        j(i2, f2, i3);
        if (this.g0 != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt2 = getChildAt(i7);
                if (!((g) childAt2.getLayoutParams()).a) {
                    this.g0.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.a0 = true;
    }

    public static class g extends ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c;
        boolean d;
        int e;
        int f;

        public g() {
            super(-1, -1);
            this.c = 0.0f;
        }

        public g(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.c = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.m0);
            this.b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(q30.e(getContext(), i2));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        this.c = new f();
        this.d = new Rect();
        this.g = -1;
        this.h = null;
        this.i = null;
        this.f203q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.x = 1;
        this.M = -1;
        this.V = true;
        this.W = false;
        this.k0 = new c();
        this.l0 = 0;
        v();
    }
}
