package defpackage;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class sb0 {
    private View a;
    private SparseArray b;

    public sb0(Context context, int i) {
        this();
        this.a = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    public View a() {
        return this.a;
    }

    public View b(int i) {
        WeakReference weakReference = (WeakReference) this.b.get(i);
        View viewFindViewById = weakReference != null ? (View) weakReference.get() : null;
        if (viewFindViewById == null && (viewFindViewById = this.a.findViewById(i)) != null) {
            this.b.put(i, new WeakReference(viewFindViewById));
        }
        return viewFindViewById;
    }

    public void c(View view) {
        this.a = view;
    }

    public void d(int i, int i2) {
        ImageView imageView = (ImageView) b(i);
        if (imageView != null) {
            imageView.setImageResource(i2);
        }
    }

    public void e(int i, View.OnClickListener onClickListener) {
        View viewB = b(i);
        if (viewB != null) {
            viewB.setOnClickListener(onClickListener);
        }
    }

    public void f(int i, CharSequence charSequence) {
        TextView textView = (TextView) b(i);
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public sb0() {
        this.b = new SparseArray();
    }
}
