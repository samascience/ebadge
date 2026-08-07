package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.jieli.jl_rcsp.BuildConfig;
import defpackage.be3;
import defpackage.v8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends RecyclerView.Adapter implements Preference.b {
    private PreferenceGroup a;
    private List b;
    private List c;
    private List d;
    private Runnable f = new a();
    private Handler e = new Handler();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.j();
        }
    }

    /* JADX INFO: renamed from: androidx.preference.b$b, reason: collision with other inner class name */
    class C0029b implements Preference.c {
        final /* synthetic */ PreferenceGroup a;

        C0029b(PreferenceGroup preferenceGroup) {
            this.a = preferenceGroup;
        }

        @Override // androidx.preference.Preference.c
        public boolean a(Preference preference) {
            this.a.y0(Integer.MAX_VALUE);
            b.this.a(preference);
            this.a.u0();
            return true;
        }
    }

    private static class c {
        int a;
        int b;
        String c;

        c(Preference preference) {
            this.c = preference.getClass().getName();
            this.a = preference.n();
            this.b = preference.y();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && TextUtils.equals(this.c, cVar.c);
        }

        public int hashCode() {
            return ((((BuildConfig.VERSION_CODE + this.a) * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public b(PreferenceGroup preferenceGroup) {
        this.a = preferenceGroup;
        this.a.g0(this);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.a;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).A0());
        } else {
            setHasStableIds(true);
        }
        j();
    }

    private androidx.preference.a c(PreferenceGroup preferenceGroup, List list) {
        androidx.preference.a aVar = new androidx.preference.a(preferenceGroup.g(), list, preferenceGroup.k());
        aVar.h0(new C0029b(preferenceGroup));
        return aVar;
    }

    private List d(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iW0 = preferenceGroup.w0();
        int i = 0;
        for (int i2 = 0; i2 < iW0; i2++) {
            Preference preferenceV0 = preferenceGroup.v0(i2);
            if (preferenceV0.E()) {
                if (!g(preferenceGroup) || i < preferenceGroup.t0()) {
                    arrayList.add(preferenceV0);
                } else {
                    arrayList2.add(preferenceV0);
                }
                if (preferenceV0 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceV0;
                    if (!preferenceGroup2.x0()) {
                        continue;
                    } else {
                        if (g(preferenceGroup) && g(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference : d(preferenceGroup2)) {
                            if (!g(preferenceGroup) || i < preferenceGroup.t0()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i++;
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        if (g(preferenceGroup) && i > preferenceGroup.t0()) {
            arrayList.add(c(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void e(List list, PreferenceGroup preferenceGroup) {
        preferenceGroup.z0();
        int iW0 = preferenceGroup.w0();
        for (int i = 0; i < iW0; i++) {
            Preference preferenceV0 = preferenceGroup.v0(i);
            list.add(preferenceV0);
            c cVar = new c(preferenceV0);
            if (!this.d.contains(cVar)) {
                this.d.add(cVar);
            }
            if (preferenceV0 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceV0;
                if (preferenceGroup2.x0()) {
                    e(list, preferenceGroup2);
                }
            }
            preferenceV0.g0(this);
        }
    }

    private boolean g(PreferenceGroup preferenceGroup) {
        return preferenceGroup.t0() != Integer.MAX_VALUE;
    }

    @Override // androidx.preference.Preference.b
    public void a(Preference preference) {
        this.e.removeCallbacks(this.f);
        this.e.post(this.f);
    }

    @Override // androidx.preference.Preference.b
    public void b(Preference preference) {
        int iIndexOf = this.c.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    public Preference f(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return (Preference) this.c.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (hasStableIds()) {
            return f(i).k();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        c cVar = new c(f(i));
        int iIndexOf = this.d.indexOf(cVar);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.d.size();
        this.d.add(cVar);
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d dVar, int i) {
        f(i).J(dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        c cVar = (c) this.d.get(i);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.BackgroundStyle);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = v8.b(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(cVar.a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            be3.t0(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i2 = cVar.b;
            if (i2 != 0) {
                layoutInflaterFrom.inflate(i2, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new d(viewInflate);
    }

    void j() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((Preference) it.next()).g0(null);
        }
        ArrayList arrayList = new ArrayList(this.b.size());
        this.b = arrayList;
        e(arrayList, this.a);
        this.c = d(this.a);
        androidx.preference.c cVarU = this.a.u();
        if (cVarU != null) {
            cVarU.f();
        }
        notifyDataSetChanged();
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            ((Preference) it2.next()).b();
        }
    }
}
