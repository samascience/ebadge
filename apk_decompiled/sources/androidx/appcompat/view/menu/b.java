package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;
import defpackage.iv0;
import defpackage.qi1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class b extends h implements j, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int G = R$layout.abc_cascading_menu_item_layout;
    boolean F;
    private final Context b;
    private final int c;
    private final int d;
    private final int e;
    private final boolean f;
    final Handler g;
    private View o;
    View p;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean w;
    private j.a x;
    ViewTreeObserver y;
    private PopupWindow.OnDismissListener z;
    private final List h = new ArrayList();
    final List i = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener j = new a();
    private final View.OnAttachStateChangeListener k = new ViewOnAttachStateChangeListenerC0004b();
    private final qi1 l = new c();
    private int m = 0;
    private int n = 0;
    private boolean v = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f131q = F();

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!b.this.a() || b.this.i.size() <= 0 || ((d) b.this.i.get(0)).a.B()) {
                return;
            }
            View view = b.this.p;
            if (view == null || !view.isShown()) {
                b.this.dismiss();
                return;
            }
            Iterator it = b.this.i.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a.b();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.appcompat.view.menu.b$b, reason: collision with other inner class name */
    class ViewOnAttachStateChangeListenerC0004b implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0004b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.y.removeGlobalOnLayoutListener(bVar.j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    class c implements qi1 {

        class a implements Runnable {
            final /* synthetic */ d a;
            final /* synthetic */ MenuItem b;
            final /* synthetic */ e c;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.a = dVar;
                this.b = menuItem;
                this.c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.a;
                if (dVar != null) {
                    b.this.F = true;
                    dVar.b.e(false);
                    b.this.F = false;
                }
                if (this.b.isEnabled() && this.b.hasSubMenu()) {
                    this.c.O(this.b, 4);
                }
            }
        }

        c() {
        }

        @Override // defpackage.qi1
        public void e(e eVar, MenuItem menuItem) {
            b.this.g.removeCallbacksAndMessages(null);
            int size = b.this.i.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (eVar == ((d) b.this.i.get(i)).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            b.this.g.postAtTime(new a(i2 < b.this.i.size() ? (d) b.this.i.get(i2) : null, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // defpackage.qi1
        public void h(e eVar, MenuItem menuItem) {
            b.this.g.removeCallbacksAndMessages(eVar);
        }
    }

    private static class d {
        public final MenuPopupWindow a;
        public final e b;
        public final int c;

        public d(MenuPopupWindow menuPopupWindow, e eVar, int i) {
            this.a = menuPopupWindow;
            this.b = eVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.k();
        }
    }

    public b(Context context, View view, int i, int i2, boolean z) {
        this.b = context;
        this.o = view;
        this.d = i;
        this.e = i2;
        this.f = z;
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.g = new Handler();
    }

    private MenuPopupWindow B() {
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.b, null, this.d, this.e);
        menuPopupWindow.U(this.l);
        menuPopupWindow.L(this);
        menuPopupWindow.K(this);
        menuPopupWindow.D(this.o);
        menuPopupWindow.G(this.n);
        menuPopupWindow.J(true);
        menuPopupWindow.I(2);
        return menuPopupWindow;
    }

    private int C(e eVar) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            if (eVar == ((d) this.i.get(i)).b) {
                return i;
            }
        }
        return -1;
    }

    private MenuItem D(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = eVar.getItem(i);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View E(d dVar, e eVar) {
        androidx.appcompat.view.menu.d dVar2;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemD = D(dVar.b, eVar);
        if (menuItemD == null) {
            return null;
        }
        ListView listViewA = dVar.a();
        ListAdapter adapter = listViewA.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            headersCount = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemD == dVar2.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewA.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewA.getChildCount()) {
            return listViewA.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int F() {
        return this.o.getLayoutDirection() == 1 ? 0 : 1;
    }

    private int G(int i) {
        List list = this.i;
        ListView listViewA = ((d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        listViewA.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.p.getWindowVisibleDisplayFrame(rect);
        if (this.f131q == 1) {
            return (iArr[0] + listViewA.getWidth()) + i > rect.right ? 0 : 1;
        }
        return iArr[0] - i < 0 ? 1 : 0;
    }

    private void H(e eVar) {
        d dVar;
        View viewE;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.b);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, layoutInflaterFrom, this.f, G);
        if (!a() && this.v) {
            dVar2.d(true);
        } else if (a()) {
            dVar2.d(h.z(eVar));
        }
        int iQ = h.q(dVar2, null, this.b, this.c);
        MenuPopupWindow menuPopupWindowB = B();
        menuPopupWindowB.p(dVar2);
        menuPopupWindowB.F(iQ);
        menuPopupWindowB.G(this.n);
        if (this.i.size() > 0) {
            List list = this.i;
            dVar = (d) list.get(list.size() - 1);
            viewE = E(dVar, eVar);
        } else {
            dVar = null;
            viewE = null;
        }
        if (viewE != null) {
            menuPopupWindowB.V(false);
            menuPopupWindowB.S(null);
            int iG = G(iQ);
            boolean z = iG == 1;
            this.f131q = iG;
            menuPopupWindowB.D(viewE);
            if ((this.n & 5) != 5) {
                iQ = z ? viewE.getWidth() : 0 - iQ;
            } else if (!z) {
                iQ = 0 - viewE.getWidth();
            }
            menuPopupWindowB.f(iQ);
            menuPopupWindowB.N(true);
            menuPopupWindowB.l(0);
        } else {
            if (this.r) {
                menuPopupWindowB.f(this.t);
            }
            if (this.s) {
                menuPopupWindowB.l(this.u);
            }
            menuPopupWindowB.H(p());
        }
        this.i.add(new d(menuPopupWindowB, eVar, this.f131q));
        menuPopupWindowB.b();
        ListView listViewK = menuPopupWindowB.k();
        listViewK.setOnKeyListener(this);
        if (dVar == null && this.w && eVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) listViewK, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(eVar.z());
            listViewK.addHeaderView(frameLayout, null, false);
            menuPopupWindowB.b();
        }
    }

    @Override // defpackage.qo2
    public boolean a() {
        return this.i.size() > 0 && ((d) this.i.get(0)).a.a();
    }

    @Override // defpackage.qo2
    public void b() {
        if (a()) {
            return;
        }
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            H((e) it.next());
        }
        this.h.clear();
        View view = this.o;
        this.p = view;
        if (view != null) {
            boolean z = this.y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.y = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.j);
            }
            this.p.addOnAttachStateChangeListener(this.k);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z) {
        int iC = C(eVar);
        if (iC < 0) {
            return;
        }
        int i = iC + 1;
        if (i < this.i.size()) {
            ((d) this.i.get(i)).b.e(false);
        }
        d dVar = (d) this.i.remove(iC);
        dVar.b.R(this);
        if (this.F) {
            dVar.a.T(null);
            dVar.a.E(0);
        }
        dVar.a.dismiss();
        int size = this.i.size();
        if (size > 0) {
            this.f131q = ((d) this.i.get(size - 1)).c;
        } else {
            this.f131q = F();
        }
        if (size != 0) {
            if (z) {
                ((d) this.i.get(0)).b.e(false);
                return;
            }
            return;
        }
        dismiss();
        j.a aVar = this.x;
        if (aVar != null) {
            aVar.c(eVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.y.removeGlobalOnLayoutListener(this.j);
            }
            this.y = null;
        }
        this.p.removeOnAttachStateChangeListener(this.k);
        this.z.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z) {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            h.A(((d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // defpackage.qo2
    public void dismiss() {
        int size = this.i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.i.toArray(new d[size]);
            for (int i = size - 1; i >= 0; i--) {
                d dVar = dVarArr[i];
                if (dVar.a.a()) {
                    dVar.a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.x = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
    }

    @Override // defpackage.qo2
    public ListView k() {
        if (this.i.isEmpty()) {
            return null;
        }
        List list = this.i;
        return ((d) list.get(list.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        for (d dVar : this.i) {
            if (mVar == dVar.b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        n(mVar);
        j.a aVar = this.x;
        if (aVar != null) {
            aVar.d(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.h
    public void n(e eVar) {
        eVar.c(this, this.b);
        if (a()) {
            H(eVar);
        } else {
            this.h.add(eVar);
        }
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean o() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.i.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                dVar = null;
                break;
            }
            dVar = (d) this.i.get(i);
            if (!dVar.a.a()) {
                break;
            } else {
                i++;
            }
        }
        if (dVar != null) {
            dVar.b.e(false);
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
        if (this.o != view) {
            this.o = view;
            this.n = iv0.b(this.m, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(int i) {
        if (this.m != i) {
            this.m = i;
            this.n = iv0.b(i, this.o.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(int i) {
        this.r = true;
        this.t = i;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void x(boolean z) {
        this.w = z;
    }

    @Override // androidx.appcompat.view.menu.h
    public void y(int i) {
        this.s = true;
        this.u = i;
    }
}
