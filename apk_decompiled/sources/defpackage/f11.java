package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class f11 {
    public ef3 a(ImageView imageView, Class cls) {
        if (Bitmap.class.equals(cls)) {
            return new ki(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new fd0(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
