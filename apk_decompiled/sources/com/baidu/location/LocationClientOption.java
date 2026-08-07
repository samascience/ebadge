package com.baidu.location;

/* JADX INFO: loaded from: classes.dex */
public final class LocationClientOption {
    public int A;
    public int B;
    public boolean C;
    public FirstLocType D;
    public String a;
    public String b;
    public boolean c;
    public int d;
    public int e;
    public String f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f214q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    protected LocationMode v;
    public int w;
    public float x;
    public int y;
    public int z;

    public enum BDLocationPurpose {
        SignIn,
        Sport,
        Transport
    }

    public enum FirstLocType {
        SPEED_IN_FIRST_LOC,
        ACCURACY_IN_FIRST_LOC
    }

    public enum LocationMode {
        Hight_Accuracy,
        Battery_Saving,
        Device_Sensors,
        Fuzzy_Locating
    }

    public LocationClientOption() {
        this.a = "gcj02";
        this.b = "noaddr";
        this.c = false;
        this.d = 0;
        this.e = 12000;
        this.f = "SDK6.0";
        this.g = 1;
        this.h = false;
        this.i = true;
        this.j = false;
        this.k = "com.baidu.location.service_v2.9";
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.f214q = false;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.w = 0;
        this.x = 0.5f;
        this.y = 0;
        this.z = 0;
        this.A = Integer.MAX_VALUE;
        this.B = 1;
        this.C = false;
        this.D = FirstLocType.SPEED_IN_FIRST_LOC;
    }

    public void a(boolean z) {
        this.l = z;
    }

    int b() {
        return this.w;
    }

    float c() {
        return this.x;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.z;
    }

    public int f() {
        return this.y;
    }

    public String g() {
        return this.a;
    }

    public boolean h() {
        return this.u;
    }

    public boolean i(LocationClientOption locationClientOption) {
        return this.a.equals(locationClientOption.a) && this.b.equals(locationClientOption.b) && this.c == locationClientOption.c && this.d == locationClientOption.d && this.e == locationClientOption.e && this.f.equals(locationClientOption.f) && this.h == locationClientOption.h && this.g == locationClientOption.g && this.i == locationClientOption.i && this.l == locationClientOption.l && this.t == locationClientOption.t && this.m == locationClientOption.m && this.o == locationClientOption.o && this.p == locationClientOption.p && this.f214q == locationClientOption.f214q && this.r == locationClientOption.r && this.n == locationClientOption.n && this.w == locationClientOption.w && this.x == locationClientOption.x && this.y == locationClientOption.y && this.z == locationClientOption.z && this.A == locationClientOption.A && this.u == locationClientOption.u && this.B == locationClientOption.B && this.C == locationClientOption.C && this.s == locationClientOption.s && this.v == locationClientOption.v && this.j == locationClientOption.j && this.D == locationClientOption.D;
    }

    public void j(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.a = lowerCase;
        }
    }

    public void k(boolean z) {
        this.j = z;
    }

    public void l(FirstLocType firstLocType) {
        this.D = firstLocType;
    }

    public void m(boolean z) {
        this.m = z;
    }

    public void n(LocationMode locationMode) {
        int i = d.a[locationMode.ordinal()];
        if (i == 1) {
            this.c = true;
            this.g = 1;
        } else if (i == 2) {
            this.c = false;
            this.g = 3;
        } else if (i == 3) {
            this.g = 2;
            this.c = true;
        } else {
            if (i != 4) {
                throw new IllegalArgumentException("Illegal this mode : " + locationMode);
            }
            this.g = 4;
            this.c = false;
        }
        this.v = locationMode;
    }

    public void o(boolean z) {
        this.h = z;
    }

    public void p(boolean z) {
        this.t = z;
    }

    public void q(boolean z) {
        this.c = z;
    }

    public void r(int i) {
        if (i >= 0) {
            this.d = i;
        }
    }

    public void s(int i) {
        if (i >= 10000) {
            this.A = i;
        }
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.a = "gcj02";
        this.b = "noaddr";
        this.c = false;
        this.d = 0;
        this.e = 12000;
        this.f = "SDK6.0";
        this.g = 1;
        this.h = false;
        this.i = true;
        this.j = false;
        this.k = "com.baidu.location.service_v2.9";
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = false;
        this.p = false;
        this.f214q = false;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.w = 0;
        this.x = 0.5f;
        this.y = 0;
        this.z = 0;
        this.A = Integer.MAX_VALUE;
        this.B = 1;
        this.C = false;
        this.D = FirstLocType.SPEED_IN_FIRST_LOC;
        this.a = locationClientOption.a;
        this.b = locationClientOption.b;
        this.c = locationClientOption.c;
        this.d = locationClientOption.d;
        this.e = locationClientOption.e;
        this.f = locationClientOption.f;
        this.g = locationClientOption.g;
        this.h = locationClientOption.h;
        this.k = locationClientOption.k;
        this.i = locationClientOption.i;
        this.l = locationClientOption.l;
        this.m = locationClientOption.m;
        this.j = locationClientOption.j;
        this.v = locationClientOption.v;
        this.o = locationClientOption.o;
        this.p = locationClientOption.p;
        this.f214q = locationClientOption.f214q;
        this.r = locationClientOption.r;
        this.n = locationClientOption.n;
        this.s = locationClientOption.s;
        this.w = locationClientOption.w;
        this.x = locationClientOption.x;
        this.y = locationClientOption.y;
        this.z = locationClientOption.z;
        this.A = locationClientOption.A;
        this.t = locationClientOption.t;
        this.u = locationClientOption.u;
        this.B = locationClientOption.B;
        this.C = locationClientOption.C;
        this.D = locationClientOption.D;
    }
}
