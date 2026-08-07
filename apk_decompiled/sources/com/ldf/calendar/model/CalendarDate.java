package com.ldf.calendar.model;

import android.util.Log;
import defpackage.sa3;
import java.io.Serializable;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class CalendarDate implements Serializable {
    private static final long serialVersionUID = 1;
    public int day;
    public int month;
    public int year;

    public CalendarDate(int i, int i2, int i3) {
        if (i2 > 12) {
            i++;
            i2 = 1;
        } else if (i2 < 1) {
            i--;
            i2 = 12;
        }
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    public CalendarDate cloneSelf() {
        return new CalendarDate(this.year, this.month, this.day);
    }

    public boolean equals(CalendarDate calendarDate) {
        return calendarDate != null && getYear() == calendarDate.getYear() && getMonth() == calendarDate.getMonth() && getDay() == calendarDate.getDay();
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public CalendarDate modifyDay(int i) {
        int iE = sa3.e(this.year, this.month - 1);
        if (i > sa3.e(this.year, this.month)) {
            CalendarDate calendarDate = new CalendarDate(this.year, this.month, this.day);
            Log.e("ldf", "移动天数过大");
            return calendarDate;
        }
        if (i > 0) {
            return new CalendarDate(this.year, this.month, i);
        }
        if (i > 0 - iE) {
            return new CalendarDate(this.year, this.month - 1, iE + i);
        }
        CalendarDate calendarDate2 = new CalendarDate(this.year, this.month, this.day);
        Log.e("ldf", "移动天数过大");
        return calendarDate2;
    }

    public CalendarDate modifyMonth(int i) {
        CalendarDate calendarDate = new CalendarDate();
        int i2 = this.month + i;
        if (i > 0) {
            if (i2 > 12) {
                calendarDate.setYear(this.year + ((i2 - 1) / 12));
                int i3 = i2 % 12;
                calendarDate.setMonth(i3 != 0 ? i3 : 12);
            } else {
                calendarDate.setYear(this.year);
                calendarDate.setMonth(i2);
            }
        } else if (i2 == 0) {
            calendarDate.setYear(this.year - 1);
            calendarDate.setMonth(12);
        } else if (i2 < 0) {
            calendarDate.setYear((this.year + (i2 / 12)) - 1);
            int iAbs = 12 - (Math.abs(i2) % 12);
            calendarDate.setMonth(iAbs != 0 ? iAbs : 12);
        } else {
            calendarDate.setYear(this.year);
            if (i2 == 0) {
                i2 = 12;
            }
            calendarDate.setMonth(i2);
        }
        return calendarDate;
    }

    public CalendarDate modifyWeek(int i) {
        CalendarDate calendarDate = new CalendarDate();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.year);
        calendar.set(2, this.month - 1);
        calendar.set(5, this.day);
        calendar.add(5, i * 7);
        calendarDate.setYear(calendar.get(1));
        calendarDate.setMonth(calendar.get(2) + 1);
        calendarDate.setDay(calendar.get(5));
        return calendarDate;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public void setMonth(int i) {
        this.month = i;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public String toString() {
        Object objValueOf;
        Object objValueOf2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.year);
        sb.append("-");
        int i = this.month;
        if (i < 10) {
            objValueOf = "0" + this.month;
        } else {
            objValueOf = Integer.valueOf(i);
        }
        sb.append(objValueOf);
        sb.append("-");
        int i2 = this.day;
        if (i2 < 10) {
            objValueOf2 = "0" + this.day;
        } else {
            objValueOf2 = Integer.valueOf(i2);
        }
        sb.append(objValueOf2);
        return sb.toString();
    }

    public CalendarDate() {
        this.year = sa3.g();
        this.month = sa3.d();
        this.day = sa3.c();
    }
}
