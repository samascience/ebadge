package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ef3 extends zg {
    private static boolean f;
    private static int g = R$id.glide_custom_view_target_tag;
    protected final View a;
    private final a b;
    private View.OnAttachStateChangeListener c;
    private boolean d;
    private boolean e;

    static final class a {
        static Integer e;
        private final View a;
        private final List b = new ArrayList();
        boolean c;
        private ViewTreeObserverOnPreDrawListenerC0127a d;

        /* JADX INFO: renamed from: ef3$a$a, reason: collision with other inner class name */
        private static final class ViewTreeObserverOnPreDrawListenerC0127a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference a;

            ViewTreeObserverOnPreDrawListenerC0127a(a aVar) {
                this.a = new WeakReference(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.a = view;
        }

        private static int c(Context context) {
            if (e == null) {
                Display defaultDisplay = ((WindowManager) z42.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }

        private int e(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.a.getContext());
        }

        private int f() {
            int paddingTop = this.a.getPaddingTop() + this.a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.a.getPaddingLeft() + this.a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return e(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private boolean i(int i, int i2) {
            return h(i) && h(i2);
        }

        private void j(int i, int i2) {
            Iterator it = new ArrayList(this.b).iterator();
            while (it.hasNext()) {
                ((hr2) it.next()).d(i, i2);
            }
        }

        void a() {
            if (this.b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                j(iG, iF);
                b();
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        void d(hr2 hr2Var) {
            int iG = g();
            int iF = f();
            if (i(iG, iF)) {
                hr2Var.d(iG, iF);
                return;
            }
            if (!this.b.contains(hr2Var)) {
                this.b.add(hr2Var);
            }
            if (this.d == null) {
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0127a viewTreeObserverOnPreDrawListenerC0127a = new ViewTreeObserverOnPreDrawListenerC0127a(this);
                this.d = viewTreeObserverOnPreDrawListenerC0127a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0127a);
            }
        }

        void k(hr2 hr2Var) {
            this.b.remove(hr2Var);
        }
    }

    public ef3(View view) {
        this.a = (View) z42.d(view);
        this.b = new a(view);
    }

    private Object i() {
        return this.a.getTag(g);
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener == null || this.e) {
            return;
        }
        this.a.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.e = true;
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
        if (onAttachStateChangeListener == null || !this.e) {
            return;
        }
        this.a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.e = false;
    }

    private void l(Object obj) {
        f = true;
        this.a.setTag(g, obj);
    }

    @Override // defpackage.j03
    public void a(hr2 hr2Var) {
        this.b.d(hr2Var);
    }

    @Override // defpackage.j03
    public void c(ef2 ef2Var) {
        l(ef2Var);
    }

    @Override // defpackage.j03
    public void d(hr2 hr2Var) {
        this.b.k(hr2Var);
    }

    @Override // defpackage.zg, defpackage.j03
    public void f(Drawable drawable) {
        super.f(drawable);
        j();
    }

    @Override // defpackage.j03
    public ef2 g() {
        Object objI = i();
        if (objI == null) {
            return null;
        }
        if (objI instanceof ef2) {
            return (ef2) objI;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // defpackage.zg, defpackage.j03
    public void h(Drawable drawable) {
        super.h(drawable);
        this.b.b();
        if (this.d) {
            return;
        }
        k();
    }

    public String toString() {
        return "Target for: " + this.a;
    }
}
