package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import defpackage.nj2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzl extends zzaz {
    public static final Parcelable.Creator<zzl> CREATOR = new a();
    private static final HashMap f;
    private final Set a;
    private final int b;
    private ArrayList c;
    private int d;
    private zzo e;

    static {
        HashMap map = new HashMap();
        f = map;
        map.put("authenticatorData", FastJsonResponse.Field.H0("authenticatorData", 2, zzr.class));
        map.put("progress", FastJsonResponse.Field.G0("progress", 4, zzo.class));
    }

    zzl(Set set, int i, ArrayList arrayList, int i2, zzo zzoVar) {
        this.a = set;
        this.b = i;
        this.c = arrayList;
        this.d = i2;
        this.e = zzoVar;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map a() {
        return f;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final Object b(FastJsonResponse.Field field) {
        int iL0 = field.L0();
        if (iL0 == 1) {
            return Integer.valueOf(this.b);
        }
        if (iL0 == 2) {
            return this.c;
        }
        if (iL0 == 4) {
            return this.e;
        }
        int iL1 = field.L0();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(iL1);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final boolean d(FastJsonResponse.Field field) {
        return this.a.contains(Integer.valueOf(field.L0()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        Set set = this.a;
        if (set.contains(1)) {
            nj2.h(parcel, 1, this.b);
        }
        if (set.contains(2)) {
            nj2.s(parcel, 2, this.c, true);
        }
        if (set.contains(3)) {
            nj2.h(parcel, 3, this.d);
        }
        if (set.contains(4)) {
            nj2.n(parcel, 4, this.e, i, true);
        }
        nj2.b(parcel, iA);
    }
}
