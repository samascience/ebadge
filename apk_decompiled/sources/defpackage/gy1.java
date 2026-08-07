package defpackage;

import android.util.Size;
import androidx.camera.core.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gy1 {
    private final String a;
    private final tj0 b = (tj0) xa0.a(tj0.class);
    private final ui0 c;

    public gy1(String str) {
        this.a = str;
        this.c = new ui0(str);
    }

    private void a(List list, int i) {
        tj0 tj0Var = this.b;
        if (tj0Var == null) {
            return;
        }
        Size[] sizeArrF = tj0Var.f(i);
        if (sizeArrF.length > 0) {
            list.addAll(Arrays.asList(sizeArrF));
        }
    }

    private void c(List list, int i) {
        List listA = this.c.a(i);
        if (listA.isEmpty()) {
            return;
        }
        list.removeAll(listA);
    }

    public Size[] b(Size[] sizeArr, int i) {
        ArrayList arrayList = new ArrayList(Arrays.asList(sizeArr));
        a(arrayList, i);
        c(arrayList, i);
        if (arrayList.isEmpty()) {
            x.k("OutputSizesCorrector", "Sizes array becomes empty after excluding problematic output sizes.");
        }
        return (Size[]) arrayList.toArray(new Size[0]);
    }
}
