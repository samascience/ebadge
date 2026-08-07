package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class fr2 implements v92 {
    private static Set g() {
        return h() ? new HashSet(Collections.singletonList(new Size(720, 1280))) : Collections.emptySet();
    }

    private static boolean h() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    static boolean j() {
        return h();
    }

    public Rect f(Rect rect, int i, pc3 pc3Var) {
        Size sizeP = y43.p(y43.m(rect), i);
        if (!i(sizeP)) {
            return rect;
        }
        int iG = pc3Var != null ? pc3Var.g() / 2 : 8;
        Rect rect2 = new Rect(rect);
        if (rect.width() == sizeP.getHeight()) {
            rect2.left += iG;
            rect2.right -= iG;
        } else {
            rect2.top += iG;
            rect2.bottom -= iG;
        }
        return rect2;
    }

    public boolean i(Size size) {
        return g().contains(size);
    }
}
