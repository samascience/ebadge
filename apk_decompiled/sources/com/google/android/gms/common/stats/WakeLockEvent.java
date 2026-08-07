package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import defpackage.nj2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new a();
    final int a;
    private final long b;
    private int c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final List h;
    private final String i;
    private final long j;
    private int k;
    private final String l;
    private final float m;
    private final long n;
    private final boolean o;
    private long p = -1;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5, boolean z) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = str3;
        this.f = str5;
        this.g = i3;
        this.h = list;
        this.i = str2;
        this.j = j2;
        this.k = i4;
        this.l = str4;
        this.m = f;
        this.n = j3;
        this.o = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int F0() {
        return this.c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long G0() {
        return this.p;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long H0() {
        return this.b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String I0() {
        List list = this.h;
        String str = this.d;
        int i = this.g;
        String str2 = Constants.STR_EMPTY;
        String strJoin = list == null ? Constants.STR_EMPTY : TextUtils.join(",", list);
        int i2 = this.k;
        String str3 = this.e;
        if (str3 == null) {
            str3 = Constants.STR_EMPTY;
        }
        String str4 = this.l;
        if (str4 == null) {
            str4 = Constants.STR_EMPTY;
        }
        float f = this.m;
        String str5 = this.f;
        if (str5 != null) {
            str2 = str5;
        }
        return "\t" + str + "\t" + i + "\t" + strJoin + "\t" + i2 + "\t" + str3 + "\t" + str4 + "\t" + f + "\t" + str2 + "\t" + this.o;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.k(parcel, 2, this.b);
        nj2.o(parcel, 4, this.d, false);
        nj2.h(parcel, 5, this.g);
        nj2.q(parcel, 6, this.h, false);
        nj2.k(parcel, 8, this.j);
        nj2.o(parcel, 10, this.e, false);
        nj2.h(parcel, 11, this.c);
        nj2.o(parcel, 12, this.i, false);
        nj2.o(parcel, 13, this.l, false);
        nj2.h(parcel, 14, this.k);
        nj2.f(parcel, 15, this.m);
        nj2.k(parcel, 16, this.n);
        nj2.o(parcel, 17, this.f, false);
        nj2.c(parcel, 18, this.o);
        nj2.b(parcel, iA);
    }
}
