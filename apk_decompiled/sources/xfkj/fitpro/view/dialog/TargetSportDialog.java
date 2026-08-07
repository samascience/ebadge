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
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.contrarywind.view.WheelView;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.fa;
import defpackage.nz;
import defpackage.zm1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class TargetSportDialog extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    WheelView f437q;
    TextView r;
    TextView s;
    TextView t;
    private Context u;
    private ArrayList v;
    private EditText w;
    private View x;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TargetSportDialog.this.getClass();
        }
    }

    public class b {
        float a;
        int b;

        public b(float f, int i) {
            this.a = f;
            this.b = i;
        }

        public int a() {
            return this.b;
        }

        public void b(int i) {
            this.b = i;
        }

        public String toString() {
            TargetSportDialog targetSportDialog;
            int i;
            if (this.b >= 2) {
                return TargetSportDialog.this.getString(R.string.custom);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(TargetSportDialog.this.Q(this.a) ? String.valueOf(this.a) : String.valueOf((int) this.a));
            if (this.b == 0) {
                targetSportDialog = TargetSportDialog.this;
                i = R.string.min;
            } else {
                targetSportDialog = TargetSportDialog.this;
                i = R.string.hour;
            }
            sb.append(targetSportDialog.getString(i));
            return sb.toString();
        }
    }

    private void P() {
        this.f437q.setCyclic(false);
        this.v = new ArrayList();
        ArrayList arrayList = new ArrayList();
        for (int i = 5; i < 125; i += 5) {
            this.v.add(new b(i, 0));
            arrayList.add(Integer.valueOf(i));
        }
        int iIndexOf = arrayList.indexOf(Integer.valueOf(zm1.t()));
        WheelView wheelView = this.f437q;
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        wheelView.setCurrentItem(iIndexOf);
        this.f437q.setDividerColor(0);
        this.f437q.setTextColorOut(Color.parseColor("#FFACABAF"));
        this.f437q.setTextColorCenter(nz.a(R.color.theme_color));
        this.f437q.setAdapter(new fa(this.v));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q(float f) {
        return (f * 10.0f) % 10.0f != 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        b bVar = (b) this.v.get(this.f437q.getCurrentItem());
        if (bVar.a() != 2) {
            this.x.setVisibility(8);
            this.f437q.setVisibility(0);
        } else if (this.x.getVisibility() != 8) {
            bVar.b(1);
        } else {
            this.x.setVisibility(0);
            this.f437q.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        P();
        this.s.setOnClickListener(new a());
        this.t.setOnClickListener(new View.OnClickListener() { // from class: n03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R(view);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_dialog_target_sport, (ViewGroup) null);
        this.f437q = (WheelView) viewInflate.findViewById(R.id.wheelview);
        this.r = (TextView) viewInflate.findViewById(R.id.tv_unite);
        this.s = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        this.t = (TextView) viewInflate.findViewById(R.id.tv_ok);
        this.w = (EditText) viewInflate.findViewById(R.id.edt_content);
        this.x = viewInflate.findViewById(R.id.ll_target);
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
