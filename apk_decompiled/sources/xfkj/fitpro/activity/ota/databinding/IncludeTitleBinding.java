package xfkj.fitpro.activity.ota.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.wd3;
import defpackage.zd3;
import xfkj.fitpro.activity.ota.R;

/* JADX INFO: loaded from: classes4.dex */
public final class IncludeTitleBinding implements wd3 {
    public final ImageView ivBack;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private IncludeTitleBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.ivBack = imageView;
        this.tvTitle = textView;
    }

    public static IncludeTitleBinding bind(View view) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) zd3.a(view, i);
        if (imageView != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) zd3.a(view, i);
            if (textView != null) {
                return new IncludeTitleBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static IncludeTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static IncludeTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.include_title, viewGroup, false);
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
