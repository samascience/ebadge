package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import defpackage.be3;
import defpackage.j23;
import defpackage.m2;
import defpackage.t1;
import defpackage.zi3;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class b implements androidx.appcompat.view.menu.j {
    private int F;
    int G;
    private NavigationMenuView a;
    LinearLayout b;
    private androidx.appcompat.view.menu.j.a c;
    androidx.appcompat.view.menu.e d;
    private int e;
    c f;
    LayoutInflater g;
    ColorStateList i;
    ColorStateList l;
    ColorStateList m;
    Drawable n;
    RippleDrawable o;
    int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f263q;
    int r;
    int s;
    int t;
    int u;
    int v;
    int w;
    boolean x;
    private int z;
    int h = 0;
    int j = 0;
    boolean k = true;
    boolean y = true;
    private int H = -1;
    final View.OnClickListener I = new a();

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = true;
            b.this.Y(true);
            androidx.appcompat.view.menu.g itemData = ((NavigationMenuItemView) view).getItemData();
            b bVar = b.this;
            boolean zP = bVar.d.P(itemData, bVar, 0);
            if (itemData != null && itemData.isCheckable() && zP) {
                b.this.f.o(itemData);
            } else {
                z = false;
            }
            b.this.Y(false);
            if (z) {
                b.this.d(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.b$b, reason: collision with other inner class name */
    private static class C0091b extends l {
        public C0091b(View view) {
            super(view);
        }
    }

    private class c extends RecyclerView.Adapter {
        private final ArrayList a = new ArrayList();
        private androidx.appcompat.view.menu.g b;
        private boolean c;

        class a extends t1 {
            final /* synthetic */ int a;
            final /* synthetic */ boolean b;

            a(int i, boolean z) {
                this.a = i;
                this.b = z;
            }

            @Override // defpackage.t1
            public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
                super.onInitializeAccessibilityNodeInfo(view, m2Var);
                m2Var.m0(m2.f.f(c.this.d(this.a), 1, 1, 1, this.b, view.isSelected()));
            }
        }

        c() {
            l();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d(int i) {
            int i2 = i;
            for (int i3 = 0; i3 < i; i3++) {
                if (b.this.f.getItemViewType(i3) == 2 || b.this.f.getItemViewType(i3) == 3) {
                    i2--;
                }
            }
            return i2;
        }

        private void e(int i, int i2) {
            while (i < i2) {
                ((g) this.a.get(i)).b = true;
                i++;
            }
        }

        private void l() {
            if (this.c) {
                return;
            }
            boolean z = true;
            this.c = true;
            this.a.clear();
            this.a.add(new d());
            int size = b.this.d.G().size();
            int i = -1;
            int i2 = 0;
            boolean z2 = false;
            int size2 = 0;
            while (i2 < size) {
                androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) b.this.d.G().get(i2);
                if (gVar.isChecked()) {
                    o(gVar);
                }
                if (gVar.isCheckable()) {
                    gVar.t(false);
                }
                if (gVar.hasSubMenu()) {
                    SubMenu subMenu = gVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            this.a.add(new f(b.this.G, 0));
                        }
                        this.a.add(new g(gVar));
                        int size3 = this.a.size();
                        int size4 = subMenu.size();
                        int i3 = 0;
                        boolean z3 = false;
                        while (i3 < size4) {
                            androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) subMenu.getItem(i3);
                            if (gVar2.isVisible()) {
                                if (!z3 && gVar2.getIcon() != null) {
                                    z3 = z;
                                }
                                if (gVar2.isCheckable()) {
                                    gVar2.t(false);
                                }
                                if (gVar.isChecked()) {
                                    o(gVar);
                                }
                                this.a.add(new g(gVar2));
                            }
                            i3++;
                            z = true;
                        }
                        if (z3) {
                            e(size3, this.a.size());
                        }
                    }
                } else {
                    int groupId = gVar.getGroupId();
                    if (groupId != i) {
                        size2 = this.a.size();
                        z2 = gVar.getIcon() != null;
                        if (i2 != 0) {
                            size2++;
                            ArrayList arrayList = this.a;
                            int i4 = b.this.G;
                            arrayList.add(new f(i4, i4));
                        }
                    } else if (!z2 && gVar.getIcon() != null) {
                        e(size2, this.a.size());
                        z2 = true;
                    }
                    g gVar3 = new g(gVar);
                    gVar3.b = z2;
                    this.a.add(gVar3);
                    i = groupId;
                }
                i2++;
                z = true;
            }
            this.c = false;
        }

        private void n(View view, int i, boolean z) {
            be3.p0(view, new a(i, z));
        }

        public Bundle f() {
            Bundle bundle = new Bundle();
            androidx.appcompat.view.menu.g gVar = this.b;
            if (gVar != null) {
                bundle.putInt("android:menu:checked", gVar.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                e eVar = (e) this.a.get(i);
                if (eVar instanceof g) {
                    androidx.appcompat.view.menu.g gVarA = ((g) eVar).a();
                    View actionView = gVarA != null ? gVarA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(gVarA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public androidx.appcompat.view.menu.g g() {
            return this.b;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            e eVar = (e) this.a.get(i);
            if (eVar instanceof f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        int h() {
            int i = 0;
            for (int i2 = 0; i2 < b.this.f.getItemCount(); i2++) {
                int itemViewType = b.this.f.getItemViewType(i2);
                if (itemViewType == 0 || itemViewType == 1) {
                    i++;
                }
            }
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(l lVar, int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    f fVar = (f) this.a.get(i);
                    lVar.itemView.setPadding(b.this.t, fVar.b(), b.this.u, fVar.a());
                    return;
                }
                TextView textView = (TextView) lVar.itemView;
                textView.setText(((g) this.a.get(i)).a().getTitle());
                j23.p(textView, b.this.h);
                textView.setPadding(b.this.v, textView.getPaddingTop(), b.this.w, textView.getPaddingBottom());
                ColorStateList colorStateList = b.this.i;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                n(textView, i, true);
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(b.this.m);
            navigationMenuItemView.setTextAppearance(b.this.j);
            ColorStateList colorStateList2 = b.this.l;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = b.this.n;
            be3.t0(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = b.this.o;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            g gVar = (g) this.a.get(i);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.b);
            b bVar = b.this;
            int i2 = bVar.p;
            int i3 = bVar.f263q;
            navigationMenuItemView.setPadding(i2, i3, i2, i3);
            navigationMenuItemView.setIconPadding(b.this.r);
            b bVar2 = b.this;
            if (bVar2.x) {
                navigationMenuItemView.setIconSize(bVar2.s);
            }
            navigationMenuItemView.setMaxLines(b.this.z);
            navigationMenuItemView.A(gVar.a(), b.this.k);
            n(navigationMenuItemView, i, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public l onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                b bVar = b.this;
                return new i(bVar.g, viewGroup, bVar.I);
            }
            if (i == 1) {
                return new k(b.this.g, viewGroup);
            }
            if (i == 2) {
                return new j(b.this.g, viewGroup);
            }
            if (i != 3) {
                return null;
            }
            return new C0091b(b.this.b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).B();
            }
        }

        public void m(Bundle bundle) {
            androidx.appcompat.view.menu.g gVarA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.g gVarA2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.c = true;
                int size = this.a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e eVar = (e) this.a.get(i2);
                    if ((eVar instanceof g) && (gVarA2 = ((g) eVar).a()) != null && gVarA2.getItemId() == i) {
                        o(gVarA2);
                        break;
                    }
                }
                this.c = false;
                l();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.a.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    e eVar2 = (e) this.a.get(i3);
                    if ((eVar2 instanceof g) && (gVarA = ((g) eVar2).a()) != null && (actionView = gVarA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(gVarA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void o(androidx.appcompat.view.menu.g gVar) {
            if (this.b == gVar || !gVar.isCheckable()) {
                return;
            }
            androidx.appcompat.view.menu.g gVar2 = this.b;
            if (gVar2 != null) {
                gVar2.setChecked(false);
            }
            this.b = gVar;
            gVar.setChecked(true);
        }

        public void p(boolean z) {
            this.c = z;
        }

        public void q() {
            l();
            notifyDataSetChanged();
        }
    }

    private static class d implements e {
        d() {
        }
    }

    private interface e {
    }

    private static class f implements e {
        private final int a;
        private final int b;

        public f(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    private static class g implements e {
        private final androidx.appcompat.view.menu.g a;
        boolean b;

        g(androidx.appcompat.view.menu.g gVar) {
            this.a = gVar;
        }

        public androidx.appcompat.view.menu.g a() {
            return this.a;
        }
    }

    private class h extends RecyclerViewAccessibilityDelegate {
        h(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, defpackage.t1
        public void onInitializeAccessibilityNodeInfo(View view, m2 m2Var) {
            super.onInitializeAccessibilityNodeInfo(view, m2Var);
            m2Var.l0(m2.e.a(b.this.f.h(), 1, false));
        }
    }

    private static class i extends l {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class j extends l {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class k extends l {
        public k(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private boolean B() {
        return q() > 0;
    }

    private void Z() {
        int i2 = (B() || !this.y) ? 0 : this.F;
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public int A() {
        return this.v;
    }

    public View C(int i2) {
        View viewInflate = this.g.inflate(i2, (ViewGroup) this.b, false);
        b(viewInflate);
        return viewInflate;
    }

    public void D(boolean z) {
        if (this.y != z) {
            this.y = z;
            Z();
        }
    }

    public void E(androidx.appcompat.view.menu.g gVar) {
        this.f.o(gVar);
    }

    public void F(int i2) {
        this.u = i2;
        d(false);
    }

    public void G(int i2) {
        this.t = i2;
        d(false);
    }

    public void H(int i2) {
        this.e = i2;
    }

    public void I(Drawable drawable) {
        this.n = drawable;
        d(false);
    }

    public void J(RippleDrawable rippleDrawable) {
        this.o = rippleDrawable;
        d(false);
    }

    public void K(int i2) {
        this.p = i2;
        d(false);
    }

    public void L(int i2) {
        this.r = i2;
        d(false);
    }

    public void M(int i2) {
        if (this.s != i2) {
            this.s = i2;
            this.x = true;
            d(false);
        }
    }

    public void N(ColorStateList colorStateList) {
        this.m = colorStateList;
        d(false);
    }

    public void O(int i2) {
        this.z = i2;
        d(false);
    }

    public void P(int i2) {
        this.j = i2;
        d(false);
    }

    public void Q(boolean z) {
        this.k = z;
        d(false);
    }

    public void R(ColorStateList colorStateList) {
        this.l = colorStateList;
        d(false);
    }

    public void S(int i2) {
        this.f263q = i2;
        d(false);
    }

    public void T(int i2) {
        this.H = i2;
        NavigationMenuView navigationMenuView = this.a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void U(ColorStateList colorStateList) {
        this.i = colorStateList;
        d(false);
    }

    public void V(int i2) {
        this.w = i2;
        d(false);
    }

    public void W(int i2) {
        this.v = i2;
        d(false);
    }

    public void X(int i2) {
        this.h = i2;
        d(false);
    }

    public void Y(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.p(z);
        }
    }

    public void b(View view) {
        this.b.addView(view);
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
        androidx.appcompat.view.menu.j.a aVar = this.c;
        if (aVar != null) {
            aVar.c(eVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.q();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(androidx.appcompat.view.menu.e eVar, androidx.appcompat.view.menu.g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.e;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, androidx.appcompat.view.menu.e eVar) {
        this.g = LayoutInflater.from(context);
        this.d = eVar;
        this.G = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f.m(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void k(zi3 zi3Var) {
        int iL = zi3Var.l();
        if (this.F != iL) {
            this.F = iL;
            Z();
        }
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, zi3Var.i());
        be3.h(this.b, zi3Var);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        c cVar = this.f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.f());
        }
        if (this.b != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public androidx.appcompat.view.menu.g n() {
        return this.f.g();
    }

    public int o() {
        return this.u;
    }

    public int p() {
        return this.t;
    }

    public int q() {
        return this.b.getChildCount();
    }

    public Drawable r() {
        return this.n;
    }

    public int s() {
        return this.p;
    }

    public int t() {
        return this.r;
    }

    public int u() {
        return this.z;
    }

    public ColorStateList v() {
        return this.l;
    }

    public ColorStateList w() {
        return this.m;
    }

    public int x() {
        return this.f263q;
    }

    public androidx.appcompat.view.menu.k y(ViewGroup viewGroup) {
        if (this.a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.g.inflate(R$layout.design_navigation_menu, viewGroup, false);
            this.a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.a));
            if (this.f == null) {
                c cVar = new c();
                this.f = cVar;
                cVar.setHasStableIds(true);
            }
            int i2 = this.H;
            if (i2 != -1) {
                this.a.setOverScrollMode(i2);
            }
            LinearLayout linearLayout = (LinearLayout) this.g.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.a, false);
            this.b = linearLayout;
            be3.z0(linearLayout, 2);
            this.a.setAdapter(this.f);
        }
        return this.a;
    }

    public int z() {
        return this.w;
    }
}
