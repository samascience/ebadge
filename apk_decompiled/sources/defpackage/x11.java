package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.view.RxRunTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class x11 implements wd3 {
    private final Toolbar a;
    public final AppCompatButton b;
    public final ImageView c;
    public final ImageButton d;
    public final ImageView e;
    public final ImageView f;
    public final Toolbar g;
    public final RelativeLayout h;
    public final RxRunTextView i;
    public final TextView j;

    private x11(Toolbar toolbar, AppCompatButton appCompatButton, ImageView imageView, ImageButton imageButton, ImageView imageView2, ImageView imageView3, Toolbar toolbar2, RelativeLayout relativeLayout, RxRunTextView rxRunTextView, TextView textView) {
        this.a = toolbar;
        this.b = appCompatButton;
        this.c = imageView;
        this.d = imageButton;
        this.e = imageView2;
        this.f = imageView3;
        this.g = toolbar2;
        this.h = relativeLayout;
        this.i = rxRunTextView;
        this.j = textView;
    }

    public static x11 bind(View view) {
        int i = R.id.btn_right;
        AppCompatButton appCompatButton = (AppCompatButton) zd3.a(view, R.id.btn_right);
        if (appCompatButton != null) {
            i = R.id.img_back;
            ImageView imageView = (ImageView) zd3.a(view, R.id.img_back);
            if (imageView != null) {
                i = R.id.img_btn_right;
                ImageButton imageButton = (ImageButton) zd3.a(view, R.id.img_btn_right);
                if (imageButton != null) {
                    i = R.id.img_left;
                    ImageView imageView2 = (ImageView) zd3.a(view, R.id.img_left);
                    if (imageView2 != null) {
                        i = R.id.img_right;
                        ImageView imageView3 = (ImageView) zd3.a(view, R.id.img_right);
                        if (imageView3 != null) {
                            Toolbar toolbar = (Toolbar) view;
                            i = R.id.toolbar_back;
                            RelativeLayout relativeLayout = (RelativeLayout) zd3.a(view, R.id.toolbar_back);
                            if (relativeLayout != null) {
                                i = R.id.toolbar_title;
                                RxRunTextView rxRunTextView = (RxRunTextView) zd3.a(view, R.id.toolbar_title);
                                if (rxRunTextView != null) {
                                    i = R.id.tv_finish;
                                    TextView textView = (TextView) zd3.a(view, R.id.tv_finish);
                                    if (textView != null) {
                                        return new x11(toolbar, appCompatButton, imageView, imageButton, imageView2, imageView3, toolbar, relativeLayout, rxRunTextView, textView);
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

    public static x11 inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @Override // defpackage.wd3
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Toolbar getRoot() {
        return this.a;
    }

    public static x11 inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.include_title, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }
}
