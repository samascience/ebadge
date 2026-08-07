package defpackage;

import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class pm1 extends vz2 {
    private pm1(Map map) {
        super(map);
    }

    public static pm1 g() {
        return new pm1(new ArrayMap());
    }

    public static pm1 h(vz2 vz2Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (String str : vz2Var.e()) {
            arrayMap.put(str, vz2Var.d(str));
        }
        return new pm1(arrayMap);
    }

    public void f(vz2 vz2Var) {
        Map map;
        Map map2 = this.a;
        if (map2 == null || (map = vz2Var.a) == null) {
            return;
        }
        map2.putAll(map);
    }

    public void i(String str, Object obj) {
        this.a.put(str, obj);
    }
}
