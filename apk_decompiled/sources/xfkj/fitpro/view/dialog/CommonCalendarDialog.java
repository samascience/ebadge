package xfkj.fitpro.view.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import androidx.databinding.ViewDataBinding;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.bq0;
import defpackage.e33;
import defpackage.ml2;
import defpackage.p31;
import java.util.Date;
import xfkj.fitpro.view.dialog.CommonCalendarDialog;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonCalendarDialog extends BindingBaseDialogFragment<bq0> {
    private Date w;
    private CalendarView.OnDateChangeListener x;

    public CommonCalendarDialog() {
        super(R.layout.fragment_dialog_common_time_picker);
        Date dateE = e33.e();
        p31.e(dateE, "getNowDate(...)");
        this.w = dateE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(CommonCalendarDialog commonCalendarDialog, CalendarView calendarView, int i, int i2, int i3) {
        CalendarView.OnDateChangeListener onDateChangeListener = commonCalendarDialog.x;
        if (onDateChangeListener == null) {
            commonCalendarDialog.y();
            return;
        }
        p31.c(onDateChangeListener);
        p31.c(calendarView);
        onDateChangeListener.onSelectedDayChange(calendarView, i, i2, i3);
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    protected BindingBaseDialogFragment.a N() {
        return new BindingBaseDialogFragment.a().a(true).k(17).m(ml2.a() - d.c(20.0f));
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    public void O(Bundle bundle, View view) {
        ViewDataBinding viewDataBindingQ = Q();
        p31.c(viewDataBindingQ);
        ((bq0) viewDataBindingQ).z.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { // from class: zz
            @Override // android.widget.CalendarView.OnDateChangeListener
            public final void onSelectedDayChange(CalendarView calendarView, int i, int i2, int i3) {
                CommonCalendarDialog.T(this.a, calendarView, i, i2, i3);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewDataBinding viewDataBindingQ = Q();
        p31.c(viewDataBindingQ);
        ((bq0) viewDataBindingQ).z.setDate(e33.a(this.w));
    }
}
