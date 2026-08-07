package xfkj.fitpro.activity.ota.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import defpackage.wd3;
import defpackage.zd3;
import xfkj.fitpro.activity.ota.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogLoadingBinding implements wd3 {
    public final LinearLayout dialogLoadingView;
    public final ProgressBar progressBar1;
    private final LinearLayout rootView;
    public final TextView tipTextView;

    private DialogLoadingBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, TextView textView) {
        this.rootView = linearLayout;
        this.dialogLoadingView = linearLayout2;
        this.progressBar1 = progressBar;
        this.tipTextView = textView;
    }

    public static DialogLoadingBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.progressBar1;
        ProgressBar progressBar = (ProgressBar) zd3.a(view, i);
        if (progressBar != null) {
            i = R.id.tipTextView;
            TextView textView = (TextView) zd3.a(view, i);
            if (textView != null) {
                return new DialogLoadingBinding(linearLayout, linearLayout, progressBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogLoadingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_loading, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // defpackage.wd3
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
