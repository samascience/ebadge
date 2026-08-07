package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public final class v31 implements wd3 {
    private final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;

    private v31(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
        this.d = linearLayout2;
    }

    public static v31 bind(View view) {
        int i = R.id.language_name;
        TextView textView = (TextView) zd3.a(view, R.id.language_name);
        if (textView != null) {
            i = R.id.language_translation;
            TextView textView2 = (TextView) zd3.a(view, R.id.language_translation);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new v31(linearLayout, textView, textView2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static v31 inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // defpackage.wd3
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static v31 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_language, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
