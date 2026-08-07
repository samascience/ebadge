package xfkj.fitpro.view.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.ldf.calendar.model.CalendarDate;
import com.ldf.calendar.view.MonthPager;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.dq;
import defpackage.ml2;

/* JADX INFO: loaded from: classes4.dex */
public class CalendarDialog extends BaseDialogFragment {
    private ImageButton r;
    private TextView s;
    private ImageButton t;
    private MonthPager u;
    private CalendarDate v;

    class a implements ViewPager.k {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.k
        public void transformPage(View view, float f) {
            view.setAlpha((float) Math.sqrt(1.0f - Math.abs(f)));
        }
    }

    class b implements MonthPager.b {
        b() {
        }

        @Override // com.ldf.calendar.view.MonthPager.b
        public void onPageScrollStateChanged(int i) {
        }

        @Override // com.ldf.calendar.view.MonthPager.b
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.ldf.calendar.view.MonthPager.b
        public void onPageSelected(int i) {
            CalendarDialog.U(CalendarDialog.this);
            throw null;
        }
    }

    static /* bridge */ /* synthetic */ dq U(CalendarDialog calendarDialog) {
        calendarDialog.getClass();
        return null;
    }

    private void V() {
        this.u.setAdapter(null);
        this.u.setCurrentItem(MonthPager.z0);
        this.u.R(false, new a());
        this.u.a0(new b());
        CalendarDate calendarDate = this.v;
        if (calendarDate == null) {
            this.s.setText(new CalendarDate().toString());
        } else {
            this.s.setText(calendarDate.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        MonthPager monthPager = this.u;
        monthPager.setCurrentItem(monthPager.getCurrentPosition() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        MonthPager monthPager = this.u;
        monthPager.setCurrentItem(monthPager.getCurrentPosition() + 1);
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    protected BaseDialogFragment.a N() {
        return new BaseDialogFragment.a().i(true).k(17).l(ml2.a() - 40);
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    public void O(Bundle bundle, View view) {
        this.u = (MonthPager) view.findViewById(R.id.calendar_view);
        this.s = (TextView) view.findViewById(R.id.tv_calendar);
        this.r = (ImageButton) view.findViewById(R.id.cl_img_btn_left);
        this.t = (ImageButton) view.findViewById(R.id.cl_img_btn_right);
        V();
        W();
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    public int P() {
        return R.layout.layout_dialog_calendar;
    }

    protected void W() {
        this.r.setOnClickListener(new View.OnClickListener() { // from class: yp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.X(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: zp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Y(view);
            }
        });
    }
}
