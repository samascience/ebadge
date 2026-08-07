package androidx.preference;

import android.R;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.c73;
import defpackage.h52;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class PreferenceFragment extends Fragment implements androidx.preference.c.InterfaceC0030c, androidx.preference.c.a, androidx.preference.c.b, DialogPreference.a {
    private androidx.preference.c b;
    RecyclerView c;
    private boolean d;
    private boolean e;
    private Context f;
    private Runnable h;
    private final c a = new c();
    private int g = R$layout.preference_list_fragment;
    private final Handler i = new a();
    private final Runnable j = new b();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragment.this.a();
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
            RecyclerView recyclerView = PreferenceFragment.this.c;
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
            PreferenceFragment.this.c.invalidateItemDecorations();
        }

        public void c(int i) {
            this.b = i;
            PreferenceFragment.this.c.invalidateItemDecorations();
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

    private void q() {
        PreferenceScreen preferenceScreenE = e();
        if (preferenceScreenE != null) {
            preferenceScreenE.M();
        }
        k();
    }

    void a() {
        PreferenceScreen preferenceScreenE = e();
        if (preferenceScreenE != null) {
            c().setAdapter(g(preferenceScreenE));
            preferenceScreenE.I();
        }
        f();
    }

    public Fragment b() {
        return null;
    }

    public final RecyclerView c() {
        return this.c;
    }

    @Override // androidx.preference.DialogPreference.a
    public Preference d(CharSequence charSequence) {
        androidx.preference.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.a(charSequence);
    }

    public PreferenceScreen e() {
        return this.b.h();
    }

    protected void f() {
    }

    protected RecyclerView.Adapter g(PreferenceScreen preferenceScreen) {
        return new androidx.preference.b(preferenceScreen);
    }

    public RecyclerView.LayoutManager h() {
        return new LinearLayoutManager(getActivity());
    }

    public abstract void i(Bundle bundle, String str);

    public RecyclerView j(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (this.f.getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R$id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R$layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(h());
        recyclerView2.setAccessibilityDelegateCompat(new h52(recyclerView2));
        return recyclerView2;
    }

    protected void k() {
    }

    @Override // androidx.preference.c.a
    public void l(Preference preference) {
        DialogFragment dialogFragmentI;
        b();
        getActivity();
        if (getFragmentManager().findFragmentByTag("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        if (preference instanceof EditTextPreference) {
            dialogFragmentI = EditTextPreferenceDialogFragment.i(preference.m());
        } else if (preference instanceof ListPreference) {
            dialogFragmentI = ListPreferenceDialogFragment.i(preference.m());
        } else {
            if (!(preference instanceof MultiSelectListPreference)) {
                throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
            }
            dialogFragmentI = MultiSelectListPreferenceDialogFragment.i(preference.m());
        }
        dialogFragmentI.setTargetFragment(this, 0);
        dialogFragmentI.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }

    @Override // androidx.preference.c.b
    public void m(PreferenceScreen preferenceScreen) {
        b();
        getActivity();
    }

    @Override // androidx.preference.c.InterfaceC0030c
    public boolean n(Preference preference) {
        if (preference.j() != null) {
            b();
            getActivity();
        }
        return false;
    }

    public void o(Drawable drawable) {
        this.a.b(drawable);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R$attr.preferenceTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i == 0) {
            i = R$style.PreferenceThemeOverlay;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), i);
        this.f = contextThemeWrapper;
        androidx.preference.c cVar = new androidx.preference.c(contextThemeWrapper);
        this.b = cVar;
        cVar.k(this);
        i(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = this.f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.PreferenceFragment, c73.a(context, R$attr.preferenceFragmentStyle, R.attr.preferenceFragmentStyle), 0);
        this.g = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PreferenceFragment_android_layout, this.g);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.PreferenceFragment_android_divider);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.PreferenceFragment_android_dividerHeight, -1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PreferenceFragment_allowDividerAfterLastItem, true);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(this.f);
        View viewInflate = layoutInflaterCloneInContext.inflate(this.g, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.list_container);
        if (!(viewFindViewById instanceof ViewGroup)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        ViewGroup viewGroup2 = (ViewGroup) viewFindViewById;
        RecyclerView recyclerViewJ = j(layoutInflaterCloneInContext, viewGroup2, bundle);
        if (recyclerViewJ == null) {
            throw new RuntimeException("Could not create RecyclerView");
        }
        this.c = recyclerViewJ;
        recyclerViewJ.addItemDecoration(this.a);
        o(drawable);
        if (dimensionPixelSize != -1) {
            p(dimensionPixelSize);
        }
        this.a.a(z);
        if (this.c.getParent() == null) {
            viewGroup2.addView(this.c);
        }
        this.i.post(this.j);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.i.removeCallbacks(this.j);
        this.i.removeMessages(1);
        if (this.d) {
            q();
        }
        this.c = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen preferenceScreenE = e();
        if (preferenceScreenE != null) {
            Bundle bundle2 = new Bundle();
            preferenceScreenE.b0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.b.l(this);
        this.b.j(this);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.l(null);
        this.b.j(null);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen preferenceScreenE;
        super.onViewCreated(view, bundle);
        if (bundle != null && (bundle2 = bundle.getBundle("android:preferences")) != null && (preferenceScreenE = e()) != null) {
            preferenceScreenE.a0(bundle2);
        }
        if (this.d) {
            a();
            Runnable runnable = this.h;
            if (runnable != null) {
                runnable.run();
                this.h = null;
            }
        }
        this.e = true;
    }

    public void p(int i) {
        this.a.c(i);
    }
}
