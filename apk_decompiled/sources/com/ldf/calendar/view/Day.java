package com.ldf.calendar.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.ldf.calendar.component.State;
import com.ldf.calendar.model.CalendarDate;

/* JADX INFO: loaded from: classes3.dex */
public class Day implements Parcelable {
    public static final Parcelable.Creator<Day> CREATOR = new a();
    private State a;
    private CalendarDate b;
    private int c;
    private int d;

    static class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Day createFromParcel(Parcel parcel) {
            return new Day(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Day[] newArray(int i) {
            return new Day[i];
        }
    }

    protected Day(Parcel parcel) {
        int i = parcel.readInt();
        this.a = i == -1 ? null : State.values()[i];
        this.b = (CalendarDate) parcel.readSerializable();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        State state = this.a;
        parcel.writeInt(state == null ? -1 : state.ordinal());
        parcel.writeSerializable(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
