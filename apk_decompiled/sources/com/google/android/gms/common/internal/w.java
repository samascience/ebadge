package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        Bundle bundleF = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iA = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            int iU = SafeParcelReader.u(iY);
            if (iU == 1) {
                bundleF = SafeParcelReader.f(parcel, iY);
            } else if (iU == 2) {
                featureArr = (Feature[]) SafeParcelReader.r(parcel, iY, Feature.CREATOR);
            } else if (iU == 3) {
                iA = SafeParcelReader.A(parcel, iY);
            } else if (iU != 4) {
                SafeParcelReader.F(parcel, iY);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.n(parcel, iY, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new zzj(bundleF, featureArr, iA, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }
}
