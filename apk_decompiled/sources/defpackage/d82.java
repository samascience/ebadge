package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.legend.smartwatch.electronicbadge.android.R;

/* JADX INFO: loaded from: classes4.dex */
public final class d82 extends Dialog {
    public static final a f = new a(null);
    private ProgressBar a;
    private TextView b;
    private TextView c;
    private final Handler d;
    private Runnable e;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final d82 a(Context context, String str) {
            p31.f(context, "context");
            p31.f(str, "message");
            d82 d82Var = new d82(context, R.style.MyDialogStyle);
            d82Var.j(str);
            return d82Var;
        }

        private a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d82(Context context, int i) {
        super(context, i);
        p31.f(context, "context");
        this.d = new Handler(Looper.getMainLooper());
    }

    private final void e() {
        Runnable runnable = this.e;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
        }
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(d82 d82Var, int i) {
        ProgressBar progressBar = d82Var.a;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = d82Var.b;
        if (textView != null) {
            textView.setText(i + "%");
        }
        ProgressBar progressBar2 = d82Var.a;
        if (progressBar2 != null) {
            progressBar2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(d82 d82Var, int i, String str) {
        ProgressBar progressBar = d82Var.a;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = d82Var.b;
        if (textView != null) {
            textView.setText(i + "%");
        }
        ProgressBar progressBar2 = d82Var.a;
        if (progressBar2 != null) {
            progressBar2.invalidate();
        }
        TextView textView2 = d82Var.c;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_progress, (ViewGroup) null);
        this.a = (ProgressBar) viewInflate.findViewById(R.id.progressBar);
        this.b = (TextView) viewInflate.findViewById(R.id.progressText);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tipTextView);
        this.c = textView;
        if (textView != null) {
            textView.setText(str);
        }
        setContentView(viewInflate);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d82 d82Var) {
        d82Var.e = null;
        try {
            if (d82Var.isShowing()) {
                d82Var.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        e();
        super.dismiss();
    }

    public final void f(int i) {
        final int iG = ga2.g(i, 0, 100);
        Runnable runnable = new Runnable() { // from class: b82
            @Override // java.lang.Runnable
            public final void run() {
                d82.g(this.a, iG);
            }
        };
        if (p31.a(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            this.d.post(runnable);
        }
    }

    public final void h(int i, String str) {
        p31.f(str, "message");
        a82 a82Var = new a82(this, ga2.g(i, 0, 100), str);
        if (p31.a(Looper.myLooper(), Looper.getMainLooper())) {
            a82Var.run();
        } else {
            this.d.post(a82Var);
        }
    }

    public final void k() {
        e();
        if (isShowing()) {
            return;
        }
        show();
    }

    public final void l(int i) {
        e();
        if (!isShowing()) {
            show();
        }
        if (i > 0) {
            Runnable runnable = new Runnable() { // from class: c82
                @Override // java.lang.Runnable
                public final void run() {
                    d82.m(this.a);
                }
            };
            this.e = runnable;
            this.d.postDelayed(runnable, i);
        }
    }
}
