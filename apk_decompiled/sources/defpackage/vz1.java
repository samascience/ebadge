package defpackage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class vz1 {
    private boolean a = false;
    private final Set b = new y9();
    private final Map c = new HashMap();
    private final Comparator d = new a();

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(az1 az1Var, az1 az1Var2) {
            float fFloatValue = ((Float) az1Var.b).floatValue();
            float fFloatValue2 = ((Float) az1Var2.b).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    public void a(String str, float f) {
        if (this.a) {
            jh1 jh1Var = (jh1) this.c.get(str);
            if (jh1Var == null) {
                jh1Var = new jh1();
                this.c.put(str, jh1Var);
            }
            jh1Var.a(f);
            if (str.equals("__container")) {
                Iterator it = this.b.iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    throw null;
                }
            }
        }
    }

    void b(boolean z) {
        this.a = z;
    }
}
