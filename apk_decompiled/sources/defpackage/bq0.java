package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class bq0 extends ViewDataBinding {
    public final CalendarView z;

    protected bq0(Object obj, View view, int i, CalendarView calendarView) {
        super(obj, view, i);
        this.z = calendarView;
    }

    public static bq0 H(View view, Object obj) {
        return (bq0) ViewDataBinding.f(obj, view, R.layout.fragment_dialog_common_time_picker);
    }

    public static bq0 I(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (bq0) ViewDataBinding.p(layoutInflater, R.layout.fragment_dialog_common_time_picker, viewGroup, z, obj);
    }

    public static bq0 J(LayoutInflater layoutInflater, Object obj) {
        return (bq0) ViewDataBinding.p(layoutInflater, R.layout.fragment_dialog_common_time_picker, null, false, obj);
    }

    public static bq0 bind(View view) {
        e.d();
        return H(view, null);
    }

    public static bq0 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        e.d();
        return I(layoutInflater, viewGroup, z, null);
    }

    public static bq0 inflate(LayoutInflater layoutInflater) {
        e.d();
        return J(layoutInflater, null);
    }
}
