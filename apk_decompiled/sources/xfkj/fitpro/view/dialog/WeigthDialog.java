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
import xfkj.fitpro.ui.activities.weight.WeightEnum;

/* JADX INFO: loaded from: classes4.dex */
public class WeigthDialog extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    WheelView f438q;
    TextView r;
    TextView s;
    TextView t;
    private ArrayList u;
    private ArrayList v;
    private WeightEnum w = null;
    private int x = -1;

    private int P() {
        int i = this.x;
        return i > 0 ? i : zm1.C();
    }

    private void Q() {
        this.f438q.setCyclic(true);
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
        for (int i = 20; i < 201; i++) {
            this.v.add(Integer.valueOf(i));
            WeightEnum weightEnum = this.w;
            if (weightEnum == null) {
                if (zm1.D() == d20.h) {
                    this.u.add(Integer.valueOf(i));
                } else {
                    this.u.add(Integer.valueOf(m83.b(i)));
                }
            } else if (weightEnum == WeightEnum.JIN) {
                this.u.add(Integer.valueOf(i * 2));
            } else {
                this.u.add(Integer.valueOf(i));
            }
        }
        int iIndexOf = this.v.indexOf(Integer.valueOf(P()));
        WheelView wheelView = this.f438q;
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        wheelView.setCurrentItem(iIndexOf);
        this.f438q.setDividerColor(0);
        this.f438q.setTextColorOut(Color.parseColor("#FFACABAF"));
        this.f438q.setTextColorCenter(nz.a(R.color.theme_color));
        this.f438q.setAdapter(new fa(this.u));
        this.f438q.setTextSize(15.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        y();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Q();
        this.s.setOnClickListener(new View.OnClickListener() { // from class: xh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: yh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.S(view);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_weight_dialog, (ViewGroup) null);
        this.f438q = (WheelView) viewInflate.findViewById(R.id.wheelview);
        this.r = (TextView) viewInflate.findViewById(R.id.tv_weight_unite);
        this.s = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        this.t = (TextView) viewInflate.findViewById(R.id.tv_ok);
        WeightEnum weightEnum = this.w;
        if (weightEnum == null) {
            this.r.setText(zm1.D() == d20.h ? "kg" : "lb");
        } else {
            this.r.setText(getString(weightEnum == WeightEnum.JIN ? R.string.jin : R.string.gong_jin));
        }
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
