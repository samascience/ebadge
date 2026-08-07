package com.baidu.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import defpackage.fq3;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class BDLocation implements Parcelable {
    public static final Parcelable.Creator<BDLocation> CREATOR = new e();
    private String F;
    private String G;
    private double H;
    private boolean I;
    private int J;
    private int K;
    private String L;
    private int M;
    private String N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private String S;
    private String T;
    private String U;
    private int V;
    private List W;
    private String X;
    private String Y;
    private String Z;
    private int a;
    private Bundle a0;
    private String b;
    private int b0;
    private double c;
    private int c0;
    private double d;
    private long d0;
    private boolean e;
    private String e0;
    private double f;
    private String f0;
    private boolean g;
    private double g0;
    private float h;
    private double h0;
    private boolean i;
    private boolean i0;
    private float j;
    private PoiRegion j0;
    private String k;
    private float k0;
    private float l;
    private double l0;
    private int m;
    private int m0;
    private float n;
    private int n0;
    private boolean o;
    private BDLocation o0;
    private int p;
    private Bundle p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f213q;
    private String q0;
    private String r;
    private boolean s;
    private String t;
    private String u;
    private String v;
    private String w;
    private boolean x;
    private b y;
    private String z;

    public BDLocation() {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.f213q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new b.a().m();
        this.z = null;
        this.F = null;
        this.G = null;
        this.I = false;
        this.J = 0;
        this.K = 1;
        this.L = null;
        this.N = Constants.STR_EMPTY;
        this.O = -1;
        this.P = 0;
        this.Q = 2;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = new Bundle();
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0L;
        this.e0 = null;
        this.f0 = null;
        this.g0 = Double.MIN_VALUE;
        this.h0 = Double.MIN_VALUE;
        this.i0 = false;
        this.j0 = null;
        this.k0 = -1.0f;
        this.l0 = -1.0d;
        this.m0 = 0;
        this.n0 = -1;
        this.p0 = null;
        this.q0 = null;
    }

    private void a(Boolean bool) {
        this.x = bool.booleanValue();
    }

    public void A(float f) {
        this.f213q = f;
    }

    public void B(double d) {
        this.l0 = d;
    }

    public void E(Bundle bundle) {
        this.p0 = bundle == null ? null : new Bundle(bundle);
    }

    public void F(String str) {
        this.q0 = str;
    }

    public void G(int i) {
        this.c0 = i;
    }

    public void H(int i) {
        this.V = i;
    }

    public void I(int i) {
        this.R = i;
    }

    public void J(int i) {
        this.P = i;
    }

    public void K(String str) {
        this.U = str;
    }

    public void L(boolean z) {
        this.i0 = z;
    }

    public void M(int i) {
        this.m = i;
    }

    public void N(double d) {
        this.c = d;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    public void O(int i) {
        String str;
        this.a = i;
        if (i == 66) {
            str = "Offline location successful!";
        } else if (i == 67) {
            str = "Offline location failed, please check the net (wifi/cell)!";
        } else if (i == 161) {
            str = "NetWork location successful!";
        } else if (i == 162) {
            str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
        } else if (i == 167) {
            str = "NetWork location failed because baidu location service can not caculate the location!";
        } else if (i != 505) {
            switch (i) {
                case 61:
                    P("GPS location successful!");
                    p0(0);
                    F("system");
                    return;
                case 62:
                    str = "Location failed beacuse we can not get any loc information!";
                    break;
                case 63:
                    str = "Offline location failed, please check the net (wifi/cell)!";
                    break;
                default:
                    str = "UnKnown!";
                    break;
            }
        } else {
            str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
        }
        P(str);
    }

    public void P(String str) {
        this.X = str;
    }

    public void Q(String str) {
        this.u = str;
    }

    public void R(String str) {
        this.Y = str;
    }

    public void S(int i) {
        this.K = i;
    }

    public void T(double d) {
        this.d = d;
    }

    public void U(int i) {
        this.n0 = i;
    }

    public void W(int i) {
        this.m0 = i;
    }

    public void X(int i) {
        this.M = i;
    }

    public void Y(List list) {
        this.W = list;
    }

    public void Z(PoiRegion poiRegion) {
        this.j0 = poiRegion;
    }

    public b b() {
        return this.y;
    }

    public void b0(float f) {
        this.j = f;
        this.i = true;
    }

    public String c() {
        return this.r;
    }

    public void c0(BDLocation bDLocation) {
        if (j() > 0) {
            this.o0 = bDLocation;
        }
    }

    public Bundle d() {
        return this.p0;
    }

    public void d0(float f, float f2, String str) {
        double d = f;
        String str2 = Constants.STR_EMPTY;
        String str3 = d > 0.001d ? String.format("%.2f", Float.valueOf(f)) : Constants.STR_EMPTY;
        if (f2 > 0.001d) {
            str2 = String.format("%.2f", Float.valueOf(f2));
        }
        String str4 = this.e0;
        if (str4 != null) {
            Locale locale = Locale.US;
            String str5 = String.format(locale, "%s|%s,%s", str4, str3, str2);
            this.Z = str5;
            String str6 = this.f0;
            if (str6 != null) {
                this.Z = String.format(locale, "%s|%s", str5, str6);
            }
        }
        if (str != null) {
            this.Z = String.format(Locale.US, "%s|%s", this.Z, str);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e() {
        return this.k0;
    }

    public double f() {
        return this.c;
    }

    public void f0(int i) {
        this.p = i;
    }

    public int g() {
        return this.a;
    }

    public String h() {
        return this.u;
    }

    public void h0(float f) {
        this.h = f;
        this.g = true;
    }

    public double i() {
        return this.d;
    }

    public void i0(String str) {
        this.b = str;
        R(fq3.i(str));
    }

    public int j() {
        return this.m0;
    }

    public String k() {
        return this.L;
    }

    public List l() {
        return this.W;
    }

    public void l0(String str) {
        this.k = str;
    }

    public PoiRegion m() {
        return this.j0;
    }

    public float n() {
        return this.j;
    }

    public void n0(float f) {
        this.l = f;
    }

    public String o() {
        return this.b;
    }

    public void o0(float f) {
        this.n = f;
    }

    public String p() {
        return this.k;
    }

    public void p0(int i) {
        this.O = i;
    }

    public int q() {
        return this.O;
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.i0;
    }

    public void t(b bVar) {
        if (bVar != null) {
            this.y = bVar;
            this.s = true;
        }
    }

    public String toString() {
        return "&loctype=" + g() + "&lat=" + f() + "&lon=" + i() + "&radius=" + n() + "&biasprob=" + e() + "&extrainfo=" + d();
    }

    public void u(String str) {
        this.t = str;
        this.s = str != null;
    }

    public void v(double d) {
        if (d < 9999.0d) {
            this.f = d;
            this.e = true;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.f);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.j);
        parcel.writeString(this.k);
        parcel.writeFloat(this.l);
        parcel.writeInt(this.m);
        parcel.writeFloat(this.n);
        parcel.writeInt(this.p);
        parcel.writeFloat(this.f213q);
        parcel.writeString(this.z);
        parcel.writeInt(this.J);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeDouble(this.H);
        parcel.writeString(this.L);
        parcel.writeString(this.y.c);
        parcel.writeString(this.y.d);
        parcel.writeString(this.y.f);
        parcel.writeString(this.y.g);
        parcel.writeString(this.y.h);
        parcel.writeString(this.y.e);
        parcel.writeString(this.y.i);
        parcel.writeString(this.y.a);
        parcel.writeString(this.y.b);
        parcel.writeString(this.y.j);
        parcel.writeString(this.y.k);
        parcel.writeInt(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeInt(this.K);
        parcel.writeString(this.X);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeString(this.S);
        parcel.writeString(this.T);
        parcel.writeString(this.U);
        parcel.writeInt(this.V);
        parcel.writeInt(this.b0);
        parcel.writeString(this.Y);
        parcel.writeInt(this.c0);
        parcel.writeString(this.Z);
        parcel.writeString(this.e0);
        parcel.writeString(this.f0);
        parcel.writeLong(this.d0);
        parcel.writeDouble(this.g0);
        parcel.writeDouble(this.h0);
        parcel.writeFloat(this.k0);
        parcel.writeDouble(this.l0);
        parcel.writeInt(this.m0);
        parcel.writeInt(this.n0);
        parcel.writeString(this.r);
        parcel.writeString(this.q0);
        parcel.writeParcelable(this.o0, i);
        parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.o, this.s, this.x, this.I, this.i0});
        parcel.writeList(this.W);
        parcel.writeBundle(this.a0);
        parcel.writeBundle(this.p0);
        parcel.writeParcelable(this.j0, i);
    }

    public void x(String str) {
        this.r = str;
    }

    public void z(long j) {
        this.d0 = j;
    }

    private BDLocation(Parcel parcel) {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.f213q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new b.a().m();
        this.z = null;
        this.F = null;
        this.G = null;
        this.I = false;
        this.J = 0;
        this.K = 1;
        this.L = null;
        this.N = Constants.STR_EMPTY;
        this.O = -1;
        this.P = 0;
        this.Q = 2;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = new Bundle();
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0L;
        this.e0 = null;
        this.f0 = null;
        this.g0 = Double.MIN_VALUE;
        this.h0 = Double.MIN_VALUE;
        this.i0 = false;
        this.j0 = null;
        this.k0 = -1.0f;
        this.l0 = -1.0d;
        this.m0 = 0;
        this.n0 = -1;
        this.p0 = null;
        this.q0 = null;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.k = parcel.readString();
        this.l = parcel.readFloat();
        this.m = parcel.readInt();
        this.n = parcel.readFloat();
        this.p = parcel.readInt();
        this.f213q = parcel.readFloat();
        this.z = parcel.readString();
        this.J = parcel.readInt();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readDouble();
        this.L = parcel.readString();
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        String string4 = parcel.readString();
        String string5 = parcel.readString();
        String string6 = parcel.readString();
        parcel.readString();
        String string7 = parcel.readString();
        String string8 = parcel.readString();
        String string9 = parcel.readString();
        this.y = new b.a().p(string7).q(string8).s(string).n(string2).o(string6).r(string3).t(string4).u(string5).l(string9).v(parcel.readString()).m();
        boolean[] zArr = new boolean[8];
        this.M = parcel.readInt();
        this.N = parcel.readString();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.K = parcel.readInt();
        this.X = parcel.readString();
        this.O = parcel.readInt();
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readString();
        this.T = parcel.readString();
        this.U = parcel.readString();
        this.V = parcel.readInt();
        this.b0 = parcel.readInt();
        this.Y = parcel.readString();
        this.c0 = parcel.readInt();
        this.Z = parcel.readString();
        this.e0 = parcel.readString();
        this.f0 = parcel.readString();
        this.d0 = parcel.readLong();
        this.g0 = parcel.readDouble();
        this.h0 = parcel.readDouble();
        this.k0 = parcel.readFloat();
        this.l0 = parcel.readDouble();
        this.m0 = parcel.readInt();
        this.n0 = parcel.readInt();
        this.r = parcel.readString();
        this.q0 = parcel.readString();
        try {
            this.o0 = (BDLocation) parcel.readParcelable(BDLocation.class.getClassLoader());
        } catch (Exception e) {
            this.o0 = null;
            e.printStackTrace();
        }
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.o = zArr[3];
            this.s = zArr[4];
            this.x = zArr[5];
            this.I = zArr[6];
            this.i0 = zArr[7];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            parcel.readList(arrayList, Poi.class.getClassLoader());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (arrayList.size() == 0) {
            this.W = null;
        } else {
            this.W = arrayList;
        }
        try {
            this.a0 = parcel.readBundle();
        } catch (Exception e3) {
            e3.printStackTrace();
            this.a0 = new Bundle();
        }
        try {
            this.p0 = parcel.readBundle();
        } catch (Exception e4) {
            e4.printStackTrace();
            this.p0 = new Bundle();
        }
        try {
            this.j0 = (PoiRegion) parcel.readParcelable(PoiRegion.class.getClassLoader());
        } catch (Exception e5) {
            this.j0 = null;
            e5.printStackTrace();
        }
    }

    /* synthetic */ BDLocation(Parcel parcel, e eVar) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        this.a = 0;
        ArrayList arrayList = null;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.f213q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new b.a().m();
        this.z = null;
        this.F = null;
        this.G = null;
        this.I = false;
        this.J = 0;
        this.K = 1;
        this.L = null;
        this.N = Constants.STR_EMPTY;
        this.O = -1;
        this.P = 0;
        this.Q = 2;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = new Bundle();
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0L;
        this.e0 = null;
        this.f0 = null;
        this.g0 = Double.MIN_VALUE;
        this.h0 = Double.MIN_VALUE;
        this.i0 = false;
        this.j0 = null;
        this.k0 = -1.0f;
        this.l0 = -1.0d;
        this.m0 = 0;
        this.n0 = -1;
        this.p0 = null;
        this.q0 = null;
        this.a = bDLocation.a;
        this.b = bDLocation.b;
        this.c = bDLocation.c;
        this.d = bDLocation.d;
        this.e = bDLocation.e;
        this.f = bDLocation.f;
        this.g = bDLocation.g;
        this.h = bDLocation.h;
        this.i = bDLocation.i;
        this.j = bDLocation.j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.f213q = bDLocation.f213q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.t = bDLocation.t;
        this.x = bDLocation.x;
        this.y = new b.a().p(bDLocation.y.a).q(bDLocation.y.b).s(bDLocation.y.c).n(bDLocation.y.d).o(bDLocation.y.e).r(bDLocation.y.f).t(bDLocation.y.g).u(bDLocation.y.h).l(bDLocation.y.j).v(bDLocation.y.k).m();
        this.z = bDLocation.z;
        this.F = bDLocation.F;
        this.G = bDLocation.G;
        this.H = bDLocation.H;
        this.K = bDLocation.K;
        this.J = bDLocation.J;
        this.I = bDLocation.I;
        this.L = bDLocation.L;
        this.M = bDLocation.M;
        this.N = bDLocation.N;
        this.u = bDLocation.u;
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.O = bDLocation.O;
        this.P = bDLocation.P;
        this.Q = bDLocation.P;
        this.R = bDLocation.R;
        this.S = bDLocation.S;
        this.T = bDLocation.T;
        this.U = bDLocation.U;
        this.V = bDLocation.V;
        this.b0 = bDLocation.b0;
        this.Z = bDLocation.Z;
        this.e0 = bDLocation.e0;
        this.f0 = bDLocation.f0;
        this.g0 = bDLocation.g0;
        this.h0 = bDLocation.h0;
        this.d0 = bDLocation.d0;
        this.l0 = bDLocation.l0;
        this.m0 = bDLocation.m0;
        this.n0 = bDLocation.n0;
        this.o0 = bDLocation.o0;
        this.Y = bDLocation.Y;
        if (bDLocation.W != null) {
            arrayList = new ArrayList();
            for (int i = 0; i < bDLocation.W.size(); i++) {
                Poi poi = (Poi) bDLocation.W.get(i);
                arrayList.add(new Poi(poi.b(), poi.c(), poi.d(), poi.e(), poi.a()));
            }
        }
        this.W = arrayList;
        this.X = bDLocation.X;
        this.a0 = bDLocation.a0;
        this.c0 = bDLocation.c0;
        this.i0 = bDLocation.i0;
        this.j0 = bDLocation.j0;
        this.k0 = bDLocation.k0;
        this.p0 = bDLocation.p0;
        this.q0 = bDLocation.q0;
    }

    /* JADX WARN: Code duplicated, block: B:220:0x04a3 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:221:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:225:0x04f6 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:227:0x0504 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:230:0x050f A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:232:0x051b A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:235:0x052e A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:237:0x053c A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:240:0x0547 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:242:0x0555 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:245:0x0560 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:247:0x056e A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:250:0x0579 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:253:0x0589 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:255:0x0595 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:256:0x0599 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:264:0x05c2 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:266:0x05d2 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:269:0x05db  */
    /* JADX WARN: Code duplicated, block: B:271:0x05de A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:274:0x05e9 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:277:0x0602 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x0612 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:283:0x0622 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:288:0x0643 A[Catch: Error -> 0x0142, Exception -> 0x065f, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:290:0x064d A[Catch: Error -> 0x0142, Exception -> 0x065f, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:296:0x0667 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x0673 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:299:0x0677 A[Catch: Error -> 0x0142, Exception -> 0x05d7, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:300:0x067c A[Catch: Error -> 0x0142, Exception -> 0x05d7, TRY_LEAVE, TryCatch #7 {Exception -> 0x05d7, blocks: (B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c), top: B:378:0x05b4 }] */
    /* JADX WARN: Code duplicated, block: B:305:0x068c A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:306:0x0696 A[Catch: Error -> 0x0142, Exception -> 0x0146, TRY_LEAVE, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:309:0x06a0 A[Catch: Error -> 0x0142, Exception -> 0x06b0, TryCatch #0 {Exception -> 0x06b0, blocks: (B:307:0x069a, B:309:0x06a0, B:310:0x06ac), top: B:366:0x069a }] */
    /* JADX WARN: Code duplicated, block: B:310:0x06ac A[Catch: Error -> 0x0142, Exception -> 0x06b0, TRY_LEAVE, TryCatch #0 {Exception -> 0x06b0, blocks: (B:307:0x069a, B:309:0x06a0, B:310:0x06ac), top: B:366:0x069a }] */
    /* JADX WARN: Code duplicated, block: B:313:0x06b4 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:314:0x06b8 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:317:0x06c5 A[Catch: Error -> 0x0142, Exception -> 0x0146, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:320:0x06d5 A[Catch: Error -> 0x0142, Exception -> 0x0146, TRY_LEAVE, TryCatch #11 {Error -> 0x0142, blocks: (B:7:0x00ad, B:8:0x00af, B:11:0x00e4, B:13:0x013a, B:18:0x014b, B:20:0x0151, B:21:0x0158, B:23:0x015e, B:24:0x016a, B:25:0x016e, B:27:0x0172, B:28:0x0177, B:31:0x0180, B:33:0x01af, B:34:0x01b6, B:36:0x01be, B:37:0x01cb, B:39:0x01d3, B:40:0x01dc, B:42:0x01e4, B:43:0x01f1, B:46:0x01fb, B:48:0x0209, B:50:0x0215, B:52:0x021a, B:53:0x021e, B:55:0x0226, B:56:0x0238, B:58:0x023e, B:60:0x025c, B:62:0x0267, B:64:0x026d, B:66:0x0276, B:67:0x0283, B:68:0x0285, B:70:0x028d, B:72:0x0299, B:73:0x029b, B:75:0x02a3, B:77:0x02b1, B:79:0x02b9, B:81:0x02c1, B:83:0x02c9, B:85:0x02d1, B:87:0x02d9, B:88:0x02e0, B:90:0x02e8, B:92:0x02f4, B:94:0x02f9, B:97:0x0301, B:101:0x030b, B:103:0x0313, B:105:0x031b, B:107:0x0323, B:109:0x032b, B:111:0x0333, B:113:0x033b, B:115:0x0343, B:117:0x034f, B:119:0x0357, B:121:0x0362, B:123:0x036a, B:125:0x0375, B:127:0x037d, B:129:0x0388, B:131:0x0390, B:133:0x039b, B:135:0x03a3, B:137:0x03ab, B:139:0x03b3, B:220:0x04a3, B:223:0x04ee, B:225:0x04f6, B:227:0x0504, B:228:0x0507, B:230:0x050f, B:232:0x051b, B:233:0x0526, B:235:0x052e, B:237:0x053c, B:238:0x053f, B:240:0x0547, B:242:0x0555, B:243:0x0558, B:245:0x0560, B:247:0x056e, B:248:0x0571, B:250:0x0579, B:251:0x0581, B:253:0x0589, B:255:0x0595, B:256:0x0599, B:259:0x05a2, B:260:0x05ac, B:262:0x05b4, B:264:0x05c2, B:266:0x05d2, B:271:0x05de, B:272:0x05e1, B:274:0x05e9, B:275:0x05fa, B:277:0x0602, B:278:0x060a, B:280:0x0612, B:281:0x061a, B:283:0x0622, B:284:0x062b, B:286:0x0633, B:288:0x0643, B:290:0x064d, B:292:0x0651, B:294:0x065f, B:296:0x0667, B:298:0x0673, B:299:0x0677, B:300:0x067c, B:303:0x0684, B:305:0x068c, B:307:0x069a, B:309:0x06a0, B:310:0x06ac, B:311:0x06b0, B:313:0x06b4, B:315:0x06bd, B:317:0x06c5, B:318:0x06cd, B:320:0x06d5, B:335:0x070b, B:336:0x070e, B:345:0x0744, B:314:0x06b8, B:306:0x0696, B:302:0x0681, B:144:0x03e7, B:146:0x03f2, B:158:0x040a, B:164:0x0416, B:172:0x0422, B:180:0x042e, B:188:0x043d, B:196:0x044d, B:204:0x045d, B:212:0x046f, B:218:0x048d, B:222:0x04df, B:353:0x0759, B:354:0x075e), top: B:385:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:325:0x06e5 A[Catch: all -> 0x0709, TryCatch #6 {all -> 0x0709, blocks: (B:323:0x06df, B:325:0x06e5, B:327:0x06eb, B:329:0x06ef, B:331:0x0706), top: B:376:0x06df }] */
    /* JADX WARN: Code duplicated, block: B:331:0x0706 A[Catch: all -> 0x0709, TRY_LEAVE, TryCatch #6 {all -> 0x0709, blocks: (B:323:0x06df, B:325:0x06e5, B:327:0x06eb, B:329:0x06ef, B:331:0x0706), top: B:376:0x06df }] */
    /* JADX WARN: Code duplicated, block: B:340:0x0724 A[Catch: all -> 0x0742, TryCatch #2 {all -> 0x0742, blocks: (B:338:0x0716, B:340:0x0724, B:342:0x072c), top: B:369:0x0716 }] */
    /* JADX WARN: Code duplicated, block: B:342:0x072c A[Catch: all -> 0x0742, TRY_LEAVE, TryCatch #2 {all -> 0x0742, blocks: (B:338:0x0716, B:340:0x0724, B:342:0x072c), top: B:369:0x0716 }] */
    /* JADX WARN: Code duplicated, block: B:369:0x0716 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:378:0x05b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:386:0x0633 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:405:0x065c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:410:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:411:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    public BDLocation(String str) {
        boolean z;
        Exception exc;
        ?? r2;
        String str2;
        JSONObject jSONObject;
        boolean z2;
        Exception exc2;
        String string;
        String str3;
        String string2;
        String string3;
        String string4;
        String str4;
        String str5;
        String str6;
        String str7;
        String string5;
        String string6;
        String string7;
        String string8;
        String str8;
        int i;
        int i2;
        String str9;
        JSONObject jSONObject2;
        int i3;
        String[] strArrSplit;
        int iOptInt;
        int iIntValue;
        JSONObject jSONObject3;
        String str10;
        String str11;
        String string9;
        String str12;
        String[] strArrSplit2;
        int iIntValue2;
        String string10;
        String string11;
        String string12;
        String string13;
        String string14;
        String string15;
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.l = 0.0f;
        this.m = -1;
        this.n = 0.0f;
        this.o = false;
        this.p = -1;
        this.f213q = -1.0f;
        this.r = null;
        this.s = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = false;
        this.y = new b.a().m();
        this.z = null;
        this.F = null;
        this.G = null;
        this.I = false;
        this.J = 0;
        this.K = 1;
        this.L = null;
        this.N = Constants.STR_EMPTY;
        this.O = -1;
        this.P = 0;
        this.Q = 2;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = new Bundle();
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0L;
        this.e0 = null;
        this.f0 = null;
        this.g0 = Double.MIN_VALUE;
        this.h0 = Double.MIN_VALUE;
        this.i0 = false;
        this.j0 = null;
        this.k0 = -1.0f;
        this.l0 = -1.0d;
        this.m0 = 0;
        this.n0 = -1;
        this.p0 = null;
        this.q0 = null;
        if (str == null || str.equals(Constants.STR_EMPTY)) {
            return;
        }
        try {
            try {
                try {
                    JSONObject jSONObject4 = new JSONObject(str);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject("result");
                    int i4 = Integer.parseInt(jSONObject5.getString("error"));
                    O(i4);
                    i0(jSONObject5.getString("time"));
                    String str13 = "x";
                    String str14 = "y";
                    if (i4 == 61) {
                        JSONObject jSONObject6 = jSONObject4.getJSONObject("content");
                        JSONObject jSONObject7 = jSONObject6.getJSONObject("point");
                        N(Double.parseDouble(jSONObject7.getString("y")));
                        T(Double.parseDouble(jSONObject7.getString("x")));
                        b0(Float.parseFloat(jSONObject6.getString("radius")));
                        h0(Float.parseFloat(jSONObject6.getString("s")));
                        A(Float.parseFloat(jSONObject6.getString("d")));
                        f0(Integer.parseInt(jSONObject6.getString("n")));
                        if (jSONObject6.has("is_mock")) {
                            W(jSONObject6.getInt("is_mock"));
                        }
                        if (jSONObject6.has("h")) {
                            try {
                                v(jSONObject6.getDouble("h"));
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            if (jSONObject6.has("in_cn")) {
                                S(Integer.parseInt(jSONObject6.getString("in_cn")));
                            } else {
                                S(1);
                            }
                        } catch (Exception unused2) {
                        }
                        if (this.K == 0) {
                            x("wgs84");
                            return;
                        } else {
                            x("gcj02");
                            return;
                        }
                    }
                    if (i4 == 161) {
                        JSONObject jSONObject8 = jSONObject4.getJSONObject("content");
                        JSONObject jSONObject9 = jSONObject8.getJSONObject("point");
                        N(Double.parseDouble(jSONObject9.getString("y")));
                        T(Double.parseDouble(jSONObject9.getString("x")));
                        b0(Float.parseFloat(jSONObject8.getString("radius")));
                        if (jSONObject8.has("traffic")) {
                            l0(jSONObject8.getString("traffic"));
                        }
                        if (jSONObject8.has("traffic_prop")) {
                            n0(Float.parseFloat(jSONObject8.optString("traffic_prop")));
                        }
                        if (jSONObject8.has("is_station")) {
                            M(jSONObject8.optInt("is_station"));
                        }
                        if (jSONObject8.has("traffic_skip_prop")) {
                            o0(Float.parseFloat(jSONObject8.optString("traffic_skip_prop")));
                        }
                        if (jSONObject8.has("sema")) {
                            JSONObject jSONObject10 = jSONObject8.getJSONObject("sema");
                            if (jSONObject10.has("aptag")) {
                                String string16 = jSONObject10.getString("aptag");
                                if (!TextUtils.isEmpty(string16)) {
                                    this.u = string16;
                                    str2 = Constants.STR_EMPTY;
                                } else {
                                    str2 = Constants.STR_EMPTY;
                                    this.u = str2;
                                }
                            } else {
                                str2 = Constants.STR_EMPTY;
                            }
                            if (jSONObject10.has("aptagd")) {
                                JSONArray jSONArray = jSONObject10.getJSONObject("aptagd").getJSONArray("pois");
                                ArrayList arrayList = new ArrayList();
                                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                    JSONObject jSONObject11 = jSONArray.getJSONObject(i5);
                                    arrayList.add(new Poi(jSONObject11.getString("pid"), jSONObject11.getString("pname"), jSONObject11.getDouble("pr"), jSONObject11.has("tags") ? jSONObject11.getString("tags") : str2, jSONObject11.has("addr") ? jSONObject11.getString("addr") : str2));
                                }
                                this.W = arrayList;
                            }
                            if (jSONObject10.has("poiregion")) {
                                String string17 = jSONObject10.getString("poiregion");
                                if (!TextUtils.isEmpty(string17)) {
                                    this.v = string17;
                                }
                            }
                            if (jSONObject10.has("poi_regions")) {
                                JSONObject jSONObject12 = jSONObject10.getJSONObject("poi_regions");
                                this.j0 = new PoiRegion(jSONObject12.has("direction_desc") ? jSONObject12.getString("direction_desc") : str2, jSONObject12.has("name") ? jSONObject12.getString("name") : str2, jSONObject12.has("tag") ? jSONObject12.getString("tag") : str2);
                            }
                            if (jSONObject10.has("regular")) {
                                String string18 = jSONObject10.getString("regular");
                                if (!TextUtils.isEmpty(string18)) {
                                    this.w = string18;
                                }
                            }
                        } else {
                            str2 = Constants.STR_EMPTY;
                        }
                        String str15 = ",";
                        if (jSONObject8.has("addr")) {
                            try {
                                jSONObject = jSONObject8.getJSONObject("addr");
                                z2 = true;
                            } catch (Exception unused3) {
                                jSONObject = null;
                                z2 = false;
                            }
                            if (jSONObject != null) {
                                string2 = jSONObject.has("city") ? jSONObject.getString("city") : str2;
                                string5 = jSONObject.has("city_code") ? jSONObject.getString("city_code") : str2;
                                string6 = jSONObject.has("country") ? jSONObject.getString("country") : str2;
                                string7 = jSONObject.has("country_code") ? jSONObject.getString("country_code") : str2;
                                String string19 = jSONObject.has("province") ? jSONObject.getString("province") : str2;
                                string3 = jSONObject.has("district") ? jSONObject.getString("district") : str2;
                                string = jSONObject.has("street") ? jSONObject.getString("street") : str2;
                                string4 = jSONObject.has("street_number") ? jSONObject.getString("street_number") : str2;
                                String string20 = jSONObject.has("adcode") ? jSONObject.getString("adcode") : str2;
                                string8 = jSONObject.has("town") ? jSONObject.getString("town") : null;
                                str8 = string20;
                                str7 = string19;
                            } else {
                                try {
                                    String[] strArrSplit3 = jSONObject8.getString("addr").split(",");
                                    int length = strArrSplit3.length;
                                    if (length > 0) {
                                        str3 = strArrSplit3[0];
                                        i = 1;
                                    } else {
                                        i = 1;
                                        str3 = null;
                                    }
                                    if (length > i) {
                                        try {
                                            string2 = strArrSplit3[i];
                                            i2 = 2;
                                        } catch (Exception e) {
                                            exc2 = e;
                                            string = null;
                                            string2 = null;
                                            string3 = null;
                                            string4 = null;
                                            str4 = null;
                                            str5 = null;
                                            str6 = null;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                            if (z2) {
                                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                                this.s = true;
                                            }
                                            if (jSONObject8.has("floor")) {
                                                string15 = jSONObject8.getString("floor");
                                                this.z = string15;
                                                if (TextUtils.isEmpty(string15)) {
                                                    this.z = null;
                                                }
                                            }
                                            if (jSONObject8.has("indoor")) {
                                                string14 = jSONObject8.getString("indoor");
                                                if (!TextUtils.isEmpty(string14)) {
                                                    p0(Integer.valueOf(string14).intValue());
                                                }
                                            }
                                            if (jSONObject8.has("loctp")) {
                                                string13 = jSONObject8.getString("loctp");
                                                this.L = string13;
                                                if (TextUtils.isEmpty(string13)) {
                                                    this.L = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldgid")) {
                                                string12 = jSONObject8.getString("bldgid");
                                                this.F = string12;
                                                if (TextUtils.isEmpty(string12)) {
                                                    this.F = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldg")) {
                                                string11 = jSONObject8.getString("bldg");
                                                this.G = string11;
                                                if (TextUtils.isEmpty(string11)) {
                                                    this.G = null;
                                                }
                                            }
                                            if (jSONObject8.has("acc")) {
                                                this.H = jSONObject8.getDouble("acc");
                                            }
                                            if (jSONObject8.has("ibav")) {
                                                string10 = jSONObject8.getString("ibav");
                                                if (TextUtils.isEmpty(string10)) {
                                                    this.J = 0;
                                                } else {
                                                    this.J = Integer.valueOf(string10).intValue();
                                                }
                                            }
                                            if (jSONObject8.has("indoorflags")) {
                                                try {
                                                    jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                    if (jSONObject2.has("area")) {
                                                        iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                        if (iIntValue == 0) {
                                                            J(2);
                                                        } else if (iIntValue == 1) {
                                                            J(1);
                                                        }
                                                    }
                                                    if (jSONObject2.has("support")) {
                                                        I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                    }
                                                    if (jSONObject2.has("inbldg")) {
                                                        this.S = jSONObject2.getString("inbldg");
                                                    }
                                                    if (jSONObject2.has("inbldgid")) {
                                                        this.T = jSONObject2.getString("inbldgid");
                                                    }
                                                    if (jSONObject2.has("polygon")) {
                                                        K(jSONObject2.getString("polygon"));
                                                    }
                                                    if (jSONObject2.has("ret_fields")) {
                                                        try {
                                                            for (String str16 : jSONObject2.getString("ret_fields").split("\\|")) {
                                                                strArrSplit = str16.split("=");
                                                                if (strArrSplit == null) {
                                                                }
                                                            }
                                                        } catch (Exception unused4) {
                                                        }
                                                    }
                                                    if (jSONObject2.has("inout_ble")) {
                                                        iOptInt = jSONObject2.optInt("inout_ble");
                                                        H(iOptInt);
                                                        if (iOptInt == 1) {
                                                            L(true);
                                                        } else {
                                                            L(false);
                                                        }
                                                    } else {
                                                        H(-1);
                                                    }
                                                } catch (Exception e2) {
                                                    e2.printStackTrace();
                                                }
                                            }
                                            if (jSONObject8.has("gpscs")) {
                                                G(jSONObject8.getInt("gpscs"));
                                            } else {
                                                G(0);
                                            }
                                            if (jSONObject8.has("in_cn")) {
                                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                                            } else {
                                                S(1);
                                            }
                                            if (this.K == 0) {
                                                x("wgs84");
                                            } else {
                                                x("gcj02");
                                            }
                                            if (jSONObject8.has("navi")) {
                                                this.e0 = jSONObject8.getString("navi");
                                            }
                                            if (jSONObject8.has("navi_client")) {
                                                str12 = str15;
                                                try {
                                                    if (string9.contains(str12)) {
                                                        iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                        Integer.valueOf(strArrSplit2[1]).intValue();
                                                        if (iIntValue2 > 0) {
                                                            this.i0 = true;
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                }
                                            }
                                            if (jSONObject8.has("nrl_point")) {
                                                try {
                                                    jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                    str10 = str13;
                                                    if (jSONObject3.has(str10)) {
                                                        str11 = str14;
                                                        if (jSONObject3.has(str11)) {
                                                            this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                                            this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                } catch (Throwable unused5) {
                                                    this.g0 = Double.MIN_VALUE;
                                                    this.h0 = Double.MIN_VALUE;
                                                    return;
                                                }
                                            }
                                            return;
                                        }
                                    } else {
                                        i2 = 2;
                                        string2 = null;
                                    }
                                    if (length > i2) {
                                        try {
                                            string3 = strArrSplit3[i2];
                                        } catch (Exception e3) {
                                            exc2 = e3;
                                            string = null;
                                            string3 = null;
                                            string4 = null;
                                            str4 = null;
                                            str5 = null;
                                            str6 = null;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                            if (z2) {
                                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                                this.s = true;
                                            }
                                            if (jSONObject8.has("floor")) {
                                                string15 = jSONObject8.getString("floor");
                                                this.z = string15;
                                                if (TextUtils.isEmpty(string15)) {
                                                    this.z = null;
                                                }
                                            }
                                            if (jSONObject8.has("indoor")) {
                                                string14 = jSONObject8.getString("indoor");
                                                if (!TextUtils.isEmpty(string14)) {
                                                    p0(Integer.valueOf(string14).intValue());
                                                }
                                            }
                                            if (jSONObject8.has("loctp")) {
                                                string13 = jSONObject8.getString("loctp");
                                                this.L = string13;
                                                if (TextUtils.isEmpty(string13)) {
                                                    this.L = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldgid")) {
                                                string12 = jSONObject8.getString("bldgid");
                                                this.F = string12;
                                                if (TextUtils.isEmpty(string12)) {
                                                    this.F = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldg")) {
                                                string11 = jSONObject8.getString("bldg");
                                                this.G = string11;
                                                if (TextUtils.isEmpty(string11)) {
                                                    this.G = null;
                                                }
                                            }
                                            if (jSONObject8.has("acc")) {
                                                this.H = jSONObject8.getDouble("acc");
                                            }
                                            if (jSONObject8.has("ibav")) {
                                                string10 = jSONObject8.getString("ibav");
                                                if (TextUtils.isEmpty(string10)) {
                                                    this.J = 0;
                                                } else {
                                                    this.J = Integer.valueOf(string10).intValue();
                                                }
                                            }
                                            if (jSONObject8.has("indoorflags")) {
                                                jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                if (jSONObject2.has("area")) {
                                                    iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                    if (iIntValue == 0) {
                                                        J(2);
                                                    } else if (iIntValue == 1) {
                                                        J(1);
                                                    }
                                                }
                                                if (jSONObject2.has("support")) {
                                                    I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                }
                                                if (jSONObject2.has("inbldg")) {
                                                    this.S = jSONObject2.getString("inbldg");
                                                }
                                                if (jSONObject2.has("inbldgid")) {
                                                    this.T = jSONObject2.getString("inbldgid");
                                                }
                                                if (jSONObject2.has("polygon")) {
                                                    K(jSONObject2.getString("polygon"));
                                                }
                                                if (jSONObject2.has("ret_fields")) {
                                                    while (i3 < r5) {
                                                        strArrSplit = str16.split("=");
                                                        if (strArrSplit == null) {
                                                        }
                                                    }
                                                }
                                                if (jSONObject2.has("inout_ble")) {
                                                    iOptInt = jSONObject2.optInt("inout_ble");
                                                    H(iOptInt);
                                                    if (iOptInt == 1) {
                                                        L(true);
                                                    } else {
                                                        L(false);
                                                    }
                                                } else {
                                                    H(-1);
                                                }
                                            }
                                            if (jSONObject8.has("gpscs")) {
                                                G(jSONObject8.getInt("gpscs"));
                                            } else {
                                                G(0);
                                            }
                                            if (jSONObject8.has("in_cn")) {
                                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                                            } else {
                                                S(1);
                                            }
                                            if (this.K == 0) {
                                                x("wgs84");
                                            } else {
                                                x("gcj02");
                                            }
                                            if (jSONObject8.has("navi")) {
                                                this.e0 = jSONObject8.getString("navi");
                                            }
                                            if (jSONObject8.has("navi_client")) {
                                                str12 = str15;
                                                if (string9.contains(str12)) {
                                                    iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                    Integer.valueOf(strArrSplit2[1]).intValue();
                                                    if (iIntValue2 > 0) {
                                                        this.i0 = true;
                                                    }
                                                }
                                            }
                                            if (jSONObject8.has("nrl_point")) {
                                                jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                str10 = str13;
                                                if (jSONObject3.has(str10)) {
                                                    str11 = str14;
                                                    if (jSONObject3.has(str11)) {
                                                        this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                                        this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        string3 = null;
                                    }
                                    if (length > 3) {
                                        try {
                                            string = strArrSplit3[3];
                                        } catch (Exception e4) {
                                            exc2 = e4;
                                            string = null;
                                            string4 = null;
                                            str4 = null;
                                            str5 = null;
                                            str6 = null;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                            if (z2) {
                                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                                this.s = true;
                                            }
                                            if (jSONObject8.has("floor")) {
                                                string15 = jSONObject8.getString("floor");
                                                this.z = string15;
                                                if (TextUtils.isEmpty(string15)) {
                                                    this.z = null;
                                                }
                                            }
                                            if (jSONObject8.has("indoor")) {
                                                string14 = jSONObject8.getString("indoor");
                                                if (!TextUtils.isEmpty(string14)) {
                                                    p0(Integer.valueOf(string14).intValue());
                                                }
                                            }
                                            if (jSONObject8.has("loctp")) {
                                                string13 = jSONObject8.getString("loctp");
                                                this.L = string13;
                                                if (TextUtils.isEmpty(string13)) {
                                                    this.L = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldgid")) {
                                                string12 = jSONObject8.getString("bldgid");
                                                this.F = string12;
                                                if (TextUtils.isEmpty(string12)) {
                                                    this.F = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldg")) {
                                                string11 = jSONObject8.getString("bldg");
                                                this.G = string11;
                                                if (TextUtils.isEmpty(string11)) {
                                                    this.G = null;
                                                }
                                            }
                                            if (jSONObject8.has("acc")) {
                                                this.H = jSONObject8.getDouble("acc");
                                            }
                                            if (jSONObject8.has("ibav")) {
                                                string10 = jSONObject8.getString("ibav");
                                                if (TextUtils.isEmpty(string10)) {
                                                    this.J = 0;
                                                } else {
                                                    this.J = Integer.valueOf(string10).intValue();
                                                }
                                            }
                                            if (jSONObject8.has("indoorflags")) {
                                                jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                if (jSONObject2.has("area")) {
                                                    iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                    if (iIntValue == 0) {
                                                        J(2);
                                                    } else if (iIntValue == 1) {
                                                        J(1);
                                                    }
                                                }
                                                if (jSONObject2.has("support")) {
                                                    I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                }
                                                if (jSONObject2.has("inbldg")) {
                                                    this.S = jSONObject2.getString("inbldg");
                                                }
                                                if (jSONObject2.has("inbldgid")) {
                                                    this.T = jSONObject2.getString("inbldgid");
                                                }
                                                if (jSONObject2.has("polygon")) {
                                                    K(jSONObject2.getString("polygon"));
                                                }
                                                if (jSONObject2.has("ret_fields")) {
                                                    while (i3 < r5) {
                                                        strArrSplit = str16.split("=");
                                                        if (strArrSplit == null) {
                                                        }
                                                    }
                                                }
                                                if (jSONObject2.has("inout_ble")) {
                                                    iOptInt = jSONObject2.optInt("inout_ble");
                                                    H(iOptInt);
                                                    if (iOptInt == 1) {
                                                        L(true);
                                                    } else {
                                                        L(false);
                                                    }
                                                } else {
                                                    H(-1);
                                                }
                                            }
                                            if (jSONObject8.has("gpscs")) {
                                                G(jSONObject8.getInt("gpscs"));
                                            } else {
                                                G(0);
                                            }
                                            if (jSONObject8.has("in_cn")) {
                                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                                            } else {
                                                S(1);
                                            }
                                            if (this.K == 0) {
                                                x("wgs84");
                                            } else {
                                                x("gcj02");
                                            }
                                            if (jSONObject8.has("navi")) {
                                                this.e0 = jSONObject8.getString("navi");
                                            }
                                            if (jSONObject8.has("navi_client")) {
                                                str12 = str15;
                                                if (string9.contains(str12)) {
                                                    iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                    Integer.valueOf(strArrSplit2[1]).intValue();
                                                    if (iIntValue2 > 0) {
                                                        this.i0 = true;
                                                    }
                                                }
                                            }
                                            if (jSONObject8.has("nrl_point")) {
                                                jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                str10 = str13;
                                                if (jSONObject3.has(str10)) {
                                                    str11 = str14;
                                                    if (jSONObject3.has(str11)) {
                                                        this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                                        this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        string = null;
                                    }
                                    if (length > 4) {
                                        try {
                                            string4 = strArrSplit3[4];
                                        } catch (Exception e5) {
                                            exc2 = e5;
                                            string4 = null;
                                            str4 = null;
                                            str5 = null;
                                            str6 = null;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                            if (z2) {
                                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                                this.s = true;
                                            }
                                            if (jSONObject8.has("floor")) {
                                                string15 = jSONObject8.getString("floor");
                                                this.z = string15;
                                                if (TextUtils.isEmpty(string15)) {
                                                    this.z = null;
                                                }
                                            }
                                            if (jSONObject8.has("indoor")) {
                                                string14 = jSONObject8.getString("indoor");
                                                if (!TextUtils.isEmpty(string14)) {
                                                    p0(Integer.valueOf(string14).intValue());
                                                }
                                            }
                                            if (jSONObject8.has("loctp")) {
                                                string13 = jSONObject8.getString("loctp");
                                                this.L = string13;
                                                if (TextUtils.isEmpty(string13)) {
                                                    this.L = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldgid")) {
                                                string12 = jSONObject8.getString("bldgid");
                                                this.F = string12;
                                                if (TextUtils.isEmpty(string12)) {
                                                    this.F = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldg")) {
                                                string11 = jSONObject8.getString("bldg");
                                                this.G = string11;
                                                if (TextUtils.isEmpty(string11)) {
                                                    this.G = null;
                                                }
                                            }
                                            if (jSONObject8.has("acc")) {
                                                this.H = jSONObject8.getDouble("acc");
                                            }
                                            if (jSONObject8.has("ibav")) {
                                                string10 = jSONObject8.getString("ibav");
                                                if (TextUtils.isEmpty(string10)) {
                                                    this.J = 0;
                                                } else {
                                                    this.J = Integer.valueOf(string10).intValue();
                                                }
                                            }
                                            if (jSONObject8.has("indoorflags")) {
                                                jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                if (jSONObject2.has("area")) {
                                                    iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                    if (iIntValue == 0) {
                                                        J(2);
                                                    } else if (iIntValue == 1) {
                                                        J(1);
                                                    }
                                                }
                                                if (jSONObject2.has("support")) {
                                                    I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                }
                                                if (jSONObject2.has("inbldg")) {
                                                    this.S = jSONObject2.getString("inbldg");
                                                }
                                                if (jSONObject2.has("inbldgid")) {
                                                    this.T = jSONObject2.getString("inbldgid");
                                                }
                                                if (jSONObject2.has("polygon")) {
                                                    K(jSONObject2.getString("polygon"));
                                                }
                                                if (jSONObject2.has("ret_fields")) {
                                                    while (i3 < r5) {
                                                        strArrSplit = str16.split("=");
                                                        if (strArrSplit == null) {
                                                        }
                                                    }
                                                }
                                                if (jSONObject2.has("inout_ble")) {
                                                    iOptInt = jSONObject2.optInt("inout_ble");
                                                    H(iOptInt);
                                                    if (iOptInt == 1) {
                                                        L(true);
                                                    } else {
                                                        L(false);
                                                    }
                                                } else {
                                                    H(-1);
                                                }
                                            }
                                            if (jSONObject8.has("gpscs")) {
                                                G(jSONObject8.getInt("gpscs"));
                                            } else {
                                                G(0);
                                            }
                                            if (jSONObject8.has("in_cn")) {
                                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                                            } else {
                                                S(1);
                                            }
                                            if (this.K == 0) {
                                                x("wgs84");
                                            } else {
                                                x("gcj02");
                                            }
                                            if (jSONObject8.has("navi")) {
                                                this.e0 = jSONObject8.getString("navi");
                                            }
                                            if (jSONObject8.has("navi_client")) {
                                                str12 = str15;
                                                if (string9.contains(str12)) {
                                                    iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                    Integer.valueOf(strArrSplit2[1]).intValue();
                                                    if (iIntValue2 > 0) {
                                                        this.i0 = true;
                                                    }
                                                }
                                            }
                                            if (jSONObject8.has("nrl_point")) {
                                                jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                str10 = str13;
                                                if (jSONObject3.has(str10)) {
                                                    str11 = str14;
                                                    if (jSONObject3.has(str11)) {
                                                        this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                                        this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        string4 = null;
                                    }
                                    if (length > 5) {
                                        try {
                                            str4 = strArrSplit3[5];
                                        } catch (Exception e6) {
                                            string = string;
                                            exc2 = e6;
                                            str4 = null;
                                            str5 = null;
                                            str6 = null;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                            if (z2) {
                                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                                this.s = true;
                                            }
                                            if (jSONObject8.has("floor")) {
                                                string15 = jSONObject8.getString("floor");
                                                this.z = string15;
                                                if (TextUtils.isEmpty(string15)) {
                                                    this.z = null;
                                                }
                                            }
                                            if (jSONObject8.has("indoor")) {
                                                string14 = jSONObject8.getString("indoor");
                                                if (!TextUtils.isEmpty(string14)) {
                                                    p0(Integer.valueOf(string14).intValue());
                                                }
                                            }
                                            if (jSONObject8.has("loctp")) {
                                                string13 = jSONObject8.getString("loctp");
                                                this.L = string13;
                                                if (TextUtils.isEmpty(string13)) {
                                                    this.L = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldgid")) {
                                                string12 = jSONObject8.getString("bldgid");
                                                this.F = string12;
                                                if (TextUtils.isEmpty(string12)) {
                                                    this.F = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldg")) {
                                                string11 = jSONObject8.getString("bldg");
                                                this.G = string11;
                                                if (TextUtils.isEmpty(string11)) {
                                                    this.G = null;
                                                }
                                            }
                                            if (jSONObject8.has("acc")) {
                                                this.H = jSONObject8.getDouble("acc");
                                            }
                                            if (jSONObject8.has("ibav")) {
                                                string10 = jSONObject8.getString("ibav");
                                                if (TextUtils.isEmpty(string10)) {
                                                    this.J = 0;
                                                } else {
                                                    this.J = Integer.valueOf(string10).intValue();
                                                }
                                            }
                                            if (jSONObject8.has("indoorflags")) {
                                                jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                if (jSONObject2.has("area")) {
                                                    iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                    if (iIntValue == 0) {
                                                        J(2);
                                                    } else if (iIntValue == 1) {
                                                        J(1);
                                                    }
                                                }
                                                if (jSONObject2.has("support")) {
                                                    I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                }
                                                if (jSONObject2.has("inbldg")) {
                                                    this.S = jSONObject2.getString("inbldg");
                                                }
                                                if (jSONObject2.has("inbldgid")) {
                                                    this.T = jSONObject2.getString("inbldgid");
                                                }
                                                if (jSONObject2.has("polygon")) {
                                                    K(jSONObject2.getString("polygon"));
                                                }
                                                if (jSONObject2.has("ret_fields")) {
                                                    while (i3 < r5) {
                                                        strArrSplit = str16.split("=");
                                                        if (strArrSplit == null) {
                                                        }
                                                    }
                                                }
                                                if (jSONObject2.has("inout_ble")) {
                                                    iOptInt = jSONObject2.optInt("inout_ble");
                                                    H(iOptInt);
                                                    if (iOptInt == 1) {
                                                        L(true);
                                                    } else {
                                                        L(false);
                                                    }
                                                } else {
                                                    H(-1);
                                                }
                                            }
                                            if (jSONObject8.has("gpscs")) {
                                                G(jSONObject8.getInt("gpscs"));
                                            } else {
                                                G(0);
                                            }
                                            if (jSONObject8.has("in_cn")) {
                                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                                            } else {
                                                S(1);
                                            }
                                            if (this.K == 0) {
                                                x("wgs84");
                                            } else {
                                                x("gcj02");
                                            }
                                            if (jSONObject8.has("navi")) {
                                                this.e0 = jSONObject8.getString("navi");
                                            }
                                            if (jSONObject8.has("navi_client")) {
                                                str12 = str15;
                                                if (string9.contains(str12)) {
                                                    iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                    Integer.valueOf(strArrSplit2[1]).intValue();
                                                    if (iIntValue2 > 0) {
                                                        this.i0 = true;
                                                    }
                                                }
                                            }
                                            if (jSONObject8.has("nrl_point")) {
                                                jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                str10 = str13;
                                                if (jSONObject3.has(str10)) {
                                                    str11 = str14;
                                                    if (jSONObject3.has(str11)) {
                                                        this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                                        this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        str4 = null;
                                    }
                                    if (length > 6) {
                                        try {
                                            str5 = strArrSplit3[6];
                                        } catch (Exception e7) {
                                            string = string;
                                            exc2 = e7;
                                            str5 = null;
                                            str6 = null;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                            if (z2) {
                                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                                this.s = true;
                                            }
                                            if (jSONObject8.has("floor")) {
                                                string15 = jSONObject8.getString("floor");
                                                this.z = string15;
                                                if (TextUtils.isEmpty(string15)) {
                                                    this.z = null;
                                                }
                                            }
                                            if (jSONObject8.has("indoor")) {
                                                string14 = jSONObject8.getString("indoor");
                                                if (!TextUtils.isEmpty(string14)) {
                                                    p0(Integer.valueOf(string14).intValue());
                                                }
                                            }
                                            if (jSONObject8.has("loctp")) {
                                                string13 = jSONObject8.getString("loctp");
                                                this.L = string13;
                                                if (TextUtils.isEmpty(string13)) {
                                                    this.L = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldgid")) {
                                                string12 = jSONObject8.getString("bldgid");
                                                this.F = string12;
                                                if (TextUtils.isEmpty(string12)) {
                                                    this.F = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldg")) {
                                                string11 = jSONObject8.getString("bldg");
                                                this.G = string11;
                                                if (TextUtils.isEmpty(string11)) {
                                                    this.G = null;
                                                }
                                            }
                                            if (jSONObject8.has("acc")) {
                                                this.H = jSONObject8.getDouble("acc");
                                            }
                                            if (jSONObject8.has("ibav")) {
                                                string10 = jSONObject8.getString("ibav");
                                                if (TextUtils.isEmpty(string10)) {
                                                    this.J = 0;
                                                } else {
                                                    this.J = Integer.valueOf(string10).intValue();
                                                }
                                            }
                                            if (jSONObject8.has("indoorflags")) {
                                                jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                if (jSONObject2.has("area")) {
                                                    iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                    if (iIntValue == 0) {
                                                        J(2);
                                                    } else if (iIntValue == 1) {
                                                        J(1);
                                                    }
                                                }
                                                if (jSONObject2.has("support")) {
                                                    I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                }
                                                if (jSONObject2.has("inbldg")) {
                                                    this.S = jSONObject2.getString("inbldg");
                                                }
                                                if (jSONObject2.has("inbldgid")) {
                                                    this.T = jSONObject2.getString("inbldgid");
                                                }
                                                if (jSONObject2.has("polygon")) {
                                                    K(jSONObject2.getString("polygon"));
                                                }
                                                if (jSONObject2.has("ret_fields")) {
                                                    while (i3 < r5) {
                                                        strArrSplit = str16.split("=");
                                                        if (strArrSplit == null) {
                                                        }
                                                    }
                                                }
                                                if (jSONObject2.has("inout_ble")) {
                                                    iOptInt = jSONObject2.optInt("inout_ble");
                                                    H(iOptInt);
                                                    if (iOptInt == 1) {
                                                        L(true);
                                                    } else {
                                                        L(false);
                                                    }
                                                } else {
                                                    H(-1);
                                                }
                                            }
                                            if (jSONObject8.has("gpscs")) {
                                                G(jSONObject8.getInt("gpscs"));
                                            } else {
                                                G(0);
                                            }
                                            if (jSONObject8.has("in_cn")) {
                                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                                            } else {
                                                S(1);
                                            }
                                            if (this.K == 0) {
                                                x("wgs84");
                                            } else {
                                                x("gcj02");
                                            }
                                            if (jSONObject8.has("navi")) {
                                                this.e0 = jSONObject8.getString("navi");
                                            }
                                            if (jSONObject8.has("navi_client")) {
                                                str12 = str15;
                                                if (string9.contains(str12)) {
                                                    iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                    Integer.valueOf(strArrSplit2[1]).intValue();
                                                    if (iIntValue2 > 0) {
                                                        this.i0 = true;
                                                    }
                                                }
                                            }
                                            if (jSONObject8.has("nrl_point")) {
                                                jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                str10 = str13;
                                                if (jSONObject3.has(str10)) {
                                                    str11 = str14;
                                                    if (jSONObject3.has(str11)) {
                                                        this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                                        this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        str5 = null;
                                    }
                                    if (length > 7) {
                                        try {
                                            str6 = strArrSplit3[7];
                                        } catch (Exception e8) {
                                            string = string;
                                            exc2 = e8;
                                            str6 = null;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                            if (z2) {
                                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                                this.s = true;
                                            }
                                            if (jSONObject8.has("floor")) {
                                                string15 = jSONObject8.getString("floor");
                                                this.z = string15;
                                                if (TextUtils.isEmpty(string15)) {
                                                    this.z = null;
                                                }
                                            }
                                            if (jSONObject8.has("indoor")) {
                                                string14 = jSONObject8.getString("indoor");
                                                if (!TextUtils.isEmpty(string14)) {
                                                    p0(Integer.valueOf(string14).intValue());
                                                }
                                            }
                                            if (jSONObject8.has("loctp")) {
                                                string13 = jSONObject8.getString("loctp");
                                                this.L = string13;
                                                if (TextUtils.isEmpty(string13)) {
                                                    this.L = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldgid")) {
                                                string12 = jSONObject8.getString("bldgid");
                                                this.F = string12;
                                                if (TextUtils.isEmpty(string12)) {
                                                    this.F = null;
                                                }
                                            }
                                            if (jSONObject8.has("bldg")) {
                                                string11 = jSONObject8.getString("bldg");
                                                this.G = string11;
                                                if (TextUtils.isEmpty(string11)) {
                                                    this.G = null;
                                                }
                                            }
                                            if (jSONObject8.has("acc")) {
                                                this.H = jSONObject8.getDouble("acc");
                                            }
                                            if (jSONObject8.has("ibav")) {
                                                string10 = jSONObject8.getString("ibav");
                                                if (TextUtils.isEmpty(string10)) {
                                                    this.J = 0;
                                                } else {
                                                    this.J = Integer.valueOf(string10).intValue();
                                                }
                                            }
                                            if (jSONObject8.has("indoorflags")) {
                                                jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                                                if (jSONObject2.has("area")) {
                                                    iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                                    if (iIntValue == 0) {
                                                        J(2);
                                                    } else if (iIntValue == 1) {
                                                        J(1);
                                                    }
                                                }
                                                if (jSONObject2.has("support")) {
                                                    I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                                                }
                                                if (jSONObject2.has("inbldg")) {
                                                    this.S = jSONObject2.getString("inbldg");
                                                }
                                                if (jSONObject2.has("inbldgid")) {
                                                    this.T = jSONObject2.getString("inbldgid");
                                                }
                                                if (jSONObject2.has("polygon")) {
                                                    K(jSONObject2.getString("polygon"));
                                                }
                                                if (jSONObject2.has("ret_fields")) {
                                                    while (i3 < r5) {
                                                        strArrSplit = str16.split("=");
                                                        if (strArrSplit == null) {
                                                        }
                                                    }
                                                }
                                                if (jSONObject2.has("inout_ble")) {
                                                    iOptInt = jSONObject2.optInt("inout_ble");
                                                    H(iOptInt);
                                                    if (iOptInt == 1) {
                                                        L(true);
                                                    } else {
                                                        L(false);
                                                    }
                                                } else {
                                                    H(-1);
                                                }
                                            }
                                            if (jSONObject8.has("gpscs")) {
                                                G(jSONObject8.getInt("gpscs"));
                                            } else {
                                                G(0);
                                            }
                                            if (jSONObject8.has("in_cn")) {
                                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                                            } else {
                                                S(1);
                                            }
                                            if (this.K == 0) {
                                                x("wgs84");
                                            } else {
                                                x("gcj02");
                                            }
                                            if (jSONObject8.has("navi")) {
                                                this.e0 = jSONObject8.getString("navi");
                                            }
                                            if (jSONObject8.has("navi_client")) {
                                                str12 = str15;
                                                if (string9.contains(str12)) {
                                                    iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                                    Integer.valueOf(strArrSplit2[1]).intValue();
                                                    if (iIntValue2 > 0) {
                                                        this.i0 = true;
                                                    }
                                                }
                                            }
                                            if (jSONObject8.has("nrl_point")) {
                                                jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                                                str10 = str13;
                                                if (jSONObject3.has(str10)) {
                                                    str11 = str14;
                                                    if (jSONObject3.has(str11)) {
                                                        this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                                        this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } else {
                                        str6 = null;
                                    }
                                    if (length > 8) {
                                        try {
                                            str9 = strArrSplit3[8];
                                        } catch (Exception e9) {
                                            string = string;
                                            exc2 = e9;
                                            exc2.printStackTrace();
                                            str7 = str3;
                                            str14 = "y";
                                            string5 = str4;
                                            string6 = str5;
                                            string7 = str6;
                                            z2 = false;
                                            str15 = ",";
                                            string8 = null;
                                            str8 = null;
                                        }
                                    } else {
                                        str9 = null;
                                    }
                                    string = string;
                                    str7 = str3;
                                    str14 = "y";
                                    string6 = str5;
                                    string7 = str6;
                                    z2 = true;
                                    str15 = ",";
                                    string8 = null;
                                    str8 = str9;
                                    string5 = str4;
                                } catch (Exception e10) {
                                    exc2 = e10;
                                    string = null;
                                    str3 = null;
                                }
                            }
                            if (z2) {
                                this.y = new b.a().p(string6).q(string7).s(str7).n(string2).o(string5).r(string3).t(string).u(string4).l(str8).v(string8).m();
                                this.s = true;
                            }
                        } else {
                            str15 = ",";
                            str13 = "x";
                            str14 = "y";
                            this.s = false;
                            u(null);
                        }
                        if (jSONObject8.has("floor")) {
                            string15 = jSONObject8.getString("floor");
                            this.z = string15;
                            if (TextUtils.isEmpty(string15)) {
                                this.z = null;
                            }
                        }
                        if (jSONObject8.has("indoor")) {
                            string14 = jSONObject8.getString("indoor");
                            if (!TextUtils.isEmpty(string14)) {
                                p0(Integer.valueOf(string14).intValue());
                            }
                        }
                        if (jSONObject8.has("loctp")) {
                            string13 = jSONObject8.getString("loctp");
                            this.L = string13;
                            if (TextUtils.isEmpty(string13)) {
                                this.L = null;
                            }
                        }
                        if (jSONObject8.has("bldgid")) {
                            string12 = jSONObject8.getString("bldgid");
                            this.F = string12;
                            if (TextUtils.isEmpty(string12)) {
                                this.F = null;
                            }
                        }
                        if (jSONObject8.has("bldg")) {
                            string11 = jSONObject8.getString("bldg");
                            this.G = string11;
                            if (TextUtils.isEmpty(string11)) {
                                this.G = null;
                            }
                        }
                        if (jSONObject8.has("acc")) {
                            this.H = jSONObject8.getDouble("acc");
                        }
                        if (jSONObject8.has("ibav")) {
                            string10 = jSONObject8.getString("ibav");
                            if (TextUtils.isEmpty(string10) && !string10.equals("0")) {
                                this.J = Integer.valueOf(string10).intValue();
                            } else {
                                this.J = 0;
                            }
                        }
                        if (jSONObject8.has("indoorflags")) {
                            jSONObject2 = jSONObject8.getJSONObject("indoorflags");
                            if (jSONObject2.has("area")) {
                                iIntValue = Integer.valueOf(jSONObject2.getString("area")).intValue();
                                if (iIntValue == 0) {
                                    J(2);
                                } else if (iIntValue == 1) {
                                    J(1);
                                }
                            }
                            if (jSONObject2.has("support")) {
                                I(Integer.valueOf(jSONObject2.getString("support")).intValue());
                            }
                            if (jSONObject2.has("inbldg")) {
                                this.S = jSONObject2.getString("inbldg");
                            }
                            if (jSONObject2.has("inbldgid")) {
                                this.T = jSONObject2.getString("inbldgid");
                            }
                            if (jSONObject2.has("polygon")) {
                                K(jSONObject2.getString("polygon"));
                            }
                            if (jSONObject2.has("ret_fields")) {
                                while (i3 < r5) {
                                    strArrSplit = str16.split("=");
                                    if (strArrSplit == null && strArrSplit.length >= 2) {
                                        this.a0.putString(strArrSplit[0], strArrSplit[1]);
                                    }
                                }
                            }
                            if (jSONObject2.has("inout_ble")) {
                                iOptInt = jSONObject2.optInt("inout_ble");
                                H(iOptInt);
                                if (iOptInt == 1) {
                                    L(true);
                                } else {
                                    L(false);
                                }
                            } else {
                                H(-1);
                            }
                        }
                        if (jSONObject8.has("gpscs")) {
                            G(jSONObject8.getInt("gpscs"));
                        } else {
                            G(0);
                        }
                        try {
                            if (jSONObject8.has("in_cn")) {
                                S(Integer.parseInt(jSONObject8.getString("in_cn")));
                            } else {
                                S(1);
                            }
                        } catch (Exception unused6) {
                        }
                        if (this.K == 0) {
                            x("wgs84");
                        } else {
                            x("gcj02");
                        }
                        if (jSONObject8.has("navi")) {
                            this.e0 = jSONObject8.getString("navi");
                        }
                        if (jSONObject8.has("navi_client") && (string9 = jSONObject8.getString("navi_client")) != null) {
                            str12 = str15;
                            if (string9.contains(str12) && (strArrSplit2 = string9.split(str12)) != null && strArrSplit2.length >= 2) {
                                iIntValue2 = Integer.valueOf(strArrSplit2[0]).intValue();
                                Integer.valueOf(strArrSplit2[1]).intValue();
                                if (iIntValue2 > 0) {
                                    this.i0 = true;
                                }
                            }
                        }
                        if (jSONObject8.has("nrl_point")) {
                            jSONObject3 = jSONObject8.getJSONObject("nrl_point");
                            str10 = str13;
                            if (jSONObject3.has(str10)) {
                                str11 = str14;
                                if (jSONObject3.has(str11)) {
                                    this.g0 = Double.parseDouble(jSONObject3.getString(str11));
                                    this.h0 = Double.parseDouble(jSONObject3.getString(str10));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (i4 != 66 && i4 != 68) {
                        if (i4 == 167) {
                            S(2);
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject13 = jSONObject4.getJSONObject("content");
                    JSONObject jSONObject14 = jSONObject13.getJSONObject("point");
                    N(Double.parseDouble(jSONObject14.getString("y")));
                    T(Double.parseDouble(jSONObject14.getString("x")));
                    b0(Float.parseFloat(jSONObject13.getString("radius")));
                    a(Boolean.valueOf(Boolean.parseBoolean(jSONObject13.getString("isCellChanged"))));
                    x("gcj02");
                } catch (Exception e11) {
                    exc = e11;
                    z = false;
                    exc.printStackTrace();
                    r2 = z;
                    this.a = r2;
                    this.s = r2;
                }
            } catch (Error e12) {
                e12.printStackTrace();
                r2 = 0;
                this.a = r2;
                this.s = r2;
            }
        } catch (Exception e13) {
            z = false;
            exc = e13;
        }
    }
}
