package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public class vi2 extends ui2 {
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;

    public vi2(Context context) {
        super(context);
        d();
    }

    private void d() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_sure_false, (ViewGroup) null);
        this.c = (ImageView) viewInflate.findViewById(R.id.iv_logo);
        this.e = (TextView) viewInflate.findViewById(R.id.tv_sure);
        this.f = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_content);
        this.d = textView;
        textView.setTextIsSelectable(true);
        this.g = (TextView) viewInflate.findViewById(R.id.tv_title);
        setContentView(viewInflate);
    }

    public TextView b() {
        return this.f;
    }

    public TextView c() {
        return this.e;
    }

    public void e(String str) {
        this.f.setText(str);
    }

    public void f(String str) {
        this.d.setText(str);
    }

    public void g(String str) {
        this.e.setText(str);
    }

    public void h(String str) {
        this.g.setText(str);
    }
}
