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
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.jdqm.tapelibrary.TapeView;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.zm1;

/* JADX INFO: loaded from: classes4.dex */
public class StepsChoiseDialog extends DialogFragment {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f433q;
    public TapeView r;
    public TextView s;
    public TextView t;
    private Context u;
    private int v = 2000;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(float f) {
        int i = (int) f;
        this.v = i;
        this.f433q.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.v = zm1.u();
        this.r.setOnValueChangeListener(new TapeView.a() { // from class: iu2
            @Override // com.jdqm.tapelibrary.TapeView.a
            public final void a(float f) {
                this.a.Q(f);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: ju2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.R(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: ku2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.S(view);
            }
        });
        this.r.g(this.v, 1000.0f, 20000.0f, 100.0f, 10);
        this.f433q.setText(this.v + Constants.STR_EMPTY);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u = getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_steps_choise_dialog, (ViewGroup) null);
        this.f433q = (TextView) viewInflate.findViewById(R.id.tv_steps);
        this.r = (TapeView) viewInflate.findViewById(R.id.tapeView);
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
