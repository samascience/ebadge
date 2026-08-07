package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public final class w11 implements wd3 {
    private final LinearLayout a;
    public final CheckBox b;
    public final TextView c;

    private w11(LinearLayout linearLayout, CheckBox checkBox, TextView textView) {
        this.a = linearLayout;
        this.b = checkBox;
        this.c = textView;
    }

    public static w11 bind(View view) {
        int i = R.id.cx_protocol;
        CheckBox checkBox = (CheckBox) zd3.a(view, R.id.cx_protocol);
        if (checkBox != null) {
            i = R.id.tv_user_private_procity;
            TextView textView = (TextView) zd3.a(view, R.id.tv_user_private_procity);
            if (textView != null) {
                return new w11((LinearLayout) view, checkBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static w11 inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // defpackage.wd3
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static w11 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.include_layout_private_protocol, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
