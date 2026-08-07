package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.lifecycle.l;
import defpackage.d63;
import defpackage.im1;
import defpackage.p31;
import defpackage.wo;
import defpackage.y70;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.u;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final a f = new a(null);
    private static final Class[] g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    private final Map a;
    private final Map b;
    private final Map c;
    private final Map d;
    private final androidx.savedstate.a.c e;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final l a(Bundle bundle, Bundle bundle2) {
            if (bundle == null) {
                if (bundle2 == null) {
                    return new l();
                }
                HashMap map = new HashMap();
                for (String str : bundle2.keySet()) {
                    p31.e(str, "key");
                    map.put(str, bundle2.get(str));
                }
                return new l(map);
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
            if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                throw new IllegalStateException("Invalid bundle passed as restored state");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = parcelableArrayList.get(i);
                p31.d(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
            }
            return new l(linkedHashMap);
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : l.g) {
                p31.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }

        private a() {
        }
    }

    public l(Map map) {
        p31.f(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new androidx.savedstate.a.c() { // from class: vj2
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return l.d(this.a);
            }
        };
        linkedHashMap.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(l lVar) {
        p31.f(lVar, "this$0");
        for (Map.Entry entry : u.n(lVar.b).entrySet()) {
            lVar.e((String) entry.getKey(), ((androidx.savedstate.a.c) entry.getValue()).a());
        }
        Set<String> setKeySet = lVar.a.keySet();
        ArrayList arrayList = new ArrayList(setKeySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : setKeySet) {
            arrayList.add(str);
            arrayList2.add(lVar.a.get(str));
        }
        return wo.a(d63.a("keys", arrayList), d63.a("values", arrayList2));
    }

    public final androidx.savedstate.a.c c() {
        return this.e;
    }

    public final void e(String str, Object obj) {
        p31.f(str, "key");
        if (!f.b(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't put value with type ");
            p31.c(obj);
            sb.append(obj.getClass());
            sb.append(" into saved state");
            throw new IllegalArgumentException(sb.toString());
        }
        Object obj2 = this.c.get(str);
        im1 im1Var = obj2 instanceof im1 ? (im1) obj2 : null;
        if (im1Var != null) {
            im1Var.o(obj);
        } else {
            this.a.put(str, obj);
        }
        MutableStateFlow mutableStateFlow = (MutableStateFlow) this.d.get(str);
        if (mutableStateFlow == null) {
            return;
        }
        mutableStateFlow.setValue(obj);
    }

    public l() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new androidx.savedstate.a.c() { // from class: vj2
            @Override // androidx.savedstate.a.c
            public final Bundle a() {
                return l.d(this.a);
            }
        };
    }
}
