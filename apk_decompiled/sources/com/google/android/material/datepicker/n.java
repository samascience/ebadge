package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class n extends RecyclerView.Adapter {
    private final MaterialCalendar a;

    class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n.this.a.P(n.this.a.G().f(Month.b(this.a, n.this.a.I().b)));
            n.this.a.Q(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    public static class b extends RecyclerView.ViewHolder {
        final TextView a;

        b(TextView textView) {
            super(textView);
            this.a = textView;
        }
    }

    n(MaterialCalendar materialCalendar) {
        this.a = materialCalendar;
    }

    private View.OnClickListener d(int i) {
        return new a(i);
    }

    int e(int i) {
        return i - this.a.G().l().c;
    }

    int f(int i) {
        return this.a.G().l().c + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        int iF = f(i);
        bVar.a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iF)));
        TextView textView = bVar.a;
        textView.setContentDescription(f.k(textView.getContext(), iF));
        com.google.android.material.datepicker.b bVarH = this.a.H();
        Calendar calendarK = m.k();
        com.google.android.material.datepicker.a aVar = calendarK.get(1) == iF ? bVarH.f : bVarH.d;
        Iterator it = this.a.J().t0().iterator();
        while (it.hasNext()) {
            calendarK.setTimeInMillis(((Long) it.next()).longValue());
            if (calendarK.get(1) == iF) {
                aVar = bVarH.e;
            }
        }
        aVar.d(bVar.a);
        bVar.a.setOnClickListener(d(iF));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.G().m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
