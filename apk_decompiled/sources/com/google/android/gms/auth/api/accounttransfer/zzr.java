package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.tencent.open.SocialOperation;
import defpackage.nj2;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new c();
    private static final HashMap g;
    private final Set a;
    private final int b;
    private zzt c;
    private String d;
    private String e;
    private String f;

    static {
        HashMap map = new HashMap();
        g = map;
        map.put("authenticatorInfo", FastJsonResponse.Field.G0("authenticatorInfo", 2, zzt.class));
        map.put(SocialOperation.GAME_SIGNATURE, FastJsonResponse.Field.J0(SocialOperation.GAME_SIGNATURE, 3));
        map.put("package", FastJsonResponse.Field.J0("package", 4));
    }

    zzr(Set set, int i, zzt zztVar, String str, String str2, String str3) {
        this.a = set;
        this.b = i;
        this.c = zztVar;
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public /* synthetic */ Map a() {
        return g;
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
            return this.d;
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
            nj2.n(parcel, 2, this.c, i, true);
        }
        if (set.contains(3)) {
            nj2.o(parcel, 3, this.d, true);
        }
        if (set.contains(4)) {
            nj2.o(parcel, 4, this.e, true);
        }
        if (set.contains(5)) {
            nj2.o(parcel, 5, this.f, true);
        }
        nj2.b(parcel, iA);
    }
}
