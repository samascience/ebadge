package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.c;

/* JADX INFO: loaded from: classes.dex */
public class u8 extends e10 implements m8 {
    private c d;
    private final c91.a e;

    public u8(Context context) {
        this(context, 0);
    }

    private static int f(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    private void g() {
        if3.a(getWindow().getDecorView(), this);
        kf3.a(getWindow().getDecorView(), this);
        jf3.a(getWindow().getDecorView(), this);
    }

    @Override // defpackage.e10, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        e().e(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        e().z();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return c91.e(this.e, getWindow().getDecorView(), this, keyEvent);
    }

    public c e() {
        if (this.d == null) {
            this.d = c.i(this, this);
        }
        return this.d;
    }

    @Override // android.app.Dialog
    public View findViewById(int i) {
        return e().j(i);
    }

    boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean i(int i) {
        return e().H(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        e().u();
    }

    @Override // defpackage.e10, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        e().t();
        super.onCreate(bundle);
        e().y(bundle);
    }

    @Override // defpackage.e10, android.app.Dialog
    protected void onStop() {
        super.onStop();
        e().E();
    }

    @Override // defpackage.m8
    public void onSupportActionModeFinished(u2 u2Var) {
    }

    @Override // defpackage.m8
    public void onSupportActionModeStarted(u2 u2Var) {
    }

    @Override // defpackage.m8
    public u2 onWindowStartingSupportActionMode(u2.a aVar) {
        return null;
    }

    @Override // defpackage.e10, android.app.Dialog
    public void setContentView(int i) {
        g();
        e().J(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e().P(charSequence);
    }

    public u8(Context context, int i) {
        super(context, f(context, i));
        this.e = new c91.a() { // from class: t8
            @Override // c91.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return this.a.h(keyEvent);
            }
        };
        c cVarE = e();
        cVarE.O(f(context, i));
        cVarE.y(null);
    }

    @Override // defpackage.e10, android.app.Dialog
    public void setContentView(View view) {
        g();
        e().K(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        e().P(getContext().getString(i));
    }

    @Override // defpackage.e10, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        e().L(view, layoutParams);
    }
}
