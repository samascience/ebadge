package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.fw0;
import defpackage.nj2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements com.google.android.gms.common.api.a.d.InterfaceC0076a, com.google.android.gms.common.api.a.d, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
    public static final Scope k = new Scope("profile");
    public static final Scope l = new Scope("email");
    public static final Scope m = new Scope("openid");
    public static final Scope n;
    public static final Scope o;
    public static final GoogleSignInOptions p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final GoogleSignInOptions f237q;
    private static Comparator r;
    private final int a;
    private final ArrayList b;
    private Account c;
    private boolean d;
    private final boolean e;
    private final boolean f;
    private String g;
    private String h;
    private ArrayList i;
    private Map j;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        n = scope;
        o = new Scope("https://www.googleapis.com/auth/games");
        p = new a().c().d().a();
        f237q = new a().e(scope, new Scope[0]).a();
        CREATOR = new f();
        r = new e();
    }

    GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, N0(arrayList2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map N0(List list) {
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
            map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.F0()), googleSignInOptionsExtensionParcelable);
        }
        return map;
    }

    public static GoogleSignInOptions O0(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    private final JSONObject S0() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.b, r);
            ArrayList arrayList = this.b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).F0());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.d);
            jSONObject.put("forceCodeForRefreshToken", this.f);
            jSONObject.put("serverAuthRequested", this.e);
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put("serverClientId", this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put("hostedDomain", this.h);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public Account F0() {
        return this.c;
    }

    public ArrayList G0() {
        return this.i;
    }

    public ArrayList H0() {
        return new ArrayList(this.b);
    }

    public String I0() {
        return this.g;
    }

    public boolean J0() {
        return this.f;
    }

    public boolean K0() {
        return this.d;
    }

    public boolean L0() {
        return this.e;
    }

    public final String U0() {
        return S0().toString();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0051 A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x005b  */
    /* JADX WARN: Code duplicated, block: B:27:0x005c A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0068 A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0070 A[Catch: ClassCastException -> 0x0082, TryCatch #0 {ClassCastException -> 0x0082, blocks: (B:5:0x0004, B:7:0x000e, B:10:0x0017, B:12:0x0027, B:15:0x0034, B:17:0x0038, B:22:0x0049, B:24:0x0051, B:29:0x0068, B:31:0x0070, B:33:0x0078, B:27:0x005c, B:20:0x003f), top: B:39:0x0004 }] */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.i.size() <= 0 && googleSignInOptions.i.size() <= 0 && this.b.size() == googleSignInOptions.H0().size() && this.b.containsAll(googleSignInOptions.H0())) {
                Account account = this.c;
                if (account == null) {
                    if (googleSignInOptions.F0() == null) {
                        if (TextUtils.isEmpty(this.g)) {
                            if (TextUtils.isEmpty(googleSignInOptions.I0())) {
                                if (this.f != googleSignInOptions.J0() && this.d == googleSignInOptions.K0() && this.e == googleSignInOptions.L0()) {
                                    return true;
                                }
                            }
                        } else if (this.g.equals(googleSignInOptions.I0())) {
                            if (this.f != googleSignInOptions.J0()) {
                            }
                        }
                    }
                } else if (account.equals(googleSignInOptions.F0())) {
                    if (TextUtils.isEmpty(this.g)) {
                        if (TextUtils.isEmpty(googleSignInOptions.I0())) {
                            if (this.f != googleSignInOptions.J0()) {
                            }
                        }
                    } else if (this.g.equals(googleSignInOptions.I0())) {
                        if (this.f != googleSignInOptions.J0()) {
                        }
                    }
                }
            }
        } catch (ClassCastException unused) {
        }
        return false;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.b;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).F0());
        }
        Collections.sort(arrayList);
        return new fw0().a(arrayList).a(this.c).a(this.g).c(this.f).c(this.d).c(this.e).b();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.s(parcel, 2, H0(), false);
        nj2.n(parcel, 3, F0(), i, false);
        nj2.c(parcel, 4, K0());
        nj2.c(parcel, 5, L0());
        nj2.c(parcel, 6, J0());
        nj2.o(parcel, 7, I0(), false);
        nj2.o(parcel, 8, this.h, false);
        nj2.s(parcel, 9, G0(), false);
        nj2.b(parcel, iA);
    }

    public static final class a {
        private Set a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;
        private String g;
        private Map h;

        public a() {
            this.a = new HashSet();
            this.h = new HashMap();
        }

        public final GoogleSignInOptions a() {
            if (this.a.contains(GoogleSignInOptions.o)) {
                Set set = this.a;
                Scope scope = GoogleSignInOptions.n;
                if (set.contains(scope)) {
                    this.a.remove(scope);
                }
            }
            if (this.d && (this.f == null || !this.a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.a), this.f, this.d, this.b, this.c, this.e, this.g, this.h, null);
        }

        public final a b() {
            this.a.add(GoogleSignInOptions.l);
            return this;
        }

        public final a c() {
            this.a.add(GoogleSignInOptions.m);
            return this;
        }

        public final a d() {
            this.a.add(GoogleSignInOptions.k);
            return this;
        }

        public final a e(Scope scope, Scope... scopeArr) {
            this.a.add(scope);
            this.a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            this.a = new HashSet();
            this.h = new HashMap();
            a52.g(googleSignInOptions);
            this.a = new HashSet(googleSignInOptions.b);
            this.b = googleSignInOptions.e;
            this.c = googleSignInOptions.f;
            this.d = googleSignInOptions.d;
            this.e = googleSignInOptions.g;
            this.f = googleSignInOptions.c;
            this.g = googleSignInOptions.h;
            this.h = GoogleSignInOptions.N0(googleSignInOptions.i);
        }
    }

    private GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map) {
        this.a = i;
        this.b = arrayList;
        this.c = account;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = str;
        this.h = str2;
        this.i = new ArrayList(map.values());
        this.j = map;
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, e eVar) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }
}
