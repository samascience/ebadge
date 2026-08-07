package defpackage;

import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class xw2 {
    private final List a = new ArrayList();

    private static void b(List list, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    iArr[i2] = i3;
                    b(list, i, iArr, i2 + 1);
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    private List c(int i) {
        ArrayList arrayList = new ArrayList();
        b(arrayList, i, new int[i], 0);
        return arrayList;
    }

    public boolean a(SurfaceConfig surfaceConfig) {
        return this.a.add(surfaceConfig);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    public List d(List list) {
        int i;
        boolean zG;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.a.size()) {
            return null;
        }
        List listC = c(this.a.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        Iterator it = listC.iterator();
        do {
            i = 0;
            if (it.hasNext()) {
                int[] iArr = (int[]) it.next();
                zG = true;
                while (i < this.a.size()) {
                    if (iArr[i] < list.size()) {
                        zG &= ((SurfaceConfig) this.a.get(i)).g((SurfaceConfig) list.get(iArr[i]));
                        if (!zG) {
                            break;
                        }
                        surfaceConfigArr[iArr[i]] = (SurfaceConfig) this.a.get(i);
                    }
                    i++;
                }
            }
            if (i != 0) {
                return Arrays.asList(surfaceConfigArr);
            }
            return null;
        } while (!zG);
        i = 1;
        if (i != 0) {
            return Arrays.asList(surfaceConfigArr);
        }
        return null;
    }
}
