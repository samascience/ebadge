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
public final class ActivityJliOtaactivityBinding implements wd3 {
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView tvUpgrade;

    private ActivityJliOtaactivityBinding(LinearLayout linearLayout, ProgressBar progressBar, TextView textView) {
        this.rootView = linearLayout;
        this.progressBar = progressBar;
        this.tvUpgrade = textView;
    }

    public static ActivityJliOtaactivityBinding bind(View view) {
        int i = R.id.progressBar;
        ProgressBar progressBar = (ProgressBar) zd3.a(view, i);
        if (progressBar != null) {
            i = R.id.tv_upgrade;
            TextView textView = (TextView) zd3.a(view, i);
            if (textView != null) {
                return new ActivityJliOtaactivityBinding((LinearLayout) view, progressBar, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityJliOtaactivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityJliOtaactivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_jli_otaactivity, viewGroup, false);
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
