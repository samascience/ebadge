package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;

/* JADX INFO: loaded from: classes.dex */
final class l extends h implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, j, View.OnKeyListener {
    private static final int v = R$layout.abc_popup_menu_item_layout;
    private final Context b;
    private final e c;
    private final d d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;
    final MenuPopupWindow i;
    private PopupWindow.OnDismissListener l;
    private View m;
    View n;
    private j.a o;
    ViewTreeObserver p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f134q;
    private boolean r;
    private int s;
    private boolean u;
    final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    private final View.OnAttachStateChangeListener k = new b();
    private int t = 0;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!l.this.a() || l.this.i.B()) {
                return;
            }
            View view = l.this.n;
            if (view == null || !view.isShown()) {
                l.this.dismiss();
            } else {
                l.this.i.b();
            }
        }
    }

    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.p = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.p.removeGlobalOnLayoutListener(lVar.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i, int i2, boolean z) {
        this.b = context;
        this.c = eVar;
        this.e = z;
        this.d = new d(eVar, LayoutInflater.from(context), z, v);
        this.g = i;
        this.h = i2;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.m = view;
        this.i = new MenuPopupWindow(context, null, i, i2);
        eVar.c(this, context);
    }

    private boolean B() {
        View view;
        if (a()) {
            return true;
        }
        if (this.f134q || (view = this.m) == null) {
            return false;
        }
        this.n = view;
        this.i.K(this);
        this.i.L(this);
        this.i.J(true);
        View view2 = this.n;
        boolean z = this.p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.p = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.j);
        }
        view2.addOnAttachStateChangeListener(this.k);
        this.i.D(view2);
        this.i.G(this.t);
        if (!this.r) {
            this.s = h.q(this.d, null, this.b, this.f);
            this.r = true;
        }
        this.i.F(this.s);
        this.i.I(2);
        this.i.H(p());
        this.i.b();
        ListView listViewK = this.i.k();
        listViewK.setOnKeyListener(this);
        if (this.u && this.c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.c.z());
            }
            frameLayout.setEnabled(false);
            listViewK.addHeaderView(frameLayout, null, false);
        }
        this.i.p(this.d);
        this.i.b();
        return true;
    }

    @Override // defpackage.qo2
    public boolean a() {
        return !this.f134q && this.i.a();
    }

    @Override // defpackage.qo2
    public void b() {
        if (!B()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z) {
        if (eVar != this.c) {
            return;
        }
        dismiss();
        j.a aVar = this.o;
        if (aVar != null) {
            aVar.c(eVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z) {
        this.r = false;
        d dVar = this.d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // defpackage.qo2
    public void dismiss() {
        if (a()) {
            this.i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.o = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
    }

    @Override // defpackage.qo2
    public ListView k() {
        return this.i.k();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.b, mVar, this.n, this.e, this.g, this.h);
            iVar.j(this.o);
            iVar.g(h.z(mVar));
            iVar.i(this.l);
            this.l = null;
            this.c.e(false);
            int iD = this.i.d();
            int iO = this.i.o();
            if ((Gravity.getAbsoluteGravity(this.t, this.m.getLayoutDirection()) & 7) == 5) {
                iD += this.m.getWidth();
            }
            if (iVar.n(iD, iO)) {
                j.a aVar = this.o;
                if (aVar == null) {
                    return true;
                }
                aVar.d(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.h
    public void n(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f134q = true;
        this.c.close();
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(View view) {
        this.m = view;
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(boolean z) {
        this.d.d(z);
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(int i) {
        this.t = i;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(int i) {
        this.i.f(i);
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void x(boolean z) {
        this.u = z;
    }

    @Override // androidx.appcompat.view.menu.h
    public void y(int i) {
        this.i.l(i);
    }
}
