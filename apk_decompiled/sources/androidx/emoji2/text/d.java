package androidx.emoji2.text;

import android.text.TextPaint;
import defpackage.yy1;

/* JADX INFO: loaded from: classes.dex */
class d implements e.InterfaceC0019e {
    private static final ThreadLocal b = new ThreadLocal();
    private final TextPaint a;

    d() {
        TextPaint textPaint = new TextPaint();
        this.a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal threadLocal = b;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return (StringBuilder) threadLocal.get();
    }

    @Override // androidx.emoji2.text.e.InterfaceC0019e
    public boolean a(CharSequence charSequence, int i, int i2, int i3) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i < i2) {
            sbB.append(charSequence.charAt(i));
            i++;
        }
        return yy1.a(this.a, sbB.toString());
    }
}
