package com.github.mikephil.charting.data;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import defpackage.lg;

/* JADX INFO: loaded from: classes.dex */
public class Entry extends lg implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new a();
    private float d;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Entry[] newArray(int i) {
            return new Entry[i];
        }
    }

    protected Entry(Parcel parcel) {
        this.d = 0.0f;
        this.d = parcel.readFloat();
        d(parcel.readFloat());
        if (parcel.readInt() == 1) {
            c(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Entry, x: " + this.d + " y: " + b();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.d);
        parcel.writeFloat(b());
        if (a() == null) {
            parcel.writeInt(0);
        } else {
            if (!(a() instanceof Parcelable)) {
                throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
            }
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) a(), i);
        }
    }
}
