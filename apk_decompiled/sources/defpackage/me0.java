package defpackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class me0 {
    public static final Map a;
    public static final Map b;
    public static final Map c;
    public static final Map d;
    private static final Map e;

    static {
        HashMap map = new HashMap();
        a = map;
        HashMap map2 = new HashMap();
        b = map2;
        HashMap map3 = new HashMap();
        c = map3;
        HashMap map4 = new HashMap();
        d = map4;
        HashMap map5 = new HashMap();
        e = map5;
        map.put(8, new HashSet(Collections.singletonList(8)));
        map.put(10, new HashSet(Collections.singletonList(10)));
        map.put(0, new HashSet(Arrays.asList(8, 10)));
        map2.put(0, new HashSet(Arrays.asList(0, 1, 2, 3, 4)));
        map2.put(1, new HashSet(Collections.singletonList(0)));
        map2.put(2, new HashSet(Arrays.asList(1, 2, 3, 4)));
        map2.put(3, new HashSet(Collections.singletonList(1)));
        map2.put(4, new HashSet(Collections.singletonList(2)));
        map2.put(5, new HashSet(Collections.singletonList(3)));
        map2.put(6, new HashSet(Collections.singletonList(4)));
        map3.put(8, 8);
        map3.put(10, 10);
        map4.put(0, 1);
        map4.put(1, 3);
        map4.put(2, 4);
        map4.put(3, 5);
        map4.put(4, 6);
        HashMap map6 = new HashMap();
        ie0 ie0Var = ie0.d;
        map6.put(ie0Var, 1);
        ie0 ie0Var2 = ie0.f;
        map6.put(ie0Var2, 2);
        ie0 ie0Var3 = ie0.g;
        map6.put(ie0Var3, 4096);
        ie0 ie0Var4 = ie0.h;
        map6.put(ie0Var4, 8192);
        HashMap map7 = new HashMap();
        map7.put(ie0Var, 1);
        map7.put(ie0Var2, 2);
        map7.put(ie0Var3, 4096);
        map7.put(ie0Var4, 8192);
        HashMap map8 = new HashMap();
        map8.put(ie0Var, 1);
        map8.put(ie0Var2, 4);
        map8.put(ie0Var3, 4096);
        map8.put(ie0Var4, 16384);
        HashMap map9 = new HashMap();
        map9.put(ie0.i, 256);
        map9.put(ie0.j, 512);
        map5.put("video/hevc", map6);
        map5.put("video/av01", map7);
        map5.put("video/x-vnd.on2.vp9", map8);
        map5.put("video/dolby-vision", map9);
    }

    public static int a(String str, ie0 ie0Var) {
        Integer num;
        Map map = (Map) e.get(str);
        if (map == null || (num = (Integer) map.get(ie0Var)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public static Set b(ie0 ie0Var) {
        Set set = (Set) a.get(Integer.valueOf(ie0Var.a()));
        return set == null ? Collections.emptySet() : set;
    }

    public static Set c(ie0 ie0Var) {
        Set set = (Set) b.get(Integer.valueOf(ie0Var.b()));
        return set == null ? Collections.emptySet() : set;
    }

    private static boolean d(int i, ie0 ie0Var) {
        Set set = (Set) a.get(Integer.valueOf(ie0Var.a()));
        return set != null && set.contains(Integer.valueOf(i));
    }

    private static boolean e(int i, ie0 ie0Var) {
        Set set = (Set) b.get(Integer.valueOf(ie0Var.b()));
        return set != null && set.contains(Integer.valueOf(i));
    }

    public static boolean f(eh0.c cVar, ie0 ie0Var) {
        return d(cVar.b(), ie0Var) && e(cVar.g(), ie0Var);
    }

    public static int g(int i) {
        Map map = c;
        b52.a(map.containsKey(Integer.valueOf(i)));
        Integer num = (Integer) map.get(Integer.valueOf(i));
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public static int h(int i) {
        Map map = d;
        b52.a(map.containsKey(Integer.valueOf(i)));
        Integer num = (Integer) map.get(Integer.valueOf(i));
        Objects.requireNonNull(num);
        return num.intValue();
    }
}
