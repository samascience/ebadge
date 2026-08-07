package xfkj.fitpro.view.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
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
public class CalendarSportDialog extends BaseDialogFragment {
    private ImageButton r;
    private TextView s;
    private ImageButton t;
    private MonthPager u;
    private CalendarDate v;
    private View w;
    private final int x = 1;
    private final int y = 2;
    private final int z = 3;
    private Handler F = new Handler(new a());

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                CalendarSportDialog.this.w.setVisibility(8);
            } else if (i == 2) {
                CalendarSportDialog.this.w.setVisibility(0);
            } else if (i == 3) {
                CalendarSportDialog.this.d0();
            }
            return false;
        }
    }

    class b implements ViewPager.k {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.k
        public void transformPage(View view, float f) {
            view.setAlpha((float) Math.sqrt(1.0f - Math.abs(f)));
        }
    }

    class c implements MonthPager.b {
        c() {
        }

        @Override // com.ldf.calendar.view.MonthPager.b
        public void onPageScrollStateChanged(int i) {
        }

        @Override // com.ldf.calendar.view.MonthPager.b
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.ldf.calendar.view.MonthPager.b
        public void onPageSelected(int i) {
            CalendarSportDialog.V(CalendarSportDialog.this);
            throw null;
        }
    }

    static /* bridge */ /* synthetic */ dq V(CalendarSportDialog calendarSportDialog) {
        calendarSportDialog.getClass();
        return null;
    }

    private void Y() {
        this.u.setAdapter(null);
        this.u.setCurrentItem(MonthPager.z0);
        this.u.R(false, new b());
        this.u.a0(new c());
        CalendarDate calendarDate = this.v;
        if (calendarDate == null) {
            this.s.setText(new CalendarDate().toString());
        } else {
            this.s.setText(calendarDate.toString());
        }
    }

    private void Z() {
        this.r.setOnClickListener(new View.OnClickListener() { // from class: aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a0(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: bq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b0(view);
            }
        });
        this.w.setOnTouchListener(new View.OnTouchListener() { // from class: cq
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.a.c0(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        MonthPager monthPager = this.u;
        monthPager.setCurrentItem(monthPager.getCurrentPosition() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        MonthPager monthPager = this.u;
        monthPager.setCurrentItem(monthPager.getCurrentPosition() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c0(View view, MotionEvent motionEvent) {
        y();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        super.y();
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    protected BaseDialogFragment.a N() {
        return new BaseDialogFragment.a().i(true).k(48).j(0.0f).l(ml2.a()).h(R.style.summary_pop_anim);
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    public void O(Bundle bundle, View view) {
        this.u = (MonthPager) view.findViewById(R.id.calendar_view);
        this.s = (TextView) view.findViewById(R.id.tv_calendar);
        this.r = (ImageButton) view.findViewById(R.id.cl_img_btn_left);
        this.t = (ImageButton) view.findViewById(R.id.cl_img_btn_right);
        View viewFindViewById = view.findViewById(R.id.view_space);
        this.w = viewFindViewById;
        viewFindViewById.setAlpha(0.5f);
        this.w.setVisibility(4);
        Y();
        Z();
        this.F.sendEmptyMessageDelayed(2, 550L);
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment
    public int P() {
        return R.layout.layout_dialog_calendar_sport;
    }

    @Override // xfkj.fitpro.view.dialog.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.F.removeMessages(1);
        this.F.removeMessages(2);
        this.F.removeMessages(3);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void y() {
        this.w.setVisibility(8);
        this.F.sendEmptyMessageDelayed(3, 100L);
    }
}
