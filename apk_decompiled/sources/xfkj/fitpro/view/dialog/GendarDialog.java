package xfkj.fitpro.view.dialog;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.DialogFragment;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.zm1;

/* JADX INFO: loaded from: classes4.dex */
public class GendarDialog extends DialogFragment implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Context f430q;
    private RadioButton r;
    private RadioButton s;
    private RadioGroup t;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.t.setOnCheckedChangeListener(this);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        radioGroup.getCheckedRadioButtonId();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f430q = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_gendar_dialog, (ViewGroup) null);
        int i = R.id.rad_man;
        this.r = (RadioButton) viewInflate.findViewById(R.id.rad_man);
        this.s = (RadioButton) viewInflate.findViewById(R.id.rad_wman);
        RadioGroup radioGroup = (RadioGroup) viewInflate.findViewById(R.id.rad_grp);
        this.t = radioGroup;
        if (zm1.j() != 1) {
            i = R.id.rad_wman;
        }
        radioGroup.check(i);
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
