package xfkj.fitpro.view.dialog;

import android.content.Context;
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
public class AgeDialog extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    WheelView f426q;
    TextView r;
    TextView s;
    TextView t;
    private Context u;
    private ArrayList v;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AgeDialog.this.getClass();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AgeDialog.this.getClass();
        }
    }

    private void N() {
        this.f426q.setCyclic(true);
        this.v = new ArrayList();
        for (int i = 6; i < 150; i++) {
            this.v.add(Integer.valueOf(i));
        }
        int iIndexOf = this.v.indexOf(Integer.valueOf(zm1.c()));
        WheelView wheelView = this.f426q;
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        wheelView.setCurrentItem(iIndexOf);
        this.f426q.setDividerColor(0);
        this.f426q.setTextColorOut(Color.parseColor("#FFACABAF"));
        this.f426q.setTextColorCenter(nz.a(R.color.theme_color));
        this.f426q.setAdapter(new fa(this.v));
        this.f426q.setTextSize(15.0f);
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
        this.u = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_age_dialog, (ViewGroup) null);
        this.f426q = (WheelView) viewInflate.findViewById(R.id.wheelview);
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
