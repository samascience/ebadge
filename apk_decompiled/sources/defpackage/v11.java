package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.view.RxRunTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class v11 implements wd3 {
    private final LinearLayout a;
    public final ImageButton b;
    public final AppCompatButton c;
    public final ImageView d;
    public final LinearLayout e;
    public final LinearLayout f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;
    public final RxRunTextView j;
    public final TextView k;

    private v11(LinearLayout linearLayout, ImageButton imageButton, AppCompatButton appCompatButton, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, RxRunTextView rxRunTextView, TextView textView3) {
        this.a = linearLayout;
        this.b = imageButton;
        this.c = appCompatButton;
        this.d = imageView;
        this.e = linearLayout2;
        this.f = linearLayout3;
        this.g = linearLayout4;
        this.h = textView;
        this.i = textView2;
        this.j = rxRunTextView;
        this.k = textView3;
    }

    public static v11 bind(View view) {
        int i = R.id.add_device;
        ImageButton imageButton = (ImageButton) zd3.a(view, R.id.add_device);
        if (imageButton != null) {
            i = R.id.btn_unbind_device;
            AppCompatButton appCompatButton = (AppCompatButton) zd3.a(view, R.id.btn_unbind_device);
            if (appCompatButton != null) {
                i = R.id.img_device;
                ImageView imageView = (ImageView) zd3.a(view, R.id.img_device);
                if (imageView != null) {
                    i = R.id.ll_connected_container;
                    LinearLayout linearLayout = (LinearLayout) zd3.a(view, R.id.ll_connected_container);
                    if (linearLayout != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view;
                        i = R.id.ll_unConnected_container;
                        LinearLayout linearLayout3 = (LinearLayout) zd3.a(view, R.id.ll_unConnected_container);
                        if (linearLayout3 != null) {
                            i = R.id.tv_device_connection_status;
                            TextView textView = (TextView) zd3.a(view, R.id.tv_device_connection_status);
                            if (textView != null) {
                                i = R.id.tv_device_mac_address;
                                TextView textView2 = (TextView) zd3.a(view, R.id.tv_device_mac_address);
                                if (textView2 != null) {
                                    i = R.id.tv_device_name;
                                    RxRunTextView rxRunTextView = (RxRunTextView) zd3.a(view, R.id.tv_device_name);
                                    if (rxRunTextView != null) {
                                        i = R.id.tv_device_version;
                                        TextView textView3 = (TextView) zd3.a(view, R.id.tv_device_version);
                                        if (textView3 != null) {
                                            return new v11(linearLayout2, imageButton, appCompatButton, imageView, linearLayout, linearLayout2, linearLayout3, textView, textView2, rxRunTextView, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static v11 inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // defpackage.wd3
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }

    public static v11 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.include_home_device_top_container2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
