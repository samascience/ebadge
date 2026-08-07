package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import defpackage.dd0;
import defpackage.g43;
import defpackage.qo2;
import defpackage.s2;
import defpackage.v2;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements v2.a {
    c F;
    private b G;
    final f H;
    int I;
    d k;
    private Drawable l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f137q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private final SparseBooleanArray x;
    e y;
    a z;

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
        }
    }

    private class a extends androidx.appcompat.view.menu.i {
        public a(Context context, androidx.appcompat.view.menu.m mVar, View view) {
            super(context, mVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.g) mVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).i : view2);
            }
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.z = null;
            actionMenuPresenter.I = 0;
            super.e();
        }
    }

    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public qo2 a() {
            a aVar = ActionMenuPresenter.this.z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    private class c implements Runnable {
        private e a;

        public c(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c != null) {
                ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).i;
            if (view != null && view.getWindowToken() != null && this.a.m()) {
                ActionMenuPresenter.this.y = this.a;
            }
            ActionMenuPresenter.this.F = null;
        }
    }

    private class d extends AppCompatImageView implements ActionMenuView.a {

        class a extends u {
            final /* synthetic */ ActionMenuPresenter j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.u
            public qo2 b() {
                e eVar = ActionMenuPresenter.this.y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.u
            public boolean c() {
                ActionMenuPresenter.this.N();
                return true;
            }

            @Override // androidx.appcompat.widget.u
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.F != null) {
                    return false;
                }
                actionMenuPresenter.E();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            g43.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.N();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                dd0.l(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    private class e extends androidx.appcompat.view.menu.i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z) {
            super(context, eVar, view, z, R$attr.actionOverflowMenuStyle);
            h(8388613);
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c != null) {
                ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c.close();
            }
            ActionMenuPresenter.this.y = null;
            super.e();
        }
    }

    private class f implements androidx.appcompat.view.menu.j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
            if (eVar instanceof androidx.appcompat.view.menu.m) {
                eVar.F().e(false);
            }
            androidx.appcompat.view.menu.j.a aVarP = ActionMenuPresenter.this.p();
            if (aVarP != null) {
                aVarP.c(eVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).c) {
                return false;
            }
            ActionMenuPresenter.this.I = ((androidx.appcompat.view.menu.m) eVar).getItem().getItemId();
            androidx.appcompat.view.menu.j.a aVarP = ActionMenuPresenter.this.p();
            if (aVarP != null) {
                return aVarP.d(eVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.x = new SparseBooleanArray();
        this.H = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof androidx.appcompat.view.menu.k.a) && ((androidx.appcompat.view.menu.k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean B() {
        return E() | F();
    }

    public Drawable D() {
        d dVar = this.k;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.m) {
            return this.l;
        }
        return null;
    }

    public boolean E() {
        Object obj;
        c cVar = this.F;
        if (cVar != null && (obj = this.i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.F = null;
            return true;
        }
        e eVar = this.y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean F() {
        a aVar = this.z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean G() {
        return this.F != null || H();
    }

    public boolean H() {
        e eVar = this.y;
        return eVar != null && eVar.d();
    }

    public void I(Configuration configuration) {
        if (!this.s) {
            this.r = s2.b(this.b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.c;
        if (eVar != null) {
            eVar.N(true);
        }
    }

    public void J(boolean z) {
        this.v = z;
    }

    public void K(ActionMenuView actionMenuView) {
        this.i = actionMenuView;
        actionMenuView.initialize(this.c);
    }

    public void L(Drawable drawable) {
        d dVar = this.k;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.m = true;
            this.l = drawable;
        }
    }

    public void M(boolean z) {
        this.n = z;
        this.o = true;
    }

    public boolean N() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.n || H() || (eVar = this.c) == null || this.i == null || this.F != null || eVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.b, this.c, this.k, true));
        this.F = cVar;
        ((View) this.i).post(cVar);
        return true;
    }

    @Override // v2.a
    public void a(boolean z) {
        if (z) {
            super.l(null);
            return;
        }
        androidx.appcompat.view.menu.e eVar = this.c;
        if (eVar != null) {
            eVar.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void c(androidx.appcompat.view.menu.e eVar, boolean z) {
        B();
        super.c(eVar, z);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void d(boolean z) {
        super.d(z);
        ((View) this.i).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.c;
        boolean z2 = false;
        if (eVar != null) {
            ArrayList arrayListU = eVar.u();
            int size = arrayListU.size();
            for (int i = 0; i < size; i++) {
                v2 v2VarB = ((androidx.appcompat.view.menu.g) arrayListU.get(i)).b();
                if (v2VarB != null) {
                    v2VarB.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.c;
        ArrayList arrayListB = eVar2 != null ? eVar2.B() : null;
        if (this.n && arrayListB != null) {
            int size2 = arrayListB.size();
            if (size2 == 1) {
                z2 = !((androidx.appcompat.view.menu.g) arrayListB.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.k == null) {
                this.k = new d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                actionMenuView.addView(this.k, actionMenuView.C());
            }
        } else {
            d dVar = this.k;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.k);
                }
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.ActionMenuPresenter] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r15v1, types: [androidx.appcompat.view.menu.g] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        ArrayList arrayListG;
        int size;
        int i;
        int I;
        ?? r0;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.e eVar = actionMenuPresenter.c;
        View view = null;
        ?? r3 = 0;
        if (eVar != null) {
            arrayListG = eVar.G();
            size = arrayListG.size();
        } else {
            arrayListG = null;
            size = 0;
        }
        int i2 = actionMenuPresenter.r;
        int i3 = actionMenuPresenter.f137q;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.i;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) arrayListG.get(i6);
            if (gVar.o()) {
                i4++;
            } else if (gVar.n()) {
                i5++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.v && gVar.isActionViewExpanded()) {
                i2 = 0;
            }
        }
        if (actionMenuPresenter.n && (z || i5 + i4 > i2)) {
            i2--;
        }
        int i7 = i2 - i4;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.t) {
            int i8 = actionMenuPresenter.w;
            I = i3 / i8;
            i = i8 + ((i3 % i8) / I);
        } else {
            i = 0;
            I = 0;
        }
        int i9 = 0;
        int i10 = 0;
        ?? r1 = actionMenuPresenter;
        while (i9 < size) {
            ?? r15 = (androidx.appcompat.view.menu.g) arrayListG.get(i9);
            if (r15.o()) {
                View viewQ = r1.q(r15, view, viewGroup);
                if (r1.t) {
                    I -= ActionMenuView.I(viewQ, i, I, iMakeMeasureSpec, r3);
                } else {
                    viewQ.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewQ.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                int groupId = r15.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                r15.u(true);
                r0 = r3;
            } else if (r15.n()) {
                int groupId2 = r15.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i7 > 0 || z2) && i3 > 0 && (!r1.t || I > 0);
                boolean z4 = z3;
                if (z3) {
                    View viewQ2 = r1.q(r15, null, viewGroup);
                    if (r1.t) {
                        int I2 = ActionMenuView.I(viewQ2, i, I, iMakeMeasureSpec, 0);
                        I -= I2;
                        if (I2 == 0) {
                            z4 = false;
                        }
                    } else {
                        viewQ2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = viewQ2.getMeasuredWidth();
                    i3 -= measuredWidth2;
                    if (i10 == 0) {
                        i10 = measuredWidth2;
                    }
                    z3 = z5 & (!r1.t ? i3 + i10 <= 0 : i3 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i11 = 0; i11 < i9; i11++) {
                        androidx.appcompat.view.menu.g gVar2 = (androidx.appcompat.view.menu.g) arrayListG.get(i11);
                        if (gVar2.getGroupId() == groupId2) {
                            if (gVar2.l()) {
                                i7++;
                            }
                            gVar2.u(false);
                        }
                    }
                }
                if (z3) {
                    i7--;
                }
                r15.u(z3);
                r0 = 0;
            } else {
                r0 = r3;
                r15.u(r0);
            }
            i9++;
            r3 = r0;
            size = size;
            view = null;
            r1 = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void i(Context context, androidx.appcompat.view.menu.e eVar) {
        super.i(context, eVar);
        Resources resources = context.getResources();
        s2 s2VarB = s2.b(context);
        if (!this.o) {
            this.n = s2VarB.h();
        }
        if (!this.u) {
            this.p = s2VarB.c();
        }
        if (!this.s) {
            this.r = s2VarB.d();
        }
        int measuredWidth = this.p;
        if (this.n) {
            if (this.k == null) {
                d dVar = new d(this.a);
                this.k = dVar;
                if (this.m) {
                    dVar.setImageDrawable(this.l);
                    this.l = null;
                    this.m = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.k.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.k.getMeasuredWidth();
        } else {
            this.k = null;
        }
        this.f137q = measuredWidth;
        this.w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).a) > 0 && (menuItemFindItem = this.c.findItem(i)) != null) {
            l((androidx.appcompat.view.menu.m) menuItemFindItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.a
    public void k(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.k.a aVar) {
        aVar.initialize(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
        if (this.G == null) {
            this.G = new b();
        }
        actionMenuItemView.setPopupCallback(this.G);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean l(androidx.appcompat.view.menu.m mVar) {
        boolean z = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.m mVar2 = mVar;
        while (mVar2.j0() != this.c) {
            mVar2 = (androidx.appcompat.view.menu.m) mVar2.j0();
        }
        View viewC = C(mVar2.getItem());
        if (viewC == null) {
            return false;
        }
        this.I = mVar.getItem().getItemId();
        int size = mVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = mVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
        }
        a aVar = new a(this.b, mVar, viewC);
        this.z = aVar;
        aVar.g(z);
        this.z.k();
        super.l(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        SavedState savedState = new SavedState();
        savedState.a = this.I;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean o(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.k) {
            return false;
        }
        return super.o(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.a
    public View q(androidx.appcompat.view.menu.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.q(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public androidx.appcompat.view.menu.k r(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.k kVar = this.i;
        androidx.appcompat.view.menu.k kVarR = super.r(viewGroup);
        if (kVar != kVarR) {
            ((ActionMenuView) kVarR).setPresenter(this);
        }
        return kVarR;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean t(int i, androidx.appcompat.view.menu.g gVar) {
        return gVar.l();
    }
}
