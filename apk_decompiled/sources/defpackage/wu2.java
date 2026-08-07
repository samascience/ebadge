package defpackage;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.camera.core.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class wu2 {
    private final a a;
    private final gy1 b;
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();

    interface a {
        StreamConfigurationMap a();

        Size[] b(int i);

        Size[] c(int i);

        int[] d();
    }

    private wu2(StreamConfigurationMap streamConfigurationMap, gy1 gy1Var) {
        this.a = new xu2(streamConfigurationMap);
        this.b = gy1Var;
    }

    static wu2 e(StreamConfigurationMap streamConfigurationMap, gy1 gy1Var) {
        return new wu2(streamConfigurationMap, gy1Var);
    }

    public Size[] a(int i) {
        if (this.d.containsKey(Integer.valueOf(i))) {
            if (((Size[]) this.d.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) this.d.get(Integer.valueOf(i))).clone();
        }
        Size[] sizeArrB = this.a.b(i);
        if (sizeArrB != null && sizeArrB.length > 0) {
            sizeArrB = this.b.b(sizeArrB, i);
        }
        this.d.put(Integer.valueOf(i), sizeArrB);
        if (sizeArrB != null) {
            return (Size[]) sizeArrB.clone();
        }
        return null;
    }

    public int[] b() {
        int[] iArrD = this.a.d();
        if (iArrD == null) {
            return null;
        }
        return (int[]) iArrD.clone();
    }

    public Size[] c(int i) {
        if (this.c.containsKey(Integer.valueOf(i))) {
            if (((Size[]) this.c.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) this.c.get(Integer.valueOf(i))).clone();
        }
        Size[] sizeArrC = this.a.c(i);
        if (sizeArrC != null && sizeArrC.length != 0) {
            Size[] sizeArrB = this.b.b(sizeArrC, i);
            this.c.put(Integer.valueOf(i), sizeArrB);
            return (Size[]) sizeArrB.clone();
        }
        x.k("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
        return sizeArrC;
    }

    public StreamConfigurationMap d() {
        return this.a.a();
    }
}
