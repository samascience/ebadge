package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes3.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    private final Calendar a;
    final int b;
    final int c;
    final int d;
    final int e;
    final long f;
    private String g;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i) {
            return new Month[i];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarE = m.e(calendar);
        this.a = calendarE;
        this.b = calendarE.get(2);
        this.c = calendarE.get(1);
        this.d = calendarE.getMaximum(7);
        this.e = calendarE.getActualMaximum(5);
        this.f = calendarE.getTimeInMillis();
    }

    static Month b(int i, int i2) {
        Calendar calendarM = m.m();
        calendarM.set(1, i);
        calendarM.set(2, i2);
        return new Month(calendarM);
    }

    static Month c(long j) {
        Calendar calendarM = m.m();
        calendarM.setTimeInMillis(j);
        return new Month(calendarM);
    }

    static Month d() {
        return new Month(m.k());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.a.compareTo(month.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int e(int i) {
        int i2 = this.a.get(7);
        if (i <= 0) {
            i = this.a.getFirstDayOfWeek();
        }
        int i3 = i2 - i;
        return i3 < 0 ? i3 + this.d : i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.b == month.b && this.c == month.c;
    }

    long f(int i) {
        Calendar calendarE = m.e(this.a);
        calendarE.set(5, i);
        return calendarE.getTimeInMillis();
    }

    int g(long j) {
        Calendar calendarE = m.e(this.a);
        calendarE.setTimeInMillis(j);
        return calendarE.get(5);
    }

    String h() {
        if (this.g == null) {
            this.g = f.l(this.a.getTimeInMillis());
        }
        return this.g;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    long i() {
        return this.a.getTimeInMillis();
    }

    Month j(int i) {
        Calendar calendarE = m.e(this.a);
        calendarE.add(2, i);
        return new Month(calendarE);
    }

    int k(Month month) {
        if (this.a instanceof GregorianCalendar) {
            return ((month.c - this.c) * 12) + (month.b - this.b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.b);
    }
}
