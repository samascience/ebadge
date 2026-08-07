package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.jaredrummler.materialspinner.R$id;
import com.jaredrummler.materialspinner.R$layout;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class xg1 extends BaseAdapter {
    private final Context a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;

    private static class b {
        private TextView a;

        private b(TextView textView) {
            this.a = textView;
        }
    }

    public xg1(Context context) {
        this.a = context;
    }

    public abstract Object a(int i);

    public String b(int i) {
        return getItem(i).toString();
    }

    public abstract List c();

    public int d() {
        return this.b;
    }

    public boolean e() {
        return this.i;
    }

    public void f(int i) {
        this.b = i;
    }

    public xg1 g(int i) {
        this.d = i;
        return this;
    }

    @Override // android.widget.Adapter
    public abstract int getCount();

    @Override // android.widget.Adapter
    public abstract Object getItem(int i);

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R$layout.ms__list_item, viewGroup, false);
            textView = (TextView) view.findViewById(R$id.tv_tinted_spinner);
            textView.setTextColor(this.c);
            textView.setPadding(this.f, this.e, this.h, this.g);
            int i2 = this.d;
            if (i2 != 0) {
                textView.setBackgroundResource(i2);
            }
            if (this.a.getResources().getConfiguration().getLayoutDirection() == 1) {
                textView.setTextDirection(4);
            }
            view.setTag(new b(textView));
        } else {
            textView = ((b) view.getTag()).a;
        }
        textView.setText(b(i));
        return view;
    }

    public void h(boolean z) {
        this.i = z;
    }

    public xg1 i(int i, int i2, int i3, int i4) {
        this.f = i;
        this.e = i2;
        this.h = i3;
        this.g = i4;
        return this;
    }

    public xg1 j(int i) {
        this.c = i;
        return this;
    }
}
