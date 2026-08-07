package com.luck.picture.lib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LocalMediaFolder implements Parcelable {
    public static final Parcelable.Creator<LocalMediaFolder> CREATOR = new a();
    private long a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private List j;
    private int k;
    private boolean l;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMediaFolder createFromParcel(Parcel parcel) {
            return new LocalMediaFolder(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalMediaFolder[] newArray(int i) {
            return new LocalMediaFolder[i];
        }
    }

    public LocalMediaFolder() {
        this.a = -1L;
        this.h = -1;
        this.j = new ArrayList();
    }

    public long a() {
        return this.a;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.k;
    }

    public List d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    public String h() {
        return TextUtils.isEmpty(this.b) ? "unknown" : this.b;
    }

    public int i() {
        return this.h;
    }

    public boolean j() {
        return this.i;
    }

    public boolean k() {
        return this.g;
    }

    public boolean l() {
        return this.l;
    }

    public void m(long j) {
        this.a = j;
    }

    public void n(boolean z) {
        this.i = z;
    }

    public void o(boolean z) {
        this.g = z;
    }

    public void p(int i) {
        this.f = i;
    }

    public void q(int i) {
        this.k = i;
    }

    public void r(List list) {
        this.j = list;
    }

    public void s(String str) {
        this.c = str;
    }

    public void t(String str) {
        this.d = str;
    }

    public void u(boolean z) {
        this.l = z;
    }

    public void v(int i) {
        this.e = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.h);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.j);
        parcel.writeInt(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
    }

    public void x(String str) {
        this.b = str;
    }

    public void z(int i) {
        this.h = i;
    }

    protected LocalMediaFolder(Parcel parcel) {
        this.a = -1L;
        this.h = -1;
        this.j = new ArrayList();
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readByte() != 0;
        this.h = parcel.readInt();
        this.i = parcel.readByte() != 0;
        this.j = parcel.createTypedArrayList(LocalMedia.CREATOR);
        this.k = parcel.readInt();
        this.l = parcel.readByte() != 0;
    }
}
