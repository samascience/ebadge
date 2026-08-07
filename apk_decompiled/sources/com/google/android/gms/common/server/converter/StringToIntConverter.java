package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import defpackage.nj2;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.a {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b();
    private final int a;
    private final HashMap b = new HashMap();
    private final SparseArray c = new SparseArray();
    private final ArrayList d = null;

    StringToIntConverter(int i, ArrayList arrayList) {
        this.a = i;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            zaa zaaVar = (zaa) obj;
            F0(zaaVar.b, zaaVar.c);
        }
    }

    public final StringToIntConverter F0(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
        this.c.put(i, str);
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.a
    public final /* synthetic */ Object u(Object obj) {
        String str = (String) this.c.get(((Integer) obj).intValue());
        return (str == null && this.b.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.b.keySet()) {
            arrayList.add(new zaa(str, ((Integer) this.b.get(str)).intValue()));
        }
        nj2.s(parcel, 2, arrayList, false);
        nj2.b(parcel, iA);
    }

    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new c();
        private final int a;
        final String b;
        final int c;

        zaa(int i, String str, int i2) {
            this.a = i;
            this.b = str;
            this.c = i2;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iA = nj2.a(parcel);
            nj2.h(parcel, 1, this.a);
            nj2.o(parcel, 2, this.b, false);
            nj2.h(parcel, 3, this.c);
            nj2.b(parcel, iA);
        }

        zaa(String str, int i) {
            this.a = 1;
            this.b = str;
            this.c = i;
        }
    }
}
