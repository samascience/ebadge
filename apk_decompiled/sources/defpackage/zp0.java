package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.legend.mywatch.commonlib.R$id;
import com.legend.mywatch.commonlib.R$layout;

/* JADX INFO: loaded from: classes3.dex */
public final class zp0 implements wd3 {
    private final LinearLayout a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;

    private zp0(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
    }

    public static zp0 bind(View view) {
        int i = R$id.content;
        TextView textView = (TextView) zd3.a(view, i);
        if (textView != null) {
            i = R$id.image;
            ImageView imageView = (ImageView) zd3.a(view, i);
            if (imageView != null) {
                i = R$id.title;
                TextView textView2 = (TextView) zd3.a(view, i);
                if (textView2 != null) {
                    i = R$id.tv_cancel;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) zd3.a(view, i);
                    if (appCompatTextView != null) {
                        i = R$id.tv_confirm;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) zd3.a(view, i);
                        if (appCompatTextView2 != null) {
                            return new zp0((LinearLayout) view, textView, imageView, textView2, appCompatTextView, appCompatTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static zp0 inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // defpackage.wd3
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static zp0 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_dialog_common_prompt, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
