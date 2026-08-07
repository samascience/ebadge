package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class s1 extends ClickableSpan {
    private final int a;
    private final m2 b;
    private final int c;

    public s1(int i, m2 m2Var, int i2) {
        this.a = i;
        this.b = m2Var;
        this.c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
        this.b.Z(this.c, bundle);
    }
}
