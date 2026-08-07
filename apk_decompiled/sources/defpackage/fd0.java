package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class fd0 extends e11 {
    public fd0(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.e11
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }
}
