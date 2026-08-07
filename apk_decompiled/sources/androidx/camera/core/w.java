package androidx.camera.core;

import android.media.ImageReader;
import defpackage.x01;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    public static x01 a(int i, int i2, int i3, int i4) {
        return new d(ImageReader.newInstance(i, i2, i3, i4));
    }
}
