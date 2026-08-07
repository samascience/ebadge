package androidx.preference;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import defpackage.be3;
import defpackage.c73;
import defpackage.g52;
import defpackage.m2;
import defpackage.v8;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private int J;
    private b K;
    private List L;
    private PreferenceGroup M;
    private boolean N;
    private boolean O;
    private d P;
    private e Q;
    private final View.OnClickListener R;
    private Context a;
    private androidx.preference.c b;
    private long c;
    private c d;
    private int e;
    private int f;
    private CharSequence g;
    private CharSequence h;
    private int i;
    private Drawable j;
    private String k;
    private Intent l;
    private String m;
    private Bundle n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f197q;
    private String r;
    private Object s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.T(view);
        }
    }

    interface b {
        void a(Preference preference);

        void b(Preference preference);
    }

    public interface c {
        boolean a(Preference preference);
    }

    private static class d implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        private final Preference a;

        d(Preference preference) {
            this.a = preference;
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence charSequenceV = this.a.v();
            if (!this.a.A() || TextUtils.isEmpty(charSequenceV)) {
                return;
            }
            contextMenu.setHeaderTitle(charSequenceV);
            contextMenu.add(0, 0, 0, R$string.copy).setOnMenuItemClickListener(this);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            ClipboardManager clipboardManager = (ClipboardManager) this.a.g().getSystemService("clipboard");
            CharSequence charSequenceV = this.a.v();
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceV));
            Toast.makeText(this.a.g(), this.a.g().getString(R$string.preference_copied, charSequenceV), 0).show();
            return true;
        }
    }

    public interface e {
        CharSequence a(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i, int i2) {
        this.e = Integer.MAX_VALUE;
        this.f = 0;
        this.o = true;
        this.p = true;
        this.f197q = true;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.z = true;
        this.H = true;
        int i3 = R$layout.preference;
        this.I = i3;
        this.R = new a();
        this.a = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Preference, i, i2);
        this.i = c73.l(typedArrayObtainStyledAttributes, R$styleable.Preference_icon, R$styleable.Preference_android_icon, 0);
        this.k = c73.m(typedArrayObtainStyledAttributes, R$styleable.Preference_key, R$styleable.Preference_android_key);
        this.g = c73.n(typedArrayObtainStyledAttributes, R$styleable.Preference_title, R$styleable.Preference_android_title);
        this.h = c73.n(typedArrayObtainStyledAttributes, R$styleable.Preference_summary, R$styleable.Preference_android_summary);
        this.e = c73.d(typedArrayObtainStyledAttributes, R$styleable.Preference_order, R$styleable.Preference_android_order, Integer.MAX_VALUE);
        this.m = c73.m(typedArrayObtainStyledAttributes, R$styleable.Preference_fragment, R$styleable.Preference_android_fragment);
        this.I = c73.l(typedArrayObtainStyledAttributes, R$styleable.Preference_layout, R$styleable.Preference_android_layout, i3);
        this.J = c73.l(typedArrayObtainStyledAttributes, R$styleable.Preference_widgetLayout, R$styleable.Preference_android_widgetLayout, 0);
        this.o = c73.b(typedArrayObtainStyledAttributes, R$styleable.Preference_enabled, R$styleable.Preference_android_enabled, true);
        this.p = c73.b(typedArrayObtainStyledAttributes, R$styleable.Preference_selectable, R$styleable.Preference_android_selectable, true);
        this.f197q = c73.b(typedArrayObtainStyledAttributes, R$styleable.Preference_persistent, R$styleable.Preference_android_persistent, true);
        this.r = c73.m(typedArrayObtainStyledAttributes, R$styleable.Preference_dependency, R$styleable.Preference_android_dependency);
        int i4 = R$styleable.Preference_allowDividerAbove;
        this.w = c73.b(typedArrayObtainStyledAttributes, i4, i4, this.p);
        int i5 = R$styleable.Preference_allowDividerBelow;
        this.x = c73.b(typedArrayObtainStyledAttributes, i5, i5, this.p);
        int i6 = R$styleable.Preference_defaultValue;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            this.s = N(typedArrayObtainStyledAttributes, i6);
        } else {
            int i7 = R$styleable.Preference_android_defaultValue;
            if (typedArrayObtainStyledAttributes.hasValue(i7)) {
                this.s = N(typedArrayObtainStyledAttributes, i7);
            }
        }
        this.H = c73.b(typedArrayObtainStyledAttributes, R$styleable.Preference_shouldDisableView, R$styleable.Preference_android_shouldDisableView, true);
        int i8 = R$styleable.Preference_singleLineTitle;
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i8);
        this.y = zHasValue;
        if (zHasValue) {
            this.z = c73.b(typedArrayObtainStyledAttributes, i8, R$styleable.Preference_android_singleLineTitle, true);
        }
        this.F = c73.b(typedArrayObtainStyledAttributes, R$styleable.Preference_iconSpaceReserved, R$styleable.Preference_android_iconSpaceReserved, false);
        int i9 = R$styleable.Preference_isPreferenceVisible;
        this.v = c73.b(typedArrayObtainStyledAttributes, i9, i9, true);
        int i10 = R$styleable.Preference_enableCopying;
        this.G = c73.b(typedArrayObtainStyledAttributes, i10, i10, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void Y() {
        if (TextUtils.isEmpty(this.r)) {
            return;
        }
        Preference preferenceF = f(this.r);
        if (preferenceF != null) {
            preferenceF.Z(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.r + "\" not found for preference \"" + this.k + "\" (title: \"" + ((Object) this.g) + "\"");
    }

    private void Z(Preference preference) {
        if (this.L == null) {
            this.L = new ArrayList();
        }
        this.L.add(preference);
        preference.L(this, n0());
    }

    private void c0(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                c0(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    private void p0(SharedPreferences.Editor editor) {
        if (this.b.n()) {
            editor.apply();
        }
    }

    private void q0() {
        Preference preferenceF;
        String str = this.r;
        if (str == null || (preferenceF = f(str)) == null) {
            return;
        }
        preferenceF.r0(this);
    }

    private void r0(Preference preference) {
        List list = this.L;
        if (list != null) {
            list.remove(preference);
        }
    }

    public boolean A() {
        return this.G;
    }

    public boolean B() {
        return this.o && this.t && this.u;
    }

    public boolean C() {
        return this.f197q;
    }

    public boolean D() {
        return this.p;
    }

    public final boolean E() {
        return this.v;
    }

    protected void F() {
        b bVar = this.K;
        if (bVar != null) {
            bVar.b(this);
        }
    }

    public void G(boolean z) {
        List list = this.L;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((Preference) list.get(i)).L(this, z);
        }
    }

    protected void H() {
        b bVar = this.K;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void I() {
        Y();
    }

    public void J(androidx.preference.d dVar) {
        Integer numValueOf;
        View view = dVar.itemView;
        view.setOnClickListener(this.R);
        view.setId(this.f);
        TextView textView = (TextView) dVar.a(R.id.summary);
        if (textView != null) {
            CharSequence charSequenceV = v();
            if (TextUtils.isEmpty(charSequenceV)) {
                textView.setVisibility(8);
                numValueOf = null;
            } else {
                textView.setText(charSequenceV);
                textView.setVisibility(0);
                numValueOf = Integer.valueOf(textView.getCurrentTextColor());
            }
        } else {
            numValueOf = null;
        }
        TextView textView2 = (TextView) dVar.a(R.id.title);
        if (textView2 != null) {
            CharSequence charSequenceX = x();
            if (TextUtils.isEmpty(charSequenceX)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequenceX);
                textView2.setVisibility(0);
                if (this.y) {
                    textView2.setSingleLine(this.z);
                }
                if (!D() && B() && numValueOf != null) {
                    textView2.setTextColor(numValueOf.intValue());
                }
            }
        }
        ImageView imageView = (ImageView) dVar.a(R.id.icon);
        if (imageView != null) {
            int i = this.i;
            if (i != 0 || this.j != null) {
                if (this.j == null) {
                    this.j = v8.b(this.a, i);
                }
                Drawable drawable = this.j;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.j != null) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(this.F ? 4 : 8);
            }
        }
        View viewA = dVar.a(R$id.icon_frame);
        if (viewA == null) {
            viewA = dVar.a(R.id.icon_frame);
        }
        if (viewA != null) {
            if (this.j != null) {
                viewA.setVisibility(0);
            } else {
                viewA.setVisibility(this.F ? 4 : 8);
            }
        }
        if (this.H) {
            c0(view, B());
        } else {
            c0(view, true);
        }
        boolean zD = D();
        view.setFocusable(zD);
        view.setClickable(zD);
        dVar.d(this.w);
        dVar.e(this.x);
        boolean zA = A();
        if (zA && this.P == null) {
            this.P = new d(this);
        }
        view.setOnCreateContextMenuListener(zA ? this.P : null);
        view.setLongClickable(zA);
        if (!zA || zD) {
            return;
        }
        be3.t0(view, null);
    }

    protected void K() {
    }

    public void L(Preference preference, boolean z) {
        if (this.t == z) {
            this.t = !z;
            G(n0());
            F();
        }
    }

    public void M() {
        q0();
        this.N = true;
    }

    protected Object N(TypedArray typedArray, int i) {
        return null;
    }

    public void O(m2 m2Var) {
    }

    public void P(Preference preference, boolean z) {
        if (this.u == z) {
            this.u = !z;
            G(n0());
            F();
        }
    }

    protected void Q(Parcelable parcelable) {
        this.O = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    protected Parcelable R() {
        this.O = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void S() {
        androidx.preference.c.InterfaceC0030c interfaceC0030cE;
        if (B() && D()) {
            K();
            c cVar = this.d;
            if (cVar == null || !cVar.a(this)) {
                androidx.preference.c cVarU = u();
                if ((cVarU == null || (interfaceC0030cE = cVarU.e()) == null || !interfaceC0030cE.n(this)) && this.l != null) {
                    g().startActivity(this.l);
                }
            }
        }
    }

    protected void T(View view) {
        S();
    }

    protected boolean U(boolean z) {
        if (!o0()) {
            return false;
        }
        if (z == p(!z)) {
            return true;
        }
        t();
        SharedPreferences.Editor editorC = this.b.c();
        editorC.putBoolean(this.k, z);
        p0(editorC);
        return true;
    }

    protected boolean V(int i) {
        if (!o0()) {
            return false;
        }
        if (i == q(~i)) {
            return true;
        }
        t();
        SharedPreferences.Editor editorC = this.b.c();
        editorC.putInt(this.k, i);
        p0(editorC);
        return true;
    }

    protected boolean W(String str) {
        if (!o0()) {
            return false;
        }
        if (TextUtils.equals(str, r(null))) {
            return true;
        }
        t();
        SharedPreferences.Editor editorC = this.b.c();
        editorC.putString(this.k, str);
        p0(editorC);
        return true;
    }

    public boolean X(Set set) {
        if (!o0()) {
            return false;
        }
        if (set.equals(s(null))) {
            return true;
        }
        t();
        SharedPreferences.Editor editorC = this.b.c();
        editorC.putStringSet(this.k, set);
        p0(editorC);
        return true;
    }

    public boolean a(Object obj) {
        return true;
    }

    public void a0(Bundle bundle) {
        d(bundle);
    }

    final void b() {
        this.N = false;
    }

    public void b0(Bundle bundle) {
        e(bundle);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(Preference preference) {
        int i = this.e;
        int i2 = preference.e;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.g;
        CharSequence charSequence2 = preference.g;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.g.toString());
    }

    void d(Bundle bundle) {
        Parcelable parcelable;
        if (!z() || (parcelable = bundle.getParcelable(this.k)) == null) {
            return;
        }
        this.O = false;
        Q(parcelable);
        if (!this.O) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public void d0(int i) {
        e0(v8.b(this.a, i));
        this.i = i;
    }

    void e(Bundle bundle) {
        if (z()) {
            this.O = false;
            Parcelable parcelableR = R();
            if (!this.O) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            }
            if (parcelableR != null) {
                bundle.putParcelable(this.k, parcelableR);
            }
        }
    }

    public void e0(Drawable drawable) {
        if (this.j != drawable) {
            this.j = drawable;
            this.i = 0;
            F();
        }
    }

    protected Preference f(String str) {
        androidx.preference.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.a(str);
    }

    public void f0(int i) {
        this.I = i;
    }

    public Context g() {
        return this.a;
    }

    final void g0(b bVar) {
        this.K = bVar;
    }

    public Bundle h() {
        if (this.n == null) {
            this.n = new Bundle();
        }
        return this.n;
    }

    public void h0(c cVar) {
        this.d = cVar;
    }

    StringBuilder i() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequenceX = x();
        if (!TextUtils.isEmpty(charSequenceX)) {
            sb.append(charSequenceX);
            sb.append(' ');
        }
        CharSequence charSequenceV = v();
        if (!TextUtils.isEmpty(charSequenceV)) {
            sb.append(charSequenceV);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void i0(int i) {
        if (i != this.e) {
            this.e = i;
            H();
        }
    }

    public String j() {
        return this.m;
    }

    public void j0(CharSequence charSequence) {
        if (w() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.h, charSequence)) {
            return;
        }
        this.h = charSequence;
        F();
    }

    long k() {
        return this.c;
    }

    public final void k0(e eVar) {
        this.Q = eVar;
        F();
    }

    public Intent l() {
        return this.l;
    }

    public void l0(int i) {
        m0(this.a.getString(i));
    }

    public String m() {
        return this.k;
    }

    public void m0(CharSequence charSequence) {
        if ((charSequence != null || this.g == null) && (charSequence == null || charSequence.equals(this.g))) {
            return;
        }
        this.g = charSequence;
        F();
    }

    public final int n() {
        return this.I;
    }

    public boolean n0() {
        return !B();
    }

    public PreferenceGroup o() {
        return this.M;
    }

    protected boolean o0() {
        return this.b != null && C() && z();
    }

    protected boolean p(boolean z) {
        if (!o0()) {
            return z;
        }
        t();
        return this.b.i().getBoolean(this.k, z);
    }

    protected int q(int i) {
        if (!o0()) {
            return i;
        }
        t();
        return this.b.i().getInt(this.k, i);
    }

    protected String r(String str) {
        if (!o0()) {
            return str;
        }
        t();
        return this.b.i().getString(this.k, str);
    }

    public Set s(Set set) {
        if (!o0()) {
            return set;
        }
        t();
        return this.b.i().getStringSet(this.k, set);
    }

    public g52 t() {
        androidx.preference.c cVar = this.b;
        if (cVar != null) {
            cVar.g();
        }
        return null;
    }

    public String toString() {
        return i().toString();
    }

    public androidx.preference.c u() {
        return this.b;
    }

    public CharSequence v() {
        return w() != null ? w().a(this) : this.h;
    }

    public final e w() {
        return this.Q;
    }

    public CharSequence x() {
        return this.g;
    }

    public final int y() {
        return this.J;
    }

    public boolean z() {
        return !TextUtils.isEmpty(this.k);
    }

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c73.a(context, R$attr.preferenceStyle, R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
