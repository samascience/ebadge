package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import defpackage.be3;

/* JADX INFO: loaded from: classes3.dex */
class i extends RecyclerView.Adapter {
    private final CalendarConstraints a;
    private final DateSelector b;
    private final DayViewDecorator c;
    private final MaterialCalendar.l d;
    private final int e;

    class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ MaterialCalendarGridView a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getAdapter().r(i)) {
                i.this.d.a(this.a.getAdapter().getItem(i).longValue());
            }
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        final TextView a;
        final MaterialCalendarGridView b;

        b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.a = textView;
            be3.q0(textView, true);
            this.b = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    i(Context context, DateSelector dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.l lVar) {
        Month monthL = calendarConstraints.l();
        Month monthH = calendarConstraints.h();
        Month monthK = calendarConstraints.k();
        if (monthL.compareTo(monthK) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthK.compareTo(monthH) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.e = (h.g * MaterialCalendar.K(context)) + (MaterialDatePicker.c0(context) ? MaterialCalendar.K(context) : 0);
        this.a = calendarConstraints;
        this.b = dateSelector;
        this.c = dayViewDecorator;
        this.d = lVar;
        setHasStableIds(true);
    }

    Month d(int i) {
        return this.a.l().j(i);
    }

    CharSequence e(int i) {
        return d(i).h();
    }

    int f(Month month) {
        return this.a.l().k(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        Month monthJ = this.a.l().j(i);
        bVar.a.setText(monthJ.h());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.b.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthJ.equals(materialCalendarGridView.getAdapter().a)) {
            h hVar = new h(monthJ, this.b, this.a, this.c);
            materialCalendarGridView.setNumColumns(monthJ.d);
            materialCalendarGridView.setAdapter((ListAdapter) hVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().q(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.a.l().j(i).i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.c0(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.e));
        return new b(linearLayout, true);
    }
}
