package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.tt1;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    private final Month a;
    private final Month b;
    private final DateValidator c;
    private Month d;
    private final int e;
    private final int f;
    private final int g;

    public interface DateValidator extends Parcelable {
        boolean k0(long j);
    }

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    }

    public static final class b {
        static final long f = m.a(Month.b(1900, 0).f);
        static final long g = m.a(Month.b(2100, 11).f);
        private long a;
        private long b;
        private Long c;
        private int d;
        private DateValidator e;

        b(CalendarConstraints calendarConstraints) {
            this.a = f;
            this.b = g;
            this.e = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.a = calendarConstraints.a.f;
            this.b = calendarConstraints.b.f;
            this.c = Long.valueOf(calendarConstraints.d.f);
            this.d = calendarConstraints.e;
            this.e = calendarConstraints.c;
        }

        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.e);
            Month monthC = Month.c(this.a);
            Month monthC2 = Month.c(this.b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l = this.c;
            return new CalendarConstraints(monthC, monthC2, dateValidator, l == null ? null : Month.c(l.longValue()), this.d, null);
        }

        public b b(long j) {
            this.c = Long.valueOf(j);
            return this;
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i, a aVar) {
        this(month, month2, dateValidator, month3, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.a.equals(calendarConstraints.a) && this.b.equals(calendarConstraints.b) && tt1.a(this.d, calendarConstraints.d) && this.e == calendarConstraints.e && this.c.equals(calendarConstraints.c);
    }

    Month f(Month month) {
        if (month.compareTo(this.a) < 0) {
            return this.a;
        }
        return month.compareTo(this.b) > 0 ? this.b : month;
    }

    public DateValidator g() {
        return this.c;
    }

    Month h() {
        return this.b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.d, Integer.valueOf(this.e), this.c});
    }

    int i() {
        return this.e;
    }

    int j() {
        return this.g;
    }

    Month k() {
        return this.d;
    }

    Month l() {
        return this.a;
    }

    int m() {
        return this.f;
    }

    boolean n(long j) {
        if (this.a.f(1) <= j) {
            Month month = this.b;
            if (j <= month.f(month.e)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, 0);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.d, 0);
        parcel.writeParcelable(this.c, 0);
        parcel.writeInt(this.e);
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.a = month;
        this.b = month2;
        this.d = month3;
        this.e = i;
        this.c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > m.m().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.g = month.k(month2) + 1;
        this.f = (month2.c - month.c) + 1;
    }
}
