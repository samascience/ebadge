package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import defpackage.nj2;
import defpackage.u9;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new b();
    private static final u9 g;
    private final int a;
    private List b;
    private List c;
    private List d;
    private List e;
    private List f;

    static {
        u9 u9Var = new u9();
        g = u9Var;
        u9Var.put("registered", FastJsonResponse.Field.K0("registered", 2));
        u9Var.put("in_progress", FastJsonResponse.Field.K0("in_progress", 3));
        u9Var.put("success", FastJsonResponse.Field.K0("success", 4));
        u9Var.put("failed", FastJsonResponse.Field.K0("failed", 5));
        u9Var.put("escrowed", FastJsonResponse.Field.K0("escrowed", 6));
    }

    zzo(int i, List list, List list2, List list3, List list4, List list5) {
        this.a = i;
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.e = list4;
        this.f = list5;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map a() {
        return g;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object b(FastJsonResponse.Field field) {
        switch (field.L0()) {
            case 1:
                return Integer.valueOf(this.a);
            case 2:
                return this.b;
            case 3:
                return this.c;
            case 4:
                return this.d;
            case 5:
                return this.e;
            case 6:
                return this.f;
            default:
                int iL0 = field.L0();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(iL0);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean d(FastJsonResponse.Field field) {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.q(parcel, 2, this.b, false);
        nj2.q(parcel, 3, this.c, false);
        nj2.q(parcel, 4, this.d, false);
        nj2.q(parcel, 5, this.e, false);
        nj2.q(parcel, 6, this.f, false);
        nj2.b(parcel, iA);
    }
}
