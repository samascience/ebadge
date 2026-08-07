package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import defpackage.nj2;

/* JADX INFO: loaded from: classes.dex */
public final class x implements Parcelable.Creator {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, getServiceRequest.a);
        nj2.h(parcel, 2, getServiceRequest.b);
        nj2.h(parcel, 3, getServiceRequest.c);
        nj2.o(parcel, 4, getServiceRequest.d, false);
        nj2.g(parcel, 5, getServiceRequest.e, false);
        nj2.r(parcel, 6, getServiceRequest.f, i, false);
        nj2.d(parcel, 7, getServiceRequest.g, false);
        nj2.n(parcel, 8, getServiceRequest.h, i, false);
        nj2.r(parcel, 10, getServiceRequest.i, i, false);
        nj2.r(parcel, 11, getServiceRequest.j, i, false);
        nj2.c(parcel, 12, getServiceRequest.k);
        nj2.h(parcel, 13, getServiceRequest.l);
        nj2.c(parcel, 14, getServiceRequest.m);
        nj2.o(parcel, 15, getServiceRequest.F0(), false);
        nj2.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iG = SafeParcelReader.G(parcel);
        Scope[] scopeArr = GetServiceRequest.o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.p;
        Feature[] featureArr2 = featureArr;
        int iA = 0;
        int iA2 = 0;
        int iA3 = 0;
        boolean zV = false;
        int iA4 = 0;
        boolean zV2 = false;
        String strO = null;
        IBinder iBinderZ = null;
        Account account = null;
        String strO2 = null;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            switch (SafeParcelReader.u(iY)) {
                case 1:
                    iA = SafeParcelReader.A(parcel, iY);
                    break;
                case 2:
                    iA2 = SafeParcelReader.A(parcel, iY);
                    break;
                case 3:
                    iA3 = SafeParcelReader.A(parcel, iY);
                    break;
                case 4:
                    strO = SafeParcelReader.o(parcel, iY);
                    break;
                case 5:
                    iBinderZ = SafeParcelReader.z(parcel, iY);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.r(parcel, iY, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, iY);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.n(parcel, iY, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.F(parcel, iY);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.r(parcel, iY, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.r(parcel, iY, Feature.CREATOR);
                    break;
                case 12:
                    zV = SafeParcelReader.v(parcel, iY);
                    break;
                case 13:
                    iA4 = SafeParcelReader.A(parcel, iY);
                    break;
                case 14:
                    zV2 = SafeParcelReader.v(parcel, iY);
                    break;
                case 15:
                    strO2 = SafeParcelReader.o(parcel, iY);
                    break;
            }
        }
        SafeParcelReader.t(parcel, iG);
        return new GetServiceRequest(iA, iA2, iA3, strO, iBinderZ, scopeArr, bundle, account, featureArr, featureArr2, zV, iA4, zV2, strO2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
