package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.h00;
import defpackage.jh2;
import defpackage.nj2;
import defpackage.st1;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements jh2, ReflectedParcelable {
    final int a;
    private final int b;
    private final String c;
    private final PendingIntent d;
    private final ConnectionResult e;
    public static final Status f = new Status(-1);
    public static final Status g = new Status(0);
    public static final Status h = new Status(14);
    public static final Status i = new Status(8);
    public static final Status j = new Status(15);
    public static final Status k = new Status(16);
    public static final Status m = new Status(17);
    public static final Status l = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new f();

    Status(int i2, int i3, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.d = pendingIntent;
        this.e = connectionResult;
    }

    public ConnectionResult F0() {
        return this.e;
    }

    public PendingIntent G0() {
        return this.d;
    }

    public int H0() {
        return this.b;
    }

    public String I0() {
        return this.c;
    }

    public boolean J0() {
        return this.d != null;
    }

    public boolean K0() {
        return this.b <= 0;
    }

    public void L0(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (J0()) {
            PendingIntent pendingIntent = this.d;
            a52.g(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public final String M0() {
        String str = this.c;
        return str != null ? str : h00.a(this.b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.a == status.a && this.b == status.b && st1.a(this.c, status.c) && st1.a(this.d, status.d) && st1.a(this.e, status.e);
    }

    public int hashCode() {
        return st1.b(Integer.valueOf(this.a), Integer.valueOf(this.b), this.c, this.d, this.e);
    }

    @Override // defpackage.jh2
    public Status n() {
        return this;
    }

    public String toString() {
        st1.a aVarC = st1.c(this);
        aVarC.a("statusCode", M0());
        aVarC.a("resolution", this.d);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, H0());
        nj2.o(parcel, 2, I0(), false);
        nj2.n(parcel, 3, this.d, i2, false);
        nj2.n(parcel, 4, F0(), i2, false);
        nj2.h(parcel, 1000, this.a);
        nj2.b(parcel, iA);
    }

    public Status(int i2) {
        this(i2, null);
    }

    public Status(int i2, String str) {
        this(1, i2, str, null, null);
    }

    public Status(int i2, String str, PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent, null);
    }
}
