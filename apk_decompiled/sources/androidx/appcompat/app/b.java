package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import defpackage.u8;

/* JADX INFO: loaded from: classes.dex */
public class b extends u8 implements DialogInterface {
    final AlertController f;

    public static class a {
        private final AlertController.b a;
        private final int b;

        public a(Context context) {
            this(context, b.l(context, 0));
        }

        public b a() {
            b bVar = new b(this.a.a, this.b);
            this.a.a(bVar.f);
            bVar.setCancelable(this.a.r);
            if (this.a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.a.s);
            bVar.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context b() {
            return this.a.a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.w = listAdapter;
            bVar.x = onClickListener;
            return this;
        }

        public a d(boolean z) {
            this.a.r = z;
            return this;
        }

        public a e(View view) {
            this.a.g = view;
            return this;
        }

        public a f(int i) {
            this.a.c = i;
            return this;
        }

        public a g(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public a h(int i) {
            AlertController.b bVar = this.a;
            bVar.h = bVar.a.getText(i);
            return this;
        }

        public a i(CharSequence charSequence) {
            this.a.h = charSequence;
            return this;
        }

        public a j(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.a;
            bVar.v = charSequenceArr;
            bVar.J = onMultiChoiceClickListener;
            bVar.F = zArr;
            bVar.G = true;
            return this;
        }

        public a k(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.l = bVar.a.getText(i);
            this.a.n = onClickListener;
            return this;
        }

        public a l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.l = charSequence;
            bVar.n = onClickListener;
            return this;
        }

        public a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.o = charSequence;
            bVar.f125q = onClickListener;
            return this;
        }

        public a n(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a o(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.i = bVar.a.getText(i);
            this.a.k = onClickListener;
            return this;
        }

        public a p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.i = charSequence;
            bVar.k = onClickListener;
            return this;
        }

        public a q(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.w = listAdapter;
            bVar.x = onClickListener;
            bVar.I = i;
            bVar.H = true;
            return this;
        }

        public a r(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.v = charSequenceArr;
            bVar.x = onClickListener;
            bVar.I = i;
            bVar.H = true;
            return this;
        }

        public a s(int i) {
            AlertController.b bVar = this.a;
            bVar.f = bVar.a.getText(i);
            return this;
        }

        public a t(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public a u(View view) {
            AlertController.b bVar = this.a;
            bVar.z = view;
            bVar.y = 0;
            bVar.E = false;
            return this;
        }

        public b v() {
            b bVarA = a();
            bVarA.show();
            return bVarA;
        }

        public a(Context context, int i) {
            this.a = new AlertController.b(new ContextThemeWrapper(context, b.l(context, i)));
            this.b = i;
        }
    }

    protected b(Context context, int i) {
        super(context, l(context, i));
        this.f = new AlertController(getContext(), this, getWindow());
    }

    static int l(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button j(int i) {
        return this.f.c(i);
    }

    public ListView k() {
        return this.f.e();
    }

    @Override // defpackage.u8, defpackage.e10, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f.g(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f.h(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // defpackage.u8, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f.q(charSequence);
    }
}
