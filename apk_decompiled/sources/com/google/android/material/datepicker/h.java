package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import defpackage.az1;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
class h extends BaseAdapter {
    static final int g = m.m().getMaximum(4);
    private static final int h = (m.m().getMaximum(5) + m.m().getMaximum(7)) - 1;
    final Month a;
    final DateSelector b;
    private Collection c;
    b d;
    final CalendarConstraints e;
    final DayViewDecorator f;

    h(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.a = month;
        this.b = dateSelector;
        this.e = calendarConstraints;
        this.f = dayViewDecorator;
        this.c = dateSelector.t0();
    }

    private String c(Context context, long j) {
        return f.e(context, j, l(j), k(j), g(j));
    }

    private void f(Context context) {
        if (this.d == null) {
            this.d = new b(context);
        }
    }

    private boolean j(long j) {
        Iterator it = this.b.t0().iterator();
        while (it.hasNext()) {
            if (m.a(j) == m.a(((Long) it.next()).longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j) {
        return m.k().getTimeInMillis() == j;
    }

    private void o(TextView textView, long j, int i) {
        boolean z;
        a aVar;
        a aVar2;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String strC = c(context, j);
        textView.setContentDescription(strC);
        boolean zK0 = this.e.g().k0(j);
        if (zK0) {
            textView.setEnabled(true);
            boolean zJ = j(j);
            textView.setSelected(zJ);
            if (zJ) {
                aVar2 = this.d.b;
            } else {
                aVar2 = l(j) ? this.d.c : this.d.a;
            }
            aVar = aVar2;
            z = zJ;
        } else {
            textView.setEnabled(false);
            z = false;
            aVar = this.d.g;
        }
        DayViewDecorator dayViewDecorator = this.f;
        if (dayViewDecorator == null || i == -1) {
            aVar.d(textView);
            return;
        }
        Month month = this.a;
        int i2 = month.c;
        int i3 = month.b;
        ColorStateList colorStateListA = dayViewDecorator.a(context, i2, i3, i, zK0, z);
        boolean z2 = z;
        aVar.e(textView, colorStateListA, this.f.g(context, i2, i3, i, zK0, z2));
        Drawable drawableC = this.f.c(context, i2, i3, i, zK0, z2);
        Drawable drawableE = this.f.e(context, i2, i3, i, zK0, z2);
        Drawable drawableD = this.f.d(context, i2, i3, i, zK0, z2);
        boolean z3 = z;
        textView.setCompoundDrawables(drawableC, drawableE, drawableD, this.f.b(context, i2, i3, i, zK0, z3));
        textView.setContentDescription(this.f.f(context, i2, i3, i, zK0, z3, strC));
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.c(j).equals(this.a)) {
            int iG = this.a.g(j);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(iG) - materialCalendarGridView.getFirstVisiblePosition()), j, iG);
        }
    }

    int a(int i) {
        return b() + (i - 1);
    }

    int b() {
        return this.a.e(this.e.i());
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < b() || i > m()) {
            return null;
        }
        return Long.valueOf(this.a.f(n(i)));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0054  */
    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public TextView getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        f(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day, viewGroup, false);
        }
        int iB = i - b();
        if (iB >= 0) {
            Month month = this.a;
            if (iB >= month.e) {
                textView.setVisibility(8);
                textView.setEnabled(false);
                i2 = -1;
            } else {
                i2 = iB + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
            i2 = -1;
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        o(textView, item.longValue(), i2);
        return textView;
    }

    boolean g(long j) {
        Iterator it = this.b.C().iterator();
        while (it.hasNext()) {
            Object obj = ((az1) it.next()).b;
            if (obj != null && ((Long) obj).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.a.d;
    }

    boolean h(int i) {
        return i % this.a.d == 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    boolean i(int i) {
        return (i + 1) % this.a.d == 0;
    }

    boolean k(long j) {
        Iterator it = this.b.C().iterator();
        while (it.hasNext()) {
            Object obj = ((az1) it.next()).a;
            if (obj != null && ((Long) obj).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    int m() {
        return (b() + this.a.e) - 1;
    }

    int n(int i) {
        return (i - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            p(materialCalendarGridView, ((Long) it.next()).longValue());
        }
        DateSelector dateSelector = this.b;
        if (dateSelector != null) {
            Iterator it2 = dateSelector.t0().iterator();
            while (it2.hasNext()) {
                p(materialCalendarGridView, ((Long) it2.next()).longValue());
            }
            this.c = this.b.t0();
        }
    }

    boolean r(int i) {
        return i >= b() && i <= m();
    }
}
