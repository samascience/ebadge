package com.thoughtbot.expandablerecyclerview.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExpandableGroup<T extends Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ExpandableGroup> CREATOR = new a();
    private String a;
    private List b;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpandableGroup createFromParcel(Parcel parcel) {
            return new ExpandableGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ExpandableGroup[] newArray(int i) {
            return new ExpandableGroup[i];
        }
    }

    protected ExpandableGroup(Parcel parcel) {
        this.a = parcel.readString();
        byte b = parcel.readByte();
        int i = parcel.readInt();
        if (b != 1) {
            this.b = null;
            return;
        }
        this.b = new ArrayList(i);
        parcel.readList(this.b, ((Class) parcel.readSerializable()).getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ExpandableGroup{title='" + this.a + "', items=" + this.b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        if (this.b == null) {
            parcel.writeByte((byte) 0);
            parcel.writeInt(0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.b.size());
        if (this.b.size() > 0) {
            parcel.writeSerializable(((Parcelable) this.b.get(0)).getClass());
        }
        parcel.writeList(this.b);
    }
}
