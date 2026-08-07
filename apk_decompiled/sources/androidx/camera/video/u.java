package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import com.jieli.jl_rcsp.constant.Command;
import defpackage.ir2;
import defpackage.ra;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class u {
    private static final Map b;
    private static final Map c;
    private final Map a = new HashMap();

    static abstract class a {
        a() {
        }

        static a c(s sVar, int i) {
            return new h(sVar, i);
        }

        abstract int a();

        abstract s b();
    }

    static {
        HashMap map = new HashMap();
        b = map;
        map.put(s.d, Range.create(2160, 4319));
        map.put(s.c, Range.create(1080, 1439));
        map.put(s.b, Range.create(720, 1079));
        map.put(s.a, Range.create(Integer.valueOf(Command.CMD_PHONE_NUMBER_PLAY_MODE), 719));
        HashMap map2 = new HashMap();
        c = map2;
        map2.put(0, ra.a);
        map2.put(1, ra.c);
    }

    u(List list, Map map) {
        for (s sVar : b.keySet()) {
            this.a.put(a.c(sVar, -1), new ArrayList());
            Iterator it = c.keySet().iterator();
            while (it.hasNext()) {
                this.a.put(a.c(sVar, ((Integer) it.next()).intValue()), new ArrayList());
            }
        }
        b(map);
        c(list);
        i(map);
    }

    private void b(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            List listF = f((s) entry.getKey(), -1);
            Objects.requireNonNull(listF);
            listF.add((Size) entry.getValue());
        }
    }

    private void c(List list) {
        Integer numD;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            s sVarE = e(size);
            if (sVarE != null && (numD = d(size)) != null) {
                List listF = f(sVarE, numD.intValue());
                Objects.requireNonNull(listF);
                listF.add(size);
            }
        }
    }

    private static Integer d(Size size) {
        for (Map.Entry entry : c.entrySet()) {
            if (ra.b(size, (Rational) entry.getValue(), ir2.b)) {
                return (Integer) entry.getKey();
            }
        }
        return null;
    }

    private static s e(Size size) {
        for (Map.Entry entry : b.entrySet()) {
            if (((Range) entry.getValue()).contains(Integer.valueOf(size.getHeight()))) {
                return (s) entry.getKey();
            }
        }
        return null;
    }

    private List f(s sVar, int i) {
        return (List) this.a.get(a.c(sVar, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int h(int i, Size size, Size size2) {
        return Math.abs(ir2.c(size) - i) - Math.abs(ir2.c(size2) - i);
    }

    private void i(Map map) {
        for (Map.Entry entry : this.a.entrySet()) {
            Size size = (Size) map.get(((a) entry.getKey()).b());
            if (size != null) {
                final int iC = ir2.c(size);
                Collections.sort((List) entry.getValue(), new Comparator() { // from class: androidx.camera.video.t
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return u.h(iC, (Size) obj, (Size) obj2);
                    }
                });
            }
        }
    }

    List g(s sVar, int i) {
        List listF = f(sVar, i);
        return listF != null ? new ArrayList(listF) : new ArrayList(0);
    }
}
