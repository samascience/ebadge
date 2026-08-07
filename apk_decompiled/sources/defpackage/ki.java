package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class ki extends e11 {
    public ki(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.e11
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(Bitmap bitmap) {
        ((ImageView) this.a).setImageBitmap(bitmap);
    }
}
