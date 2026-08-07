package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.search.SearchView;
import com.tencent.connect.common.Constants;
import defpackage.be3;
import defpackage.ck0;
import defpackage.dd0;
import defpackage.e43;
import defpackage.f43;
import defpackage.he;
import defpackage.hf0;
import defpackage.ig1;
import defpackage.j23;
import defpackage.jg1;
import defpackage.mu1;
import defpackage.nf3;
import defpackage.o23;
import defpackage.og1;
import defpackage.rg1;
import defpackage.td0;
import defpackage.u30;
import defpackage.ug1;
import defpackage.v8;
import defpackage.yg1;
import defpackage.zi3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.b, ig1 {
    private static final int I = R$style.Widget_Material3_SearchView;
    private boolean F;
    private TransitionState G;
    private Map H;
    final View a;
    final ClippableRoundedCornerLayout b;
    final View c;
    final View d;
    final FrameLayout e;
    final FrameLayout f;
    final MaterialToolbar g;
    final Toolbar h;
    final TextView i;
    final EditText j;
    final ImageButton k;
    final View l;
    final TouchObserverFrameLayout m;
    private final boolean n;
    private final h o;
    private final jg1 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f267q;
    private final hf0 r;
    private final Set s;
    private SearchBar t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private final int y;
    private boolean z;

    public static class Behavior extends CoordinatorLayout.c {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, SearchView searchView, View view) {
            if (searchView.x() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String a;
        int b;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeInt(this.b);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readString();
            this.b = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView.this.k.setVisibility(charSequence.length() > 0 ? 0 : 8);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(View view) {
        q();
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean C(View view, MotionEvent motionEvent) {
        if (!s()) {
            return false;
        }
        p();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ zi3 D(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, View view, zi3 zi3Var) {
        marginLayoutParams.leftMargin = i + zi3Var.j();
        marginLayoutParams.rightMargin = i2 + zi3Var.k();
        return zi3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean E(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ zi3 F(View view, zi3 zi3Var) {
        int iL = zi3Var.l();
        setUpStatusBarSpacer(iL);
        if (!this.F) {
            setStatusBarSpacerEnabledInternal(iL > 0);
        }
        return zi3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ zi3 G(View view, zi3 zi3Var, nf3.e eVar) {
        boolean zO = nf3.o(this.g);
        this.g.setPadding((zO ? eVar.c : eVar.a) + zi3Var.j(), eVar.b, (zO ? eVar.a : eVar.c) + zi3Var.k(), eVar.d);
        return zi3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        V();
    }

    private void K(TransitionState transitionState, boolean z) {
        if (this.G.equals(transitionState)) {
            return;
        }
        if (z) {
            if (transitionState == TransitionState.SHOWN) {
                setModalForAccessibility(true);
            } else if (transitionState == TransitionState.HIDDEN) {
                setModalForAccessibility(false);
            }
        }
        this.G = transitionState;
        Iterator it = new LinkedHashSet(this.s).iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
        X(transitionState);
    }

    private void L(boolean z, boolean z2) {
        if (z2) {
            this.g.setNavigationIcon((Drawable) null);
            return;
        }
        this.g.setNavigationOnClickListener(new View.OnClickListener() { // from class: em2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A(view);
            }
        });
        if (z) {
            td0 td0Var = new td0(getContext());
            td0Var.c(og1.d(this, R$attr.colorOnSurface));
            this.g.setNavigationIcon(td0Var);
        }
    }

    private void M() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void N() {
        this.k.setOnClickListener(new View.OnClickListener() { // from class: ul2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.B(view);
            }
        });
        this.j.addTextChangedListener(new a());
    }

    private void O() {
        this.m.setOnTouchListener(new View.OnTouchListener() { // from class: dm2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.C(view, motionEvent);
            }
        });
    }

    private void P() {
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.l.getLayoutParams();
        final int i = marginLayoutParams.leftMargin;
        final int i2 = marginLayoutParams.rightMargin;
        be3.E0(this.l, new mu1() { // from class: xl2
            @Override // defpackage.mu1
            public final zi3 a(View view, zi3 zi3Var) {
                return SearchView.D(marginLayoutParams, i, i2, view, zi3Var);
            }
        });
    }

    private void Q(int i, String str, String str2) {
        if (i != -1) {
            j23.p(this.j, i);
        }
        this.j.setText(str);
        this.j.setHint(str2);
    }

    private void R() {
        U();
        P();
        T();
    }

    private void S() {
        this.b.setOnTouchListener(new View.OnTouchListener() { // from class: cm2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return SearchView.E(view, motionEvent);
            }
        });
    }

    private void T() {
        setUpStatusBarSpacer(getStatusBarHeight());
        be3.E0(this.d, new mu1() { // from class: zl2
            @Override // defpackage.mu1
            public final zi3 a(View view, zi3 zi3Var) {
                return this.a.F(view, zi3Var);
            }
        });
    }

    private void U() {
        nf3.e(this.g, new nf3.d() { // from class: yl2
            @Override // nf3.d
            public final zi3 a(View view, zi3 zi3Var, nf3.e eVar) {
                return this.a.G(view, zi3Var, eVar);
            }
        });
    }

    private void W(ViewGroup viewGroup, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != this) {
                if (childAt.findViewById(this.b.getId()) != null) {
                    W((ViewGroup) childAt, z);
                } else if (z) {
                    this.H.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    be3.z0(childAt, 4);
                } else {
                    Map map = this.H;
                    if (map != null && map.containsKey(childAt)) {
                        be3.z0(childAt, ((Integer) this.H.get(childAt)).intValue());
                    }
                }
            }
        }
    }

    private void X(TransitionState transitionState) {
        if (this.t == null || !this.f267q) {
            return;
        }
        if (transitionState.equals(TransitionState.SHOWN)) {
            this.p.c();
        } else if (transitionState.equals(TransitionState.HIDDEN)) {
            this.p.f();
        }
    }

    private void Y() {
        MaterialToolbar materialToolbar = this.g;
        if (materialToolbar == null || w(materialToolbar)) {
            return;
        }
        int defaultNavigationIconResource = getDefaultNavigationIconResource();
        if (this.t == null) {
            this.g.setNavigationIcon(defaultNavigationIconResource);
            return;
        }
        Drawable drawableR = dd0.r(v8.b(getContext(), defaultNavigationIconResource).mutate());
        if (this.g.getNavigationIconTint() != null) {
            dd0.n(drawableR, this.g.getNavigationIconTint().intValue());
        }
        this.g.setNavigationIcon(new ck0(this.t.getNavigationIcon(), drawableR));
        Z();
    }

    private void Z() {
        ImageButton imageButtonD = f43.d(this.g);
        if (imageButtonD == null) {
            return;
        }
        int i = this.b.getVisibility() == 0 ? 1 : 0;
        Drawable drawableQ = dd0.q(imageButtonD.getDrawable());
        if (drawableQ instanceof td0) {
            ((td0) drawableQ).e(i);
        }
        if (drawableQ instanceof ck0) {
            ((ck0) drawableQ).a(i);
        }
    }

    private Window getActivityWindow() {
        Activity activityA = u30.a(getContext());
        if (activityA == null) {
            return null;
        }
        return activityA.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.t;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R$dimen.m3_searchview_elevation);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z) {
        this.d.setVisibility(z ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f) {
        hf0 hf0Var = this.r;
        if (hf0Var == null || this.c == null) {
            return;
        }
        this.c.setBackgroundColor(hf0Var.c(this.y, f));
    }

    private void setUpHeaderLayout(int i) {
        if (i != -1) {
            o(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this.e, false));
        }
    }

    private void setUpStatusBarSpacer(int i) {
        if (this.d.getLayoutParams().height != i) {
            this.d.getLayoutParams().height = i;
            this.d.requestLayout();
        }
    }

    private boolean u() {
        return this.G.equals(TransitionState.HIDDEN) || this.G.equals(TransitionState.HIDING);
    }

    private boolean w(Toolbar toolbar) {
        return dd0.q(toolbar.getNavigationIcon()) instanceof td0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        this.j.clearFocus();
        SearchBar searchBar = this.t;
        if (searchBar != null) {
            searchBar.requestFocus();
        }
        nf3.n(this.j, this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        if (this.j.requestFocus()) {
            this.j.sendAccessibilityEvent(8);
        }
        nf3.t(this.j, this.z);
    }

    public void I() {
        this.j.postDelayed(new Runnable() { // from class: vl2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z();
            }
        }, 100L);
    }

    void J() {
        if (this.x) {
            I();
        }
    }

    public void V() {
        if (this.G.equals(TransitionState.SHOWN) || this.G.equals(TransitionState.SHOWING)) {
            return;
        }
        this.o.Z();
    }

    @Override // defpackage.ig1
    public void a() {
        if (u()) {
            return;
        }
        he heVarS = this.o.S();
        if (Build.VERSION.SDK_INT < 34 || this.t == null || heVarS == null) {
            r();
        } else {
            this.o.p();
        }
    }

    public void a0() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.u = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.n) {
            this.m.addView(view, i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    @Override // defpackage.ig1
    public void b(he heVar) {
        if (u() || this.t == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.o.f0(heVar);
    }

    @Override // defpackage.ig1
    public void c(he heVar) {
        if (u() || this.t == null) {
            return;
        }
        this.o.a0(heVar);
    }

    @Override // defpackage.ig1
    public void d() {
        if (u() || this.t == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        this.o.o();
    }

    rg1 getBackHelper() {
        return this.o.r();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        return new Behavior();
    }

    public TransitionState getCurrentTransitionState() {
        return this.G;
    }

    protected int getDefaultNavigationIconResource() {
        return R$drawable.ic_arrow_back_black_24;
    }

    public EditText getEditText() {
        return this.j;
    }

    public CharSequence getHint() {
        return this.j.getHint();
    }

    public TextView getSearchPrefix() {
        return this.i;
    }

    public CharSequence getSearchPrefixText() {
        return this.i.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.u;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.j.getText();
    }

    public Toolbar getToolbar() {
        return this.g;
    }

    public void o(View view) {
        this.e.addView(view);
        this.e.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ug1.e(this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        a0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.a);
        setVisible(savedState.b == 0);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.a = text == null ? null : text.toString();
        savedState.b = this.b.getVisibility();
        return savedState;
    }

    public void p() {
        this.j.post(new Runnable() { // from class: wl2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y();
            }
        });
    }

    public void q() {
        this.j.setText(Constants.STR_EMPTY);
    }

    public void r() {
        if (this.G.equals(TransitionState.HIDDEN) || this.G.equals(TransitionState.HIDING)) {
            return;
        }
        this.o.M();
    }

    boolean s() {
        return this.u == 48;
    }

    public void setAnimatedNavigationIcon(boolean z) {
        this.v = z;
    }

    public void setAutoShowKeyboard(boolean z) {
        this.x = z;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        setUpBackgroundViewElevationOverlay(f);
    }

    public void setHint(CharSequence charSequence) {
        this.j.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z) {
        this.w = z;
    }

    public void setModalForAccessibility(boolean z) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z) {
            this.H = new HashMap(viewGroup.getChildCount());
        }
        W(viewGroup, z);
        if (z) {
            return;
        }
        this.H = null;
    }

    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        this.g.setOnMenuItemClickListener(hVar);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        this.i.setText(charSequence);
        this.i.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setStatusBarSpacerEnabled(boolean z) {
        this.F = true;
        setStatusBarSpacerEnabledInternal(z);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        this.j.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z) {
        this.g.setTouchscreenBlocksFocus(z);
    }

    void setTransitionState(TransitionState transitionState) {
        K(transitionState, true);
    }

    public void setUseWindowInsetsController(boolean z) {
        this.z = z;
    }

    public void setVisible(boolean z) {
        boolean z2 = this.b.getVisibility() == 0;
        this.b.setVisibility(z ? 0 : 8);
        Z();
        K(z ? TransitionState.SHOWN : TransitionState.HIDDEN, z2 != z);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.t = searchBar;
        this.o.X(searchBar);
        if (searchBar != null) {
            searchBar.setOnClickListener(new View.OnClickListener() { // from class: am2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.H(view);
                }
            });
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new Runnable() { // from class: bm2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.V();
                        }
                    });
                    this.j.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        Y();
        M();
        X(getCurrentTransitionState());
    }

    public boolean t() {
        return this.v;
    }

    public boolean v() {
        return this.w;
    }

    public boolean x() {
        return this.t != null;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialSearchViewStyle);
    }

    public void setHint(int i) {
        this.j.setHint(i);
    }

    public void setText(int i) {
        this.j.setText(i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchView(Context context, AttributeSet attributeSet, int i) {
        int i2 = I;
        super(yg1.c(context, attributeSet, i, i2), attributeSet, i);
        this.p = new jg1(this);
        this.s = new LinkedHashSet();
        this.u = 16;
        this.G = TransitionState.HIDDEN;
        Context context2 = getContext();
        TypedArray typedArrayI = o23.i(context2, attributeSet, R$styleable.SearchView, i, i2, new int[0]);
        this.y = typedArrayI.getColor(R$styleable.SearchView_backgroundTint, 0);
        int resourceId = typedArrayI.getResourceId(R$styleable.SearchView_headerLayout, -1);
        int resourceId2 = typedArrayI.getResourceId(R$styleable.SearchView_android_textAppearance, -1);
        String string = typedArrayI.getString(R$styleable.SearchView_android_text);
        String string2 = typedArrayI.getString(R$styleable.SearchView_android_hint);
        String string3 = typedArrayI.getString(R$styleable.SearchView_searchPrefixText);
        boolean z = typedArrayI.getBoolean(R$styleable.SearchView_useDrawerArrowDrawable, false);
        this.v = typedArrayI.getBoolean(R$styleable.SearchView_animateNavigationIcon, true);
        this.w = typedArrayI.getBoolean(R$styleable.SearchView_animateMenuItems, true);
        boolean z2 = typedArrayI.getBoolean(R$styleable.SearchView_hideNavigationIcon, false);
        this.x = typedArrayI.getBoolean(R$styleable.SearchView_autoShowKeyboard, true);
        this.f267q = typedArrayI.getBoolean(R$styleable.SearchView_backHandlingEnabled, true);
        typedArrayI.recycle();
        LayoutInflater.from(context2).inflate(R$layout.mtrl_search_view, this);
        this.n = true;
        this.a = findViewById(R$id.open_search_view_scrim);
        this.b = (ClippableRoundedCornerLayout) findViewById(R$id.open_search_view_root);
        this.c = findViewById(R$id.open_search_view_background);
        this.d = findViewById(R$id.open_search_view_status_bar_spacer);
        this.e = (FrameLayout) findViewById(R$id.open_search_view_header_container);
        this.f = (FrameLayout) findViewById(R$id.open_search_view_toolbar_container);
        this.g = (MaterialToolbar) findViewById(R$id.open_search_view_toolbar);
        this.h = (Toolbar) findViewById(R$id.open_search_view_dummy_toolbar);
        this.i = (TextView) findViewById(R$id.open_search_view_search_prefix);
        this.j = (EditText) findViewById(R$id.open_search_view_edit_text);
        this.k = (ImageButton) findViewById(R$id.open_search_view_clear_button);
        this.l = findViewById(R$id.open_search_view_divider);
        this.m = (TouchObserverFrameLayout) findViewById(R$id.open_search_view_content_container);
        this.o = new h(this);
        this.r = new hf0(context2);
        S();
        M();
        setUpHeaderLayout(resourceId);
        setSearchPrefixText(string3);
        Q(resourceId2, string, string2);
        L(z, z2);
        N();
        O();
        R();
    }
}
