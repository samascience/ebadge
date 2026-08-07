package com.legend.mywatch.sdk.mywatchsdklib.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes3.dex */
public final class RecordInfoModel implements Parcelable {
    public static final a CREATOR = new a(null);
    private int a;
    private int b;
    private boolean c;
    private boolean d;
    private int e;

    public static final class a implements Parcelable.Creator {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecordInfoModel createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new RecordInfoModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecordInfoModel[] newArray(int i) {
            return new RecordInfoModel[i];
        }

        private a() {
        }
    }

    public RecordInfoModel(int i, int i2, boolean z, boolean z2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = z;
        this.d = z2;
        this.e = i3;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.e;
    }

    public final int c() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordInfoModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readByte() != 0, false, 0);
        p31.f(parcel, "parcel");
    }
}
