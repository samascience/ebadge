package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class a23 {
    private float c;
    private float d;
    private t13 g;
    private final TextPaint a = new TextPaint(1);
    private final v13 b = new a();
    private boolean e = true;
    private WeakReference f = new WeakReference(null);

    class a extends v13 {
        a() {
        }

        @Override // defpackage.v13
        public void a(int i) {
            a23.this.e = true;
            b bVar = (b) a23.this.f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // defpackage.v13
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            a23.this.e = true;
            b bVar = (b) a23.this.f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public a23(b bVar) {
        j(bVar);
    }

    private float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.a.getFontMetrics().ascent);
    }

    private float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    private void i(String str) {
        this.c = d(str);
        this.d = c(str);
        this.e = false;
    }

    public t13 e() {
        return this.g;
    }

    public float f(String str) {
        if (!this.e) {
            return this.d;
        }
        i(str);
        return this.d;
    }

    public TextPaint g() {
        return this.a;
    }

    public float h(String str) {
        if (!this.e) {
            return this.c;
        }
        i(str);
        return this.c;
    }

    public void j(b bVar) {
        this.f = new WeakReference(bVar);
    }

    public void k(t13 t13Var, Context context) {
        if (this.g != t13Var) {
            this.g = t13Var;
            if (t13Var != null) {
                t13Var.o(context, this.a, this.b);
                b bVar = (b) this.f.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                t13Var.n(context, this.a, this.b);
                this.e = true;
            }
            b bVar2 = (b) this.f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void l(boolean z) {
        this.e = z;
    }

    public void m(boolean z) {
        this.e = z;
    }

    public void n(Context context) {
        this.g.n(context, this.a, this.b);
    }
}
