package defpackage;

import android.util.ArrayMap;
import android.util.Pair;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class vz2 {
    private static final vz2 b = new vz2(new ArrayMap());
    protected final Map a;

    protected vz2(Map map) {
        this.a = map;
    }

    public static vz2 a(Pair pair) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put((String) pair.first, pair.second);
        return new vz2(arrayMap);
    }

    public static vz2 b() {
        return b;
    }

    public static vz2 c(vz2 vz2Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : vz2Var.e()) {
            arrayMap.put(str, vz2Var.d(str));
        }
        return new vz2(arrayMap);
    }

    public Object d(String str) {
        return this.a.get(str);
    }

    public Set e() {
        return this.a.keySet();
    }

    public final String toString() {
        return "android.hardware.camera2.CaptureRequest.setTag.CX";
    }
}
