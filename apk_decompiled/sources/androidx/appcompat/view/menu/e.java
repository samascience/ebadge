package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import defpackage.ee3;
import defpackage.lw2;
import defpackage.q30;
import defpackage.v2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements lw2 {
    private static final int[] A = {1, 4, 5, 3, 2, 0};
    private final Context a;
    private final Resources b;
    private boolean c;
    private boolean d;
    private a e;
    private ContextMenu.ContextMenuInfo m;
    CharSequence n;
    Drawable o;
    View p;
    private g x;
    private boolean z;
    private int l = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f132q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList v = new ArrayList();
    private CopyOnWriteArrayList w = new CopyOnWriteArrayList();
    private boolean y = false;
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private boolean h = true;
    private ArrayList i = new ArrayList();
    private ArrayList j = new ArrayList();
    private boolean k = true;

    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.a = context;
        this.b = context.getResources();
        g0(true);
    }

    private static int D(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = A;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void Q(int i, boolean z) {
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        this.f.remove(i);
        if (z) {
            N(true);
        }
    }

    private void b0(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesE = E();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i > 0) {
                this.n = resourcesE.getText(i);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i2 > 0) {
                this.o = q30.e(w(), i2);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        N(false);
    }

    private g g(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new g(this, i, i2, i3, i4, charSequence, i5);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    private void g0(boolean z) {
        boolean z2;
        if (z) {
            z2 = this.b.getConfiguration().keyboard != 1 && ee3.j(ViewConfiguration.get(this.a), this.a);
        }
        this.d = z2;
    }

    private void i(boolean z) {
        if (this.w.isEmpty()) {
            return;
        }
        i0();
        for (WeakReference weakReference : this.w) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                jVar.d(z);
            }
        }
        h0();
    }

    private void j(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || this.w.isEmpty()) {
            return;
        }
        for (WeakReference weakReference : this.w) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                int id = jVar.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    jVar.j(parcelable);
                }
            }
        }
    }

    private void k(Bundle bundle) {
        Parcelable parcelableM;
        if (this.w.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : this.w) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                int id = jVar.getId();
                if (id > 0 && (parcelableM = jVar.m()) != null) {
                    sparseArray.put(id, parcelableM);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(m mVar, j jVar) {
        if (this.w.isEmpty()) {
            return false;
        }
        boolean zL = jVar != null ? jVar.l(mVar) : false;
        for (WeakReference weakReference : this.w) {
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null) {
                this.w.remove(weakReference);
            } else if (!zL) {
                zL = jVar2.l(mVar);
            }
        }
        return zL;
    }

    private static int p(ArrayList arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((g) arrayList.get(size)).f() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public View A() {
        return this.p;
    }

    public ArrayList B() {
        t();
        return this.j;
    }

    boolean C() {
        return this.t;
    }

    Resources E() {
        return this.b;
    }

    public e F() {
        return this;
    }

    public ArrayList G() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.f.get(i);
            if (gVar.isVisible()) {
                this.g.add(gVar);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean H() {
        return !this.f132q;
    }

    public boolean I() {
        return this.y;
    }

    boolean J() {
        return this.c;
    }

    public boolean K() {
        return this.d;
    }

    void L(g gVar) {
        this.k = true;
        N(true);
    }

    void M(g gVar) {
        this.h = true;
        N(true);
    }

    public void N(boolean z) {
        if (this.f132q) {
            this.r = true;
            if (z) {
                this.s = true;
                return;
            }
            return;
        }
        if (z) {
            this.h = true;
            this.k = true;
        }
        i(z);
    }

    public boolean O(MenuItem menuItem, int i) {
        return P(menuItem, null, i);
    }

    public boolean P(MenuItem menuItem, j jVar, int i) {
        g gVar = (g) menuItem;
        if (gVar == null || !gVar.isEnabled()) {
            return false;
        }
        boolean zK = gVar.k();
        v2 v2VarB = gVar.b();
        boolean z = v2VarB != null && v2VarB.a();
        if (gVar.j()) {
            zK |= gVar.expandActionView();
            if (zK) {
                e(true);
            }
        } else if (gVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                e(false);
            }
            if (!gVar.hasSubMenu()) {
                gVar.x(new m(w(), this, gVar));
            }
            m mVar = (m) gVar.getSubMenu();
            if (z) {
                v2VarB.e(mVar);
            }
            zK |= l(mVar, jVar);
            if (!zK) {
                e(true);
            }
        } else if ((i & 1) == 0) {
            e(true);
        }
        return zK;
    }

    public void R(j jVar) {
        for (WeakReference weakReference : this.w) {
            j jVar2 = (j) weakReference.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.w.remove(weakReference);
            }
        }
    }

    public void S(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(v());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).S(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public void T(Bundle bundle) {
        j(bundle);
    }

    public void U(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).U(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    public void V(Bundle bundle) {
        k(bundle);
    }

    public void W(a aVar) {
        this.e = aVar;
    }

    public e X(int i) {
        this.l = i;
        return this;
    }

    void Y(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f.size();
        i0();
        for (int i = 0; i < size; i++) {
            g gVar = (g) this.f.get(i);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        h0();
    }

    protected e Z(int i) {
        b0(0, null, i, null, null);
        return this;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int iD = D(i3);
        g gVarG = g(i, i2, i3, iD, charSequence, this.l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
        if (contextMenuInfo != null) {
            gVarG.v(contextMenuInfo);
        }
        ArrayList arrayList = this.f;
        arrayList.add(p(arrayList, iD), gVarG);
        N(true);
        return gVarG;
    }

    protected e a0(Drawable drawable) {
        b0(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.a);
    }

    public void c(j jVar, Context context) {
        this.w.add(new WeakReference(jVar));
        jVar.i(context, this);
        this.k = true;
    }

    protected e c0(int i) {
        b0(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.x;
        if (gVar != null) {
            f(gVar);
        }
        this.f.clear();
        N(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        N(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    protected e d0(CharSequence charSequence) {
        b0(0, charSequence, 0, null, null);
        return this;
    }

    public final void e(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        for (WeakReference weakReference : this.w) {
            j jVar = (j) weakReference.get();
            if (jVar == null) {
                this.w.remove(weakReference);
            } else {
                jVar.c(this, z);
            }
        }
        this.u = false;
    }

    protected e e0(View view) {
        b0(0, null, 0, null, view);
        return this;
    }

    public boolean f(g gVar) {
        boolean zF = false;
        if (!this.w.isEmpty() && this.x == gVar) {
            i0();
            for (WeakReference weakReference : this.w) {
                j jVar = (j) weakReference.get();
                if (jVar != null) {
                    zF = jVar.f(this, gVar);
                    if (zF) {
                        break;
                    }
                } else {
                    this.w.remove(weakReference);
                }
            }
            h0();
            if (zF) {
                this.x = null;
            }
        }
        return zF;
    }

    public void f0(boolean z) {
        this.z = z;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getItemId() == i) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (menuItemFindItem = gVar.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return (MenuItem) this.f.get(i);
    }

    boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    public void h0() {
        this.f132q = false;
        if (this.r) {
            this.r = false;
            N(this.s);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((g) this.f.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i0() {
        if (this.f132q) {
            return;
        }
        this.f132q = true;
        this.r = false;
        this.s = false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return r(i, keyEvent) != null;
    }

    public boolean m(g gVar) {
        boolean zG = false;
        if (this.w.isEmpty()) {
            return false;
        }
        i0();
        for (WeakReference weakReference : this.w) {
            j jVar = (j) weakReference.get();
            if (jVar != null) {
                zG = jVar.g(this, gVar);
                if (zG) {
                    break;
                }
            } else {
                this.w.remove(weakReference);
            }
        }
        h0();
        if (zG) {
            this.x = gVar;
        }
        return zG;
    }

    public int n(int i) {
        return o(i, 0);
    }

    public int o(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (((g) this.f.get(i2)).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return O(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        g gVarR = r(i, keyEvent);
        boolean zO = gVarR != null ? O(gVarR, i2) : false;
        if ((i2 & 2) != 0) {
            e(true);
        }
        return zO;
    }

    public int q(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((g) this.f.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    g r(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.v;
        arrayList.clear();
        s(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (g) arrayList.get(0);
        }
        boolean zJ = J();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) arrayList.get(i2);
            char alphabeticShortcut = zJ ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (zJ && alphabeticShortcut == '\b' && i == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iN = n(i);
        if (iN >= 0) {
            int size = this.f.size() - iN;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((g) this.f.get(iN)).getGroupId() != i) {
                    break;
                }
                Q(iN, false);
                i2 = i3;
            }
            N(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        Q(q(i), true);
    }

    void s(List list, int i, KeyEvent keyEvent) {
        boolean zJ = J();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                g gVar = (g) this.f.get(i2);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).s(list, i, keyEvent);
                }
                char alphabeticShortcut = zJ ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if ((modifiers & 69647) == ((zJ ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (zJ && alphabeticShortcut == '\b' && i == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i) {
                gVar.t(z2);
                gVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i) {
                gVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = (g) this.f.get(i2);
            if (gVar.getGroupId() == i && gVar.y(z)) {
                z2 = true;
            }
        }
        if (z2) {
            N(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.c = z;
        N(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f.size();
    }

    public void t() {
        ArrayList arrayListG = G();
        if (this.k) {
            boolean zE = false;
            for (WeakReference weakReference : this.w) {
                j jVar = (j) weakReference.get();
                if (jVar == null) {
                    this.w.remove(weakReference);
                } else {
                    zE |= jVar.e();
                }
            }
            if (zE) {
                this.i.clear();
                this.j.clear();
                int size = arrayListG.size();
                for (int i = 0; i < size; i++) {
                    g gVar = (g) arrayListG.get(i);
                    if (gVar.l()) {
                        this.i.add(gVar);
                    } else {
                        this.j.add(gVar);
                    }
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(G());
            }
            this.k = false;
        }
    }

    public ArrayList u() {
        t();
        return this.i;
    }

    protected String v() {
        return "android:menu:actionviewstates";
    }

    public Context w() {
        return this.a;
    }

    public g x() {
        return this.x;
    }

    public Drawable y() {
        return this.o;
    }

    public CharSequence z() {
        return this.n;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        g gVar = (g) a(i, i2, i3, charSequence);
        m mVar = new m(this.a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.b.getString(i4));
    }
}
