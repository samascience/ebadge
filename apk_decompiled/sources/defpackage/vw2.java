package defpackage;

import android.util.Size;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class vw2 {
    private static final Size b = new Size(320, 240);
    private static final Comparator c = new m00();
    private final af2 a = (af2) xa0.a(af2.class);

    public Size[] a(Size[] sizeArr) {
        if (this.a == null || !af2.f()) {
            return sizeArr;
        }
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            if (c.compare(size, b) >= 0) {
                arrayList.add(size);
            }
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
