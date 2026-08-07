package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.phy.ota_demo.R$style;

/* JADX INFO: loaded from: classes.dex */
public class i5 extends Dialog {
    private h5 a;

    public static class a {
        private final h5.a a;

        public a(Context context) {
            this(context, R$style.dialog);
        }

        public a a() {
            this.a.s = R$style.dialog_scale_anim;
            return this;
        }

        public i5 b() {
            h5.a aVar = this.a;
            i5 i5Var = new i5(aVar.a, aVar.b);
            this.a.a(i5Var.a);
            i5Var.setCancelable(this.a.c);
            if (this.a.c) {
                i5Var.setCanceledOnTouchOutside(true);
            }
            i5Var.setOnCancelListener(this.a.d);
            i5Var.setOnDismissListener(this.a.e);
            DialogInterface.OnKeyListener onKeyListener = this.a.f;
            if (onKeyListener != null) {
                i5Var.setOnKeyListener(onKeyListener);
            }
            return i5Var;
        }

        public a c(boolean z) {
            this.a.c = z;
            return this;
        }

        public a d(View view) {
            h5.a aVar = this.a;
            aVar.n = view;
            aVar.m = 0;
            return this;
        }

        public a e(int i, View.OnClickListener onClickListener) {
            this.a.i.put(i, onClickListener);
            return this;
        }

        public a f(int i, CharSequence charSequence) {
            this.a.h.put(i, charSequence);
            return this;
        }

        public a g(int i, int i2) {
            h5.a aVar = this.a;
            aVar.o = i;
            aVar.p = i2;
            return this;
        }

        public a(Context context, int i) {
            this.a = new h5.a(context, i);
        }
    }

    public i5(Context context, int i) {
        super(context, i);
        this.a = new h5(this, getWindow());
    }
}
