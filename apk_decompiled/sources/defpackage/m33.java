package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.view.RxRunTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class m33 implements wd3 {
    private final LinearLayout a;
    public final ImageView b;
    public final ImageView c;
    public final RelativeLayout d;
    public final RxRunTextView e;

    private m33(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RxRunTextView rxRunTextView) {
        this.a = linearLayout;
        this.b = imageView;
        this.c = imageView2;
        this.d = relativeLayout;
        this.e = rxRunTextView;
    }

    public static m33 bind(View view) {
        int i = R.id.left_btn;
        ImageView imageView = (ImageView) zd3.a(view, R.id.left_btn);
        if (imageView != null) {
            i = R.id.right_btn;
            ImageView imageView2 = (ImageView) zd3.a(view, R.id.right_btn);
            if (imageView2 != null) {
                i = R.id.title_back;
                RelativeLayout relativeLayout = (RelativeLayout) zd3.a(view, R.id.title_back);
                if (relativeLayout != null) {
                    i = R.id.titles;
                    RxRunTextView rxRunTextView = (RxRunTextView) zd3.a(view, R.id.titles);
                    if (rxRunTextView != null) {
                        return new m33((LinearLayout) view, imageView, imageView2, relativeLayout, rxRunTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static m33 inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // defpackage.wd3
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static m33 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.title_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
