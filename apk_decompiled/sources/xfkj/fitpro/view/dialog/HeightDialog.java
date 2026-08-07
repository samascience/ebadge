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
import defpackage.d20;
import defpackage.fa;
import defpackage.m83;
import defpackage.nz;
import defpackage.zm1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class HeightDialog extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    WheelView f431q;
    TextView r;
    TextView s;
    TextView t;
    private ArrayList u;
    private ArrayList v;

    private void P() {
        this.f431q.setCyclic(true);
        ArrayList arrayList = this.u;
        if (arrayList == null) {
            this.u = new ArrayList();
        } else {
            arrayList.clear();
        }
        ArrayList arrayList2 = this.v;
        if (arrayList2 == null) {
            this.v = new ArrayList();
        } else {
            arrayList2.clear();
        }
        for (int i = 50; i < 251; i++) {
            this.v.add(Integer.valueOf(i));
            if (zm1.l() == d20.j) {
                this.u.add(Integer.valueOf(i));
            } else {
                this.u.add(Integer.valueOf(m83.d(i)));
            }
        }
        int iIndexOf = this.v.indexOf(Integer.valueOf(zm1.k()));
        WheelView wheelView = this.f431q;
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        wheelView.setCurrentItem(iIndexOf);
        this.f431q.setDividerColor(0);
        this.f431q.setTextColorOut(Color.parseColor("#FFACABAF"));
        this.f431q.setTextColorCenter(nz.a(R.color.theme_color));
        this.f431q.setAdapter(new fa(this.u));
        this.f431q.setTextSize(15.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        zm1.e0(((Integer) this.v.get(this.f431q.getCurrentItem())).intValue());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        P();
        this.s.setOnClickListener(new View.OnClickListener() { // from class: lw0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: mw0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R(view);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_height_dialog, (ViewGroup) null);
        this.f431q = (WheelView) viewInflate.findViewById(R.id.wheelview);
        this.r = (TextView) viewInflate.findViewById(R.id.tv_unite);
        this.s = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        this.t = (TextView) viewInflate.findViewById(R.id.tv_ok);
        this.r.setText(zm1.l() == d20.j ? R.string.cm : R.string.inch);
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
