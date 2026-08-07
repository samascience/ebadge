package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new c();
    private final int a;
    private final HashMap b;
    private final ArrayList c = null;
    private final String d;

    zak(int i, ArrayList arrayList, String str) {
        this.a = i;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zalVar = (zal) arrayList.get(i2);
            String str2 = zalVar.b;
            HashMap map2 = new HashMap();
            int size2 = zalVar.c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zamVar = (zam) zalVar.c.get(i3);
                map2.put(zamVar.b, zamVar.c);
            }
            map.put(str2, map2);
        }
        this.b = map;
        this.d = (String) a52.g(str);
        F0();
    }

    public final void F0() {
        Iterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            Map map = (Map) this.b.get((String) it.next());
            Iterator it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse.Field) map.get((String) it2.next())).N0(this);
            }
        }
    }

    public final String G0() {
        return this.d;
    }

    public final Map H0(String str) {
        return (Map) this.b.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.b.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map = (Map) this.b.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.b.keySet()) {
            arrayList.add(new zal(str, (Map) this.b.get(str)));
        }
        nj2.s(parcel, 2, arrayList, false);
        nj2.o(parcel, 3, this.d, false);
        nj2.b(parcel, iA);
    }
}
