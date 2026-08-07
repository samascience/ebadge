package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.h52;

/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceFragmentCompat extends Fragment implements androidx.preference.c.InterfaceC0030c, androidx.preference.c.a, androidx.preference.c.b, DialogPreference.a {
    private androidx.preference.c b;
    RecyclerView c;
    private boolean d;
    private boolean e;
    private Runnable g;
    private final c a = new c();
    private int f = R$layout.preference_list_fragment;
    private Handler h = new a();
    private final Runnable i = new b();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragmentCompat.this.v();
        }
    }

    class b implements Runnable {
        b() {
        }

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
        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = PreferenceFragmentCompat.this.c;
            recyclerView.focusableViewAvailable(recyclerView);
        }
    }

    private class c extends RecyclerView.ItemDecoration {
        private Drawable a;
        private int b;
        private boolean c = true;

        c() {
        }

        private boolean d(View view, RecyclerView recyclerView) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
            boolean z = false;
            if (!(childViewHolder instanceof d) || !((d) childViewHolder).c()) {
                return false;
            }
            boolean z2 = this.c;
            int iIndexOfChild = recyclerView.indexOfChild(view);
            if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
                return z2;
            }
            RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
            if ((childViewHolder2 instanceof d) && ((d) childViewHolder2).b()) {
                z = true;
            }
            return z;
        }

        public void a(boolean z) {
            this.c = z;
        }

        public void b(Drawable drawable) {
            if (drawable != null) {
                this.b = drawable.getIntrinsicHeight();
            } else {
                this.b = 0;
            }
            this.a = drawable;
            PreferenceFragmentCompat.this.c.invalidateItemDecorations();
        }

        public void c(int i) {
            this.b = i;
            PreferenceFragmentCompat.this.c.invalidateItemDecorations();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (d(view, recyclerView)) {
                rect.bottom = this.b;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            if (this.a == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int width = recyclerView.getWidth();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (d(childAt, recyclerView)) {
                    int y = ((int) childAt.getY()) + childAt.getHeight();
                    this.a.setBounds(0, y, width, this.b + y);
                    this.a.draw(canvas);
                }
            }
        }
    }

    private void H() {
        x().setAdapter(null);
        PreferenceScreen preferenceScreenY = y();
        if (preferenceScreenY != null) {
            preferenceScreenY.M();
        }
        E();
    }

    protected RecyclerView.Adapter A(PreferenceScreen preferenceScreen) {
        return new androidx.preference.b(preferenceScreen);
    }

    public RecyclerView.LayoutManager B() {
        return new LinearLayoutManager(getContext());
    }

    public abstract void C(Bundle bundle, String str);

    public RecyclerView D(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R$id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R$layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(B());
        recyclerView2.setAccessibilityDelegateCompat(new h52(recyclerView2));
        return recyclerView2;
    }

    protected void E() {
    }

    public void F(Drawable drawable) {
        this.a.b(drawable);
    }

    public void G(int i) {
        this.a.c(i);
    }

    @Override // androidx.preference.DialogPreference.a
    public Preference d(CharSequence charSequence) {
        androidx.preference.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.a(charSequence);
    }

    @Override // androidx.preference.c.a
    public void l(Preference preference) {
        DialogFragment dialogFragmentV;
        w();
        getActivity();
        if (getParentFragmentManager().j0("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            dialogFragmentV = EditTextPreferenceDialogFragmentCompat.V(preference.m());
        } else if (preference instanceof ListPreference) {
            dialogFragmentV = ListPreferenceDialogFragmentCompat.V(preference.m());
        } else {
            if (!(preference instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            dialogFragmentV = MultiSelectListPreferenceDialogFragmentCompat.V(preference.m());
        }
        dialogFragmentV.setTargetFragment(this, 0);
        dialogFragmentV.M(getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }

    @Override // androidx.preference.c.b
    public void m(PreferenceScreen preferenceScreen) {
        w();
        getActivity();
    }

    @Override // androidx.preference.c.InterfaceC0030c
    public boolean n(Preference preference) {
        if (preference.j() == null) {
            return false;
        }
        w();
        getActivity();
        Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Bundle bundleH = preference.h();
        Fragment fragmentA = supportFragmentManager.t0().a(requireActivity().getClassLoader(), preference.j());
        fragmentA.setArguments(bundleH);
        fragmentA.setTargetFragment(this, 0);
        supportFragmentManager.p().p(((View) getView().getParent()).getId(), fragmentA).f(null).h();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R$attr.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = R$style.PreferenceThemeOverlay;
        }
        getActivity().getTheme().applyStyle(i, false);
        androidx.preference.c cVar = new androidx.preference.c(getContext());
        this.b = cVar;
        cVar.k(this);
        C(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.PreferenceFragmentCompat, R$attr.preferenceFragmentCompatStyle, 0);
        this.f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PreferenceFragmentCompat_android_layout, this.f);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(getContext());
        View viewInflate = layoutInflaterCloneInContext.inflate(this.f, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewD = D(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewD == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.c = recyclerViewD;
        recyclerViewD.addItemDecoration(this.a);
        F(drawable);
        if (dimensionPixelSize != -1) {
            G(dimensionPixelSize);
        }
        this.a.a(z);
        if (this.c.getParent() == null) {
            viewGroup2.addView(this.c);
        }
        this.h.post(this.i);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.h.removeCallbacks(this.i);
        this.h.removeMessages(1);
        if (this.d) {
            H();
        }
        this.c = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreenY = y();
        if (preferenceScreenY != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenY.b0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.b.l(this);
        this.b.j(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.l(null);
        this.b.j(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenY;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenY = y()) != null) {
            preferenceScreenY.a0(bundle2);
        }
        if (this.d) {
            v();
            Runnable runnable = this.g;
            if (runnable != null) {
                runnable.run();
                this.g = null;
            }
        }
        this.e = true;
    }

    void v() {
        PreferenceScreen preferenceScreenY = y();
        if (preferenceScreenY != null) {
            x().setAdapter(A(preferenceScreenY));
            preferenceScreenY.I();
        }
        z();
    }

    public Fragment w() {
        return null;
    }

    public final RecyclerView x() {
        return this.c;
    }

    public PreferenceScreen y() {
        return this.b.h();
    }

    protected void z() {
    }
}
