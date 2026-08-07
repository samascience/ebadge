package xfkj.fitpro.view.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.contrarywind.view.WheelView;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.fa;
import defpackage.nz;
import defpackage.zm1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class TargetCalDialog extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    WheelView f435q;
    TextView r;
    TextView s;
    TextView t;
    private ArrayList u;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TargetCalDialog.this.getClass();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TargetCalDialog.this.getClass();
        }
    }

    private void N() {
        this.f435q.setCyclic(true);
        this.u = new ArrayList();
        for (int i = 10; i <= 5000; i += 10) {
            this.u.add(Integer.valueOf(i));
        }
        int iIndexOf = this.u.indexOf(Integer.valueOf(zm1.r()));
        WheelView wheelView = this.f435q;
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        wheelView.setCurrentItem(iIndexOf);
        this.f435q.setDividerColor(0);
        this.f435q.setTextColorOut(Color.parseColor("#FFACABAF"));
        this.f435q.setTextColorCenter(nz.a(R.color.theme_color));
        this.f435q.setAdapter(new fa(this.u));
        this.f435q.setTextSize(15.0f);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        N();
        this.s.setOnClickListener(new a());
        this.t.setOnClickListener(new b());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_target_cal, (ViewGroup) null);
        this.f435q = (WheelView) viewInflate.findViewById(R.id.wheelview);
        this.r = (TextView) viewInflate.findViewById(R.id.tv_unite);
        this.s = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        this.t = (TextView) viewInflate.findViewById(R.id.tv_ok);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = B().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }
}
