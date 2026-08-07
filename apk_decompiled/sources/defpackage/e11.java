package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class e11 extends ef3 implements l53.a {
    private Animatable h;

    public e11(ImageView imageView) {
        super(imageView);
    }

    private void m(Object obj) {
        if (!(obj instanceof Animatable)) {
            this.h = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.h = animatable;
        animatable.start();
    }

    private void p(Object obj) {
        o(obj);
        m(obj);
    }

    @Override // defpackage.j03
    public void b(Object obj, l53 l53Var) {
        if (l53Var == null || !l53Var.a(obj, this)) {
            p(obj);
        } else {
            m(obj);
        }
    }

    @Override // defpackage.zg, defpackage.j03
    public void e(Drawable drawable) {
        super.e(drawable);
        p(null);
        n(drawable);
    }

    @Override // defpackage.ef3, defpackage.zg, defpackage.j03
    public void f(Drawable drawable) {
        super.f(drawable);
        p(null);
        n(drawable);
    }

    @Override // defpackage.ef3, defpackage.zg, defpackage.j03
    public void h(Drawable drawable) {
        super.h(drawable);
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
        p(null);
        n(drawable);
    }

    public void n(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    protected abstract void o(Object obj);

    @Override // defpackage.bb1
    public void onStart() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // defpackage.bb1
    public void onStop() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
