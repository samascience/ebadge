package com.luck.picture.lib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.luck.picture.lib.compress.Checker;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public class LocalMedia implements Parcelable {
    public static final Parcelable.Creator<LocalMedia> CREATOR = new a();
    private int F;
    public int G;
    public boolean H;
    private long I;
    private boolean J;
    private boolean K;
    private long L;
    private long a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private long h;
    private boolean i;
    private boolean j;
    public int k;
    private int l;
    private String m;
    private int n;
    private boolean o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f300q;
    private int r;
    private int s;
    private int t;
    private int u;
    private float v;
    private long w;
    private boolean x;
    private String y;
    private String z;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMedia createFromParcel(Parcel parcel) {
            return new LocalMedia(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalMedia[] newArray(int i) {
            return new LocalMedia[i];
        }
    }

    public LocalMedia() {
        this.F = -1;
        this.G = -1;
        this.I = -1L;
    }

    public static LocalMedia F(long j, String str, String str2, String str3, String str4, long j2, int i, String str5, int i2, int i3, long j3, long j4, long j5) {
        LocalMedia localMedia = new LocalMedia();
        localMedia.b0(j);
        localMedia.n0(str);
        localMedia.p0(str2);
        localMedia.Y(str3);
        localMedia.l0(str4);
        localMedia.W(j2);
        localMedia.K(i);
        localMedia.d0(str5);
        localMedia.r0(i2);
        localMedia.Z(i3);
        localMedia.q0(j3);
        localMedia.I(j4);
        localMedia.U(j5);
        return localMedia;
    }

    public static LocalMedia G(String str, int i, int i2) {
        LocalMedia localMediaF = F(0L, str, Constants.STR_EMPTY, Constants.STR_EMPTY, Constants.STR_EMPTY, 0L, i2, Constants.STR_EMPTY, 0, 0, 0L, -1L, 0L);
        localMediaF.o0(i);
        return localMediaF;
    }

    public boolean A() {
        return this.K;
    }

    public boolean B() {
        return this.J;
    }

    public boolean E() {
        return !TextUtils.isEmpty(a());
    }

    public void H(String str) {
        this.g = str;
    }

    public void I(long j) {
        this.I = j;
    }

    public void J(boolean z) {
        this.i = z;
    }

    public void K(int i) {
        this.n = i;
    }

    public void L(String str) {
        this.e = str;
    }

    public void M(boolean z) {
        this.o = z;
    }

    public void N(int i) {
        this.s = i;
    }

    public void O(int i) {
        this.r = i;
    }

    public void P(int i) {
        this.t = i;
    }

    public void Q(int i) {
        this.u = i;
    }

    public void R(float f) {
        this.v = f;
    }

    public void S(boolean z) {
        this.j = z;
    }

    public void T(String str) {
        this.f = str;
    }

    public void U(long j) {
        this.L = j;
    }

    public void W(long j) {
        this.h = j;
    }

    public void X(boolean z) {
        this.K = z;
    }

    public void Y(String str) {
        this.y = str;
    }

    public void Z(int i) {
        this.f300q = i;
    }

    public String a() {
        return this.g;
    }

    public long b() {
        return this.I;
    }

    public void b0(long j) {
        this.a = j;
    }

    public String c() {
        return this.e;
    }

    public void c0(boolean z) {
        this.J = z;
    }

    public int d() {
        return this.s;
    }

    public void d0(String str) {
        this.m = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.r;
    }

    public int f() {
        return this.t;
    }

    public void f0(int i) {
        this.l = i;
    }

    public int g() {
        return this.u;
    }

    public float h() {
        return this.v;
    }

    public void h0(boolean z) {
        this.x = z;
    }

    public String i() {
        return this.f;
    }

    public void i0(String str) {
        this.d = str;
    }

    public long j() {
        return this.L;
    }

    public long k() {
        return this.h;
    }

    public int l() {
        return this.f300q;
    }

    public void l0(String str) {
        this.z = str;
    }

    public long m() {
        return this.a;
    }

    public String n() {
        return TextUtils.isEmpty(this.m) ? Checker.MIME_TYPE_JPEG : this.m;
    }

    public void n0(String str) {
        this.b = str;
    }

    public int o() {
        return this.l;
    }

    public void o0(int i) {
        this.k = i;
    }

    public String p() {
        return this.z;
    }

    public void p0(String str) {
        this.c = str;
    }

    public String q() {
        return this.b;
    }

    public void q0(long j) {
        this.w = j;
    }

    public int r() {
        return this.k;
    }

    public void r0(int i) {
        this.p = i;
    }

    public String s() {
        return this.c;
    }

    public long t() {
        return this.w;
    }

    public String toString() {
        return "LocalMedia{id=" + this.a + ", path='" + this.b + "', realPath='" + this.c + "', originalPath='" + this.d + "', compressPath='" + this.e + "', cutPath='" + this.f + "', androidQToPath='" + this.g + "', duration=" + this.h + ", isChecked=" + this.i + ", isCut=" + this.j + ", position=" + this.k + ", num=" + this.l + ", mimeType='" + this.m + "', chooseModel=" + this.n + ", compressed=" + this.o + ", width=" + this.p + ", height=" + this.f300q + ", cropImageWidth=" + this.r + ", cropImageHeight=" + this.s + ", cropOffsetX=" + this.t + ", cropOffsetY=" + this.u + ", cropResultAspectRatio=" + this.v + ", size=" + this.w + ", isOriginal=" + this.x + ", fileName='" + this.y + "', parentFolderName='" + this.z + "', orientation=" + this.F + ", bucketId=" + this.I + ", isMaxSelectEnabledMask=" + this.J + ", isEditorImage=" + this.K + ", dateAddedTime=" + this.L + '}';
    }

    public int u() {
        return this.p;
    }

    public boolean v() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeByte(this.o ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.p);
        parcel.writeInt(this.f300q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeFloat(this.v);
        parcel.writeLong(this.w);
        parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeByte(this.H ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.L);
    }

    public boolean x() {
        return this.o && !TextUtils.isEmpty(c());
    }

    public boolean z() {
        return this.j && !TextUtils.isEmpty(i());
    }

    protected LocalMedia(Parcel parcel) {
        this.F = -1;
        this.G = -1;
        this.I = -1L;
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readLong();
        this.i = parcel.readByte() != 0;
        this.j = parcel.readByte() != 0;
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readByte() != 0;
        this.p = parcel.readInt();
        this.f300q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readFloat();
        this.w = parcel.readLong();
        this.x = parcel.readByte() != 0;
        this.y = parcel.readString();
        this.z = parcel.readString();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readByte() != 0;
        this.I = parcel.readLong();
        this.J = parcel.readByte() != 0;
        this.K = parcel.readByte() != 0;
        this.L = parcel.readLong();
    }
}
