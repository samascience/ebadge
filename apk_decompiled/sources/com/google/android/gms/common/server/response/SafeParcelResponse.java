package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import defpackage.a52;
import defpackage.ca;
import defpackage.nj2;
import defpackage.sf1;
import defpackage.v71;
import defpackage.zf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new e();
    private final int a;
    private final Parcel b;
    private final int c = 2;
    private final zak d;
    private final String e;
    private int f;
    private int g;

    SafeParcelResponse(int i, Parcel parcel, zak zakVar) {
        this.a = i;
        this.b = (Parcel) a52.g(parcel);
        this.d = zakVar;
        if (zakVar == null) {
            this.e = null;
        } else {
            this.e = zakVar.G0();
        }
        this.f = 2;
    }

    private static void h(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                sb.append(v71.a(obj.toString()));
                sb.append("\"");
                return;
            case 8:
                sb.append("\"");
                sb.append(zf.a((byte[]) obj));
                sb.append("\"");
                return;
            case 9:
                sb.append("\"");
                sb.append(zf.b((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                sf1.a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final void i(StringBuilder sb, Map map, Parcel parcel) {
        SparseArray sparseArray = new SparseArray();
        for (Map.Entry entry : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) entry.getValue()).L0(), entry);
        }
        sb.append('{');
        int iG = SafeParcelReader.G(parcel);
        boolean z = false;
        while (parcel.dataPosition() < iG) {
            int iY = SafeParcelReader.y(parcel);
            Map.Entry entry2 = (Map.Entry) sparseArray.get(SafeParcelReader.u(iY));
            if (entry2 != null) {
                if (z) {
                    sb.append(",");
                }
                String str = (String) entry2.getKey();
                FastJsonResponse.Field field = (FastJsonResponse.Field) entry2.getValue();
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (field.P0()) {
                    switch (field.d) {
                        case 0:
                            j(sb, field, FastJsonResponse.g(field, Integer.valueOf(SafeParcelReader.A(parcel, iY))));
                            break;
                        case 1:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.c(parcel, iY)));
                            break;
                        case 2:
                            j(sb, field, FastJsonResponse.g(field, Long.valueOf(SafeParcelReader.C(parcel, iY))));
                            break;
                        case 3:
                            j(sb, field, FastJsonResponse.g(field, Float.valueOf(SafeParcelReader.x(parcel, iY))));
                            break;
                        case 4:
                            j(sb, field, FastJsonResponse.g(field, Double.valueOf(SafeParcelReader.w(parcel, iY))));
                            break;
                        case 5:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.a(parcel, iY)));
                            break;
                        case 6:
                            j(sb, field, FastJsonResponse.g(field, Boolean.valueOf(SafeParcelReader.v(parcel, iY))));
                            break;
                        case 7:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.o(parcel, iY)));
                            break;
                        case 8:
                        case 9:
                            j(sb, field, FastJsonResponse.g(field, SafeParcelReader.g(parcel, iY)));
                            break;
                        case 10:
                            Bundle bundleF = SafeParcelReader.f(parcel, iY);
                            HashMap map2 = new HashMap();
                            for (String str2 : bundleF.keySet()) {
                                map2.put(str2, bundleF.getString(str2));
                            }
                            j(sb, field, FastJsonResponse.g(field, map2));
                            break;
                        case 11:
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        default:
                            int i = field.d;
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(i);
                            throw new IllegalArgumentException(sb2.toString());
                    }
                } else if (field.e) {
                    sb.append("[");
                    switch (field.d) {
                        case 0:
                            ca.d(sb, SafeParcelReader.j(parcel, iY));
                            break;
                        case 1:
                            ca.f(sb, SafeParcelReader.d(parcel, iY));
                            break;
                        case 2:
                            ca.e(sb, SafeParcelReader.k(parcel, iY));
                            break;
                        case 3:
                            ca.c(sb, SafeParcelReader.i(parcel, iY));
                            break;
                        case 4:
                            ca.b(sb, SafeParcelReader.h(parcel, iY));
                            break;
                        case 5:
                            ca.f(sb, SafeParcelReader.b(parcel, iY));
                            break;
                        case 6:
                            ca.g(sb, SafeParcelReader.e(parcel, iY));
                            break;
                        case 7:
                            ca.h(sb, SafeParcelReader.p(parcel, iY));
                            break;
                        case 8:
                        case 9:
                        case 10:
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        case 11:
                            Parcel[] parcelArrM = SafeParcelReader.m(parcel, iY);
                            int length = parcelArrM.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (i2 > 0) {
                                    sb.append(",");
                                }
                                parcelArrM[i2].setDataPosition(0);
                                i(sb, field.R0(), parcelArrM[i2]);
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out.");
                    }
                    sb.append("]");
                } else {
                    switch (field.d) {
                        case 0:
                            sb.append(SafeParcelReader.A(parcel, iY));
                            break;
                        case 1:
                            sb.append(SafeParcelReader.c(parcel, iY));
                            break;
                        case 2:
                            sb.append(SafeParcelReader.C(parcel, iY));
                            break;
                        case 3:
                            sb.append(SafeParcelReader.x(parcel, iY));
                            break;
                        case 4:
                            sb.append(SafeParcelReader.w(parcel, iY));
                            break;
                        case 5:
                            sb.append(SafeParcelReader.a(parcel, iY));
                            break;
                        case 6:
                            sb.append(SafeParcelReader.v(parcel, iY));
                            break;
                        case 7:
                            String strO = SafeParcelReader.o(parcel, iY);
                            sb.append("\"");
                            sb.append(v71.a(strO));
                            sb.append("\"");
                            break;
                        case 8:
                            byte[] bArrG = SafeParcelReader.g(parcel, iY);
                            sb.append("\"");
                            sb.append(zf.a(bArrG));
                            sb.append("\"");
                            break;
                        case 9:
                            byte[] bArrG2 = SafeParcelReader.g(parcel, iY);
                            sb.append("\"");
                            sb.append(zf.b(bArrG2));
                            sb.append("\"");
                            break;
                        case 10:
                            Bundle bundleF2 = SafeParcelReader.f(parcel, iY);
                            Set<String> setKeySet = bundleF2.keySet();
                            setKeySet.size();
                            sb.append("{");
                            boolean z2 = true;
                            for (String str3 : setKeySet) {
                                if (!z2) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(str3);
                                sb.append("\"");
                                sb.append(":");
                                sb.append("\"");
                                sb.append(v71.a(bundleF2.getString(str3)));
                                sb.append("\"");
                                z2 = false;
                            }
                            sb.append("}");
                            break;
                        case 11:
                            Parcel parcelL = SafeParcelReader.l(parcel, iY);
                            parcelL.setDataPosition(0);
                            i(sb, field.R0(), parcelL);
                            break;
                        default:
                            throw new IllegalStateException("Unknown field type out");
                    }
                }
                z = true;
            }
        }
        if (parcel.dataPosition() == iG) {
            sb.append('}');
            return;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(iG);
        throw new SafeParcelReader.ParseException(sb3.toString(), parcel);
    }

    private final void j(StringBuilder sb, FastJsonResponse.Field field, Object obj) {
        if (!field.c) {
            h(sb, field.b, obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            h(sb, field.b, arrayList.get(i));
        }
        sb.append("]");
    }

    private final Parcel k() {
        int i = this.f;
        if (i != 0) {
            if (i == 1) {
            }
            return this.b;
        }
        this.g = nj2.a(this.b);
        nj2.b(this.b, this.g);
        this.f = 2;
        return this.b;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map a() {
        zak zakVar = this.d;
        if (zakVar == null) {
            return null;
        }
        return zakVar.H0(this.e);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object c(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean e(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        a52.h(this.d, "Cannot convert to JSON on client side.");
        Parcel parcelK = k();
        parcelK.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        i(sb, this.d.H0(this.e), parcelK);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zak zakVar;
        int iA = nj2.a(parcel);
        nj2.h(parcel, 1, this.a);
        nj2.m(parcel, 2, k(), false);
        int i2 = this.c;
        if (i2 == 0) {
            zakVar = null;
        } else {
            if (i2 != 1 && i2 != 2) {
                int i3 = this.c;
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
            zakVar = this.d;
        }
        nj2.n(parcel, 3, zakVar, i, false);
        nj2.b(parcel, iA);
    }
}
