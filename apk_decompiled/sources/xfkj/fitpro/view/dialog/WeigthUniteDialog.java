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
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.d20;
import defpackage.zm1;

/* JADX INFO: loaded from: classes4.dex */
public class WeigthUniteDialog extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    TextView f439q;
    TextView r;
    Button s;
    private Context t;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        zm1.i0(d20.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
        zm1.i0(d20.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f439q.setOnClickListener(new View.OnClickListener() { // from class: zh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q(view);
            }
        });
        this.r.setOnClickListener(new View.OnClickListener() { // from class: ai3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: bi3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.S(view);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.t = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_weight_unite_dialog, (ViewGroup) null);
        this.f439q = (TextView) viewInflate.findViewById(R.id.tv_kg);
        this.r = (TextView) viewInflate.findViewById(R.id.tv_pound);
        this.s = (Button) viewInflate.findViewById(R.id.btn_cancel);
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
