package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import defpackage.nj2;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new d();
    private static final HashMap h;
    private final Set a;
    private final int b;
    private String c;
    private int d;
    private byte[] e;
    private PendingIntent f;
    private DeviceMetaData g;

    static {
        HashMap map = new HashMap();
        h = map;
        map.put("accountType", FastJsonResponse.Field.J0("accountType", 2));
        map.put("status", FastJsonResponse.Field.I0("status", 3));
        map.put("transferBytes", FastJsonResponse.Field.F0("transferBytes", 4));
    }

    zzt(Set set, int i, String str, int i2, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.a = set;
        this.b = i;
        this.c = str;
        this.d = i2;
        this.e = bArr;
        this.f = pendingIntent;
        this.g = deviceMetaData;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map a() {
        return h;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object b(FastJsonResponse.Field field) {
        int iL0 = field.L0();
        if (iL0 == 1) {
            return Integer.valueOf(this.b);
        }
        if (iL0 == 2) {
            return this.c;
        }
        if (iL0 == 3) {
            return Integer.valueOf(this.d);
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
    protected boolean d(FastJsonResponse.Field field) {
        return this.a.contains(Integer.valueOf(field.L0()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        Set set = this.a;
        if (set.contains(1)) {
            nj2.h(parcel, 1, this.b);
        }
        if (set.contains(2)) {
            nj2.o(parcel, 2, this.c, true);
        }
        if (set.contains(3)) {
            nj2.h(parcel, 3, this.d);
        }
        if (set.contains(4)) {
            nj2.e(parcel, 4, this.e, true);
        }
        if (set.contains(5)) {
            nj2.n(parcel, 5, this.f, i, true);
        }
        if (set.contains(6)) {
            nj2.n(parcel, 6, this.g, i, true);
        }
        nj2.b(parcel, iA);
    }
}
