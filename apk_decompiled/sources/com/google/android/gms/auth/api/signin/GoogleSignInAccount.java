package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.jieli.jl_rcsp.BuildConfig;
import defpackage.a52;
import defpackage.ly;
import defpackage.nj2;
import defpackage.v70;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new d();
    private static ly n = v70.b();
    private final int a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Uri f;
    private String g;
    private long h;
    private String i;
    private List j;
    private String k;
    private String l;
    private Set m = new HashSet();

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List list, String str7, String str8) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = uri;
        this.g = str5;
        this.h = j;
        this.i = str6;
        this.j = list;
        this.k = str7;
        this.l = str8;
    }

    public static GoogleSignInAccount P0(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl", null);
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount googleSignInAccountQ0 = Q0(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), uri, Long.valueOf(j), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountQ0.g = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccountQ0;
    }

    private static GoogleSignInAccount Q0(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, (l == null ? Long.valueOf(n.a() / 1000) : l).longValue(), a52.e(str7), new ArrayList((Collection) a52.g(set)), str5, str6);
    }

    private final JSONObject T0() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (J0() != null) {
                jSONObject.put("id", J0());
            }
            if (K0() != null) {
                jSONObject.put("tokenId", K0());
            }
            if (G0() != null) {
                jSONObject.put("email", G0());
            }
            if (F0() != null) {
                jSONObject.put("displayName", F0());
            }
            if (I0() != null) {
                jSONObject.put("givenName", I0());
            }
            if (H0() != null) {
                jSONObject.put("familyName", H0());
            }
            if (L0() != null) {
                jSONObject.put("photoUrl", L0().toString());
            }
            if (N0() != null) {
                jSONObject.put("serverAuthCode", N0());
            }
            jSONObject.put("expirationTime", this.h);
            jSONObject.put("obfuscatedIdentifier", this.i);
            JSONArray jSONArray = new JSONArray();
            List list = this.j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, c.a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.F0());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String F0() {
        return this.e;
    }

    public String G0() {
        return this.d;
    }

    public String H0() {
        return this.l;
    }

    public String I0() {
        return this.k;
    }

    public String J0() {
        return this.b;
    }

    public String K0() {
        return this.c;
    }

    public Uri L0() {
        return this.f;
    }

    public Set M0() {
        HashSet hashSet = new HashSet(this.j);
        hashSet.addAll(this.m);
        return hashSet;
    }

    public String N0() {
        return this.g;
    }

    public final String R0() {
        return this.i;
    }

    public final String S0() {
        JSONObject jSONObjectT0 = T0();
        jSONObjectT0.remove("serverAuthCode");
        return jSONObjectT0.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.i.equals(this.i) && googleSignInAccount.M0().equals(M0());
    }

    public int hashCode() {
        return ((this.i.hashCode() + BuildConfig.VERSION_CODE) * 31) + M0().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.o(parcel, 2, J0(), false);
        nj2.o(parcel, 3, K0(), false);
        nj2.o(parcel, 4, G0(), false);
        nj2.o(parcel, 5, F0(), false);
        nj2.n(parcel, 6, L0(), i, false);
        nj2.o(parcel, 7, N0(), false);
        nj2.k(parcel, 8, this.h);
        nj2.o(parcel, 9, this.i, false);
        nj2.s(parcel, 10, this.j, false);
        nj2.o(parcel, 11, I0(), false);
        nj2.o(parcel, 12, H0(), false);
        nj2.b(parcel, iA);
    }
}
