package defpackage;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
abstract class h11 {
    static void a(ImageWriter imageWriter) {
        imageWriter.close();
    }

    static Image b(ImageWriter imageWriter) {
        return imageWriter.dequeueInputImage();
    }

    static ImageWriter c(Surface surface, int i) {
        return ImageWriter.newInstance(surface, i);
    }

    static void d(ImageWriter imageWriter, Image image) {
        imageWriter.queueInputImage(image);
    }
}
